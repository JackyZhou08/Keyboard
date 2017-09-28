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
        //隐藏系统的键盘
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            et_number.setShowSoftInputOnFocus(false);
        } else {
            try {
                Class<EditText> cls = EditText.class;
                Method setSoftInputShownOnFocus;
                setSoftInputShownOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setSoftInputShownOnFocus.setAccessible(true);
                setSoftInputShownOnFocus.invoke(et_number, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
