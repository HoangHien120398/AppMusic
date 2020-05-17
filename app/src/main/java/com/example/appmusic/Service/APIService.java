package com.example.appmusic.Service;

//de ket hop lai voi nhau giuwa retrofit va Dataserver(giao dien)

// Day la phan tuong tac voi server de doc du lieu ve

public class APIService {
    // Dau tien ket noi voi retrofit de tuong tac voi server

    private static String base_url = "https://appmusichien.000webhostapp.com/Server/";

    //Tiep theo ta se tao mot funtion der ket noi Retrofit va DataService lai voi nhau

    public static DataService getService()
    {
        return APIRetrofitClient.getClient(base_url).create(DataService.class);//Nhan du lieu sau do tra ve

    }
}
