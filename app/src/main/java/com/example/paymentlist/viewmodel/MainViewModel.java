package com.example.paymentlist.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.paymentlist.model.PaymentMethod;
import com.example.paymentlist.rest.Api;
import com.example.paymentlist.rest.mapper.PaymentMethodResponseMapper;
import com.example.paymentlist.utils.SingleLiveEvent;

import java.net.UnknownHostException;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class MainViewModel extends ViewModel {

    public final CompositeDisposable compositeDisposable = new CompositeDisposable();
    public final MutableLiveData<Boolean> loadingStatus = new MutableLiveData<>(false);
    public final SingleLiveEvent<String> errorMessageSingleEvent = new SingleLiveEvent<>();
    public LiveData<List<PaymentMethod>> paymentMethodsLiveData = new MutableLiveData<>();
    public SingleLiveEvent<String> errorMessageLiveEvent = getErrorMessageSingleEvent();
    private final PaymentMethodResponseMapper paymentMethodResponseMapper = new PaymentMethodResponseMapper();
    public MutableLiveData<List<PaymentMethod>> paymentMethodsMutableLiveData = new MutableLiveData<List<PaymentMethod>>();


    public void loadPaymentMethods() {
        Disposable getPaymentMethodsDisposable = Api.getInstance().getApiServiceClient().getPaymentMethods()
                .doOnSubscribe(disposable -> setLoadingStatus(true))
                .doFinally(() -> setLoadingStatus(false))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getPaymentMethodsResponse -> {
                    List<PaymentMethod> paymentMethods = paymentMethodResponseMapper.ModelFromEntity(getPaymentMethodsResponse);
                    paymentMethodsMutableLiveData.postValue(paymentMethods);
                }, throwable -> {
                    if (throwable instanceof UnknownHostException) {
                        showErrorMessage("Unable to fetch data. Please check your internet connection and try again");
                    } else {
                        showErrorMessage(throwable.getLocalizedMessage());
                    }
                    throwable.printStackTrace();
                });

        addDisposable(getPaymentMethodsDisposable);
    }

    public void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    protected void setLoadingStatus(Boolean loadingStatus) {
        this.loadingStatus.postValue(loadingStatus);
    }

    protected void showErrorMessage(String errorMessage) {
        errorMessageSingleEvent.setValue(errorMessage);
    }

    public SingleLiveEvent<String> getErrorMessageSingleEvent() {
        return errorMessageSingleEvent;
    }

}