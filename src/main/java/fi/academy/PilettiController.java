package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.net.URISyntaxException;

@CrossOrigin(origins = "*")
@RestController
public class PilettiController {
    private PilettiRepository pilettirepo;

    @Autowired
    public PilettiController(PilettiRepository pilettirepo){
        this.pilettirepo = pilettirepo;

    }
    @GetMapping(value = "/etusivu")
    public Iterable<Piletti> pilettilistaus() {
        Iterable<Piletti> piletit = pilettirepo.findAll();
        return piletit;
    }

    //PageRequest.of(firstResult, maxResults, Sort.by(...))

    @GetMapping(value = "/sortattu")
    public Iterable<Piletti> sortatutViisi() {
        Iterable<Piletti> sortatutViisi= pilettirepo.getFirstFive(PageRequest.of(0,5));
        return sortatutViisi;
    }

    @GetMapping(value = "/sortatutTulevat")
    public Iterable<Piletti> sortatutTulevat() {
        Iterable<Piletti> sortatutTulevat= pilettirepo.findAllIncoming();
        return sortatutTulevat;
    }

    @GetMapping(value = "/sortatutViisi")
    public Iterable<Piletti> sortatutViisiSeuraavaa() {
        Iterable<Piletti> sortatutViisiSeuraavaa= pilettirepo.getNextFive(PageRequest.of(0,6));
        return sortatutViisiSeuraavaa;
    }

    @GetMapping(value = "/sortattuKaikki")
    public Iterable<Piletti> sortatutPiletit() {
        Iterable<Piletti> sortatut = pilettirepo.findAll();
        return sortatut;
    }

    @GetMapping(value = "/kategoria/urheilu")
    public Iterable<Piletti> urheilu() {
        Iterable<Piletti> urheilu = pilettirepo.findAllInSports();
        return urheilu;
    }

    @GetMapping(value = "/kategoria/musiikki")
    public Iterable<Piletti> musiikki() {
        Iterable<Piletti> musiikki = pilettirepo.findAllInMusic();
        return musiikki;
    }

    @GetMapping(value = "/kategoria/kulttuuri")
    public Iterable<Piletti> kulttuuri() {
        Iterable<Piletti> kulttuuri = pilettirepo.findAllInCulture();
        return kulttuuri;
    }

    @GetMapping(value = "/kategoria/muu")
    public Iterable<Piletti> muut() {
        Iterable<Piletti> muut = pilettirepo.findAllInOther();
        return muut;
    }

    @PostMapping(value = "/uusi")
    ResponseEntity<Piletti> uusiPiletti(@RequestBody Piletti piletti) throws URISyntaxException {
        Piletti result = pilettirepo.save(piletti);
        return ResponseEntity.created(new URI("/uusi/" + result.getId()))
                .body(result);
    }
}

