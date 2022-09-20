const CLIENT_URL =
  "https://g22fea38c9b9675-pauce3v7xj8epmdn.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client";

showClientsData();
// GET HTTP method for show all clients

function showClientsData() {
  $.ajax({
    url: CLIENT_URL,
    type: "GET",
    dataType: "json",

    success: function (clients) {
      $("#tableContent").empty();
      for (let index = 0; index < clients.items.length; index++) {
        const element = clients.items[index];
        let tr =
          "<tr><td>" +
          element.id +
          "</td><td>" +
          element.name +
          "</td><td>" +
          element.email +
          "</td><td>" +
          element.age +
          "</td><td>" +
          "<button onclick= 'putDataInputs(" +
          JSON.stringify(element) +
          ")'" +
          ">Actualizar</button>" +
          "</td><td>" +
          "<button onclick='deleteClientsData(" +
          element.id +
          ")'>Eliminar</button>" +
          "</td></tr>";

        $("#tableContent").append(tr);
      }
    },

    error: function (xhr, status) {
      alert("Ha sucedido un error!" + status);
    },
  });
}

// POST HTTP method for insert a new client
function saveClientsData() {
  let id = $("#idClient").val();
  let name = $("#nameClient").val();
  let mail = $("#mailClient").val();
  let age = $("#ageClient").val();

  let newData = {
    id: id,
    name: name,
    email: mail,
    age: age,
  };

  $.ajax({
    url: CLIENT_URL,
    type: "POST",
    data: JSON.stringify(newData),
    contentType: "application/json",

    success: function (client) {
      $("#idClient").val("");
      $("#nameClient").val("");
      $("#mailClient").val("");
      $("#ageClient").val("");
      alert("Cliente Guardado");
    },
    error: function (xhr, status) {
      alert("Ha ocurrido un problema" + status);
    },
    complete: function (xhr, status) {
      window.location.assign("../index.html");
    },
  });
}

function putDataInputs(data) {
  $("#updateClientID").val(data.id);
  $("#updateClientName").val(data.name);
  $("#updateClientMail").val(data.email);
  $("#updateClientAge").val(data.age);
}
// PUT HTTP method for update a client
// TODO: Corregir y pensar el flujo de este mismo, no funciona el paso
// de variables al momento de cambiar ventana
function updateClientsData(data) {
  console.log(data);
  let id = $("#updateClientID").val();
  let name = $("#updateClientName").val();
  let email = $("#updateClientMail").val();
  let age = $("#updateClientAge").val();
  
  let newData = {
    id: id,
    name: name,
    email: email,
    age: age,
  };

  $.ajax({
    url: CLIENT_URL,
    type: "PUT",
    data: JSON.stringify(newData),
    contentType: "application/json",

    success: function (client) {
      alert("Cliente Guardado");
    },
    error: function (xhr, status) {
      alert("Ha ocurrido un problema" + status);
    },
    complete: function (xhr, status) {
      $("#idClient").val("");
      $("#nameClient").val("");
      $("#mailClient").val("");
      $("#ageClient").val("");
      showClientsData();
    },
  });
}

//DELETE HTTP method for delete a client
function deleteClientsData(id) {
  let data = {
    id: id,
  };

  $.ajax({
    url: CLIENT_URL,
    type: "DELETE",
    data: JSON.stringify(data),
    contentType: "application/json",
    success: function (client) {
      $("#idCliente").val("");
      $("#nombreCliente").val("");
      $("#mailCliente").val("");
      $("#edadCliente").val("");
    },
    error: function (xhr, status) {
      alert("ha sucedido un problema");
    },
    complete: function () {
      showClientsData();
    },
  });
}
