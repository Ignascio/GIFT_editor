import java.awt.Container;
import java.awt.EventQueue;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;


public class Applicaion_Window {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static  Applicaion_Window window;
	private JTextField textField_4;
	private JTextField textField_6;
	private  Container panel_8;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_12;
	protected JTextField textField_13;
	protected JTextField textField_14;
	protected JTextField textField_15;
	private JTextArea textArea;
	private JRadioButton rdbtnTrue;
	private JRadioButton rdbtnFalse;
	protected static FileIO IO;
	
	private static File file;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	private ArrayList<Matching> list = new ArrayList<>();
	private ArrayList<Multichoice> list1 = new ArrayList<>();
	private ArrayList<shortAnswer> list2 = new ArrayList<>();
	private JTextArea textArea_1;  
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Applicaion_Window();
					window.frame.setVisible(true);
					
//					//promt where to save file
//					JFileChooser jFileChooser = new JFileChooser();
//					jFileChooser.setSelectedFile(new File("GIFT.txt"));
//					 int returnVal = jFileChooser.showSaveDialog(window.frame);
//					
//			        if (returnVal == JFileChooser.APPROVE_OPTION) {
//			            file = jFileChooser.getSelectedFile();
//			            new File(file.getAbsolutePath()).createNewFile();
//			            //This is where a real application would open the file.
//			            
//			            IO = new FileIO(file.getAbsolutePath(), 2);
//			            
//			            System.out.println("Saving: " + file.getName() + ".");	            
//			        } else {
//			        	System.out.println("Open command cancelled by user.");
//			        }
				        
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
		
		textArea = new JTextArea();
		panel.add(textArea, "cell 2 3 4 1,height 70,grow");
		
		/*************************************************************
		 * True/False tab action
		 * 
		 *************************************************************/
		JButton btnNewButton_1 = new JButton("Save to file");
		btnNewButton_1.addActionListener(new ActionListener() {
			String Statement = "::T:: Q {A}";
			public void actionPerformed(ActionEvent e) {
				
				
				String newStatement = "";
				newStatement= Statement.replace("::T::","::"+textField.getText()+"::");
				newStatement = newStatement.replace("Q", textArea.getText());
				if(rdbtnTrue.isSelected()){
					newStatement = newStatement.replace("{A}","{T}");
				}else if(rdbtnFalse.isSelected()){
					newStatement = newStatement.replace("{A}","{F}");
				}
				System.out.println(newStatement);
			}
		});
		panel.add(btnNewButton_1, "cell 1 4,alignx center,aligny top");
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "Correct Answer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_7, "cell 2 4");
		panel_7.setLayout(new MigLayout("", "[][][][][][]", "[][][]"));
		
		rdbtnTrue = new JRadioButton("True");
		buttonGroup_1.add(rdbtnTrue);
		panel_7.add(rdbtnTrue, "cell 2 2,growx");
		
		rdbtnFalse = new JRadioButton("False");
		buttonGroup_1.add(rdbtnFalse);
		panel_7.add(rdbtnFalse, "cell 4 2,growx");
		
		JButton btnNewButton = new JButton("Clear Text");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		panel.add(btnNewButton, "cell 5 4,aligny top");
		
		JButton btnNewButton_2 = new JButton("Add Another");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textArea.setText("");
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
		
		/*************************************************************
		 * Matching tab action
		 * 
		 *************************************************************/
		
		btnNewButton_3.addActionListener(new ActionListener() {
			
			char letter = 'A';
			public void actionPerformed(ActionEvent e) {
				list.add(new Matching(letter,panel_8));
				letter++;
				window.frame.repaint();
			
			}
		});
		
		JButton btnNewButton_4 = new JButton("Save to File");
		btnNewButton_4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String statment = "Q {\n";
				String Matching_statment = "=Q -> A \n";
				
				statment = statment.replace("Q",textField_1.getText());
				
