package com.example.abdulbasith.testmonday.data.network;

import com.example.abdulbasith.testmonday.data.network.model.GameDataModel;
import com.example.abdulbasith.testmonday.data.network.service.ConnectionService;
import com.example.abdulbasith.testmonday.data.network.service.IRequestInterface;

import io.reactivex.Observable;

/**
 * Created by Abdul Basith on 20/11/2017.
 */

public class AppApiHelper implements IApiHelper {
    private IRequestInterface requestInterface;

    public AppApiHelper() {
        this.requestInterface = ConnectionService.getConnectionService();
    }

    @Override
    public Observable<GameDataModel> getGameData() {
        return null;
    }
}
