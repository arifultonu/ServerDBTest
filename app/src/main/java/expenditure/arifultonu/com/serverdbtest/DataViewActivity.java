package expenditure.arifultonu.com.serverdbtest;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataViewActivity extends Activity {

    // Account Statement Nodes
    private static final String TAG_All_DATA_NODES = "UserDataList";
    private static final String TAG_USER_NAME = "UserName";
    private static final String TAG_PASSWORD = "Password";
    private static final String TAG_EMAIL = "Email";
    private static String retrive_url = IPConfigure.getIP()
            + "ArifulTonuAndroidConnectivity/RegistrationServlet";

    TableLayout viewTableLayout;

    JSONParser jsonParser = new JSONParser();
    JSONObject json;

    ArrayList<Object> dataList = new ArrayList<Object>();
    JSONArray dataStatement = null;
    JSONArray array;
    JSONArray jsonArray = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_view);
        viewTableLayout = (TableLayout) findViewById(R.id.viewAlldataTable);

        new GetAllData().execute();
    }

    public void showTableData() {

        Color myColor = new Color();

        TableRow th = new TableRow(this);
        th.setBackgroundColor(Color.parseColor("#d4d4d4"));
        th.setLayoutParams(new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView thd = new TextView(this);
        thd.setPadding(10, 0, 10, 0);
        thd.setTextColor(Color.BLACK);
        // thd.setTextColor(myColor.parseColor("#1f62b0"));
        thd.setTextSize(7 * getResources().getDisplayMetrics().density);
        thd.setBackgroundResource(R.drawable.table_border_color);
        thd.setText("User Name");
        thd.setGravity(Gravity.CENTER);

        th.addView(thd);

        TextView thd1 = new TextView(this);
        thd1.setPadding(10, 0, 10, 0);
        thd1.setTextColor(Color.BLACK);
        //thd1.setTextColor(myColor.parseColor("#1f62b0"));
        thd1.setTextSize(7 * getResources().getDisplayMetrics().density);
        thd1.setBackgroundResource(R.drawable.table_border_color);
        thd1.setText("Password");
        thd1.setGravity(Gravity.CENTER);
//		thd1.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources()
//				.getDimension(R.dimen.text_size));
        th.addView(thd1);

        TextView thd2 = new TextView(this);
        thd2.setPadding(10, 0, 10, 0);
        thd2.setTextColor(Color.BLACK);
        //thd2.setTextColor(myColor.parseColor("#1f62b0"));
        thd2.setTextSize(7 * getResources().getDisplayMetrics().density);
        thd2.setBackgroundResource(R.drawable.table_border_color);
        thd2.setText("Email");
        thd2.setGravity(Gravity.CENTER);
//		thd1.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources()
//				.getDimension(R.dimen.text_size));
        th.addView(thd2);


//        TextView thd3 = new TextView(this);
//        thd3.setPadding(10, 0, 10, 0);
//        thd3.setTextColor(Color.WHITE);
//         thd3.setTextColor(myColor.parseColor("#1f62b0"));
//         thd3.setTextSize(7 * getResources().getDisplayMetrics().density);
//        thd3.setBackgroundResource(R.drawable.table_border_color);
//        thd3.setText("Delete");
//       //thd1.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.text_size));
//        th.addView(thd3);

        viewTableLayout.addView(th);

        // for(String ad:list){

        for (Iterator<Object> i = dataList.iterator(); i.hasNext(); ) {
            TableRow tr = new TableRow(this);

            // Integer value = (Integer) i.next();
            // if ((value + 1) % 2 == 0)
            // tr.setBackgroundColor(Color.DKGRAY);
            tr.setBackgroundColor(Color.parseColor("#e8e8e8"));
            // tr.setBackgroundResource(R.drawable.border_color);

            tr.setLayoutParams(new TableLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));


            // Account Type
            final TextView td1 = new TextView(this);
            td1.setPadding(10, 0, 10, 0);
            // td1.setTextColor(Color.WHITE);
            td1.setTextColor(myColor.parseColor("#6d6d6d"));
            td1.setBackgroundResource(R.drawable.table_border_color);
            td1.setTextSize(7 * getResources().getDisplayMetrics().density);
            td1.setText(i.next() + "");
            td1.setGravity(Gravity.LEFT);
//			td1.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources()
//					.getDimension(R.dimen.text_size));
            tr.addView(td1);


            // Account Type
            final TextView td2 = new TextView(this);
            td2.setPadding(10, 0, 10, 0);
            //  td2.setTextColor(Color.WHITE);
            td2.setTextColor(myColor.parseColor("#6d6d6d"));
            td2.setBackgroundResource(R.drawable.table_border_color);
            td2.setTextSize(7 * getResources().getDisplayMetrics().density);
            td2.setText(i.next() + "");
            td2.setGravity(Gravity.LEFT);
//			td1.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources()
//					.getDimension(R.dimen.text_size));
            tr.addView(td2);

            // Account Type
            final TextView td3 = new TextView(this);
            td3.setPadding(10, 0, 10, 0);
            // td3.setTextColor(Color.WHITE);
            td3.setTextColor(myColor.parseColor("#6d6d6d"));
            td3.setBackgroundResource(R.drawable.table_border_color);
            td3.setTextSize(7 * getResources().getDisplayMetrics().density);
            td3.setText(i.next() + "");
            td3.setGravity(Gravity.LEFT);
//			td1.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources()
//					.getDimension(R.dimen.text_size));
            tr.addView(td3);

//            Button button = new Button(this);
//            button.setText("edit");
//            button.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    // TODO Auto-generated method stub
//                    Toast.makeText(getApplicationContext(), td1.getText().toString(), Toast.LENGTH_LONG).show();
//                }
//            });
//            tr.addView(button);

            viewTableLayout.addView(tr);

        }
    }

    private class GetAllData extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dataList = new ArrayList<Object>();
            jsonArray = new JSONArray();
            viewTableLayout.removeAllViews();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            // Toast.makeText(MainActivity.this, "json :" + json.toString(), Toast.LENGTH_LONG).show();
            showTableData();

        }


        @Override
        protected String doInBackground(String... args) {

            List<NameValuePair> params = new ArrayList<NameValuePair>();

            json = jsonParser.makeHttpRequest(retrive_url, "GET", params);
            Log.d("json: ", json.toString());
            // Log.d("jjjjjjjjjjjjjjjjjjjjjjj",username);

            if(json!= null){
                try {
                    jsonArray = json.getJSONArray(TAG_All_DATA_NODES);
                    for(int i = 0; jsonArray.length()>0; i++){
                        JSONObject c = jsonArray.getJSONObject(i);
                        dataList.add(c.getString(TAG_USER_NAME));
                        dataList.add(c.getString(TAG_PASSWORD));
                        dataList.add(c.getString(TAG_EMAIL));
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }else{

            }


            return null;

        }


    }
}


