window.addEventListener('load', function () {

    //Buscamos y obtenemos el form donde estan
    //los datos que el usuario pudo haber modificado del paciente
    const form = document.querySelector('#update_dentist_form');
    form.addEventListener('submit', function (event) {
        event.preventDefault();
        let patientId = document.querySelector('#dentist_id').value;

        //creamos un JSON que tendrá los datos del paciente
        //a diferencia de un paciente nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo
        const formData = {
            id: document.querySelector('#dentist_id').value,
            name: document.querySelector('#name').value,
            surname: document.querySelector('#surname').value,
            register: document.querySelector('#register').value,

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
          const url = '/dentists/' +id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let patient = data;
              document.querySelector('#dentist_id').value = dentist.id;
              document.querySelector('#name').value = dentist.name;
              document.querySelector('#surname').value = dentist.surname;
             document.querySelector('#register').value = dentist.register;




            //el form por default esta oculto y al editar se habilita
          }).catch(error => {
          document.querySelector('#div_dentist_updating');

              console.log(error);
          });



      }