package ru.higgradeloc.model;

import java.util.Objects;

public abstract class person {
    protected String name;

    public person(String name) {
        this.name = name;
    }

    public void say(String phrase) {
        System.out.println(this.name + " говорит: \"" + phrase + "\"");
    }

    // Абстрактный метод (требование задания)
    public abstract void performAction();

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person person = (person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}