package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVueloRepository;
import com.uce.edu.demo.repository.modelo.Vuelo;

@Service
@Transactional
public class VueloServiceImpl implements IVueloService {

	@Autowired
	private IVueloRepository iVueloRepository;
	
	@Override
	public void insertar(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.iVueloRepository.insertar(vuelo);
	}

	@Override
	public List<Vuelo> buscar(String origen, String destino, String fecha) {
		// TODO Auto-generated method stub
		return this.iVueloRepository.buscar(origen, destino, fecha);
	}

	@Override
	public Vuelo buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iVueloRepository.buscarPorNumero(numero);
	}

}
