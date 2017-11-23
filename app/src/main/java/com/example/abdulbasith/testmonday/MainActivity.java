package com.example.abdulbasith.testmonday;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.abdulbasith.testmonday.data.component.IActivityComponent;
import com.example.abdulbasith.testmonday.data.network.AppDataManager;
import com.example.abdulbasith.testmonday.data.network.model.GameDataModel;
import com.example.abdulbasith.testmonday.ui.gameData.GameDataPresenter;
import com.example.abdulbasith.testmonday.ui.gameData.IGameDataMVPView;
import com.example.abdulbasith.testmonday.ui.utility.rx.AppSchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity implements IGameDataMVPView {

//    public IActivityComponent getiActivityComponent(){
//        return
//    }

    GameDataPresenter<IGameDataMVPView> gameDataMVPViewGameDataPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_main);

        gameDataMVPViewGameDataPresenter = new GameDataPresenter<>(
                new AppDataManager(),
                new AppSchedulerProvider(),
                new CompositeDisposable());

        gameDataMVPViewGameDataPresenter.onAttach(this);
        gameDataMVPViewGameDataPresenter.onViewPrepared();

        super.onCreate(savedInstanceState);
    }



    @Override
    public void onFetchDataCompleted(GameDataModel gameDataModel) {

        Log.i("GameData -->",gameDataModel.getData().toString());

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @SuppressLint("LongLogTag")
    @Override
    public void onError(String message) {
        Log.i("This is GameData error Activity -->", message);

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }
}
