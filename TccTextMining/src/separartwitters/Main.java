package separartwitters;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import utils.Constants;

public class Main {

	private JFrame frame;
	public static ArrayList<String>tweets = null;
	public int count = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 497, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 461, 85);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		final JTextArea textField = new JTextArea();
		textField.setWrapStyleWord(true);
		textField.setLineWrap(true);
		textField.setBounds(10, 11, 441, 63);
		panel.add(textField);
		
		JButton btnPos = new JButton("POS");
		btnPos.setMnemonic('1');
		btnPos.setBounds(10, 107, 89, 23);
		frame.getContentPane().add(btnPos);
		
		JButton btnNeg = new JButton("NEG");
		btnNeg.setMnemonic('2');
		btnNeg.setBounds(109, 107, 89, 23);
		frame.getContentPane().add(btnNeg);
		
		JButton btnNeu = new JButton("NEU");
		btnNeu.setMnemonic('3');
		btnNeu.setBounds(208, 107, 89, 23);
		frame.getContentPane().add(btnNeu);
		
		JButton btnDes = new JButton("DESCARTAR");
		btnDes.setMnemonic('4');
		btnDes.setBounds(353, 107, 118, 23);
		frame.getContentPane().add(btnDes);
		
		JButton btnCarregar = new JButton("Carregar TXT");
		btnCarregar.setBounds(10, 141, 131, 23);
		frame.getContentPane().add(btnCarregar);
		
		btnCarregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				File file = FileChooserDirectory.initialize(); 
				tweets = Helper.getListFromTxt(file);
				textField.setText(tweets.get(count));
			}
		});
		
		btnPos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Helper.saveTweet(textField.getText(), Constants.POSITIVE);
				count++;
				try {
					textField.setText(tweets.get(count));
				} catch (IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "Acabou");
				}
				
			}
		});
		
		btnNeg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Helper.saveTweet(textField.getText(), Constants.NEGATIVE);
				count++;
				try {
					textField.setText(tweets.get(count));
				} catch (IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "Acabou");
				}
				
			}
		});
		
		btnNeu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Helper.saveTweet(textField.getText(), Constants.NEUTRAL);
				count++;
				try {
					textField.setText(tweets.get(count));
				} catch (IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "Acabou");
				}
				
			}
		});
		
		btnDes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				count++;
				try {
					textField.setText(tweets.get(count));
				} catch (IndexOutOfBoundsException e) {
					JOptionPane.showMessageDialog(null, "Acabou");
				}
				
			}
		});
	}
}
