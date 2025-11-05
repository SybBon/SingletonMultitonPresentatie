package controller;

import model.StandaardWasmand;

import java.util.ArrayList;
import java.util.Scanner;

public class StandaardWasmandController {
    public static void main(String[] args) {

        Scanner toetsenbord = new Scanner(System.in);
        ArrayList<StandaardWasmand> wasmanden = new ArrayList<>();
        System.out.println("We gaan de was doen! Typ 'stop' wanneer je klaar bent.\n");

        while (true) {
            System.out.println("Wat wil je bij de was doen?");

            System.out.print("Wasmand: ");
            String naam = toetsenbord.next();

            if (naam.equals("stop") || naam.equals("t+stop")) {
                System.out.println("\nProgramma wordt afgesloten...");
                break;
            }

            StandaardWasmand wasmand = null;
            // doorloop de lijst en kijk of deze mand al bestaat
            for (StandaardWasmand mand : wasmanden) {
                if (mand.getWasmandNaam().equalsIgnoreCase(naam)) {
                    wasmand = mand;
                    break;
                }
            }
            // als de mand nog niet bestaat, maak een nieuwe
            if (wasmand == null) {
                wasmand = new StandaardWasmand(naam);
                wasmanden.add(wasmand);
            }

            System.out.print("Kledingstuk: ");
            String kledingstuk = toetsenbord.next();

            wasmand.voegToe(kledingstuk);
        }
        System.out.println();
        System.out.println("Overzicht van de was:");
        for (StandaardWasmand mand : wasmanden) {
            System.out.print(mand.getWasmandNaam() + ": ");
            mand.toonInhoud();
        }
    }
}

