package ar.edu.unlam.pb2;

import java.util.Comparator;

public class ordenadoPorCodigo implements Comparator<Figurita> {

	@Override
	public int compare(Figurita o1, Figurita o2) {
		return o1.getCodigo().compareTo(o2.getCodigo());
	}

}
