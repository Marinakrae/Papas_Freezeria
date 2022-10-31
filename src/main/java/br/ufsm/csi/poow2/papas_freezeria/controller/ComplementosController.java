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
    private static Complementos_Repository complementos_repository;

    @GetMapping("/listar")
    public static List<Complementos> getComplementos() {
        List<Complementos> complementos = complementos_repository.findAll();
        return complementos;
    }

    @GetMapping("/{id}")
    public Complementos getComplementosById(@PathVariable("id") int id) {
        Complementos complementos = complementos_repository.getReferenceById(id);
        return complementos;
    }

    @PostMapping("/salvar")
    public static void salvar(@RequestBody Complementos complementos) {
        complementos_repository.save(complementos);
    }

    @PostMapping("/apagar/{id}")
    public void apagar(@PathVariable("id") int id) {
        Complementos complementos = complementos_repository.getReferenceById(id);
        complementos_repository.delete(complementos);
    }

    @PutMapping("/editar/{id}")
    public static void editar(@PathVariable("id") int id, @RequestBody Complementos complementos) {
        Complementos complementosEditado = new Complementos();
        complementosEditado = complementos_repository.getReferenceById(id);
        complementosEditado.setComplemento1(complementos.getComplemento1());
        complementosEditado.setComplemento2(complementos.getComplemento2());
        complementosEditado.setComplemento3(complementos.getComplemento3());

        complementos_repository.save(complementosEditado);
    }
}
