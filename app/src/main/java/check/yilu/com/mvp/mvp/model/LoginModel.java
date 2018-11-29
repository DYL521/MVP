package check.yilu.com.mvp.mvp.model;

import check.yilu.com.mvp.bean.User;

public class LoginModel {

    public void login(String name, String passwd, OnLoginResultListener onLoginResultListener) {

        if ("aa".equals(name) && "123456".equals(passwd)) {
            onLoginResultListener.loginSuccess(new User(name, passwd));
        } else {
            onLoginResultListener.loginFailure();
        }
    }


    public interface OnLoginResultListener {
        void loginSuccess(User user);

        void loginFailure();
    }
}
