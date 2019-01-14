package fi.academy;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PilettiRepository extends CrudRepository<Piletti, Integer> {
    //ekat viisi päivämäärän ja ajan mukaan sortattuna
    @Query("SELECT p FROM Piletti p ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> getFirstFive(PageRequest pageRequest);

    //kaikki päivämäärän ja ajan mukaan sortattuna
    @Query("SELECT p FROM Piletti p ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAll();

    // ekat viisi tulevaa päivämäärän ja ajan mukaan sortattuna
    @Query("SELECT p FROM Piletti p WHERE paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> getNextFive(PageRequest pageRequest);

    // kaikki tulevat päivämäärän ja ajan mukaan sortattuna
    @Query("SELECT p FROM Piletti p WHERE paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAllIncoming();

    // HAUT KATEGORIOITTAIN

    @Query("SELECT p FROM Piletti p WHERE category like 'Musiikki' and paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAllInMusic();

    @Query("SELECT p FROM Piletti p WHERE category like 'Urheilu' and paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAllInSports();

    @Query("SELECT p FROM Piletti p WHERE category like 'Kulttuuri' and paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAllInCulture();

    @Query("SELECT p FROM Piletti p WHERE category like 'Muu' and paivays >= current_date ORDER BY paivays ASC, klo ASC")
    Iterable<Piletti> findAllInOther();
}
