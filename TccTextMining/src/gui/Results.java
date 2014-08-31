package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Results {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Results window = new Results();
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
	public Results() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 332, 188);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPositivos = new JLabel("Positivos:");
		lblPositivos.setBounds(20, 21, 72, 14);
		frame.getContentPane().add(lblPositivos);
		
		JLabel lblNegativos = new JLabel("Negativos:");
		lblNegativos.setBounds(20, 51, 72, 14);
		frame.getContentPane().add(lblNegativos);
		
		JLabel lblPosResult = new JLabel("");
		lblPosResult.setBounds(112, 21, 46, 14);
		frame.getContentPane().add(lblPosResult);
		
		JLabel lblNegResults = new JLabel("");
		lblNegResults.setBounds(112, 51, 46, 14);
		frame.getContentPane().add(lblNegResults);
	}
}
