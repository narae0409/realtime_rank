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
    //String keyword = "initial";
    final Bundle bundle = new Bundle();
    TextView Rank1, Rank2, Rank3, Rank4, Rank5, Rank6, Rank7, Rank8, Rank9, Rank10;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rank1 = (TextView)findViewById(R.id.rank1);
        Rank2 = (TextView)findViewById(R.id.rank2);
        Rank3 = (TextView)findViewById(R.id.rank3);
        Rank4 = (TextView)findViewById(R.id.rank4);
        Rank5 = (TextView)findViewById(R.id.rank5);
        Rank6 = (TextView)findViewById(R.id.rank6);
        Rank7 = (TextView)findViewById(R.id.rank7);
        Rank8 = (TextView)findViewById(R.id.rank8);
        Rank9 = (TextView)findViewById(R.id.rank9);
        Rank10 = (TextView)findViewById(R.id.rank10);

        Linkify.TransformFilter transform = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher match, String url) {
                return "";
            }
        };

        Handler handler1 = new Handler() {
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                if (bundle == null) {
                    Rank1.setText(" null");
                }
                else if (bundle != null) {
                    Rank1.setText("1. " + bundle.getString("message"));
                    String keyword = bundle.getString("message");
                    Pattern ptn = Pattern.compile(keyword);
                    Linkify.addLinks(Rank1, ptn, address+keyword, null, transform);
                }
                else {
                    Rank1.setText("error!");
                }

            }
        };

        new Thread(() -> {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("title");
                Element ele = elements.get(1);
                msg = ele.text();
                bundle.putString("message", msg);
                Message msg = handler1.obtainMessage();
                msg.setData(bundle);
                handler1.sendMessage(msg);


            } catch (IOException e) {
                e.printStackTrace();
                Rank1.setText("fail");
            }


        }).start();

        Handler handler2 = new Handler() {
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                if (bundle == null) {
                    Rank2.setText(" null");
                }
                else if (bundle != null) {
                    Rank2.setText("2. " + bundle.getString("message"));
                    String keyword = bundle.getString("message");
                    Pattern ptn = Pattern.compile(keyword);
                    Linkify.addLinks(Rank2, ptn, address+keyword, null, transform);
                }
                else {
                    Rank2.setText("error!");
                }

            }
        };

        new Thread(() -> {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("title");
                Element ele = elements.get(2);
                msg = ele.text();
                bundle.putString("message", msg);
                Message msg = handler2.obtainMessage();
                msg.setData(bundle);
                handler2.sendMessage(msg);


            } catch (IOException e) {
                e.printStackTrace();
                Rank2.setText("fail");
            }


        }).start();

        Handler handler3 = new Handler() {
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                if (bundle == null) {
                    Rank3.setText(" null");
                }
                else if (bundle != null) {
                    Rank3.setText("3. " + bundle.getString("message"));
                    String keyword = bundle.getString("message");
                    Pattern ptn = Pattern.compile(keyword);
                    Linkify.addLinks(Rank3, ptn, address+keyword, null, transform);
                }
                else {
                    Rank3.setText("error!");
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
                Message msg = handler3.obtainMessage();
                msg.setData(bundle);
                handler3.sendMessage(msg);


            } catch (IOException e) {
                e.printStackTrace();
                Rank3.setText("fail");
            }


        }).start();

        Handler handler4 = new Handler() {
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                if (bundle == null) {
                    Rank4.setText(" null");
                }
                else if (bundle != null) {
                    Rank4.setText("4. " + bundle.getString("message"));
                    String keyword = bundle.getString("message");
                    Pattern ptn = Pattern.compile(keyword);
                    Linkify.addLinks(Rank4, ptn, address+keyword, null, transform);
                }
                else {
                    Rank4.setText("error!");
                }

            }
        };

        new Thread(() -> {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("title");
                Element ele = elements.get(4);
                msg = ele.text();
                bundle.putString("message", msg);
                Message msg = handler4.obtainMessage();
                msg.setData(bundle);
                handler4.sendMessage(msg);


            } catch (IOException e) {
                e.printStackTrace();
                Rank4.setText("fail");
            }


        }).start();

        Handler handler5 = new Handler() {
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                if (bundle == null) {
                    Rank5.setText(" null");
                }
                else if (bundle != null) {
                    Rank5.setText("5. " + bundle.getString("message"));
                    String keyword = bundle.getString("message");
                    Pattern ptn = Pattern.compile(keyword);
                    Linkify.addLinks(Rank5, ptn, address+keyword, null, transform);
                }
                else {
                    Rank5.setText("error!");
                }

            }
        };

        new Thread(() -> {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("title");
                Element ele = elements.get(5);
                msg = ele.text();
                bundle.putString("message", msg);
                Message msg = handler5.obtainMessage();
                msg.setData(bundle);
                handler5.sendMessage(msg);


            } catch (IOException e) {
                e.printStackTrace();
                Rank5.setText("fail");
            }


        }).start();

        Handler handler6 = new Handler() {
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                if (bundle == null) {
                    Rank6.setText(" null");
                }
                else if (bundle != null) {
                    Rank6.setText("6. " + bundle.getString("message"));
                    String keyword = bundle.getString("message");
                    Pattern ptn = Pattern.compile(keyword);
                    Linkify.addLinks(Rank6, ptn, address+keyword, null, transform);
                }
                else {
                    Rank6.setText("error!");
                }

            }
        };

        new Thread(() -> {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("title");
                Element ele = elements.get(6);
                msg = ele.text();
                bundle.putString("message", msg);
                Message msg = handler6.obtainMessage();
                msg.setData(bundle);
                handler6.sendMessage(msg);


            } catch (IOException e) {
                e.printStackTrace();
                Rank6.setText("fail");
            }


        }).start();

        Handler handler7 = new Handler() {
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                if (bundle == null) {
                    Rank7.setText(" null");
                }
                else if (bundle != null) {
                    Rank7.setText("7. " + bundle.getString("message"));
                    //Rank7.setText("7. ");
                    String keyword = bundle.getString("message");
                    Pattern ptn = Pattern.compile(keyword);
                    Linkify.addLinks(Rank7, ptn, address+keyword, null, transform);
                }
                else {
                    Rank7.setText("error!");
                }

            }
        };

        new Thread(() -> {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("title");
                Element ele = elements.get(7);
                msg = ele.text();
                bundle.putString("message", msg);
                Message msg = handler7.obtainMessage();
                msg.setData(bundle);
                handler7.sendMessage(msg);


            } catch (IOException e) {
                e.printStackTrace();
                Rank7.setText("fail");
            }


        }).start();

        Handler handler8 = new Handler() {
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                if (bundle == null) {
                    Rank8.setText(" null");
                }
                else if (bundle != null) {
                    Rank8.setText("8. " + bundle.getString("message"));
                    String keyword = bundle.getString("message");
                    Pattern ptn = Pattern.compile(keyword);
                    Linkify.addLinks(Rank8, ptn, address+keyword, null, transform);
                }
                else {
                    Rank8.setText("error!");
                }

            }
        };

        new Thread(() -> {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("title");
                Element ele = elements.get(8);
                msg = ele.text();
                bundle.putString("message", msg);
                Message msg = handler8.obtainMessage();
                msg.setData(bundle);
                handler8.sendMessage(msg);


            } catch (IOException e) {
                e.printStackTrace();
                Rank8.setText("fail");
            }


        }).start();

        Handler handler9 = new Handler() {
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                if (bundle == null) {
                    Rank9.setText(" null");
                }
                else if (bundle != null) {
                    Rank9.setText("9. " + bundle.getString("message"));
                    String keyword = bundle.getString("message");
                    Pattern ptn = Pattern.compile(keyword);
                    Linkify.addLinks(Rank9, ptn, address+keyword, null, transform);
                }
                else {
                    Rank9.setText("error!");
                }

            }
        };

        new Thread(() -> {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("title");
                Element ele = elements.get(9);
                msg = ele.text();
                bundle.putString("message", msg);
                Message msg = handler9.obtainMessage();
                msg.setData(bundle);
                handler9.sendMessage(msg);


            } catch (IOException e) {
                e.printStackTrace();
                Rank9.setText("fail");
            }


        }).start();

        Handler handler10 = new Handler() {
            public void handleMessage(Message msg) {
                Bundle bundle = msg.getData();
                if (bundle == null) {
                    Rank10.setText(" null");
                }
                else if (bundle != null) {
                    Rank10.setText("10. " + bundle.getString("message"));
                    String keyword = bundle.getString("message");
                    Pattern ptn = Pattern.compile(keyword);
                    Linkify.addLinks(Rank10, ptn, address+keyword, null, transform);
                }
                else {
                    Rank10.setText("error!");
                }

            }
        };

        new Thread(() -> {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select("title");
                Element ele = elements.get(10);
                msg = ele.text();
                bundle.putString("message", msg);
                Message msg = handler10.obtainMessage();
                msg.setData(bundle);
                handler10.sendMessage(msg);


            } catch (IOException e) {
                e.printStackTrace();
                Rank10.setText("fail");
            }


        }).start();

    }
}