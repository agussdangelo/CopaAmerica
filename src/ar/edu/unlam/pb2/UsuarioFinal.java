package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class UsuarioFinal extends Usuario{
	
	private ArrayList<Figurita> stockFiguritas;
	private ArrayList<Figurita> figuritasPegadas;

	public UsuarioFinal(String nombre, Integer edad, Integer dni) {
		super(nombre, edad, dni);
		this.stockFiguritas = new ArrayList<Figurita>();
		this.figuritasPegadas = new ArrayList<Figurita>();
	}

	public ArrayList<Figurita> getFiguritas() {
		return stockFiguritas;
	}

	public void setFiguritas(ArrayList<Figurita> figuritas) {
		this.stockFiguritas = figuritas;
	}

	public Boolean agregarFigurita(Figurita nuevaFigurita) {
		return stockFiguritas.add(nuevaFigurita);
	}
	
	@Override
	public Integer cantidadDeFiguritas() {
		return stockFiguritas.size();
	}
	
	public Boolean pegarFigurita(Figurita nuevaFigurita) throws FiguritaRepetidaException {
		if (figuritasPegadas.contains(nuevaFigurita)) {
			throw new FiguritaRepetidaException("No se puede pegar la figurita porque está repetida");
		}
		if (stockFiguritas.contains(nuevaFigurita)) {
			stockFiguritas.remove(nuevaFigurita);
			figuritasPegadas.add(nuevaFigurita);
			return true;
		}
		return false;
	}

	public Boolean intercambiarFiguritas(UsuarioFinal otroUsuario, Figurita miFigurita, Figurita suFigurita) throws FiguritaNoDisponibleException {
		if (figuritasPegadas.contains(miFigurita)) {
			throw new FiguritaNoDisponibleException("No se puede intercambiar una figurita que ya ha sido pegada");
		}
		if(!otroUsuario.getFiguritas().contains(suFigurita)) {
			throw new FiguritaNoDisponibleException("El otro usuario no tiene esta figurita");
		}
		if (this.stockFiguritas.contains(miFigurita) && otroUsuario.getFiguritas().contains(suFigurita)) {
			this.stockFiguritas.remove(miFigurita);
			otroUsuario.getFiguritas().remove(suFigurita);
			this.stockFiguritas.add(suFigurita);
			otroUsuario.getFiguritas().add(miFigurita);
			return true;
		}
		return false;
	}

}
