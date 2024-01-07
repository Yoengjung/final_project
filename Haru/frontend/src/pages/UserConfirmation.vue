<template>
  <div>
    <div class="userConfirm-container">
      <div class="userConfirm-box">
        <h3>개인 정보 확인</h3>
        <form>
          <label for="password">비밀번호</label>
          <input type="password" id="password" />
          <p id="userComfirm-pwd-msg"></p>
          <button type="submit" id="userConfirm-btn" @click="userConfirmBtn">
            개인 정보 수정
          </button>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "UserConfirmation",
  data() {
    return {};
  },
  methods: {
    userConfirmBtn() {
      this.$router.push("/updateMyInfo");
    },
  },
};
</script>
<style scoped>
@import url("../css/userConfirmation.css");
</style>
