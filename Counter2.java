import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Counter2 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton start = new JButton("Start");
	private JButton pause = new JButton("Pause");
	private JTextField txt = new JTextField(10);
	
	private int count = 0;
	private boolean runFlag = true; // Pause button sets this to false
	
	public Counter2() {
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		add(txt);
		start.addActionListener(new StartListener());
		add(start);
		pause.addActionListener(new PauseListener());
		add(pause);
		pack(); // make window just large enough for its GUI
		setVisible(true); // show window
	} // end Counter2 constructor
	
	private class PauseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			runFlag = !runFlag;
		}
	}

	private class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Thread t = new Thread(new SeparateSubTask());
			t.start();
		}
	}
	
	private class SeparateSubTask implements Runnable {
		public void run() {
			// Same code as go() in Counter1
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
	}
	
	public static void main(String args[]) {
		Counter2 application = new Counter2();
		application.setDefaultCloseOperation(EXIT_ON_CLOSE);
	} // end main
} // end class Counter2