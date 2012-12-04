import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;


public class Applicaion_Window {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static  Applicaion_Window window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Applicaion_Window();
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
	public Applicaion_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 636, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("True-False", null, panel, null);
		panel.setLayout(new MigLayout("", "[][][grow][][][]", "[][][][grow][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Question Title(Optional)");
		panel.add(lblNewLabel, "cell 1 1,alignx right,aligny top");
		
		textField = new JTextField();
		panel.add(textField, "cell 2 1 4 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Question");
		panel.add(lblNewLabel_1, "cell 1 3,alignx right,aligny top");
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea, "cell 2 3 4 1,height 70,grow");
		
		JButton btnNewButton_1 = new JButton("Save to file");
		panel.add(btnNewButton_1, "cell 1 4,alignx center,aligny top");
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Correct Answer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_7, "cell 2 4");
		panel_7.setLayout(new MigLayout("", "[][][][][][]", "[][][]"));
		
		JRadioButton rdbtnTrue = new JRadioButton("True");
		panel_7.add(rdbtnTrue, "cell 2 2,growx");
		
		JRadioButton rdbtnFalse = new JRadioButton("False");
		panel_7.add(rdbtnFalse, "cell 4 2,growx");
		
		JButton btnNewButton = new JButton("Clear Text");
		panel.add(btnNewButton, "cell 5 4,aligny top");
		
		JButton btnNewButton_2 = new JButton("Add Another");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton_2, "cell 1 5,alignx center");
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Matching", null, panel_2, null);
		panel_2.setLayout(new MigLayout("", "[][][grow][][][][]", "[][][][50,grow][][]"));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_2.add(lblNewLabel_2, "cell 1 1,alignx trailing");
		
		textField_1 = new JTextField();
		panel_2.add(textField_1, "cell 2 1 5 1,growx");
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Add Q&A");
		
		panel_2.add(btnNewButton_3, "cell 1 3,sizegroupx 1,sizegroupy 1,aligny top");
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "cell 2 3 4 1,grow");
		
		final JPanel panel_8 = new JPanel();
		scrollPane.setViewportView(panel_8);
		panel_8.setLayout(new MigLayout("", "[][grow][20][][grow]", "[][][][][][]"));
		
		btnNewButton_3.addActionListener(new ActionListener() {
			
			char letter = 'A';
			public void actionPerformed(ActionEvent e) {
				
				JLabel lblNewLabel_3 = new JLabel(Character.toString(letter));
				panel_8.add(lblNewLabel_3, "alignx trailing");
				
				textField_2 = new JTextField();
				panel_8.add(textField_2, "growx");
				textField_2.setColumns(10);
				
				JLabel lblNewLabel_4 = new JLabel(Character.toString(letter));
				panel_8.add(lblNewLabel_4, "skip,alignx trailing");
				
				textField_3 = new JTextField();
				panel_8.add(textField_3, "growx,wrap");
				textField_3.setColumns(10);
				letter++;
				window.frame.repaint();
			}
		});
		
		
		JButton btnNewButton_4 = new JButton("Save to File");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(btnNewButton_4, "cell 1 4,sizegroupx 1,sizegroupy 1");
		
		JButton btnNewButton_5 = new JButton("Add Another");
		panel_2.add(btnNewButton_5, "cell 1 5,sizegroupx 1,sizegroupy 1");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Multiple Choice", null, panel_1, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Short Answer", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Numerical", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Calculated", null, panel_5, null);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Essay", null, panel_6, null);
	}

}
