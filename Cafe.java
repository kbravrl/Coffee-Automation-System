/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Cafe;

import java.util.ArrayList;
import java.util.List;

class Cafe {

    private final Inventory inventory;
    private double totalSales;
    private final List<Order> orderList;

    public Cafe(Inventory inventory) {
        this.inventory = inventory;
        this.totalSales = 0.0;
        orderList = new ArrayList<>();
    }

    public void sellCoffee(Order order) {
        if (isCoffeeInStock(order)) {
            double totalCoffeePrice = calculateTotalCoffeePrice(order);
            if (paymentControl(order.getCustomer(), totalCoffeePrice)) {
                addOrderToList(order);
                updateInventory(order.getCoffee().getType(), order.getQuantity(), false);
                totalSales += totalCoffeePrice;
                deductBalance(order.getCustomer(), totalCoffeePrice);
                System.out.println("1 of " + order.getQuantity() + " *" + order.getCustomer().getName() + "* "
                        + order.getCoffee());
            }
        }
    }

    private double calculateTotalCoffeePrice(Order order) {
        return ((order.getCoffee().getType().getPrice() + order.getCoffee().getSize().getSizePrice())) * order.getQuantity();
    }

    public boolean isCoffeeInStock(Order order) {
        int availableQuantity = inventory.getCoffeeQuantity(order.getCoffee().getType());
        if (availableQuantity >= order.getQuantity()) {
            return true;
        }
        System.out.println("Üzgünüz, bu boyutta yeterli " + order.getCoffee() + " stokta bulunmamaktadır.");
        return false;
    }

    public boolean paymentControl(Customer customer, double totalCoffeePrice) {
        if (customer.getWalletBalance() >= totalCoffeePrice) {
            return true;
        }
        System.out.println("Yetersiz bakiye nedeniyle sipariş iptal edildi.");
        return false;
    }

    public void updateInventory(Coffee.CoffeeType type, int quantity, boolean add) {
        if (add) {
            inventory.addCoffeeQuantity(type, quantity);
        } else {
            inventory.reduceCoffeeQuantity(type, quantity);
        }
    }

    public void deductBalance(Customer customer, double amount) {
        double currentBalance = customer.getWalletBalance();
        double newBalance = currentBalance - amount;
        customer.setWalletBalance(newBalance);
    }

    public void addOrderToList(Order order) {
        orderList.add(order);
    }

    public void displayMenu() {
        System.out.println("Menü:");
        inventory.displayCoffeeList();
    }

    public void printTotalSalesReport() {
        System.out.println("\nToplam Satış: " + totalSales + " TL");
    }

    public void printInventoryReport() {
        System.out.println("\nEnvanter Durumu:");
        inventory.displayCoffeeQuantities();
    }
}
