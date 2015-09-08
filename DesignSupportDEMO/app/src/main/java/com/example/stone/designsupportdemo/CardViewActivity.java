package com.example.stone.designsupportdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class CardViewActivity extends Activity {
    TextView text1, text2;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        Intent intent = getIntent();
        LinearItem item = (LinearItem)intent.getSerializableExtra("item");
        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView2);
        image = (ImageView)findViewById(R.id.imageView);
        text1.setText(item.text1);
        text2.setText(item.text2);
        image.setImageResource(R.drawable.ie);
    }


}
