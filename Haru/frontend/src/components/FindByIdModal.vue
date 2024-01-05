<template>
  <div class="modalBackground">
    <div v-if="modalOpen" class="findIdModal">
      <div class="findModalContent">
        <span class="close" @click="$emit('modalClose')">&times;</span>
        <h2>아이디 찾기</h2>
        <form autocomplete="off">
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

          <button @click="findIdToggleModal">아이디 찾기</button>
        </form>
      </div>
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
