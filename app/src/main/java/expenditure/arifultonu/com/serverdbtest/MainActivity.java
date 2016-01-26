package expenditure.arifultonu.com.serverdbtest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private static String insert_url = IPConfigure.getIP()
            + "ArifulTonuAndroidConnectivity/RegistrationServlet";


    JSONParser jsonParser = new JSONParser();
    JSONObject json;
    JSONArray jsonArray = null;

    EditText userName;
    EditText password;
    EditText emailId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userName = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        emailId = (EditText) findViewById(R.id.email);
        Button btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName1 = userName.getText().toString();
                String pass = password.getText().toString();
                String email = emailId.getText().toString();

                new DataInsert().execute(userName1, pass, email);
            }
        });

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class DataInsert extends AsyncTask<String, Integer, String> {
        String randomString;

        @Override
        protected String doInBackground(String... args) {
            //TelephonyManager mngr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            //String imei = mngr.getDeviceId();

            String username = args[0],
                    pass = args[1],
                    email = args[2];

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("username", username));
            params.add(new BasicNameValuePair("pass", pass));
            params.add(new BasicNameValuePair("email", email));

            json = jsonParser.makeHttpRequest(insert_url, "POST", params);


            return null;
        }
    }
}
