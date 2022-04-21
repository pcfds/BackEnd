window.addEventListener('load', function () {

    //Buscamos y obtenemos el form donde estan
    //los datos que el usuario pudo haber modificado del paciente
    const form = document.querySelector('#update_appointment_form');
    form.addEventListener('submit', function (event) {
        event.preventDefault();
        let patientId = document.querySelector('#appointment_id').value;

        //creamos un JSON que tendrá los datos del paciente
        //a diferencia de un paciente nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo
        const formData = {
            id: document.querySelector('#appointment_id).value,
            patient: document.querySelector('#patient').value,
            dentist: document.querySelector('#dentist').value,
            date: document.querySelector('#date').value,
            time: document.querySelector('#time').value,


        };

        //invocamos utilizando la función fetch la API pacientes con el método PUT
        //que modificará al paciente que enviaremos en formato JSON

       const settings = {
                    method: "PUT",
                    headers: {
                        "Content-Type": "application/json",
                    },
                    body: JSON.stringify(formData),
                };


        fetch('/dentists/update', settings)
          .then((response) => response.json())
          .then((result) => {
            console.log(result);
          })
          .catch((error) => {
            console.error("error", error);
          });

          location.reload();

    })
 })

    //Es la funcion que se invoca cuando se hace click sobre el id de un paciente del listado
    //se encarga de llenar el form con los datos del paciente
    //que se desea modificar
    function findBy(id) {
          const url = '/appointments/' +id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let patient = data;
              document.querySelector('#appointment_id').value = appointment.id;
              document.querySelector('#patient').value = appointment.patient.id;
              document.querySelector('#dentist').value = appointment.dentist.id;
              document.querySelector('#date').value = appointment.date;
              document.querySelector('#time').value = appointment.time;




            //el form por default esta oculto y al editar se habilita
          }).catch(error => {
          document.querySelector('#div_appointment_updating');

              console.log(error);
          });



      }