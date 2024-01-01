package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Multi;

public class ProcessingStream {
    public static void main(String[] args) {
        Multi.createFrom().range(1, 25).log()
                .filter(item -> item % 2 == 0)
                .select().distinct().select().first(3)
                .subscribe().with(System.out::println);
    }
}
