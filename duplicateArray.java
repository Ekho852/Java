import java.util.Scanner;

public class duplicateArray 
{
	public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);//input
        int[] numbers = new int[5];//set array size to 5
        int count = 0;//initialize count variable
        while (count < 5) 
        {
            System.out.print("Enter a number between 10 and 100: ");
            int number = input.nextInt();
            if (number < 10 || number > 100)//error check for integer range
            {
                System.out.printf("Invalid input. Number must be between 10 and 100 ");
                continue;//continues through statements
            }
            
            boolean isDuplicate = false;//checks if number is already in array/duplicate
            for (int i = 0; i < count; i++)//iterates throughout array 
            {
                if (numbers[i] == number)
                {
                    isDuplicate = true;
                    break;//if duplicate the for loop is broken and restarts
                }
            }
            
            if (!isDuplicate)//if number entered is unique ie not duplicate 
            {
                numbers[count] = number;
                count++;
            }
            
            System.out.printf("Current set of unique numbers: ");//prints out array of numbers so far
            for (int i = 0; i < count; i++) 
            {
                System.out.printf(numbers[i] + " ");
            }
            
            System.out.println();//new line to separate lines but keep characters together
        }
        
        input.close();//closes input to prevent memory leaks
    }
}
