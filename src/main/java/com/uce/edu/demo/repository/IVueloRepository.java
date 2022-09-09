package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface IVueloRepository {

	public void insertar(Vuelo vuelo);

	public List<Vuelo> buscar(String origen, String destino, String fecha);
	
	public Vuelo buscarPorNumero(String numero);
}
