package com.example.appmusic.Service;


// DataService dung de gui phuwong thuc va tra du lieu tu phia server ve

import com.example.appmusic.Model.Quangcao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {

    @GET("banner.php")
    //nhan du lieu
    Call<List<Quangcao>> GetDataBanner();
}
