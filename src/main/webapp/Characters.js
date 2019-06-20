function makeRequest(method, url, body) {

  return new Promise((resolve, reject) => {
    let request = new XMLHttpRequest();
    request.open(method, url);
    request.send(body);

    request.onload = () => {
      if (request.status >= 200 && request.status <= 299) {
        resolve(request);
      } else {
        const reason = new Error("Rejected");
        reject(reason);
      }
    }

  });

  
}

function getAllCharacters() {
  makeRequest("GET", "http://localhost:8080/SoloProject/api/character/getAllCharacters" )
    .then((request) => {
      console.log(request.responseText);
      // document.getElementById('result').innerText = request.responseText;
      let node = document.createElement("tbody");
      node.setAttribute("id", "tbody");
      document.getElementById("result").appendChild(node);
      let obj = JSON.parse(request.responseText);
      console.log(obj);
      let tr = "<tr>";
      tr += "<td> Character ID</td><td> Character Name </td><td>Actor Name</td><td>Power Rating</td><td> Morality</td><td>Gender</td><td> Homeworld</td></tr>";

      for (i in obj) {
        tr += "<td>" + obj[i].characterID + "</td><td>" + obj[i].characterName + "</td><td>" + obj[i].actorName + "</td><td>" + obj[i].powerRating + "</td><td>" + obj[i].morality + "</td><td>" + obj[i].gender + "</td><td>" + obj[i].homeworld+"</td></tr>";
      }
      tbody.innerHTML += tr;
    });
}

function getACharacter() {
  let id = document.getElementById('character').value;
  makeRequest("GET", `http://localhost:8080/SoloProject/api/character/getACharacter/${id}`)
    .then((request) => {
      let res = document.getElementById('result');
     
      let node = document.createElement("tbody");
      node.setAttribute("id", "tbody");
      document.getElementById("result").appendChild(node);
      let obj = JSON.parse(request.responseText);
      console.log(obj);
      let tr = "<tr>";
      tr += "<td> Character ID</td><td> Character Name </td><td>Actor Name</td><td>Power Rating</td><td> Morality</td><td>Gender</td><td> Homeworld</td></tr>";

      tr += "<td>" + obj.characterID + "</td><td>" + obj.characterName + "</td><td>" + obj.actorName + "</td><td>" + obj.powerRating + "</td><td>" + obj.morality + "</td><td>" + obj.gender + "</td><td>" + obj.homeworld+"</td></tr>";
      //`http://localhost:8080/SoloProject/api/movie/getAMovie/${id}`
     tbody.innerHTML += tr;
    })
}


function updateCharacter(id) {

  let idVal = id.value;
  let chaName = document.getElementById("updateName").value;
  let chaAct = document.getElementById("updateAct").value;
  let chaPower = document.getElementById("updatePower").value;
  let chaMor = document.getElementById("updateMor").value;
  let chaGen = document.getElementById("updateGen").value;
  let chaHome = document.getElementById("updateHome").value;

  const accObject = {
    characterName: chaName,
    actorName: chaAct,
    powerRating: chaPower,
    morality: chaMor,
    gender: chaGen,
    homeworld: chaHome
  }

  makeRequest("PUT", `http://localhost:8080/SoloProject/api/character/updateCharacter/${idVal}`, JSON.stringify(accObject))
  .then((request) => {
    console.log(request.responseText)
    document.getElementById('result').innerText = request.responseText;
  });
}

function createCharacter() {
  let request = new XMLHttpRequest();
  let chaName = document.getElementById("updateName").value;
  let chaAct = document.getElementById("updateAct").value;
  let chaPower = document.getElementById("updatePower").value;
  let chaMor = document.getElementById("updateMor").value;
  let chaGen = document.getElementById("updateGen").value;
  let chaHome = document.getElementById("updateHome").value;

  const accObject = {
    characterName: chaName,
    actorName: chaAct,
    powerRating: chaPower,
    morality: chaMor,
    gender: chaGen,
    homeworld: chaHome
  }
  let accJSON = JSON.stringify(accObject);
  request.onload = function(){
    document.getElementById('result').innerText = request.responseText;
  }
  //creating an account as a JSON string
  request.open("POST", "http://localhost:8080/SoloProject/api/character/createCharacter");
  request.send(accJSON);
}
function deleteCharacter(){
  let id = document.getElementById('inputno').value;
 makeRequest("DELETE", `http://localhost:8080/SoloProject/api/character/deleteCharacter/${id}`)
    .then(res => { console.log("Success") });
}