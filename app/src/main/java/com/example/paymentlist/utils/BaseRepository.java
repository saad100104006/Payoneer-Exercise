package com.example.paymentlist.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public abstract class BaseRepository {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final MutableLiveData<Boolean> loadingStatus = new MutableLiveData<>(false);
    private final SingleLiveEvent<String> errorMessageSingleEvent = new SingleLiveEvent<>();


    protected void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    protected void setLoadingStatus(Boolean loadingStatus) {
        this.loadingStatus.postValue(loadingStatus);
    }

    protected void showErrorMessage(String errorMessage) {
        errorMessageSingleEvent.setValue(errorMessage);
    }


    public LiveData<Boolean> getLoadingStatus() {
        return loadingStatus;
    }


    public SingleLiveEvent<String> getErrorMessageSingleEvent() {
        return errorMessageSingleEvent;
    }


    public void clearResources() {
        compositeDisposable.clear();
    }
}
