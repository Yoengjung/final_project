<template>
  <div class="background-container">
    <div class="container">
      <form
        method="POST"
        autocomplete="off"
        @submit.prevent="onSubmit"
        class="login-form"
      >
        <h2>가입하기</h2>
        <div class="label-box">
          <label for="userId">아이디</label>
          <span>*</span>
        </div>
        <div class="input-group-box">
          <input
            type="text"
            @keydown.enter.prevent="handleEnter"
            id="userId"
            placeholder="아이디 입력"
          />
          <button id="id-check" @click="idCheck">Button</button>
        </div>
        <p style="display: none" id="idCheck-msg" class="msg"></p>
        <div class="label-box">
          <label for="pwd">비밀번호</label><span>*</span>
        </div>
        <div class="input-group-box-1">
          <input
            type="password"
            name="pwd"
            id="pwd"
            placeholder="영문 대문자와 숫자, 특수문자를 포함한 8자리 이상"
          />
        </div>

        <p style="display: none" id="pwd-msg" class="msg"></p>

        <div class="label-box">
          <label for="pwd_check">비밀번호 확인</label><span>*</span>
        </div>
        <div class="input-group-box-1">
          <input
            type="password"
            name="pwd_chk"
            id="pwd_chk"
            placeholder="비밀번호 확인"
          />
        </div>
        <p style="display: none" id="pwd-chk-msg" class="msg"></p>

        <div class="label-box">
          <label for="nickname">닉네임</label>
          <span>*</span>
        </div>
        <div class="input-group-box">
          <input
            type="text"
            name="nickname"
            id="nickname"
            placeholder="한글, 영문 대소문자, 숫자만 사용 가능"
          />
          <button id="nickname-check" @click="nicknameCheck">button</button>
        </div>

        <p style="display: none" id="nicknameCheck-msg" class="msg"></p>
        <div class="label-box">
          <label for="name">이름</label>
          <span>*</span>
        </div>
        <div class="input-group-box-1">
          <input type="text" name="name" id="name" placeholder="이름 입력" />
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
            placeholder="이메일 입력"
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

        <div class="label-box">
          <label for="profile">프로필 사진</label>
        </div>
        <div class="profile-box">
          <img src="../assets/camera_image.png" id="preview-img" />
          <p>사진 끌어다 올리기</p>
          <label for="profile">
            <div class="btn-upload">파일 업로드하기</div>
          </label>
          <input type="file" name="profile" id="profile" />
        </div>
        <div class="termsOfUse-container">
          <p>이용약관 및 개인정보처리방침</p>
          <div class="termsOfUse-box">
            <input type="checkbox" name="termsOfUse" id="termsOfUse" />
            <label for="termsOfUse">[필수]이용약관에 동의</label>
            <button @click="termsOfUseModal">></button>
          </div>
          <div class="termsOfUse-box">
            <input type="checkbox" name="privacyPolicy" id="privacyPolicy" />
            <label for="privacyPolicy">[필수]개인정보처리방침에 동의</label>
            <button @click="privacyPolicyModal">></button>
          </div>
          <div class="btn-group">
            <div class="btn-group-1">
              <button id="back-btn" @click="back">뒤로가기</button>
              <button id="submit-btn" @click="submit">가입하기</button>
            </div>
          </div>
        </div>
      </form>
    </div>
    <!-- 이용약관 모달 -->
    <termsOfUseModal
      :termsOfUseModalOpen="termsOfUseModalOpen"
      @closeModal="closeTermsOfUseModal"
    />
    <!-- 개인정보처리방침 모달 -->
    <privacyPolicyModal
      :modalOpen="modalOpen"
      @closeModal="closePrivacyPolicyModal"
    />
  </div>
</template>
<script>
import axios from "axios";
import termsOfUseModal from "../components/TermsOfUseModal.vue";
import privacyPolicyModal from "../components/PrivacyPolicyModel.vue";

