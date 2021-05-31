package com.example.paymentlist.utils;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.atomic.AtomicBoolean;

public class SingleLiveEvent<T> extends MutableLiveData<T> {

    private LiveData<T> liveDataToObserve;
    private final AtomicBoolean mPending = new AtomicBoolean(false);

    public SingleLiveEvent() {
        final MediatorLiveData<T> outputLiveData = new MediatorLiveData<>();
        outputLiveData.addSource(this, currentValue -> {
            outputLiveData.setValue(currentValue);
            mPending.set(false);
        });
        liveDataToObserve = outputLiveData;
    }


    @MainThread
    @Override
    public void observe(@NonNull @NotNull LifecycleOwner owner, @NonNull @NotNull Observer<? super T> observer) {
        liveDataToObserve.observe(owner, t -> {
            if (mPending.get()) {
                observer.onChanged(t);
            }
        });
    }

    @MainThread
    public void setValue(T value) {
        mPending.set(true);
        super.setValue(value);
    }
}
