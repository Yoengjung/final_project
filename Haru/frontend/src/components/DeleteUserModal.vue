<template>
  <div class="deleteMyInfo-wrap" v-if="deleteMyInfoModal">
    <div class="deleteMyInfo-modal" v-if="deleteMyInfoModal">
      <div class="deleteMyInfo-modal-content">
        <div class="deleteMyInfo-modal-header">
          <span class="close" @click="$emit('modalClose')">&times;</span>
          <h3>정말.... 탈퇴 하실건가요</h3>
        </div>
        <div class="deleteMyInfo-modal-body">
          <img src="../img/deleteUserModal/image106.png" />
          <div class="delete-text-commend">
            <p>탈퇴 선택시, 계정은</p>
            <div style="display: flex">
              <p>삭제되며</p>
              &nbsp;
              <p style="color: red">복구 되지 않습니다.</p>
            </div>
            <br />
            <div class="delete-commend-input-box">
              <span>탈퇴하기 전에</span>&nbsp;
              <input type="text" id="delete-id" placeholder="아이디" />&nbsp;
              <span>를 입력해주세요.</span>
            </div>
          </div>
        </div>
        <div class="deleteMyInfo-modal-footer">
          <div class="deleteMyInfo-modal-footer-box">
            <button class="deleteMyInfo-modal-button" id="deleteMyInfo-cancel">
              뒤로가기
            </button>
            <button class="deleteMyInfo-modal-button" id="deleteMyInfo-submit">
              탈퇴하기
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "DeleteMyInfoModal",
  data() {
    return {};
  },
  props: {
    deleteMyInfoModal: Boolean,
  },
};
</script>
