package com.example.stone.designsupportdemo;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class test1Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> datalist = new ArrayList<String>();
    Toolbar toolbar;
    DeAdapter mAdapter;
    EditText editText1,editText2;
    TextInputLayout input1,input2;
    CoordinatorLayout coord;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        recyclerView = (RecyclerView)findViewById(R.id.test1_recycler_view);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        coord = (CoordinatorLayout)findViewById(R.id.main_content);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        input1 = (TextInputLayout)findViewById(R.id.input1);
        input2 = (TextInputLayout)findViewById(R.id.input2);
        input1.setHint("test1");
        input2.setHint("test2");
        input1.setErrorEnabled(true);
        input2.setErrorEnabled(true);
        setListener();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new DeAdapter(datalist);
        setSupportActionBar(toolbar);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    void setListener(){

        coord.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 5) {
                    input1.setError("需要4個字以上");
                    input1.setErrorEnabled(true);
                } else {
                    input1.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()<8){
                    input2.setError("需要8個字以上");
                    input2.setErrorEnabled(true);
                }else{
                    input2.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!input1.isErrorEnabled()&&!input2.isErrorEnabled()){
                    mAdapter.add(editText1.getText().toString());
                    mAdapter.add(editText2.getText().toString());
                }
            }
        });
    }
}
