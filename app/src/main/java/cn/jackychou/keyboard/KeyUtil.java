package cn.jackychou.keyboard;

import android.app.Activity;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;

/**
 * Created by Jacky on 2017/8/31.
 */

public class KeyUtil {
    private Context mContext;//上下文对象
    private KeyboardView mKeyboardView;//这个主角怎么能丢？
    private Keyboard mKeyboard;//好吧，其实他也是主角
    private KeyView keyView;

    /**
     * 必须activity作为上下文对像 *
     *
     * @param context
     */
    public KeyUtil(Context context) {
        mContext = context;
        //初始化键盘布局，下面在放进 KeyBoardView里面去。
        mKeyboard = new Keyboard(mContext, R.xml.number);
        keyView = (KeyView) mContext;
        //配置keyBoardView
        mKeyboardView = ((Activity) context).findViewById(R.id.kv_number);
        mKeyboardView.setKeyboard(mKeyboard); //装甲激活~ 咳咳…
        mKeyboardView.setPreviewEnabled(false);   //这个是，效果图按住是出来的预览图。

        //设置监听，不设置的话会报错。监听放下面了。
        mKeyboardView.setOnKeyboardActionListener(mListener);
    }


    /**
     * onPress: 按下触发。
     * onRelease：松开触发。
     * onKey ： 松开触发，在OnRelease之前触发。
     * swipeLeft : 左滑动，其他同理。哈哈~就这么懒。
     * onText ：需要在键盘xml，也就是我此时的number.xml里面中key标签对里添加一个keyOutputText的属性，打印出来的就是它的值。
     */

    //监听
    private KeyboardView.OnKeyboardActionListener mListener = new KeyboardView.OnKeyboardActionListener() {

        @Override
        public void onPress(int primaryCode) {

        }

        @Override
        public void onRelease(int primaryCode) {

        }

        @Override
        public void onKey(int primaryCode, int[] keyCodes) {
            //primaryCode 的值是code的值
            keyView.change(primaryCode);
        }

        @Override
        public void onText(CharSequence charSequence) {

        }

        @Override
        public void swipeLeft() {

        }

        @Override
        public void swipeRight() {

        }

        @Override
        public void swipeDown() {

        }

        @Override
        public void swipeUp() {

        }

    };

}
