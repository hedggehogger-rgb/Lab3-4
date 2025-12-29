package ru.higgradeloc.model;

import ru.higgradeloc.enums.intensity;
import ru.higgradeloc.exceptions.StructuralDamageException;
import ru.higgradeloc.interfaces.shake;
import ru.higgradeloc.records.tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class house implements shake {
    private final person owner;
    private List<tile> roofTiles;

    public house(person owner) {
        this.owner = owner;
        this.roofTiles = new ArrayList<>();
        // Инициализируем крышу черепицей
        for (int i = 0; i < 20; i++) {
            roofTiles.add(new tile("Глина", 1.5));
        }
    }

    public void loseTiles() {
        if (roofTiles.isEmpty()) {
            System.out.println("На крыше уже не осталось черепицы!");
            return;
        }

        int lostCount = new Random().nextInt(5, roofTiles.size() + 1);
        System.out.println("Крыша ходит ходуном! " + lostCount + " шт. черепицы разлетается во все стороны!");

        // Удаляем часть черепицы (эмуляция разрушения)
        for (int i = 0; i < lostCount && !roofTiles.isEmpty(); i++) {
            roofTiles.remove(0);
        }
    }

    public void shatter() {
        System.out.println("Домик " + owner.getName() + " раскачивается то влево, то вправо.");
    }

    @Override
    public void beShaken(intensity level) throws StructuralDamageException {
        System.out.println("Домик подвергся тряске с интенсивностью: " + level);

        switch (level) {
            case min -> System.out.println("Домик слегка покачивается.");
            case med -> {
                shatter();
                System.out.println("Слышен скрип кирпичей.");
            }
            case max -> {
                shatter();
                loseTiles();
                throw new StructuralDamageException("Хрупкая конструкция домика не выдержала ярости!");
            }
        }
    }

    @Override
    public String toString() {
        return "{владелец домика " + owner.getName() + ", Оставшихся черепиц " + roofTiles.size() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        house house = (house) o;
        return Objects.equals(owner, house.owner) && Objects.equals(roofTiles, house.roofTiles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, roofTiles);
    }
}
