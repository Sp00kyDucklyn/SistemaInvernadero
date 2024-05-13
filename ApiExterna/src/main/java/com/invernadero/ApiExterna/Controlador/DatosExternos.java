
package com.invernadero.ApiExterna.Controlador;
import com.invernadero.fachadadatosexternos.FachadaDatosExternos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    
}
