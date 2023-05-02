// Ragged Array demonstration
// Michael Madden, Feb 2001


public class ArrayRag
{
  public static void main(String[] args) throws java.io.IOException
  {
    int r, c;

    System.out.println("\nRagged 2D array: \n");
    int[][] ragged = new int[3][];

    // First row: 3 cols
    ragged[0] = new int[3];
    ragged[0][0] = 2;
    ragged[0][1] = 4;
    ragged[0][2] = 6;

    // Second row: 10 cols
    ragged[1] = new int[10];  // default to zeros

    // Third row: 5 cols
    int[] ragRow2 = {5, 4, 3, 2, 1};
    ragged[2] = ragRow2;

    for (r=0; r<ragged.length; r++) {
       for (c=0; c<ragged[r].length; c++) {
        System.out.print(ragged[r][c] + "  ");
      }
      System.out.println();
    }

    // Pause before exit
    System.out.println("\nPress return to exit...");
    System.in.read();
  }
}


