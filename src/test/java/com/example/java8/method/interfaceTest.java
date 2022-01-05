package com.example.java8.method;

import com.example.java8.DefaultFoo;
import org.junit.jupiter.api.Test;

public class interfaceTest {

    @Test
    public void 테스트() {
        DefaultFoo foo = new DefaultFoo("test");
        foo.printName();
        foo.printNameUpperCase();   // interface default method
    }

}
