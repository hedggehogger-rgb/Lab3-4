package ru.higgradeloc;

import ru.higgradeloc.exceptions.StructuralDamageException;
import ru.higgradeloc.model.*;

import java.util.ArrayList;
import java.util.List;

public class start {
    public static void main(String[] args) {
        System.out.println("=== НАЧАЛО СЦЕНЫ: Выселение Кума Тыквы ===");

        pumpkin pump = new pumpkin("Кум Тыква");
        tomato tomato = new tomato("Синьор Помидор");
        house pumpkinHouse = new house(pump);

        List<villager> neighbors = new ArrayList<>();
        neighbors.add(new villager("Сосед Лук"));
        neighbors.add(new villager("Тетушка Фасоль"));
        System.out.println("\n--- ДОМИК КУМА ТЫКВЫ ---");
        pump.performAction();
        pump.dream();
        tomato.performAction();
        tomato.grab(pumpkinHouse);

        try {
            tomato.shake(pumpkinHouse);
        } catch (StructuralDamageException e) {
            System.err.println("[EXCEPTION LOG]: " + e.getMessage());
            System.out.println(">> Из-за разрушений Кум Тыква вынужден вернуться в реальность.");
            pump.openEyes();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка аргумента: " + e.getMessage());
        }
        tomato.growl();
        System.out.println("\n--- УЛИЦА ДЕРЕВНИ ---");

        for (villager villager : neighbors) {
            villager.performAction();
        }
        System.out.println("\n--- ВНЕЗАПНО ---");

        greenpea pea = new greenpea("Синьор Зеленый Горошек");
        Runnable appearAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("Словно горошина из стручка, появляется " + pea.getName());
            }
        };
        appearAction.run();

        pea.performAction();

        System.out.println("\n=== КОНЕЦ СЦЕНЫ ===");
        System.out.println("\n[DEBUG INFO]:");
    }
}
