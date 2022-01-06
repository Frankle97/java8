package com.example.java8.stream;

import com.example.java8.OnlineClass;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    List<String> names = new ArrayList<>();

    @Test
    public void streamTest() {
        addList();

        List<String> collect = names.stream().map((s) -> {
            System.out.println("s = " + s);
            return s.toUpperCase();
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);

        List<String> stringList = names.stream().map(String::toUpperCase)
                .collect(Collectors.toList());
        stringList.forEach(System.out::println);
    }

    @Test
    public void streamTest2() {
        List<OnlineClass> springClasses = setOnlineClass();
        List<OnlineClass> javaClasses = setJavaClasses();

        // TODO : spring 으로 시작하는 수업
        System.out.println("-start with spring-");
        springClasses.stream().
                filter(s -> s.getTitle().startsWith("spring"))
                .forEach(o -> System.out.println(o.toString()));

        // TODO : close 되지 않은 수업
        System.out.println("-non closed class-");
        springClasses.stream()
                .filter(s -> !s.isClosed())
                .forEach(s -> System.out.println(s.toString()));

        // TODO : 수업 이름만 모아서 스트림 만들기
        System.out.println("-map of class name-");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);

        // TODO : 두 수업 목록에 들어있는 모든 수업 아이디 출력
        System.out.println("-all of classes id-");
        List<List<OnlineClass>> events = new ArrayList<>();
        events.add(springClasses);
        events.add(javaClasses);

        events.stream()
                .flatMap(Collection::stream)
                .forEach(oc -> System.out.println("oc.getId() = " + oc.getId()));

        // TODO 10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만
        System.out.println("-1 to 10 stream-");
        Stream.iterate(0, i -> i + 1)
                .skip(1)
                .limit(10)
                .forEach(System.out::println);

        // TODO 자바 수업 중 Test가 들어간 수업이 있는지 확인
        System.out.println("-java class find Test-");
        boolean test = javaClasses.stream()
                .anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println("test = " + test);

        // TODO 스프링 수업 중 제목이 spring 들어간 것 모아서 List로 만들기
        System.out.println("-spring classes-");
        List<String> spring = springClasses.stream()
                .map(OnlineClass::getTitle)
                .filter(title -> title.contains("spring"))
                .collect(Collectors.toList());

        System.out.println("spring = " + spring);

    }

    private ArrayList<OnlineClass> setJavaClasses() {
        ArrayList<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));
        return javaClasses;
    }

    private ArrayList<OnlineClass> setOnlineClass() {
        ArrayList<OnlineClass> onlineClasses = new ArrayList<>();
        onlineClasses.add(new OnlineClass(1, "spring boot", true));
        onlineClasses.add(new OnlineClass(2, "spring data jpa", false));
        onlineClasses.add(new OnlineClass(3, "spring mvc", false));
        onlineClasses.add(new OnlineClass(4, "spring core", false));
        onlineClasses.add(new OnlineClass(5, "rest api development", false));
        return onlineClasses;
    }

    private void addList() {
        names.add("aa");
        names.add("bb");
        names.add("cc");
        names.add("dd");
    }

}
