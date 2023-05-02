import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.Random;

public class ConwaysLife extends JFrame implements Runnable, MouseListener 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// member data
    private BufferStrategy strategy;
    private Graphics offscreenBuffer;
    private boolean gameState[][] = new boolean[40][40];
    private boolean isPlaying = false;
    private Random random = new Random();
    private GameStateManager gameStateManager = new GameStateManager();
    private static String workingDirectory;
    
    private void saveGameState() 
    {
        gameStateManager.saveGameState(gameState);
    }

    private void loadGameState() 
    {
        boolean[][] loadedState = gameStateManager.loadGameState();
        if (loadedState != null) 
        {
            gameState = loadedState;
        }
    }
    
    // constructor
    public ConwaysLife() 
    {
        //Display the window, centred on the screen
        Dimension screensize =
                java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int x = screensize.width / 2 - 400;
        int y = screensize.height / 2 - 400;
        setBounds(x, y, 800, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Conway's game of life");
        // initialise double-buffering
        setIgnoreRepaint(true);
        createBufferStrategy(2);
        strategy = getBufferStrategy();
        offscreenBuffer = strategy.getDrawGraphics();
        // register the Jframe itself to receive mouse events
        addMouseListener(this);
        // initialise the game state
        for (x = 0; x < 40; x++) 
        {
            for (y = 0; y < 40; y++) 
            {
                gameState[x][y] = false;
            }
        }
        // create and start our animation thread
        Thread t = new Thread(this);
        t.start();
    }


    // thread's entry point
    public void run() 
    {
        while (true) 
        {
            // 1: sleep for 1/10 sec
            try 
            {
                Thread.sleep(100);
            } 
            catch (InterruptedException e) 
            {}
            // 2: animate game objects [nothing yet!]
            if (isPlaying) 
            {
                applyConwayRules();
            }
            // 3: force an application repaint
            this.repaint();
        }
    }

    // mouse events which must be implemented for MouseListener
    public void mousePressed(MouseEvent e) 
    {
        int x = e.getX() / 20;
        int y = e.getY() / 20;

        // Check for button clicks
        if (!isPlaying) {
            // Start button
            if (x >= 35 && x <= 37 && y >= 1 && y <= 3) 
            {
                isPlaying = true;
                return;
            }
            // Random button
            if (x >= 35 && x <= 37 && y >= 5 && y <= 7) 
            {
                randomizeGameState();
                System.out.println("Layout Randomized");
                return;
            }
            // Save button
            if (x >= 35 && x <= 37 && y >= 9 && y <= 11) 
            {
                saveGameState();
                System.out.println("Current layout saved");
                return;
            }
            // Load button
            if (x >= 35 && x <= 37 && y >= 13 && y <= 15) 
            {
                loadGameState();
                System.out.println("Layout loaded");
                return;
            }
        }
     

        // toggle the state of the cell
        gameState[x][y] = !gameState[x][y];
        // request an extra repaint, to get immediate visual feedback
        this.repaint();
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }
    
    // application's paint method
    public void paint(Graphics g) 
    {
        g = offscreenBuffer; // draw to offscreen buffer
        // clear the canvas with a big black rectangle
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 800);
        
        // draw buttons when not playing
        if (!isPlaying) {
            g.setColor(Color.GREEN);
            g.fillRect(35 * 20 + 35, 1 * 20, 40, 40); // Start button
            g.setColor(Color.BLACK);
            g.setFont(new Font("Times", Font.BOLD, 12));
            g.drawString("Start", 35 * 20 + 43, 1 * 20 + 25);

            g.setColor(Color.YELLOW);
            g.fillRect(35 * 20 + 35, 5 * 20, 40, 40); // Random button
            g.setColor(Color.BLACK);
            g.setFont(new Font("Times", Font.BOLD, 12));
            g.drawString("Rand", 35 * 20 + 43, 5 * 20 + 25);

            g.setColor(Color.CYAN);
            g.fillRect(35 * 20 + 35, 9 * 20, 40, 40); // Save button
            g.setColor(Color.BLACK);
            g.setFont(new Font("Times", Font.BOLD, 12));
            g.drawString("Save", 35 * 20 + 43, 9 * 20 + 25);

            g.setColor(Color.MAGENTA);
            g.fillRect(35 * 20 + 35, 13 * 20, 40, 40); // Load button
            g.setColor(Color.BLACK);
            g.setFont(new Font("Times", Font.BOLD, 12));
            g.drawString("Load", 35 * 20 + 43, 13 * 20 + 25);
        
        }
        // redraw all game objects
        g.setColor(Color.WHITE);
        for (int x = 0; x < 40; x++) 
        {
            for (int y = 0; y < 40; y++) 
            {
                if (gameState[x][y]) 
                {
                    g.fillRect(x * 20, y * 20, 20, 20);
                }
            }
        }
        // flip the buffers
        strategy.show();
    

    }

    private void randomizeGameState()//uses random util to generate random board 
    {
        for (int x = 0; x < 40; x++) 
        {
            for (int y = 0; y < 40; y++) 
            {
                gameState[x][y] = random.nextBoolean();
            }
        }
    }

    private void applyConwayRules()//rules of the game
    {
        boolean[][] newGameState = new boolean[40][40];

        for (int x = 0; x < 40; x++) 
        {
            for (int y = 0; y < 40; y++) 
            {
                int liveNeighbours = getLiveNeighbours(x, y);

                if (gameState[x][y]) 
                {
                	/*if game state is true ie live then game state is spread to neighbor
                	if it has 2 or 3 live neigbours*/
                    newGameState[x][y] = liveNeighbours == 2 || liveNeighbours == 3;
                } 
                else 
                {	
                	/*if game state is false (ie dead) then game state is spread to neighbor
                	if it has 3 live neigbours*/
                    newGameState[x][y]= liveNeighbours == 3;
                }
            }
         }  gameState = newGameState;//update newGameState array with new generation
    }

    private int getLiveNeighbours(int x, int y) 
    {
        int liveNeighbours = 0;

        for (int dx = -1; dx <= 1; dx++) 
        {
            for (int dy = -1; dy <= 1; dy++) 
            {
                if (dx == 0 && dy == 0) 
                {
                    continue;
                }

                int newX = x + dx;
                int newY = y + dy;
                
                if (newX >= 0 && newX < 40 && newY >= 0 && newY < 40 && gameState[newX][newY]) 
                {
                    liveNeighbours++;
                }
            }
        }

        return liveNeighbours;
    }


    //


    // application entry point
    public static void main(String[] args) 
    {
	    workingDirectory = System.getProperty("user.dir");
	    System.out.println("Working Directory = " + workingDirectory);
    	ConwaysLife w = new ConwaysLife();
    }
}