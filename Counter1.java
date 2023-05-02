import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Counter1 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton start = new JButton("Start");
	private JButton pause = new JButton("Pause");
	private JTextField txt = new JTextField(10);
	
	private int count = 0;
	private boolean runFlag = true; // Pause button sets this to false
	
	public Counter1() {
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		add(txt);
		start.addActionListener(new StartListener());
		add(start);
		pause.addActionListener(new PauseListener());
		add(pause);
		pack(); // make window just large enough for its GUI
		setVisible(true); // show window
	} // end Counter1 constructor
	
	private class PauseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			runFlag = !runFlag;
		}
	}

	private class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			go();
		}
	}

	public void go() {
		while(true) {
			if (runFlag)
				txt.setText(Integer.toString(count++));
			try { 
				Thread.sleep(100);
			}
			catch(InterruptedException e) {
				System.err.println("Interrupted");
			}
		}
	}
	
	public static void main(String args[]) {
		Counter1 application = new Counter1();
		application.setDefaultCloseOperation(EXIT_ON_CLOSE);
	} // end main
} // end class Counter1