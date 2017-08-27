package BACKEND;

public class Colegio
{
	private String localidad;
	private String nombre;

	public Colegio (String loca, String nom)
	{
		localidad = loca;
		nombre = nom; 

	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
