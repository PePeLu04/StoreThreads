package org.joseluis.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Store {
    private Queue<String> products = new LinkedList<>();

    public synchronized void restockProduct(String product) {
        products.offer(product);
        System.out.println(Thread.currentThread().getName() + ": Restocked " + product);

        saveProductsToXML();
    }

    public synchronized void sellProduct() {
        if (!products.isEmpty()) {
            String product = products.poll();
            System.out.println(Thread.currentThread().getName() + ": Sold " + product);
            saveProductsToXML();
        } else {
            System.out.println(Thread.currentThread().getName() + ": No products available");
        }
    }

    public synchronized boolean hasProducts() {
        return !products.isEmpty();
    }

    private void saveProductsToXML() {
        try {
            File file = new File("products.xml");
            FileWriter writer = new FileWriter(file);

            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<products>\n");

            for (String product : products) {
                writer.write("  <product>" + product + "</product>\n");
            }

            writer.write("</products>\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> loadProductsFromXML() {
        List<String> loadedProducts = new ArrayList<>();

        try {
            File file = new File("products.xml");
            // Lógica para leer el archivo XML y cargar los productos en loadedProducts
            // ...

        } catch (Exception e) {
            e.printStackTrace();
        }

        return loadedProducts;
    }

    public interface OnActionCallback {
        void onAction(String message);
    }
}