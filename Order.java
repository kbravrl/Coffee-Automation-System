/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Cafe;

class Order {

    private Customer customer;
    private Coffee coffee;
    private int coffeeQuantity;

    public Order(Customer customer, Coffee coffee, int coffeeQuantity) {
        this.customer = customer;
        this.coffee = coffee;
        this.coffeeQuantity = coffeeQuantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public int getQuantity() {
        return coffeeQuantity;
    }

    public void setQuantity(int coffeeQuantity) {
        this.coffeeQuantity = coffeeQuantity;
    }
}
