package org.example;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean isTrue = true;

        while (isTrue) {
            // Display the main menu
            System.out.println("Welcome to ZOOtopia!");
            System.out.printf("1. Enter as Admin \n2. Enter as a Visitor \n3. View Special Deals%n");
            System.out.println("Enter your choice: ");
            Zoo zoo1=new Zoo();
            DiscountManager manager1=new DiscountManager();
            SpecialDealManager manager2=new SpecialDealManager();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Admin Username: ");
                    String username = scanner.nextLine();
                    System.out.println("admin Enter Admin Password: ");
                    String password2 = scanner.nextLine();
                    Admin admin1=new Admin(username,password2);
                    boolean islogin=admin1.login(admin1);
                    if (islogin) {
                        AdminPanel adminpanel=new AdminPanel(admin1);
                        adminpanel.start();
                        break;
                    } else {
                        System.out.println("Incorrect Username or Password");
                        break;
                    }
                case 2:
                    int choice1;
                    do{
                    System.out.println("1. Register \n2. Login");
                    System.out.println("Enter your choice: ");
                    choice1 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice1) {
                        case 1:
                                System.out.println("Enter Visitor Name: ");
                                String name = scanner.nextLine();
                                System.out.println("Enter Visitor Age: ");
                                int age = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character
                                System.out.println("Enter Visitor Phone Number: ");
                                String phoneNumber = scanner.nextLine();
                                System.out.println("Enter Visitor Balance: ");
                                int balance = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character
                                System.out.println("Enter Visitor Email: ");
                                String email = scanner.nextLine();
                                System.out.println("Enter Visitor Password: ");
                                String Password = scanner.nextLine();

                                // Create a new Visitor object and add it to the visitors list
                                Visitor newVisitor = new Visitor(name, age, phoneNumber, balance, email, Password);
                                VisitorMenu visitorsMenu=new VisitorMenu();
                                VisitorManager.visitors.add(newVisitor);
                                System.out.println("Registration is successful.");

                                break;
                        case 2:
                            System.out.println("Email: ");
                            String mail = scanner.nextLine();
                            System.out.println("Password: ");
                            String password_vis = scanner.nextLine();
//                            Boolean login_details=VisitorManager.CheckLogin(mail,password_vis);
                            Visitor curr_visitor=VisitorManager.getVisitorByEmailAndPassword(mail,password_vis);
                            if (curr_visitor!=null){
                                System.out.println("Login successfull");
                                VisitorMenu.start(curr_visitor);
                            }
                            else {
                                System.out.println("Wrong email or passoword Or Visitor not registered");
                            }
                            break;
                        default:
                            System.out.println("Invalid choice. Try again.");

                    }
                    }while (choice1!=2);
                    break;
                case 3:
//                    SpecialDeal specialdeal = new SpecialDeal();
                    break;
                case 4:
                    isTrue = false; // Exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    public static class AttractionManager {
        private static List<Attraction> attractions = new ArrayList<>();

        public static void addAttraction(String name, String description) {
            Attraction newAttraction = new Attraction(name, description);
            attractions.add(newAttraction);
        }
        public static void ModifyAttraction (int Id,String name, String description) {
            Attraction attraction2=new Attraction(name,description,Id+1);
            attractions.set(Id,attraction2);
        }
        public static void deleteAttraction(int id){
            attractions.remove(id);
        }
        public static List<Attraction> getAttractions() {
            return attractions;
        }
        public static void ChangePrice(int id,int Price){
            attractions.get(id-1).setTicketPrice(Price);
        }
        public static void Change_schedule(int uniqueId){
            Attraction old=attractions.get(uniqueId-1);
            if (old.equals("open")){
                attractions.get(uniqueId-1).setSchedule("close");
            }
            else {  attractions.get(uniqueId-1).setSchedule("open");}
        }
    }
    public static class VisitorManager {
        public static List<Visitor> visitors =new ArrayList<>();
//        public static Boolean CheckLogin(String mail, String password_vis){
//            Boolean istrue=true;
//            for (Visitor each: visitors)
//            {
//                if (each.getEmail().equals(mail) && each.getPassword().equals(password_vis)){
//                    istrue=true;
//                    break;
//                }
//                else istrue= false;
//            }
//
//            return istrue;
//        }
        public static Visitor getVisitorByEmailAndPassword(String email, String password) {
            for (Visitor visitor : visitors) {
                if (visitor.getEmail().equals(email) && visitor.getPassword().equals(password)) {
                    return visitor;
                }
            }
            return null; // Return null if no matching visitor is found
        }

    }
    public static class DiscountManager{
        public static List<Discount> discounts=new ArrayList<>();

        public DiscountManager() {
            Discount minorDiscount = new Discount("Minor", 10, "MINOR10");
            // Create a "Senior Citizen" discount with 20% discount and code "SENIOR20"
            Discount seniorDiscount = new Discount("Senior Citizen", 20, "SENIOR20");
            discounts.add(minorDiscount);
            discounts.add(seniorDiscount);
        }
        public static void add_discount(Discount discount){
                discounts.add(discount);
            }

        public static void printDiscounts() {
            System.out.println("View Discounts:");
            for(Discount discount: discounts){
                System.out.println("Id"+discount.getId());
                System.out.println("Discount Category:"+discount.getDiscountCategory());
                System.out.println("Discount Percentage (e.g., 20 for 20%): "+discount.getPercentage());
            }
        }
    }

    public static class SpecialDealManager{
        public static List<SpecialDeal> alldeals=new ArrayList<>();
        public SpecialDealManager(){
            // Create a "Buy 2 tickets and get 15% off" special deal
            SpecialDeal deal1 = new SpecialDeal("Buy 2 tickets and get 15% off", 15, 2);

            // Create a "Buy 3 tickets and get 30% off" special deal
            SpecialDeal deal2 = new SpecialDeal("Buy 3 tickets and get 30% off", 30, 3);

        }
        public static void addDeals (SpecialDeal deal){
            alldeals.add(deal);
        }
        public static void printDeals(){
            System.out.println("View Special Deals:");
            for (SpecialDeal deal:alldeals){
                System.out.println("Id"+deal.getId()+deal.getDealType());

            }
        }
        public static void removedeal(int Id){
            alldeals.remove(Id-1);
        }
    }
    public static class FeedbackManager{
        public static List<Feedback> allfeedback=new ArrayList<>();
        public static void addDeals (Feedback feed){
            allfeedback.add(feed);
        }
        public static void printallfeeds(){
            for (Feedback feeds:allfeedback){
                System.out.println(feeds.getFeedback());
            }
        }
    }
    public static class TicketManager{
    }
}
