package com.example.paymentlist.ui.main.ApiTest;


import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.example.paymentlist.rest.Api;
import com.example.paymentlist.viewmodel.MainViewModel;

import junit.framework.Assert;

import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static junit.framework.TestCase.assertEquals;


@RunWith(MockitoJUnitRunner.class)

public final class PaymentApiTest {
    @NotNull
    private final TestRule testInstantTaskExecutorRule = (TestRule) (new InstantTaskExecutorRule());
    private MainViewModel viewModel;
    @Mock
    private Observer observer;
    private MockWebServer mockWebServer;
    CompositeDisposable compositeDisposable;

    @Rule
    @NotNull
    public final TestRule getTestInstantTaskExecutorRule() {
        return this.testInstantTaskExecutorRule;
    }

    @Before
    public final void setUp() {
        try {
            MockitoAnnotations.initMocks(this);
            viewModel = new MainViewModel();
            viewModel.paymentMethodsLiveData.observeForever(observer);
            mockWebServer = new MockWebServer();
            compositeDisposable = new CompositeDisposable();
            mockWebServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public final void read_sample_success_json_file/* $FF was: read sample success json file*/() {
        ResponseFileReader reader = new ResponseFileReader("success_response.json");
        Assert.assertNotNull(reader.getContent());
    }

    @Test
    public final void check_response_code_200_returned() {
        // Assign
        MockResponse response = new MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(new ResponseFileReader("success_response.json").getContent());
        mockWebServer.enqueue(response);

        Disposable getPaymentMethodsDisposable = Api.getInstance().getApiServiceClient().getPaymentMethods()
                .subscribe(getPaymentMethodsResponse -> {
                    assertEquals(response.toString().contains("200"), getPaymentMethodsResponse.toString().contains("200"));

                }, throwable -> {
                    if (throwable instanceof UnknownHostException) {

                    } else {
                    }

                    throwable.printStackTrace();
                });

        compositeDisposable.add(getPaymentMethodsDisposable);

    }


    @Test
    public final void check_response_Code_400_returned() {

        // Assign
        MockResponse response = new MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .setBody(new ResponseFileReader("failed_response.json").getContent());
        mockWebServer.enqueue(response);


        Disposable getPaymentMethodsDisposable = Api.getInstance().getApiServiceClient().getPaymentMethods()
                .subscribe(getPaymentMethodsResponse -> {
                    assertEquals(response.toString().contains("400"), getPaymentMethodsResponse.toString().contains("400"));

                }, throwable -> {
                    if (throwable instanceof UnknownHostException) {

                    } else {
                    }

                    throwable.printStackTrace();
                });

        compositeDisposable.add(getPaymentMethodsDisposable);
    }


    @Test
    public final void check_response_Code_500_returned() {

        // Assign
        MockResponse response = new MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_INTERNAL_ERROR)
                .setBody(new ResponseFileReader("failed_response.json").getContent());
        mockWebServer.enqueue(response);


        Disposable getPaymentMethodsDisposable = Api.getInstance().getApiServiceClient().getPaymentMethods()
                .subscribe(getPaymentMethodsResponse -> {
                    assertEquals(response.toString().contains("500"), getPaymentMethodsResponse.toString().contains("500"));

                }, throwable -> {
                    if (throwable instanceof UnknownHostException) {

                    } else {
                    }

                    throwable.printStackTrace();
                });

        compositeDisposable.add(getPaymentMethodsDisposable);
    }


    @After
    public final void tearDown() {
        try {
            viewModel.paymentMethodsLiveData.removeObserver(observer);
            mockWebServer.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

