//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.Image;
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JTextArea;
//import javax.swing.JLabel;
//
//import mundo.Central;
//import mundo.EstacionBomberos;
//import mundo.Tweet;
//
//
//public class DialogoBombers extends JDialog {
//
//	private final JPanel contentPanel = new JPanel();
//	private principal prin; 
//	public final static String MAPS ="http://maps.googleapis.com/maps/api/staticmap?center=Bogota";
//	public final static String ZOOM ="&zoom=11&size=2000x2000";
//	public final static String SENSOR = "&sensor=false";
//	private double laU =4.6045;
//	private double loU =-74.0694;
//	 private URL dire ;
//	 private final static String MARCADOR ="&markers=color:red%7Clabel:B%7C";
//	 private final static String MARCADOR_CERCANO ="&markers=color:yellow%7C";
//	private final static String POSICION ="&markers=color:red%7C4.6045,-74.0694";
//
//  //&markers=color:blue%7Clabel:S%7C62.107733,-145.541936
//	public DialogoBombers(principal inter, String palabra) throws IOException
//	{
//		setResizable(false);
//		prin = inter; 
//		setBounds(100, 100, 1159, 701);
//		getContentPane().setLayout(new BorderLayout());
//		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		getContentPane().add(contentPanel, BorderLayout.CENTER);
//		contentPanel.setLayout(null);
//
//		Central c = new Central();
//		
//		
//		try {
//			
//			c.cargarBomberos();
//	
//		String la = "";
//		String lo="";
//		
//		String url = MAPS+la+","+lo+ZOOM+SENSOR;
//		ArrayList bomberos = c.estacionesBomberosporLocalidad(palabra);
//		
//		for(int i = 0; i<bomberos.size();i++)
//		 {
//			 EstacionBomberos x= (EstacionBomberos) bomberos.get(i);
//			 la = x.getLatitud();
//			 lo = x.getLongitud();
//			 String a = x.getLatitud();
//			 String b = x.getLongitud();
//			 String ur  =MARCADOR + a+","+b+"|";
//			 url= url+ur; 
//		 System.out.println(a+"nnckkcnskdnc"+b );
//		
//			 
//			 
//			 
//			 
//			 
//		
//		 }
//		
//		//url = url+"&"+MARCADOR_CERCANO +masCercano.getLatitud()+","+masCercano.getLongitud()+ MARCADOR;
//		 
//		
////		for(int i = 0; i<bomberos.size();i++)
////		 {
////			
////				 String a = y.getLatitud();
////				 String b = y.getLongitud();
////				 String ur  =a+","+b+"|";
////				 url= url+ur; 
////			 
////		 
////		 }
////		 
//		 
//			 
//		 
//		 
//		 System.out.println(url);
//		 dire = new URL(url);
//		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//
//		Image image = ImageIO.read(dire);
//		JLabel mapa =new JLabel(new ImageIcon(image));
//		mapa.setBounds(274, 0, 819, 629);
//		contentPanel.add(mapa);
//		
////		JPanel panel = new JPanel();
////		panel.setBounds(0, 0, 248, 567);
////		contentPanel.add(panel);
////		panel.setLayout(null);
////		
////		JLabel lblLeyendas = new JLabel("Leyendas");
////		lblLeyendas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
////		lblLeyendas.setBounds(61, 11, 101, 28);
////		panel.add(lblLeyendas);
////		
////		JLabel lblNewLabel = new JLabel("New label");
////		lblNewLabel.setIcon(new ImageIcon("G:\\PMC\\data\\red.gif"));
////		lblNewLabel.setBounds(10, 63, 33, 32);
////		panel.add(lblNewLabel);
////		
////		JLabel lblNewLabel_1 = new JLabel("New label");
////		lblNewLabel_1.setIcon(new ImageIcon("G:\\PMC\\data\\blue}.png"));
////		lblNewLabel_1.setBounds(10, 127, 33, 33);
////		panel.add(lblNewLabel_1);
////		
////		JLabel lblNewLabel_2 = new JLabel("");
////		lblNewLabel_2.setIcon(new ImageIcon("G:\\PMC\\data\\google_marker_yellow.png"));
////		lblNewLabel_2.setBounds(10, 188, 33, 38);
////		panel.add(lblNewLabel_2);
////		
////		JLabel lblUbicacionActual = new JLabel("Ubicacion Actual");
////		lblUbicacionActual.setBounds(61, 72, 88, 14);
////		panel.add(lblUbicacionActual);
////		
////		JLabel lblTweetsDestacados = new JLabel("Tweets Destacados");
////		lblTweetsDestacados.setBounds(61, 136, 101, 14);
////		panel.add(lblTweetsDestacados);
////		
////		JLabel lblNuestraRecomendacion = new JLabel("Nuestra Recomendacion ");
////		lblNuestraRecomendacion.setBounds(61, 199, 119, 14);
////		panel.add(lblNuestraRecomendacion);
////	}
//}}
