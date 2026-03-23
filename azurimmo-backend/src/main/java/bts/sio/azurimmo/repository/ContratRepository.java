package bts.sio.azurimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bts.sio.azurimmo.model.Contrat;


public interface ContratRepository extends JpaRepository<Contrat, Long> {
	 List<Contrat> findByAppartement_Id(long id);
}