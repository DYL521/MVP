package check.yilu.com.mvp.mvp.view;

import check.yilu.com.mvp.bean.User;

public interface LoginView {

    String getAccount();

    String getPasswd();

    void loginSuccess(User user);

    void showNetworkError();

    void showVerifyFailed();

}
