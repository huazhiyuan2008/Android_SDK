Android_SDK
===========

根据实际使用遇见的bug: 当本地没有装腾讯微博客户端是，进行webview授权登录，onAuthPassed不被调用

给出解决方案：替换Account.java和WeiboToken.java；

使用方法：

    @Override
    public void onWeiBoNotInstalled() {            
        Intent i = new Intent(activity, Authorize.class);
        i.putExtra("APP_KEY", "YOUR_APP_KEY");
        i.putExtra("REDIRECT_URI", "YOUR_REDIRECT_URI");
        activity.startActivityForResult(i, 1001);
    }

同时在onActivityResult中捕捉回调

    @Override
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && mOnAuthListener != null) {
            String name = data.getStringExtra("name");
            WeiboToken token = (WeiboToken)data.getExtras().get("token");
            if (!StrUtils.isEmpty(name) && token != null) {
                mOnAuthListener.onAuthPassed(name, token);
            }
        }
    }
    
