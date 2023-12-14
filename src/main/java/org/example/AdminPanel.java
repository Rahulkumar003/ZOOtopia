package org.example;

import java.util.List;
import java.util.Scanner;

import static org.example.Main.*;

public class AdminPanel {
    private Admin admin;
    private Scanner scanner;

    public AdminPanel(Admin admin1) {
        this.admin = admin1;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            displayAdminMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageAttractions();
                    break;
                case 2:
                    manageAnimals();
                    break;
                case 3:
                    scheduleEvents();
                    break;
                case 4:
                    setDiscounts();
                    break;
                case 5:
                    setSpecialDeal();
                    break;
                case 6:
                    viewVisitorStats();
                    break;
                case 7:
                    viewFeedback();
                    break;
                case 8:
                    System.out.println("Exiting Admin panel.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 8);
    }

    private void displayAdminMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. Manage Attractions");
        System.out.println("2. Manage Animals");
        System.out.println("3. Schedule Events");
        System.out.println("4. Set Discounts");
        System.out.println("5. Set Special Deal");
        System.out.println("6. View Visitor Stats");
        System.out.println("7. View Feedback");
        System.out.println("8. Exit");
        System.out.println("Enter your choice: ");
    }
    private void displayAttractionMenu() {
        System.out.println("Manage Attractions:\n" +
                "1. Add Attraction\n" +
                "2. View Attractions\n" +
                "3. Modify Attraction\n" +
                "4. Remove Attraction\n" +
                "5. Exit\n" +
                "Enter your choice: ");
    }
    public void displayManageAnimalsMenu() {
        System.out.println("Manage Animals:");
        System.out.println("1. Add Animal");
        System.out.println("2. Update Animal Details");
        System.out.println("3. Remove Animal");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    private void manageAttractions()
    {
        int choice;
        displayAttractionMenu();
        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Attraction Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Attraction Description: ");
                String description = scanner.nextLine();

                AttractionManager.addAttraction(name, description);
                System.out.println("Attraction added successfully.");
                break;

            case 2:
                List<Attraction> attractions = AttractionManager.getAttractions();
                System.out.println("Attractions in the Zoo:");
                System.out.println("UniqueId"+"  AttractionName " + "Description");
                for (Attraction attraction : attractions) {
                    System.out.println(attraction.getUniqueId()+". "+attraction.getName() + "  " + attraction.getDescription());
                }
                break;
            case 3:
                List<Attraction> attractions2 = AttractionManager.getAttractions();
                System.out.println("Attractions in the Zoo:");
                System.out.println("UniqueId"+"  AttractionName " + "Description");
                for (Attraction attraction : attractions2) {
                    System.out.println(attraction.getUniqueId()+". "+attraction.getName() + "  " + attraction.getDescription());
                }
                System.out.print("Enter Attraction Id: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter New Attraction Name: ");
                String name2 = scanner.nextLine();
                System.out.print("Enter New Attraction Description: ");
                String description2 = scanner.nextLine();
                AttractionManager.ModifyAttraction(id-1,name2,description2);
                break;
            case 4:
                List<Attraction> attractions3 = AttractionManager.getAttractions();
                System.out.println("Attractions in the Zoo:");
                System.out.println("UniqueId"+"  AttractionName " + "Description");
                for (Attraction attraction : attractions3) {
                    System.out.println(attraction.getUniqueId()+". "+attraction.getName() + "  " + attraction.getDescription());
                }
                System.out.print("Enter Attraction Id: ");
                int id1 = scanner.nextInt();
                AttractionManager.deleteAttraction(id1-1);
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }
    }

