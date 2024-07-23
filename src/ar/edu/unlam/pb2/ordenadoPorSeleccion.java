package ar.edu.unlam.pb2;

import java.util.Comparator;

public class ordenadoPorSeleccion implements Comparator<Figurita> {

	@Override
	public int compare(Figurita o1, Figurita o2) {
		return o1.getSeleccion().compareTo(o2.getSeleccion());
	}

}
