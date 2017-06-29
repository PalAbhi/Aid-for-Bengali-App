package com.abhishek.pal.translator;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<word> num = new ArrayList<word>();
        word n=new word("Lal","Red",R.drawable.color_red);
        num.add(n);                     //This is a two line input. From the next addition we will do it inline
        num.add(new word("Sobuj","Green",R.drawable.color_green));
        num.add(new word("Khoire","Brown",R.drawable.color_brown));
        num.add(new word("Subhra","Gray",R.drawable.color_gray));
        num.add(new word("Kalo","Black",R.drawable.color_black));
        num.add(new word("Sada","White",R.drawable.color_white));
        num.add(new word("Holud"," Musturd Yellow",R.drawable.color_mustard_yellow));
        num.add(new word("Badami Holde","Dusty Yellow",R.drawable.color_dusty_yellow));


        //Now here comes something important. The code below will make a seperate textview for each number.
        // Suppose we have a huge number of views. Ths will use up an immense amount of memory.
        // So what we need to do is to use ListView and ArrayAdapter
        //Below is the orthodox code that will use too much of memory
        /*Remember we would have used LinearLayout for the orthodox one so here we are creating an object of LinearLayout
        LinearLayout lout = (LinearLayout) findViewById(R.id.linout);

        int i;
        for ( i = 0; i < num.size(); i++) {
            TextView t=new TextView(this);
            t.setText(num.get(i));
            lout.addView(t);
        */
        //Now the new memory saving approach


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        wordadapter adapter = new wordadapter(this, num,R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}


