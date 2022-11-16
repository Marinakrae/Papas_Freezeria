package br.ufsm.csi.poow2.papas_freezeria.controller;


import br.ufsm.csi.poow2.papas_freezeria.model.Complementos;
import br.ufsm.csi.poow2.papas_freezeria.repository.Complementos_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("freezeria/complementos")
public class ComplementosController {

    @Autowired
    private Complementos_Repository complementos_repository;

    public ComplementosController(Complementos_Repository complementos_repository) {
        this.complementos_repository = complementos_repository;
    }

    @GetMapping("/listar")
    public List<Complementos> getComplementos() {
        return complementos_repository.findAll();
    }

    @GetMapping("/{id}")
    public Complementos getComplementosById(@PathVariable("id") int id) {
        return complementos_repository.getReferenceById(id);
    }

    @PostMapping("/salvar")
    public void salvar(@RequestBody Complementos complementos) {
        complementos_repository.save(complementos);
    }

    //substituir pela inativação
    @DeleteMapping("/apagar")
    public void apagar(@RequestBody Complementos complementos) {
        //Ao inves de apagar, vamos inativar o registro
        complementos_repository.delete(complementos);
    }

    @PutMapping("/editar/{id}")
    public void editar(@PathVariable("id") int id, @RequestBody Complementos complementos) {
        new Complementos();
        Complementos complementosEditado;
        complementosEditado = complementos_repository.getReferenceById(id);
        complementosEditado.setComplemento1(complementos.getComplemento1());
        complementosEditado.setComplemento2(complementos.getComplemento2());
        complementosEditado.setComplemento3(complementos.getComplemento3());

        complementos_repository.save(complementosEditado);
    }
}
