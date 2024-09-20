package biblioteca.biblioteca.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "fecha_publicacion")
    private String fechaPublicacion;
    @Column(name = "id_autor")
    private Long idAutor;

}
