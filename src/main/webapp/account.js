const getAllAccounts = () => {
  let req = new XMLHttpRequest();
  req.onload = function () {
    let res = document.getElementById("getAllAccounts");
    res.innerHTML = req.responseText;
    child();
  }
  req.open("GET", "http://localhost:8080/AccountSETemplate/api/account/getAllAccounts")
  req.send();
}

function makeRequest(method, url, body) {
  return new Promise((res, rej) => {
    const req = new XMLHttpRequest();
    req.open(method, url);

    req.send(body);
    req.onload = () => {
      if (req.status >= 200 && req.status <= 299) {
        res(req);
      }
      else {reject(new Error("Rejected")); }
    }
  })
}

function getAll() {
  makeRequest("GET", "http://localhost:8080/AccountSETemplate/api/account/getAllAccounts")
    .then(res => { console.log("Success") });
}


function getAnAccount() {
  let req = new XMLHttpRequest();
  req.onload = function () {
    let res = document.getElementById('result');
    res.innerHTML = req.responseText;
  }
  let id = document.getElementById('account').value;
  req.open("GET", `http://localhost:8080/AccountSETemplate/api/account/getAnAccount/${id}`)
  req.send();
}

function getAcc(){
  let id = document.getElementById('account').value;
  console.log(id);
  makeRequest("GET", `http://localhost:8080/AccountSETemplate/api/account/getAnAccount/${id}`)
  .then(res=> {console.log("Success")});
}


function child() {
  let myH1 = document.createElement('h1');
  myH1.innerText = 'All Accounts!';
  myH1.id = 'header-text';
  document.getElementById('header-box').appendChild(myH1);
}

function createAnAccount() {
  let req = new XMLHttpRequest();
  let id1 = document.getElementById('idno').value;
  let id2 = document.getElementById('acc').value;
  let id3 = document.getElementById('fn').value;
  let id4 = document.getElementById('ls').value;

  const text = {
    // id: 10,
    accountNumber: 10,
    firstName: "Adam",
    lastName: "Stephan"
  }
  const obj1 = JSON.stringify(text);
    req.onload = function() {
      let res = document.getElementById('createAnAccount');
      res.innerHTML = req.responseText;
    };

  req.open("POST", "http://localhost:8080/AccountSETemplate/api/account/createAccount");
  req.send(obj1);
}

function deleteAccount(){
  let id = document.getElementById('inputno').value;
 makeRequest("DELETE", `http://localhost:8080/AccountSETemplate/api/account/deleteAccount/${id}`)
    .then(res => { console.log("Success") });

}

function updateAccount(){
  let id5 = document.getElementById('id1').value;
    let id6 = document.getElementById('accno').value;
      let id7 = document.getElementById('fn1').value;
        let id8 = document.getElementById('ln1').value;
        const text = {
    accountNumber: "accno",
    firstName: "fn1",
    lastName: "ln1"
        }
  const obj1 = JSON.stringify(text);
   makeRequest("PUT", `http://localhost:8080/AccountSETemplate/api/account/updateAccount/${id5}`, obj1)
    .then(res => { console.log("Success") });


}