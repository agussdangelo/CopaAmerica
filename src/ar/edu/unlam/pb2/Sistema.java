package ar.edu.unlam.pb2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Sistema {

	private TreeSet<Figurita> figuritas;
	private HashSet<Administrador> administradores;
	private HashSet<UsuarioFinal> usuariosFinales;
	
	public Sistema() {
		this.administradores = new HashSet<Administrador>();
		this.usuariosFinales = new HashSet<UsuarioFinal>();
		this.figuritas = new TreeSet<Figurita>();
	}

	public HashSet<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(HashSet<Administrador> administradores) {
		this.administradores = administradores;
	}

	public HashSet<UsuarioFinal> getUsuariosFinales() {
		return usuariosFinales;
	}

	public void setUsuariosFinales(HashSet<UsuarioFinal> usuariosFinales) {
		this.usuariosFinales = usuariosFinales;
	}
	
	public TreeSet<Figurita> getFiguritas() {
		return figuritas;
	}

	public void setFiguritas(TreeSet<Figurita> figuritas) {
		this.figuritas = figuritas;
	}
	
	public Boolean agregarUsuarioFinal(UsuarioFinal usuarioNuevo) {
		return usuariosFinales.add(usuarioNuevo);
	}
	
	public Boolean agregarAdministrador(Administrador adminNuevo) {
		return administradores.add(adminNuevo);
	}
	
	public Boolean agregarFigurita(Figurita nuevaFigurita) {
		return figuritas.add(nuevaFigurita);
	}
	
	public TreeSet<Figurita> devolverFiguritasOrdenadosPorGrupo() {
		return ordenarFiguritasParaDevolver(new ordenadoPorGrupo());
	}
	
	public TreeSet<Figurita> devolverFiguritasOrdenadosPorSeleccion() {
		return ordenarFiguritasParaDevolver(new ordenadoPorSeleccion());
	}
	
	public TreeSet<Figurita> devolverFiguritasOrdenadosPorCodigo() {
		return ordenarFiguritasParaDevolver(new ordenadoPorCodigo());
	}
	
	public TreeSet<Figurita> ordenarFiguritasParaDevolver(Comparator<Figurita> citerioDeOrdenacion) {
		TreeSet<Figurita> figuritaOrdenada = new TreeSet<Figurita>(citerioDeOrdenacion);
		figuritaOrdenada.addAll(figuritas);
		return figuritaOrdenada;
	}	

}
