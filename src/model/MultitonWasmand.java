package model;

import java.util.ArrayList;

public class MultitonWasmand {

    private static ArrayList<MultitonWasmand> manden = new ArrayList<>();
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
        for (MultitonWasmand mand : manden) {
            mand.toonInhoud();
        }
    }

    public static MultitonWasmand getInstance(String wasmandNaam) {
        if (!isToegestaan(wasmandNaam)) {
            System.out.println("   Fout: Er is geen mand voor '" + wasmandNaam + "'.");
            System.out.println("   Kies uit: wit, bont of zwart.\n");
            return null;
        }
        for (MultitonWasmand mand : manden) {
            if (mand.wasmandNaam.equalsIgnoreCase(wasmandNaam)) {
                return mand;
            }
        }
        MultitonWasmand nieuweMand = new MultitonWasmand(wasmandNaam);
        manden.add(nieuweMand);
        return nieuweMand;
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

