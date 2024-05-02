package com.invernadero.creadorpdf;

import DominioDatos.Datos;
import com.invernadero.fachada.Fachada;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.List;
/**
 *
 * @author Jorge
 */
public class PDFCreator {

    String directorioTrabajo = System.getProperty("user.dir");
    String rutaArchivo ="/Recursos/datos.pdf";
    
    public PDFCreator(){
       
    }
    
    public void generarPDF(){
        Fachada fachada = new Fachada();
        List<Datos> listaDatos = fachada.obtenerDatos();
        Document documento = new Document(PageSize.A4);
        
        try {
            String directorioTrabajo = System.getProperty("user.dir");
            String rutaArchivo ="/Recursos/datos.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(directorioTrabajo+rutaArchivo));
            documento.open();
            
            Paragraph titulo = new Paragraph("DATOS DE SENSORES", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
            titulo.setAlignment(Element.ALIGN_CENTER);

            documento.add(titulo);

            documento.add(new Paragraph("\n"));
            
            PdfPTable tabla = new PdfPTable(7);
            
            float[] anchos = {1f, 1f, 1f, 1f, 1f, 2f, 1f};
            tabla.setTotalWidth(PageSize.A6.getWidth());
            tabla.setWidths(anchos);
            
            tabla.addCell(crearCelda("ID", 8));
            tabla.addCell(crearCelda("ID SENSOR", 8));
            tabla.addCell(crearCelda("TIPO", 8));
            tabla.addCell(crearCelda("HUMEDAD", 8));
            tabla.addCell(crearCelda("TEMPERATURA", 8));
            tabla.addCell(crearCelda("FECHA Y HORA", 8));
            tabla.addCell(crearCelda("MARCA", 8));
            
            for (Datos dato: listaDatos) {
                tabla.addCell(crearCelda(String.valueOf(dato.getId()), 8));
                tabla.addCell(crearCelda(dato.getIdSensor(), 8));
                tabla.addCell(crearCelda(dato.getTipoSensor(), 8));
                tabla.addCell(crearCelda(String.valueOf(dato.getMedidaHumedad()), 8));
                tabla.addCell(crearCelda(String.valueOf(dato.getMedidaTemperatura()), 8));
                tabla.addCell(crearCelda(dato.getFechaHora().toString(), 8));
                tabla.addCell(crearCelda(dato.getMarcaSensor(), 8));
            }
            
            documento.add(tabla);
            documento.close();
            
         
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    
    private Paragraph crearCelda(String contenido, float tamañoFuente) {
        Paragraph paragraph = new Paragraph(contenido);
        paragraph.getFont().setSize(tamañoFuente);
        return paragraph;
    }
    
}
