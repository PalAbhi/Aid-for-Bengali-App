package com.abhishek.pal.translator;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abhishek on 25-08-2016.
 */
public class wordadapter extends ArrayAdapter<word> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param pWords A List of AndroidFlavor objects to display in a list
     */

    private int mColorId;
    public wordadapter(Context context, ArrayList<word> pWords,int ColorId)
    {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context,0, pWords);
        mColorId=ColorId;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        // Get the {@link AndroidFlavor} object located at this position in the list
        word local_word = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID text1
        TextView bengaliTextView = (TextView) listItemView.findViewById(R.id.text1);

        // Get the String from the current words object and
        // set this text on the number TextView
        bengaliTextView.setText(local_word.getTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.text2);
        defaultTextView.setText(local_word.getEnglish());

        ImageView im=(ImageView) listItemView.findViewById(R.id.im);
        if(local_word.isvalidimage()) {
            im.setImageResource(local_word.getmImid());
            im.setVisibility(View.VISIBLE);             //Suppose that the previous View had no image but this one has
                                                        //  Thats why we are setting this view as Visible irrespective of the previous View
        }
        else
        {
            im.setVisibility(View.GONE);                    //This helps the phrases class to overlook the ia=mage resource
        }

        View v=listItemView.findViewById(R.id.Linout);
        int color= ContextCompat.getColor(getContext(),mColorId);
        v.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
