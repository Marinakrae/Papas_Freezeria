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
    private static Nivel_Repository nivel_repository;

    public NivelController(Nivel_Repository nivel_repository) {
        this.nivel_repository = nivel_repository;
    }

    @GetMapping("/listar")
    public static List<Nivel> getComplementos() {
        List<Nivel> niveis = nivel_repository.findAll();
        return niveis;
    }

    @GetMapping("/{id}")
    public Nivel getComplementosById(@PathVariable("id") int id) {
        Nivel niveis = nivel_repository.getReferenceById(id);
        return niveis;
    }

    @PostMapping("/salvar")
    public static void salvar(@RequestBody Nivel niveis) {
        nivel_repository.save(niveis);
    }

    @DeleteMapping("/apagar")
    public void apagar(@RequestBody Nivel nivel) {
        nivel_repository.delete(nivel);
    }

    @PutMapping("/editar/{id}")
    public static void editar(@PathVariable("id") int id, @RequestBody Nivel nivel) {
        Nivel nivelEditado = new Nivel();
        nivelEditado = nivel_repository.getReferenceById(id);
        nivelEditado.setDesempenho_nivel(nivel.getDesempenho_nivel());
        nivelEditado.setIdNivel(nivel.getIdNivel());
        nivelEditado.setDificuldade(nivel.getDificuldade());
        nivelEditado.setPontos(nivel.getPontos());

        nivel_repository.save(nivelEditado);
    }
}

