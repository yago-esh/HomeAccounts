package yagoamani.HomeAccounts;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class Interface {

	protected  JFrame frame;

	public Interface() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("New button");
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		toolBar.add(btnNewButton_2);
	}

}
