package ru.itsjava.services;

import ru.itsjava.domain.Client;
import ru.itsjava.domain.Coffee;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final Client client;
    private final CoffeeService coffeeService;
    private final Scanner scanner;

    @Override
    public void buyCoffee() {
        System.out.println("Введите название кофе");
        String name = scanner.next();
        if (coffeeService.hasCoffee(name)) {
            coffeeService.takeCoffeeByName(name);
            System.out.println("Купили кофе");
        } else {
            System.out.println("Не смогли купить кофе");
        }
    }

    @Override
    public void putCoffee() {
        System.out.println("Введите название кофе");
        String name = scanner.next();

        System.out.println("Введите бренд кофе");
        String brand = scanner.next();

        Coffee coffee = new Coffee(name, brand);
        coffeeService.putCoffee(coffee);
        System.out.println("Спасибо за кофе");
    }

    @Override
    public void printCoffee() {
        System.out.println("Уважаемый " + client.getName());
        System.out.println("Вот наш кофе");
        coffeeService.printCoffee();
    }
}
