public class SafeHouse extends NormalLoc{

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation(){
        System.out.println("Güvenli Evdesiniz!");
        System.out.println("Canınız yenilendi!");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealt()); //Safehouse a gelindiğinde can yenilendi
        System.out.println("-------------------------");
        return true;
    }
}
