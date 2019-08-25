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

    @PostMapping(value = "/uusi")
    ResponseEntity<Piletti> uusiPiletti(@RequestBody Piletti piletti) throws URISyntaxException {
        Piletti result = pilettirepo.save(piletti);
        return ResponseEntity.created(new URI("/uusi/" + result.getId()))
                .body(result);
    }
}

