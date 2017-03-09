//package alea.aleademo.dialog;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.annotation.StyleRes;
//
//import alea.aleademo.R;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//
///**
// * Created by aleac on 3/8/2017.
// */
//
//public class QuizDialog extends Dialog {
//     private QuizDialog.ICustomDialogEventListener quizListener;
//
//    @OnClick(R.id.quiz_four_bt)
//    public void okClick(){
//        quizListener.OnClickListener();
//        dismiss();
//    }
//
//
//    public QuizDialog(@NonNull Context context, QuizDialog.ICustomDialogEventListener listener) {
//        super(context, R.style.dialog);
//        this.quizListener = quizListener;
//    }
//
//    public abstract void OnClickListener();
//
//
//    public interface ICustomDialogEventListener{
//        public void quizDialogEvent();
//        public void OnClickListener();
//        public void quizDialogEventTwo();
//
//    }
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_quiz_dialog);
//        ButterKnife.bind(this);
//
//    }
//}
//
