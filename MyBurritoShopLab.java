import java.util.Scanner;

public class MyBurritoShopLab {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        BurritoShop shop = new BurritoShop();

        boolean open = true;
        while (open) {
            shop.printStatus();
            System.out.println("\nWhat task will you do next?");
            System.out.println("   1. Take a Burrito Order");
            System.out.println("   2. Make a Burrito Order");
            System.out.println("   3. Ring Out a Burrito Order");
            System.out.println("   4. Wash Next Dish");
            System.out.println("   5. Wash All Dishes");
            System.out.println("   6. Close For the Day");

            System.out.print("Enter your choice: ");
            int choice = keyboard.nextInt();
            keyboard.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("What size [small/large]: ");
                    String size = keyboard.nextLine();
                    System.out.print("What protein [chicken/steak/carnitas/sofritas/none]: ");
                    String protein = keyboard.nextLine();
                    System.out.print("What rice [white/brown/none]: ");
                    String rice = keyboard.nextLine();
                    System.out.print("What beans [black/pinto/none]: ");
                    String beans = keyboard.nextLine();
                    System.out.print("What other toppings (comma list): ");
                    String toppings = keyboard.nextLine();
                    System.out.print("Do you want guacamole [Y/N]: ");
                    boolean guacamole = keyboard.nextLine().equalsIgnoreCase("Y");

                    BurritoLab4 order = new BurritoLab4(size, protein, rice, beans, toppings, guacamole);
                    shop.takeOrder(order);
                    break;
                case 2:
                    BurritoLab4 madeOrder = shop.makeOrder();
                    if (madeOrder != null) {
                        System.out.println("\nMade order: " + madeOrder);
                    } else {
                        System.out.println("\nNo orders to make.");
                    }
                    break;
                case 3:
                    BurritoLab4 ringOutOrder = shop.ringOutOrder();
                    if (ringOutOrder != null) {
                        System.out.printf("\nCustomer Charged $%.2f%n", ringOutOrder.calculatePrice());
                    } else {
                        System.out.println("\nNo orders to ring out - take more orders.");
                    }
                    break;
                case 4:
                    shop.washNextDish();
                    break;
                case 5:
                    System.out.println("\nWashing all dishes:");
                    shop.washAllDishes();
                    break;
                case 6:
                    if (!shop.hasOrders() && !shop.hasTransactions() && !shop.hasDirtyDishes()) {
                        System.out.println("\nGreat Work Today!");
                        open = false;
                    } else {
                        System.out.println("\nCannot close yet, there is still work to be done.");
                    }
                    break;
                default:
                    System.out.println("\nInvalid option. Please try again.");
            }
        }

        keyboard.close();
    }
}
