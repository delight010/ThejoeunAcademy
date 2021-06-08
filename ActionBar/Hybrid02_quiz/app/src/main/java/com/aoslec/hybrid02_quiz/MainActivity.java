package com.aoslec.hybrid02_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    WebView webView = null;
    Button btn_hello, btn_img_origin, btn_img_full;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        btn_hello = findViewById(R.id.btn_hello);
        btn_img_origin = findViewById(R.id.btn_img_origin);
        btn_img_full = findViewById(R.id.btn_img_full);

        btn_hello.setOnClickListener(onClickListener);
        btn_img_origin.setOnClickListener(onClickListener);
        btn_img_full.setOnClickListener(onClickListener);


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
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });

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
                case R.id.btn_hello:
//                    webView.loadUrl("https://www.naver.com");
                    btn_hello();
                    break;
                case R.id.btn_img_origin:
                    btn_img_origin();
                    break;
                case R.id.btn_img_full:
                    btn_img_full();
                    break;
                default:
                    break;
            }

        }
    };

    public void btn_hello(){
//        webView.loadUrl("https://192.168.0.133:8080/test/Arithmetic.jsp");
        //본인 ip 쓰기
        webView.loadUrl("http://192.168.0.133:8080/test/hello.html");
       }

       public void btn_img_origin(){
        webView.loadUrl("https://i.pinimg.com/170x/e3/cf/94/e3cf9449e222f8c94b9f70f94ea44f23.jpg");
       }

    public void btn_img_full(){

        webView.loadUrl("https://i.pinimg.com/170x/e3/cf/94/e3cf9449e222f8c94b9f70f94ea44f23.jpg");
        webView.getSettings().setUseWideViewPort(true);
    }

}