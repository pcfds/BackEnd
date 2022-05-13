window.addEventListener('load', function () {

    //Buscamos y obtenemos el form donde estan
    //los datos que el usuario pudo haber modificado del paciente
    const form = document.querySelector('#update_patient_form');
    form.addEventListener('submit', function (event) {
        event.preventDefault();
        let patientId = document.querySelector('#patient_id').value;

        //creamos un JSON que tendrá los datos del paciente
        //a diferencia de un paciente nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo
        const formData = {
            id: document.querySelector('#patient_id').value,
            name: document.querySelector('#name').value,
            surname: document.querySelector('#surname').value,
            email: document.querySelector('#email').value,
            dni: document.querySelector('#dni').value,
            address: {
            street: document.querySelector('#street').value,
            number: document.querySelector('#number').value,
            city:   document.querySelector('#city').value
            }

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


        fetch('/patients/update', settings)
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
          const url = '/patients/' +id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let patient = data;
              document.querySelector('#patient_id').value = patient.id;
              document.querySelector('#name').value = patient.name;
              document.querySelector('#surname').value = patient.surname;
             document.querySelector('#email').value = patient.email;
             document.querySelector('#dni').value = patient.dni;
             document.querySelector('#street').value = patient.address.street;
             document.querySelector('#number').value = patient.address.number;
             document.querySelector('#city').value = patient.address.city;



            //el form por default esta oculto y al editar se habilita
          }).catch(error => {
          document.querySelector('#div_patient_updating');

              console.log(error);
          });



      }