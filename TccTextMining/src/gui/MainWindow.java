package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import utils.Constants;
import main.MainClass;

import com.google.gwt.user.client.rpc.IsSerializable;

import forms.MainWindowForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField textFieldPesquisa;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 494, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel.setBounds(10, 11, 458, 63);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPesquisa = new JLabel("Pesquisa");
		lblPesquisa.setBounds(10, 11, 57, 14);
		panel.add(lblPesquisa);
		
		textFieldPesquisa = new JTextField();
		textFieldPesquisa.setBounds(65, 8, 383, 20);
		panel.add(textFieldPesquisa);
		textFieldPesquisa.setColumns(10);
		
		JLabel lblSepareAsPalavras = new JLabel("Separe as palavras por v\u00EDrgula sem espa\u00E7o");
		lblSepareAsPalavras.setHorizontalAlignment(SwingConstants.CENTER);
		lblSepareAsPalavras.setBounds(10, 36, 438, 14);
		panel.add(lblSepareAsPalavras);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_1.setBounds(10, 77, 458, 81);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblArmazenarEm = new JLabel("Armazenar em:");
		lblArmazenarEm.setBounds(10, 11, 87, 14);
		panel_1.add(lblArmazenarEm);

		
		final JRadioButton rdbtnarff = new JRadioButton(".arff");
		rdbtnarff.setEnabled(false);
		rdbtnarff.setBounds(103, 7, 54, 23);
		panel_1.add(rdbtnarff);
		
		final JRadioButton rdbtntxt = new JRadioButton(".txt");
		rdbtntxt.setEnabled(false);
		rdbtntxt.setBounds(162, 7, 54, 23);
		panel_1.add(rdbtntxt);

		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnarff);
		radioGroup.add(rdbtntxt);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_2.setBounds(222, 11, 226, 59);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		final JCheckBox chckbxUmTxtPor = new JCheckBox("Um txt por registro");
		chckbxUmTxtPor.setEnabled(false);
		chckbxUmTxtPor.setBounds(6, 7, 180, 23);
		panel_2.add(chckbxUmTxtPor);
		
		final JCheckBox chckbxTodosOsRegistros = new JCheckBox("Todos os registros em um txt");
		chckbxTodosOsRegistros.setEnabled(false);
		chckbxTodosOsRegistros.setBounds(6, 29, 200, 23);
		panel_2.add(chckbxTodosOsRegistros);
		

		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_3.setBounds(10, 169, 458, 41);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblPasta = new JLabel("Pasta");
		lblPasta.setBounds(10, 11, 33, 14);
		panel_3.add(lblPasta);
		
		textField = new JTextField();

		textField.setEnabled(false);
		textField.setBounds(53, 8, 300, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		final JButton btnProcurar = new JButton("Procurar");
		btnProcurar.setEnabled(false);
		btnProcurar.setBounds(363, 7, 85, 23);
		panel_3.add(btnProcurar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(368, 221, 100, 28);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		final JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setEnabled(false);
		btnIniciar.setBounds(10, 0, 80, 23);
		panel_4.add(btnIniciar);
		
		textFieldPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(!textFieldPesquisa.getText().isEmpty()){
					rdbtnarff.setEnabled(true);
					rdbtntxt.setEnabled(true);
				}else{
					rdbtnarff.setEnabled(false);
					rdbtntxt.setEnabled(false);
				}
					
			}
		});
		
		rdbtntxt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtntxt.isSelected()){
					chckbxUmTxtPor.setEnabled(true);
					chckbxTodosOsRegistros.setEnabled(true);
					
					textField.setEnabled(true);
					btnProcurar.setEnabled(true);
				}	
			}
		});
		
		rdbtnarff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnarff.isSelected()){
					chckbxUmTxtPor.setEnabled(false);
					chckbxTodosOsRegistros.setEnabled(false);
					chckbxTodosOsRegistros.setSelected(false);
					chckbxUmTxtPor.setSelected(false);
					textField.setEnabled(false);
					btnProcurar.setEnabled(false);
				}	
			}
		});
		
		btnProcurar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnProcurar.isEnabled()){
					textField.setText(FileChooserDirectory.initialize());
					if(!textField.getText().isEmpty()){
						btnIniciar.setEnabled(true);
					}else{
						btnIniciar.setEnabled(false);
					}
				}	
			}
		});

		
		btnIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnIniciar.isEnabled()){
					MainWindowForm mwf = new MainWindowForm();
					mwf.setKeyWords(textFieldPesquisa.getText());
					
					if(rdbtnarff.isSelected()){
						mwf.setSaveTxt(Constants.ARFFTYPE);
					}else{
						mwf.setSaveTxt(Constants.TXTTYPE);
						if(chckbxUmTxtPor.isSelected())
							mwf.setOneFilePerRecord(true);
						if(chckbxTodosOsRegistros.isSelected())
							mwf.setAllRecordsInOneFile(true);
						mwf.setPath(textField.getText());
					}
					
					
					if(validateForm(mwf)){
						MainClass.initializeWork(mwf);
						frame.dispose();
					}
				}
				
			}
		});
		
		
	}
	
	public boolean validateForm(MainWindowForm mwf){
		if(mwf.getSaveType().equals(Constants.TXTTYPE)){
			if(!mwf.isOneFilePerRecord() && !mwf.isAllRecordsInOneFile()){
				JOptionPane.showMessageDialog(null, "Selecione pelo menos um tipo de armazenamento em txt", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
}
