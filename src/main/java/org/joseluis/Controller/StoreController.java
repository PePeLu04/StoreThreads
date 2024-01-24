package org.joseluis.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.joseluis.domain.Store;
import org.joseluis.domain.WorkerThread;

public class StoreController {
    @FXML
    private Label statusLabel;

    private Store store = new Store();

    @FXML
    private void handleRestockButton(ActionEvent event) {
        WorkerThread restocker = new WorkerThread(store, "Restocker");
        restocker.start();

        try {
            restocker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        statusLabel.setText("Products restocked!");
    }

    @FXML
    private void handleBuyButton() {
        if(store.hasProducts()) {
            WorkerThread customer = new WorkerThread(store, "Customer");
            customer.start();
            statusLabel.setText("Product bought!");
        }else{
            statusLabel.setText("No products available");
        }
    }

}
