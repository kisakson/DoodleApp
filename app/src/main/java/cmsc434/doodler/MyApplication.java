package cmsc434.doodler;

import android.app.Application;
import android.graphics.Paint;
import android.graphics.Path;

import java.util.ArrayList;

public class MyApplication extends Application {

    private static MyApplication singleInstance;
    private ArrayList<Paint> paints;
    private ArrayList<Path> paths;
    private int size;
    private int hue;
    private int brightness;
    private int saturation;
    private int opacity;
    private int numPaths;

    public void onCreate() {
        super.onCreate();
        MyApplication.singleInstance = (MyApplication)getApplicationContext();
        size = 20;
        hue = 0;
        brightness = 0;
        saturation = 0;
        opacity = 255;
        numPaths = 0;
    }

    public static MyApplication getStaticApplicationContext() {
        return singleInstance;
    }

    public void setPaints(ArrayList<Paint> paints) {
        this.paints = paints;
    }

    public ArrayList<Paint> getPaints() {
        return paints;
    }

    public void setPaths(ArrayList<Path> paths) {
        this.paths = paths;
    }

    public ArrayList<Path> getPaths() {
        return paths;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getHue() {
        return hue;
    }

    public void setHue(int hue) {
        this.hue = hue;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public int getOpacity() {
        return opacity;
    }

    public void setOpacity(int opacity) {
        this.opacity = opacity;
    }

    public int getNumPaths() {
        return numPaths;
    }

    public void setNumPaths(int numPaths) {
        this.numPaths = numPaths;
    }
}
