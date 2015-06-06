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

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView aadhar = (TextView) findViewById(R.id.aadhar);
        TextView first_name = (TextView) findViewById(R.id.fname);
        TextView last_name = (TextView) findViewById(R.id.lname);
        TextView gender = (TextView) findViewById(R.id.gender);
        TextView dob = (TextView) findViewById(R.id.dob);
        TextView dobt = (TextView) findViewById(R.id.dobt);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        String timeString = sdf.format(c.getTime());


        String init = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<Auth uid=”+aadhar+” tid=”public” ac=”public” sa=”ac” ver=”1.5” lk=”MKHmkuz-MgLYvA54PbwZdo9eC3D5y7SVozWwpNgEPysVqLs_aJgAVOI”>\n <Skey ci=”20170227”>encrypted and encoded session key</Skey>\n <Uses pi=”y” pa=”n” pfa=”n” bio=”n” pin=”n” otp=”n”/>\n <Data>encrypted and then encoded block</Data>\n <Hmac>SHA-256 Hash of Pid XML, encrypted and then encoded</Hmac>\n <Signature>Digital signature of AUA</Signature>\n</Auth>\n"
        String pid = '<Pid ts=”” ver=””>\n <Meta fdc=”” idc=”” apc=””>\n <Locn lat=”” lng=”” vtc=”” subdist=”” dist=”” state=”” pc=””/>\n </Meta>\n <Demo lang=””>\n <Pi ms=”E|P” mv=”” name=”” lname=”” lmv=”” gender=”M|F|T” dob=””\ndobt=”V|D|A” age=”” phone=”” email=””/>\n <Pa ms=”E” co=”” house=”” street=”” lm=”” loc=”” \n vtc=”” subdist=”” dist=”” state=”” pc=”” po=””/>\n <Pfa ms=”E|P” mv=”” av=”” lav=”” lmv=””/>\n </Demo>\n <Bios>\n <Bio type=”FMR|FIR|IIR” posh=””>encoded biometric</Bio>\n </Bios>\n <Pv otp=”” pin=””/>\n</Pid>'

        Button b1 = (Button) findViewById(R.id.signup);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
