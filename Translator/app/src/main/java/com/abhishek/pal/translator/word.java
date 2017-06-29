package com.abhishek.pal.translator;

/**
 * Created by Abhishek on 25-08-2016.
 */
public class word {
    private String mEng;
    private String mTranslate;
    private int mImid=No_image;
    private static final int No_image=-1;

    public word(String eng, String translate)
    {
        mEng=eng;
        mTranslate=translate;
    }
    public word(String eng,String Translate,int Res)
    {
        mEng=eng;
        mTranslate=Translate;
        mImid=Res;
    }

    public String getEnglish()
    {
        return mEng;
    }

    public String getTranslation()
    {
        return mTranslate;
    }

    public int getmImid()
    {
        return mImid;
    }

    public boolean isvalidimage()       //Purpose of this funtion is to check whether the view realy has some image or not
    {
        return mImid!=No_image;         //Will return 0 if there is no image
    }

}
