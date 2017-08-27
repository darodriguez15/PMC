package BACKEND;

public class Localidad 
{
	private String nombre;
	private String numero; 

	public Localidad(String name, String number) 
	{
		nombre = name;
		numero = number; 

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
