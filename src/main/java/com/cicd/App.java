package com.cicd;

public class App {

    public static double calculateTotal(double price, int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        double price = 100.0;
        int quantity = 3;

        double total = calculateTotal(price, quantity);

        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + total);
    }
}