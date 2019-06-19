
const getMovies = "http://localhost:8080/SoloProject/api/movie/getAllMovies"


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
      res.innerHTML = request.responseText;
      let node = document.createElement("tbody");
      node.setAttribute("id", "tbody");
      document.getElementById("result").appendChild(node);
      let obj = JSON.parse(req.responseText);
      console.log(obj);
      let tr = "<tr>";
      tr += "<td> MovieID</td><td> Title</td><td>Release Year</td><td>Run Time</td><td> Certification</td><td>Rating</td></tr>";

      tr += "<td>" + obj.movieID + "</td><td>" + obj.title + "</td><td>" + obj.releaseYear + "</td><td>" + obj.runTime + "</td><td>" + obj.certification + "</td><td>" + obj.rating + "</td></tr>";
      //`http://localhost:8080/SoloProject/api/movie/getAMovie/${id}`
    })
}


 function deleteMovie(){
  let id = document.getElementById('inputno').value;
 makeRequest("DELETE", `http://localhost:8080/SoloProject/api/movie/deleteMovie/${id}`)
    .then(res => { console.log("Success") });
}
 
function updateMovie(){
  let id = document.getElementById('id').value;
    let id1 = document.getElementById('titl').value;
      let id2 = document.getElementById('ry').value;
        let id3 = document.getElementById('rt').value;
        let id4 = document.getElementById('cer').value;
        let id5 = document.getElementById('rat').value;
        const text = {
    title: "titl",
    releaseYear: "ry",
    runTime: "rt",
    certification: "cer",
    rating: "rat",
        }
  const obj1 = JSON.stringify(text);
   makeRequest("PUT", `http://localhost:8080/SoloProject/api/movie/updateMovie/${id}`, obj1)
    .then(res => { console.log("Success") });

}






