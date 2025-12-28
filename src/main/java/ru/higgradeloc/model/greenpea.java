package ru.higgradeloc.model;

public class greenpea extends person {

    public greenpea(String name) {
        super(name);
    }

    public void bow() {
        System.out.println(this.name + " пытается отвесить глубокий поклон, но его не замечают.");
    }

    public void jumpAndDangleLegs() {
        System.out.println(this.name + " подпрыгивает как можно выше.");
        System.out.println(this.name + " подобострастно дрыгает ногами в воздухе.");
    }

    @Override
    public void performAction() {
        bow();
        jumpAndDangleLegs();
    }
}