const AUDIENCE_URL =
  "https://g22fea38c9b9675-pauce3v7xj8epmdn.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/audience/audience";

showAudienceData();

function showAudienceData() {
  $.ajax({
    url: AUDIENCE_URL,
    type: "GET",
    dataType: "json",

    success: function (audience) {
      $("#tableContentAudience").empty();
      for (let index = 0; index < audience.items.length; index++) {
        const element = audience.items[index];
        let tr =
          "<tr><td>" +
          element.id +
          "</td><td>" +
          element.owner +
          "</td><td>" +
          element.capacity +
          "</td><td>" +
          element.category_id +
          "</td><td>" +
          element.name +
          "</td><td>" +
          "<button onclick= 'updateData(" +
          JSON.stringify(element) +
          ")'" +
          ">Actualizar</button>" +
          "</td><td>" +
          "<button onclick='deleteAudienceData(" +
          element.id +
          ")'>Eliminar</button>" +
          "</td></tr>";

        $("#tableContentAudience").append(tr);
      }
    },

    error: function (xhr, status) {
      alert("Ha sucedido un error!" + status);
    },
  });
}

function saveAudienceData() {
  let id = $("#idAudience").val();
  let owner = $("#ownerAudience").val();
  let capacity = $("#capacityAudience").val();
  let category_id = $("#categoryIdAudience").val();
  let name = $("#nameAudience").val();

  let newData = {
    id: id,
    owner: owner,
    capacity: capacity,
    category_id: category_id,
    name: name,
  };

  $.ajax({
    url: AUDIENCE_URL,
    type: "POST",
    data: JSON.stringify(newData),
    contentType: "application/json",

    success: function (client) {
      $("#idAudience").val("");
      $("#ownerAudience").val("");
      $("#capacityAudience").val("");
      $("#categoryIdAudience").val("");
      $("#nameAudience").val("");
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

// TODO: Lo mismo que en cliente, pensar el flujo y logica de como realizarlo
function updateAudienceData() {}

function deleteAudienceData(id) {
  let data = {
    id: id,
  };

  $.ajax({
    url: AUDIENCE_URL,
    type: "DELETE",
    data: JSON.stringify(data),
    contentType: "application/json",
    success: function (audience) {
      $("#idCliente").val("");
      $("#nombreCliente").val("");
      $("#mailCliente").val("");
      $("#edadCliente").val("");
    },
    error: function (xhr, status) {
      alert("ha sucedido un problema");
    },
    complete: function () {
      showAudienceData();
    },
  });
}
