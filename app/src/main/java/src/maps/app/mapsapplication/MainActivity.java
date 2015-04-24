package src.maps.app.mapsapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import src.maps.app.mapsapplication.Utilities.Geolocationserv;
import src.maps.app.mapsapplication.Utilities.googledirections;


public class MainActivity extends ActionBarActivity {
EditText edt_source,edt_dest;
    Geolocationserv a;
    googledirections b;
    static String[] routes,dist;

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_source=(EditText)findViewById(R.id.edt_source);
        edt_dest=(EditText)findViewById(R.id.edt_dest);


    }

public void getloc(View v) {

    String source = edt_source.getText().toString();
    String dest = edt_dest.getText().toString();
    a = new Geolocationserv(source, dest, this);
    a.sendaddress();


}

public void show_map(View v)
{


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
}
