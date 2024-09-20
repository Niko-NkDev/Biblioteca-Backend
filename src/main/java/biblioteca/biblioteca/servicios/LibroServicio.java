package biblioteca.biblioteca.servicios;

import biblioteca.biblioteca.entidades.Libro;
import biblioteca.biblioteca.repositorios.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServicio {
    @Autowired
    private LibroRepositorio libroRepositorio;

    public List<Libro> findAll(){
        return libroRepositorio.findAll();
    }
    public Libro findById(Long id){
        return libroRepositorio.findById(id).orElse(null);
    }
    public Libro save(Libro libro){
        return libroRepositorio.save(libro);
    }
    public void delete(Long id){
        libroRepositorio.deleteById(id);
    }
}


