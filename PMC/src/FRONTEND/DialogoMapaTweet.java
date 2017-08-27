package FRONTEND;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.imageio.ImageIO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;





import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.DropMode;

import BACKEND.Central;
import BACKEND.Tweet;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;




public class DialogoMapaTweet extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DialogoResultadoTweet prin; 
	public final static String MAPS ="http://maps.googleapis.com/maps/api/staticmap?center=";
	public final static String ZOOM ="BOGOTA&zoom=11&size=2000x2000";
	public final static String SENSOR = "&sensor=false";
	private double laU =4.6045;
	private double loU =-74.0694;
	private URL dire ;
	private final static String MARCADOR ="&markers=color:blue%7C";
	private final static String MARCADOR_FAMOSO ="&markers=color:green%7C";
	private final static String MARCADOR_CERCANO ="&markers=color:yellow%7C";
	private final static String MARCADOR_BASICO ="&markers=color:brown%7C";
	private final static String POSICION ="&markers=color:red%7C";
	private final static String POS_LAT ="4.6045";
	private final static String POS_LON ="-74.0694";
	private JTextField USERNAME;
	private JTextField SEGUIDORES;
	private JTextField TWEET;
	private JTextField LALO;


	public DialogoMapaTweet(DialogoResultadoTweet inter, String palabra) throws IOException 
	{
		setResizable(false);
		prin = inter; 
		setBounds(100, 100, 1068, 692);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		Tweet recomendado = new Tweet("", "", "", "", "", "", "", "", "");

		Central c = new Central("G:/WebContent/WEB-INF/ConnectionData");

		try {


			String nuevaLa="";
			String nuevaLo="";
			//			double POSLa= Integer.parseInt(POS_LAT);
			//			double POSLo= Integer.parseInt(POS_LON);

			String url = MAPS+ZOOM+SENSOR+POSICION+POS_LAT+","+POS_LON;

			ArrayList tweets = c.darTweetsPalabra(palabra);
			ArrayList<Tweet> famosos = new ArrayList<Tweet>();
			ArrayList<Tweet> general = new ArrayList<Tweet>();
			ArrayList<Tweet> basico = new ArrayList<Tweet>();
			int cuantos =0;
			boolean fav = true;
			boolean yakasFamoso= true;
			boolean yakasNormi= true;
			boolean yakasBasico= true;
			boolean yakasCercano= true;
			for(int i = 0; i<tweets.size();i++)
			{


				Tweet x= (Tweet) tweets.get(i);

				if (!x.getUsername().equals("trendinaliaCO"))
				{

				if (x.getSeguidores().length()>=5 )
				{
					famosos.add(x);
				}
				if (x.getSeguidores().length()==4 )
				{
					general.add(x);
				}
				if (x.getSeguidores().length()<4 )
				{
					basico.add(x);
				}
				}
			}

			int comp = 10;
			
			for (int j = 0; j< famosos.size();j++)
			{
				Tweet u = famosos.get(j);
				int seguidos = u.getAmigos().length();



				if (seguidos<comp)
				{
					comp = seguidos;
					recomendado =u;
				}
			}
			
			
			System.out.println("el recomendado es: " + recomendado.getUsername()+"      , texto : "+recomendado.getTexto() );
			
			



				//				int actualLa= Integer.parseInt(x.getLat());
				//				int actualLo= Integer.parseInt(x.getLon());





				//					else if ( x.getSeguidores().length()==6)
				//					{ 
				//						if (cuantos <= 70&& fav==true)
				//						{
				//
				//							cuantos++;
				//							System.out.println(cuantos);
				//							String ur  ="";
				//							if (yakasCercano)
				//							{
				//								ur =MARCADOR_CERCANO;
				//								yakasCercano= false;
				//								fav=false;
				//								
				//							}
				//							 ur  +=nuevaLa+","+nuevaLo+"|";
				//							url= url+ur; 
				//						}
				//					}

			int max= 0;
				for (int j = 0; j< general.size()&& max<10;j++)
				{
					Tweet u = general.get(j);
					String[] la= u.getLat().split("\\.");
					String[]  lo =u.getLon().split("\\.");
					nuevaLa = la[0]+".";
					
					for ( int y = 1; y < la.length;y++)
					{
						nuevaLa += la[y];
					}
					nuevaLo = lo[0]+".";
					for ( int o = 1; o < lo.length;o++)
					{
						nuevaLo += lo[o];
					}

		
						
						if (cuantos <= 65)
						{
							cuantos++;
							String ur="";
							if (yakasBasico)
							{
								ur  =MARCADOR;
								yakasBasico= false;
							}
							ur  +=nuevaLa+","+nuevaLo+"|";
							url= url+ur; 
							max++;
						}
					

				}
				
				for ( int l = 0 ; l<famosos.size();l++)
				{
					Tweet p = famosos.get(l);
//					System.out.println( "latitud famosa:"+ p.getLat()+" longitud: "+p.getLon()+" segidores amigos:"+p.getSeguidores()+","+ p.getAmigos());
					String[] la= p.getLat().split("\\.");
					String[]  lo = p.getLon().split("\\.");
					nuevaLa = la[0]+".";
					for ( int y = 1; y < la.length;y++)
					{
						nuevaLa += la[y];
					}
					nuevaLo = lo[0]+".";
					for ( int o = 1; o < lo.length;o++)
					{
						nuevaLo += lo[o];
					}



					if (cuantos <= 65)
					{
						String ur ="";



						if (p.getId().equals(recomendado.getId()))
						{
							ur =MARCADOR_CERCANO;
							cuantos++;
							ur  +=nuevaLa+","+nuevaLo+"|";
							url= url+ur+MARCADOR_FAMOSO; 
							yakasFamoso= false;
							recomendado.setLat(nuevaLa);
							recomendado.setLon(nuevaLo);

						}
						else
						{
							if (yakasFamoso)
							{
								ur =MARCADOR_FAMOSO;
								yakasFamoso= false;
							}
							cuantos++;
							ur  +=nuevaLa+","+nuevaLo+"|";
							url= url+ur; 
						}
						

					}

				}

				System.out.println(basico.size()+ "   ESTOS SON LOS CAFES");
				System.out.println(general.size()+ "   ESTOS SON LOS AZULES");
				System.out.println(famosos.size()+ "   ESTOS SON LOS VERDES");
				for (int w = 0; w< basico.size();w++)
				{
					Tweet u = basico.get(w);
					String[] la= u.getLat().split("\\.");
					String[]  lo =u.getLon().split("\\.");
					nuevaLa = la[0]+".";
					for ( int y = 1; y < la.length;y++)
					{
						nuevaLa += la[y];
					}
					nuevaLo = lo[0]+".";
					for ( int o = 1; o < lo.length;o++)
					{
						nuevaLo += lo[o];
					}
					
					if (cuantos <= 65)
					{

						cuantos++;
						String ur  ="";
						if (yakasNormi)
						{
							ur  =MARCADOR_BASICO;
							yakasNormi= false;
						}
						ur  +=nuevaLa+","+nuevaLo+"|";
						url= url+ur; 
					}		
				}

			







			System.out.println(url);
			dire = new URL(url);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		Image image = ImageIO.read(dire);
		JLabel mapa =new JLabel(new ImageIcon(image));
		mapa.setBounds(428, 0, 634, 640);
		contentPanel.add(mapa);
		USERNAME = new JTextField();
		USERNAME.setBounds(277, 69, 101, 20);
		USERNAME.setColumns(10);
		SEGUIDORES = new JTextField();
		SEGUIDORES.setColumns(10);
		SEGUIDORES.setBounds(277, 186, 101, 20);
		LALO = new JTextField();
		LALO.setColumns(10);
		LALO.setBounds(277, 123, 101, 20);
		
				JPanel panel = new JPanel();
				panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				panel.setBounds(0, 0, 424, 672);
				contentPanel.add(panel);
				panel.setLayout(null);
				
				JLabel lblTweet = new JLabel("Tweet:");
				lblTweet.setBounds(353, 639, 67, 28);
				panel.add(lblTweet);
				lblTweet.setFont(new Font("Andy", Font.PLAIN, 23));
				
				JTextPane txtpnNuestraRecomendacionEl = new JTextPane();
				txtpnNuestraRecomendacionEl.setFont(new Font("Andy", Font.PLAIN, 14));
				txtpnNuestraRecomendacionEl.setBackground(new Color(51, 153, 255));
				txtpnNuestraRecomendacionEl.setText("Nuestra recomendacion el el marcador amarillo,si no es visible\r\nel marcador amarillo puede ser por dos razones: la primera\r\nque en la misma zona se encuentres muchos mas marcadores,\r\ny la segunda por que no hay tweets que nos permitan generar \r\nuna recomendacion confiable, pero eso no impide realizar la\r\nrecomendacio, asi que seguro debe haber marcadores de \r\ndistintos colores por lo tanto al observar una aglomeracion \r\nde estos mismos quiere decir que este es un punto de \r\nrecomendacion secundaria. Para tener una mejor vision del \r\nlugar por favor copiar el link y googlearlo:\r\nhttps://www.google.com.co/maps/place/"+ recomendado.getLat()+","+recomendado.getLon());
				txtpnNuestraRecomendacionEl.setBounds(34, 446, 358, 182);
				panel.add(txtpnNuestraRecomendacionEl);
				
						JLabel lblLeyendas = new JLabel("Leyendas");
						lblLeyendas.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						lblLeyendas.setBounds(84, 11, 101, 28);
						panel.add(lblLeyendas);
						
								JLabel lblNewLabel = new JLabel("New label");
								lblNewLabel.setIcon(new ImageIcon("data\\red.gif"));
								lblNewLabel.setBounds(10, 63, 33, 32);
								panel.add(lblNewLabel);
								
										JLabel lblNewLabel_1 = new JLabel("");
										lblNewLabel_1.setIcon(new ImageIcon("data\\blue}.png"));
										lblNewLabel_1.setBounds(10, 245, 33, 33);
										panel.add(lblNewLabel_1);
										
												JLabel lblNewLabel_2 = new JLabel("");
												lblNewLabel_2.setIcon(new ImageIcon("data\\google_marker_yellow.png"));
												lblNewLabel_2.setBounds(10, 123, 33, 32);
												panel.add(lblNewLabel_2);
												
														JLabel lblUbicacionActual = new JLabel("Ubicacion Actual");
														lblUbicacionActual.setBounds(84, 72, 211, 14);
														panel.add(lblUbicacionActual);
														
																JLabel lblTweetsDestacados = new JLabel("Tweets Vericidad 2");
																lblTweetsDestacados.setBounds(84, 246, 152, 14);
																panel.add(lblTweetsDestacados);
																
																		JLabel lblNuestraRecomendacion = new JLabel("Nuestra Recomendacion ");
																		lblNuestraRecomendacion.setBounds(84, 139, 152, 14);
																		panel.add(lblNuestraRecomendacion);
																		
																		JLabel label = new JLabel("");
																		label.setIcon(new ImageIcon("data\\marker-google-brown.png"));
																		label.setBounds(10, 305, 33, 33);
																		panel.add(label);
																		
																		JLabel lblTweetsVericidad = new JLabel("Tweets Vericidad 1");
																		lblTweetsVericidad.setBounds(88, 189, 151, 14);
																		panel.add(lblTweetsVericidad);
																		
																		JLabel label_2 = new JLabel("");
																		label_2.setIcon(new ImageIcon("data\\verde.png"));
																		label_2.setBounds(10, 170, 33, 33);
																		panel.add(label_2);
																		
																		JLabel lblTweetsVericidad_1 = new JLabel("Tweets Vericidad 3");
																		lblTweetsVericidad_1.setBounds(87, 313, 152, 14);
																		panel.add(lblTweetsVericidad_1);
																		
																		JLabel lblComoInterpretarLos = new JLabel("Como interpretar los resultados");
																		lblComoInterpretarLos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
																		lblComoInterpretarLos.setBounds(73, 376, 290, 28);
																		panel.add(lblComoInterpretarLos);
																		
	
																		USERNAME.setText(recomendado.getUsername());
																		SEGUIDORES.setText(recomendado.getSeguidores());
																		LALO.setText(recomendado.getLat()+","+recomendado.getLon());
																		panel.add(USERNAME);
																		panel.add(SEGUIDORES);
																		
	
																		panel.add(LALO);
																		
																		JLabel lblUsername = new JLabel("Username");
																		lblUsername.setBounds(298, 47, 122, 14);
																		panel.add(lblUsername);
																		
																		JLabel lblRecomendacion = new JLabel("Recomendacion");
																		lblRecomendacion.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
																		lblRecomendacion.setBounds(251, 11, 152, 28);
																		panel.add(lblRecomendacion);
																		
																		JLabel lblLatitudlongitud = new JLabel("Latitud,Longitud");
																		lblLatitudlongitud.setBounds(287, 98, 122, 14);
																		panel.add(lblLatitudlongitud);
																		
																		JLabel lblSeguidores = new JLabel("Seguidores");
																		lblSeguidores.setBounds(298, 161, 122, 14);
																		panel.add(lblSeguidores);
																		
																		JLabel lblNewLabel_3 = new JLabel("New label");
																		lblNewLabel_3.setIcon(new ImageIcon("data\\fondo-azul-836335-1.png"));
																		lblNewLabel_3.setBounds(0, -11, 1063, 716);
																		panel.add(lblNewLabel_3);
		TWEET = new JTextField();
		TWEET.setBounds(422, 638, 640, 29);
		contentPanel.add(TWEET);
		TWEET.setColumns(10);
		TWEET.setText(recomendado.getTexto());
	}
}
