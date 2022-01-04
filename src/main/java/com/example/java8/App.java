package com.example.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class App {

    public static void main(String[] args) {
        String[] names = {"KEESUN", "WHITESHIP", "TOBY"};
        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

    }

}
