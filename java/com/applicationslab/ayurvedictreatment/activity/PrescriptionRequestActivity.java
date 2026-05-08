package com.applicationslab.ayurvedictreatment.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.applicationslab.ayurvedictreatment.R;
import com.applicationslab.ayurvedictreatment.utility.PreferenceUtil;
import com.applicationslab.ayurvedictreatment.utility.Urls;
import com.applicationslab.ayurvedictreatment.utility.UtilityMethod;
import com.applicationslab.ayurvedictreatment.widget.CustomToast;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class PrescriptionRequestActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtAge;
    TextView txtProbDetails;
    EditText edtAge;
    EditText edtProbDetails;
    Button btnSubmit;

    String disease = "General Consultation"; // Default value to prevent crashes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription_details);
        initData();
        initView();
        setUiClickHandler();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initData() {
        // Check if data was passed from previous activity
        if(getIntent() != null && getIntent().getExtras() != null) {
            String tempDisease = getIntent().getExtras().getString("disease");
            // Only update if the value is not empty
            if(tempDisease != null && !tempDisease.isEmpty()){
                disease = tempDisease;
            }
        }
    }

    private void initView() {
        Toolbar toolBar=(Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle("Prescription for " + disease);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtAge = (TextView) findViewById(R.id.txtAge);
        txtProbDetails = (TextView) findViewById(R.id.txtProbDetails);
        edtAge = (EditText) findViewById(R.id.edtAge);
        edtProbDetails = (EditText) findViewById(R.id.edtProbDetails);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        try {
            Typeface tfRegular = Typeface.createFromAsset(getAssets(), "fonts/OpenSansRegular.ttf");
            txtAge.setTypeface(tfRegular);
            txtProbDetails.setTypeface(tfRegular);
            edtAge.setTypeface(tfRegular);
            edtProbDetails.setTypeface(tfRegular);
            btnSubmit.setTypeface(tfRegular, Typeface.BOLD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setUiClickHandler() {
        btnSubmit.setOnClickListener(this);
    }

    private boolean isDataValid() {
        if(edtAge.getText().toString() == null || "".equals(edtAge.getText().toString().trim())) {
            new CustomToast(this, "Age is required", "", false);
            return false;
        }
        if(edtProbDetails.getText().toString() == null || "".equals(edtProbDetails.getText().toString().trim())) {
            new CustomToast(this, "Problem details is required", "", false);
            return false;
        }
        UtilityMethod utilityMethod = new UtilityMethod();
        if(!utilityMethod.isDecimalNumberValid(edtAge.getText().toString().trim())) {
            new CustomToast(this, "Invalid age found", "", false);
            return false;
        }
        return true;
    }

    private void requestPrescriptionApi() {
        final ProgressDialog mDialog = new ProgressDialog(this);
        mDialog.setMessage("Sending request...");
        mDialog.setCancelable(false);
        mDialog.show();

        StringRequest mRequest = new StringRequest(Request.Method.POST, Urls.URL_REQUEST_PRESCRIPTION,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            mDialog.dismiss();
                            JSONObject json = new JSONObject(response);
                            int success = json.getInt("success");

                            // Get the actual message from server
                            String message = json.optString("message", "Request sent");

                            if(success == 1) {
                                new CustomToast(PrescriptionRequestActivity.this, "Request sent successfully", "", false);
                                finish();
                            } else {
                                // Show the REAL error from PHP (e.g., "Missing required fields")
                                new CustomToast(PrescriptionRequestActivity.this, message, "", false);
                            }
                        } catch (Exception e) {
                            mDialog.dismiss();
                            new CustomToast(PrescriptionRequestActivity.this, "Error: " + e.getMessage(), "", false);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mDialog.dismiss();
                new CustomToast(PrescriptionRequestActivity.this, "Network Error. Check URL.", "", false);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                PreferenceUtil preferenceUtil = new PreferenceUtil(PrescriptionRequestActivity.this);

                params.put("email", preferenceUtil.getEmail());
                // Ensure disease is never null
                params.put("disease", (disease != null) ? disease : "General");
                params.put("age", edtAge.getText().toString().trim());
                params.put("details", edtProbDetails.getText().toString().trim());

                return params;
            }
        };
        Volley.newRequestQueue(this).add(mRequest);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSubmit) {
            if(isDataValid()) {
                requestPrescriptionApi();
            }
        }
    }
}