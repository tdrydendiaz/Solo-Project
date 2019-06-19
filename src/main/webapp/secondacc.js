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

function getAll() {
  makeRequest("GET", "http://localhost:8080/AccountSETemplate/api/account/getAllAccounts")
  .then((request) => {
    console.log(request.responseText);
    document.getElementById('result').innerText = request.responseText;
  });
}

function getOne(id) {
  let idVal = id.value;
  makeRequest("GET", `http://localhost:8080/AccountSETemplate/api/account/getAnAccount/${idVal}`)
  .then((request) => {
      if (request.responseText != 'null'){
        console.log(request.responseText);
        document.getElementById('result').innerText = request.responseText;
      } else {
        document.getElementById('result').innerText = "Account not found";
      }
  })
  .catch((reason) => {
    console.log(reason.message);
  });
}

function createAcc() {
  let accId = document.getElementById('accountId').value;
  let accFirst = document.getElementById('firstName').value;
  let accLast = document.getElementById('lastName').value;

  const accObject = {
    accountNumber: accId,
    firstName: accFirst,
    lastName: accLast
  }
  let accJSON = JSON.stringify(accObject);
  makeRequest("POST", "http://localhost:8080/AccountSETemplate/api/account/createAccount", accJSON)
  .then((request) => {
    console.log(accJSON);
    document.getElementById('result').innerText = request.responseText;
  });
}

function deleteAcc(id) {
  let idVal = id.value;
  makeRequest("DELETE", `http://localhost:8080/AccountSETemplate/api/account/deleteAccount/${idVal}`)
  .then((request) => {
      document.getElementById('result').innerText = request.responseText;
  })
  .catch((reason) => {
    console.log(reason.message);
  });
}

function updateAcc(id) {


  let idVal = id.value;
  let accNum = document.getElementById("updateAccNum").value;
  let accFirst = document.getElementById("updateFirst").value;
  let accLast = document.getElementById("updateLast").value;

  const accObject = {
    accountNumber: accNum,
    firstName: accFirst,
    lastName: accLast
  }

  makeRequest("PUT", `http://localhost:8080/AccountSETemplate/api/account/updateAccount/${idVal}`, JSON.stringify(accObject))
  .then((request) => {
    console.log(request.responseText)
    document.getElementById('result').innerText = request.responseText;
  });
}


//callback is an abitrary function name
function callbackExample(callback) {
  WebRequest();
  callback();
}

function getAnAccountRequest(id) {
  let request = new XMLHttpRequest();
  let idVal = id.value;
  request.onload = function(){

    if (request.responseText != 'null'){
      document.getElementById('result').innerText = request.responseText;
    } else {
      document.getElementById('result').innerText = "Account not found"
    }

  }
  request.open("GET", `http://localhost:8080/AccountSETemplate/api/account/getAnAccount/${idVal}`);
  request.send();
}

function getAllAccountRequest() {

  let request = new XMLHttpRequest();
  request.onload = function() {
    // let account = document.createElement('p');
    // account.innerText = request.reponseText;
    // document.getElementById('allAccounts').appendChild(account);
    document.getElementById('result').innerText = request.responseText;
  }
  request.open("GET", "http://localhost:8080/AccountSETemplate/api/account/getAllAccounts")
  request.send();
}

function createAccountRequest() {
  let request = new XMLHttpRequest();
  //getting the inputs
  let accId = document.getElementById('accountId').value;
  let accFirst = document.getElementById('firstName').value;
  let accLast = document.getElementById('lastName').value;
  //creating an JavaScript object with the inputs
  const accObject = {
    accountNumber: accId,
    firstName: accFirst,
    lastName: accLast
  }
  let accJSON = JSON.stringify(accObject);
  request.onload = function(){
    document.getElementById('result').innerText = request.responseText;
  }
  //creating an account as a JSON string
  request.open("POST", "http://localhost:8080/AccountSETemplate/api/account/createAccount");
  request.send(accJSON);
}

function deleteAccountRequest(id) {
  let request = new XMLHttpRequest();
  let idVal = id.value;
  request.onload = function(){

    document.getElementById('result').innerText = request.responseText;
  }
  request.open("DELETE", `http://localhost:8080/AccountSETemplate/api/account/deleteAccount/${idVal}`);
  request.send();
}

function updateAccountRequest(id) {
  let request = new XMLHttpRequest();

}

function addingChild() {
  let myH1 = document.createElement('h1');
  myH1.innerText = 'Page Header';
  myH1.id = 'header-text';
  document.getElementById('header-box').appendChild(myH1);
}