package org.alexsandrov.spring.rest.entity;

public class Person {
    private int id;
    private String name;
    private String lastName;
    private byte age;

    public Person() {
    }

    public Person(int id, String name, String lastName, byte age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public byte getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
