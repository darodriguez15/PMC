package FRONTEND;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
















import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JScrollBar;

import BACKEND.Central;
import BACKEND.Tweet;



public class DialogoResultadoTweet extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DialogoTweets prin; 
	private DefaultListModel<String> modelo;  
	private JList<String> list ; 
	private Central central;
	private String palabra;

	

	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public DialogoResultadoTweet(DialogoTweets inter) 
	{
		central = new Central("G:/WebContent/WEB-INF/ConnectionData");
	
		prin = inter; 
		setBounds(100, 100, 951, 568);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
       modelo = new DefaultListModel<String>();
       
		JButton btnVerEnMapa = new JButton("Ver en Mapa");
		btnVerEnMapa.setBounds(798, 496, 115, 23);
		btnVerEnMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			
			{
				try {
					new DialogoMapaTweet(DialogoResultadoTweet.this,palabra).setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		
		contentPanel.setLayout(null);
		contentPanel.add(btnVerEnMapa);
		
	    list = new JList<String>();
		list.setBounds(10, 11, 903, 474);
		contentPanel.add(list);
	}
	public void setPalabra(String palabra)
	{
		this.palabra=palabra;
	}
	
	public void arreglarCosita(String palabra)
	{
		ArrayList ans;
		try {
			
			ans = central.darTweetsPalabra(palabra);
			int cont= 0 ;
			for (int i = 0; i < ans.size(); i++)
			{
				Tweet n = (Tweet) ans.get(i);
				if ( n.getSeguidores().length()>=2)
				{
				 modelo.addElement(n.getTexto() );
				 list.setModel(modelo);
				 cont++;
				 
				}
				 
				
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
