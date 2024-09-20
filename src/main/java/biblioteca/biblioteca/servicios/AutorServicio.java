package biblioteca.biblioteca.servicios;

import biblioteca.biblioteca.entidades.Autor;
import biblioteca.biblioteca.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorio autorRepositorio;

    public List<Autor> findAll(){
        return autorRepositorio.findAll();
    }
    public Autor findById(Long id){
        return autorRepositorio.findById(id).orElse(null);
    }
    public Autor save(Autor autores){
        return autorRepositorio.save(autores);
    }
    public void delete(Long id){
        autorRepositorio.deleteById(id);
    }
}

