package expenditure.arifultonu.com.serverdbtest;

import android.content.Intent;
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
import android.widget.TableLayout;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private static final String TAG_All_DATA_NODES = "UserDataList";
    private static final String TAG_USER_NAME = "UserName";
    private static final String TAG_PASSWORD = "Password";
    private static final String TAG_EMAIL = "Email";

    private static String insert_url = IPConfigure.getIP()
            + "ArifulTonuAndroidConnectivity/RegistrationServlet";

    TableLayout viewTableLayout;

    ArrayList<Object> dataList = new ArrayList<Object>();
    JSONParser jsonParser = new JSONParser();
    JSONObject json;
    JSONArray jsonArray = null;

    EditText userName;
    EditText password;
    EditText emailId;
    Button btnSave;
    Button btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userName = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        emailId = (EditText) findViewById(R.id.email);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnView = (Button) findViewById(R.id.btnViewAll);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName1 = userName.getText().toString();
                String pass = password.getText().toString();
                String email = emailId.getText().toString();

                new DataInsert().execute();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DataViewActivity.class));
                startActivity(new Intent(MainActivity.this, DataViewActivity.class));
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

    private class DataInsert extends AsyncTask<String, String, String> {
        String randomString;

        @Override
        protected String doInBackground(String... args) {
            //TelephonyManager mngr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            //String imei = mngr.getDeviceId();

//            String username = args[0],
//                    pass = args[1],
//                    email = args[2];
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("username", userName.getText().toString()));
            params.add(new BasicNameValuePair("pass", password.getText().toString()));
            params.add(new BasicNameValuePair("email", emailId.getText().toString()));


//            List<NameValuePair> params = new ArrayList<NameValuePair>();
//            params.add(new BasicNameValuePair("username", username));
//            params.add(new BasicNameValuePair("pass", pass));
//            params.add(new BasicNameValuePair("email", email));

            json = jsonParser.makeHttpRequest(insert_url, "POST", params);

            return null;
        }
    }


}


