package ru.itsjava.services;

import ru.itsjava.domain.Coffee;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {
    private final List<Coffee> coffeeFromShop;

    @Override
    public Coffee takeCoffeeByName(String name) {
        Coffee resCoffee = null;
        for (Coffee coffee : coffeeFromShop) {
            if (coffee.getName().equals(name)) {
                resCoffee = coffee;
            }
        }
        if (resCoffee != null) {
            coffeeFromShop.remove(resCoffee);
            return resCoffee;
        }
        return null;
    }

    @Override
    public void putCoffee(Coffee coffee) {
        coffeeFromShop.add(coffee);
    }

    @Override
    public boolean hasCoffee(String name) {
        for (Coffee coffee : coffeeFromShop) {
            if (coffee.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void printCoffee() {
        for (Coffee coffee : coffeeFromShop) {
            System.out.println(coffee.getName() + " " + coffee.getBrand());
        }
    }
}