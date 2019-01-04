package check.yilu.com.mvp.mvp.presenter;

import android.text.TextUtils;
import android.util.Log;

import check.yilu.com.mvp.bean.User;
import check.yilu.com.mvp.ui.activity.MyActivity;
import check.yilu.com.mvp.mvp.model.LoginModel;
import check.yilu.com.mvp.mvp.view.LoginView;

public class LoginPresenter {


    // 模型
    private LoginModel mLoginModel;

    public LoginPresenter() {
        mLoginModel = new LoginModel();
    }

    // 绑定视图
    private LoginView mLoginView;

    public void bind(MyActivity loginview) {
        mLoginView = loginview;
    }

    public void login() {
        String account = mLoginView.getPasswd();
        String passwd = mLoginView.getPasswd();
        Log.e("aaaa： ", "account： " + account + "passwd: " + passwd);

        if (checkParameter(account, passwd)) {

                mLoginModel.login(account, passwd, new LoginModel.OnLoginResultListener() {
                    @Override
                    public void loginSuccess(User user) {
                        mLoginView.loginSuccess(user);
                    }

                    @Override
                    public void loginFailure() {
                        mLoginView.showVerifyFailed();
                    }
                });
        }

    }

    /**
     * 参数校验
     *
     * @param account
     * @param passd
     * @return
     */
    private boolean checkParameter(String account, String passd) {
        if (TextUtils.isEmpty(account) | TextUtils.isEmpty(passd)) {
            mLoginView.showVerifyFailed();
            return false;
        } else if (!checkNetwork()) {
            mLoginView.showNetworkError();
            return false;
        }
        return true;
    }

    /**
     * 检测网络 是否可用
     *
     * @return
     */
    public boolean checkNetwork() {
        return true;
    }
}
