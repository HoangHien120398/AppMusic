package com.example.appmusic.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appmusic.Model.Quangcao;
import com.example.appmusic.R;
import com.example.appmusic.Service.APIService;
import com.example.appmusic.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Home extends Fragment {
    View view;// view de gan layout cho phan Fragment
    private static final String TAG = "Fragment_Home";

    @Nullable
    @Override
    // View nay c chuc nang gan lalyout cho fragment, sau do tuong tac
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;

    }

    private void GetData() {

        DataService dataservice = new APIService().getService();
        Call<List<Quangcao>> callback = dataservice.GetDataBanner();
        callback.enqueue(new Callback<List<Quangcao>>() {
            @Override
            public void onResponse(Call<List<Quangcao>> call, Response<List<Quangcao>> response) {
                // LẮng nghe cho việc có kết quả trả về
                ArrayList<Quangcao> banners = (ArrayList<Quangcao>) response.body();
                Log.d("BBB", banners.get(0).getTenBaiHat());
            }

            @Override
            public void onFailure(Call<List<Quangcao>> call, Throwable t) {
                Log.d(TAG, "onFailure: ");

                //Lắng nghe ch việc sự kiện dữ liệu không được gửi, thất bại

            }
        });// lawng nghe du lieu

    }
}
