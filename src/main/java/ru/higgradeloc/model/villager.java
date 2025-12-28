package ru.higgradeloc.model;

public class villager extends person {

    public villager(String name) {
        super(name);
    }

    public void lockDoor() {
        int turns = (int) (Math.random() * 2) + 2; // 2 или 3 оборота (случайность)
        System.out.println(this.name + " запирает дверь на " + turns + " оборота ключа.");
    }

    public void panic() {
        System.out.println(this.name + " впадает в панику и захлопывает ставни!");
    }

    @Override
    public void performAction() {
        panic();
        lockDoor();
    }
}