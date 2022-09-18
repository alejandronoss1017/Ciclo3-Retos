const CLIENT_URL =
  "https://g22fea38c9b9675-pauce3v7xj8epmdn.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client";

showData();
// GET HTTP method for show all clients
function showData() {
  $.ajax({
    url: CLIENT_URL,
    type: "GET",
    dataType: "json",

    success: function (clients) {
      $("#tableContent").empty();
      for (let index = 0; index < clients.items.length; index++) {
        const element = clients.items[index];
        console.log(element);
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
          "<button onclick= 'updateData(" +
          JSON.stringify(element) +
          ")'" +
          ">Actualizar</button>" +
          "</td><td>" +
          "<button onclick='deleteData(" +
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
function saveData() {
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

// PUT HTTP method for update a client
// TODO: Corregir y pensar el flujo de este mismo, no funciona el paso
// de variables al momento de cambiar ventana
function updateData(data) {
  window.location.assign("../templates/actualizacionClientes.html");
  console.log(data);

  document.getElementById("updateClientID").innerText = data.id;
  let id = document.getElementById("updateClientID");
  let name = document.getElementById("updateClientName");
  let mail = document.getElementById("updateClientMail");
  let edad = document.getElementById("updateClientAge");

  id.value;
}

//DELETE HTTP method for delete a client
function deleteData(id) {
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
      showData();
    },
  });
}
