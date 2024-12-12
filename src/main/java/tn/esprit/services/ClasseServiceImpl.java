package tn.esprit.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Classe;
import tn.esprit.repositories.ClasseRepository;


@Service
@AllArgsConstructor
public class ClasseServiceImpl implements  IClasseService{

    ClasseRepository classeRepository;
    @Override
    public Classe addClasse(Classe classe) {
        return classeRepository.save(classe);
    }







}