export default {
  name: "SignUp",
  data() {
    return {
      userId: "",
      pwd: "",
      nickname: "",
      email: "",
      name: "",
      profile: "",
      termsOfUseModalOpen: false,
      modalOpen: false,
    };
  },
  components: {
    privacyPolicyModal,
    termsOfUseModal,
  },
  mounted() {},

  methods: {
    back() {
      this.$router.push("/login");
    },
    termsOfUseModal() {
      this.termsOfUseModalOpen = true;
    },
    closeTermsOfUseModal() {
      this.termsOfUseModalOpen = false;
    },
    privacyPolicyModal() {
      this.modalOpen = true;
    },
    closePrivacyPolicyModal() {
      this.modalOpen = false;
    },

<<<<<<< HEAD
    idCheck() {
=======
    async idCheck() {
>>>>>>> origin/Li-Yj
      var idRegex = /^[a-zA-Z0-9_]+$/;
      const userId = document.getElementById("userId").value;
      if (userId === "") {
        document.getElementById("idCheck-msg").innerText =
          "아이디는 필수 입력 사항입니다.";
        document.getElementById("idCheck-msg").style.display = "block";
        document.getElementById("userId").focus();
        return false;
      } else if (!idRegex.test(userId)) {
        document.getElementById("idCheck-msg").innerText =
          "아이디는 영문 대소문자와 숫자, _만 사용 가능합니다.";
        document.getElementById("idCheck-msg").style.display = "block";
        document.getElementById("userId").focus();
        return false;
      }
      axios
        .get(`http://localhost/Haru/${userId}/userId`)
        .then((res) => {
          console.log(res);
          if (res.data) {
            document.getElementById("idCheck-msg").innerText =
              "이미 사용중인 아이디입니다.";
            document.getElementById("idCheck-msg").style.display = "block";
            document.getElementById("userId").focus();
            return false;
          } else {
            document.getElementById("idCheck-msg").innerText =
              "사용 가능한 아이디입니다.";
            document.getElementById("idCheck-msg").style.display = "block";
          }
        })
        .catch((error) => {
          console.error("API 호출 에러:", error);
          return false;
        });
    },

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
      const pwd = document.getElementById("pwd").value;
      const pwd_chk = document.getElementById("pwd_chk").value;
      const nickname = document.getElementById("nickname").value;
      const email = document.getElementById("email").value;
      const name = document.getElementById("name").value;

      var idRegex = /^[a-zA-Z0-9_]+$/;
      var pwdRegex = /^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*[a-zA-Z]).{8,}$/;
      var nicknameRegex = /^[a-zA-Z0-9ㄱ-ㅎ가-힣]+$/;
      var emailRegex = /^[\w-.]+@([\w-]+\.)+[\w-]{2,5}$/;

      if (userId === "") {
        document.getElementById("idCheck-msg").innerText =
          "아이디는 필수 입력 사항입니다.";
        document.getElementById("idCheck-msg").style.display = "block";
      }
      if (pwd === "") {
        document.getElementById("pwd-msg").innerHTML =
          "비밀번호는 영문 대문자와 숫자, 특수문자를 포함한 8자리 이상이어야 합니다.";
        document.getElementById("pwd-msg").style.display = "block";
      } else {
        document.getElementById("pwd-msg").style.display = "none";
      }
      if (pwd_chk !== pwd || pwd_chk === "") {
        document.getElementById("pwd-chk-msg").innerHTML =
          "비밀번호가 일치하지 않습니다.";
        document.getElementById("pwd-chk-msg").style.display = "block";
      } else {
        document.getElementById("pwd-chk-msg").style.display = "none";
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

      if (
        userId === "" ||
        pwd === "" ||
        pwd_chk === "" ||
        email === "" ||
        name === "" ||
        nickname === ""
      ) {
        return false;
      }

      if (idRegex.test(userId) === false) {
        document.getElementById("userId").focus();
        document.getElementById("idCheck-msg").innerText =
          "아이디는 영문 대소문자와 숫자, _만 사용 가능합니다.";
        document.getElementById("idCheck-msg").style.display = "block";
      } else if (pwdRegex.test(pwd) == false) {
        document.getElementById("pwdCheck-msg").innerHTML =
          "비밀번호는 영문 대문자와 숫자, 특수문자를 포함한 8자리 이상이어야 합니다.";
        document.getElementById("pwdCheck-msg").style.display = "block";
        document.getElementById("pwd").focus();
      } else if (pwd !== pwd_chk) {
        alert("비밀번호가 일치하지 않습니다.");
        document.getElementById("pwd_chk").focus();
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
            pwd: pwd,
            nickname: nickname,
            email: email,
            name: name,
          })
          .then((res) => {
            if (res.data === 1) {
              alert("회원가입이 완료되었습니다.");
              this.$router.push("/login");
            } else {
              alert("회원가입에 실패하였습니다.");
              return false;
            }
          })
          .catch((error) => {
            console.error("API 호출 에러:", error);
            return false;
          });
      }
    },
    previewImage(event) {
      const reader = new FileReader();
      const image = event.target.files[0];
      reader.readAsDataURL(image);
      reader.onload = (event) => {
        this.profile = event.target.result;
      };
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
@import url("../css/signup.css");
</style>
