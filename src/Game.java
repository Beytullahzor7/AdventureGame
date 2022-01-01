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
        System.out.println("-----------------------------");
        player.selectChar();

        Location location = null;
        while (true){
            player.printInfo(); //Her döngüde playerin o zamanki statelerini ekrana getir
            System.out.println();
            System.out.println("------Bölgeler------");
            System.out.println();
            System.out.println("1- Güvenli Ev ---> Burası sizin için güvenlidir");
            System.out.println("2- Eşya Dükkanı ---> Silah veya zırh satın alabilirsiniz");
            System.out.println("3- Mağara ---> Ödül <Yemek>, dikkatli ol zombi çıkabilir");
            System.out.println("4- Orman ---> Ödül <Odun>, dikkatli ol vampir çıkabilir");
            System.out.println("5- Nehir ---> Ödül <Su>, dikkatli ol ayı çıkabilir");
            System.out.println("0- Çıkış Yap ---> Oyunu Sonlandır");

            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");

            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player); //this ürettigim player nesnesine denk gelir
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player); //polymorphism
                    break;
                case 4:
                    location = new Forest(player); //polymorphism
                    break;
                case 5:
                    location = new River(player); //polymorphism
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz!");
            }

            if(location == null){
                System.out.println("Oyundan Çıkış Yapılıyor...");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER!!!");
                break;
            }
        }
    }
}
