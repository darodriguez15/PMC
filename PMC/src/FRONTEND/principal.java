package FRONTEND;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;






import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextField;

import BACKEND.Central;

import java.awt.Color;


public class principal {

	private JFrame frame;
	private Central central;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal window = new principal();
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
	public principal() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 501, 225);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnQuePiensaLa = new JButton("Que piensa la gente");
		btnQuePiensaLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				new DialogoTweets(principal.this).setVisible(true);
			}
		});
		btnQuePiensaLa.setBounds(152, 115, 169, 23);
		frame.getContentPane().add(btnQuePiensaLa);
		
		JLabel lblBienvenidoALa = new JLabel("Bienvenido a recomiendanos");
		lblBienvenidoALa.setFont(new Font("Andy", Font.PLAIN, 33));
		lblBienvenidoALa.setBounds(75, 39, 371, 40);
		frame.getContentPane().add(lblBienvenidoALa);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("data\\images.jpg"));
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setBackground(Color.WHITE);
		label.setBounds(225, 0, 260, 207);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("data\\sa.png"));
		lblNewLabel.setBounds(0, 0, 225, 196);
		frame.getContentPane().add(lblNewLabel);
	}
}
