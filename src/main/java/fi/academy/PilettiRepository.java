package fi.academy;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PilettiRepository extends CrudRepository<Piletti, Integer> {

    //all sorted by date and time
    @Query("SELECT p FROM Piletti p ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAll();

    // first five incoming sorted by date and time
    @Query("SELECT p FROM Piletti p WHERE paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> getNextFive(PageRequest pageRequest);

    // all incoming sorted by date and time
    @Query("SELECT p FROM Piletti p WHERE paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAllIncoming();
}
