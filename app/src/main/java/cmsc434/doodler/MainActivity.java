package cmsc434.doodler;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int size;
    private int hue;
    private int brightness;
    private int saturation;
    private int opacity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        size = MyApplication.getStaticApplicationContext().getSize();
        hue = MyApplication.getStaticApplicationContext().getHue();
        brightness = MyApplication.getStaticApplicationContext().getBrightness();
        saturation = MyApplication.getStaticApplicationContext().getSaturation();
        opacity = MyApplication.getStaticApplicationContext().getOpacity();

        Intent gotIntent = getIntent();
        if (gotIntent != null && gotIntent.getStringExtra("toastMessage") != null) {
            Toast.makeText(MainActivity.this, gotIntent.getStringExtra("toastMessage"),
                    Toast.LENGTH_SHORT).show();
        }

        final DoodleView doodleView = (DoodleView) findViewById(R.id.doodleView);
        doodleView.setPaint(size, hue, saturation, brightness, opacity);
        ArrayList<Paint> paints = MyApplication.getStaticApplicationContext().getPaints();
        ArrayList<Path> paths = MyApplication.getStaticApplicationContext().getPaths();
        if (paints != null && paths != null) {
            doodleView.recreateDrawings(paints, paths);
        }

        Button buttonSettings = (Button) findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Paint> paints = doodleView.getPaints();
                ArrayList<Path> paths = doodleView.getPaths();
                MyApplication.getStaticApplicationContext().setPaints(paints);
                MyApplication.getStaticApplicationContext().setPaths(paths);
                Intent myIntent = new Intent(MainActivity.this, SettingsActivity.class);
                MainActivity.this.startActivity(myIntent);
                finish();
            }
        });

        Button buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                doodleView.clear();
                                break;
                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure? This cannot be undone.").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        });
    }

}
