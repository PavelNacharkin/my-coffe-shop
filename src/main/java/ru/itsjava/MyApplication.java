package ru.itsjava;

import ru.itsjava.services.ShopService;
import ru.itsjava.services.ShopServiceImpl;

public class MyApplication {
    public static void main(String[] args) {

        ShopService shopService = new ShopServiceImpl();

        shopService.start();
    }
}
