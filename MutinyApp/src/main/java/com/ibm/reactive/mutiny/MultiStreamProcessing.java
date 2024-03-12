package com.ibm.reactive.mutiny;

import io.smallrye.mutiny.Multi;

public class MultiStreamProcessing {
    public static void main(String[] args) {
        Multi.createFrom()
                .range(1, 25)
                .onItem()
                .transform(i -> i * 3)
                .filter(j -> j % 2 != 0)
                .subscribe()
                .with(System.out::println);
    }
}
