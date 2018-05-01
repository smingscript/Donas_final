package com.kcci.emmi.donasmainview;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class IntroActivity extends AppCompatActivity {
    ArrayList<HashMap<String, String>> tkykPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                intent.putExtra("tkykPoints", tkykPoints);
                startActivity(intent);
            }
        }, 3000); //인텐트 넘어가는 시간 지정해주기

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ImageView star1 = (ImageView) findViewById(R.id.star1);
        final Animation ani1 = AnimationUtils.loadAnimation(IntroActivity.this, R.anim.rotate);

        ani1.setStartOffset(2000);
        ani1.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.anim.decelerate_interpolator));

        star1.startAnimation(ani1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    tkykPoints = threadMethod();

                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //Parsing XML to map locations on Google map
    private ArrayList<HashMap<String,String>> threadMethod() throws XmlPullParserException, IOException {
        StringBuffer buffer = new StringBuffer();

        InputStream ins = getResources().openRawResource(getResources().getIdentifier("takoyaki", "raw", getPackageName()));
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(ins, "utf-8");

        String tag = "";
        int eventType = xpp.getEventType();

        boolean isStartTag = false;
        ArrayList<HashMap<String, String>> searchContents = new ArrayList<>();

        HashMap<String, String> placeMarkContent = null;
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    tag = xpp.getName();
                    if (tag.equals("Placemark")) {
                        placeMarkContent = new HashMap<>();
                    } else if(tag.equals("name") || tag.equals("description") || tag.equals("coordinates")) {
                        isStartTag = true;
                    }

                    break;
                case XmlPullParser.TEXT:
                    String text = xpp.getText();

                    if (isStartTag && placeMarkContent != null && tag.equals("name")) {
                        placeMarkContent.put("name", text);
                    } else if (isStartTag && placeMarkContent != null && tag.equals("description")) {
                        placeMarkContent.put("description", text);
                    } else if (isStartTag && placeMarkContent != null && tag.equals("coordinates")){
                        placeMarkContent.put("coordinates", text);
                    }
                    break;
                case XmlPullParser.END_TAG:
                    tag = xpp.getName();

                    if(tag.equals("Placemark")){
                        searchContents.add(placeMarkContent);
                        placeMarkContent = null;
                    } else if(tag.equals("name") || tag.equals("description") || tag.equals("coordinates")) {
                        isStartTag = false;
                    }
                    break;
            }
            eventType = xpp.next();
        }
        return searchContents;
    }
}
