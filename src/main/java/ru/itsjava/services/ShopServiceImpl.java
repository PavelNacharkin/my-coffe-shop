package ru.itsjava.services;

import ru.itsjava.domain.Client;
import ru.itsjava.domain.Coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopServiceImpl implements ShopService {
    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ваше имя");
        String clientName = scanner.next();

        Client client = new Client(clientName, new ArrayList<>());

        List<Coffee> coffeeList = new ArrayList<>();
        coffeeList.add(new Coffee("Irish_Cream", "Veronese"));
        coffeeList.add(new Coffee("Arabica", "Paulig"));

        CoffeeService coffeeService = new CoffeeServiceImpl(coffeeList);

        ClientService clientService = new ClientServiceImpl(client, coffeeService, scanner);
        MenuService menuService = new MenuServiceImpl(clientService, scanner);
        menuService.menu();
    }
}
