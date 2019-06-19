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
      tr += "<td> MovieID</td><td> Title</td><td>Release Year</td><td>Run Time</td><td> Certification</td><td>Rating</td></tr>";

      for (i in obj) {
        tr += "<td>" + obj[i].movieID + "</td><td>" + obj[i].title + "</td><td>" + obj[i].releaseYear + "</td><td>" + obj[i].runTime + "</td><td>" + obj[i].certification + "</td><td>" + obj[i].rating + "</td></tr>";
      }
      tbody.innerHTML += tr;
    });
}

