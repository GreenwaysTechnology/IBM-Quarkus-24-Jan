package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Uni;

public class FirstProgram {
    public static void main(String[] args) {
        Uni.createFrom().item("Hello").subscribe().with(data -> {
            System.out.println(data);
        });
    }
}