    public void manageAnimals() {
        int choice;
        displayManageAnimalsMenu();
        choice = scanner.nextInt();
        scanner.nextLine();
            switch (choice) {
                case 1:
                    // Add Animal
                    System.out.print("Enter Animal Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Animal Type (Mammal, Amphibian, or Reptile): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter the Sound Animal make: ");
                    String sound = scanner.nextLine();
                    System.out.print("Description of Animal : ");
                    String description = scanner.nextLine();
                    if (Zoo.isValidAnimalType(type)) {
                        Animal animal = null;

                        if (type.equals("Mammal")) {
                            animal = new Mammal(name,sound,description);
                        } else if (type.equals("Reptile")) {
                            animal = new Reptile(name,sound,description);
                        } else if (type.equals("Amphibian")) {
                            animal = new Amphibian(name,sound,description);
                        }

                        if (animal != null) {
                            Zoo.addAnimal(animal);
                            System.out.println("Animal added to Zoo.");
                        } else {
                            System.out.println("Invalid animal type. Animal not added.");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid animal type. Animal not added.");
                    }
                    break;

                case 2:
                    // View Animals
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
                    break;

                case 3:
                    // Remove Animal
                    System.out.print("Enter the name of the animal to remove: ");
                    String animalName = scanner.nextLine();
                    if (Zoo.removeAnimal(animalName)) {
                        System.out.println(animalName + " removed from the zoo.");
                    } else {
                        System.out.println("Animal not found in the zoo.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting Manage Animals.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
    }

    private void scheduleEvents() {
//        Schedule Events: Admins can select when the attractions are open or closed and also select
//        the price of entry ticket necessary for the attractions.
//        The attraction should also maintain the count of ticketed visitors.
        List<Attraction> attractions3 = AttractionManager.getAttractions();
        System.out.println("Attractions in the Zoo:");
        System.out.println("UniqueId"+"  AttractionName " + "Description");
        for (Attraction attraction : attractions3) {
            System.out.println(attraction.getUniqueId()+". "+attraction.getName() + "  " + attraction.getDescription());
            System.out.println("Schedule: "+attraction.getSchedule());
        }
        System.out.println("\n");

        System.out.println("1.Set ticket prices");
        System.out.println("2.Change Event Schedule");
        System.out.println("Enter Choice :");
        int Choice=scanner.nextInt();
        scanner.nextLine();
        if (Choice==1) {
            System.out.println("Attractions in the Zoo:");
            System.out.println("UniqueId"+"  AttractionName " + "Description");
            for (Attraction attraction : attractions3) {
                System.out.println(attraction.getUniqueId() + ". " + attraction.getName() + "  " + attraction.getDescription());
                System.out.println("Schedule :"+attraction.getSchedule());
                System.out.println("Enter ticket price: ₹");
                int price = scanner.nextInt();
                scanner.nextLine();
                AttractionManager.ChangePrice(attraction.getUniqueId(), price);
            }
        }
        else if (Choice==2) {
            System.out.println("Attractions in the Zoo:");
            System.out.println("UniqueId"+"  AttractionName " + "Description");
            for (Attraction attraction : attractions3) {
                System.out.println(attraction.getUniqueId()+". "+attraction.getName() + "  " + attraction.getDescription());
                System.out.println("Schedule :"+attraction.getSchedule());
            }
            System.out.println("Enter UniqueId of attraction :");
            int uniqueIdToModify = scanner.nextInt();
            scanner.nextLine();
            int size= AttractionManager.getAttractions().size();
                if (uniqueIdToModify < size ) {
                    AttractionManager.Change_schedule(uniqueIdToModify);
                }
                else {
                    System.out.println("Attraction with the specified UniqueId not found.");
                }
            }
    }

    private void setDiscounts() {
        int discountChoice;
        do {
            System.out.println("Set Discounts:");
            System.out.println("1. Add Discount");
            System.out.println("2. Modify Discount");
            System.out.println("3. Remove Discount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            discountChoice = scanner.nextInt();
            scanner.nextLine();

            switch (discountChoice) {
                case 1:
//                    addDiscount();
                    System.out.println("Enter Discount Category:");
                    String distype=scanner.nextLine();
                    System.out.println(" Enter Discount Percentage (e.g., 20 for 20%):");
                    int perc=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Discount code");
                    String code=scanner.nextLine();
                    Discount discount=new Discount(distype,perc,code);
                    DiscountManager.add_discount(discount);
                    System.out.println("Discount added successfully.");
                    break;
                case 2:
//                    modifyDiscount();
                    DiscountManager.printDiscounts();
                    System.out.println("Enter Id ");
                    int discountId =scanner.nextInt();
                    scanner.nextLine();
                    if (discountId < 1 || discountId > DiscountManager.discounts.size()) {
                        System.out.println("Invalid discount ID. No changes will be made.");
                    } else {
                        Discount oldDiscount = DiscountManager.discounts.get(discountId - 1);

                        System.out.println("Enter the new Discount Category:");
                        String newType = scanner.nextLine();

                        System.out.println("Enter the new Discount Percentage (e.g., 20 for 20%):");
                        int newPercentage = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline

                        System.out.println("Enter the new Discount code:");
                        String newCode = scanner.nextLine();

                        // Create a new Discount object with updated information
                        Discount newDiscount = new Discount(discountId,newType, newPercentage, newCode);
                        // Replace the old discount with the new one
                        DiscountManager.discounts.set(discountId - 1, newDiscount);

                        System.out.println("Discount updated successfully.");
                    }
                    break;
                case 3:
//                    removeDiscount();
                    DiscountManager.printDiscounts();
                    System.out.println("Enter Id ");
                    int discountId1 =scanner.nextInt();
                    scanner.nextLine();
                    if (discountId1 < 1 || discountId1 > DiscountManager.discounts.size()) {
                        System.out.println("Invalid discount ID. No changes will be made.");
                    } else {
                        DiscountManager.discounts.remove(discountId1 - 1);
                        System.out.println("Discount Removed successfully");
                    }
                    break;
                case 4:
                    System.out.println("Exiting Discount Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (discountChoice != 4);
    }
    private void setSpecialDeal() {
        int specialDealChoice;
        do {
            System.out.println("Set Special Deals:");
            System.out.println("1. Add Special Deal");
            System.out.println("2. Remove Special Deal");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            specialDealChoice = scanner.nextInt();
            scanner.nextLine();

            switch (specialDealChoice) {
                case 1:
//                    addSpecialDeal();
                    System.out.println("Enter Deal Type:");
                    String dealtype=scanner.nextLine();
                    System.out.println(" Enter Deal Percentage (e.g., 20 for 20%):");
                    int percent=scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Deal applicable on Tickets");
                    int tickets=scanner.nextInt();
                    SpecialDeal deal=new SpecialDeal(dealtype,percent,tickets);
                    SpecialDealManager.addDeals(deal);
                    System.out.println("Special Deal added successfully.");
                    break;
                case 2:
                        SpecialDealManager.printDeals();
                    System.out.println("Enter Deal Id:");
                    int id1=scanner.nextInt();
                    scanner.nextLine();
                    SpecialDealManager.removedeal(id1);
                    System.out.println("Special Deal removed successfully.");
//                    removeSpecialDeal();
                    break;
                case 3:
                    System.out.println("Exiting Special Deals Menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (specialDealChoice != 3);
    }


    private void viewVisitorStats() {
        System.out.println("Visitor Statistics: ");
        System.out.println(" Total Visitors: "+VisitorMenu.getTotal_visitor() );
        System.out.println("Total Revenue: "+VisitorMenu.getTotal_revenue());
        System.out.println(" Most Popular Attraction:");
    }

    private void viewFeedback() {
        FeedbackManager.printallfeeds();
    }

}
