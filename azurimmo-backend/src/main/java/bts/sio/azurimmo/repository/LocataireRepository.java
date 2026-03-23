package bts.sio.azurimmo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import bts.sio.azurimmo.model.Locataire;

@Repository
public interface LocataireRepository extends JpaRepository<Locataire, Long> {
        List<Locataire> findByContrats_Id(long contratId);
}