package tv.lightingsystems.flashapp.policy

import android.content.Context
import android.webkit.WebView

class MyPolicyView(context: Context) : WebView(context){

    fun startPolicyInitialization(){

        webViewClient = MyWebViewClient()
        webChromeClient = MyWebChromeClient()


    }

}