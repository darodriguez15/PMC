package BACKEND;

public class Tweet {
	//t_id,t_userId,t_screenName,t_friends,t_followers,t_text,t_lat,t_lon,t_createdAt
	
	private String id;
	private String usuarioID;
	private String username;
	private String amigos;
	private String seguidores;
	private String texto;
	private String lat;
	private String lon;
	private String fecha;
	
	
	
	
	
	
	public Tweet(String id, String usuarioID, String username, String amigos, String seguidores, String texto, String lat, String lon,String fecha) {

		this.id = id;
		this.usuarioID = usuarioID;
		this.username = username;
		this.amigos = amigos;
		this.seguidores = seguidores;
		this.texto = texto;
		this.lat = lat;
		this.lon = lon;
		this.fecha = fecha;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(String usuarioID) {
		this.usuarioID = usuarioID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		username = username;
	}
	public String getAmigos() {
		return amigos;
	}
	public void setAmigos(String amigos) {
		this.amigos = amigos;
	}
	public String getSeguidores() {
		return seguidores;
	}
	public void setSeguidores(String seguidores) {
		this.seguidores = seguidores;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	

}
