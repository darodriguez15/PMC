package BACKEND;

public class EstacionBomberos
{
	private String dependencia;

	private String Localidad;

	private String upz ;

	private String direccion; 

	private String telefono;

	private String Comandante;

	private String longitud;

	private String latitud; 


	public EstacionBomberos(String dep, String loca, String upz, String dire, 
			String tel, String coma, String lon, String la )
	{
		
		String  longitud = lon.replaceAll(";","\\.");
		String  latitud = la.replaceAll(";","\\.");
		this.dependencia = dep; 
		this.Localidad = loca;
		this.upz = upz; 
		this.telefono = tel; 
		this.Comandante = coma; 
		this.longitud = longitud; 
		this.latitud = latitud; 
		

	}


	public String getDependencia() {
		return dependencia;
	}


	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}


	public String getLocalidad() {
		return Localidad;
	}


	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}


	public String getUpz() {
		return upz;
	}


	public void setUpz(String upz) {
		this.upz = upz;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getComandante() {
		return Comandante;
	}


	public void setComandante(String comandante) {
		Comandante = comandante;
	}


	public String getLongitud() {
		return longitud;
	}


	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}


	public String getLatitud() {
		return latitud;
	}


	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

}
