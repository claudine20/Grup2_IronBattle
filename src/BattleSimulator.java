
import java.util.Random;
import java.util.Scanner;

/**
 * Main RPG Battle Simulator class.
 * Provides a menu to create characters and simulate battles.
 */
public class BattleSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        Character player1 = null;
        Character player2 = null;

        while (true) {
            // Menu options
            System.out.println("\n==== RPG Battle Simulator ====");
            System.out.println("1. Create Warrior");
            System.out.println("2. Create Wizard");
            System.out.println("3. Start Battle");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 1) {
                // Create a new Warrior
                System.out.print("Enter Warrior name: ");
                String name = scanner.nextLine();
                int hp = rand.nextInt(101) + 100;  // 100-200
                int stamina = rand.nextInt(41) + 10; // 10-50
                int strength = rand.nextInt(10) + 1; // 1-10
                Warrior warrior = new Warrior(name, hp, stamina, strength);
                if (player1 == null) player1 = warrior;
                else player2 = warrior;
                System.out.println("Created Warrior: " + name + " | HP: " + hp + " | Stamina: " + stamina + " | Strength: " + strength);

            } else if (option == 2) {
                // Create a new Wizard
                System.out.print("Enter Wizard name: ");
                String name = scanner.nextLine();
                int hp = rand.nextInt(51) + 50;   // 50-100
                int mana = rand.nextInt(41) + 10; // 10-50
                int intelligence = rand.nextInt(50) + 1; // 1-50
                Wizard wizard = new Wizard(name, hp, mana, intelligence);
                if (player1 == null) player1 = wizard;
                else player2 = wizard;
                System.out.println("Created Wizard: " + name + " | HP: " + hp + " | Mana: " + mana + " | Intelligence: " + intelligence);

            } else if (option == 3) {
                // Battle logic
                if (player1 == null || player2 == null) {
                    System.out.println("You need two characters to battle!");
                    continue;
                }

                System.out.println("\n==== Battle Start ====");
                System.out.println(player1.getName() + " VS " + player2.getName());

                // Added 28/07/2025
                boolean battleFinished = false;

                while (!battleFinished) {
                    int round = 1;

                    // Battle round loop

                    while (player1.getIsAlive() && player2.getIsAlive()) {
                        System.out.println("\n-- Round " + round + " --");
                        ((Attacker) player1).attack(player2);  // Player1 attacks player2
                        ((Attacker) player2).attack(player1);  // Player2 attacks player1

                        // Display current HP
                        System.out.println(player1.getName() + " HP: " + player1.getHp());
                        System.out.println(player2.getName() + " HP: " + player2.getHp());
                        round++;
                    }

                    // If both died at same time = tie
                    if (!player1.getIsAlive() && !player2.getIsAlive()) {
                        System.out.println("\nIt's a tie! Restarting the battle with new HP...");

                        // Reset HP for each based on type
                        if (player1 instanceof Warrior) {
                            player1.setHp(rand.nextInt(101) + 100); // 100–200
                        } else {
                            player1.setHp(rand.nextInt(51) + 50); // 50–100
                        }
                        player1.setIsAlive(true);

                        if (player2 instanceof Warrior) {
                            player2.setHp(rand.nextInt(101) + 100); // 100–200
                        } else {
                            player2.setHp(rand.nextInt(51) + 50); // 50–100
                        }
                        player2.setIsAlive(true);

                        // Print new stats
                        System.out.println(player1.getName() + " new HP: " + player1.getHp());
                        System.out.println(player2.getName() + " new HP: " + player2.getHp());

                    } else if (player1.getIsAlive()) {
                        System.out.println("\nWinner: " + player1.getName());
                        battleFinished = true;
                    } else {
                        System.out.println("\nWinner: " + player2.getName());
                        battleFinished = true;
                    }
                }

            } else if (option == 4) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}