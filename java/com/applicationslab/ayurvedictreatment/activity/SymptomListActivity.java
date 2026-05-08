package com.applicationslab.ayurvedictreatment.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.applicationslab.ayurvedictreatment.R;

public class SymptomListActivity extends AppCompatActivity implements View.OnClickListener {

    // --- UI Components ---
    TextView txtOptional;

    // Old Disease TextViews
    TextView txtAppendicites, txtAsthma, txtBronchitis, txtDiabetes, txtDysentery,
            txtHeatDisease, txtBloodPressure, txtJaundice, txtMalaria, txtMumps;

    // New Disease TextViews
    TextView txtAcne, txtAllergies, txtAlzheimer, txtAnemia, txtArthritis, txtChickenpox, txtCholera,
            txtCommonCold, txtConjunctivitis, txtCovid, txtDengue, txtDepression, txtDiarrhea,
            txtFlu, txtFoodPoisoning, txtKidneyStones, txtMeasles, txtMigraine, txtPneumonia,
            txtSinusitis, txtUlcer, txtStroke, txtTonsillitis, txtTb, txtTyphoid, txtUti;

    // Old Disease Layouts
    RelativeLayout relativeAppendicites, relativeAsthma, relativeBronchitis, relativeDiabetes,
            relativeDysentery, relativeHeatDisease, relativeBloodPressure, relativeJaundice,
            relativeMalaria, relativeMumps;

    // New Disease Layouts
    RelativeLayout relativeAcne, relativeAllergies, relativeAlzheimer, relativeAnemia, relativeArthritis,
            relativeChickenpox, relativeCholera, relativeCommonCold, relativeConjunctivitis,
            relativeCovid, relativeDengue, relativeDepression, relativeDiarrhea, relativeFlu,
            relativeFoodPoisoning, relativeKidneyStones, relativeMeasles, relativeMigraine,
            relativePneumonia, relativeSinusitis, relativeUlcer, relativeStroke, relativeTonsillitis,
            relativeTb, relativeTyphoid, relativeUti;

