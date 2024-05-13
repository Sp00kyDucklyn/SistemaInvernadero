
package com.invernadero.ApiExterna.Controlador;
import DominioDatos.Datos;
import com.invernadero.fachadadatosexternos.FachadaDatosExternos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Jorge
 */
@RestController
@RequestMapping("/api")
public class DatosExternos {


    FachadaDatosExternos fachadaExterna = new FachadaDatosExternos();
    
    @GetMapping("/datos-externos")
    public ResponseEntity<?> ObtenerDatos(){
        return ResponseEntity.ok(fachadaExterna.obtenerDatos());
    }

    @GetMapping("/datos-externos/{idSensor}")
    public ResponseEntity<?> ObtenerSensor(@PathVariable String idSensor){
        return ResponseEntity.ok(fachadaExterna.obtenerDatosPorIdSensor(idSensor));
    }

//    @GetMapping("/datos-externos")
//    public ResponseEntity<?> ObtenerDatosPorPeriodo(){
//        return ResponseEntity.ok(fachadaExterna.obtenerDatosPorPeriodo());
//    }
    
}
