package com.aoslec.hybrid01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    WebView webView = null;
    Button btnReload, btnPage1, btnPage2, btnPage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        btnReload = findViewById(R.id.btn_reload);
        btnPage1 = findViewById(R.id.btn_page1);
        btnPage2 = findViewById(R.id.btn_page2);
        btnPage3 = findViewById(R.id.btn_page3);

        btnReload.setOnClickListener(onClickListener);
        btnPage1.setOnClickListener(onClickListener);
        btnPage2.setOnClickListener(onClickListener);
        btnPage3.setOnClickListener(onClickListener);

        //Web Setting
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // JavaScript 사용 여부
        webSettings.setBuiltInZoomControls(true); // 확대 축소 사용 여부
        webSettings.setDisplayZoomControls(false); // 돋보기 사용 여부

        //Link 시 다른 Brower 안보이게
        webView.setWebViewClient(new WebViewClient(){
            @Override
            // Page가 띄워질 때
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                btnReload.setText("로딩 중...");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                btnReload.setText(webView.getTitle());
            }
        });

        webView.loadUrl("https://www.naver.com"); // default 로딩 값

    }

    //뒤로가기 눌렀을 시, 자동 앱종료 방지 & 이전화면으로 이동
    //이전화면이 없을 시 앱 종료
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            finish();
        }
    }


    //버튼 클릭에 따라, 페이지 이동
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_page1:
                    webView.loadUrl("https://www.naver.com");
                    btnPage1Click();
                    break;
                case R.id.btn_page2:
                    webView.loadUrl("https://www.google.com");
                    break;
                case R.id.btn_page3:
                    webView.loadUrl("https://www.daum.net");
                    break;
                default:
                    break;
            }

        }
    };

    public void btnPage1Click(){
        webView.loadUrl("https://192.168.0.78:8080/test/Arithmetic.jsp");
    //본인 ip 쓰기
    };



}