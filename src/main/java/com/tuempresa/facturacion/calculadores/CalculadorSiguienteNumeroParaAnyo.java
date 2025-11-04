package com.tuempresa.facturacion.calculadores;

import lombok.Getter;
import lombok.Setter;
import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;

import javax.persistence.Query;

public class CalculadorSiguienteNumeroParaAnyo implements ICalculator {
    @Getter
    @Setter
    int anyo;

    public Object calculate() throws Exception {
        Query query = XPersistence.getManager().createQuery("select max(f.numero) from Factura f where f.anyo = :anyo");

        query.setParameter("anyo", anyo); // Ponemos el año inyectado como parámetro de la consulta
        Integer ultimoNumero = (Integer) query.getSingleResult();
        return ultimoNumero == null ? 1 : ultimoNumero + 1;
    }

}
