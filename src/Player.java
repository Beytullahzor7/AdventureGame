import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String charName; //CharacterName = {Samuray,okcu, sovalye}
    private String name;
    private Scanner input = new Scanner(System.in);

    public Player(String name) { //Diğer 4 field oyun içerisinde kullanıcıdan istenecek bu yüzden constructora bunları yazmama gerek yok
        this.name = name;
    }

    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("Karakterler");
        System.out.println("---------------");

        for(GameChar gameChar : charList){
            System.out.println("Id: " + gameChar.getId()+
                    "\t Karakter: " + gameChar.getName() +
                    "\t Hasar: " + gameChar.getDamage()+
                    "\t Sağlık: " + gameChar.getHealth() +
                    "\t Para: " + gameChar.getMoney());
        }
        System.out.println("---------------");
        System.out.print("Lütfen bir karakter seciniz: ");

        int selectChar = input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter: " + this.getCharName() +
                ", Hasar: " + this.getDamage() +
                ", Saglık: " + this.getHealth() +
                ", Para: " + this.getMoney());
    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
