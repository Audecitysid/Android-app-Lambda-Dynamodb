package com.example.bee;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BeeAPI {

    @GET("crud")
    Call<Post> getPosts(@Query("StatusCode") int statusCode, @Query("uid") String uid);

    @GET("crud")
    Call<PostSignup> signup(@Query("StatusCode") int statusCode, @Query("uid") String uid, @Query("name") String name, @Query("password") String password, @Query("isvalid") String isValid);

    @GET("crud")
    Call<PostAddbank> addBank(@Query("StatusCode") int statusCode, @Query("uid") String uid,
                              @Query("bank") String bank, @Query("branch") String branch,
                              @Query("accno") String accountNumber, @Query("ifsc") String IFSC,
                              @Query("phno") String phoneNumber, @Query("atmno") String ATM);

    @GET("crud")
    Call<PostUPI_Interface> transferAmount(@Query("StatusCode") int statusCode, @Query("uid") String uid,
                                           @Query("source_acc") String sourceAccount, @Query("destination_acc") String destinationAccount,
                                           @Query("amount") int amount, @Query("atmno") String atmNo);

    @GET("crud")
    Call<PostBankshow1Activity> verify(@Query("StatusCode") int statusCode, @Query("accno") String accountNumber);


    @GET("crud")
    Call<PostBankshow1Activity> closeacc(@Query("StatusCode") int statusCode, @Query("accno") String accountNumber , @Query("atmno") String atmNo);

    @GET("crud")
    Call<PostDisplay_Bank> seeBank(@Query("StatusCode") int statusCode, @Query("accno") String accountNumber);



    /*
    @GET("posts")
    Call<List<Post>> getPosts();
    */
    /*
    This particular method is responsible for getting a list of posts
    */

}
