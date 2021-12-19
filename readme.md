# 0.1(進行中)

## 登入功能
### 目前問題
* 前端沒設置資料回傳，所以先用apiTest.html測試後端功能(首頁有連結)
* 註冊登入功能陽春，要多加判斷(前後端都要設計)
* email和password設置規則?(最少字數?)
* 登入成功後網頁的改變?


### 前端
* 登入介面
![](https://i.imgur.com/yzQsAv8.png)
### 後端

* 前端輸入取得所有帳密

      makeRequest("./getAccounts")

![](https://i.imgur.com/HHmmhCD.png)
* 註冊帳號(apiTest內)
  
  ![](https://i.imgur.com/HwNaE1D.png)
* 登入帳號(apiTest內)

  ![](https://i.imgur.com/CEssZ2l.png)
### 資料庫相關
![](https://i.imgur.com/988Pqi8.png)
* 帳密資料庫
  
Table: account_basic
    
    
Columns:

    EMAIL       varchar(50) PK 
    PASSWORD    varchar(50)
![](https://i.imgur.com/9wFdTNu.png)
