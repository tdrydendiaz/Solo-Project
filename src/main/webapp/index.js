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
    makeRequest("GET", "http://localhost:8080/SoloProject/api/movie/getAllMovies")
    .then((request) => {
      console.log(request.responseText);
      document.getElementById('result').innerText = request.responseText;
    });
  }