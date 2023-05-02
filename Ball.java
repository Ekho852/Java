import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ball {
    private Point position;
    private Point velocity;
    private int radius;
    private Color color;
    
    public Ball(Point position, Point velocity, int radius, Color color) {
        this.position = position;
        this.velocity = velocity;
        this.radius = radius;
        this.color = color;
    }
    
    public void update(Dimension bounds) {
        position.translate(velocity.x, velocity.y);
        
        if (position.x - radius < 0) {
            position.x = radius;
            velocity.x *= -1;
        } else if (position.x + radius > bounds.width) {
            position.x = bounds.width - radius;
            velocity.x *= -1;
        }
        
        if (position.y - radius < 0) {
            position.y = radius;
            velocity.y *= -1;
        } else if (position.y + radius > bounds.height) {
            position.y = bounds.height - radius;
            velocity.y *= -1;
        }
    }
    
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(position.x - radius, position.y - radius, radius * 2, radius * 2);
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private Ball ball;
            private Dimension size = new Dimension(500, 500);
            private Random random = new Random();
            
            {
                Point position = new Point(random.nextInt(size.width), random.nextInt(size.height));
                Point velocity = new Point(random.nextInt(11) - 5, random.nextInt(11) - 5);
                int radius = 20;
                Color color = Color.RED;
                ball = new Ball(position, velocity, radius, color);
                
                setPreferredSize(size);
                
                Runnable runnable = () -> {
                    while (true) {
                        ball.update(size);
                        repaint();
                        
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                
                new Thread(runnable).start();
            }
            
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ball.draw(g);
            }
        };
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}