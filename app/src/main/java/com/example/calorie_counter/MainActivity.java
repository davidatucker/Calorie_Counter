package com.example.calorie_counter;

/*import android.support.v7.app.AppCompatActivity;*/
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Spinner spinnerDropDownView;
    String[] spinnerValueHoldValue = {"Aerobics", "Bicycling", "Dancing", "Running", "Swimming","Walking" };
    private String SelectedActivity;
    private float MET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate( savedInstanceState );
        CalCalc = new Calculator( 100.0f, 100.0f );
        setContentView( R.layout.activity_main );

        spinnerDropDownView =(Spinner)findViewById(R.id.selection_spinner);
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, spinnerValueHoldValue);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item,spinnerValueHoldValue);
        spinnerDropDownView.setAdapter(adapter);

        spinnerDropDownView.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // I think Toast does the pop up on the bottom when a users selects something from the drop down.
                //Toast.makeText(MainActivity.this, spinnerDropDownView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                SelectedActivity = spinnerDropDownView.getSelectedItem().toString();
                if(SelectedActivity == "Aerobics"){
                  MET = (float)7.3;}
                else if(SelectedActivity == "Bicycling"){
                  MET = (float)7.5;}
                else if(SelectedActivity == "Dancing"){
                  MET = (float)5.0;}
                else if(SelectedActivity == "Running"){
                  MET = (float)9.8;}
                else if(SelectedActivity == "Swimming"){
                  MET = (float)6.0;}
                else if(SelectedActivity == "Walking"){
                  MET = (float)4.3;}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });
    }

    private Calculator CalCalc;

    /** Called when the user clicks on the Calculate button */
    public void calculate( View v ) {
        Log.w( "MainActivity", "v = " + v );

        EditText TimeSpentEditText = ( EditText ) findViewById( R.id.amount_time_spent );
        String timeString = TimeSpentEditText.getText( ).toString( );

        EditText WeightEditText = ( EditText ) findViewById( R.id.weight );
        String weightString = WeightEditText.getText().toString();

        TextView CalorieTextView = (TextView) findViewById(R.id.Calories);

        try {

            // Convert the input from text to float
            float timeSpent = Float.parseFloat(timeString);
            float weight = Float.parseFloat(weightString);

            // Set the variables
            CalCalc.setTimeSpent(timeSpent);
            CalCalc.setWeight(weight);
            CalCalc.setMET(MET);

            // Actual call of the calculation
            float CalUsed = CalCalc.CaloriesUsed();

            // Put the answer in the Answer box on the screen
            //CalorieTextView.setText(String.valueOf(CalUsed));
            CalorieTextView.setText(String.format("Calories: %.2f", CalUsed));

        } catch( NumberFormatException nfe ) {
            // pop up an alert view here
        }
    }
}
    //  This was used to run the calc as the users changed the input boxes
    /*private class TextChangeHandler implements TextWatcher {
        public void afterTextChanged( Editable e ) {
            calculate( );
        }

        public void beforeTextChanged( CharSequence s, int start,
                                       int count, int after ) {
        }

        public void onTextChanged( CharSequence s, int start,
                                   int before, int after ) {
        }*/

