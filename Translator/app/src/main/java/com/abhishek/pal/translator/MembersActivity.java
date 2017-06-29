package com.abhishek.pal.translator;

//import android.support.v7.app.AppCompatActivity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<word> num = new ArrayList<word>();
        word n=new word("Father","Baba",R.drawable.family_father);
        num.add(n);                     //This is a two line input. From the next addition we will do it inline
        num.add(new word("Mother","Maa",R.drawable.family_mother));
        num.add(new word("Son","Chele",R.drawable.family_son));
        num.add(new word("Daughter","Meye",R.drawable.family_daughter));
        num.add(new word("Elder Brother","Dada",R.drawable.family_older_brother));
        num.add(new word("Younger Brother ","Bhai",R.drawable.family_younger_brother));
        num.add(new word("Elder Sister","Didi",R.drawable.family_older_sister));
        num.add(new word("Younger Sister","Bon",R.drawable.family_younger_sister));
        num.add(new word("Grandmother","Didima",R.drawable.family_grandmother));
        num.add(new word("Granddad","Dadu",R.drawable.family_grandfather));

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
        wordadapter adapter = new wordadapter(this, num,R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}


