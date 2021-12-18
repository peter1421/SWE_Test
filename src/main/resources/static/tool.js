 function makeRequest(url) {
    //回傳資料庫後端數據
    xhr = new XMLHttpRequest();
    xhr.onload = function() {
      let response = JSON.parse(this.response);
      console.log(response)
      };
    xhr.open("GET", url, true);
    xhr.send();
 }