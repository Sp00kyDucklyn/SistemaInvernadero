package entidades;

import entidades.Alarma;
import entidades.Invernadero;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-04-20T21:00:14", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Sensor.class)
public class Sensor_ { 

    public static volatile SingularAttribute<Sensor, Invernadero> invernadero;
    public static volatile SingularAttribute<Sensor, String> claveSensor;
    public static volatile SingularAttribute<Sensor, String> marca;
    public static volatile SingularAttribute<Sensor, Alarma> alarma;
    public static volatile SingularAttribute<Sensor, Long> idSensor;

}