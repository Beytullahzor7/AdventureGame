public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Magaza");
    }

    @Override
    public boolean onLocation(){
        System.out.println("------ Magazaya Hosgeldiniz ------ !");
        System.out.println("1- Silahlar");
        System.out.println("2- Zırhlar");
        System.out.println("3- Cıkıs Yap");
        System.out.print("Seçiminiz: ");

        int selectCase = input.nextInt();
        while (selectCase < 1 || selectCase > 3){
            System.out.println("Geçersiz bir değer girdiniz, Lütfen doğru bir değer giriniz!");
            selectCase = input.nextInt();
        }
        switch (selectCase){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Bir daha bekleriz");
                return true;
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("----- Silahlar -----");
        for(Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + "-" +w.getName()+ " <Para : "+ w.getPrice() + " ,Hasar : " + w.getDamage()+ ">");
        }
    }

    public void buyWeapon(){
        System.out.print("Bir silah seçiniz: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length){ //dinamik yapı
            System.out.println("Geçersiz bir değer girdiniz, Lütfen doğru bir değer giriniz!");
            selectWeaponID = input.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

        if(selectedWeapon != null){
            if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yeterli Paranız Bulunmamaktadır.");
            }else{
                //Satın alma işleminin gerçekleştiği alan
                System.out.println(selectedWeapon.getName() + " silahını satın aldınız.");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan Paranız: " + this.getPlayer().getMoney());
                //System.out.println("Eski Silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().setWeapon(selectedWeapon); //Seçilen silahı oyuncunun silahı olarak set ettik
                //System.out.println("Yeni Silahınız: "+ this.getPlayer().getInventory().getWeapon().getName());

            }
        }
    }

    public void printArmor(){
        System.out.println("Silahlar");
    }
}
