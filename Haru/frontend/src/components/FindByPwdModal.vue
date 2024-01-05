<template>
  <div v-if="modalOpen" class="findPwdModal">
    <div class="findModalContent">
      <span class="close" @click="$emit('modalClose')">&times;</span>
      <h2>비밀번호 찾기</h2>
      <form autocomplete="off">
        <div>
          <label for="id">아이디</label>
          <input type="text" id="id" />
        </div>
        <div>
          <label for="name">이름</label>
          <input type="text" id="name" />
        </div>
        <div>
          <label for="email">이메일</label>
        </div>
        <div class="email-box">
          <input type="email" id="email" />
          <button @click.prevent="submit">인증</button>
        </div>
        <div class="emailCheckBox">
          <label for="emailCheck">인증번호</label>
          <input type="number" id="emailCheck" />
        </div>
        <button @click="findIdToggleModal">비밀번호 찾기</button>
      </form>
    </div>
  </div>
</template>
<script>
export default {
  name: "FindByIdModal",
  data() {
    return {};
  },
  props: {
    modalOpen: Boolean,
  },
};
</script>
