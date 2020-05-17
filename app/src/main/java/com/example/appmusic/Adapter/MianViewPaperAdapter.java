package com.example.appmusic.Adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MianViewPaperAdapter extends FragmentPagerAdapter {
    //Ta se tao ra hai mang
    // Mang thu nhat de gan vao fragment

    private ArrayList<Fragment> arrayFragment = new ArrayList<>();// cap phat bo nho
    private ArrayList<String> arraytitle =  new ArrayList<>();//khi ta vuot ben duoi tab thi hien thi cac title,hien thi ten cua cac tab


    public MianViewPaperAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {// khi tra ve viewpaper tra ve baao nhieu fragment

        return arrayFragment.get(position);
    }

    @Override
    public int getCount() {//co bao nhieu fragment
        return arrayFragment.size();
    }

    //Add vao fragment
    public void addFragment(Fragment fragment, String title)
    {
        arrayFragment.add(fragment);
        arraytitle.add(title);
    }


    //khi add viewpaper roi, lam sao de hien thi ten
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arraytitle.get(position);
    }
}
