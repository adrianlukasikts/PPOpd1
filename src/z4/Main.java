package z4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Zadanie 4");
        Pasazer pasazer1 = new Pasazer();
        Pasazer pasazer2 = new Pasazer();
        assert pasazer1 instanceof Czlowiek;
        assert pasazer1.toString().equals("Jestem pasazerem");
        Przystanek przystanek1 = new Przystanek(List.of(pasazer1, pasazer2));
        assert przystanek1.getLudzie().equals(List.of(pasazer1, pasazer2));
        Przystanek przystanek2 = new Przystanek();
        assert przystanek2.getLudzie() == null;
        Automat automat = new Automat();
        assert automat.jakiKoszt(1.70).equals(20);
        assert automat.jakiKoszt(2.20).equals(75);
        assert !pasazer1.czyMamBilet();
        assert !pasazer2.czyMamBilet();
        assert automat.sprzedajBilet(pasazer1, 2.23).equals("Nie udalo sie sprzedac biletu za podana cene");
        assert !pasazer1.czyMamBilet();
        assert automat.sprzedajBilet(pasazer1, 2.20).equals("Sprzedano bilet pasaerowi za podana cene");
        assert pasazer1.czyMamBilet();
        Kierowca kierowca = new Kierowca();
        assert kierowca instanceof Czlowiek;
        assert kierowca.toString().equals("Jestem kierowca");
        Autobus autobus = new Autobus(kierowca);
        assert autobus.getKierowca().equals(kierowca);
        assert autobus.getUczestnicy().equals(List.of());
        Konduktor konduktor = new Konduktor();
        assert konduktor instanceof Czlowiek;
        assert konduktor.toString().equals("Jestem konduktorem");
        przystanek1.doAutobusu(autobus);
        assert autobus.getUczestnicy().equals(List.of(pasazer1, pasazer2));
        assert przystanek1.getLudzie() == null;
        autobus.dodajUczestnika(konduktor);
        assert autobus.getUczestnicy().equals(List.of(pasazer1, pasazer2, konduktor));
        assert konduktor.skontroluj(pasazer1).equals("Dziekuje za okazanie biletu");
        assert konduktor.skontroluj(pasazer2).equals("Niestety musze wystawic mandat za brak biletu");
        autobus.wypuscUczestnikow(przystanek2);
        assert autobus.getUczestnicy() == null;
        assert przystanek2.getLudzie().equals(List.of(pasazer1, pasazer2, konduktor));
    }
}
