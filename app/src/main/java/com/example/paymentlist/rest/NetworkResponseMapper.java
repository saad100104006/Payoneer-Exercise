package com.example.paymentlist.rest;

public interface NetworkResponseMapper<Model, Entity> {
    Model ModelFromEntity(Entity entity);
}
