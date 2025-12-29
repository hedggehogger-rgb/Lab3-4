package ru.higgradeloc.model;

import ru.higgradeloc.enums.intensity;
import ru.higgradeloc.exceptions.StructuralDamageException;
import ru.higgradeloc.interfaces.shake;

public class tomato extends person {

    public tomato(String name) {
        super(name);
    }

    @Override
    public void performAction() {
        System.out.println(this.name + " надувается от злости и краснеет.");
    }

    public void growl() {
        System.out.println(this.name + " издает грозное, звериное рычание: \"Р-р-р-а-а!\"");
    }

    public void grab(Object obj) {
        System.out.println(this.name + " хватает обеими руками " + obj.toString());
    }

    public void shake(shake target) throws StructuralDamageException {
        if (target == null) {
            throw new IllegalArgumentException("Нечего трясти! Цель отсутствует.");
        }

        System.out.println(this.name + " начинает трясти объект изо всех сил.");
        target.beShaken(intensity.max);
    }
}
