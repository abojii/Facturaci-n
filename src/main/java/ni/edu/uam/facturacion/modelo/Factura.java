package ni.edu.uam.facturacion.modelo;

import com.tuempresa.facturacion.calculadores.CalculadorSiguienteNumeroParaAnyo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.CurrentLocalDateCalculator;
import org.openxava.calculators.CurrentYearCalculator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Factura {
    @Id
    @GeneratedValue(generator="system-uuid")
    @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=32)
    String oid;

    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class) // Año actual
    int anyo;


    @Column(length=6)
    @DefaultValueCalculator(value= CalculadorSiguienteNumeroParaAnyo.class,
            properties=@PropertyValue(name="anyo") // Para inyectar el valor de anyo de Factura
            // en el calculador antes de llamar a calculate()
    )
    int numero;
    //@Column(length=6)
    //int numero;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fecha;

    @ManyToOne(fetch=FetchType.LAZY, optional=false) // El cliente es obligatorio
    Cliente cliente;

    @TextArea
    String observaciones;

    @ElementCollection
    Collection<Detalle> detalles;




}
