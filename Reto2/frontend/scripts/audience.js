const AUDIENCE_URL =
  "https://g22fea38c9b9675-pauce3v7xj8epmdn.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/audience/audience";

showAudienceData();

// GET HTTTP method for show all audiences
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
          "<button onclick= 'putDataInputsAudience(" +
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

// POST HTTP method for insert a new audience
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

    success: function (audience) {
      $("#idAudience").val("");
      $("#ownerAudience").val("");
      $("#capacityAudience").val("");
      $("#categoryIdAudience").val("");
      $("#nameAudience").val("");
      alert("Auditorio guardado");
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
function putDataInputsAudience(data) {
  let row = `<label for="id">Id: </label>
        <input type="number" id="updateAudienceID" />
        <label for="name">Dueño: </label>
        <input type="text" id="updateAudienceOwner" />
        <label for="mail">Capacidad: </label>
        <input type="text" id="updateAudienceCapacity" />
        <label for="age">Categoria: </label>
        <input type="number" id="updateAudienceCategory" />
        <label for="age">Nombre: </label>
        <input type="text" id="updateAudienceName" />
        <input type="submit" onclick="updateAudienceData()" value="Confirmar" />`;
  $("#updateAudience").append(row);
  $("#updateAudienceID").val(data.id);
  $("#updateAudienceOwner").val(data.owner);
  $("#updateAudienceCapacity").val(data.capacity);
  $("#updateAudienceCategory").val(data.category_id);
  $("#updateAudienceName").val(data.name);
}

//PUT HTTP method for update an audience
function updateAudienceData() {
  let id = $("#updateAudienceID").val();
  let owner = $("#updateAudienceOwner").val();
  let capacity = $("#updateAudienceCapacity").val();
  let category_id = $("#updateAudienceCategory").val();
  let name = $("#updateAudienceName").val();

  let newData = {
    id: id,
    owner: owner,
    capacity: capacity,
    category_id: category_id,
    name: name,
  };

  $.ajax({
    url: AUDIENCE_URL,
    type: "PUT",
    data: JSON.stringify(newData),
    contentType: "application/json",

    success: function (audience) {
      alert("Auditorio Actualizado");
    },
    error: function (xhr, status) {
      alert("Ha ocurrido un problema" + status);
    },
    complete: function (xhr, status) {
      $("#updateAudience").empty();
      showAudienceData();
    },
  });
}

// DELETE HTTP method for delete an audience
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
      alert("ha sucedido un problema" + status);
    },
    complete: function () {
      showAudienceData();
    },
  });
}
