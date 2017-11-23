package com.example.abdulbasith.testmonday.data.network;

import com.example.abdulbasith.testmonday.data.network.model.GameDataModel;

import io.reactivex.Observable;

/**
 * Created by Abdul Basith on 20/11/2017.
 */

public class AppDataManager implements IDataManager{

    IApiHelper iApiHelper;

    public AppDataManager() {
        this.iApiHelper = new AppApiHelper();
    }

    @Override
    public Observable<GameDataModel> getGameData() {
        return iApiHelper.getGameData();
    }
}
