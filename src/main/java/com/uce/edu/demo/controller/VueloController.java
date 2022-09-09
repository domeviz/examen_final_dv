package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.CompraPasaje;
import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.service.ICompraPasajeService;
import com.uce.edu.demo.service.IVueloService;

@Controller
@RequestMapping("/vuelos")
public class VueloController {

	@Autowired
	private IVueloService iVueloService;
	
	@Autowired
	private ICompraPasajeService iCompraPasajeService;

	@GetMapping("/buscar")
	public String buscarVuelos(Vuelo vuelo) {
		return "VistaBuscar";
	}
	
	@GetMapping("/vuelosDisponibles")
	public String buscarVuelosDisponibles(Model modelo, Vuelo vuelo) {
		List<Vuelo> vuelos = this.iVueloService.buscar(vuelo.getOrigen(), vuelo.getDestino(),
				vuelo.getFechaVuelo());
		modelo.addAttribute("vuelos", vuelos);
		return "VistaVuelosDisponibles";
	}
	
	@GetMapping("/buscarVuelo")
	public String reservarVuelo(Vuelo vuelo) {
		return "VistaVuelo";
	}
	
	@GetMapping("/reservarVuelo")
	public String ingresarReserva(Vuelo vuelo, Model modelo) {
		Vuelo vDisp = this.iVueloService.buscarPorNumero(vuelo.getNumero());
		modelo.addAttribute("vDisp", vDisp);
		return "VistaReservar";
	}
	
	@PostMapping("/reservar")
	public String ingresarReserva(CompraPasaje comprapasaje) {
		this.iCompraPasajeService.comprar(comprapasaje);
		return "redirect:/vuelos/buscarVuelo";
	}
}
