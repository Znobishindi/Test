package weapon;

public class Machine extends Weapon {
    @Override
    public String shot() {
        return "Тра-та-та-та-та";
    }
    @Override
    public String toString (){
        return "Автомат";
    }
}