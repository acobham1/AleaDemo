package alea.aleademo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import alea.aleademo.Adapter.ListViewAdapter;
import alea.aleademo.Adapter.ViewPagerAdapter;
import alea.aleademo.R;
import alea.aleademo.fragment.ContentFragment;
import alea.aleademo.fragment.FirstFragment;
import alea.aleademo.fragment.HistoryFragment;
import alea.aleademo.fragment.LoginFragment;
import alea.aleademo.fragment.SecondFragment;
import alea.aleademo.fragment.ThirdFragment;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private ArrayList<String> listResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listResult = new ArrayList<String>();
        createFakeResult();
        initialView();

    }

    private void createFakeResult(){
        listResult.add("AAAAAAAAAAAAAAA");
        listResult.add("BBBBBBBBBBBBB");
        listResult.add("CCCCCC");
        listResult.add("DD");
        listResult.add("EEEEEEEE");
        listResult.add("F");
        listResult.add("GGGGGG");
        listResult.add("H");
        listResult.add("I");
        listResult.add("J");
        listResult.add("K");
        listResult.add("L");
        listResult.add("M");
        listResult.add("N");
        listResult.add("O");
        listResult.add("P");
        listResult.add("Q");


    }
    private void initialView() {
        listView = (ListView) findViewById(R.id.list_view);
        View view = getLayoutInflater().inflate(R.layout.list_view_header,null);

        LinearLayout listViewHeader = (LinearLayout)view.findViewById(R.id.list_view_header);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);
        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("We have no more content.");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);

        viewPager = (ViewPager) view.findViewById(R.id.view_list_view_header);
        fragmentList.add(new FirstFragment());
        fragmentList.add(new SecondFragment());
        fragmentList.add(new ThirdFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);

    }



    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "listView was clicked at position: " + position, Toast.LENGTH_SHORT).show();
        Log.d("testListViewActivity", String.valueOf(position));
    }

    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("message", "ListView");
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}