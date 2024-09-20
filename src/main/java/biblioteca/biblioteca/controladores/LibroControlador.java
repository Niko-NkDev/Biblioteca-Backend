package biblioteca.biblioteca.controladores;

import biblioteca.biblioteca.entidades.Autor;
import biblioteca.biblioteca.entidades.Libro;
import biblioteca.biblioteca.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;

    @GetMapping
    public List<Libro> getAllLibros() {
        return libroServicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Libro libro = libroServicio.findById(id);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libro);
    }

    @PostMapping
    public Libro createLibros(@RequestBody Libro libro) {
        return libroServicio.save(libro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libroDetails) {
        Libro libro = libroServicio.findById(id);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        libro.setTitulo(libroDetails.getTitulo());
        libro.setCategoria(libroDetails.getCategoria());
        libro.setFechaPublicacion(libroDetails.getFechaPublicacion());
        libro.setIdAutor(libroDetails.getIdAutor());

        final Libro updatedLibro = libroServicio.save(libro);
        return ResponseEntity.ok(updatedLibro);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        Libro libro = libroServicio.findById(id);
        if (libro == null) {
            return ResponseEntity.notFound().build();
        }
        libroServicio.delete(id);
        return ResponseEntity.noContent().build();
    }

}
