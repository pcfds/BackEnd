window.addEventListener('load', function () {

     //Al cargar la pagina buscamos y obtenemos el formulario donde estarán
     //los datos que el usuario cargará del nuevo estudiante
    const form = document.querySelector('#add_new_patient');

    //Ante un submit del formulario se ejecutará la siguiente funcion
    form.addEventListener('submit', function (e) {
    e.preventDefault();

        //creamos un JSON que tendrá los datos del nuevo estudiante
        const formData = {
            name: document.querySelector('#name').value,
            surname: document.querySelector('#surname').value,
            email: document.querySelector('#email').value,
            dni: document.querySelector('#dni').value,
            address: { street: document.querySelector('#street').value,
                                 number: document.querySelector('#number').value,
                                  city:  document.querySelector('#city').value,}



        };

        //invocamos utilizando la función fetch la API estudiantes con el método POST
        //que guardará al estudiante que enviaremos en formato JSON
        const url = '/patients/register';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
               //Si no hay ningun error se muestra un mensaje diciendo que el estudiante
               //se agrego bien
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Patient Added Successfully</div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 //se dejan todos los campos vacíos por si se quiere ingresar otro estudiante
                 resetUploadForm();


            })
            .catch(error => {
                 //Si hay algun error se muestra un mensaje diciendo que el estudiante
                 //no se pudo guardar y se intente nuevamente
                  let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                   document.querySelector('#response').innerHTML = errorAlert;
                   document.querySelector('#response').style.display = "block";
                   //se dejan todos los campos vacíos por si se quiere ingresar otro estudiante
                   resetUploadForm();})
    });

    function resetUploadForm(){
        document.querySelector('#name').value = "";
        document.querySelector('#surname').value = "";
        document.querySelector('#dni').value = "";
        document.querySelector('#email').value = "";
         document.querySelector('#street').value = "";
          document.querySelector('#number').value = "";
           document.querySelector('#city').value = "";

    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/listPatient") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});