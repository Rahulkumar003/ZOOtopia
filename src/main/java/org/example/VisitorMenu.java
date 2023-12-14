package org.example;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import static org.example.Main.*;
import static org.example.Main.AttractionManager.getAttractions;

public class VisitorMenu extends Visitor  {
    private Visitor visitor;
    private static int Total_visitor=0;
    private static int Total_revenue=0;

    private static Scanner scanner;
    static Membership Basic =new Membership("Basic",20);
    static Membership Premium =new Membership("Premium",50);
    public VisitorMenu() {
        scanner = new Scanner(System.in);
    }

    public static void start(Visitor curr_visitor) {
        int choice;
        do {
            displayVisitorMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    exploreZoo();
                    break;
                case 2:
                    buyMembership(curr_visitor);
                    break;
                case 3:
                    buyTickets(curr_visitor);
                    break;
                case 4:
                    ViewDiscounts();
                    break;
                case 5:
                    ViewSpecialDeals();
                    break;
                case 6:
                    // Visit Animals
                    // Display a list of available animals
                    List<Animal> animals = Zoo.getAnimals();
                    if (animals.isEmpty()) {
                        System.out.println("No animals in the zoo.");
                    } else {
                        System.out.println("Animals in the Zoo:");
                        for (Animal animal : animals) {
                            System.out.println("Name: " + animal.getName());
                            System.out.println("Type: " + animal.getType());
                            System.out.println("Sound: " + animal.getSound());
                            System.out.println("Description: " + animal.getDescription());
                            System.out.println();
                        }
                    }
                    System.out.println("Select an animal to visit:");
                    int animalChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (animalChoice >= 1 && animalChoice <= animals.size()) {
                        visitAnimal(animals.get(animalChoice - 1));
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 7:
                    // Visit Attractions
                    List<Attraction> attractions3 = AttractionManager.getAttractions();
                    System.out.println("Select an attraction to visit:");
                    System.out.println("Attractions in the Zoo:");
                    System.out.println("UniqueId"+"  AttractionName " );
                    for (Attraction attraction : attractions3) {
                        System.out.println(attraction.getUniqueId() + ". " + attraction.getName());
                    }
                        int attractionChoice = scanner.nextInt();
                        scanner.nextLine();

                    if (attractionChoice >= 1 && attractionChoice <= attractions3.size()) {
                        visitAttraction(attractions3.get(attractionChoice - 1),curr_visitor);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 8:
                    leaveFeedback();
                    break;
                case 9:
                    System.out.println("Logging out.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 9);}
        public static void visitAnimal(Animal animal) {
            System.out.println("You are visiting the " + animal.getName() + ".");

            // Ask the visitor to choose between feeding or reading about the animal
            System.out.println("Choose an option:");
            System.out.println("1. Feed the animal");
            System.out.println("2. Read about the animal");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    feedAnimal(animal);
                    break;
                case 2:
                    readAboutAnimal(animal);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        public static void feedAnimal(Animal animal) {
            // You can implement specific feeding behaviors for different animal types
            // For example, for a lion, it can roar.
            System.out.println("You are feeding the " + animal.getName() + ". It makes a noise: " + animal.getSound());
        }

        public static void readAboutAnimal(Animal animal) {
            // Display a brief passage about the animal's history
            System.out.println("You are reading about the " + animal.getName() + ".");
            System.out.println("Description: "+animal.getDescription());
        }


        public static void visitAttraction(Attraction attraction,Visitor visitor) {
            if (visitor.getMembership().equals("Basic")){
                int tickets=attraction.getTicketcount();
                    if(tickets<1){
                        System.out.println("Ticket not available. Basic Members need to buy separate tickets for the attractions.");
                    }
                    else {
                        attraction.setTicketcount(tickets-1);
                        System.out.println("Thanks for visiting "+attraction.getName());
                    }
            }
            else {
                System.out.println("Thanks for visiting "+attraction.getName());
            }
        }

    public static void displayVisitorMenu() {
        System.out.println("Visitor Menu:");
        System.out.println("1. Explore the Zoo");
        System.out.println("2. Buy Membership");
        System.out.println("3. Buy Tickets");
        System.out.println("4. View Discounts");
        System.out.println("5. View Special Deals");
        System.out.println("6. Visit Animals");
        System.out.println("7. Visit Attractions");
        System.out.println("8. Leave Feedback");
        System.out.println("9. Log Out");
        System.out.print("Enter your choice: ");
    }

    public static void exploreZoo() {
        int choice;
        do {
            System.out.println("Explore the Zoo:\n" +
                    "1. View Attractions\n" +
                    "2. View Animals\n" +
                    "3. Exit\n");
            System.out.println("Enter your Choice :");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    List<Attraction> attractions = getAttractions();
                    System.out.println("Attractions in the Zoo:");
                    for (Attraction attraction : attractions) {
                        System.out.println(attraction.getUniqueId() + ". " + attraction.getName());
                    }
                    if (!attractions.isEmpty()){
                    System.out.println("Enter your Choice :");
                    int choice1 = scanner.nextInt();
                    scanner.nextLine();
                    int size=getAttractions().size();
                    if (choice < size) {
                        System.out.println(attractions.get(choice1).getDescription());
                    }
                    else {
                        System.out.println("Select a valid choice.");
                    }
                    }
                }
                case 2 -> {
                    List<Animal> animals = Zoo.getAnimals();
                    if (animals.isEmpty()) {
                        System.out.println("No animals in the zoo.");
                    } else {
                        System.out.println("Animals in the Zoo:");
                        for (Animal animal : animals) {
                            System.out.println("Name: " + animal.getName());
                            System.out.println("Type: " + animal.getType());
                            System.out.println("Description: " + animal.getDescription());
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Thanks for visiting zoo");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while(choice!=3);
    }

    public static void buyMembership(Visitor curr_visitor) {
        System.out.println("Buy Membership:");
        System.out.println("1. Basic Membership (₹20)");
        System.out.println("2. Premium Membership (₹50)");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            // Buy Basic Membership
            curr_visitor.setMembership(Basic);
            Total_revenue+=20;
            int curr_balance=curr_visitor.getBalance()-20;
            curr_visitor.setBalance(curr_balance);
            System.out.println("Basic Membership purchased successfully. Your balance is now ₹." +curr_visitor.getBalance());
            Total_visitor++;
        } else if (choice == 2) {
//            // Buy Premium Membership
            curr_visitor.setMembership(Premium);
            Total_revenue+=50;
            Total_visitor++;
            int curr_balance=curr_visitor.getBalance()-50;
            curr_visitor.setBalance(curr_balance);
            System.out.println("Premium Membership purchased successfully. Your balance is now ₹." +curr_visitor.getBalance());
        } else {
            System.out.println("Invalid choice.");
        }

        // Close the scanner
        scanner.close();
    }
    public static void buyTickets(Visitor visitor){
        if (visitor.getMembership().equals("Basic")) {
            System.out.println("Buy Tickets:\n" + "Select an Attraction to Buy a Ticket:");
            List<Attraction> attractions = getAttractions();
            System.out.println("Attractions in the Zoo:");
            for (Attraction attraction : attractions) {
                System.out.println(attraction.getUniqueId() + ". " + attraction.getName() + "(rupees:" + attraction.getTicketPrice() + ")");
            }
            int choice1 = scanner.nextInt();
            scanner.nextLine();
            Attraction attraction = attractions.get(choice1);
//                 Apply the discount if valid
//                int discountedPrice = applyDiscount(totalTicketPrice, discountCode);

//                // Deduct the ticket price from the visitor's balance
            if (visitor.getBalance() > attraction.getTicketPrice()) {
                int count=attraction.getTicketcount();
                attraction.setTicketcount(++count);
                attraction.setFinalcount(++count);
                int balance=visitor.getBalance();
                    balance-=attraction.getTicketPrice();
                    visitor.setBalance(balance);
                    VisitorMenu.Total_revenue+=attraction.getTicketPrice();
                    System.out.println("Tickets purchased successfully. Enjoy your visit!");
                }
                else {
                    System.out.println("Insufficient balance to purchase tickets.");
                }
        } else {
                System.out.println("Only basic users can buy tickets.");
            }
    }
    public static void ViewDiscounts() {
        DiscountManager.printDiscounts();
    }
    public static void ViewSpecialDeals(){
        SpecialDealManager.printDeals();
    }

    public static void leaveFeedback() {
        System.out.println("Leave Feedback: ");
        System.out.println("Enter your feedback (max 200 characters): ");
        String string1= scanner.nextLine();
        Feedback feed1=new Feedback(string1);
        System.out.println("Thank you for your feedback.");
    }


    public static int getTotal_visitor() {
        return Total_visitor;
    }

    public static int getTotal_revenue() {
        return Total_revenue;
    }
//    public static Attraction get_mostrevenue(){
////
//        return Attraction;
//    }
    public void login() {
    }
    public void register() {
    }

}
