/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Cafe;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Customer customer1 = new Customer("Ahmet", 100.0);
        Customer customer2 = new Customer("Ayşe", 50.0);

        // Create orders
        Coffee coffee1 = new Coffee(Coffee.CoffeeType.MOCHA, Coffee.CupSize.GRANDE);
        Coffee coffee2 = new Coffee(Coffee.CoffeeType.LATTE, Coffee.CupSize.TALL);
        Order order1 = new Order(customer1, coffee1, 2);
        Order order2 = new Order(customer2, coffee2, 1);

        Cafe cafe = new Cafe(inventory);

        // Perform coffee sales
        System.out.println("----- Coffee Sale Started -----\n");
        cafe.sellCoffee(order1);
        cafe.sellCoffee(order2);
        System.out.println("----- Coffee Sale Ended -----");

        // Print total sales report and inventory status
        cafe.printTotalSalesReport();
        cafe.printInventoryReport();

        // Print remaining balances of the customers
        System.out.println("Remaining Balances:");
        System.out.println(customer1.getName() + ": " + customer1.getWalletBalance() + " TL");
        System.out.println(customer2.getName() + ": " + customer2.getWalletBalance() + " TL");
    }
}
