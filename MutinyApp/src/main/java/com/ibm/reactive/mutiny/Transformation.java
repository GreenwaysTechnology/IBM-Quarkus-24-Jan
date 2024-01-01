package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class Transformation {
    public static void main(String[] args) {
        Uni.createFrom()
                .item("hello")
                .onItem()
                .transform(message -> message.toUpperCase())
                .onItem()
                .transform(msg -> msg + " SUBRAMNAIAN")
                .subscribe()
                .with(System.out::println);
    }
}
