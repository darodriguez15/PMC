
package BACKEND;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;


import dao.DAOTablaTweets;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;



public class Central {

	/**
	 * Atributo estÃ¡tico que contiene el path relativo del archivo que tiene los datos de la conexiÃ³n
	 */
	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";

	/**
	 * Atributo estÃ¡tico que contiene el path absoluto del archivo que tiene los datos de la conexiÃ³n
	 */
	private  String connectionDataPath;

	/**
	 * Atributo que guarda el usuario que se va a usar para conectarse a la base de datos.
	 */
	private String user;

	/**
	 * Atributo que guarda la clave que se va a usar para conectarse a la base de datos.
	 */
	private String password;

	/**
	 * Atributo que guarda el URL que se va a usar para conectarse a la base de datos.
	 */
	private String url;

	/**
	 * Atributo que guarda el driver que se va a usar para conectarse a la base de datos.
	 */
	private String driver;
	
	/**
	 * ConexiÃ³n a la base de datos
	 */
	private Connection conn;


	/**
	 * MÃ©todo constructor de la clase VideoAndesMaster, esta clase modela y contiene cada una de las 
	 * transacciones y la logia de negocios que estas conllevan.
	 * <b>post: </b> Se crea el objeto VideoAndesMaster, se inicializa el path absoluto de el archivo de conexiÃ³n y se
	 * inicializa los atributos que se usan par la conexiÃ³n a la base de datos.
	 * @param contextPathP - path absoluto en el servidor del contexto del deploy actual
	 */
	public Central(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
		
		
		listaTweets = new ArrayList();
		localidades = new ArrayList();
		colegios = new ArrayList();
		bomberos = new ArrayList();
	}

