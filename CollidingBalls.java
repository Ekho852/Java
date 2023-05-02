import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;



public class CollidingBalls extends JPanel 
{
    private static final long serialVersionUID = 1L;
    private int WIDTH = 640;//Box height and width
    private int HEIGHT = 480;
    private Color[] COLORS = {Color.RED, Color.ORANGE, Color.YELLOW,
    		Color.GREEN, Color.BLUE, Color.MAGENTA, Color.PINK, 
    		Color.CYAN, Color.GRAY, Color.WHITE};//Array of Colours for the balls
    private int numBalls;//variable to store input number of balls
    private Ball[] balls;//array to store equivalent number of balls
    private int lastColorIndex = -1;//variable to reset colour array

    public CollidingBalls(int numBalls) //method to start number of threads equal to number of balls
    {
        this.numBalls = numBalls;
        balls = new Ball[numBalls];
        for (int i = 0; i < numBalls; i++) 
        {
            balls[i] = new Ball();
            new Thread(balls[i]).start();
        }
    }

    public void paintComponent(Graphics g) //Used to colour multiple balls
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < numBalls; i++) 
        {
            g2d.setColor(balls[i].getColor());
            g2d.fill(new Ellipse2D.Double(balls[i].getX(), balls[i].getY(), balls[i].getRadius() * 2, balls[i].getRadius() * 2));
        }
    }

    private class Ball implements Runnable 
    {
        private double x; //ball variables such as x,y coords, x,y speed, radius and color
        private double y;
        private double dx;
        private double dy;
        private double radius;
        private Color color;

        public Ball() //Assigns variables to each ball 
        {
            WIDTH = Math.max(WIDTH, 10);
            HEIGHT = Math.max(HEIGHT, 10);
            x = new Random().nextInt(WIDTH - 25) + 30; //random used to space out balls
            y = new Random().nextInt(HEIGHT - 25) + 30;
            dx = 3;
            dy = 3;
            radius = 25;
            color = getNextColor();
        }

        public double getX() //returns x coord for paint component 
        {
            return x;
        }

        public double getY()//returns y coord for paint component  
        {
            return y;
        }

        public double getRadius()//returns radius for paint component   
        {
            return radius;
        }

        public Color getColor()//returns colour for paint component 
        {
            return color;
        }

        private Color getNextColor()//Goes through color array to return different color sequentially  
        {
            lastColorIndex = (lastColorIndex + 1) % COLORS.length;
            return COLORS[lastColorIndex];
        }
        
        
        private boolean hasCollision(Ball other)
        /*boolean method used to check if distance between two balls 
          and returns true if distance is smaller than that of the two ball radius
          ie the two balls are impacting each other 	*/
        {
        double distance = Math.sqrt(Math.pow(x - other.x, 2) + Math.pow(y - other.y, 2));
        return distance < radius + other.radius;
        }
        
        public void run() 
        {
            while (!Thread.currentThread().isInterrupted()) 
            {	
                
                x += dx;//updates ball position by adding speed to position
                y += dy;
                
                if (x - radius < 0) 
                {
                    dx = -dx;
                    x = radius;
                } 
                else if (x + radius > WIDTH)//checks if ball hits wall and if it does then change direction
                {
                    dx = -dx;
                    x = WIDTH - radius;
                }
                
                if (y - radius < 0) 
                {
                    dy = -dy;
                    y = radius;
                } 
                else if (y + radius > HEIGHT)//checks if ball hits wall and if it does then change direction
                {
                    dy = -dy;
                    y = HEIGHT - radius;
                }
                
                synchronized (CollidingBalls.this)//Synchronizes threads to access at same time
                {
                    for (int i = 0; i < numBalls; i++) 
                    {
                        Ball other = balls[i];
                        if (other != this && hasCollision(other))
                        //if collision has occurred then reverse speed/direction of balls	
                        {
                            double tempDx = dx;
                            double tempDy = dy;
                            dx = other.dx;
                            dy = other.dy;
                            other.dx = tempDx;
                            other.dy = tempDy;
                            break;
                        }
                    }
                }
                            
                
                repaint();//updates position of ball
                
                try 
                {
                    Thread.sleep(10);//slows down animation to 10ms refresh
                } 
                catch (InterruptedException e) 
                
                {
                    Thread.currentThread().interrupt();//break thread if error occurs
                }
            }
        }

   }
    
    
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Colliding Balls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int numBalls = Integer.parseInt(javax.swing.JOptionPane.showInputDialog(frame, 
        													"Enter number of balls:"));
        frame.setSize(640, 480);
        frame.add(new CollidingBalls(numBalls));
        frame.setVisible(true);
    }
}
