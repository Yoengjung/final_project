<template>
  <div class="container1">
    <h1 class="logo">
      <a href="/"><img src="../assets/logo_검정.png" /></a>
    </h1>
    <header>
      <div class="dropdown">
        <button class="dropbtn dropbtn-1">나의 스트레스</button>
        <div class="dropdown-content dropdown-1">
          <a href="/faceregistration">나의 스트레스 분석하기</a>
          <a href="#">나의 스트레스 종합 보고서</a>
        </div>
      </div>
      <div class="dropdown">
        <button class="dropbtn">내 장소</button>
        <div class="dropdown-content">
          <a href="MyPlaceDiary">추천 리스트</a>
          <a href="#">찜한 장소</a>
        </div>
      </div>
      <div class="dropdown">
        <button class="dropbtn">피드</button>
        <div class="dropdown-content">
          <a href="/feed">피드</a>
          <a href="/MyFeed">내 피드</a>
          <a href="insertFeed">피드 작성하기</a>
        </div>
      </div>
      <div class="login-ul-box">
        <ul>
          <li><a href="/login">로그인</a></li>
          <li><a href="/signup">회원가입</a></li>
        </ul>
      </div>
    </header>
  </div>
</template>
<script>
export default {
  name: "Header",
};
</script>
<style scoped>
.container1 {
  margin: 0px;
  padding: 0px;
  position: relative;
  /* width: 60%; */
  width: fit-content;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  flex-direction: row;
  z-index: 10;
}

header {
  width: 100%;
}

.logo {
  position: relative;
  top: 30px;
  left: 80px;
  width: 100px;
  height: 100px;
}

img {
  width: 130px;
}

/* Dropdown Button */
.dropbtn {
  padding: 16px;
  border: none;
  cursor: pointer;
  display: flex;
  position: relative;
  width: 160px;
  justify-content: center;
  background-color: transparent;
  font-size: 20px;
  color: white;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}

.dropbtn:hover {
  color: white;
}

.dropbtn-1 {
  width: 210px;
}

.dropdown {
  position: relative;
  display: inline-block;
  margin: 30px -15px;
  z-index: 1;
}

.dropdown:first-child {
  margin-left: 150px;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: black rgba(0, 0, 0, 0.5);
  min-width: 160px;
  z-index: 1;
}

.dropdown-1 {
  min-width: 210px;
}

.dropdown-content a {
  color: white;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: center;
  background-color: rgba(36, 36, 36, 0.6);
}

.dropdown-content a:last-child {
  border-bottom-right-radius: 10px;
  border-bottom-left-radius: 10px;
}

.dropdown-content a:hover {
  background-color: #adadad;
}

.dropdown:hover .dropdown-content {
  display: block;
}

.dropdown:hover .dropbtn {
  background-color: rgba(36, 36, 36, 0.6);
}

/* 로그인 회원가입 */
.login-ul-box {
  position: relative;
  display: flex;
  float: right;
  width: 350px;
  right: 0;
  top: 30px;
}

.login-ul-box ul {
  display: flex;
  position: absolute;
  list-style: none;
  align-items: center;
  padding: 0;
  margin: 15px;
}

.login-ul-box ul li {
  margin: 0 40px;
}

.login-ul-box ul li a {
  text-decoration: none;
  font-size: 20px;
  color: white;
}

.login-ul-box ul li a:hover {
  color: black;
}
</style>
