
const getAllMovies="http://http://35.246.26.121:8888/SoloProject/api/movie/getAllMovies"


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


  
  function getAllMovies(){
    makeRequest("GET", getAllMovies)
    .then((request) => {
      console.log(request.responseText);
      // document.getElementById('result').innerText = request.responseText;
      let node=document.createElement("tbody");
      node.setAttribute("id","tbody");
      document.getElementById("result").appendChild(node);
      let obj=JSON.parse(request.responseText);
      console.log(obj);
      let tr="<tr>";
      tr+="<td> MovieID</td><td> Title</td><td>Release Year</td><td>Run Time</td><td> Certification</td><td>Rating</td></tr>";  
    
      for ( i in obj){
    tr+="<td>"+ obj[i].movieID+"</td><td>"+ obj[i].title+"</td><td>"+ obj[i].releaseYear+"</td><td>"+ obj[i].runTime+"</td><td>"+ obj[i].certification+"</td><td>"+ obj[i].rating+"</td></tr>";  
  }
tbody.innerHTML+=tr;
    });
  }

  function getAMovie() {
    let req = new XMLHttpRequest();
    req.onload = function () {
      let res = document.getElementById('result');
      res.innerHTML = req.responseText;
      let node=document.createElement("tbody");
      node.setAttribute("id","tbody");
      document.getElementById("result").appendChild(node);
      let obj=JSON.parse(req.responseText);
      console.log(obj);
      let tr="<tr>";
      tr+="<td> MovieID</td><td> Title</td><td>Release Year</td><td>Run Time</td><td> Certification</td><td>Rating</td></tr>";  
    
      for ( i in obj){
        tr+="<td>"+ obj[i].movieID+"</td><td>"+ obj[i].title+"</td><td>"+ obj[i].releaseYear+"</td><td>"+ obj[i].runTime+"</td><td>"+ obj[i].certification+"</td><td>"+ obj[i].rating+"</td></tr>";  
    }
    let id = document.getElementById('movie').value;
    req.open("GET", `http://localhost:8080/SoloProject/api/movie/getAMovie/${id}`)
    req.send();

  }
  
