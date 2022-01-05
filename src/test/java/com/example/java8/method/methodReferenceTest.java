package com.example.java8.method;

import com.example.java8.Greeting;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class methodReferenceTest {

    @Test
    public void methodReferenceExample() {
        Greeting greeting = new Greeting();
        UnaryOperator<String> staticMethod = Greeting::hi; // 스태틱 메서드 참조 방법
        UnaryOperator<String> instanceMethod = greeting::hello; // 인스턴스 메서드 참조 방법

        Supplier<Greeting> newGreeting = Greeting::new; // 생성자
        Greeting greeting1 = newGreeting.get();

        Function<String, Greeting> jyjGreeting = Greeting::new;
        jyjGreeting.apply("abcd");

        String[] names = {"c", "b", "a"};
        Arrays.sort(names, String::compareToIgnoreCase);
    }
}
