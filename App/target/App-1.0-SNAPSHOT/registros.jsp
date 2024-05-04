<%@ page import="com.invernadero.fachada.Fachada" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Resgistros Sensores</title>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.5.3/jspdf.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/1.3.2/html2canvas.js"></script>
        <script>
            window.jsPDF = window.jspdf.jsPDF;
        </script>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }

            .container {
                max-width: 800px;
                margin: 20px auto;
                padding: 0 20px;
            }

            h1 {
                text-align: center;
            }

            table {
                width: 100%;
                border-collapse: collapse;
            }

            table, th, td {
                border: 1px solid #ddd;
            }

            th, td {
                padding: 8px;
                text-align: left;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2;
            }

            #btnDescargar {
                position: fixed;
                bottom: 20px;
                right: 20px;
                z-index: 1000;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Visualización de Datos</h1>
            <table id="data-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>ID Sensor</th>
                        <th>Tipo Sensor</th>
                        <th>Humedad</th>
                        <th>Temperatura</th>
                        <th>Fecha y Hora</th>
                        <th>Marca</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Los datos se cargarán aquí dinámicamente -->
                </tbody>
            </table>
            <div class="chart-container">
                <canvas id="humidity-chart"></canvas>
            </div>
            <div class="chart-container">
                <canvas id="temperature-chart"></canvas>
            </div>
            <button class="btnDescargar">Descargar PDF</button>
            <button class="btnDescargarGraficas">Descargar Graficas</button>
        </div>

        <script src="js/scriptRegistros.js"></script>
    </body>
</html>
