package cmsc434.doodler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class SettingsActivity extends AppCompatActivity {

    int size;
    int hue;
    int brightness;
    int saturation;
    int opacity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        size = MyApplication.getStaticApplicationContext().getSize();
        hue = MyApplication.getStaticApplicationContext().getHue();
        brightness = MyApplication.getStaticApplicationContext().getBrightness();
        saturation = MyApplication.getStaticApplicationContext().getSaturation();
        opacity = MyApplication.getStaticApplicationContext().getOpacity();

        final PaintView paintView = (PaintView) findViewById(R.id.paintView);
        paintView.updatePaint(size, hue, saturation, brightness, opacity);

        Button buttonOK = (Button) findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SettingsActivity.this, MainActivity.class);
                MyApplication.getStaticApplicationContext().setSize(size);
                MyApplication.getStaticApplicationContext().setHue(hue);
                MyApplication.getStaticApplicationContext().setBrightness(brightness);
                MyApplication.getStaticApplicationContext().setSaturation(saturation);
                MyApplication.getStaticApplicationContext().setOpacity(opacity);
                myIntent.putExtra("toastMessage", "Brush updated.");
                SettingsActivity.this.startActivity(myIntent);
                finish();
            }
        });

        Button buttonCancel = (Button) findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SettingsActivity.this, MainActivity.class);
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
                paintView.updatePaint(size, hue, saturation, brightness, opacity);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        SeekBar seekHue = (SeekBar) findViewById(R.id.seekBarHue);
        seekHue.setProgress(hue);
        seekHue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                hue = i;
                paintView.updatePaint(size, hue, saturation, brightness, opacity);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        SeekBar seekBright = (SeekBar) findViewById(R.id.seekBarBright);
        seekBright.setProgress(brightness);
        seekBright.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                brightness = i;
                paintView.updatePaint(size, hue, saturation, brightness, opacity);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        SeekBar seekSatr = (SeekBar) findViewById(R.id.seekBarSatr);
        seekSatr.setProgress(saturation);
        seekSatr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                saturation = i;
                paintView.updatePaint(size, hue, saturation, brightness, opacity);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        SeekBar seekOpac = (SeekBar) findViewById(R.id.seekBarOpac);
        seekOpac.setProgress(opacity);
        seekOpac.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                opacity = i;
                paintView.updatePaint(size, hue, saturation, brightness, opacity);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }

}
