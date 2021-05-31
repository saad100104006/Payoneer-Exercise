package com.example.paymentlist.model;

public class PaymentMethod {
    private String imageUrl;
    private String label;

    public PaymentMethod(String imageUrl, String label) {
        this.imageUrl = imageUrl;
        this.label = label;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "imageUrl='" + imageUrl + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
