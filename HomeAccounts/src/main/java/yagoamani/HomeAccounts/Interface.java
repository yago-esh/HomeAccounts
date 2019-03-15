package yagoamani.HomeAccounts;

import java.awt.FlowLayout;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Interface {

	protected JFrame frame;
	private JTable table;
	private JLabel lbResult;
	private DefaultTableModel model;

	public Interface() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Fecha", "Categoria", "Importe", "%", "Comentario" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(61);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);

		Object[][] data = { { "01/03/2019", "AJUSTES", -92.22, 100.0, "AJUSTE DE DEUDAS PENDIENTES" },
				{ "01/03/2019", "OCIO", -10.0, 0.0, "SPOTIFY PUREZA" } };
		model = (DefaultTableModel) table.getModel();
		model.addRow(data[0]);
		model.addRow(data[1]);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		frame.getContentPane().add(menuBar);
		menuBar.setBackground(SystemColor.menu);

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
		JScrollPane scrollPaneTable = new JScrollPane(table);
		scrollPaneTable.setBounds(10, 33, 410, 149);
		frame.getContentPane().add(scrollPaneTable);

		JPanel panelResult = new JPanel();
		FlowLayout fl_panelResult = (FlowLayout) panelResult.getLayout();
		fl_panelResult.setAlignment(FlowLayout.LEFT);
		panelResult.setBounds(20, 187, 130, 21);
		frame.getContentPane().add(panelResult);

		JLabel lbTextResult = new JLabel("Resultado:");
		panelResult.add(lbTextResult);

		lbResult = new JLabel("0 €");
		panelResult.add(lbResult);

		JPanel panelFinalBalance = new JPanel();
		FlowLayout fl_panelFinalBalance = (FlowLayout) panelFinalBalance.getLayout();
		fl_panelFinalBalance.setAlignOnBaseline(true);
		fl_panelFinalBalance.setAlignment(FlowLayout.LEFT);
		panelFinalBalance.setBounds(162, 187, 130, 21);
		frame.getContentPane().add(panelFinalBalance);

		JLabel lbTextFinalBalance = new JLabel("Saldo Final:");
		panelFinalBalance.add(lbTextFinalBalance);

		JLabel lbFinalBalance = new JLabel("0 €");
		panelFinalBalance.add(lbFinalBalance);
		calculateTotal();
	}

	public void calculateTotal() {
		double value = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			value += (double) table.getValueAt(i, 2);
			System.out.println();
		}
		lbResult.setText(String.valueOf(value) + " €");
		frame.repaint();
	}
}
