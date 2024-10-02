package br.edu.ifgoias.academico.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.services.DisciplinaService;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "/disciplinas")
public class DisciplinaResource {

    @Autowired
    private DisciplinaService service;

    @GetMapping
    public ResponseEntity<List<Disciplina>> findAll() {
        List<Disciplina> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Disciplina> findById(@PathVariable Integer id) {
        Optional<Disciplina> disciplina = service.findById(id);
        return disciplina.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Disciplina> insert(@RequestBody Disciplina disciplina) {
        Disciplina newDisciplina = service.insert(disciplina);
        return ResponseEntity.ok().body(newDisciplina);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Disciplina> update(@PathVariable Integer id, @RequestBody Disciplina disciplina) {
        Disciplina updatedDisciplina = service.update(id, disciplina);
        return updatedDisciplina != null ? ResponseEntity.ok().body(updatedDisciplina) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
