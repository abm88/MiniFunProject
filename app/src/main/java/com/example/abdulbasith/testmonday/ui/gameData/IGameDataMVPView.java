package com.example.abdulbasith.testmonday.ui.gameData;

import com.example.abdulbasith.testmonday.data.network.model.GameDataModel;
import com.example.abdulbasith.testmonday.ui.base.MvpView;

import java.util.List;

/**
 * Created by Abdul Basith on 22/11/2017.
 */

public interface IGameDataMVPView extends MvpView {
    void onFetchDataCompleted(GameDataModel gameDataModel);
}
