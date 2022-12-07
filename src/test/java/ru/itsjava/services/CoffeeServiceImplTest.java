package ru.itsjava.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.itsjava.domain.Coffee;

import java.util.ArrayList;
import java.util.List;

public class CoffeeServiceImplTest {

    public static final Coffee COFFEE_ARABICA = new Coffee("Arabica", "Paulig");
    public static final Coffee COFFEE_IRISH_CREAM = new Coffee("Irish_Cream", "Veronese");
    List<Coffee> coffeeList = new ArrayList<>();
    CoffeeService coffeeService = new CoffeeServiceImpl(coffeeList);

    @DisplayName("проверка получения обьекта(кофе) по имени")
    @Test
    public void shouldHaveCorrectTakeCoffeeByName() {
        coffeeList.add(COFFEE_ARABICA);
        coffeeList.add(COFFEE_IRISH_CREAM);
        Assertions.assertEquals(COFFEE_ARABICA, coffeeService.takeCoffeeByName("Arabica"));
        Assertions.assertNotEquals(COFFEE_IRISH_CREAM, coffeeService.takeCoffeeByName("English_Cream"));
    }

    @DisplayName("проверка добавления обьекта(кофе)")
    @Test
    public void shouldHaveCorrectPutCoffee() {
        coffeeService.putCoffee(COFFEE_ARABICA);
        Assertions.assertEquals(COFFEE_ARABICA, coffeeList.get(0));
    }

    @DisplayName("проверка наличия обьекта(кофе) по имени")
    @Test
    public void shouldHaveCorrectHasCoffee() {
        coffeeService.putCoffee(COFFEE_ARABICA);
        Assertions.assertTrue(coffeeService.hasCoffee("Arabica"));
        Assertions.assertFalse(coffeeService.hasCoffee("Irish_Cream"));
    }

}
