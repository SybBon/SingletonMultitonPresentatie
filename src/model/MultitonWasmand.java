package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MultitonWasmand {

    private static Map<String, MultitonWasmand> manden = new HashMap<>();
    private static final String[] TOEGESTANE_MANDEN = {"wit", "bont", "zwart"};

    private String wasmandNaam;
    private ArrayList<String> kledingstukken = new ArrayList<>();

    private MultitonWasmand(String wasmandNaam) {
        this.wasmandNaam = wasmandNaam;
    }

    public void voegToe(String kledingstuk) {
        kledingstukken.add(kledingstuk);
    }

    public void toonInhoud() {
        System.out.println("Inhoud van mand '" + wasmandNaam + "': " + kledingstukken);
    }

    public static void toonAlleManden() {
        for (MultitonWasmand mand : manden.values()) {
            mand.toonInhoud();
        }
    }

    public static MultitonWasmand getInstance(String wasmandNaam) {
        if (!isToegestaan(wasmandNaam)) {
            System.out.println("   Fout: Er is geen mand voor '" + wasmandNaam + "'.");
            System.out.println("   Kies uit: wit, bont of zwart.\n");
            return null;
        }

        if (!manden.containsKey(wasmandNaam)) {
            manden.put(wasmandNaam, new MultitonWasmand(wasmandNaam));
        }
        return manden.get(wasmandNaam);
    }

    private static boolean isToegestaan(String naam) {
        for (String toegestaan : TOEGESTANE_MANDEN) {
            if (toegestaan.equalsIgnoreCase(naam)) {
                return true;
            }
        }
        return false;
    }
}

