import java.io.*;
import java.util.Scanner;

public class DzialaniaNaPlikach {
    public static String[] wczytajPlik(String nazwaPliku) throws FileNotFoundException {
        int liczbaLiniiTekstu = wyliczLinieTekstu(nazwaPliku);
        String[] dzialaniaMatematyczne = new String[liczbaLiniiTekstu];
        int indeks = 0;

        try (Scanner scanner = new Scanner(new File(nazwaPliku))) {
            while (scanner.hasNextLine()) {
                dzialaniaMatematyczne[indeks] = scanner.nextLine();
                indeks++;
            }
        }
        return dzialaniaMatematyczne;
    }

    public static int[] obliczenia(String[] dzialaniaMatematyczne) {
        int[] wyniki = new int[dzialaniaMatematyczne.length];
        for (int i = 0; i < dzialaniaMatematyczne.length; i++) {
            String[] rozdzielenieObliczen = dzialaniaMatematyczne[i].split(" ");
            int liczba1 = Integer.parseInt(rozdzielenieObliczen[0]);
            String operatorMatematyczny = rozdzielenieObliczen[1];
            int liczba2 = Integer.parseInt(rozdzielenieObliczen[2]);
            if (operatorMatematyczny.equals("+")) {
                wyniki[i] = liczba1 + liczba2;
            } else if (operatorMatematyczny.equals("-")) {
                wyniki[i] = liczba1 - liczba2;
            } else if (operatorMatematyczny.equals("*")) {
                wyniki[i] = liczba1 * liczba2;
            } else if (operatorMatematyczny.equals("/")) {
                wyniki[i] = liczba1 / liczba2;
            }
        }
        return wyniki;
    }

    public static void wyswietlenieTekstuwKonsoli(String[] dzialaniaMatematyczne, int[] wyniki) throws IOException {
        for (int i = 0; i < dzialaniaMatematyczne.length; i++) {
            System.out.println(dzialaniaMatematyczne[i] + " = " + wyniki[i]);
        }
    }

    public static void zapisanieWynikowDoPliku(String[] dzialaniaMatematyczne, int[] wyniki, String nazwaPliku) throws IOException {
        FileWriter fileWriter = new FileWriter(nazwaPliku);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < dzialaniaMatematyczne.length; i++) {
            bufferedWriter.write(dzialaniaMatematyczne[i] + " = " + wyniki[i]);
            bufferedWriter.newLine();

        }
    }

    public static int wyliczLinieTekstu(String nazwaPliku) throws FileNotFoundException {
        int liczbaLiniiTekstu = 0;
        try (Scanner scanner = new Scanner(new File(nazwaPliku))) {
            while (scanner.hasNextLine()) {
                liczbaLiniiTekstu++;
                scanner.nextLine();
            }
        }
        return liczbaLiniiTekstu;
    }
}