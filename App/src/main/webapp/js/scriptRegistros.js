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
        tableBody.innerHTML = ''; //Sirve para limpiar la tabla
        data.forEach(row => {
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

    //Funcion que permite descargar un archivo pdf con los datos de los sensores.
    function descargarTablaComoPDF() {

        const tabla = document.getElementById('data-table');
        html2canvas(tabla).then(canvas => {
            const pdf = new jsPDF('p', 'pt', 'letter');
            const imgData = canvas.toDataURL('image/png');
            const imgWidth = pdf.internal.pageSize.getWidth();
            const imgHeight = (canvas.height * imgWidth) / canvas.width;
            pdf.addImage(imgData, 'PNG', 0, 0, imgWidth, imgHeight);

            pdf.save("tabla_datos.pdf");
        });
    }
    const btnDescargarPDF = document.querySelector('.btnDescargar');
    btnDescargarPDF.addEventListener('click', descargarTablaComoPDF);

    //Funcion que permite descargar un archivo pdf con las graficas.
    function descargarGraficasComoPDF() {
        const humidityChartCanvas = document.getElementById('humidity-chart');
        const temperatureChartCanvas = document.getElementById('temperature-chart');

        Promise.all([
            html2canvas(humidityChartCanvas),
            html2canvas(temperatureChartCanvas)
        ]).then(([humidityChartCanvas, temperatureChartCanvas]) => {
            const pdf = new jsPDF('p', 'pt', 'letter');
            const imgWidth = pdf.internal.pageSize.getWidth();
            const imgHeight = imgWidth * 0.75;
            const humidityChartImgData = humidityChartCanvas.toDataURL('image/png');
            pdf.addImage(humidityChartImgData, 'PNG', 40, 40, imgWidth - 80, imgHeight - 150);
            const temperatureChartImgData = temperatureChartCanvas.toDataURL('image/png');
            pdf.addPage();
            pdf.addImage(temperatureChartImgData, 'PNG', 40, 40, imgWidth - 80, imgHeight - 150);
            pdf.save("graficas_datos.pdf");
        });
    }

    const btnDescargarGraficas = document.querySelector('.btnDescargarGraficas');
    btnDescargarGraficas.addEventListener('click', descargarGraficasComoPDF);

});

