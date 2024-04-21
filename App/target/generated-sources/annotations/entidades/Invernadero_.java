package entidades;

import entidades.Sensor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-20T21:00:14", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Invernadero.class)
public class Invernadero_ { 

    public static volatile ListAttribute<Invernadero, Sensor> sensores;
    public static volatile SingularAttribute<Invernadero, String> direccion;
    public static volatile SingularAttribute<Invernadero, Long> id_invernadero;
    public static volatile SingularAttribute<Invernadero, String> nombre;

}