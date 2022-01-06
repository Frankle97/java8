package com.example.java8.iterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class IteratorTest {

    List<String> name = new ArrayList<>();

    @Test
    public void forEach() {
        addList();

        name.forEach(System.out::println);
        name.forEach(s -> {
            System.out.println("s = " + s);
        });
    }

    @Test
    public void spliterator() {
        addList();

        Spliterator<String> spliterator = name.spliterator();
        while (spliterator.tryAdvance(System.out::println));

    }

    private void addList() {
        name.add("a");
        name.add("b");
        name.add("c");
        name.add("d");
    }

}
