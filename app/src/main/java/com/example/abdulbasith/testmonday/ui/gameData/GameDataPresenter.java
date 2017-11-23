package com.example.abdulbasith.testmonday.ui.gameData;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.abdulbasith.testmonday.data.network.AppDataManager;
import com.example.abdulbasith.testmonday.data.network.model.GameDataModel;
import com.example.abdulbasith.testmonday.ui.base.BasePresenter;
import com.example.abdulbasith.testmonday.ui.utility.rx.SchedulerProvider;

import javax.annotation.Nonnull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Abdul Basith on 22/11/2017.
 */

public class GameDataPresenter <V extends IGameDataMVPView> extends BasePresenter<V> implements IGameDataMVPPresenter<V>{
    public GameDataPresenter(AppDataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getCompositeDisposable()
                .add(getDataManager().getGameData()
                .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<GameDataModel>() {
                                       @Override
                                       public void accept(@Nonnull GameDataModel gameDataModel) throws Exception {
                                           getMvpView().onFetchDataCompleted(gameDataModel);
                                       }
                                   },
                                new Consumer<Throwable>() {
                                    @SuppressLint("LongLogTag")
                                    @Override
                                    public void accept(@Nonnull Throwable throwable) throws Exception {
                                        getMvpView().onError(throwable.getMessage());
                                        Log.i("This is GameData Error on consumer-->", throwable.getMessage());
                                    }
                                }));


    }
}
