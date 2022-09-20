const MESSAGE_URL =
  "https://g22fea38c9b9675-pauce3v7xj8epmdn.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/message/message";

showMessageData();

// GET HTTP method for show all messages
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
          "<button onclick= 'putDataInputsMessage(" +
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

// POST HTTP method for insert a new message
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

//Set actual data in inputs to be modified
function putDataInputsMessage(data) {
  let row = `<label for="id">Id: </label>
    <input type="number" id="updateMessageID" />
    <label for="name">Mensaje: </label>
        <textarea id="updateMessageText" cols="30" rows="1"></textarea>
        <input type="submit" onclick="updateMessageData()" value="Confirmar" />`;
  $("#updateMessage").append(row);
  $("#updateMessageID").val(data.id);
  $("#updateMessageText").val(data.messagetext);
}

// PUT HTTP method for update a message
function updateMessageData() {
  let id = $("#updateMessageID").val();
  let text = $("#updateMessageText").val();

  let newData = {
    id: id,
    messagetext: text,
  };

  $.ajax({
    url: MESSAGE_URL,
    type: "PUT",
    data: JSON.stringify(newData),
    contentType: "application/json",

    success: function (message) {
      alert("Mensaje Actualizado");
    },
    error: function (xhr, status) {
      alert("Ha ocurrido un problema" + status);
    },
    complete: function (xhr, status) {
      $("#updateMessage").empty();
      showMessageData();
    },
  });
}

// DELETE HTTP method for delete a message
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
