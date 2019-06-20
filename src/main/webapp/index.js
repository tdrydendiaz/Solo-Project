
const getMovies = "http://localhost:8080/SoloProject/api/movie/getAllMovies"

http://35.228.151.103:8888/SoloProject/api/movie/getAllMovies
function makeRequest(method, url, body) {

  return new Promise((resolve, reject) => {
    let request = new XMLHttpRequest();
    request.open(method, url);
    request.send(body);

    request.onload = () => {
      const bt=document.getElementById("result");
      while (bt.firstChild){
        bt.removeChild(bt.firstChild);
      }
      if (request.status >= 200 && request.status <= 299) {
        resolve(request);
      } else {
        const reason = new Error("Rejected");
        reject(reason);
      }
    }

  });
}


function getAllMovies() {

  makeRequest("GET", getMovies)
    .then((request) => {
      console.log(request.responseText);
      // document.getElementById('result').innerText = request.responseText;
      let node = document.createElement("tbody");
      node.setAttribute("id", "tbody");
      document.getElementById("result").appendChild(node);
      let obj = JSON.parse(request.responseText);
      console.log(obj);
      let tr = "<tr>";
      tr += "<td> MovieID</td><td> Title</td><td>Release Year</td><td>Run Time</td><td> Certification</td><td>Rating</td></tr>";

      for (i in obj) {
        tr += "<td>" + obj[i].movieID + "</td><td>" + obj[i].title + "</td><td>" + obj[i].releaseYear + "</td><td>" + obj[i].runTime + "</td><td>" + obj[i].certification + "</td><td>" + obj[i].rating + "</td></tr>";
      }
      tbody.innerHTML += tr;
    });
}

function getAMovie() {
  let id = document.getElementById('movie').value;
  makeRequest("GET", `http://localhost:8080/SoloProject/api/movie/getAMovie/${id}`)
    .then((request) => {
      let res = document.getElementById('result');
      // res.innerHTML = request.responseText;
      let node = document.createElement("tbody");
      node.setAttribute("id", "tbody");
      document.getElementById("result").appendChild(node);
      let obj = JSON.parse(request.responseText);
      console.log(obj);
      let tr = "<tr>";
      tr += "<td>|-- MovieID--|</td><td> |----------Title----------|</td><td>|--Release Year--|</td><td>|--Run Time--|</td><td> |--Certification--|</td><td>|---Rating---|</td></tr>";

      tr += "<td>" + obj.movieID + "</td><td>" + obj.title + "</td><td>" + obj.releaseYear + "</td><td>" + obj.runTime + "</td><td>" + obj.certification + "</td><td>" + obj.rating + "</td></tr>";
      //`http://localhost:8080/SoloProject/api/movie/getAMovie/${id}`
       tbody.innerHTML += tr;
    })
}


 function deleteMovie(){
  let id = document.getElementById('inputno').value;
 makeRequest("DELETE", `http://localhost:8080/SoloProject/api/movie/deleteMovie/${id}`)
    .then(res => { console.log("Success") });
}
 

function updateMovie(id) {


  let idVal = id.value;
  let movtitle = document.getElementById("updateTitle").value;
  let movReleaseYear = document.getElementById("updateYear").value;
  let movRunTime = document.getElementById("updateRun").value;
  let movCert = document.getElementById("updateCert").value;
  let movRating = document.getElementById("updateRat").value;

  const accObject = {
    title: movtitle,
    releaseYear: movReleaseYear,
    runTime: movRunTime,
    certification: movCert,
    rating: movRating
  }

  makeRequest("PUT", `http://localhost:8080/SoloProject/api/movie/updateMovie/${idVal}`, JSON.stringify(accObject))
  .then((request) => {
    console.log(request.responseText)
    document.getElementById('result').innerText = request.responseText;
  });
}

function createMovie() {
  let request = new XMLHttpRequest();
  let movtitle = document.getElementById("updateTitle").value;
  let movReleaseYear = document.getElementById("updateYear").value;
  let movRunTime = document.getElementById("updateRun").value;
  let movCert = document.getElementById("updateCert").value;
  let movRating = document.getElementById("updateRat").value;

  const movObject = {
    title: movtitle,
    releaseYear: movReleaseYear,
    runTime: movRunTime,
    certification: movCert,
    rating: movRating
  }
  let accJSON = JSON.stringify(movObject);
  request.onload = function(){
    document.getElementById('result').innerText = request.responseText;
  }
  //creating an account as a JSON string
  request.open("POST", "http://localhost:8080/SoloProject/api/movie/createMovie");
  request.send(accJSON);
}

getAllMovies();




