package src.maps.app.mapsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import src.maps.app.mapsapplication.Utilities.Geolocationserv;


public class Infoscreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infoscreen);
        TextView txtvwsource = (TextView) findViewById(R.id.txtvw_sourcename);
        txtvwsource.setText(Geolocationserv.source);
        TextView txtvwdest = (TextView) findViewById(R.id.destinationname);
        txtvwdest.setText(Geolocationserv.dest);
        ImageView imgvw_staticmap = (ImageView) findViewById(R.id.imgvw_staticmap);

        Picasso.with(this).load("https://maps.googleapis.com/maps/api/staticmap?center=" + Geolocationserv.source + "&zoom=5&size=600x300&maptype=roadmap" +
                        "&markers=color:blue%7Clabel:S%7C" + Geolocationserv.lat[0] + "," + Geolocationserv.lang[0] + "&markers=color:green%7Clabel:D%7C" + Geolocationserv.lat[1] + "," + Geolocationserv.lang[1] + "&path=weight:3%7Ccolor:red%7Cenc:"+MapActivity.encodedString + "&key=AIzaSyCVRktCvkLUKhzR5rinh_2RmRo7z3io4ZE"
        ).into(imgvw_staticmap);
        Button btn =(Button) findViewById(R.id.btn_pay2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Infoscreen.this,Paymentscreen.class);
                startActivity(intent);
                Infoscreen.this.finish();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_infoscreen, menu);
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
    }
