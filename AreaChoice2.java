import javax.swing.JOptionPane;

/*JOptionPane.showInputDialog = displays dialog box */

public class AreaChoice2 {
    public static void main(String[] args) 
    {
        double width, height;
        String shape;
        shape = JOptionPane.showInputDialog("Enter 'T' for triangle or 'R' for rectangle:");

        if (shape.equalsIgnoreCase("T")) // Triangle
        {
            width = Double.parseDouble(JOptionPane.showInputDialog("Enter the base width of the triangle:"));
            height = Double.parseDouble(JOptionPane.showInputDialog("Enter the height of the triangle:"));
            double area = 0.5 * width * height;
            JOptionPane.showMessageDialog(null, "The area of the triangle is: " + area);
        } 
        
        else if (shape.equalsIgnoreCase("R")) // Rectangle
        {
            width = Double.parseDouble(JOptionPane.showInputDialog("Enter the width of the rectangle:"));
            height = Double.parseDouble(JOptionPane.showInputDialog("Enter the height of the rectangle:"));
            double area = width * height;
            JOptionPane.showMessageDialog(null, "The area of the rectangle is: " + area);
        } 
        
        else // Error Handling 
        {
            JOptionPane.showMessageDialog(null, "Invalid input");
        }
        
        System.exit(0); // Terminate program
     }
}