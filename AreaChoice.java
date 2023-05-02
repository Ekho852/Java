import java.util.Scanner;

/*String shape = input.nextLine().toUpperCase(); used to convert input to upper case
 *equalsIgnoreCase used to simply ignore case of input string
 *println = Print + New line while printf(\n) also does new line*/	

public class AreaChoice {
    public static void main(String[] args) 
    {
    	Scanner input = new Scanner(System.in);
        System.out.println("Enter 'T' for triangle or 'R' for rectangle:");
        String shape = input.nextLine();
        
        if (shape.equalsIgnoreCase("T")) 
        {
            System.out.println("Enter base width of triangle:");
            double baseWidth = input.nextDouble();
            System.out.println("Enter height of triangle:");
            double height = input.nextDouble();
            double area = 0.5 * baseWidth * height;
            System.out.printf("Area of triangle is: %.2f", area);
        } 
        
        else if (shape.equalsIgnoreCase("R")) 
        {
            System.out.println("Enter width of rectangle:");
            double width = input.nextDouble();
            System.out.println("Enter height of rectangle:");
            double height = input.nextDouble();
            double area = width * height;
            System.out.printf("Area of rectangle is: %.2f", area);
        }
        
        else 
        {
            System.out.println("Invalid input");
        }
        
        input.close();
       
    }
}