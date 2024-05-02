
import DominioDatos.Datos;
import com.invernadero.fachadadatosexternos.FachadaDatosExternos;
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Jorge
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FachadaDatosExternos fachada = new FachadaDatosExternos();
        
        // Crear datos de prueba
        Datos datos = new Datos("12", "Sensor de asdasdas", 75.5, 25.3, LocalDateTime.now(), "MarcaXYZ");
//        fachada.agregarDatos(datos);
        
        try {
            Datos datosInsertados = fachada.agregarDatos(datos);
            if (datosInsertados != null) {
                System.out.println("Datos insertados correctamente. ID generado: " + datosInsertados.getId());
            } else {
                System.out.println("Hubo un problema al insertar los datos.");
            }
        } catch (Exception e) {
            System.out.println("Error al agregar datos: " + e.getMessage());
        }
    }
    
}
