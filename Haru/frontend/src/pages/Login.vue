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
                <button @click="openIdModal" @submit.prevent>
                  아이디 찾기
                </button>
                <button @click="openPasswordModal">비밀번호 찾기</button>

                <!-- 아이디 찾기 모달 -->
                <div v-if="isIdModalOpen" class="modal">
                  <div class="modal-content">
                    <h2>아이디 찾기</h2>
                    <form @submit.prevent>
                      <div>
                        <label for="name">이름:</label>
                        <input type="text" id="name" v-model="name" />
                      </div>
                      <div>
                        <label for="email">이메일:</label>
                        <input type="email" id="email" v-model="email" />
                      </div>
                      <button @click="findUserId">아이디 찾기</button>
                    </form>
                    <button @click="closeIdModal">닫기</button>
                  </div>
                  <!-- 비밀번호 찾기 모달 -->
                  <div v-if="isPasswordModalOpen" class="modal">
                    <div class="modal-content">
                      <h2>비밀번호 찾기</h2>
                      <form @submit.prevent>
                        <!-- 비밀번호 찾기에 해당하는 폼 구성 -->
                      </form>
                      <button @click="closePasswordModal">닫기</button>
                    </div>
                  </div>
                </div>
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
  data() {
    return {
      isIdModalOpen: false,
      isPasswordModalOpen: false,
      name: "",
      email: "",
    };
  },
  methods: {
    openIdModal() {
      this.isIdModalOpen = true;
    },
    closeIdModal() {
      this.isIdModalOpen = false;
    },
    openPasswordModal() {
      this.isPasswordModalOpen = true;
    },
    closePasswordModal() {
      this.isPasswordModalOpen = false;
    },
  },
};
</script>
<style scoped>
@import url("../css/login.css");
</style>
