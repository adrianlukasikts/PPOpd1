package z1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Zadanie 1");
        Smok smok = new Smok();

        assert smok.getPunktyZycia() == 1000;
        assert smok instanceof Postac;

        Rycerz rycerz = new Rycerz(500, 50);

        assert rycerz.getPunktyZycia() == 500;
        assert rycerz.getSila() == 50;
        assert rycerz instanceof Postac;
        assert rycerz instanceof Walczaca;

        Druid druid = new Druid(250, 100);

        assert druid.getPunktyZycia() == 250;
        assert druid.getMana() == 100;
        assert druid instanceof Postac;
        assert druid instanceof Leczaca;

        smok.atakuj(rycerz);

        assert rycerz.getPunktyZycia() == 400;

        smok.atakuj(rycerz);

        assert rycerz.getPunktyZycia() == 300;

        druid.wylecz(rycerz);

        assert rycerz.getPunktyZycia() == 500;
        assert druid.getMana() == 90;

        druid.wylecz(rycerz);

        assert rycerz.getPunktyZycia() == 700;

        druid.atakuj(smok);

        assert smok.getPunktyZycia() == 999;

        rycerz.atakuj(smok);

        assert smok.getPunktyZycia() == 949;

        rycerz.atakuj(smok);

        assert smok.getPunktyZycia() == 899;

        rycerz.atakuj(smok);

        assert smok.getPunktyZycia() == 849;
    }
}
