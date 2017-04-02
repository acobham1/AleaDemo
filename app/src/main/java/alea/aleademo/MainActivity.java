package alea.aleademo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import alea.aleademo.bean.Book;
import alea.aleademo.util.QuizDialogActivity;
import alea.aleademo.util.TimerActivity;
import alea.aleademo.util.UtilLog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnTouchListener {

    private ImageButton bt1;
    private ImageButton bt3;
    int counter = 0;
    private GestureDetector mGestureDirector;

    @BindView(R.id.hw_4)
    LinearLayout linearHw4;


    @BindView(R.id.main_fl) FrameLayout fl;


    @OnClick(R.id.button_left)
    public void toLeftButton(){
        setContentView(R.layout.homework_4);
//
// if(counter==0){
//            ObjectAnimator animator = ObjectAnimator.ofFloat(linearHw4,"translationX", 0, 950, 950, 950, 950);
//            animator.setDuration(1000);
//            animator.start();
//            counter++;
//        }
//        else{
//            ObjectAnimator animator = ObjectAnimator.ofFloat(linearHw4, "translationX", 950, 0, 0, 0, 0);
//            animator.setDuration(1000);
//            animator.start();
//            counter=0;
//        }
    }

    @OnClick(R.id.quiz_four_bt)
    public void toQuiz4Button(){
        Intent intent = new Intent(this, QuizDialogActivity.class);
        startActivityForResult(intent, 5);
    }

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
                toastShort("Quiz 4 Dialog Activity");
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
                mGestureDirector.onTouchEvent(event);
        return true;
    }
    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        public boolean onDown(MotionEvent e){
            UtilLog.logD("MyGesture", "onDown");
            toastShort( "onDown");
            return true;
        }
        public void onShowPress(MotionEvent e){
            UtilLog.logD("MyGesture", "onShowPress");
            toastShort( "onShowPress");

            ;

        }
        public void onLongPress(MotionEvent e){
            UtilLog.logD("MyGesture", "onLongPress");
            toastShort( "onLongPress");

        }
        public boolean onSingleTapUp(MotionEvent e){
            UtilLog.logD("MyGesture", "onSingleTapUp");
            toastShort( "onSingleTapUp");
            return true;
        }
        public boolean onSingleTapConfirmed(MotionEvent e){
            UtilLog.logD("MyGesture", "onSingleTapConfirmed" + e);
            toastShort( "onSingleTapConfirmed");
            if(counter == 1){
                ObjectAnimator animator = ObjectAnimator.ofFloat(linearHw4, "translationX", 950, 0, 0, 0);
                animator.setDuration(1000);
                counter=0;
                animator.start();
            }
            return true;
        }
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
            UtilLog.logD("MyGesture", "onScroll:" + (e2.getX() -e1.getX()) + "  " +distanceX);
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "onScroll" ,Toast.LENGTH_SHORT);
            toast.show();
            return true;
        }
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float VelocityY){
            UtilLog.logD("MyGesture", "onFling" + (e1.getY() - e2.getY() + " " + velocityX));
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "onFling" ,Toast.LENGTH_SHORT);

            if(counter == 0){
                ObjectAnimator animator = ObjectAnimator.ofFloat(linearHw4, "translationX", 0, 1000, 950, 950, 950);
                animator.setDuration(1000);
                animator.start();
                counter++;
            }else{
                ObjectAnimator animator = ObjectAnimator.ofFloat(linearHw4, "translationX", 950, 0, 0, 0, 0);
                animator.setDuration(1000);
                animator.start();
                counter=0;
            }
            toast.show();

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

