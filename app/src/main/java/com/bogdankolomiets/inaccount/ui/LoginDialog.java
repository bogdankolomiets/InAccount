package com.bogdankolomiets.inaccount.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.bogdankolomiets.inaccount.BuildConfig;
import com.bogdankolomiets.inaccount.R;

/**
 * @author bogdan
 * @version 1
 * @date 31.03.17
 */

public class LoginDialog extends Dialog {
    private final String mUrl;
    private final OAuthDialogListener mOAuthDialogListener;
    private ProgressDialog mSpinner;
    private WebView mWebView;

    public LoginDialog(@NonNull Context context, String url, OAuthDialogListener oAuthDialogListener) {
        super(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        mUrl = url;
        mOAuthDialogListener = oAuthDialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_dialog);
        mSpinner = new ProgressDialog(getContext());
        mSpinner.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mSpinner.setMessage("Loading...");
        setupWebView();
    }

    private void setupWebView() {
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.setVerticalScrollBarEnabled(false);
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setWebViewClient(new OAuthWebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(mUrl);
    }

    private class OAuthWebViewClient extends WebViewClient {

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url = request.getUrl().toString();
            return shouldOverrideUrlLoading(url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return shouldOverrideUrlLoading(url);
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            mOAuthDialogListener.onError(error.getDescription().toString());
            LoginDialog.this.dismiss();
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            mOAuthDialogListener.onError(description);
            LoginDialog.this.dismiss();
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            mSpinner.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mSpinner.dismiss();
        }

        private boolean shouldOverrideUrlLoading(String url) {
            if (url.startsWith(BuildConfig.REDIRECT_URI)) {
                String code = url.split("=")[1];
                LoginDialog.this.dismiss();
                mOAuthDialogListener.onComplete(code);
                return true;
            }

            return false;
        }
    }
}
