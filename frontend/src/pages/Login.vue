<template>
  <div class="login-container">
    <div class="white-box"></div>
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
      <div class="social-login-box"></div>
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
  background-repeat: no-repeat;
  top: -50px;
  background-size: cover;
  background-image: url("../assets/login_bg.png");
  z-index: -1;
}

.white-box {
  display: flex;
  position: absolute;
  width: 65%;
  height: 50%;
  left: 50%;
  transform: translateX(-50%);
  background-color: white;
  border-radius: 25px;
  box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.8);
}

.login-box {
  display: flex;
  position: absolute;
  flex-direction: column;
  align-items: center;
  width: 25%;
  height: 60%;
  left: 65%;
  background-color: rgba(207, 147, 147, 0.3);
  transform: translateX(-50%);
  border-radius: 15px;
  box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.8);
}

.login-box h1 {
  margin-top: 70px;
  margin-bottom: 30px;
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
  border-bottom: 3px solid black;
  border-top-right-radius: 5px;
  border-top-left-radius: 5px;
  padding: 0px 10px;
  font-size: 20px;
}

.form-check {
  display: flex;
  width: 100%;
  margin: 20px 0;
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
</style>
