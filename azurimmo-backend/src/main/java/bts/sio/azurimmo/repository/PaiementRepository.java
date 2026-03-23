package bts.sio.azurimmo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bts.sio.azurimmo.model.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long>{
	List<Paiement> findByContrat_Id(long id);
}
