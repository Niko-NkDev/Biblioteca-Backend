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
@Table(name="autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_autores")
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name = "nacionalidad")
    private  String nacionalidad;
    @Column(name = "fecha_nacimiento")
    private  String fechaNacimiento;
}
