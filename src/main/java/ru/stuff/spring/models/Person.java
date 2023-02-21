package ru.stuff.spring.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Person {

    private int id;
    @NotEmpty(message = "Пустое имя")
    @Size(min = 2, max = 30, message = "Имя должно содержать от 2 до 30 символов")
    private String name;
    @Email
    @NotEmpty(message = "Пустое поле email")
    private String email;
    @Min(value = 0, message = "Возраст не может быть отрицательным")
    private int age;
    public Person() {
    }

    public Person(int id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
