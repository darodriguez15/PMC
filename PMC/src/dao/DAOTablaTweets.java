/**-------------------------------------------------------------------
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 *
 * Materia: Sistemas Transaccionales
 * Ejercicio: VideoAndes
 * Autor: Juan Felipe García - jf.garcia268@uniandes.edu.co
 * -------------------------------------------------------------------
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BACKEND.Tweet;



public class DAOTablaTweets {


	private ArrayList<Object> recursos;
	private Connection conn;

	
	
	public DAOTablaTweets() {
		recursos = new ArrayList<Object>();
	}


	public void cerrarRecursos() {
		for(Object ob : recursos){
			if(ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	
	public void setConn(Connection con){
		this.conn = con;
	}


	public ArrayList<Tweet> darTweets() throws SQLException, Exception {
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();

		String sql = "SELECT * FROM TWEETS";

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String id = rs.getString("ID");
			String nombre = rs.getString("ID_USER");
			String usuario = rs.getString("USERNAME");
			String amigos = rs.getString("FRIENDS");
			String seguidores = rs.getString("FOLLOWERS");
			String texto = rs.getString("TEXT");
			String lat = rs.getString("LAT");
			String lon = rs.getString("LON");
			String fecha = rs.getString("CREATED_AT");
			
			tweets.add(new Tweet(id, nombre,usuario,amigos, seguidores, texto,lat,lon,fecha));
		}
		return tweets;
	}



	public ArrayList<Tweet> buscarTweetsPorPalabra(String x) throws SQLException, Exception {
		ArrayList<Tweet> Tweets = new ArrayList<Tweet>();

		String sql = "SELECT * FROM Tweets WHERE TEXT like'%" + x + "%'";

		System.out.println("SQL stmt:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			String id = rs.getString("ID");
			String nombre = rs.getString("ID_USER");
			String usuario = rs.getString("USERNAME");
			String amigos = rs.getString("FRIENDS");
			String seguidores = rs.getString("FOLLOWERS");
			String texto = rs.getString("TEXT");
			String lat = rs.getString("LAT");
			String lon = rs.getString("LON");
			String fecha = rs.getString("CREATED_AT");
			
			Tweets.add(new Tweet(id, nombre,usuario,amigos, seguidores, texto,lat,lon,fecha));
		}
		return Tweets;
	}


//	public void addPuerto(Puerto puerto) throws SQLException, Exception {
//
//		String sql = "INSERT INTO PUERTOS VALUES ('";
//		sql += puerto.getId() + "'" + ",'";
//		sql += puerto.getNombre() + "','";
//		sql += puerto.getPais() + "','";
//		sql += puerto.getCiudad() + "')";
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
//
//	}
//	
//
//	
	
//	public void updatePuerto(Puerto puerto) throws SQLException, Exception {
//
//		String sql = "UPDATE PUERTOS SET ";
//		sql += "nombre='" + puerto.getNombre() + "',";
//		sql += "pais='" + puerto.getPais() + "',";
//		sql += "ciudad=" + puerto.getCiudad();
//		sql += " WHERE id_PUERTO = " + puerto.getId();
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
//	}


	
	
//	public void deletePuerto(Puerto puerto) throws SQLException, Exception {
//
//		String sql = "DELETE FROM PUERTOS";
//		sql += " WHERE id_puerto = " + puerto.getId();
//
//		System.out.println("SQL stmt:" + sql);
//
//		PreparedStatement prepStmt = conn.prepareStatement(sql);
//		recursos.add(prepStmt);
//		prepStmt.executeQuery();
//	}




}
