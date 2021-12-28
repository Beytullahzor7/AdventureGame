import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera Oyununa hosgeldiniz !");
        System.out.println("Lütfen bir isim giriniz: ");
        //String playerName = input.nextLine();

        Player player = new Player("Ali");
        System.out.println(player.getName() + " hosgeldiniz.");

        System.out.println("Lütfen bir karakter seciniz: ");
        player.selectChar();
    }
}
