package com.github.bean;

import java.io.Serializable;

/**
 * @author qianhao
 * @create 2020/4/15-13:33
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -6062503048061593928L;
    private transient String name;
    private int age;

    public Person() {
    }

    public Person(int age,String name) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
