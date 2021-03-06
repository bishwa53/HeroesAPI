package com.e.heroes.api;

import com.e.heroes.model.Heroes;
import com.e.heroes.model.ImageResponse;
import com.e.heroes.model.LoginSignupResponse;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface HeroesApi {

    @POST("heroes")
    Call<Void> addHero(@Body Heroes heroes);

    @FormUrlEncoded
    @POST("heroes")
    Call<Void> addHero(@Field("name") String name,@Field("desc") String description,@Field("image") String imageName);

    @FormUrlEncoded
    @POST("heroes")
    Call<Void> addHero(@FieldMap Map<String,String> name);

    @Multipart
    @POST("upload")
    Call<ImageResponse> uploadImage(@Part MultipartBody.Part img);

    @GET("heroes")
    Call<List<Heroes>> getAllHeroes();

    @FormUrlEncoded
    @POST("users/login")
    Call<LoginSignupResponse> checkUser(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("users/signup")
    Call<LoginSignupResponse> registerUser(@Field("username") String username, @Field("password") String password);

}
