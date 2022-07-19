import weapon.*;


public class Player {
    private final Weapon[] weaponSlots;

    public Player() {
        weaponSlots = new Weapon[]{
                new WaterPistol(),
                new Slingshot(),
                new Rpg(),
                new Pistol(),
                new Machine()
        };
    }

    public Weapon[] getWeaponSlots() {
        return this.weaponSlots;
    }

    public int getSlotsCount() {
        return weaponSlots.length;
    }

    public String nameOfGun(int slot) {
        //      if (slot > weaponSlots.length - 1 || slot < 0) {
        //          System.out.println("У меня нет такой пушки. Давай подумай лучше!");
        //      } else {
        Weapon weapon = weaponSlots[slot];
        return weapon.toString();
        //      }
    }

    public String shotWithWeapon(int slot) {
        String shot = null;
        if (slot > weaponSlots.length - 1 || slot < 0) {
        } else {
            Weapon weapon = weaponSlots[slot];
            System.out.println("Огонь!!!");
            shot =  weapon.shot();
        }
        return shot;
    }
}
