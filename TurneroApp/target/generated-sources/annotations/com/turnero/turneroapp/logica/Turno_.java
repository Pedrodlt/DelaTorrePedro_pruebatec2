package com.turnero.turneroapp.logica;

import com.turnero.turneroapp.logica.Ciudadano;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-11-30T17:50:28")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, Date> fecha;
    public static volatile SingularAttribute<Turno, String> estado;
    public static volatile SingularAttribute<Turno, Integer> numero;
    public static volatile SingularAttribute<Turno, String> tramite;
    public static volatile SingularAttribute<Turno, Long> id;
    public static volatile SingularAttribute<Turno, Ciudadano> ciudadano;

}