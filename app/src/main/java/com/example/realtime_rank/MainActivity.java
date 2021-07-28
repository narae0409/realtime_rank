package com.example.realtime_rank;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    String address = "https://search.naver.com/search.naver?query=";
    TextView Rank1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rank1 = (TextView)findViewById(R.id.rank1);

        Rank1.setText("new text");
        //setText, compile, addLinks.scheme 모두 같은 변수로 통일하여 적용
        //Rank1은 i로 변경하여 for문으로 반복

        Pattern ptn = Pattern.compile("new");

        Linkify.TransformFilter transform = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher match, String url) {
                return "";
            }
        };

        Linkify.addLinks(Rank1, ptn, address+"test", null, transform);

    }
}