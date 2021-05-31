package com.example.paymentlist.rest;

import com.example.paymentlist.rest.data.GetPaymentMethodsResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;


public interface ApiServiceClient {

    // user calls
    @GET("optile/checkout-android/develop/shared-test/lists/listresult.json")
    Observable<GetPaymentMethodsResponse> getPaymentMethods();
}