	/*
	 * MÃ©todo que  inicializa los atributos que se usan para la conexion a la base de datos.
	 * <b>post: </b> Se han inicializado los atributos que se usan par la conexiÃ³n a la base de datos.
	 */
	private void initConnectionData() {
		try {
			File arch = new File(this.connectionDataPath);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream(arch);
			prop.load(in);
			in.close();
			this.url = prop.getProperty("url");
			this.user = prop.getProperty("usuario");
			this.password = prop.getProperty("clave");
			this.driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * MÃ©todo que  retorna la conexiÃ³n a la base de datos
	 * @return Connection - la conexiÃ³n a la base de datos
	 * @throws SQLException - Cualquier error que se genere durante la conexiÃ³n a la base de datos
	 */
	private Connection darConexion() throws SQLException {
		System.out.println("Connecting to: " + url + " With user: " + user);
		return DriverManager.getConnection(url, user, password);
	}

	
	
	
	
	
	private  ArrayList listaTweets;
	private ArrayList localidades;
	private ArrayList colegios;
	private ArrayList bomberos;



	



	public ArrayList darTweets() throws Exception {
		ArrayList<Tweet> Tweets;
		DAOTablaTweets daoTweets = new DAOTablaTweets();
		try 
		{
			//////TransacciÃ³n
			this.conn = darConexion();
			daoTweets.setConn(conn);
			Tweets = daoTweets.darTweets();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoTweets.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return Tweets;
	}
	
	public ArrayList darTweetsPalabra(String x) throws Exception {
		ArrayList<Tweet> Tweets;
		DAOTablaTweets daoTweets = new DAOTablaTweets();
		try 
		{
			//////TransacciÃ³n
			this.conn = darConexion();
			daoTweets.setConn(conn);
			Tweets = daoTweets.buscarTweetsPorPalabra(x);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoTweets.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return Tweets;
	}


	
	
	
	
	
	
	
	
	
//
//	public void setListaTweets(ArrayList listaTweets) {
//		this.listaTweets = listaTweets;
//	}
//
//	public ArrayList getLocalidades() {
//		return localidades;
//	}
//
//
//
//	public void setLocalidades(ArrayList localidades) {
//		this.localidades = localidades;
//	}
//
//
//
//	public ArrayList getColegios() {
//		return colegios;
//	}
//
//
//
//	public void setColegios(ArrayList colegios) {
//		this.colegios = colegios;
//	}
//
//
//
//

//
//	public void cargarTweets() throws Exception
//	{
//	
//
//			File arch = new File ("data/olakase.csv");
//			FileReader fr = new FileReader (arch);
//			BufferedReader lector = new BufferedReader(fr);
//
//			//0 t_id,   1 t_userId,   2 t_screenName,    3 t_friends,    4t_followers,   5t_text,    6 t_lat,   7 t_lon,   8t_createdAt 694301
//			lector.readLine();
//			for(int j =0; j < 474846 ; j++)
//			{
//				String text = lector.readLine();
//						
//				String infoTweet [] = text.split(",");
//				String id = infoTweet[0].replaceAll("\"", "");
//				String userid = infoTweet[1].replaceAll("\"", "");
//				String username = infoTweet[2].replaceAll("\"", "");
//				String amigos = infoTweet[3].replaceAll("\"", "");
//				String seguidores = infoTweet[4].replaceAll("\"", "");
//				String texto = infoTweet[5].replaceAll("\"", "");
//				String fecha = infoTweet[8].replaceAll("\"", "");
//				String latitud = infoTweet[6].replaceAll("\"", "");
//				String longitud = infoTweet[7].replaceAll("\"", "");
//				
//
//				
//				if (latitud.startsWith(" ")||latitud.contains("a")||latitud.contains("e")||latitud.contains("i")||latitud.contains("o")||latitud.contains("u"))
//				{
//					String salva = infoTweet[9].replaceAll("\"", "");
//					texto += latitud;
//					latitud = longitud;
//					longitud= fecha;
//					fecha= salva;
//				}
//				if (latitud.contains("a")||latitud.contains("e")||latitud.contains("i")||latitud.contains("o")||latitud.contains("u"))
//				{
//					
//					String salva1 = infoTweet[10].replaceAll("\"", "");
//					texto += latitud;
//					latitud = longitud;
//					longitud= fecha;
//					fecha= salva1;
//				}
//				if (latitud.contains("a")||latitud.contains("e")||latitud.contains("i")||latitud.contains("o")||latitud.contains("u"))
//				{
//					
//					String salva2 = infoTweet[11].replaceAll("\"", "");
//					texto += latitud;
//					latitud = longitud;
//					longitud= fecha;
//					fecha= salva2;
//				}
//			
//				
//				Tweet	 x = new Tweet(id, userid, username,amigos,seguidores, texto, latitud, longitud, fecha);
//
//				listaTweets.add(x);
//				
//
//				
//			
//
//
//
//		}
//		for (int o = 0; o< listaTweets.size(); o++)
//		{
//			Tweet temp = (Tweet) listaTweets.get(o);
//			if(temp.getLat().contains("a")||temp.getLat().contains("e")||temp.getLat().contains("i")||temp.getLat().contains("o")||temp.getLat().contains("u"))
//			{
//				listaTweets.remove(o);
//			}
//			if(temp.getLon().contains("a")||temp.getLon().contains("e")||temp.getLon().contains("i")||temp.getLon().contains("o")||temp.getLon().contains("u"))
//			{
//				listaTweets.remove(o);
//			}
//		}
//		
//		System.out.println("TODO OK");
//
//	}
//
//	public void crearDoc ()
//	{
//
//		WorkbookSettings ws = new WorkbookSettings();
//		ws.setEncoding("Cp1252");
//		try {
//
//			Workbook wb=Workbook.getWorkbook(new File("G:/"+0+".xls"),ws);
//			
//			WritableWorkbook copy=Workbook.createWorkbook(new File("G:/"+0+".xls"),wb);
//			
//			WritableSheet sheet = copy.getSheet(0);
//			
//			
//			
//		sheet.addCell(new Label(0, 1, "T_ID"));
//		sheet.addCell(new Label(1, 1, "T_USERID"));
//		sheet.addCell(new Label(2, 1, "T_SCREENNAME"));
//		sheet.addCell(new Label(3, 1, "T_FRIENDS"));
//		sheet.addCell(new Label(4, 1, "T_FOLLOWERS"));
//		sheet.addCell(new Label(5, 1, "T_TEXT"));
//		sheet.addCell(new Label(5, 1, "T_LAT"));
//		sheet.addCell(new Label(7, 1, "T_LON"));
//		sheet.addCell(new Label(8, 1, "T_CREATEDAT"));
//		
//			for (int i = 1,j=0; i < listaTweets.size(); i++) {
//				
//				
//				
//				if(i ==60000 )
//				{
//					j++;
//				 copy=Workbook.createWorkbook(new File("G:/"+j+".xls"),wb);
//				 sheet = copy.getSheet(0);
//				 i=1;
//				}
//					
//	
//			
//			
////			System.out.println("Tamaño: "+listaTweets.size()+ "en la posicion :"+i+ " esta en el documento :"+j);
//			
//			
//
//				Tweet actual = (Tweet) listaTweets.get(i-1);
//				
//				sheet.addCell(new Label(0, i, actual.getId()));
//				sheet.addCell(new Label(1, i, actual.getUsuarioID()));
//				sheet.addCell(new Label(2, i, actual.getUsername()));
//				sheet.addCell(new Label(3, i, actual.getAmigos()));
//				sheet.addCell(new Label(4, i, actual.getSeguidores()));
//				sheet.addCell(new Label(5, i, actual.getTexto()));
//				sheet.addCell(new Label(6, i, actual.getLat()));
//				sheet.addCell(new Label(7, i, actual.getLon()));
//				sheet.addCell(new Label(8, i, actual.getFecha()));
//		
//				
//				copy.write();
//				
//			}
//			
//			copy.close();
//			
//
//		
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (RowsExceededException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (WriteException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (BiffException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
//	
//	
//	
//	
//	public void escribir(String nombreArchivo)
//
//	{
//		File f;
//
//		f = new File(nombreArchivo);
//
//		try{
//
//			FileWriter w = new FileWriter(f);
//
//			BufferedWriter bw = new BufferedWriter(w);
//
//			PrintWriter wr = new PrintWriter(bw);  
//
//		for (int i = 0; i < listaTweets.size(); i++) {
//
//
//			Tweet actual = (Tweet) listaTweets.get(i);
//
//
//			String coso= actual.getId()+","+ actual.getUsuarioID()+","+actual.getUsername()+","+actual.getAmigos()+","+actual.getSeguidores()+","+actual.getTexto()+","+ actual.getLat()+","+actual.getLon()+","+actual.getFecha();
//			
//			wr.write(coso+"\n");
//		
//			
//			
//
//			
//
//		
//	}
//		wr.close();
//		bw.close();
//		}catch(IOException e){};
//
//
//}
//
//	public void cargarLocalidades() throws BiffException, IOException
//	{
//		Workbook workbook = Workbook.getWorkbook(new File("data/Localidades.xls"));
//		Sheet sheet = workbook.getSheet(0);
//		for (int i = 1; i <21; i++) {
//
//			Cell numero = sheet.getCell(0,i); 
//			Cell nombre = sheet.getCell(1,i); 
//
//			String name = nombre.getContents(); 
//			String number = numero.getContents(); 
//
//			Localidad nueva = new Localidad(name, number);
//
//			System.out.println(nueva.getNombre() + "//////////" + nueva.getNumero() + "///////////////" );
//			localidades.add(nueva);
//
//		}
//
//	}
//
//
//
//
//	public void cargarColegios() throws BiffException, IOException
//	{
//		Workbook workbook = Workbook.getWorkbook(new File("data/colegios.xls"));
//		Sheet sheet = workbook.getSheet(0);
//		for (int i = 1; i <8066; i++) {
//
//			Cell lo = sheet.getCell(0,i); 
//			Cell nombre = sheet.getCell(3,i); 
//
//			String name = nombre.getContents(); 
//			String number = lo.getContents(); 
//
//			Colegio nuevo = new Colegio(number, name); 
//
//			System.out.println(nuevo.getNombre() + "//////////" + nuevo.getLocalidad() + "///////////////" );
//			colegios.add(nuevo);
//
//		}
//
//	}
//
//	 
//	 public void cargarBomberos() throws BiffException, IOException
//	 {
//		 Workbook workbook = Workbook.getWorkbook(new File("data/Bomberos.xls"));
//		 Sheet sheet = workbook.getSheet(0);
//		 for (int i = 1; i <17; i++) {
//
//			 Cell dep = sheet.getCell(0,i); 
//			 Cell loca  = sheet.getCell(1,i); 
//			 Cell upz = sheet.getCell(2,i);
//			 Cell dire = sheet.getCell(3,i);
//			 Cell tel = sheet.getCell(4,i);
//			 Cell coma = sheet.getCell(6,i);
//			 Cell la = sheet.getCell(12,i);
//			 Cell lo = sheet.getCell(11,i);
//			 
//
//			 String dependencia = dep.getContents(); 
//			 String localidad = loca.getContents(); 
//			 String upzz = upz.getContents(); 
//			 String direccion = dire.getContents(); 
//			 String telefono = tel.getContents(); 
//			 String comandante = coma.getContents(); 
//			 String latitud = la.getContents(); 
//			 String longitud = lo.getContents(); 
//
//			 EstacionBomberos x = new EstacionBomberos(dependencia, localidad, upzz, direccion, telefono, comandante, longitud, latitud);
//
//			 System.out.println(x.getLocalidad() + "//////////" + x.getLatitud() + "///////////////" + x.getLongitud() );
//			bomberos.add(x);
//
//		 }
//}
//
//
//
//
//	public ArrayList buscarPorPalabra (String palabra) throws Exception
//	{
//
//
//		ArrayList lista = getListaTweets();
//		ArrayList rta = new ArrayList();
//		System.out.println(lista.size());
//		int max= 0 ;
//		boolean termino= false; 
//		for (int i = 0 ; i < lista.size(); i++)
//		{
//			
//			Tweet n = (Tweet) lista.get(i);
//			if (n.getTexto().contains(palabra))
//			{
//				System.out.println(n.getUsername()+" "+n.getTexto());
//				rta.add(n);
//			}
//			
//        
//		}
//		return rta;
//
//	}
//	
//	public ArrayList estacionesBomberosporLocalidad(String localidad)
//	{
//		ArrayList capos = new ArrayList();
//		
//		for (int i = 0; i < bomberos.size(); i++)
//		{
//			EstacionBomberos temp = (EstacionBomberos) bomberos.get(i);
//			if(temp.getLocalidad().equalsIgnoreCase(localidad))
//			{
//				capos.add(temp);
//			}
//		}
//		return capos;
//	}
//









}
