package ni.edu.uam.facturacion.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
@Getter
@Setter
public class Direccion {
    @Id
    private Long id;
    @Column(length=30)
    String viaPublica;

    @Column(length = 5)
    int codigoPostal;

    @Column(length = 20)
    String municipio;

    @Column(length = 30)
    String provincia;
}
