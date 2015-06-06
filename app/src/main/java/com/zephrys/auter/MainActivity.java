package com.zephrys.auter;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Button b1 = (Button) findViewById(R.id.signup);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the various required fields
                String aadhar = (String) ((TextView) findViewById(R.id.aadhar)).getText();
                String first_name = (String) ((TextView) findViewById(R.id.fname)).getText();
//                String last_name = (String) ((TextView) findViewById(R.id.lname)).getText();
                String gender = (String) ((TextView) findViewById(R.id.gender)).getText();
                String dob = (String) ((TextView) findViewById(R.id.dob)).getText();

                String son1 = String.format("{ \"aadhaar-id\": \"%s\", \"device-id\": \"Zephyr\", \"modality\": \"demo\", \"certificate-type\": \"preprod\", \"demographics\": { \"name\": { \"matching-strategy\": \"P\",\n      \"matching-value\": \"56\",\"name-value\": \"%s\" } , \"dob\": {\n      \"format\": \"YYYY-MM-DD\",\n      \"dob-type\": \"V\",\n      \"dob-value\": \"%s\"\n    }, \"gender\" : \"%s\"}, \"location\": { \"type\": \"gps\", \"latitude\": \"22.3\", \"longitude\": \"73.2\", \"altitude\": \"0\" } }", aadhar, first_name, dob, gender);
//                Calendar c = Calendar.getInstance();
//                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
//                String timeString = f.format(c.getTime());

                HttpClient client = new DefaultHttpClient();
                HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000); //Timeout Limit
                HttpResponse response;
//                JSONObject json = new JSONObject();

                try {
                    HttpPost post = new HttpPost("https://ac.khoslalabs.com/hackgate/hackathon/auth/raw HTTP/1.1");
                    StringEntity se = new StringEntity(son1);
                    se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                    post.setEntity(se);
                    response = client.execute(post);

                    /*Checking response */
                    if(response!=null){
                        InputStream in = response.getEntity().getContent(); //Get the data in the entity
                    }

                } catch(Exception e) {
                    e.printStackTrace();
                }


            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
