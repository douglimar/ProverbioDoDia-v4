package br.ddmsoftware.proverbiododia;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btnShare;
    Button btnNewProverb;
    ProgressDialog progressDialog;
    String language;
    LoadPortugueseImages lpi;
    LoadEnglishImages lei;
    public String full_filename;
    File file;
    Integer iLastImageLoaded = 0;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        //btnNewProverb = (Button) findViewById(R.id.btnNewProverb); -- onClick is invoked directly in MainActivity.xml onClick tag
        //btnShare = (Button) findViewById(R.id.btnShare); -- onClick is invoked directly in MainActivity.xml onClick tag

        // Loading in Random mode the first Image
        loadQuote(null);

        // Descomentar antes do Release Final

        // Load Advertisement Banner
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    // Method that load aleatorally a Image with a Quote
    public void loadQuote(View v){

        int iImage=0;
        //int[] aImages;

        imageView.setImageResource(0);

        language = Locale.getDefault().getLanguage();

        if (language.equals("pt")){
            lpi = new LoadPortugueseImages();

            // Load Array with All Images
            //aImages = lpi.loadQuotes();

            // Randomized function that choose one image in the Array
            iImage = lpi.getQuoteImagePt();

            // Compare with the last Quote Selected
            if (iImage == iLastImageLoaded)
                iImage = lpi.getQuoteImagePt();

            // Set Sorted Image in ImageView()
            imageView.setImageResource(iImage);

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            //onLoadActivity();

            iLastImageLoaded = iImage;
        } else {

            lei = new LoadEnglishImages();

            // Load Array with All Images
            //aImages = lpi.loadQuotes();

            // Randomized function that choose one image in the Array
            iImage = lei.getQuoteImageEn();

            // Compare with the last Quote Selected
            if (iImage == iLastImageLoaded)
                iImage = lei.getQuoteImageEn();

            // Set Sorted Image in ImageView()
            imageView.setImageResource(iImage);

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            //onLoadActivity();

            iLastImageLoaded = iImage;

        }

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


    /*
    Function that share image contained in a ImageView on Social Media Network
     */
    private void shareImage(int iRepeat){

        Bitmap bitmap;

        OutputStream output;

        // Retrieve the image selected in ImageView component
        imageView.buildDrawingCache(true);

        bitmap = imageView.getDrawingCache();

        imageView.buildDrawingCache(false);

        // Find the SD Card path
        File filepath = Environment.getExternalStorageDirectory();
        //File filepath = getExternalCacheDir(); //Environment.geteDownloadCacheDirectory(); //ExternalStorageDirectory();

        // Create a new folder in SD Card
        File dir = new File(filepath.getAbsolutePath() + "/Pictures/");
        dir.mkdirs();


        // Create a name for the saved image
        full_filename = dir.toString() +"/proverb"+ System.currentTimeMillis() + ".png";
        file = new File(dir, "proverb"+ System.currentTimeMillis() + ".png");

        try {

            // Create a New instance of a Share Intent
            Intent share = new Intent(Intent.ACTION_SEND);

            // Type of file to share
            share.setType("image/jpeg");

            output = new FileOutputStream(file);

            // Workaround - in the first execution, bitmap is null
            if (iRepeat <= 0) {
                shareImage(1);
            } else {

                // Compress into png format image from 0% - 100%
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, output);
                output.flush();
                output.close();

                // Locate the image to Share
                Uri uri = Uri.fromFile(file);

                // Pass the image into an Intnet
                share.putExtra(Intent.EXTRA_STREAM, uri);
                // temp permission for receiving app to read this file
                share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                // Show the social share chooser list
                startActivityForResult(Intent.createChooser(share, getString(R.string.share_chooser)),1);

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block

            Toast toast = Toast.makeText(getApplicationContext(), "ERROR: " + e.getMessage(), Toast.LENGTH_SHORT);
            toast.show();

            e.printStackTrace();
        }
    }

    // Function called after OnCreateChooser execute
    protected void onActivityResult(int aRequestCode, int aResultCode, Intent aData){
        super.onActivityResult(aRequestCode,aResultCode, aData);

        if (aRequestCode == 1) {

            setContentView(R.layout.activity_main);
            imageView = (ImageView) findViewById(R.id.imageView);

            // Reload Last Image before erase the image sent
            if (iLastImageLoaded >= 0 ) {
                imageView.setImageResource(iLastImageLoaded);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            }

            // Delete Image sent from the SDCard (Clear buffer)
            if (file.exists() == true)
                file.delete();
        }
    }


    // Thread to Create a Loading ProgressDialog
    public void shareImageWithProgress(View v) {

        progressDialog = ProgressDialog.show(MainActivity.this, getString(R.string.share_progress_dialog_title), getString(R.string.share_progress_dialog_message), true);

        new Thread(new Runnable() {
            @Override
            public void run() {

                // Function Share Image
                shareImage(0);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                    }
                });

            }
        }).start();
    }
}
