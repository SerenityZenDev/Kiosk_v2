package org.example;

import org.example.Controller.KioskController;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        KioskController kioskController = new KioskController();
        kioskController.start();
    }
}

