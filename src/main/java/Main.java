import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            String[] dzialaniaMatematyczne = DzialaniaNaPlikach.wczytajPlik("operacjeMatematyczne.txt");
            int[] wynikiDzialanMatematycznych = DzialaniaNaPlikach.obliczenia(dzialaniaMatematyczne);
            DzialaniaNaPlikach.wyswietlenieTekstuwKonsoli(dzialaniaMatematyczne, wynikiDzialanMatematycznych);
            DzialaniaNaPlikach.zapisanieWynikowDoPliku(dzialaniaMatematyczne, wynikiDzialanMatematycznych, "wynikiDzialanMatematycznych.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Nie da sie wczytac pliku");
        } catch (IOException e) {
            System.out.println("Nie da sie zapisac pliku");
        }
    }
}
