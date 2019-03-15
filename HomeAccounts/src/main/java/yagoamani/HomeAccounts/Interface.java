package yagoamani.HomeAccounts;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Interface {

	protected JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface window = new Interface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);

		JMenu mnView = new JMenu("Vista");
		menuBar.add(mnView);

		JMenuItem mnItmMonth = new JMenuItem("Contabilidad Mes");
		mnView.add(mnItmMonth);

		JMenuItem mnItmYear = new JMenuItem("Contabilidad Anual");
		mnView.add(mnItmYear);

		JMenuItem mnItmDebts = new JMenuItem("Deudas");
		mnView.add(mnItmDebts);

		JMenuItem mnItmGraphics = new JMenuItem("Graficos");
		mnView.add(mnItmGraphics);

		String[] columnNames = { "Fecha", "Categoria", "Importe", "%", "Comentario" };
		String[][] data = { { "01/03/2019", "AJUSTES", "-92,22", "100", "AJUSTE DE DEUDAS PENDIENTES" }, { "01/03/2019", "OCIO", "-10", "0", "SPOTIFY PUREZA" } };
		table = new JTable(data, columnNames);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		JScrollPane scrollPane = new JScrollPane(table);

		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setColumnHeaderView(scrollPane_1);
	}
}
