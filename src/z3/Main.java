package z3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Zadanie 3");
        Polska polska = new Polska();
        Niemcy niemcy = new Niemcy();
        Czechy czechy = new Czechy();
        Slowacja slowacja = new Slowacja();
        Ukraina ukraina = new Ukraina();
        Bialorus bialorus = new Bialorus();
        Litwa litwa = new Litwa();
        Rosja rosja = new Rosja();

        assert polska instanceof PanstwoEuropejskie;
        assert niemcy instanceof PanstwoEuropejskie;
        assert czechy instanceof PanstwoEuropejskie;
        assert slowacja instanceof PanstwoEuropejskie;
        assert ukraina instanceof PanstwoEuropejskie;
        assert bialorus instanceof PanstwoEuropejskie;
        assert litwa instanceof PanstwoEuropejskie;
        assert rosja instanceof PanstwoAzjatyckie;

        assert polska instanceof Panstwo;
        assert niemcy instanceof Panstwo;
        assert czechy instanceof Panstwo;
        assert slowacja instanceof Panstwo;
        assert ukraina instanceof Panstwo;
        assert bialorus instanceof Panstwo;
        assert litwa instanceof Panstwo;
        assert rosja instanceof Panstwo;

        assert polska.getKontynent() == Kontynent.EUROPA;
        assert polska.getLiczbaLudnosci() == 37750000;
        assert polska.getStolica().equals("Warszawa");

        assert rosja.getKontynent() == Kontynent.AZJA;
        assert rosja.getLiczbaLudnosci() == 143400000;
        assert rosja.getStolica().equals("Moskwa");

        assert polska.getSasiedzi().equals(List.of());

        polska.dodajSasiada(niemcy);
        polska.dodajSasiada(czechy);
        polska.dodajSasiada(slowacja);
        polska.dodajSasiada(ukraina);
        polska.dodajSasiada(bialorus);
        polska.dodajSasiada(litwa);
        polska.dodajSasiada(rosja);

        assert polska.getSasiedzi().equals(List.of(
                niemcy,
                czechy,
                slowacja,
                ukraina,
                bialorus,
                litwa,
                rosja
        ));

        rosja.migruj(polska, 1000000);

        assert rosja.getLiczbaLudnosci() == 142400000;
        assert polska.getLiczbaLudnosci() == 38750000;
    }
}
