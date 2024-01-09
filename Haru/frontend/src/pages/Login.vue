<template>
  <div class="container1">
    <div class="login-container">
      <!-- 좌측 박스 영역 -->
      <div class="left-box">
        <h2>하루의 여울</h2>
        <img src="../assets/login_icon.png" />
        <p>장소...추천 받으실래요?</p>
        <a href="/Signup" class="big-ctlbtn else-btn">회원가입</a>
      </div>

      <!-- 로그인 박스 영역 -->
      <div class="login-box">
        <div class="login-inner-box">
          <form method="POST" autocomplete="off">
            <h1>로그인</h1>
            <div class="form-input-box">
              <!-- 아이디 -->
              <div class="form-input">
                <label for="userId">아이디</label>
                <input
                  type="text"
                  name="userId"
                  id="userId"
                  class="input-text"
                />
              </div>
              <!-- 비밀번호 -->
              <div class="form-input">
                <label for="password">비밀번호</label>
                <input
                  type="password"
                  name="password"
                  id="password"
                  class="input-text"
                />
              </div>
              <div class="form-check">
                <div class="remember-checkbox">
                  <input type="checkbox" name="remember" id="remember" />
                  <label for="remember">로그인 상태 유지</label>
                </div>
              </div>
              <button
                class="big-ctlbtn insert-btn"
                @click="submit"
                id="login-submit-btn"
              >
                로그인
              </button>

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
        </div>
        <div class="social-login-box">
          <a href="#"><img src="../assets/kakao_login_icon.png" /></a>
          <a href="#"><img src="../assets/naver_login_icon.png" /></a>
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
  created() {
    this.bgImage();
  },
  methods: {
    bgImage() {
      var newImage = "type3";
      this.$emit("bgImage", newImage);
    },
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
.container1 {
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
