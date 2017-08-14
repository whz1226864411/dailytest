package com.creat.test;

/**
 * Created by Administrator on 2017/7/29 0029.
 */
public class Person {
    private Person person;
    public Person(Person person){
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
