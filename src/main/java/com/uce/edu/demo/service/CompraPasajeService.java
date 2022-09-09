package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICompraPasajeRepository;
import com.uce.edu.demo.repository.modelo.CompraPasaje;

@Service
public class CompraPasajeService implements ICompraPasajeService {

	@Autowired
	private ICompraPasajeRepository iCompraPasajeRepository;
	@Override
	public void comprar(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		this.iCompraPasajeRepository.comprar(compraPasaje);
	}

}
