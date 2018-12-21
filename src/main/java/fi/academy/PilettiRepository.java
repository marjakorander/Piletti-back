package fi.academy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PilettiRepository extends CrudRepository<Piletti, Integer> {
    Iterable<Piletti> findAll();

    @Query("SELECT p FROM Piletti p ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> sortByAscendingDate();
}
