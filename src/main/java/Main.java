import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        System.out.format("У игрока %d слотов с оружием,"
                        + " введите номер, чтобы выстрелить,"
                        + " -1 чтобы выйти%n",
                player.getSlotsCount()
        );
        int slot;
        int x = 0;
        while (true) {
            if (x > 0) {
                System.out.println("Давай еще постреляем! Выбирай заново.");
            }
            for (int i = 0; i < player.getSlotsCount(); i++) {
                System.out.print(i + 1 + ". ");
                System.out.println(player.nameOfGun(i));
                x++;
            }
            slot = scanner.nextInt();
            if (slot == -1) {
                break;
            } else {
                player.nameOfGun(slot-1);
                System.out.println(player.shotWithWeapon(slot - 1));
            }
        }
        System.out.println("Game over!");
    }
}