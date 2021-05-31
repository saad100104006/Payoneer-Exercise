package com.example.paymentlist.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paymentlist.databinding.MainFragmentBinding;
import com.example.paymentlist.utils.VerticalSpaceItemDecoration;
import com.example.paymentlist.viewmodel.MainViewModel;
import com.google.android.material.snackbar.Snackbar;


public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";

    private MainFragmentBinding binding;
    private MainViewModel mViewModel;
    private PaymentListAdapter paymentListAdapter = new PaymentListAdapter();

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MainFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        binding.recyclerView.addItemDecoration(new VerticalSpaceItemDecoration());
        binding.recyclerView.setAdapter(paymentListAdapter);

        mViewModel.loadPaymentMethods();

        mViewModel.paymentMethodsMutableLiveData.observe(getViewLifecycleOwner(), paymentMethods -> {
            paymentListAdapter.submitList(paymentMethods);
        });

        mViewModel.loadingStatus.observe(getViewLifecycleOwner(), loadingStatus -> {
            if (loadingStatus) {
                binding.progressBar.setVisibility(View.VISIBLE);
            } else {
                binding.progressBar.setVisibility(View.GONE);
            }
        });

        mViewModel.errorMessageLiveEvent.observe(getViewLifecycleOwner(), errorMessage -> {
            Snackbar.make(requireView(), errorMessage, Snackbar.LENGTH_LONG).show();
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}