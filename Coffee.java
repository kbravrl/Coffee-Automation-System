/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Cafe;

class Coffee {

    private CoffeeType type;
    private CupSize size;

    enum CoffeeType {
        MOCHA(50.0), LATTE(40.0), CAPPUCCINO(45.0), MACCHIATO(40.0);

        private final double price;

        private CoffeeType(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }

    enum CupSize {
        TALL(0.0), GRANDE(10.0), VENTI(15.0);

        private final double sizePrice;

        private CupSize(double sizePrice) {
            this.sizePrice = sizePrice;
        }

        public double getSizePrice() {
            return sizePrice;
        }
    }

    public Coffee(CoffeeType type, CupSize size) {
        this.type = type;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Coffee{" + "type=" + type + ", size=" + size;
    }

    public CoffeeType getType() {
        return type;
    }

    public void setType(CoffeeType type) {
        this.type = type;
    }

    public CupSize getSize() {
        return size;
    }

    public void setSize(CupSize size) {
        this.size = size;
    }
}
