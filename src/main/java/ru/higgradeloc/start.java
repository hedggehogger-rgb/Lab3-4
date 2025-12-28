package ru.higgradeloc;

import ru.higgradeloc.exceptions.StructuralDamageException;
import ru.higgradeloc.model.*;

import java.util.ArrayList;
import java.util.List;

public class start {
    public static void main(String[] args) {
        // --- 1. Инициализация персонажей и среды ---
        System.out.println("=== НАЧАЛО СЦЕНЫ: Выселение Кума Тыквы ===");

        pumpkin pump = new pumpkin("Кум Тыква");
        tomato tomato = new tomato("Синьор Помидор");
        house pumpkinHouse = new house(pump);

        List<villager> neighbors = new ArrayList<>();
        neighbors.add(new villager("Сосед Лук"));
        neighbors.add(new villager("Тетушка Фасоль"));

        // --- 2. Сценарий ---

        System.out.println("\n--- НАТ. ДОМИК КУМА ТЫКВЫ ---");

        // Кум Тыква пытается уйти от реальности
        pump.performAction();
        pump.dream();

        // Помидор начинает действовать
        tomato.performAction();
        tomato.grab(pumpkinHouse);

        try {
            // Помидор трясет домик
            tomato.shake(pumpkinHouse);
        } catch (StructuralDamageException e) {
            // Обработка Checked исключения
            System.err.println("[EXCEPTION LOG]: " + e.getMessage());
            System.out.println(">> Из-за разрушений Кум Тыква вынужден вернуться в реальность.");
            pump.openEyes();
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка аргумента: " + e.getMessage());
        }

        // Рычание Помидора
        tomato.growl();

        // Реакция жителей
        System.out.println("\n--- НАТ. УЛИЦА ДЕРЕВНИ ---");

        for (villager villager : neighbors) {
            villager.performAction();
        }

        // Появление Зеленого Горошка
        System.out.println("\n--- ВНЕЗАПНО ---");

        greenpea pea = new greenpea("Синьор Зеленый Горошек");

        // Анонимный класс
        Runnable appearAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("Словно горошина из стручка, появляется " + pea.getName());
            }
        };
        appearAction.run();

        pea.performAction();

        System.out.println("\n=== КОНЕЦ СЦЕНЫ ===");

        // Технический вывод (toString)
        System.out.println("\n[DEBUG INFO]:");
        System.out.println(pump.toString());
        System.out.println(pumpkinHouse.toString());
    }
}