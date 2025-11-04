package controller;

import model.SingletonWasmand;
import java.util.Scanner;

public class SingletonWasmandController {
    public static void main(String[] args) {

        Scanner toetsenbord = new Scanner(System.in);

        System.out.println("We gaan de was doen! Typ 'stop' wanneer je klaar bent.\n");

        while (true) {
            System.out.println("Wat wil je bij de was doen?");

            System.out.print("Wasmand: ");
            String naam = toetsenbord.next();

            if (naam.equals("stop") || naam.equals("t+stop")) {
                System.out.println("\nProgramma wordt afgesloten...");
                break;
            }
            System.out.print("Kledingstuk: ");
            String kledingstuk = toetsenbord.next();
            //krijg toegang tot de enige instance van de Singleton klasse via de public static methode getInstance()
            SingletonWasmand wasmand = SingletonWasmand.getInstance(naam);
            wasmand.voegToe(kledingstuk);
        }
        System.out.println();
        System.out.println("Overzicht van de was:");
        SingletonWasmand.getInstance("n.v.t.").toonInhoud();
    }
}
