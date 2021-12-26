   function checkJavascript(){
            alert('引入成功')
   }



    function deleteAllCookies() {
        var cookies = document.cookie.split(";");
        for (var i = 0; i < cookies.length; i++) {
            var cookie = cookies[i];
            var eqPos = cookie.indexOf("=");
            var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
            document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
        }
        console.log("cookies 清除完成");
        alert("登出完成")
    }


        function getCookie(objName){//獲取指定名稱的cookie的值
            var arrStr = document.cookie.split("; ");

            for(var i = 0;i < arrStr.length;i++ ){
                var temp = arrStr[i].split("=");
                console.log(i,temp)
                if(temp[0] == objName) {
                    alert(unescape('登入者:'+temp[1]));
                    return unescape(temp[1]);
                }
            }
            alert('null');
            return null;
        }




    function apiShow(url){
          if (url === '') {
             makeRequest(url)
          } else {
             makeRequest(url)
          }
    }


    function emptyProducts() {
      $('#dataList').empty();
    }

    function makePostRequest(id) {
        var key=value=document.getElementById(id).name,value=document.getElementById(id).value;
        var data=key+"="+value,url="/api/"+id;
        var xhr = new XMLHttpRequest();
        xhr.open("post",url, true);
        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xhr.send(data);

        xhr.onload = function() {

            let response = JSON.parse(this.response);
            console.log(response)
            addDatas(response)
        };
    <!--AJAX post 寫法  https://chunchun0401.medium.com/ajax-post-%E5%AF%AB%E6%B3%95-e8ddb342196a-->

    }


    function makeRequest(url) {
        xhr = new XMLHttpRequest();
        console.log("!!!!!");
        xhr.onload = function() {
            let response = JSON.parse(this.response);
            console.log(response)
            addDatas(response)
        };
        xhr.open("GET", url, true);
        xhr.send();
    }

    function addDatas(datas) {
<!--    API資料導入後，填入迴圈修改html顯示表格-->
        console.log("顯示Data");
        emptyProducts();//全部淨空
        var key=Object.keys(datas[0]);
        for ( let data of datas ) {
            let html = '<div class="card col-4">';
            html += '<div class="card-body">';
            for(let p of key){
               if(p==key[0]){
                html += '<h5 class="card-text">'+p+ ":\t"+data[p] +'</h5>';
               }else if(p=="imageUrl"){
                html += '<img src="' + data[p] + '" class="card-img-top" alt="' +data[p]  + '"width="10" height="150">';
               }
               else{
                html += '<p class="card-text">'+p+ ":\t"+data[p] + '</p>';
               }
            }
            html += '<a href="#" class="btn btn-primary">' + '(可放圖片 按鈕功能 其他資料...)' + '</a>';
            html += '</div>';
            html += '</div>';
            $('#dataList').append(html);
        }
    }




