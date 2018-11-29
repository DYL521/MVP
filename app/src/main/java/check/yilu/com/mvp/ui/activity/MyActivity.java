package check.yilu.com.mvp.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import check.yilu.com.mvp.R;
import check.yilu.com.mvp.bean.User;
import check.yilu.com.mvp.mvp.presenter.LoginPresenter;
import check.yilu.com.mvp.mvp.view.LoginView;

public class MyActivity extends Activity implements LoginView, View.OnClickListener {
    private EditText et_name;
    private EditText et_passwd;
    private Button btn_login;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        et_name = findViewById(R.id.et_name);
        et_passwd = findViewById(R.id.et_passwd);
        btn_login = findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenter();
        loginPresenter.bind(this);

        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                Log.e("aaa: ", "点击1111");
                loginPresenter.login();
                break;
        }
    }

    @Override
    public String getAccount() {
        return et_name.getText().toString();
    }

    @Override
    public String getPasswd() {
        return et_passwd.getText().toString();
    }


    @Override
    public void loginSuccess(User user) {
        Toast.makeText(this, "登录成功！！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNetworkError() {
        Toast.makeText(this, "网络问题！！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showVerifyFailed() {
        Toast.makeText(this, "登录失败!!!", Toast.LENGTH_SHORT).show();
    }
}
