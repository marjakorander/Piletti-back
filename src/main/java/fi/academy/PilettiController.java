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

    @GetMapping(value = "/sortattu")
    public Iterable<Piletti> sortatutViisi() {
        Iterable<Piletti> sortatutViisi= pilettirepo.getFirstFive(new PageRequest(0,5));
        return sortatutViisi;
    }

    @GetMapping(value = "/sortatutViisi")
    public Iterable<Piletti> sortatutViisiSeuraavaa() {
        Iterable<Piletti> sortatutViisiSeuraavaa= pilettirepo.getNextFive(new PageRequest(0,5));
        return sortatutViisiSeuraavaa;
    }

    @GetMapping(value = "/sortattuKaikki")
    public Iterable<Piletti> sortatutPiletit() {
        Iterable<Piletti> sortatut = pilettirepo.findAll();
        return sortatut;
    }

    @PostMapping(value = "/uusi")
    ResponseEntity<Piletti> uusiPiletti(@RequestBody Piletti piletti) throws URISyntaxException {
        Piletti result = pilettirepo.save(piletti);
        return ResponseEntity.created(new URI("/uusi/" + result.getId()))
                .body(result);
    }
}

