/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Cafe;

import java.util.EnumMap;

class Inventory {

    private final EnumMap<Coffee.CoffeeType, Integer> coffeeList;

    public Inventory() {
        this.coffeeList = new EnumMap<>(Coffee.CoffeeType.class);
        for (Coffee.CoffeeType type : Coffee.CoffeeType.values()) {
            coffeeList.put(type, 10);
        }
    }

    public int getCoffeeQuantity(Coffee.CoffeeType type) {
        return coffeeList.getOrDefault(type, 0);
    }

    public void addCoffeeQuantity(Coffee.CoffeeType type, int quantity) {
        coffeeList.put(type, coffeeList.get(type) + quantity);
    }

    public void reduceCoffeeQuantity(Coffee.CoffeeType type, int quantity) {
        coffeeList.put(type, coffeeList.get(type) - quantity);
    }

    public void displayCoffeeList() {
        coffeeList.keySet().forEach(System.out::println);
    }

    public void displayCoffeeQuantities() {
        coffeeList.forEach((type, quantity) -> System.out.println(type + ": " + quantity));
    }
}
