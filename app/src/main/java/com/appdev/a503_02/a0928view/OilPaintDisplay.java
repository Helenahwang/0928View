package com.appdev.a503_02.a0928view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class OilPaintDisplay extends AppCompatActivity {

    //스레드를 anonymous class를 이용해서 만든 것인데 anonymous class는 지역변수를 사용할수 없다.
    ImageView imgView3;
    Bitmap bitmap;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil_paint_display);

        //xml 없이 java만 통해서 출력
        ImageView imgView2 = (ImageView)findViewById(R.id.imgview2);
        imgView2.setImageResource(R.drawable.sunflower);


        imgView3 = (ImageView) findViewById(R.id.imgview3);

        url = "http://sandwichbikes.com/wp-content/uploads-sandwichbikes/2016/04/van-Gogh-Irises.jpg";

        Thread th = new Thread() {
            public void run() {

                try

                {
                    //웹에서 데이터를 가져올 수 있는 스트림 생성
                    InputStream is = new URL(url).openStream();

                    //스트림의 데이터를 이미지로 변경
                    bitmap = BitmapFactory.decodeStream(is);


                } catch (
                        Exception e)

                {
                    //로그 출력하기
                    Log.e("이미지 URL", e.getMessage());
                }
            }


        };
        // 스레드 시작
        th.start();


        //스레드의 수행이 종료하면 이미지를 설정
        try{
            //스레드 수행이 종료될 때까지 대기
            th.join();
            imgView3.setImageBitmap(bitmap);

        }catch (Exception e){}
    }
}
