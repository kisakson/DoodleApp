package cmsc434.doodler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int size = 10;
    int hue = 0;
    int brightness = 0;
    int saturation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentGotten = getIntent();
        if (intentGotten != null) {
            Bundle bundleGotten = intentGotten.getExtras();
            if (bundleGotten != null) {
                size = bundleGotten.getInt("size");
                hue = bundleGotten.getInt("hue");
                brightness = bundleGotten.getInt("brightness");
                saturation = bundleGotten.getInt("saturation");
                Toast.makeText(MainActivity.this,"Saturation is " + saturation + " and brt is " + brightness,
                        Toast.LENGTH_SHORT).show();
            }
        }

        DoodleView doodleView = (DoodleView) findViewById(R.id.doodleView);
        doodleView.setPaint(size, hue, saturation, brightness);

        Button buttonSettings = (Button) findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SettingsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("size", size);
                bundle.putInt("hue", hue);
                bundle.putInt("brightness", brightness);
                bundle.putInt("saturation", saturation);
                myIntent.putExtras(bundle);
                MainActivity.this.startActivity(myIntent);
                finish();
            }
        });

        Button buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // make pop up that asks if user is sure, then actually delete the design
            }
        });
    }
}
