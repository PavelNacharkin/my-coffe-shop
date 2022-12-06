package ru.itsjava.services;

import ru.itsjava.domain.Coffee;

public interface CoffeeService {
    Coffee takeCoffeeByName(String name);

    void putCoffee(Coffee coffee);

    boolean hasCoffee(String name);

    void printCoffee();
}
