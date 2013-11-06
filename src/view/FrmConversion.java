package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultListModel;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import model.ListSelectionHandler;

import javax.swing.JButton;

public class FrmConversion extends JFrame {

	private JPanel contentPane;
	public static JTextField txtInput;
	public static JTextField txtOutput;
	
	public static JList lbSelection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConversion frame = new FrmConversion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmConversion() {
		setTitle("JConvert");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input");
		lblNewLabel.setBounds(12, 12, 70, 15);
		contentPane.add(lblNewLabel);
		
		txtInput = new JTextField();
		txtInput.setBounds(70, 10, 362, 19);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		//Create list model so that elements can be added to the JList
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement("Binary -> Hexadecimal");
		listModel.addElement("Binary -> Integer");
		listModel.addElement("Integer -> Binary");
		listModel.addElement("Integer -> Hexadecimal");
		listModel.addElement("Hexadecimal -> Binary");
		listModel.addElement("Hexadecimal -> Integer");

		
		
		lbSelection = new JList(listModel);
		lbSelection.setBounds(122, 105, 199, 135);
		contentPane.add(lbSelection);
		//Add event listener
		ListSelectionModel listSelectionModel = lbSelection.getSelectionModel();
	    listSelectionModel.addListSelectionListener(
				new ListSelectionHandler()
				);
	    lbSelection.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent k) {
				// TODO Auto-generated method stub
				if(k.getKeyCode() == KeyEvent.VK_SPACE)
				txtOutput.setText("");
				txtInput.setText("");
				lbSelection.setSelectedIndex(-1);
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		}); 
		
		JLabel lblNewLabel_1 = new JLabel("Output");
		lblNewLabel_1.setBounds(12, 42, 70, 15);
		contentPane.add(lblNewLabel_1);
		
		txtOutput = new JTextField();
		txtOutput.setColumns(10);
		txtOutput.setBounds(70, 40, 362, 19);
		contentPane.add(txtOutput);
		
		JLabel lblNewLabel_2 = new JLabel("Conversion");
		lblNewLabel_2.setBounds(178, 78, 88, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton btnAbout = new JButton("?");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "A simple java number converter.\nWhile focus is set on the list box\nspace bar can be used to clear the\ncurrent selection.\n\nWritten by Michael Steenkamp.");
			}
		});
		btnAbout.setBounds(387, 233, 41, 25);
		contentPane.add(btnAbout);

	}
}
