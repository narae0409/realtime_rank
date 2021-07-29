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
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    String address = "https://search.naver.com/search.naver?query=";
    String url = "https://trends.google.com/trends/trendingsearches/daily/rss?geo=KR";
    String msg;
    static String keyword = "initial";
    final Bundle bundle = new Bundle();
    TextView Rank1, textView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rank1 = (TextView)findViewById(R.id.rank1);
        textView = findViewById(R.id.rank2);

        Rank1.setText(keyword);

        Pattern ptn = Pattern.compile(keyword);

        Linkify.TransformFilter transform = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher match, String url) {
                return "";
            }
        };

        Linkify.addLinks(Rank1, ptn, address+keyword, null, transform);
        Linkify.addLinks(textView, ptn, address+keyword, null, transform);

        Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                if (bundle == null) {
                    textView.setText(" null");
                } else if (bundle != null) {
                    textView.setText(bundle.getString("message"));
                    keyword = bundle.getString("message");
                } else {
                    textView.setText("error!");
                }

            }
        };



        new Thread(() -> {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("title");
                Element ele = elements.get(3);
                msg = ele.text();
                bundle.putString("message", msg);
                Message msg = handler.obtainMessage();
                msg.setData(bundle);
                handler.sendMessage(msg);


            } catch (IOException e) {
                e.printStackTrace();
                textView.setText("fail");
            }


        }).start();

    }
}