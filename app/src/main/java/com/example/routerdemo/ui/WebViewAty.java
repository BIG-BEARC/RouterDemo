package com.example.routerdemo.ui;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.routerdemo.databinding.ActivityWebViewAtyBinding;
@Route(path = WebViewAty.PATH)
public class WebViewAty extends AppCompatActivity {
    public static final String PATH = "/test/webActivity";
    WebView webView;
    ActivityWebViewAtyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityWebViewAtyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        webView = new WebView(this);
        binding.ll.addView(webView);
        // 格式规定为:file:////android_asset/文件名.html
        webView.loadUrl("file:////android_asset/text.html");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.clearCache(true);
        webView.clearHistory();
        webView.clearFormData();
        webView.destroy();
        binding.ll.removeView(webView);
        webView = null;

    }
}