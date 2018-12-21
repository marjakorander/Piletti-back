package fi.academy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

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
    public Iterable<Piletti> sortatutPiletit() {
        Iterable<Piletti> sortatut = pilettirepo.sortByAscendingDate();
        return sortatut;
    }

    @PostMapping(value = "/uusi")
    ResponseEntity<Piletti> uusiPiletti(@RequestBody Piletti piletti) throws URISyntaxException {
        Piletti result = pilettirepo.save(piletti);
        return ResponseEntity.created(new URI("uusi" + result.getId()))
                .body(result);
    }
}
