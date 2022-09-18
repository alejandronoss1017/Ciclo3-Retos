const CLIENT_URL =
  "https://g22fea38c9b9675-pauce3v7xj8epmdn.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client";

// GET HTTP method for Jquery
function showData() {
  $.ajax({
    url: CLIENT_URL,
    type: "GET",
    dataType: "json",

    success: function (clients) {
      for (let index = 0; index < clients.items.length; index++) {
        const element = clients.items[index];
        console.log(element);
      }
    },

    error: function (xhr, status) {
      alert("Ha sucedido un error!" + status);
    },
  });
}

//Metodo POST
function saveData(params) {
  let id = $("#idCliente").val();
  let nombre = $("#nombreCliente").val();
  let mail = $("#mailCLiente").val();
  let edad = $("#edadCliente").val();

  let data = {
    id: idCliente,
    name: nombre,
    email: mailCliente,
    age: edad,
  };

  let dataToSend = JSON.stringify(data);
  console.log(dataToSend);

  $.ajax({
    url: "https://g22fea38c9b9675-pauce3v7xj8epmdn.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client",
    type: "POST",
    dataType: "json",
    data: dataToSend,
    contentType: "application/json",

    complete: function (client) {
      $("#idCliente").val("");
      $("#nombreCliente").val("");
      $("#mailCLiente").val("");
      $("#edadCliente").val("");
    },
    error: function (xhr, status) {
      alert("Ha sucedido un error!");
    },
  });
}

function editarCliente() {
  let id = $("#idCliente").val();
  let nombre = $("#nombreCliente").val();
  let mail = $("#mailCLiente").val();
  let edad = $("#edadCliente").val();

  let data = {
    id: idCliente,
    name: nombre,
    email: mailCliente,
    age: edad,
  };

  let dataToSend = JSON.stringify(data);
  console.log(dataToSend);

  $.ajax({
    url: "https://g22fea38c9b9675-pauce3v7xj8epmdn.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client",
    type: "PUT",
    dataType: "json",
    data: dataToSend,
    contentType: "application/json",

    complete: function (client) {
      $("#idCliente").val("");
      $("#nombreCliente").val("");
      $("#mailCLiente").val("");
      $("#edadCliente").val("");
    },
    error: function (xhr, status) {
      alert("Ha sucedido un error!");
    },
  });
}

function borrarCliente(idCliente) {
  let data = {
    id: idCliente,
  };

  let dataToSend = JSON.stringify(data);
  console.log(dataToSend);

  $.ajax({
    url: "https://g22fea38c9b9675-pauce3v7xj8epmdn.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/client/client",
    type: "DELETE",
    dataType: "json",
    data: dataToSend,
    contentType: "application/json",

    complete: function (client) {
      $("#idCliente").val("");
      $("#nombreCliente").val("");
      $("#mailCLiente").val("");
      $("#edadCliente").val("");
    },
    error: function (xhr, status) {
      alert("Ha sucedido un error!");
    },
  });
}
