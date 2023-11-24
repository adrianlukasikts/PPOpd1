package z2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Zadanie 2");
        List<Ksiazka> ksiazki = List.of(
                new Potop(1),
                new Potop(2),
                new Dziady(3),
                new Balladyna(4),
                new Lalka(5)
        );
        Potop potop1 = (Potop) ksiazki.get(0);

        assert potop1.getId() == 1;
        assert potop1.getAutor().equals("Henryk Sienkiewicz");

        Potop potop2 = (Potop) ksiazki.get(1);

        assert potop2.getId() == 2;
        assert potop2.getAutor().equals("Henryk Sienkiewicz");

        Dziady dziady = (Dziady) ksiazki.get(2);

        assert dziady.getId() == 3;
        assert dziady.getAutor().equals("Adam Mickiewicz");

        Balladyna balladyna = (Balladyna) ksiazki.get(3);

        assert balladyna.getId() == 4;
        assert balladyna.getAutor().equals("Juliusz Slowacki");

        Lalka lalka = (Lalka) ksiazki.get(4);

        assert lalka.getId() == 5;
        assert lalka.getAutor().equals("Boleslaw Prus");

        List<Uzytkownik> uzytkownicy = List.of(new Uzytkownik(0), new Uzytkownik(1));

        assert uzytkownicy.get(0).getId() == 0;
        assert uzytkownicy.get(0).getIdWypozyczonychKsiazek().isEmpty();
        assert uzytkownicy.get(1).getId() == 1;
        assert uzytkownicy.get(1).getIdWypozyczonychKsiazek().isEmpty();

        Biblioteka biblioteka = new Biblioteka(uzytkownicy, ksiazki);
        biblioteka.getUzytkownik(0).wypozycz(1);
        biblioteka.getUzytkownik(0).wypozycz(4);

        assert biblioteka.getUzytkownik(0).getIdWypozyczonychKsiazek().equals(List.of(1, 4));

        biblioteka.getUzytkownik(0).oddaj(4);

        assert biblioteka.getUzytkownik(0).getIdWypozyczonychKsiazek().equals(List.of(1));

        biblioteka.getUzytkownik(1).wypozycz(4);

        assert biblioteka.getUzytkownik(1).getIdWypozyczonychKsiazek().equals(List.of(4));

        biblioteka.getUzytkownik(1).wypozycz(2);
        biblioteka.getUzytkownik(1).wypozycz(3);
        biblioteka.getUzytkownik(1).wypozycz(5);

        assert biblioteka.getUzytkownik(1).getIdWypozyczonychKsiazek().equals(List.of(4, 2, 3, 5));

        biblioteka.getUzytkownik(1).oddaj(2);

        assert biblioteka.getUzytkownik(1).getIdWypozyczonychKsiazek().equals(List.of(4, 3, 5));
    }
}
