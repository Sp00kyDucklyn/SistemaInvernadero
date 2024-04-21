package entidades;

import entidades.Sensor;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-20T21:00:14", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Alarma.class)
public class Alarma_ { 

    public static volatile SingularAttribute<Alarma, Sensor> sensor;
    public static volatile SingularAttribute<Alarma, Double> limiteHumedad;
    public static volatile SingularAttribute<Alarma, Double> limiteTemperatura;
    public static volatile SingularAttribute<Alarma, Long> idAlarma;

}