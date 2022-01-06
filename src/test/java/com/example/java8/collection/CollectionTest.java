package com.example.java8.collection;

import com.sun.deploy.net.MessageHeader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionTest {

    private List<String> name = new ArrayList<>();

    @Test
    public void abc() {
        addList();

        List<String> c = name.stream()
                .map(String::toLowerCase)
                .filter(s -> s.startsWith("c"))
                .collect(Collectors.toList());

        System.out.println("name = " + name);
        System.out.println("c = " + c);

    }

    @Test
    public void comparator() {
        addList();



    }

    public void addList() {
        name.add("aa");
        name.add("bb");
        name.add("cc");
        name.add("dd");
    }
}
