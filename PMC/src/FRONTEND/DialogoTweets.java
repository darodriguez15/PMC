package FRONTEND;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DialogoTweets extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private principal principal; 
	private JTextField textField;
	

	

	/**
	 * Create the dialog.
	 */
	public DialogoTweets(principal inter) 
	{
		principal = inter; 
		setBounds(100, 100, 252, 131);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblIngresaLaPalabra = new JLabel("Ingresa la palabra clave de busqueda");
		lblIngresaLaPalabra.setBounds(10, 28, 263, 14);
		contentPanel.add(lblIngresaLaPalabra);
		
		JLabel lblNewLabel = new JLabel("Ingresa la palabra clave de busqueda");
		lblNewLabel.setBounds(10, 11, 267, 18);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(118, 29, 108, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Busqueda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				DialogoResultadoTweet x =	new DialogoResultadoTweet(DialogoTweets.this);
				
				x.setVisible(true);
				String palabra = textField.getText();
				x.arreglarCosita(palabra);
				x.setPalabra(palabra);
				}
		});
		btnNewButton.setBounds(10, 60, 182, 23);
		getContentPane().add(btnNewButton);
	}
}
