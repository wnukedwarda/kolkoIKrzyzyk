import java.util.Scanner;

public class kolkoKrzyzyk {

    private static final String KOLKO = "o";
    private static final String KRZYZYK = "x";

    public void graj() {

        Scanner sc = new Scanner(System.in);
        String[][] plansza = new String[3][3];
        String ostatniSymbol = KRZYZYK;
        int wykorzystanePola = 0;
        do {
            System.out.println("Podaj pozycje ");
            int pozycja1 = sc.nextInt();
            int pozycja2 = sc.nextInt();
            if (pozycja1 > 2 || pozycja2 > 2 ||
                    pozycja1 < 0 || pozycja2 < 0) {
                System.out.println("Blad, pole ma rozmiar 3x3");
                continue;
            }

            if (plansza[pozycja1][pozycja2] != null) {
                System.out.println("Blad, wybrano juz to pole");
                continue;
            }

            ostatniSymbol = ostatniSymbol.equals(KOLKO) ?
                    KRZYZYK : KOLKO;
            plansza[pozycja1][pozycja2] = ostatniSymbol;
            wykorzystanePola++;

            wyswielt(plansza);
        } while (!czyWygrana(plansza, ostatniSymbol)
                && wykorzystanePola < 9);


    }

    private void wyswielt(String[][] plansza) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(
                        " " + (plansza[i][j] != null ? plansza[i][j] : " ") + " ");

            }
            System.out.println();
        }
    }

    private boolean czyWygrana(String[][] plansza, String symbol) {
        return sprawdzWiersz(plansza, symbol, 0)
                || sprawdzWiersz(plansza, symbol, 1)
                || sprawdzWiersz(plansza, symbol, 2)
                || sprawdzKolumne(plansza, symbol, 0)
                || sprawdzKolumne(plansza, symbol, 1)
                || sprawdzKolumne(plansza, symbol, 2)
                || sprawdzPrzekatne(plansza, symbol);
    }

    private boolean sprawdzWiersz(String[][] plansza, String symbol,
                                  int indeksWiersza) {
        boolean czyWygrana = true;
        for (int i = 0; i < 3; i++) {
            czyWygrana = czyWygrana &&
                    symbol.equals(plansza[indeksWiersza][i]);
        }
        return czyWygrana;
    }

    private boolean sprawdzKolumne(String[][] plansza, String symbol,
                                   int indeksKolumny) {
        return (symbol.equals(plansza[0][indeksKolumny]) &&
                symbol.equals(plansza[1][indeksKolumny]) &&
                symbol.equals(plansza[2][indeksKolumny]));
    }

    private boolean sprawdzPrzekatne(String[][] plansza, String symbol) {
        return (symbol.equals(plansza[0][0]) &&
                symbol.equals(plansza[1][1]) &&
                symbol.equals(plansza[2][2])) ||
                (symbol.equals(plansza[0][2]) &&
                        symbol.equals(plansza[1][1]) &&
                        symbol.equals(plansza[2][0]));


    }


}


