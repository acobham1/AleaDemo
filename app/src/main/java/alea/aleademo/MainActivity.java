package alea.aleademo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Timer;

import alea.aleademo.R;
import alea.aleademo.bean.Book;
import alea.aleademo.util.TimerActivity;
import alea.aleademo.util.UtilLog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static alea.aleademo.R.id.bt2;
import static alea.aleademo.R.id.button_right;
import static android.R.attr.data;

public class MainActivity extends BaseActivity implements View.OnTouchListener {

    private ImageButton bt1;
    private ImageButton bt3;
    private GestureDetector mGestureDirector;

    @BindView(R.id.main_fl) FrameLayout fl;


    @OnClick(R.id.animator_bt)
    public void toAnimator(){
        toActivity(AnimatorActivity.class);
    }

   @OnClick(R.id.bt2)
    public void button2Click(){
       Intent intent = new Intent(this, DialogActivity.class);
       startActivityForResult(intent, 2);
    }

    @OnClick(R.id.main_anim_bt)
    public void toAnimation(){
        toActivity(AnimationActivity.class);
    }

    @OnClick(R.id.button_right)
    public void buttonRightClick(){
        Intent intent = new Intent(this, activity_a.class);
        startActivityForResult(intent, 4);
    }
    @OnClick(R.id.main_timer_bt)
    public void toTimer(){
        toActivity(TimerActivity.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        toastShort("onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        ButterKnife.bind(this);

        mGestureDirector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(this);
    }

    private void initialView() {
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
                intent.putExtra("key", "value");
                Bundle bundle = new Bundle();
                bundle.putInt("Integer", 12345);
                Book book = new Book();
                book.setName("Android");
                book.setAuthor("Alea");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
        bt3 = (ImageButton) findViewById(R.id.bt3);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListViewActivity.class);
                startActivityForResult(intent, 3);
                toActivity(ListViewActivity.class);
            }
        });}


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case 1:
                String message = data.getStringExtra("message");
                toastShort(message);
                break;
            case 2:
                toastShort("Dialog");
                break;
            case 3:
                toastShort("ListView");
                break;
            case 4: toastShort("ABCD Activity");
                break;
            case 5:
                toastShort("Timer Activity");
            default:
        }
    }

    public void onClick(View v) {
        //Toast.makeText(this ,"Button2 was clicked",Toast.LENGTH_LONG).show();
        toastLong("Button2 was clicked");
        UtilLog.logD("testD", "Toast");
        //Log.d("testD", "Toast");
    }
    @Override
    public boolean onTouch(View v, MotionEvent event){
        return mGestureDirector.onTouchEvent(event);
    }
    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        public boolean onDown(MotionEvent e){
//            UtilLog.logD("MyGesture", "onDown");
//            toastShort( "onDown");
            return false;
        }
        public void onShowPress(MotionEvent e){
//            UtilLog.logD("MyGesture", "onShowPress");
//            toastShort( "onShowPress");
        }
        public void onLongPress(MotionEvent e){
//            UtilLog.logD("MyGesture", "onLongPress");
//            toastShort( "onLongPress");
        }
        public boolean onSingleTapUp(MotionEvent e){
            UtilLog.logD("MyGesture", "onSingleTapUp");
            toastShort( "onSingleTapUp");
            return true;
        }
        public boolean onSingleTapConfirmed(MotionEvent e){
            UtilLog.logD("MyGesture", "onSingleTapConfirmed");
            toastShort( "onSingleTapConfirmed");
            return true;
        }
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
            UtilLog.logD("MyGesture", "onScroll:" + (e2.getX() -e1.getX()) + "  " +distanceX);
            toastShort( "onScroll");
            return true;
        }
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float VelocityY){
            toastShort( "onFling");
            return true;
        }
        public boolean onDoubleTap(MotionEvent e){
            toastShort( "onDoubleTap");
            return true;
        }
        public boolean onDoubleTapEvent(MotionEvent e){
            toastShort( "onDoubleTapEvent");
            return true;
        }
    }
}

