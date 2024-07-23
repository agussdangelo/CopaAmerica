package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Administrador extends Usuario{
	
	private ArrayList<Figurita> figuritas;

	public Administrador(String nombre, Integer edad, Integer dni) {
		super(nombre, edad, dni);
		this.figuritas = new ArrayList<Figurita>();
	}

	public ArrayList<Figurita> getFiguritas() {
		return figuritas;
	}

	public void setFiguritas(ArrayList<Figurita> figuritas) {
		this.figuritas = figuritas;
	}
	
	@Override
	public Boolean agregarFigurita(Figurita nuevaFigurita) {
		return figuritas.add(nuevaFigurita);
	}
	
	@Override
	public Integer cantidadDeFiguritas() {
		return figuritas.size();
	}
	
	public Boolean darDeAltaCodigo(Figurita figurita1, Figurita figurita2) throws CodigoExistenteException {
		if(figurita2.getCodigo().equals(figurita1.getCodigo())) {
			throw new CodigoExistenteException("Esta figurita ya contiene un codigo existente");
		}
		
		if(!figurita2.getCodigo().equals(figurita1.getCodigo())) {
			return true;
		}
		return false;
		
	}

}
