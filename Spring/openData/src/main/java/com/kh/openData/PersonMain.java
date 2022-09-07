package com.kh.openData;

import java.util.*;

public class PersonMain {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동", 10);
        Person p2 = new Person("홍길동", 20);
        Person p3 = new Person("홍길동", 30);
        Person p4 = new Person("홍길동", 40);
        System.out.println(p1);
        System.out.println(p1.getName());
        p1.setAge(10*10);

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);

        Set<Person> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);

        Map<String,Person> map = new HashMap<>();
        map.put("1", p1);
        map.put("2", p2);
        map.put("3", p3);
        map.put("4", p4);


        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
    }
}
