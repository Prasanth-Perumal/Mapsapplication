package src.maps.app.mapsapplication;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import src.maps.app.mapsapplication.Utilities.Geolocationserv;


public class Printscreen extends ActionBarActivity {
    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printscreen);
        WebView webView = (WebView) findViewById(R.id.webvw_print);
        webView.setWebViewClient(new WebViewClient() {
            ProgressDialog pgr=ProgressDialog.show(Printscreen.this,"Loading","please wait while we get the routes",true);
            @Override
            public boolean shouldOverrideUrlLoading(WebView view,
                                                    String url)
            {

                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url)
            {
            pgr.cancel();

            }
        });



        String htmlDocument =
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "\n" +
                        "<head>\n" +
                        "\n" +
                        "<style>\n" +
                        "\n" +
                        "body{\n" +
                        "width:100%;\n" +
                        "height:auto;\n" +
                        "font-size:12px;\n" +
                        "margin:0px auto;\n" +
                        "padding:0px auto;\n" +
                        "\n" +
                        "}\n" +
                        ".container\n" +
                        "{\n" +
                        " width:97%;\n" +
                        " height:auto;\n" +
                        " margin:0px auto;\n" +
                        " padding:0px auto;\n" +
                        " border:solid 1px black;\n" +
                        "\n" +
                        "}\n" +
                        ".wrapper{\n" +
                        "width:100%;\n" +
                        "height:450px;\n" +
                        "margin:0px auto;\n" +
                        " padding:0px auto;\n" +
                        "border:solid 1px black;\n" +
                        "}\n" +
                        "\n" +
                        "h1\n" +
                        "{\n" +
                        "text-align:center;\n" +
                        "}\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "</style>\n" +
                        "\n" +
                        "</head>\n" +
                        "\n" +
                        "<body>\n" +
                        "\n" +
                        "<div class=\"wrapper\">\n" +
                        "<div class=\"container\">\n" +
                        "\n" +
                        "\n" +
                        "<h1>Receipt</h1>\n" +
                        "\n" +

                        "<div style=\"width:100%;height:30px;float:left;margin-bottom:10px;\">\n" +
                        "<div style=\"margin-left:3%;float:left;width:15%;height:30px;\">\n" +
                        "<span><h2>Source:</h2></span>\n" +
                        "</div>\n" +
                        "<div style=\"margin-left:1%;float:left;width:65%;height:30px;\">\n" +
                        "<span><h2>K R Market</h2></span>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "\n" +

                        "<div style=\"width:100%;height:30px;float:left;margin-bottom:10px;\">\n" +
                        "<div style=\"margin-left:3%;float:left;width:15%;height:30px;\">\n" +
                        "<span><h2>Destination:</h2></span>\n" +
                        "</div>\n" +
                        "<div style=\"margin-left:1%;float:left;width:25%;height:30px;\">\n" +
                        "<span><h2>C V Raman Nagar</h2></span>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "\n" +

                        "<div style=\"width:100%;height:30px;float:left;margin-bottom:10px;\">\n" +
                        "<div style=\"margin-left:3%;float:left;width:15%;height:30px;\">\n" +
                        "<span><h2>Amount:</h2></span>\n" +
                        "</div>\n" +
                        "<div style=\"margin-left:1%;float:left;width:25%;height:30px;\">\n" +
                        "<span><h2>100</h2></span>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "\n" +

                        "<div style=\"width:100%;height:30px;float:left;margin-bottom:10px;\">\n" +
                        "<div style=\"margin-left:3%;float:left;width:15%;height:30px;\">\n" +
                        "<span><h2>KMS:</h2></span>\n" +
                        "</div>\n" +
                        "<div style=\"margin-left:1%;float:left;width:25%;height:30px;\">\n" +
                        "<span><h2>10.8</h2></span>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "\n" +

                        "<div style=\"width:100%;height:30px;float:left;margin-bottom:10px;\">\n" +
                        "<span><h3>Route from Source to Destination</h3></span>\n" +
                        "<div style=\"margin-left:3%;float:left;border:solid 1px black;width:200px;height:100px;\"><img src='"+"https://maps.googleapis.com/maps/api/staticmap?center=" + Geolocationserv.source + "&zoom=5&size=600x300&maptype=roadmap" +
                        "&markers=color:blue%7Clabel:S%7C" + Geolocationserv.lat[0] + "," + Geolocationserv.lang[0] + "&markers=color:green%7Clabel:D%7C" + Geolocationserv.lat[1] + "," + Geolocationserv.lang[1] + "&path=weight:3%7Ccolor:red%7Cenc:"+MapActivity.encodedString + "&key=AIzaSyCVRktCvkLUKhzR5rinh_2RmRo7z3io4ZE"+"'/></div>\n" +

                        "</div>\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "</div>\n" +
                        "<div>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>";

        webView.loadDataWithBaseURL(null, htmlDocument,
                "text/HTML", "UTF-8", null);

        myWebView = webView;
        TextView textprint = (TextView) findViewById(R.id.txtvw_print);
        textprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createWebPrintJob(myWebView);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_printscreen, menu);
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

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void createWebPrintJob(WebView webView) {

        PrintManager printManager = (PrintManager) this
                .getSystemService(Context.PRINT_SERVICE);

        PrintDocumentAdapter printAdapter =
                webView.createPrintDocumentAdapter();

        String jobName = getString(R.string.app_name) + " Print Test";

        printManager.print(jobName, printAdapter,
                new PrintAttributes.Builder().build());
    }
}
