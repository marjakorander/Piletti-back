package fi.academy;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PilettiRepository extends CrudRepository<Piletti, Integer> {
    //first five sorted by date and time
    @Query("SELECT p FROM Piletti p ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> getFirstFive(PageRequest pageRequest);

    //all sorted by date and time
    @Query("SELECT p FROM Piletti p ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAll();

    // first five incoming sorted by date and time
    @Query("SELECT p FROM Piletti p WHERE paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> getNextFive(PageRequest pageRequest);

    // all incoming sorted by date and time
    @Query("SELECT p FROM Piletti p WHERE paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAllIncoming();

    // FILTERING BY CATEGORIES

    @Query("SELECT p FROM Piletti p WHERE category like 'Musiikki' and paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAllInMusic();

    @Query("SELECT p FROM Piletti p WHERE category like 'Urheilu' and paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAllInSports();

    @Query("SELECT p FROM Piletti p WHERE category like 'Kulttuuri' and paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAllInCulture();

    @Query("SELECT p FROM Piletti p WHERE category like 'Muu' and paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAllInOther();
}
