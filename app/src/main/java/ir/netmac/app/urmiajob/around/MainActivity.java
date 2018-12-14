package ir.netmac.app.urmiajob.around;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnmaps;

    //private GPSTracker gps;
    private double latitude;
    private double longitude;
    private String url_around;
    private List<HashMap<String, Object>> all_around = new ArrayList<>();
    private int d1 = 2000;
    private Button btn_gps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnmaps = findViewById(R.id.btnmaps);
        btnmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        url_around = "http://www.orumcity.ir/urombist/new_get_data_around.php?lnx=" + latitude + "&lny=" + longitude + "&page=";
        Log.i("Log1", "" + url_around);


    }

    public void onClickMap(View v) {
        Intent i = new Intent(getApplicationContext(), MapsActivity.class);
        i.putExtra("url", url_around);
        i.putExtra("lnx", "" + latitude);
        i.putExtra("lny", "" + longitude);
        startActivity(i);
    }
  /*  public void my_place(){
        gps = new GPSTracker(MainActivity.this);
        if(gps.canGetLocation()) {
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
            l3.setVisibility(View.VISIBLE);
        }
        else l4.setVisibility(View.VISIBLE);
    }*/


}
