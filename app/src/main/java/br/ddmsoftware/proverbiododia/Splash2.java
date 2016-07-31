package br.ddmsoftware.proverbiododia;

import br.ddmsoftware.proverbiododia.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class Splash2 extends Activity implements Runnable {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * If set, will toggle the system UI visibility upon interaction. Otherwise,
     * will show the system UI visibility upon interaction.
     */
    private static final boolean TOGGLE_ON_CLICK = true;

    /**
     * The flags to pass to {@link SystemUiHider#getInstance}.
     */
    private static final int HIDER_FLAGS = SystemUiHider.FLAG_HIDE_NAVIGATION;

    /**
     * The instance of the {@link SystemUiHider} for this activity.
     */
    private SystemUiHider mSystemUiHider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hiding Title Bar and Setting FullScreen Mode
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash2);

        // Code to Change Wallpaper dinamically, according to the environment Language
        // DDM code
        String lang = Locale.getDefault().getDisplayLanguage();

        Toast.makeText(Splash2.this, lang.toString(), Toast.LENGTH_SHORT).show();

        FrameLayout internalFrameLayout = (FrameLayout) findViewById(R.id.frameSplash2);

        if ((lang.equals("pt") == false ) && (lang.equals("português") == false)){
            internalFrameLayout.setBackgroundResource(R.drawable.bootsplash_1280x720_en);
        } else {
            internalFrameLayout.setBackgroundResource(R.drawable.bootsplash_1280x720);
        }


        Handler h = new Handler();

        h.postDelayed(this, 2000);

    }

    public void run(){
        startActivity(new Intent(this, MainActivity.class));
        finish();

    }
}
