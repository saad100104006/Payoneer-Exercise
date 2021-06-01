package com.example.paymentlist.ui.main.ViewModelTest;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;

import com.example.paymentlist.rest.ApiServiceClient;
import com.example.paymentlist.rest.data.GetPaymentMethodsResponse;
import com.example.paymentlist.viewmodel.MainViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import io.reactivex.rxjava3.core.Observable;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class NewsViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Mock
    ApiServiceClient apiClient;
    @Mock
    private MainViewModel viewModel;
    @Mock
    Observable<GetPaymentMethodsResponse> paymentMethodsResponseObservable;
    @Mock
    private Observer<Boolean> observer;
    @Mock
    LifecycleOwner lifecycleOwner;
    Lifecycle lifecycle;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lifecycle = new LifecycleRegistry(lifecycleOwner);
        viewModel = new MainViewModel();
        viewModel.loadingStatus.observeForever(observer);
    }

    @Test
    public void testNull() {
        when(apiClient.getPaymentMethods()).thenReturn(null);
        assertNotNull(viewModel.loadingStatus);
         assertTrue(viewModel.loadingStatus.hasObservers());
    }

    @Test
    public void testApiFetchDataSuccess() {
        // Mock API response
        when(apiClient.getPaymentMethods()).thenReturn((paymentMethodsResponseObservable));
        viewModel.loadPaymentMethods();
        verify(observer).onChanged(false);
    }


    @Test
    public void testApiFetchDataError() {
        when(apiClient.getPaymentMethods()).thenReturn(Observable.error(new Throwable("Api error")));
        viewModel.loadPaymentMethods();
        verify(observer).onChanged(true);
    }

    @After
    public void tearDown() throws Exception {
        apiClient = null;
        viewModel = null;
    }
}