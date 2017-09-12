package cn.jackychou.keyboard;

import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements KeyView {

    private EditText et_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_number = (EditText) findViewById(R.id.et_number);
        et_number.setShowSoftInputOnFocus(false);//隐藏系统的键盘
        new KeyUtil(this);
    }

    @Override
    public void change(int code) {
        int i = et_number.getSelectionStart();

        if (code != Keyboard.KEYCODE_DELETE) {
            et_number.getText().insert(i, code + "");
        } else {
            if (i != 0)
                et_number.getText().delete(i - 1, i);
        }

    }
}
