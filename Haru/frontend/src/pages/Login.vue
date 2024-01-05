<template>
  <div class="container-1">
    <div class="login-container">
      <div class="white-box">
        <div class="left-box">
          <h2>하루의 여울</h2>
          <img src="../assets/login_icon.png" />
          <p>장소...추천 받으실래요?</p>
          <a href="/Signup">회원가입</a>
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
              <button @click="submit" id="login-submit-btn">로그인</button>

              <div class="login-search-box">
                <button @click="findIdToggleModal" @click.prevent="submit">
                  아이디 찾기
                </button>
                <button @click="findPwdToggleModal" @click.prevent="submit">
                  비밀번호 찾기
                </button>
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
  <FindByIdModal :modalOpen="isIdModalOpen" @modalClose="findIdToggleModal" />
  <FindByPwdModal
    :modalOpen="isPwdModalOpen"
    @modalClose="findPwdToggleModal"
  />
</template>
<script>
import FindByIdModal from "../components/FindByIdModal.vue";
import FindByPwdModal from "../components/FindByPwdModal.vue";

export default {
  name: "Login",
  data() {
    return {
      isIdModalOpen: false,
      isPwdModalOpen: false,
      name: "",
      email: "",
    };
  },
  components: {
    FindByIdModal,
    FindByPwdModal,
  },
  methods: {
    findIdToggleModal() {
      this.isIdModalOpen = !this.isIdModalOpen;
    },
    findPwdToggleModal() {
      console.log("비밀번호 찾기 모달");
      this.isPwdModalOpen = !this.isPwdModalOpen;
    },
  },
};
</script>
<style scoped>
@import url("../css/login.css");
</style>
