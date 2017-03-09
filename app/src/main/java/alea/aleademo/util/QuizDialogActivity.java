package alea.aleademo.util;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;


import alea.aleademo.BaseActivity;
import alea.aleademo.DialogActivity;
import alea.aleademo.ListViewActivity;

import alea.aleademo.ViewPagerActivity;
import alea.aleademo.bean.Book;
import alea.aleademo.dialog.CustomDialog;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import alea.aleademo.R;

import static alea.aleademo.R.id.bt1;
import static alea.aleademo.R.style.dialog;

public class QuizDialogActivity extends BaseActivity {

    private int checkedID;


    @BindView(R.id.rdg_quiz)
    RadioGroup radioGroup;
    @OnClick(R.id.okay_bt)
    public void okClick(){
        switch (checkedID){
            case R.id.quiz_rb1:
                bt1Dialog();
                break;
            case R.id.quiz_rb2:
                bt2Dialog();
                break;
            default:
        }
    }

    @OnClick(R.id.cancel_bt)
        public void onClick(View v) {
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





    private void bt2Dialog() {
        toActivity(ListViewActivity.class);
    }


    private void bt1Dialog() {
                Intent intent = new Intent(this, DialogActivity.class);
                startActivityForResult(intent, 2);
    }

    private void QuizDialog(){
        CustomDialog quizDialog = new CustomDialog(this, new CustomDialog.ICustomDialogEventListener() {
            @Override
            public void OnClickListener() {
                toastShort("Okay button was clicked");
            }
        });
        quizDialog.show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dialog);
        ButterKnife.bind(this);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId){
                toastShort("You checked the RadioButton" +checkedId);
                checkedID = checkedId;
            }
        });

    }
}
