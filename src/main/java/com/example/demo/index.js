/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


var app = {
    // Application Constructor
    initialize: function() {
        this.bindEvents();
    },
    // Bind Event Listeners
    //
    // Bind any events that are required on startup. Common events are:
    // 'load', 'deviceready', 'offline', and 'online'.
    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
    },
    // deviceready Event Handler
    //
    // The scope of 'this' is the event. In order to call the 'receivedEvent'
    // function, we must explicitly call 'app.receivedEvent(...);'
    onDeviceReady: function() {
        app.receivedEvent('deviceready');
    },
    // Update DOM on a Received Event
    receivedEvent: function(id) {
        var parentElement = document.getElementById(id);
        var listeningElement = parentElement.querySelector('.listening');
        var receivedElement = parentElement.querySelector('.received');

        listeningElement.setAttribute('style', 'display:none;');
        receivedElement.setAttribute('style', 'display:block;');

        console.log('Received Event: ' + id);
    }
};
var ultimoMensaje=0;
var idUser=-1
window.localStorage.setItem("idChat",1)
document.addEventListener("deviceready", function(){
    mostrarMensaje();
    var chatDaemon = setInterval(mostrarMensaje, 5000);
});
function validarLogin() {
    let usuario =document.getElementById('userl').value
    let pass = document.getElementById('userpl').value
    let valido = 0
    $.ajax({
    method:'GET',
    url: "https://apesapi.herokuapp.com/v1/usuario/obtenerTodo",
    dataType: 'json',
    success: function(results){
        console.log(results);
        if(results.length == 0 ){
            $('#errorlogin').html('<div class="alert alert-danger"><strong>Error! </strong> Usuario no existe</div>');
        }
        results.forEach(element => {
            if(element['nombre']==usuario && element['pass']==pass){
                idUser=element['id']
                window.localStorage.setItem("token", idUser)
                valido=1
                console.log(idUser)
            }

        if(valido==1)document.location.href='/menu.html'
        else{
            //var errorlogin=document.getElementById('errorlogin')
            //errorlogin.textContent="La contraseña no es correcta. Revísala"
            //errorlogin.style.color = 'red'
            //errorlogin.style.backgroundColor= 'blue'
            $('#errorlogin').html('<div class="alert alert-danger"><strong>Error! </strong> Nombre o contraseña equivocado</div>');
        }
        });
    }
    });
}
function mostrarMensaje(){
    console.log("entre a mostrar mensaje")
    $(document).ready(function() {
        $.ajax({				
            type: "GET",
            url: "https://apesapi.herokuapp.com/v1/mensaje/"+parseInt(window.localStorage.getItem("idChat"),10).toString()+"/"+ultimoMensaje.toString(),
            success: function(respuesta) {
                console.log("entre a mgdsgddaje")
                if(respuesta.length > 0)
                    ultimoMensaje = respuesta[respuesta.length - 1].id;
    
                for (var i = respuesta.length - 1; i >= 0; i--) {
                    if(respuesta[i].emisor == 0) {
                        $("#chatbox").append('<div class= "float-left" > Tu: '+respuesta[i].mensajee+'</div>');
                    } else {
                        $("#chatbox").append('<div class= "float-right" > Técnico: '+respuesta[i].mensajee+'</div>');
                    }
                }
            },
            error: function() {
                console.log("mostrar mensaje fallo");
            }
        });
    });
}
function guardarEstrella(num){
    window.localStorage.setItem("estrella", num)
}
function guardarCalificacion(){
    console.log("xd")
    console.log(parseInt(window.localStorage.getItem("idChat"),10))
    $.ajax({				
        type: "GET",
        url: "https://apesapi.herokuapp.com/v1/chat/obtener?id="+parseInt(window.localStorage.getItem("idChat"),10),
        success: function(data) {
            $.ajax({
                type:"POST",
                url: "https://apesapi.herokuapp.com/v1/feedback/agregar",
                contentType: 'application/json',
                data: JSON.stringify({
                "idUsuariof": parseInt(window.localStorage.getItem("token"),10),
                "idConsultaf":data.idConsulta,
                "idTecnicof":data.idTecnico,
                "comentario":$("#feedback").val(),
                "rating":parseInt(window.localStorage.getItem("estrella"),10)
                
            }),
                dataType: "JSON",
                success: function () {
                    console.log("calificacion guardada con exito")
        
                }
            });
        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
    });
    //get v1/chat/obtener?id=IDDELCHAT

    
}
function calificarServicio(){
    document.location.href="/calificar.html"
}
function subirMensaje(){    
    console.log("entreeeeeeeeeeeeeee")
    //var mensaje= $("#usermsg").val()
    $.ajax({
        type:"POST",
        url: "https://apesapi.herokuapp.com/v1/mensaje/subir",
        contentType: 'application/json',
        data: JSON.stringify({
        "mensajee": $("#usermsg").val(),
        "idChat": 1,
        "emisor": 0
    }),
        dataType: "JSON",
        success: function(){
            console.log("mensaje subido con exito")
        },
        failure: function(e) {
            console.log(e);
        }
    });
    

}
function chat(idConsulta){
    var idChat 
    console.log("AAAAAAAAAAAAAAAAAAAAAAAAAA")
    console.log(idConsulta)
    
    $.ajax({				
        type: "GET",
        url: "https://apesapi.herokuapp.com/v1/chat/obtenerPorConsulta?id="+idConsulta,
        success: function(data) {
            idChat=data.id
            window.localStorage.setItem("idChat", idChat)
            console.log(parseInt(window.localStorage.getItem("idChat"),10))
            document.location.href="/chat.html"
            mostrarMensaje(idChat);

        },
        error: function() {
            console.log("No se ha podido obtener la información");
        }
    });


}
function mostrarConsultas(){
    var contador=1
    console.log("edfgdsfg")
    $(document).ready(function() {
        $.ajax({				
            type: "GET",
            url: "https://apesapi.herokuapp.com/v1/consulta/obtenerTodo",
            success: function(data) {
                console.log("consulta");
                $('#consultasUsuario').html('<div class="card text-white mt-1 bg-dark">Aqui se muestran las consultas que has hecho: </div>');
                
                for (let i = 0; i < data.length; i++){    
                    if(parseInt(window.localStorage.getItem("token"),10) == data[i].idUsuario){
                        if(data[i].estado == 'None'){
                            $("#consultasUsuario").append('<div id="consultasUsuario"> <div class="card text-white mt-1 bg-dark"><div class="card-body"><div class="row"><div class="col-sm-2"><img src="./imagenes/gris.jpg" alt="" class="rounded-circle" style="height: 10px;width: 10px;"></div><div class="col"></div><div class="col-sm-3"><p class="font-weight-bold" style="color: grey;">Sin aceptar</p></div></div><div class="row"><div class="col-sm-9">Consulta '+(contador)+'</div> <div class="col-sm-9">Título: '+data[i].titulo+'</div><div class="col-sm-9">Categoria: '+data[i].categoria+'</div><div class="col-sm-9">Descripción de la consulta: '+data[i].descripcion+'</div><div class="col-sm-3"></div></div><div class="row"><div class="col"><blockquote class="blockquote mb-0"><footer class="blockquote-footer">Fecha: '+data[i].fecha+'</footer></blockquote></div></div></div></div></div>');
                        } 
                        if(data[i].estado == 'aceptada'){
                            $("#consultasUsuario").append('<div id="consultasUsuario"> <div class="card text-white mt-1 bg-dark"><div class="card-body"><div class="row"><div class="col-sm-2"><img src="./imagenes/ama.jpg" alt="" class="rounded-circle" style="height: 10px;width: 10px;"></div><div class="col"></div><div class="col-sm-3"><p class="font-weight-bold" style="color: yellow;">En proceso</p></div><div class="col-sm-3"><button type="button" class="btn btn-success" onclick="chat('+data[i].id+')">Ir al chat</button></div></div>  <div class="row"><div class="col-sm-9">Consulta '+(contador)+'</div><div class="col-sm-9">Título: '+data[i].titulo+'</div> </div><div class="col-sm-9">Categoria: '+data[i].categoria+'</div><div class="col-sm-9">Descripción de la consulta: '+data[i].descripcion+'</div><div class="col-sm-3"></div></div><div class="row"><div class="col"><blockquote class="blockquote mb-0"><footer class="blockquote-footer">Fecha: '+data[i].fecha+'</footer></blockquote></div></div></div></div></div>');
                        }    
                        if(data[i].estado == 'lista'){
                            $("#consultasUsuario").append('<div id="consultasUsuario"> <div class="card text-white mt-1 bg-dark"><div class="card-body"><div class="row"><div class="col-sm-2"><img src="./imagenes/verde.jpg" alt="" class="rounded-circle" style="height: 10px;width: 10px;"></div><div class="col"></div><div class="col-sm-3"><p class="font-weight-bold" style="color: green;">Solucionada</p></div></div><div class="row"><div class="col-sm-9">Consulta '+(contador)+'</div><div class="col-sm-9">Título: '+data[i].titulo+'</div></div><div class="col-sm-9">Categoria: '+data[i].categoria+'</div> <div class="col-sm-9">Descripción de la consulta: '+data[i].descripcion+'</div><div class="col-sm-3"></div></div><div class="row"><div class="col"><blockquote class="blockquote mb-0"><footer class="blockquote-footer">Fecha: '+data[i].fecha+'</footer></blockquote></div></div></div></div></div>');
                        }
                    contador++
                    } 
                }
            },
            failure: function() {
                console.log("No se ha podido obtener la información");
            }
        });
});
}
function irMenu(){
    console.log("entre a ir menu")
    window.history.go(-2);
    $(document).ready(mostrarConsultas())
}
function registrar(){

    let usuario=document.getElementById('userr').value
    let correo=document.getElementById('email').value
    let pass= document.getElementById('userp').value
    let valido= 1

    var patron=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
    if(email.value.match(patron)){
        $.ajax({
            method:'GET',
            url: "https://apesapi.herokuapp.com/v1/usuario/obtenerTodo",
            dataType: 'json',
            success: function(results){
                results.forEach(element => {
                    console.log(element['nombre'])
                    console.log(usuario)
                    if(element['nombre'] == usuario || element['correo'] == correo){
                        valido=0
                    }
                });
                if(valido == 1){
                    $.ajax({
                        type:"POST",
                        url: "https://apesapi.herokuapp.com/v1/usuario/agregar",
                        contentType: 'application/json',
                        data: JSON.stringify({
                        "nombre": usuario,
                        "correo": correo,
                        "pass": pass,
                    }),
                        dataType: "JSON",
                        success: function(){
                            $('#errorr').html('<div class="alert alert-success"><strong>Felicidades! </strong> Te has registrado con exito!</div>');
                            cambiarLogin()
                        }
                    });

                }
                else{
                    $('#errorr').html('<div class="alert alert-danger"><strong>Error: </strong> Nombre o correo ya utilizado</div>');


                }
            }
        });
    }else{
        $('#errorr').html('<div class="alert alert-danger"><strong>Error: </strong> Ingrese un email válido</div>');
    }



}
function cambiarLogin(){
    document.location.href="/index.html";
    $('#errorlogin').html('<div class="alert alert-success"><strong>Felicidades! </strong> Te has registrado con exito!</div>');
}
function cambiar(){
    document.location.href="/consultas.html"
}

function subirConsulta(){
    console.log("SIIIIIIIIIII")
    let titulo=document.getElementById('nombrec').value
    let categoria=document.getElementById('categoriac').value
    let descripcion= document.getElementById('descripcionc').value
    var d = new Date();
    idUser=parseInt(window.localStorage.getItem("token"),10)
    $.ajax({
        type:"POST",
        url: "https://apesapi.herokuapp.com/v1/consulta/agregar",
        contentType: 'application/json',
        data: JSON.stringify({
        "titulo": titulo,
        "categoria": categoria,
        "descripcion": descripcion,
        "idUsuario": idUser,
        "estado": "None",
        "fecha":d.getDate() + "/" + d.getMonth() + "/"+ d.getFullYear(),
    }),
        dataType: "JSON",
        success: function () {
            $('#exito').html('<div class="alert alert-success"><strong>Felicidades! </strong> Consulta enviada con éxito!</div>');

        }
    });

}
