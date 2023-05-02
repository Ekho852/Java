import java.util.Scanner;

/*long startTime = System.currentTimeMillis(); starts timer
*long endTime = System.currentTimeMillis(); ends time*/
public class Circle {

	public static void main(String[] args) 
	{
		long startTime = System.currentTimeMillis();
		Scanner input = new Scanner(System.in);
        System.out.println("Enter radius of circle");
		int rad = input.nextInt();
		input.close();
		
		double area = rad*rad*3.14;
		double circumference = 2*rad*3.14;
        
        System.out.println("Area of Circle is " + area);
		System.out.println("Circumference of Circle is " + circumference); 
		
		System.out.printf("\nArea of Circle is %.2f\n", area);
		System.out.printf("Circumference of Circle is %.2f\n", circumference); 
		
		 
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("\nTotal time taken: " + totalTime + " milliseconds");
	}

}
