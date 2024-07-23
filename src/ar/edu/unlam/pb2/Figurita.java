package ar.edu.unlam.pb2;

import java.util.Objects;

public class Figurita implements Comparable<Figurita>{
	
	private Integer codigo;
	private String letraGrupo;
	private String seleccion;
	private String nombreJugador;
	private Double valorDelJugador;
	
	public Figurita(Integer codigo, String letraGrupo, String seleccion, String nombreJugador, Double valorDelJugador) {
		this.codigo = codigo;
		this.letraGrupo = letraGrupo;
		this.seleccion = seleccion;
		this.nombreJugador = nombreJugador;
		this.valorDelJugador = valorDelJugador;
	}
	
	public Figurita() {
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getLetraGrupo() {
		return letraGrupo;
	}

	public void setLetraGrupo(String letraGrupo) {
		this.letraGrupo = letraGrupo;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public Double getValorDelJugador() {
		return valorDelJugador;
	}

	public void setValorDelJugador(Double valorDelJugador) {
		this.valorDelJugador = valorDelJugador;
	}

	@Override
	public int compareTo(Figurita o) {
		return codigo.compareTo(o.getCodigo());
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figurita other = (Figurita) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
