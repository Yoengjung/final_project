<template>
  <div class="login">
    <h3>login</h3>
    <form method="POST">
      <div class="form-input">
        <label for="userId">아이디</label>
        <input type="text" name="userId" id="userId" />
      </div>
      <div class="form-input">
        <label for="password">비밀번호</label>
        <input type="password" name="password" id="password" />
      </div>
      <div class="form-check">
        <input type="checkbox" name="remember" id="remember" />
        <label for="remember">Remember me</label>
      </div>
      <button @click="submit">로그인</button>
    </form>
  </div>
</template>
<script>
export default {
  name: "Login",
  setup() {},
};
</script>
<style scoped></style>
