package model;

import java.util.ArrayList;

public class SingletonWasmand {

    // heeft een private static variabel die de enige instance van de Singleton klasse bevat:
    private static SingletonWasmand instance;

    private String wasmandNaam;
    private ArrayList<String> kledingstukken = new ArrayList<>();

    // dankzij de private constructor kunnen andere klassen geen nieuwe instance van de Singleton klasse maken
    private SingletonWasmand(String wasmandNaam) {
        this.wasmandNaam = wasmandNaam;
    }

    public void voegToe(String kledingstuk) {
        kledingstukken.add(kledingstuk);
    }

    public void toonInhoud() {
        System.out.println("Inhoud van de mand (" + wasmandNaam + "): " + kledingstukken);
    }

    public String getWasmandNaam() {
        return wasmandNaam;
    }

    // heeft een public static methode die toegang geeft tot de enige instance:
    public static SingletonWasmand getInstance(String wasmandNaam) {
        if (instance == null) {
            // als de klasse nog geen instance heeft, wordt er een nieuwe gemaakt
            instance = new SingletonWasmand(wasmandNaam);
        }
        return instance;
    }
}


