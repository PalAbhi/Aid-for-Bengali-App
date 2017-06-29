package com.abhishek.pal.translator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        final TextView t1 = (TextView) findViewById(R.id.numbers);
        //The long cut code to start another intent is
        //NumberOnclickListener nc=new NumberOnclickListener();
        //t.setOnClickListener(nc);
        //Now you have to make a separate class Number NumberOnclickListener() which goes as follows:
        //public class NumberOnclickListener implements View.OnClickListener{
        //@Override
        //public void onClick(View view)
        //{
        //    Intent i = new Intent(this, NumbersActivity.class);
        //   startActivity(i);
        //}
        //The shortcut code is below
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View t1) {
                startActivity(new Intent(MainActivity.this, NumbersActivity.class)); //Shortcut to directly call another intent
                Toast.makeText(t1.getContext(), "Now lets view the Numbers", Toast.LENGTH_SHORT).show();
            }
        });
        //Similarly for other modules such as Colors,Family Members,Phrases
        TextView t2 = (TextView) findViewById(R.id.colors);
        TextView t3 = (TextView) findViewById(R.id.family);
        TextView t4 = (TextView) findViewById(R.id.phrases);
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View t2) {
                startActivity(new Intent(MainActivity.this, ColorsActivity.class));
                Toast.makeText(t2.getContext(), "Now lets view the Colors", Toast.LENGTH_SHORT).show();
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View t3) {
                startActivity(new Intent(MainActivity.this, MembersActivity.class));
                Toast.makeText(t3.getContext(), "Now lets view the Family Members", Toast.LENGTH_SHORT).show();
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View t4) {
                startActivity(new Intent(MainActivity.this, PhrasesActivity.class));
                Toast.makeText(t4.getContext(), "Now lets view the Phrases", Toast.LENGTH_SHORT).show();
            }
        });
    }


}