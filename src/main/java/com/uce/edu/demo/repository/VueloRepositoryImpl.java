package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Vuelo;

@Repository
@Transactional
public class VueloRepositoryImpl implements IVueloRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Vuelo vuelo) {
		// TODO Auto-generated method stub

		this.entityManager.persist(vuelo);
	}

	@Override
	public List<Vuelo> buscar(String origen, String destino, String fecha) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo> myQuery = this.entityManager.createQuery(
				"SELECT v FROM Vuelo v JOIN v.avion a WHERE v.origen= :datoOrigen AND v.destino= :datoDestino AND v.fechaVuelo= :datoFecha",
				Vuelo.class);

		myQuery.setParameter("datoOrigen", origen);
		myQuery.setParameter("datoDestino", destino);
		myQuery.setParameter("datoFecha", fecha);

		return myQuery.getResultList();

	}
	@Override
	public Vuelo buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Vuelo> myQuery = this.entityManager
				.createQuery("SELECT v FROM Vuelo v WHERE v.numero = :datoNumero AND v.estado = :datoEstado ", Vuelo.class);

		myQuery.setParameter("datoNumero", numero);
		myQuery.setParameter("datoEstado", "D");

		return myQuery.getSingleResult();
	}
}