    // Data Variables
    String title = "";
    String symptom = "";
    String treatment = "";
    String dose = "";
    String suggestion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_list);
        initView();
        setUIClickHandler();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Symptom Checker");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        // --- Initialize TextViews ---
        txtOptional = findViewById(R.id.txtOptional);

        // Old
        txtAppendicites = findViewById(R.id.txtAppendicites);
        txtAsthma = findViewById(R.id.txtAsthma);
        txtBronchitis = findViewById(R.id.txtBronchitis);
        txtDiabetes = findViewById(R.id.txtDiabetes);
        txtDysentery = findViewById(R.id.txtDysentery);
        txtHeatDisease = findViewById(R.id.txtHeartDisease);
        txtBloodPressure = findViewById(R.id.txtBloodPressure);
        txtJaundice = findViewById(R.id.txtJaundice);
        txtMalaria = findViewById(R.id.txtMalaria);
        txtMumps = findViewById(R.id.txtMumps);

        // New
        txtAcne = findViewById(R.id.txtAcne);
        txtAllergies = findViewById(R.id.txtAllergies);
        txtAlzheimer = findViewById(R.id.txtAlzheimer);
        txtAnemia = findViewById(R.id.txtAnemia);
        txtArthritis = findViewById(R.id.txtArthritis);
        txtChickenpox = findViewById(R.id.txtChickenpox);
        txtCholera = findViewById(R.id.txtCholera);
        txtCommonCold = findViewById(R.id.txtCommonCold);
        txtConjunctivitis = findViewById(R.id.txtConjunctivitis);
        txtCovid = findViewById(R.id.txtCovid);
        txtDengue = findViewById(R.id.txtDengue);
        txtDepression = findViewById(R.id.txtDepression);
        txtDiarrhea = findViewById(R.id.txtDiarrhea);
        txtFlu = findViewById(R.id.txtFlu);
        txtFoodPoisoning = findViewById(R.id.txtFoodPoisoning);
        txtKidneyStones = findViewById(R.id.txtKidneyStones);
        txtMeasles = findViewById(R.id.txtMeasles);
        txtMigraine = findViewById(R.id.txtMigraine);
        txtPneumonia = findViewById(R.id.txtPneumonia);
        txtSinusitis = findViewById(R.id.txtSinusitis);
        txtUlcer = findViewById(R.id.txtUlcer);
        txtStroke = findViewById(R.id.txtStroke);
        txtTonsillitis = findViewById(R.id.txtTonsillitis);
        txtTb = findViewById(R.id.txtTb);
        txtTyphoid = findViewById(R.id.txtTyphoid);
        txtUti = findViewById(R.id.txtUti);

        // --- Initialize Layouts ---
        // Old
        relativeAppendicites = findViewById(R.id.relativeAppendicites);
        relativeAsthma = findViewById(R.id.relativeAsthma);
        relativeBronchitis = findViewById(R.id.relativeBronchitis);
        relativeDiabetes = findViewById(R.id.relativeDiabates);
        relativeDysentery = findViewById(R.id.relativeDysentry);
        relativeHeatDisease = findViewById(R.id.relativeHeartDisease);
        relativeBloodPressure = findViewById(R.id.relativeBloodPressure);
        relativeJaundice = findViewById(R.id.relativeJaundice);
        relativeMalaria = findViewById(R.id.relativeMalaria);
        relativeMumps = findViewById(R.id.relativeMumps);

        // New
        relativeAcne = findViewById(R.id.relativeAcne);
        relativeAllergies = findViewById(R.id.relativeAllergies);
        relativeAlzheimer = findViewById(R.id.relativeAlzheimer);
        relativeAnemia = findViewById(R.id.relativeAnemia);
        relativeArthritis = findViewById(R.id.relativeArthritis);
        relativeChickenpox = findViewById(R.id.relativeChickenpox);
        relativeCholera = findViewById(R.id.relativeCholera);
        relativeCommonCold = findViewById(R.id.relativeCommonCold);
        relativeConjunctivitis = findViewById(R.id.relativeConjunctivitis);
        relativeCovid = findViewById(R.id.relativeCovid);
        relativeDengue = findViewById(R.id.relativeDengue);
        relativeDepression = findViewById(R.id.relativeDepression);
        relativeDiarrhea = findViewById(R.id.relativeDiarrhea);
        relativeFlu = findViewById(R.id.relativeFlu);
        relativeFoodPoisoning = findViewById(R.id.relativeFoodPoisoning);
        relativeKidneyStones = findViewById(R.id.relativeKidneyStones);
        relativeMeasles = findViewById(R.id.relativeMeasles);
        relativeMigraine = findViewById(R.id.relativeMigraine);
        relativePneumonia = findViewById(R.id.relativePneumonia);
        relativeSinusitis = findViewById(R.id.relativeSinusitis);
        relativeUlcer = findViewById(R.id.relativeUlcer);
        relativeStroke = findViewById(R.id.relativeStroke);
        relativeTonsillitis = findViewById(R.id.relativeTonsillitis);
        relativeTb = findViewById(R.id.relativeTb);
        relativeTyphoid = findViewById(R.id.relativeTyphoid);
        relativeUti = findViewById(R.id.relativeUti);

        // --- Apply Fonts ---
        Typeface tfRegular = Typeface.createFromAsset(getAssets(), "fonts/OpenSansRegular.ttf");
        applyFont(tfRegular, txtOptional, txtAppendicites, txtAsthma, txtBronchitis, txtDiabetes,
                txtDysentery, txtHeatDisease, txtBloodPressure, txtJaundice, txtMalaria, txtMumps,
                txtAcne, txtAllergies, txtAlzheimer, txtAnemia, txtArthritis, txtChickenpox, txtCholera,
                txtCommonCold, txtConjunctivitis, txtCovid, txtDengue, txtDepression, txtDiarrhea,
                txtFlu, txtFoodPoisoning, txtKidneyStones, txtMeasles, txtMigraine, txtPneumonia,
                txtSinusitis, txtUlcer, txtStroke, txtTonsillitis, txtTb, txtTyphoid, txtUti);
    }

    private void applyFont(Typeface tf, TextView... views) {
        for (TextView view : views) {
            if (view != null) view.setTypeface(tf);
        }
    }

    private void setUIClickHandler() {
        setListeners(relativeAppendicites, relativeAsthma, relativeBronchitis, relativeDiabetes,
                relativeDysentery, relativeHeatDisease, relativeBloodPressure, relativeJaundice,
                relativeMalaria, relativeMumps, relativeAcne, relativeAllergies, relativeAlzheimer,
                relativeAnemia, relativeArthritis, relativeChickenpox, relativeCholera, relativeCommonCold,
                relativeConjunctivitis, relativeCovid, relativeDengue, relativeDepression, relativeDiarrhea,
                relativeFlu, relativeFoodPoisoning, relativeKidneyStones, relativeMeasles, relativeMigraine,
                relativePneumonia, relativeSinusitis, relativeUlcer, relativeStroke, relativeTonsillitis,
                relativeTb, relativeTyphoid, relativeUti);
    }

    private void setListeners(View... views) {
        for (View view : views) {
            if (view != null) view.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        title = "";
        int id = v.getId();

        // Existing Mappings
        if (id == R.id.relativeAppendicites) title = "Appendicitis";
        else if (id == R.id.relativeAsthma) title = "Asthma";
        else if (id == R.id.relativeBronchitis) title = "Bronchitis";
        else if (id == R.id.relativeDiabates) title = "Diabetes";
        else if (id == R.id.relativeDysentry) title = "Dysentery";
        else if (id == R.id.relativeHeartDisease) title = "Heart Disease";
        else if (id == R.id.relativeBloodPressure) title = "High Blood Pressure";
        else if (id == R.id.relativeJaundice) title = "Jaundice";
        else if (id == R.id.relativeMalaria) title = "Malaria";
        else if (id == R.id.relativeMumps) title = "Mumps";

            // New Mappings
        else if (id == R.id.relativeAcne) title = "Acne";
        else if (id == R.id.relativeAllergies) title = "Allergies";
        else if (id == R.id.relativeAlzheimer) title = "Alzheimer's Disease";
        else if (id == R.id.relativeAnemia) title = "Anemia";
        else if (id == R.id.relativeArthritis) title = "Arthritis";
        else if (id == R.id.relativeChickenpox) title = "Chickenpox";
        else if (id == R.id.relativeCholera) title = "Cholera";
        else if (id == R.id.relativeCommonCold) title = "Common Cold";
        else if (id == R.id.relativeConjunctivitis) title = "Conjunctivitis";
        else if (id == R.id.relativeCovid) title = "COVID-19";
        else if (id == R.id.relativeDengue) title = "Dengue Fever";
        else if (id == R.id.relativeDepression) title = "Depression";
        else if (id == R.id.relativeDiarrhea) title = "Diarrhea";
        else if (id == R.id.relativeFlu) title = "Flu";
        else if (id == R.id.relativeFoodPoisoning) title = "Food Poisoning";
        else if (id == R.id.relativeKidneyStones) title = "Kidney Stones";
        else if (id == R.id.relativeMeasles) title = "Measles";
        else if (id == R.id.relativeMigraine) title = "Migraine";
        else if (id == R.id.relativePneumonia) title = "Pneumonia";
        else if (id == R.id.relativeSinusitis) title = "Sinusitis";
        else if (id == R.id.relativeUlcer) title = "Stomach Ulcer";
        else if (id == R.id.relativeStroke) title = "Stroke";
        else if (id == R.id.relativeTonsillitis) title = "Tonsillitis";
        else if (id == R.id.relativeTb) title = "Tuberculosis";
        else if (id == R.id.relativeTyphoid) title = "Typhoid";
        else if (id == R.id.relativeUti) title = "Urinary Tract Infection";

        if (!"".equalsIgnoreCase(title)) {
            initializeData();
            Intent intent = new Intent(SymptomListActivity.this, SymptomDetailsActivity.class);
            intent.putExtra("title", title);
            intent.putExtra("symptom", symptom);
            intent.putExtra("treatment", treatment);
            intent.putExtra("dose", dose);
            intent.putExtra("suggestion", suggestion);
            startActivity(intent);
        }
    }

    // ALPHABETICALLY SORTED DATA
    private void initializeData() {
        if (title.equalsIgnoreCase("Acne")) {
            symptom = ">> Whiteheads, blackheads, or pimples on face/upper body.\n\n>> Painful lumps beneath surface of skin.";
            treatment = "Khadirarishta";
            dose = "15-30 ml with equal water, twice daily after meals";
            suggestion = "Apply paste of Neem leaves or Turmeric. Avoid oily and spicy foods. Keep hydration high.";
        }
        else if (title.equalsIgnoreCase("Allergies")) {
            symptom = ">> Sneezing, itching of nose/eyes.\n\n>> Running nose and skin rashes.";
            treatment = "Haridra Khand";
            dose = "1 tsp twice a day with warm milk";
            suggestion = "Drink warm water with lemon and honey. Avoid cold air and dust. Steam inhalation with eucalyptus oil.";
        }
        else if (title.equalsIgnoreCase("Alzheimer's Disease")) {
            symptom = ">> Memory loss, confusion.\n\n>> Difficulty planning or solving problems.";
            treatment = "Brahmi Ghrita";
            dose = "10 ml in the morning with warm milk";
            suggestion = "Practice meditation and mental exercises. Massage head with Almond oil or Brahmi oil regularly.";
        }
        else if (title.equalsIgnoreCase("Anemia")) {
            symptom = ">> Fatigue, weakness, pale skin.\n\n>> Cold hands and feet, dizziness.";
            treatment = "Lohasava";
            dose = "15 ml twice daily after meals";
            suggestion = "Include pomegranate, dates, and beetroot in diet. Cook food in iron vessels to increase iron intake.";
        }
        else if (title.equalsIgnoreCase("Appendicitis")) {
            symptom = ">> Sudden pain in the centre of abdomen.\n\n>> Patient has a mild fever vary on 100-102 degree.\n\n>> Patient vomit several times.";
            treatment = "Shulrajlouha";
            dose = "1 tab or 2 tabs. Two times daily & socked water of Triphala.";
            suggestion = "Rest is of utmost importance in this disease. The patient should resort to fasting which is the only cure for this disease.";
        }
        else if (title.equalsIgnoreCase("Arthritis")) {
            symptom = ">> Joint pain, stiffness, swelling.\n\n>> Decreased range of motion.";
            treatment = "Maharasnadi Kwath";
            dose = "15-20 ml with warm water, twice daily";
            suggestion = "Massage joints with Mahanarayan oil. Avoid cold foods, curds, and fermentation foods. Use Ginger tea.";
        }
        else if (title.equalsIgnoreCase("Asthma")) {
            symptom = ">> It appears to be gasping for breath.\n\n>> There may be coughing.\n\n>> Tightness in the chest.";
            treatment = "Kanakasab";
            dose = "12 ml(4 tsp) twice daily";
            suggestion = "The patient should be made to perspire through steam bath, hot foot bath. Honey is considered highly beneficial.";
        }
        else if (title.equalsIgnoreCase("Bronchitis")) {
            symptom = ">> The larynx, trachea and bronchial tubes are acutely inflamed.\n\n>> Highly fever, difficulty in breathing.";
            treatment = "Basakarista";
            dose = "12 ml(4 tsp) twice daily";
            suggestion = "Use of turmeric powder. A teaspoonful of this powder should be administered with glass of milk.";
        }
        else if (title.equalsIgnoreCase("Chickenpox")) {
            symptom = ">> Itchy blister-like rash.\n\n>> Fever, fatigue, loss of appetite.";
            treatment = "Nimbadi Churna";
            dose = "1-3 grams with warm water";
            suggestion = "Neem leaf bath is highly recommended. Do not scratch the blisters. Eat light, easily digestible food.";
        }
        else if (title.equalsIgnoreCase("Cholera")) {
            symptom = ">> Severe watery diarrhea.\n\n>> Dehydration and muscle cramps.";
            treatment = "Sanjivani Vati";
            dose = "1 tablet twice daily with ginger juice";
            suggestion = "Hydration is critical (ORS or Coconut water). Lemon water with sugar and salt helps maintain electrolyte balance.";
        }
        else if (title.equalsIgnoreCase("Common Cold")) {
            symptom = ">> Runny nose, sore throat.\n\n>> Cough, congestion, mild fever.";
            treatment = "Sitopaladi Churna";
            dose = "1/2 tsp with honey, thrice daily";
            suggestion = "Drink ginger-tulsi tea. Steam inhalation. Gargle with warm salt water.";
        }
        else if (title.equalsIgnoreCase("Conjunctivitis")) {
            symptom = ">> Redness in eye, itching.\n\n>> Gritty feeling, discharge from eye.";
            treatment = "Triphala Ghrita";
            dose = "Use as eye drops (consult physician) or intake 1 tsp";
            suggestion = "Wash eyes with Triphala water (filtered). Do not touch eyes. Wear dark glasses to avoid strain.";
        }
        else if (title.equalsIgnoreCase("COVID-19")) {
            symptom = ">> Fever, dry cough, fatigue.\n\n>> Loss of taste or smell.";
            treatment = "Ayush-64 or Sanshamani Vati";
            dose = "2 tablets twice daily with warm water";
            suggestion = "Steam inhalation with carom seeds (Ajwain). Drink Golden Milk (Turmeric milk). Isolate and rest.";
        }
        else if (title.equalsIgnoreCase("Dengue Fever")) {
            symptom = ">> High fever, severe headache.\n\n>> Pain behind eyes, joint pain, rash.";
            treatment = "Giloy Ghan Vati";
            dose = "2 tablets twice daily";
            suggestion = "Papaya leaf juice is excellent for increasing platelet count. Drink plenty of fluids to avoid dehydration.";
        }
        else if (title.equalsIgnoreCase("Depression")) {
            symptom = ">> Persistent sadness, loss of interest.\n\n>> Sleep disturbances, lack of energy.";
            treatment = "Saraswatarishta";
            dose = "15-30 ml with equal water after meals";
            suggestion = "Practice Yoga and Pranayama daily. Massage head with warm oil. Eat fresh, satvik food.";
        }
        else if (title.equalsIgnoreCase("Diabetes")) {
            symptom = ">> Copious urination and glucose in the urine.\n\n>> Patient feels thirsty, feels drowsy, weakness.";
            treatment = "Jambadyaristy";
            dose = "12 ml(4 tsp) twice daily";
            suggestion = "The bitter gourd is highly beneficial in the treatment. The patient should avoid tea, coffee. Exercise is most important.";
        }
        else if (title.equalsIgnoreCase("Diarrhea")) {
            symptom = ">> Loose, watery stools.\n\n>> Abdominal cramps, dehydration.";
            treatment = "Kutajarishta";
            dose = "15-20 ml with equal water, twice daily";
            suggestion = "Eat curd and rice. Drink pomegranate juice. Avoid spicy and heavy foods.";
        }
        else if (title.equalsIgnoreCase("Dysentery")) {
            symptom = ">> Stool remains putrid & may contain blood.\n\n>> Diarrhoea and constipation may alternate.";
            treatment = "Brihatkutajabaleha";
            dose = "6 to 12g two times daily";
            suggestion = "Flesh foods of all kind should be avoided. Use small pieces of onion mixed with curd.";
        }
        else if (title.equalsIgnoreCase("Flu")) {
            symptom = ">> Fever, chills, muscle aches.\n\n>> Cough, congestion, fatigue.";
            treatment = "Tribhuvan Kirti Ras";
            dose = "1 tablet twice daily with ginger honey juice";
            suggestion = "Rest completely. Drink warm soups and herbal teas (Tulsi, Ginger, Black Pepper).";
        }
        else if (title.equalsIgnoreCase("Food Poisoning")) {
            symptom = ">> Nausea, vomiting, diarrhea.\n\n>> Abdominal pain and cramps.";
            treatment = "Bilvadi Churna";
            dose = "1 tsp with buttermilk";
            suggestion = "Fast until stomach settles. Sip light ginger tea. Avoid solid foods initially.";
        }
        else if (title.equalsIgnoreCase("Heart Disease")) {
            symptom = ">> Shortness of breath\n\n>> Chest pain or pain down either arm, palpitation.";
            treatment = "Arjunarista";
            dose = "12ml(4 tsp) twice daily";
            suggestion = "Fruits & vegetables are highly beneficial. One teaspoon raw onion juice 1st thing in the morning will be beneficial.";
        }
        else if (title.equalsIgnoreCase("High Blood Pressure")) {
            symptom = ">> Pain toward the back of the head & neck.\n\n>> Dizziness, aches & pain in the arm & shoulder.";
            treatment = "Mrityunjoy";
            dose = "12ml(4 tsp) in twice daily";
            suggestion = "Person should follow a well balanced diet. Vegetables are good for patient. Exercise plays an important role.";
        }
        else if (title.equalsIgnoreCase("Jaundice")) {
            symptom = ">> Extreme weakness, headache, fever, loss of appetite.\n\n>> Yellow coloration of the eyes, tongue, skin.";
            treatment = "Partrangasav";
            dose = "12ml(4 tsp) in twice daily";
            suggestion = "All fats must be avoided for two weeks. Drinking lots of water with lemon juice will protect the damaged liver cells.";
        }
        else if (title.equalsIgnoreCase("Kidney Stones")) {
            symptom = ">> Severe pain in side and back.\n\n>> Pain on urination, pink/brown urine.";
            treatment = "Chandraprabha Vati";
            dose = "2 tablets twice daily with water";
            suggestion = "Drink barley water and coconut water regularly. Avoid spinach, tomatoes, and excess salt.";
        }
        else if (title.equalsIgnoreCase("Malaria")) {
            symptom = ">> High fever, which may come every day.\n\n>> The fever is accompanied by chill, headache, shivering.";
            treatment = "Amritarista";
            dose = "12 ml(4 tsp) in twice daily";
            suggestion = "Avoid tea, coffee, fried food. Lime & lemon are beneficial. The leaves of the holy basil are considered beneficial.";
        }
        else if (title.equalsIgnoreCase("Measles")) {
            symptom = ">> High fever, cough, runny nose.\n\n>> Full body rash starting from face.";
            treatment = "Mahasudarshan Churna";
            dose = "1/2 tsp with warm water";
            suggestion = "Keep patient in a well-ventilated room. Sponge with Neem water. Light diet is essential.";
        }
        else if (title.equalsIgnoreCase("Migraine")) {
            symptom = ">> Severe throbbing pain on one side of head.\n\n>> Sensitivity to light/sound, nausea.";
            treatment = "Godanti Bhasma";
            dose = "250mg with honey twice daily";
            suggestion = "Apply paste of ginger powder on forehead. Avoid triggers like strong smells or bright lights. Sleep on time.";
        }
        else if (title.equalsIgnoreCase("Mumps")) {
            symptom = ">> Swelling pain under one ear with stiffness of neck.\n\n>> Fever and vomiting.";
            treatment = "Baharernani";
            dose = "2 tsp two times daily with milk & sugar";
            suggestion = "The patient should be put in bed for several days. The leaves of the peepal tree are effective.";
        }
        else if (title.equalsIgnoreCase("Pneumonia")) {
            symptom = ">> Cough with phlegm, fever, chills.\n\n>> Difficulty breathing, chest pain.";
            treatment = "Shwaskuthar Ras";
            dose = "1 tablet twice daily with honey";
            suggestion = "Must consult doctor immediately. Keep chest warm. Steam inhalation with eucalyptus is helpful.";
        }
        else if (title.equalsIgnoreCase("Sinusitis")) {
            symptom = ">> Facial pain, stuffy nose.\n\n>> Headache, loss of smell.";
            treatment = "Laxmi Vilas Ras";
            dose = "1 tablet twice daily with warm water";
            suggestion = "Jal Neti (Nasal irrigation) is very effective. Steam inhalation with mint leaves. Avoid cold drinks.";
        }
        else if (title.equalsIgnoreCase("Stomach Ulcer")) {
            symptom = ">> Burning stomach pain.\n\n>> Feeling of fullness, bloating, intolerance to fatty food.";
            treatment = "Avipattikar Churna";
            dose = "1 tsp before bed with warm water";
            suggestion = "Drink cold milk or coconut water for relief. Avoid chilies, spices, and sour foods completely.";
        }
        else if (title.equalsIgnoreCase("Stroke")) {
            symptom = ">> Sudden numbness of face/arm/leg.\n\n>> Confusion, trouble seeing or walking.";
            treatment = "Brihat Vata Chintamani Ras";
            dose = "As prescribed by physician (Critical condition)";
            suggestion = "Immediate medical attention required. Post-care involves oil massage (Abhyanga) and physiotherapy.";
        }
        else if (title.equalsIgnoreCase("Tonsillitis")) {
            symptom = ">> Swollen tonsils, sore throat.\n\n>> Difficulty swallowing, fever.";
            treatment = "Khadiradi Vati";
            dose = "Chew 1 tablet slowly, 3-4 times a day";
            suggestion = "Gargle with warm water mixed with turmeric and salt. Avoid cold water and ice cream.";
        }
        else if (title.equalsIgnoreCase("Tuberculosis")) {
            symptom = ">> Cough lasting 3+ weeks, coughing blood.\n\n>> Chest pain, weight loss, night sweats.";
            treatment = "Chyawanprash and Swarna Vasant Malti Ras";
            dose = "1 tsp Chyawanprash morning/night";
            suggestion = "Requires medical DOTS treatment. Diet should be rich in milk, ghee, and nutritious foods.";
        }
        else if (title.equalsIgnoreCase("Typhoid")) {
            symptom = ">> High fever, weakness, stomach pain.\n\n>> Headache, loss of appetite.";
            treatment = "Mahasudarshan Ghan Vati";
            dose = "2 tablets twice daily";
            suggestion = "Avoid solid foods; take liquid diet like fruit juices and gruel. Maintain strict hygiene.";
        }
        else if (title.equalsIgnoreCase("Urinary Tract Infection")) {
            symptom = ">> Burning sensation when urinating.\n\n>> Frequent urge to urinate, cloudy urine.";
            treatment = "Chandraprabha Vati or Gokshuradi Guggulu";
            dose = "2 tablets twice daily with water";
            suggestion = "Drink cranberry juice or coriander water. Maintain good hygiene. Drink plenty of water.";
        }
    }
}