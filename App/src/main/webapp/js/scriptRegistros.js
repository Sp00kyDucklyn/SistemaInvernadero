document.addEventListener("DOMContentLoaded", function () {
    function obtenerDatosSensores() {
        return fetch('http://localhost:8080/App/ObtenerDatos')
                .then(response => response.json())
                .then(data => {
                    renderizarDatos(data);
                    renderizarGraficas(data);
                })
                .catch(error => console.error('Error al obtener datos del backend:', error));
    }

    function renderizarDatos(data) {
        const tableBody = document.querySelector('#data-table tbody');
        tableBody.innerHTML = '';//Sirve para limpiar la tabla
        data.forEach(row => {
            console.log(row.id);
            const newRow = document.createElement('tr');
            newRow.innerHTML = `
                <td>${row.id}</td>
                <td>${row.idSensor}</td>
                <td>${row.tipoSensor}</td>
                <td>${row.medidaHumedad}</td>
                <td>${row.medidaTemperatura}</td>
                <td>${row.fechaHora}</td>
                <td>${row.marcaSensor}</td>
            `;
            tableBody.appendChild(newRow);
        });
    }

    function renderizarGraficas(data) {

        const humidityData = data.map(item => ({x: item.id, y: item.medidaHumedad}));
        const temperatureData = data.map(item => ({x: item.id, y: item.medidaTemperatura}));
        const humidityCtx = document.getElementById('humidity-chart').getContext('2d');
        const humidityChart = new Chart(humidityCtx, {
            type: 'line',
            data: {
                datasets: [{
                        label: 'Humedad',
                        data: humidityData,
                        backgroundColor: 'rgba(0, 0, 255, 0.2)',
                        borderColor: 'blue',
                        borderWidth: 1
                    }]
            },
            options: {
                scales: {
                    x: {
                        type: 'linear',
                        position: 'bottom'
                    },
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });

        const temperatureCtx = document.getElementById('temperature-chart').getContext('2d');
        const temperatureChart = new Chart(temperatureCtx, {
            type: 'line',
            data: {
                datasets: [{
                        label: 'Temperatura',
                        data: temperatureData,
                        backgroundColor: 'rgba(205, 92, 92, 0.2)',
                        borderColor: 'red',
                        borderWidth: 1
                    }]
            },
            options: {
                scales: {
                    x: {
                        type: 'linear',
                        position: 'bottom'
                    },
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    }

    //Se llama la funcion para obtener los datos de los sensores.
    obtenerDatosSensores();

    function descargarPDF() {
        // Crear un objeto PDF
        const pdf = new jsPDF();

        // Agregar título al PDF
        pdf.text("Datos de Sensores", 10, 10);

        // Agregar tabla al PDF
        const table = document.getElementById('data-table');
        pdf.autoTable({html: table});

        // Agregar gráficas al PDF
        const humidityCanvas = document.getElementById('humidity-chart');
        const temperatureCanvas = document.getElementById('temperature-chart');
        const humidityDataURL = humidityCanvas.toDataURL();
        const temperatureDataURL = temperatureCanvas.toDataURL();
        pdf.addImage(humidityDataURL, 'PNG', 10, 80, 100, 50);
        pdf.addImage(temperatureDataURL, 'PNG', 120, 80, 100, 50);

        // Guardar el PDF
        pdf.save("/Recursos/datos_sensores.pdf");
    }

    // Manejar el evento de clic en el botón de descarga de PDF
    const downloadPDFButton = document.getElementById('download-pdf-button');
    downloadPDFButton.addEventListener('click', downloadPDF);
});


