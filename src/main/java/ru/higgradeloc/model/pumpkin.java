package ru.higgradeloc.model;

public class pumpkin extends person {
    private boolean eyesClosed;

    public pumpkin(String name) {
        super(name);
        this.eyesClosed = false;
    }

    public void dream() {
        this.eyesClosed = true;
        System.out.println(this.name + " крепко зажмуривает глаза.");
        say("Никакого синьора Помидора тут нет. Я плыву, как моряк, по Тихому океану...");
    }

    public void openEyes() {
        this.eyesClosed = false;
        System.out.println(this.name + " в ужасе распахивает глаза от грохота!");
    }

    @Override
    public void performAction() {
        if (eyesClosed) {
            System.out.println(this.name + " пытается уйти от реальности.");
        } else {
            System.out.println(this.name + " дрожит от страха.");
        }
    }

    @Override
    public String toString() {
        return "pumpkin{name='" + name + "', eyesClosed=" + eyesClosed + "}";
    }
}
