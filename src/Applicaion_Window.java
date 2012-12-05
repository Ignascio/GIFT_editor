import java.awt.Container;
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
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;


public class Applicaion_Window {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static  Applicaion_Window window;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	protected Container panel_8;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_12;

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
		panel_2.setLayout(new MigLayout("", "[][][grow][][][][]", "[][][][50,grow][][][]"));
		
		JLabel lblNewLabel_2 = new JLabel("Question Title(Optional)");
		panel_2.add(lblNewLabel_2, "cell 0 1 2 1");
		
		textField_1 = new JTextField();
		panel_2.add(textField_1, "cell 2 1 5 1,growx");
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Add Q&A");
		
		panel_2.add(btnNewButton_3, "cell 0 3 2 1,sizegroupx 1,alignx right,sizegroupy 1,aligny top");
		
		
		
		final JPanel panel_8 = new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "cell 2 3 4 1,grow");
		scrollPane.setViewportView(panel_8);
		panel_8.setLayout(new MigLayout("", "[][grow][][][grow]", "[][][][][][]"));
		
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
		panel_2.add(btnNewButton_5, "cell 1 6,sizegroupx 1,sizegroupy 1");
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Short Answer", null, panel_3, null);
		panel_3.setLayout(new MigLayout("", "[][][grow][][]", "[][][][grow][grow][][][]"));
		
		JLabel lblNewLabel_8 = new JLabel("Question Title(Optional)");
		panel_3.add(lblNewLabel_8, "cell 0 1 2 1,alignx trailing");
		
		textField_6 = new JTextField();
		panel_3.add(textField_6, "cell 2 1 3 1,growx");
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Question");
		panel_3.add(lblNewLabel_9, "cell 1 3,aligny top");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_3.add(scrollPane_3, "cell 2 3 3 1,grow");
		
		JTextPane textPane = new JTextPane();
		scrollPane_3.setViewportView(textPane);
		
		JButton btnAddAnswer = new JButton("Add Answer");
		
				panel_3.add(btnAddAnswer, "cell 0 4,aligny top");
				
				JScrollPane scrollPane_4 = new JScrollPane();
				panel_3.add(scrollPane_4, "cell 2 4 3 1,grow");
				
				final JPanel panel_10 = new JPanel();
				scrollPane_4.setViewportView(panel_10);
				panel_10.setLayout(new MigLayout("", "[][grow]", "[]"));
				
				
				btnAddAnswer.addActionListener(new ActionListener() {
					char num = '1';
					public void actionPerformed(ActionEvent e) {
						
						JLabel lblNewLabel_10 = new JLabel(Character.toString(num++));
						panel_10.add(lblNewLabel_10, "alignx trailing");
						
						textField_7 = new JTextField();
						panel_10.add(textField_7, "growx,wrap");
						textField_7.setColumns(10);
						window.frame.repaint();
					}
				});
				
				JButton btnSaveToFile = new JButton("Save to File");
				panel_3.add(btnSaveToFile, "cell 0 5");
				
				JButton btnNewButton_10 = new JButton("Add Another");
				btnNewButton_10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				panel_3.add(btnNewButton_10, "cell 0 7 2 1,alignx left");
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Multiple Choice", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[][][grow][][]", "[][][][grow][][grow][][][]"));
		
		JLabel lblNewLabel_5 = new JLabel("Question Title(Optional)");
		panel_1.add(lblNewLabel_5, "cell 0 1 2 1,alignx trailing");
		
		textField_4 = new JTextField();
		panel_1.add(textField_4, "cell 2 1 3 1,growx");
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Question");
		panel_1.add(lblNewLabel_6, "cell 1 3,alignx right,aligny top");
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_1.add(scrollPane_2, "cell 2 3 3 1,grow");
		
		JTextArea textArea_1 = new JTextArea(5,1);
		scrollPane_2.setViewportView(textArea_1);
		
		JButton btnNewButton_7 = new JButton("Clear Text");
		panel_1.add(btnNewButton_7, "cell 4 4");
		
		JButton btnNewButton_6 = new JButton("Add Answer");
		
		panel_1.add(btnNewButton_6, "cell 0 5,aligny top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "cell 2 5 3 1,grow");
		
		final JPanel panel_9 = new JPanel();
		scrollPane_1.setViewportView(panel_9);
		panel_9.setLayout(new MigLayout("", "[][grow][]", "[]"));
		
		
		btnNewButton_6.addActionListener(new ActionListener() {
			
			char letter = 'A';
			
			public void actionPerformed(ActionEvent e) {
				
				JLabel lblNewLabel_7 = new JLabel(Character.toString(letter));
				panel_9.add(lblNewLabel_7, "alignx trailing");
			
				textField_5 = new JTextField();
				panel_9.add(textField_5, "growx");
				textField_5.setColumns(10);
				
				JSpinner spinner = new JSpinner();
				panel_9.add(spinner, "wrap");
				letter++;
				window.frame.repaint();
			}
		});
		
		JButton btnNewButton_8 = new JButton("Save to File");
		panel_1.add(btnNewButton_8, "cell 0 6");
		
		JButton btnNewButton_9 = new JButton("Add Another Multiple Choice");
		panel_1.add(btnNewButton_9, "cell 0 8 2 1,alignx center");
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Numerical", null, panel_4, null);
		panel_4.setLayout(new MigLayout("", "[][][grow][]", "[][][][grow][25.00][grow][][][]"));
		
		JLabel lblNewLabel_11 = new JLabel("Question Title(Optional)");
		panel_4.add(lblNewLabel_11, "cell 0 1 2 1,alignx trailing");
		
		textField_8 = new JTextField();
		panel_4.add(textField_8, "cell 2 1 2 1,growx");
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Question");
		panel_4.add(lblNewLabel_12, "cell 1 3,alignx right,aligny top");
		
		JScrollPane scrollPane_5 = new JScrollPane();
		panel_4.add(scrollPane_5, "cell 2 3 2 1,grow");
		
		textField_9 = new JTextField();
		scrollPane_5.setViewportView(textField_9);
		textField_9.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Math range");
		buttonGroup.add(rdbtnNewRadioButton);
		panel_4.add(rdbtnNewRadioButton, "flowx,cell 2 4");
		
		final JButton btnNewButton_13 = new JButton("Add Q&A");
		btnNewButton_13.setEnabled(false);
		
		panel_4.add(btnNewButton_13, "cell 0 5,aligny top");
		
		
		
		JScrollPane scrollPane_8 = new JScrollPane();
		panel_4.add(scrollPane_8, "cell 2 5 2 1,grow,hmin 130px,hmax 130px");
		
		
		final JPanel panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "Answer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane_8.setViewportView(panel_11);
		panel_11.setLayout(new MigLayout("", "[][grow][][]", "[]"));
		
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				panel_11.removeAll();
				
				JLabel lblNewLabel_15 = new JLabel("New label");
				panel_11.add(lblNewLabel_15, "alignx trailing");
				
				textField_12 = new JTextField();
				panel_11.add(textField_12, "span 2,growx");
				textField_12.setColumns(10);
				
				JSpinner spinner_1 = new JSpinner();
				panel_11.add(spinner_1, "wrap");
				
				window.frame.repaint();
			}
		});
		
		
			
		JButton btnSaveToFile_1 = new JButton("Save to File");
		panel_4.add(btnSaveToFile_1, "cell 0 6");
		
		JButton btnNewButton_11 = new JButton("Another Numerical");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_4.add(btnNewButton_11, "cell 0 8 2 1");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Math Range (interval end points)");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_11.removeAll();
				
				btnNewButton_13.setEnabled(false);
				
				textField_10 = new JTextField();
				panel_11.add(textField_10, "span 2,growx");
				textField_10.setColumns(8);
				
				JLabel lblDecimalPlace = new JLabel("Decimal Place");
				panel_11.add(lblDecimalPlace, "alignx left");
				
				JSpinner spinner = new JSpinner();
				panel_11.add(spinner, "growx,wrap");
				
				window.frame.repaint();
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		panel_4.add(rdbtnNewRadioButton_1, "cell 2 4");
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Multiple numeric");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_11.removeAll();
				btnNewButton_13.setEnabled(true);
				window.frame.repaint();
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_2);
		panel_4.add(rdbtnNewRadioButton_2, "cell 2 4");
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("Essay", null, panel_6, null);
		panel_6.setLayout(new MigLayout("", "[][][grow][]", "[][][][grow][grow][][][]"));
		
		JLabel lblNewLabel_13 = new JLabel("Question Title(Optional)");
		panel_6.add(lblNewLabel_13, "cell 0 1 2 1,alignx trailing");
		
		textField_11 = new JTextField();
		panel_6.add(textField_11, "cell 2 1 2 1,growx");
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Question");
		panel_6.add(lblNewLabel_14, "cell 0 3 2 1,alignx right,aligny top");
		
		JScrollPane scrollPane_6 = new JScrollPane();
		panel_6.add(scrollPane_6, "cell 2 3 2 1,grow");
		
		JTextArea textArea_2 = new JTextArea();
		scrollPane_6.setViewportView(textArea_2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Answer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.add(panel_5, "cell 2 4 2 1,grow");
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_7 = new JScrollPane();
		panel_5.add(scrollPane_7, BorderLayout.CENTER);
		
		JTextArea textArea_3 = new JTextArea();
		scrollPane_7.setViewportView(textArea_3);
		
		JButton btnSaveToFile_2 = new JButton("Save to File");
		panel_6.add(btnSaveToFile_2, "cell 0 5");
		
		JButton btnNewButton_12 = new JButton("Another Essay");
		panel_6.add(btnNewButton_12, "cell 0 7 2 1");
	}

}
