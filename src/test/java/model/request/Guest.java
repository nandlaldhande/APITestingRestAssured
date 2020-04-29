/*
 * Copyright (c) 2020.
 * All rights reserved.
 */

package model.request;

public class Guest {
    private String type;
    private Integer age;

    public Guest(String type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "type='" + type + '\'' +
                ", age=" + age +
                '}';
    }
}
