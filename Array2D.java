// 2D Array demonstration



public class Array2D
{
  public static void main(String[] args) throws java.io.IOException
  {
    final int rows = 10;
    final int cols = 5;

    int[][] table = new int[rows][cols];
    int r, c;

    // Store multiplication tables
    for (r=0; r<rows; r++) {
      for (c=0; c<cols; c++) {
        table[r][c] = r * c;
      }
    }

    //Print table
    for (r=0; r<rows; r++) {
      for (c=0; c<cols; c++) {
        System.out.print(table[r][c] + "  ");
      }
      System.out.println();
    }

    // Extract and print row from array
    System.out.println("\nHere is row 2: \n");
    int[] row2 = table[2];
    for (c=0; c<cols; c++) {
      System.out.print(row2[c] + "  ");
    }
    System.out.println();

    // Pause before exit
    System.out.println("\nPress return to exit...");
    System.in.read();
  }
}


