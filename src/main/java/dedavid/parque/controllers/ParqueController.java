package dedavid.parque.controllers;

import dedavid.parque.models.Desconto;
import dedavid.parque.models.Passaporte;
import dedavid.parque.service.ParqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parque")
public class ParqueController {

    private ParqueService service;

    public ParqueController(ParqueService service) {
        this.service = service;
    }

    @PostMapping("/passaportes")
    public ResponseEntity<Passaporte> comprarPassaporte(@RequestBody Passaporte passaporte, List<Desconto> descontos) {
        Passaporte pass = service.criarPassaporte(passaporte, descontos);
        return new ResponseEntity<>(pass, HttpStatus.CREATED);
    }

    @GetMapping("/descontos")
    public ResponseEntity<List<Desconto>> getDescontos() {
        return new ResponseEntity<>(service.getDescontos(), HttpStatus.OK);
    }

    @GetMapping("/descontos/{id}")
    public ResponseEntity<Desconto> getDesconto(@PathVariable Long id) {
        Desconto desc = service.getDesconto(id);
        return new ResponseEntity<>(desc, HttpStatus.OK);
    }

    @PutMapping("/entradas/{id}")
    public ResponseEntity<?> entrar(@PathVariable("id") Long passId) {
        service.registrarEntrada(passId);
        return new ResponseEntity<>("Entrada Permitida", HttpStatus.OK);
    }

    /*Gerente*/

    @GetMapping("/gerente/passaportes")
    public ResponseEntity<List<Passaporte>> getPassaportes() {
        return new ResponseEntity<>(service.getPassaportes(), HttpStatus.OK);
    }

    @GetMapping("/gerente/passaportes/{id}")
    public ResponseEntity<Passaporte> getPassaporte(@PathVariable Long id) {
        return new ResponseEntity<>(service.getPassaporte(id), HttpStatus.OK);
    }

    @PostMapping("/gerente/descontos")
    public ResponseEntity<Desconto> criarDesconto(@RequestBody Desconto desconto) {
        return new ResponseEntity<>(service.criarDesconto(desconto), HttpStatus.CREATED);
    }

    @PutMapping("/gerente/descontos/{id}")
    public ResponseEntity<?> ativarDesconto(@PathVariable Long id, @RequestParam boolean ativar) {
        service.ativarDesconto(id, ativar);
        return new ResponseEntity<>("Desconto alterado", HttpStatus.OK);
    }
}
