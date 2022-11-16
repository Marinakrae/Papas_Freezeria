package br.ufsm.csi.poow2.papas_freezeria.controller;

import br.ufsm.csi.poow2.papas_freezeria.model.Nivel;
import br.ufsm.csi.poow2.papas_freezeria.repository.Nivel_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("freezeria/nivel")
public class NivelController {

    @Autowired
    private Nivel_Repository nivel_repository;

    public NivelController(Nivel_Repository nivel_repository) {
        this.nivel_repository = nivel_repository;
    }

    @GetMapping("/listar")
    public List<Nivel> getComplementos() {
        return nivel_repository.findAll();
    }

    @GetMapping("/{id}")
    public Nivel getComplementosById(@PathVariable("id") int id) {
        return nivel_repository.getReferenceById(id);
    }

    @PostMapping("/salvar")
    public void salvar(@RequestBody Nivel niveis) {
        nivel_repository.save(niveis);
    }

    //substituir pela inativação
    @DeleteMapping("/apagar")
    public void apagar(@RequestBody Nivel nivel) {
        nivel_repository.delete(nivel);
    }

    @PutMapping("/editar/{id}")
    public void editar(@PathVariable("id") int id, @RequestBody Nivel nivel) {
        new Nivel();
        Nivel nivelEditado;
        nivelEditado = nivel_repository.getReferenceById(id);
        nivelEditado.setDesempenho_nivel(nivel.getDesempenho_nivel());
        nivelEditado.setIdNivel(nivel.getIdNivel());
        nivelEditado.setDificuldade(nivel.getDificuldade());
        nivelEditado.setPontos(nivel.getPontos());

        nivel_repository.save(nivelEditado);
    }
}

