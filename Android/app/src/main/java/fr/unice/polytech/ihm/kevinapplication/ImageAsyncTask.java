package fr.unice.polytech.ihm.kevinapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by thiba on 05/04/2017.
 */

public class ImageAsyncTask extends AsyncTask<String,Void,Bitmap> {

    private ImageView imageView;

    public ImageAsyncTask(ImageView imageView){
        this.imageView=imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap bmp=null;
        try{
            URL aURL = new URL(params[0]);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bmp = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();

        }
        catch (Exception e){}
        return bmp;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        imageView.setImageBitmap(result);
    }


}