<template>
  <div class="background-container">
    <div>
      <DeleteMyInfoModal
        :deleteMyInfoModal="deleteMyInfoModal"
        @modalClose="toggleDeleteMyInfoModal"
      />
    </div>
    <div class="container">
      <form
        method="POST"
        autocomplete="off"
        @submit.prevent="onSubmit"
        class="login-form"
      >
        <h2>내 정보 수정</h2>
        <div class="label-box">
          <label for="userId">아이디</label>
          <span>*</span>
        </div>
        <div class="update-input-group-box">
          <p type="text" id="userId">rhdudwnd82</p>
        </div>

        <div class="label-box">
          <label for="nickname">닉네임</label>
          <span>*</span>
        </div>
        <div class="input-group-box">
          <input type="text" name="nickname" id="nickname" value="개구쟁이" />
          <button id="nickname-check" @click="nicknameCheck">button</button>
        </div>

        <p style="display: none" id="nicknameCheck-msg" class="msg"></p>
        <div class="label-box">
          <label for="name">이름</label>
          <span>*</span>
        </div>
        <div class="input-group-box-1">
          <input type="text" name="name" id="name" value="고영중" />
        </div>
        <p style="display: none" id="nameCheck-msg" class="msg"></p>
        <div class="label-box">
          <label for="email">이메일</label>
          <span>*</span>
        </div>

        <div class="input-group-box">
          <input
            type="email"
            @keydown.enter.prevent="handleEnter"
            id="email"
            value="rhdudwnd82@naver.com"
          />
          <button id="email-ckeck" @click="emailCheck">Button</button>
        </div>
        <p style="display: none" id="emailCheck-msg" class="msg"></p>

        <div class="label-box">
          <label for="code">인증번호</label>
          <span>*</span>
        </div>

        <div class="input-group-box-1">
          <input
            type="text"
            @keydown.enter.prevent="handleEnter"
            id="code"
            placeholder="인증번호 입력"
          />
        </div>
        <p style="display: none" id="Code-msg" class="msg"></p>

        <div class="update-button-group-container">
          <div class="update-button-group-box">
            <input
              type="button"
              id="backbtn"
              @click="backbtn"
              value="뒤로가기"
            />
            <input
              type="button"
              id="update-my-info"
              @click="updateMyInfo"
              value="정보수정"
            />

            <input
              type="button"
              id="delete-my-info"
              @click="toggleDeleteMyInfoModal"
              value="탈퇴하기"
            />
          </div>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import DeleteMyInfoModal from "../components/DeleteUserModal.vue";

export default {
  name: "UpdateMyInfo",
  data() {
    return {
      userId: "",
      nickname: "",
      email: "",
      name: "",
      deleteMyInfoModal: false,
    };
  },
  components: {
    DeleteMyInfoModal,
  },
  methods: {
    nicknameCheck() {
      const nickname = document.getElementById("nickname").value;
      if (nickname === "") {
        document.getElementById("nicknameCheck-msg").innerHTML =
          "닉네임은 필수 입력 사항입니다.";
        document.getElementById("nicknameCheck-msg").style.display = "block";
        return false;
      }

      axios
        .post(`http://${process.env.BACK_END_URL}/Haru/nicknameCheck`, {
          nickname: nickname,
        })
        .then((res) => {
          if (res.data) {
            alert("사용 가능한 닉네임입니다.");
          } else {
            alert("이미 사용중인 닉네임입니다.");
          }
        })
        .catch((error) => {
          console.error("API 호출 에러:", error);
          return false;
        });
    },

    async emailCheck() {
      const email = document.getElementById("email").value;
      console.log(process.env);
      axios
        .post(`${process.env.VUE_APP_BACK_END_URL}/emailCheck`, {
          email: email,
        })
        .then((res) => {
          if (res == 1) {
            alert("인증 번호가 발송되었습니다.");
          } else {
            alert("이미 등록된 이메일입니다.");
          }
        })
        .catch((error) => {
          alert("인증 번호 발송에 오류가 발생했습니다.");
          console.error("API 호출 에러", error);
          return false;
        });
    },

    handleEnter(event) {
      event.preventDefault();
    },
    submit() {
      const userId = document.getElementById("userId").value;
      const nickname = document.getElementById("nickname").value;
      const email = document.getElementById("email").value;
      const name = document.getElementById("name").value;

      var idRegex = /^[a-zA-Z0-9_]+$/;
      var nicknameRegex = /^[a-zA-Z0-9ㄱ-ㅎ가-힣]+$/;
      var emailRegex = /^[\w-.]+@([\w-]+\.)+[\w-]{2,5}$/;

      if (userId === "") {
        document.getElementById("idCheck-msg").innerText =
          "아이디는 필수 입력 사항입니다.";
        document.getElementById("idCheck-msg").style.display = "block";
      }
      if (nickname === "") {
        document.getElementById("nicknameCheck-msg").innerHTML =
          "닉네임은 필수 입력 사항입니다.";
        document.getElementById("nicknameCheck-msg").style.display = "block";
      } else {
        document.getElementById("nicknameCheck-msg").style.display = "none";
      }
      if (name === "") {
        document.getElementById("nameCheck-msg").innerHTML =
          "이름은 필수 입력 사항입니다.";
        document.getElementById("nameCheck-msg").style.display = "block";
      } else {
        document.getElementById("nameCheck-msg").style.display = "none";
      }
      if (email === "") {
        document.getElementById("emailCheck-msg").innerHTML =
          "이메일은 필수 입력 사항입니다.";
        document.getElementById("emailCheck-msg").style.display = "block";
      } else {
        document.getElementById("emailCheck-msg").style.display = "none";
      }

      if (userId === "" || email === "" || name === "" || nickname === "") {
        return false;
      }

      if (idRegex.test(userId) === false) {
        document.getElementById("userId").focus();
        document.getElementById("idCheck-msg").innerText =
          "아이디는 영문 대소문자와 숫자, _만 사용 가능합니다.";
        document.getElementById("idCheck-msg").style.display = "block";
      } else if (nicknameRegex.test(nickname) === false) {
        alert("닉네임은 한글, 영문 대소문자, 숫자만 사용 가능합니다.");
        document.getElementById("nickname").focus();
      } else if (emailRegex.test(email) === false) {
        alert("이메일 형식이 올바르지 않습니다.");
        document.getElementById("email").focus();
      } else {
        axios
          .post("http://localhost:8090/api/user/signup", {
            userId: userId,
            nickname: nickname,
            email: email,
            name: name,
          })
          .then((res) => {
            if (res.data === 1) {
              alert("회원정보가 변경되어습니다.");
              this.$router.push("/login");
            } else {
              alert("회원정보 변경에 실패했습니다.");
              return false;
            }
          })
          .catch((error) => {
            console.error("API 호출 에러:", error);
            return false;
          });
      }
    },
    backbtn() {
      this.$router.push("/Mypage");
    },
    toggleDeleteMyInfoModal() {
      this.deleteMyInfoModal = !this.deleteMyInfoModal;
    },
  },
};
</script>

<style>
.custom-header .dropbtn {
  color: black;
}

.custom-header .login-ul-box ul li a {
  color: black;
}
</style>

<style scoped>
/* @import url("../css/updateMyInfo.css"); */
</style>
