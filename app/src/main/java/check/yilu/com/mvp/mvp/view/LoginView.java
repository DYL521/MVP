package check.yilu.com.mvp.mvp.view;

import check.yilu.com.mvp.bean.User;

public interface LoginView {

    String getAccount();

    String getPasswd(); // 获取密码

    void loginSuccess(User user);//显示登录成功

    void showNetworkError(); //显示网络错误

    void showVerifyFailed(); //显示认证失败

}
