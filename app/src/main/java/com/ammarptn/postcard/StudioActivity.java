package com.ammarptn.postcard;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class StudioActivity extends AppCompatActivity {

    private static final String TAG = "StudioActivity";
    private PostCardView postCardView;
    private EditText PostCardEditText;
    private TextView postcardText;
    private ImageView postcardImageview;
    private RelativeLayout postCardLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studio);
        
        String imgPath = getIntent().getExtras().get("img").toString();



        Log.d(TAG, "onCreate: "+imgPath);



        postCardLayout = (RelativeLayout)findViewById(R.id.postcard_Layout);
        postcardText = (TextView) findViewById(R.id.postcard_text);
        postcardImageview = (ImageView)findViewById(R.id.postcard_imageView);

        Glide.with(getApplicationContext())
                .load(new File(imgPath))
                .into(postcardImageview);


        PostCardEditText = (EditText)findViewById(R.id.editText);
        PostCardEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                postcardText.setText(PostCardEditText.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



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
            SaveBackground(screenShot(postCardLayout));
            Snackbar.make(postCardLayout, "save", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public Bitmap screenShot(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),
                view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);
        return bitmap;
    }

    private void SaveBackground(Bitmap bitmap) {

        File WillowPromoDir = new File(Environment.getExternalStorageDirectory(), "/postcard");
        boolean dirCre = createDirIfNotExists(WillowPromoDir.toString());

        Time mTime = new Time();
        mTime.setToNow();
        File initPicture = new File(WillowPromoDir, "postcard"+mTime.year+mTime.month+mTime.monthDay+mTime.hour+mTime.minute+mTime.second+".jpg");


        Log.d(TAG,"save image at"+initPicture);

        try {

            FileOutputStream outStream = new FileOutputStream(initPicture);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
            outStream.flush();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
            Log.d(TAG, "SaveBackground: bitmap is null");
        }



    }

    public  boolean createDirIfNotExists(String path) {

        Log.d(TAG,"createDirIfNotExists");
        boolean ret = true;

        File file = new File(path);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                Log.e("TravellerLog :: ", "Problem creating Image folder");
                ret = false;
            }
        }
        return ret;
    }
}
