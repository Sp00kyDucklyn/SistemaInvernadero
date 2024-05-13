Create database invernadero;
use invernadero;
CREATE TABLE invernadero (
    id_invernadero BIGINT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(255) NOT NULL,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE alarma (
    id_alarma BIGINT AUTO_INCREMENT PRIMARY KEY,
    limite_humedad DOUBLE NOT NULL,
    limite_temperatura DOUBLE NOT NULL
);

CREATE TABLE sensor (
    id_sensor BIGINT AUTO_INCREMENT PRIMARY KEY,
    clave_sensor VARCHAR(255) NOT NULL,
    marca VARCHAR(255) NOT NULL,
    id_invernadero BIGINT,
    id_alarma BIGINT,
    FOREIGN KEY (id_invernadero) REFERENCES invernadero(id_invernadero),
    FOREIGN KEY (id_alarma) REFERENCES alarma(id_alarma)
);

CREATE PROCEDURE agregar_alarma_y_actualizar_sensor(
    IN p_limite_humedad DOUBLE,
    IN p_limite_temperatura DOUBLE,
    IN p_id_sensor BIGINT
)
BEGIN
    -- Agregar la nueva alarma
    INSERT INTO alarma (limite_humedad, limite_temperatura)
    VALUES (p_limite_humedad, p_limite_temperatura)
    
    -- Obtener el ID de la alarma recién agregada
    SET @last_alarm_id = LAST_INSERT_ID()
    
    -- Actualizar el sensor con el ID de la nueva alarma
    UPDATE sensor SET id_alarma = @last_alarm_id WHERE id_sensor = p_id_sensor
END//

DELIMITER ;

INSERT INTO invernadero (direccion, nombre) VALUES
('Calle Falsa 123', 'Invernadero A'),
('Avenida Principal 456', 'Invernadero B'),
('Calle Secundaria 789', 'Invernadero C');

-- Datos de prueba para la tabla alarmas
INSERT INTO alarma (limite_humedad, limite_temperatura) VALUES
(70.5, 25.0),
(65.0, 28.0),
(80.0, 30.0);

-- Datos de prueba para la tabla sensores
INSERT INTO sensor (clave_sensor, marca, id_invernadero, id_alarma) VALUES
('ABC123', 'SensorX', 1, 1),
('DEF456', 'SensorY', 2, 2),
('GHI789', 'SensorZ', 3, 3);