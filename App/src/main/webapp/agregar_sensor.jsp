<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entidades.Invernadero" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="Controlador.ControladorInvernadero"%>
<!DOCTYPE html>
<%
    HttpSession objSesion = request.getSession(false);
%>
<%
    ControladorInvernadero cc = new ControladorInvernadero();
%>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Agregar Sensor</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-color: #f4f4f4;
    }

    form {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
      font-family: Arial, sans-serif;
      font-size: 24px;
      color: #333; /* Color de texto */
      margin-bottom: 20px;
    }

    label {
      font-size: 16px;
      margin-bottom: 10px;
    }

    input[type="text"],
    input[type="number"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 20px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    select {
      width: 100%;
      padding: 10px;
      margin-bottom: 20px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    button {
      padding: 10px 20px;
      background-color: #007bff;
      color: #fff;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
    button:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
  <form action="agregarSensor" method="post">
    <h2>Agregar Sensors</h2>
    <label for="clave_sensor">Clave del Sensor:</label>
    <input type="text" id="clave_sensor" name="clave_sensor" required>
    <label for="marca">Marca:</label>
    <input type="text" id="marca" name="marca" required>
    <label for="invernadero_id">Invernadero:</label>
    <select id="invernadero_id" name="invernadero_id" required>
           <%= cc.getOpcionesInvernaderos()%>
    </select>
    <button type="submit">Agregar Sensor</button>
  </form>
</body>
</html>