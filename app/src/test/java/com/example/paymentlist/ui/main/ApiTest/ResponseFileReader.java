package com.example.paymentlist.ui.main.ApiTest;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStreamReader;

import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;

public class ResponseFileReader {
    @NotNull
    private  String content;

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public ResponseFileReader(String path) {

        try {
            Intrinsics.checkParameterIsNotNull(path, "path");
            ClassLoader classLoader = this.getClass().getClassLoader();
            InputStreamReader reader = new InputStreamReader(classLoader != null ? classLoader.getResourceAsStream(path) : null);
            this.content = TextStreamsKt.readText(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

