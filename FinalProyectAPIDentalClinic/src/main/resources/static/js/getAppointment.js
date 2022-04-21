window.addEventListener('load', function () {

    (function(){
      //con fetch invocamos a la API de pacientes con el método GET
      //nos devolverá un JSON con una colección de pacientes
      const url = '/appointments/lists';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
         //recorremos la colección de pacientess del JSON
         for(appointment of data){

          //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos
          //el pacientes

          var table = document.getElementById("appointments");
          var appointmentRow =table.insertRow();
          let tr_id = 'tr_' + appointment.id;
          appointmentRow.id = tr_id;


          //por cada paciente creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
          //dicho boton invocara a la funcion de java script deleteByKey que se encargará
          //de llamar a la API para eliminar al paciente
           let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + appointment.id + '\"' +
                                      ' type="button" onclick="deleteBy('+appointment.id+')" class="btn btn-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

           //por cada pacientes creamos un boton que muestra el id y que al hacerle clic invocará
           //a la función de java script findBy que se encargará de buscar al pacientes que queremos
           //modificar y mostrar los datos del mismo en un formulario.
          let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + appointment.id + '\"' +
                                      ' type="button" onclick="findBy('+appointment.id+')" class="btn btn-info btn_id">' +
                                      appointment.id +
                                      '</button>';


          //armamos cada columna de la fila
          //como primer columna pondremos el boton modificar
          //luego los datos del pacientes
          //como ultima columna el boton eliminar
         patientRow.innerHTML = '<td>' + updateButton + '</td>' +
                              '<td class=\"td_patient_id\">' + appointment.patient.getid() + '</td>' +
                              '<td class=\"td_dentist_id\">' + appointment.dentist.getid() + '</td>' +
                              '<td class=\"td_date\">' + appointment.date + '</td>' +
                              '<td class=\"td_time\">' + appointment.time + '</td>' +


                              '<td>' + deleteButton + '</td>';

        };

})
})

(function(){
  let pathname = window.location.pathname;
  if (pathname == "/listAppointment.html") {
      document.querySelector(".nav .nav-item a:last").addClass("active");
  }
})


})