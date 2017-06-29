package com.abhishek.pal.translator;

//import android.support.v7.app.AppCompatActivity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<word> num = new ArrayList<word>();
        word n=new word("Where are you going?","Aapni kothai jacchen");
        num.add(n);                     //This is a two line input. From the next addition we will do it inline
        num.add(new word("What is your name","Aapnar nam ki?"));
        num.add(new word("My name is Abhishek","Amar nam Abhishek"));
        num.add(new word("How are you feeling?","Aapnar kamon lagche?"));
        num.add(new word("I am feeing good","Amar bhalo lagche"));
        num.add(new word("Are you coming?","Aapni ki aaschen?"));
        num.add(new word("Yes, I'm coming","Haa ami aaschi"));
        num.add(new word("I'm coming","Ami aaschi"));
        num.add(new word("lets go","Cholo jaya jak"));
        num.add(new word("Come here","Ekhane Eso"));

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
        wordadapter adapter = new wordadapter(this, num,R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
    }
}


