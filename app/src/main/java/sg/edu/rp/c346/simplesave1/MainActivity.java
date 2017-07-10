package sg.edu.rp.c346.simplesave1;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onPause() {
        super.onPause();
        //step 1b: Obtain an instance of the Shared Preferance
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step 1c: Obtain an Instance of the shared Preference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        // Step 1D: add the key-value pair
        prefEdit.putString("greeting", "Hello!");
        //step 1e: Call commit() method to save the changes into the Shared Preferences
        prefEdit.commit();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //Step 2a: Obtain an Instance of the Shared Preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Step 2B: Retrieve the saved data with the key, greeting from the sharedPreferences object.
        String strGreeting = prefs.getString("greeting", "No Greetings!");

        Toast toast = Toast.makeText(getApplicationContext(), strGreeting, Toast.LENGTH_LONG);
        toast.show();
    }


}
