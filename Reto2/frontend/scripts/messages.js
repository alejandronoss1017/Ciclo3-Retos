const MESSAGE_URL =
  "https://g22fea38c9b9675-pauce3v7xj8epmdn.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/message/message";

showMessageData();

function showMessageData() {
  $.ajax({
    url: MESSAGE_URL,
    type: "GET",
    dataType: "json",

    success: function (message) {
      $("#tableContentMessage").empty();
      for (let index = 0; index < message.items.length; index++) {
        const element = message.items[index];
        let tr =
          "<tr><td>" +
          element.id +
          "</td><td>" +
          element.messagetext +
          "</td><td>" +
          "<button onclick= 'updateData(" +
          JSON.stringify(element) +
          ")'" +
          ">Actualizar</button>" +
          "</td><td>" +
          "<button onclick='deleteMessageData(" +
          element.id +
          ")'>Eliminar</button>" +
          "</td></tr>";

        $("#tableContentMessage").append(tr);
      }
    },
  });
}

function saveMessageData() {
  let id = $("#idMessage").val();
  let text = $("#textMessage").val();

  let newData = {
    id: id,
    messagetext: text,
  };

  $.ajax({
    url: MESSAGE_URL,
    type: "POST",
    data: JSON.stringify(newData),
    contentType: "application/json",

    success: function (message) {
      $("#idMessage").val("");
      $("#textMessage").val("");
      alert("Mensaje Guardado");
    },
    error: function (xhr, status) {
      alert("Ha ocurrido un problema" + status);
    },
    complete: function (xhr, status) {
      window.location.assign("../index.html");
    },
  });
}


function updateMessageData() {}

function deleteMessageData(id) {
  let data = {
    id: id,
  };

  $.ajax({
    url: MESSAGE_URL,
    type: "DELETE",
    data: JSON.stringify(data),
    contentType: "application/json",

    success: function (message) {},
    error: function (xhr, status) {
      alert("Ha sucedido un problema" + status);
    },
    complete: function () {
      showMessageData();
    },
  });
}
