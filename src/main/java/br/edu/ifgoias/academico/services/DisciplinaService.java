package br.edu.ifgoias.academico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    public List<Disciplina> findAll() {
        return repository.findAll();
    }

    public Optional<Disciplina> findById(Integer id) {
        return repository.findById(id);
    }

    public Disciplina insert(Disciplina disciplina) {
        return repository.save(disciplina);
    }

    public Disciplina update(Integer id, Disciplina disciplina) {
        Optional<Disciplina> optionalDisciplina = repository.findById(id);
        if (optionalDisciplina.isPresent()) {
            Disciplina existingDisciplina = optionalDisciplina.get();
            existingDisciplina.setNomedisciplina(disciplina.getNomedisciplina());
            return repository.save(existingDisciplina);
        }
        return null;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
