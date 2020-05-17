package com.example.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;

import com.example.appmusic.Adapter.MianViewPaperAdapter;
import com.example.appmusic.Fragment.Fragment_Home;
import com.example.appmusic.Fragment.Fragment_Search;
import com.example.appmusic.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    //Đầu tiên , ta phải ánh xạ hai layout

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tạo một function cho ánh xạ lại những biến ở trên
        anhxa();
        init();//Khởi tạo
    }


    //Ham init co tac dung dua cac fragment vao trong viewPaper
    private void init()
    {
        //Khi chung ta muon su dung thi se tra ve cho no cac fragment
        MianViewPaperAdapter mianViewPaperAdapter = new MianViewPaperAdapter(getSupportFragmentManager());
        mianViewPaperAdapter.addFragment(new Fragment_Home(), "Home");
        mianViewPaperAdapter.addFragment(new Fragment_Search(),"Search");
        viewPager.setAdapter(mianViewPaperAdapter);
        //sau do se set cho phan tabLayout
        tabLayout.setupWithViewPager(viewPager);

        //Sau do set icon cho phan tim kiem va trang chu
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);

        tabLayout.getTabAt(1).setIcon(R.drawable.iconsearch);
    }

    private void anhxa()
    {

        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPaper);
    }
}
