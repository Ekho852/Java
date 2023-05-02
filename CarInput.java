import java.util.Scanner;

public class CarInput {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car1 = new Car();
        car1.make = "Toyota";
        car1.model = "Corolla";
        car1.year = 2015;
        car1.colour = "silver";
        car1.odometer = 158942;
        car1.convertible = false;
        
        Car car2 = new Car();
        car2.make = "Tesla";
        car2.model = "Model 3";
        car2.year = 2020;
        car2.colour = "red";
        car2.odometer = 563245;
        car2.convertible = false;
        
        Car car3 = new Car();
        car3.make = "Audi";
        car3.model = "TT Roadster";
        car3.year = 2023;
        car3.colour = "white";
        car3.odometer = 5620;
        car3.convertible = true;
        
        System.out.println("Which car would you like to view? (1, 2, or 3)");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println(car1.make);
                System.out.println(car1.model);
                System.out.println(car1.colour);
                System.out.println(car1.year);
                System.out.println(car1.odometer + " Km");
                System.out.println("Convertible? " + car1.convertible);
                break;
            case 2:
                System.out.println(car2.make);
                System.out.println(car2.model);
                System.out.println(car2.colour);
                System.out.println(car2.year);
                System.out.println(car2.odometer + " Km");
                System.out.println("Convertible? " + car2.convertible);
                break;
            case 3:
                System.out.println(car3.make);
                System.out.println(car3.model);
                System.out.println(car3.colour);
                System.out.println(car3.year);
                System.out.println(car3.odometer + " Km");
                System.out.println("Convertible? " + car3.convertible);
                break;
            default:
                System.out.println("Invalid choice");
        }
        
        scanner.close();
    }
    
}