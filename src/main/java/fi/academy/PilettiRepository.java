package fi.academy;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PilettiRepository extends CrudRepository<Piletti, Integer> {

    @Query("SELECT p FROM Piletti p ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> getFirstFive(PageRequest pageRequest);

    @Query("SELECT p FROM Piletti p ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAll();

    @Query("SELECT p FROM Piletti p WHERE paivays > current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> getNextFive(PageRequest pageRequest);
}
