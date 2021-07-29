package com.example.realtime_rank;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.util.Linkify;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    String address = "https://search.naver.com/search.naver?query=";
    String url = "https://trends.google.com/trends/trendingsearches/daily/rss?geo=KR";
    String msg;
    final Bundle bundle = new Bundle();
    TextView Rank1, textView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rank1 = (TextView)findViewById(R.id.rank1);
        textView = findViewById(R.id.rank2);

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

        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                textView.setText(bundle.getString("message"));
            }
        };



        new Thread(() -> {
            try {
                Document doc = Jsoup.connect(url).get();
                Element elements = doc.select("item title").first();
                msg = elements.text(); // error occurred from Document to element.
                //msg = "sample";
                bundle.putString("message", msg);
                Message msg = handler.obtainMessage();
                msg.setData(bundle);
                handler.sendMessage(msg);

            } catch (IOException e) {
                e.printStackTrace();
                textView.setText("fail2");
            }


        }).start();

    }
}