package cmsc434.doodler;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    int size;
    int hue;
    int brightness;
    int saturation;
    //int opacity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent intentValues = getIntent();
        Bundle bundleValues = intentValues.getExtras();
        size = bundleValues.getInt("size");
        hue = bundleValues.getInt("hue");
        brightness = bundleValues.getInt("brightness");
        saturation = bundleValues.getInt("saturation");

        Button buttonSettings = (Button) findViewById(R.id.buttonOK);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SettingsActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("size", size);
                bundle.putInt("hue", hue);
                bundle.putInt("brightness", brightness);
                bundle.putInt("saturation", saturation);
                myIntent.putExtras(bundle);
                SettingsActivity.this.startActivity(myIntent);
                finish();
            }
        });

        SeekBar seekSize = (SeekBar) findViewById(R.id.seekBarSize);
        seekSize.setProgress(size);
        seekSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                size = i;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // do anything?
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SettingsActivity.this,"Size is now " + size,
                        Toast.LENGTH_SHORT).show();
            }
        });

        SeekBar seekHue = (SeekBar) findViewById(R.id.seekBarHue);
        seekHue.setProgress(hue);
        seekHue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                hue = i;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // do anything?
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SettingsActivity.this,"Hue is now " + hue,
                        Toast.LENGTH_SHORT).show();
            }
        });

        SeekBar seekBright = (SeekBar) findViewById(R.id.seekBarBright);
        seekBright.setProgress(brightness);
        seekBright.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                brightness = i;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // do anything?
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SettingsActivity.this,"Brightness is now " + brightness,
                        Toast.LENGTH_SHORT).show();
            }
        });

        SeekBar seekSatr = (SeekBar) findViewById(R.id.seekBarSatr);
        seekSatr.setProgress(saturation);
        seekSatr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                saturation = i;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // do anything?
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SettingsActivity.this,"Saturation is now " + saturation,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
