package alea.aleademo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.ButterKnife;
import alea.aleademo.R;
import butterknife.OnClick;

import static alea.aleademo.R.layout.abcd_activity;

/**
 * Created by aleac on 2/22/2017.
 */

public class ABCDActivity extends BaseActivity {




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(abcd_activity);
        ButterKnife.bind(this);
        initialView();

    }
    private void initialView(){

    }

        }

