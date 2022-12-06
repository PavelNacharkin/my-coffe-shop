package ru.itsjava.services;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final ClientService clientService;

    private final Scanner scanner;

    @Override
    public void menu() {
        printMenu();
        while (true) {
            System.out.println("Введите номер меню");
            int menuNum = scanner.nextInt();
            if (menuNum == 1) {
                System.out.println("Вы выбрали купить кофу");
                clientService.buyCoffee();
            } else if (menuNum == 2) {
                System.out.println("Вы выбрали положить кофе");
                clientService.putCoffee();
            } else if (menuNum == 3) {
                System.out.println("Вы выбрали показать кофе в наличии");
                clientService.printCoffee();
            } else {
                System.out.println("До встречи");
                break;
            }

        }
    }

    @Override
    public void printMenu() {
        System.out.println("1-Купить кофе; 2- Отдать кофе;3- Показать кофе в наличии; Все остальное выход");

    }
}
