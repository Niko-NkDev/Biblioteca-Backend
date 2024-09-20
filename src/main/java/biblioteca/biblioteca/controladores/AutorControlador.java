package biblioteca.biblioteca.controladores;


import biblioteca.biblioteca.entidades.Autor;
import biblioteca.biblioteca.servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorControlador {

    @Autowired
    private AutorServicio autorServicio;

    @GetMapping
    public List<Autor> getAllAutores() {
        return autorServicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id){
        Autor autor = autorServicio.findById(id);
        if (autor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autor);
    }

    @PostMapping
    public Autor createAutor(@RequestBody Autor autor) {
        return autorServicio.save(autor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Long id, @RequestBody Autor autorDetails) {
        Autor autor = autorServicio.findById(id);
        if (autor == null) {
            return ResponseEntity.notFound().build();
        }
        autor.setNombre(autorDetails.getNombre());
        autor.setNacionalidad(autorDetails.getNacionalidad());
        autor.setFechaNacimiento(autorDetails.getFechaNacimiento());

        final Autor updatedAutor = autorServicio.save(autor);
        return ResponseEntity.ok(updatedAutor);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        Autor autor = autorServicio.findById(id);
        if (autor == null) {
            return ResponseEntity.notFound().build();
        }
        autorServicio.delete(id);
        return ResponseEntity.noContent().build();
    }
}
