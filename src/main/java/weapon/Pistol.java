package weapon;

public class Pistol extends Weapon {
    @Override
    public String shot() {
        return "Бах";
    }
    @Override
    public String toString (){
        return "Пистолет";
    }
}
