package com.example.paymentlist.rest.mapper;

import com.example.paymentlist.model.PaymentMethod;
import com.example.paymentlist.rest.NetworkResponseMapper;
import com.example.paymentlist.rest.data.GetPaymentMethodsResponse;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodResponseMapper implements NetworkResponseMapper<List<PaymentMethod>, GetPaymentMethodsResponse> {
    @Override
    public List<PaymentMethod> ModelFromEntity(GetPaymentMethodsResponse getPaymentMethodsResponse) {
        List<PaymentMethod> paymentMethods = new ArrayList<>();


        List<GetPaymentMethodsResponse.Applicable> applicables = getPaymentMethodsResponse.getNetworks().getApplicable();
        for (GetPaymentMethodsResponse.Applicable applicable : applicables) {
            PaymentMethod paymentMethod = new PaymentMethod(
                    applicable.getLinks().getLogo(),
                    applicable.getLabel()
            );

            paymentMethods.add(paymentMethod);
        }


        return paymentMethods;
    }
}
