package com.example.xyzreader.ui;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.example.xyzreader.data.ArticleLoader;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private Cursor mCursor;

    public MyPagerAdapter(FragmentManager fm, Cursor cursor) {
        super(fm);
        mCursor = cursor;
    }

    @Override
    public Fragment getItem(int i) {
        mCursor.moveToPosition(i);
        return ArticleDetailFragment.newInstance(mCursor.getLong(ArticleLoader.Query._ID));
    }



    @Override
    public int getCount() {
        return (mCursor != null) ? mCursor.getCount() : 0;
    }
}
