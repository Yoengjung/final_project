<template>
  <div class="container-1">
    <div class="login-container">
      <div class="white-box">
        <div class="left-box">
          <h2>하루의 여울</h2>
          <img src="../assets/login_icon.png" />
          <p>장소...추천 받으실래요?</p>
          <a href="/signup">회원가입</a>
        </div>
        <div class="login-box">
          <form method="POST" autocomplete="off">
            <h1>로그인</h1>
            <div class="form-input-box">
              <div class="form-input">
                <label for="userId">아이디</label>
                <input type="text" name="userId" id="userId" />
              </div>
              <div class="form-input">
                <label for="password">비밀번호</label>
                <input type="password" name="password" id="password" />
              </div>
              <div class="form-check">
                <div class="remember-checkbox">
                  <input type="checkbox" name="remember" id="remember" />
                  <label for="remember">로그인 상태 유지</label>
                </div>
              </div>
              <button @click="submit" id="submit-btn">로그인</button>
              <div class="login-search-box">
                <a href="/searchId">아이디 찾기</a>
                <a href="#">비밀번호 찾기</a>
              </div>
            </div>
          </form>
          <div class="social-login-box">
            <a href="#"><img src="../assets/kakao_login_icon.png" /></a>
            <a href="#"><img src="../assets/naver_login_icon.png" /></a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "Login",
};
</script>
<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100vh;
  position: absolute;
  background-image: url("../assets/main_image.png");
  background-repeat: no-repeat;
  background-size: cover;
  top: -1px;
  z-index: -1;
}

.white-box {
  display: flex;
  position: absolute;
  width: 40%;
  height: 50%;
  left: 50%;
  transform: translateX(-50%);
  background-color: rgba(255, 255, 255, 0.6);
  border-radius: 25px;
}

.left-box {
  position: relative;
  width: 50%;
  left: 20px;
  height: 100%;
  display: flex;
  flex-direction: column;
}

.left-box h2 {
  position: relative;
  margin-top: 30px;
  text-align: center;
  font-size: 30px;
}

.left-box img {
  position: relative;
  margin-top: 30px;
  left: 50%;
  transform: translateX(-50%);
  width: 200px;
  height: 200px;
}

.left-box p {
  position: relative;
  margin-top: 20px;
  text-align: center;
  font-size: 20px;
  color: #879090;
}

.left-box a {
  position: relative;
  margin-top: 5px;
  width: 160px;
  left: 50%;
  transform: translateX(-50%);
  text-align: center;
  font-size: 20px;
  color: black;
  text-decoration: none;
  background-color: white;
  border-radius: 10px;
}

.login-box {
  display: flex;
  position: absolute;
  flex-direction: column;
  align-items: center;
  width: 50%;
  height: 100%;
  right: 0px;
  background-color: rgba(236, 184, 163, 0.9);
  border-radius: 15px;
}

.login-box h1 {
  margin-top: 30px;
  margin-bottom: 10px;
  text-align: center;
  padding: 0px;
  font-size: 30px;
}

.form-input-box {
  display: flex;
  position: relative;
  flex-direction: column;
  align-items: center;
  width: 90%;
  height: 80%;
  left: 50%;
  transform: translateX(-50%);
}

.form-input-box .form-input:first-child input {
  margin-bottom: 20px;
}

.form-input-box .form-input input {
  width: 100%;
  height: 40px;
  border: none;
  border-bottom: 2px solid black;
  border-top-right-radius: 5px;
  border-top-left-radius: 5px;
  padding: 0px 10px;
  font-size: 20px;
}

.form-check {
  display: flex;
  width: 100%;
  margin: 10px 0;
  padding: 0px;
}

.form-check .remember-checkbox {
  display: flex;
}

.form-check .remember-checkbox label {
  margin-left: 10px;
}

.login-search-box {
  display: flex;
  width: 100%;
  margin: 20px 0px;
  padding: 0px;
}

.login-search-box a {
  display: flex;
  width: 50%;
  justify-content: center;
  align-items: center;
  text-decoration: none;
  color: black;
  font-size: 15px;
}

#submit-btn {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 40px;
  margin-top: 10px;
  border: none;
  border-radius: 27px;
  background-color: #f5f5f5;
  font-size: 20px;
  cursor: pointer;
}

.social-login-box {
  display: flex;
  width: 100%;
  height: 50px;
  margin-top: 20px;
  justify-content: center;
  align-items: center;
}

.social-login-box a {
  display: flex;
  position: relative;
  bottom: 30px;
  width: 40px;
  height: 40px;
  margin: 0px 10px;
  border-radius: 50%;
  background-color: white;
}
</style>
