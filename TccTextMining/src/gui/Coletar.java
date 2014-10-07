package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import main.MainClass;
import utils.Constants;
import forms.MainWindowForm;

public class Coletar {

	private JFrame frame;
	private JTextField textFieldPesquisa;
	private JTextField textField;
	private JTextField textQuantidade;

	/**
	 * Launch the application.
	 */
	public static void init(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coletar window = new Coletar();
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
	public Coletar() {
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
		lblArmazenarEm.setBounds(10, 33, 87, 14);
		panel_1.add(lblArmazenarEm);

		
		final JRadioButton rdbtnarff = new JRadioButton(".arff");
		rdbtnarff.setEnabled(false);
		rdbtnarff.setBounds(97, 29, 68, 23);
		panel_1.add(rdbtnarff);
		
		final JRadioButton rdbtntxt = new JRadioButton(".txt");
		rdbtntxt.setEnabled(false);
		rdbtntxt.setBounds(162, 29, 60, 23);
		panel_1.add(rdbtntxt);

		ButtonGroup fileTypeRadioGroup = new ButtonGroup();
		fileTypeRadioGroup.add(rdbtnarff);
		fileTypeRadioGroup.add(rdbtntxt);
		
		//Tentativa de adicionar tipo de busca ao Layout
		JLabel lblFetchType = new JLabel("Tipo de Busca:");
		lblFetchType.setBounds(10, 11, 87, 14);
		panel_1.add(lblFetchType);

		
		final JRadioButton rdbStream = new JRadioButton("Stream");
		rdbStream.setEnabled(false);
		rdbStream.setBounds(97, 7, 68, 23);
		panel_1.add(rdbStream);
		
		final JRadioButton rdbQuery = new JRadioButton("Query");
		rdbQuery.setEnabled(false);
		rdbQuery.setBounds(162, 7, 60, 23);
		panel_1.add(rdbQuery);

		ButtonGroup searchRadioGroup = new ButtonGroup();
		searchRadioGroup.add(rdbStream);
		searchRadioGroup.add(rdbQuery);
		//Fim da tentativa de adicionar tipo de busca ao Layout
		
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
		
		final JLabel labelQuantidade = new JLabel("Quantidade:");
		labelQuantidade.setEnabled(false);
		labelQuantidade.setBounds(10, 56, 87, 14);
		panel_1.add(labelQuantidade);
		
		textQuantidade = new JTextField();
		textQuantidade.setEnabled(false);
		textQuantidade.setBounds(97, 53, 48, 20);
		panel_1.add(textQuantidade);
		textQuantidade.setColumns(10);
		

		
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
					rdbStream.setEnabled(true);
					rdbQuery.setEnabled(true);
				}else{
					rdbStream.setEnabled(false);
					rdbQuery.setEnabled(false);
				}
					
			}
		});
		
		rdbStream.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(rdbStream.isSelected())
				{
					rdbtnarff.setEnabled(true);
					rdbtntxt.setEnabled(true);
					labelQuantidade.setEnabled(false);
					textQuantidade.setEnabled(false);
				}
			}
		});
		
		rdbQuery.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if(rdbQuery.isSelected())
				{
					rdbtnarff.setEnabled(true);
					rdbtntxt.setEnabled(true);
					labelQuantidade.setEnabled(true);
					textQuantidade.setEnabled(true);
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
					
					if(rdbtnarff.isSelected())
					{
						mwf.setSaveType(Constants.ARFFTYPE);
					}
					else
					{
						mwf.setSaveType(Constants.TXTTYPE);
						if(chckbxUmTxtPor.isSelected())
						{
							mwf.setOneFilePerRecord(true);
						}
						if(chckbxTodosOsRegistros.isSelected())
						{
							mwf.setAllRecordsInOneFile(true);
						}
						mwf.setPath(textField.getText());
					}
					
					if(rdbQuery.isSelected())
					{
						mwf.setFetchType(Constants.QUERYTYPE);
						mwf.setQuantity(Integer.parseInt(textQuantidade.getText()));
					}
					else
					{
						mwf.setFetchType(Constants.STREAMTYPE);
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
