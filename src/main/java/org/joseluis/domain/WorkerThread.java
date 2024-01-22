package org.joseluis.domain;

public class WorkerThread extends Thread {
    private Store store;

    public WorkerThread(Store store, String name) {
        super(name);
        this.store = store;
    }

    @Override
    public void run() {
        if (getName().startsWith("Restocker")) {
            for (int i = 1; i <= 5; i++) {
                store.restockProduct("Product " + i);
            }
        } else if (getName().startsWith("Customer")) {
            for (int i = 1; i <= 3; i++) {
                store.sellProduct();
            }
        }
    }
}