				if(!list.isEmpty()){
					for(Matching i:list){
						Matching_statment = Matching_statment.replace("=Q", "="+i.getTextField_2().getText());
						Matching_statment = Matching_statment.replace("A",i.getTextField_3().getText());
						statment+=" "+Matching_statment;
						Matching_statment = "=Q -> A \n";
					}
					statment+="}";
				}
				System.out.println(statment);
			}
		});
		panel_2.add(btnNewButton_4, "cell 1 4,sizegroupx 1,sizegroupy 1");
		
		JButton btnNewButton_14 = new JButton("Clear All");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_8.removeAll();
				list.removeAll(list);
				window.frame.repaint();
			}
		});
		panel_2.add(btnNewButton_14, "cell 4 4 2 1");
		
		JButton btnNewButton_5 = new JButton("Add Another");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				panel_8.removeAll();
				list.removeAll(list);
				window.frame.repaint();
			}
		});
		panel_2.add(btnNewButton_5, "cell 1 6,sizegroupx 1,sizegroupy 1");
		
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
	
		textArea_1 = new JTextArea(5,1);
		scrollPane_2.setViewportView(textArea_1);
		
		JButton btnNewButton_7 = new JButton("Clear Text");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea_1.setText("");
			}
		});
		panel_1.add(btnNewButton_7, "cell 4 4,sizegroupx 3,sizegroupy 3");
		
		JButton btnNewButton_6 = new JButton("Add Answer");
		
		panel_1.add(btnNewButton_6, "cell 0 5 2 1,aligny top");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "cell 2 5 3 1,height 130px::130px,grow");
		
		final JPanel panel_9 = new JPanel();
		scrollPane_1.setViewportView(panel_9);
		panel_9.setLayout(new MigLayout("", "[][grow][]", "[]"));
		
		
		btnNewButton_6.addActionListener(new ActionListener() {
			
			char letter = 'A';
			
			public void actionPerformed(ActionEvent e) {
				
				list1.add(new Multichoice(letter,panel_9));
				letter++;
				window.frame.repaint();
			}
		});
		
		JButton btnNewButton_8 = new JButton("Save to File");
		btnNewButton_8.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String statement = "::T:: Q { ";
				String partial_multi_statement = "~%P%A";
				String correct_mulit_statement = "=A";
				
				statement = statement.replace("::T::", "::"+textField_4.getText()+"::");
			    statement = statement.replace("Q", textArea_1.getText());
				if(!list1.isEmpty()){
					for(Multichoice i: list1){
						if(i.getSpinnerValue() < 100){
							partial_multi_statement = partial_multi_statement.replace("P", Integer.toString(i.getSpinnerValue()));
							partial_multi_statement = partial_multi_statement.replace("A", i.textField_5.getText());
							statement+=partial_multi_statement;
							partial_multi_statement = "~%P%A";
						}else if (i.getSpinnerValue() == 100){
							correct_mulit_statement = correct_mulit_statement.replace("A",i.textField_5.getText());
							statement+=correct_mulit_statement;
							correct_mulit_statement = "=A";
						}
						statement+=" ";
					}
					statement+="}";
				}
				System.out.println(statement);
			}
		});
		panel_1.add(btnNewButton_8, "cell 0 6 2 1");
		
		JButton btnNewButton_17 = new JButton("Clear All");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_9.removeAll();
				list1.removeAll(list1);
				window.frame.repaint();
			}
		});
		panel_1.add(btnNewButton_17, "cell 4 6,sizegroupx 3,sizegroupy 3");
		
		JButton btnNewButton_9 = new JButton("Add Another");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_9.removeAll();
				list1.removeAll(list1);
				window.frame.repaint();
				textArea_1.setText("");
				textField_4.setText("");
			}
		});
		panel_1.add(btnNewButton_9, "cell 0 8 2 1,alignx left");
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Short Answer", null, panel_3, null);
		panel_3.setLayout(new MigLayout("", "[][][grow][][]", "[][][][87.00,grow][45.00][132.00,grow][][6.00][]"));
		
		JLabel lblNewLabel_8 = new JLabel("Question Title(Optional)");
		panel_3.add(lblNewLabel_8, "cell 0 1 2 1,alignx trailing");
		
		textField_6 = new JTextField();
		panel_3.add(textField_6, "cell 2 1 3 1,growx");
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Question");
		panel_3.add(lblNewLabel_9, "cell 1 3,alignx right,aligny top");
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_3.add(scrollPane_3, "cell 2 3 3 1,grow");
		
		final JTextPane textPane = new JTextPane();
		scrollPane_3.setViewportView(textPane);
		
		JButton btnNewButton_16 = new JButton("Clear Text");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
			}
		});
		panel_3.add(btnNewButton_16, "cell 3 4 2 1,sizegroupx 2,sizegroupy 2");
		
		JButton btnAddAnswer = new JButton("Add Answer");
		
		panel_3.add(btnAddAnswer, "cell 0 5 2 1,aligny top");
		
		JScrollPane scrollPane_4 = new JScrollPane();
		panel_3.add(scrollPane_4, "cell 2 5 3 1,height 130px::130px,grow");
		
		final JPanel panel_10 = new JPanel();
		scrollPane_4.setViewportView(panel_10);
		panel_10.setLayout(new MigLayout("", "[][grow]", "[]"));
		
		
		btnAddAnswer.addActionListener(new ActionListener() {
			char num = '1';
			public void actionPerformed(ActionEvent e) {
				list2.add(new shortAnswer(num++, panel_10));
				window.frame.repaint();
			}
		});
		
		JButton btnSaveToFile = new JButton("Save to File");
		panel_3.add(btnSaveToFile, "cell 0 6 2 1");
		
		JButton btnNewButton_10 = new JButton("Add Another");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list2.removeAll(list2);
				panel_10.removeAll();
				textPane.setText("");
				textField_6.setText("");
				window.frame.repaint();
			}
		});
		
		JButton btnNewButton_15 = new JButton("Clear All");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list2.removeAll(list2);
				panel_10.removeAll();
				window.frame.repaint();
			}
		});
		panel_3.add(btnNewButton_15, "cell 3 6 2 1,sizegroupx 2,sizegroupy 2");
		panel_3.add(btnNewButton_10, "cell 0 8 2 1,alignx left");
		
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
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent e) {
				panel_11.removeAll();			
				textField_13 = new JTextField();
				panel_11.add(textField_13," growx,spanx");
				textField_13.setColumns(10);
				panel_11.add(new JLabel("min"));
				textField_14 = new JTextField();
				panel_11.add(textField_14,"growx,wrap, wmax 40px");
				textField_14.setColumns(5);
				panel_11.add(new JLabel("max"));
				textField_15 = new JTextField();
				panel_11.add(textField_15,"growx, wmax 40px");
				textField_15.setColumns(10);
				
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

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JTextField getTextField_6() {
		return textField_6;
	}

	public void setTextField_6(JTextField textField_6) {
		this.textField_6 = textField_6;
	}

	public JTextField getTextField_8() {
		return textField_8;
	}

	public void setTextField_8(JTextField textField_8) {
		this.textField_8 = textField_8;
	}

	public JTextField getTextField_9() {
		return textField_9;
	}

	public void setTextField_9(JTextField textField_9) {
		this.textField_9 = textField_9;
	}

	public JTextField getTextField_10() {
		return textField_10;
	}

	public void setTextField_10(JTextField textField_10) {
		this.textField_10 = textField_10;
	}

	public JTextField getTextField_11() {
		return textField_11;
	}

	public void setTextField_11(JTextField textField_11) {
		this.textField_11 = textField_11;
	}

	public JTextField getTextField_12() {
		return textField_12;
	}

	public void setTextField_12(JTextField textField_12) {
		this.textField_12 = textField_12;
	}

	public JTextField getTextField_13() {
		return textField_13;
	}

	public void setTextField_13(JTextField textField_13) {
		this.textField_13 = textField_13;
	}

	public JTextField getTextField_14() {
		return textField_14;
	}

	public void setTextField_14(JTextField textField_14) {
		this.textField_14 = textField_14;
	}

	public JTextField getTextField_15() {
		return textField_15;
	}

	public void setTextField_15(JTextField textField_15) {
		this.textField_15 = textField_15;
	}
	
	//clases
	
	class Matching{
		
		private JTextField textField_2;
		private JTextField textField_3;

		public Matching(char letter ,JPanel panel){
			JLabel lblNewLabel_3 = new JLabel(Character.toString(letter));
			panel.add(lblNewLabel_3, "alignx trailing");
			
			textField_2 = new JTextField();
			panel.add(textField_2, "growx");
			textField_2.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel(Character.toString(letter));
			panel.add(lblNewLabel_4, "skip,alignx trailing");
			
			textField_3 = new JTextField();
			panel.add(textField_3, "growx,wrap");
			textField_3.setColumns(10);
		}

		public JTextField getTextField_2() {
			return textField_2;
		}

		public JTextField getTextField_3() {
			return textField_3;
		}
	}
	
	class Multichoice{
		
		private JTextField textField_5;
		private JSpinner spinner;

		public Multichoice(char letter ,JPanel panel){
			JLabel lblNewLabel_7 = new JLabel(Character.toString(letter));
			panel.add(lblNewLabel_7, "alignx trailing");

			textField_5 = new JTextField();
			panel.add(textField_5, "growx");
			textField_5.setColumns(10);
			
			SpinnerModel sm = new SpinnerNumberModel(0, 0, 100, 1);
			spinner = new JSpinner(sm);

			panel.add(spinner, "wrap");
		}
		
		public int getSpinnerValue(){
			 return Integer.parseInt(spinner.getValue().toString());
		}
	}
	
	class shortAnswer{
	
		private JTextField textField_7;

		public shortAnswer(char letter ,JPanel panel){
			JLabel lblNewLabel_10 = new JLabel(Character.toString(letter));
			panel.add(lblNewLabel_10, "alignx trailing");
			
			textField_7 = new JTextField();
			panel.add(textField_7, "growx,wrap");
			textField_7.setColumns(10);
		}
	}
}
