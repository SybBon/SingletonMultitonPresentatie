package model;

import java.util.ArrayList;

public class StandaardWasmand {

    private String wasmandNaam;

    private ArrayList<String> kledingstukken = new ArrayList<>();

    public StandaardWasmand(String wasmandNaam) {
        this.wasmandNaam = wasmandNaam;
    }

    public void voegToe(String kledingstuk) {
        kledingstukken.add(kledingstuk);
    }

    public void toonInhoud() {
        System.out.println("Inhoud van de mand: " + kledingstukken);
    }

    public String getWasmandNaam() {
        return wasmandNaam;
    }
}

