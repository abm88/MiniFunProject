package com.example.abdulbasith.testmonday.data.network.service;

import com.example.abdulbasith.testmonday.data.network.API_Constants;
import com.example.abdulbasith.testmonday.data.network.model.GameDataModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Abdul Basith on 20/11/2017.
 */

public interface IRequestInterface {
    @GET(API_Constants.BASE_URL)
    Observable<GameDataModel> getGameData();


}
