package ar.edu.unlam.pb2;

public abstract class Usuario {
	
	private String nombre;
	private Integer edad;
	private Integer dni;
	
	public Usuario(String nombre, Integer edad, Integer dni) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public abstract Boolean agregarFigurita(Figurita nuevaFigurita);
	
	public abstract Integer cantidadDeFiguritas();


}
