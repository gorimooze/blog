package com.itproger.blog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String full_name, position;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Person(String full_name, String position) {
        this.full_name = full_name;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
