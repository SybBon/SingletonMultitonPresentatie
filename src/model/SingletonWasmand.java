package model;

import java.util.ArrayList;

public class SingletonWasmand {

    private static SingletonWasmand wasmand; // de enige mand
    private String wasmandNaam;
    private ArrayList<String> kledingstukken = new ArrayList<>();

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

    public static SingletonWasmand getInstance(String wasmandNaam) {
        if (wasmand == null) {
            wasmand = new SingletonWasmand(wasmandNaam);
        }
        return wasmand;
    }
}


