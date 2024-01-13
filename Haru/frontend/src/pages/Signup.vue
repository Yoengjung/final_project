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
          <div v-for="file in files" :key="file.name">
            <img src="file.preview" id="preview-img" style="width:100px" />
        </div>
          <p>사진 끌어다 올리기</p>
          <label for="profile-1"></label>
            <div class="btn-upload">파일 업로드하기</div>
            <input type="file" name="profile-1" id="profile-1"
                   @change="selectFile" multiple accept="image/*" ref="fileRef"/>
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
      files:[], // 파일을 저장하는 배열
      formData: null, // FormData 객체 초기화
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
    selectFile(event){
      //파일 선택시 초기화 해줘야 선택한 파일만 files에 들어 가기 때문이다.
      this.files = [];
      // const form Data = new FormData();
      const selectedFiles = event.target.files;
      for (let i = 0; i < selectedFiles. Length; i++) {
        const file = selectedFiles[i];
        // 미리보기 URL 생성
        const preview = URL.createObjectURL(file);
        // 파일 정보와 미리보기 URL을 files 배열에 추가
        this.files.push({
          name: file.name,
          preview: preview,
        });
        // 업로드할 파일은 FormData에 추가
        this. formData.append('files', file);
      }
    },
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

    async idCheck() {
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

    handleEnter(event) {
      event.preventDefault();
    },
    //모든 데이터를 입력후 가입 버튼을 클릭 했을 때
    submit() {
      const userId = document.getElementById("userId").value;
      const pwd = document.getElementById("pwd").value;
      const nickname = document.getElementById("nickname").value;
      const email = document.getElementById("email").value;
      const name = document.getElementById("name").value;
      // Add additional data to formData
      this.formData.append('userId', userId);
      this.formData.append('pwd', pwd);
      this.formData.append('nickname', nickname);
      this.formData.append('email', email);
      this.formData.append('name', name);
      axios
          .post("http://localhost:8090/api/user/signup", this.formData,
              {
                headers: {'Content-Type': 'multipart/form-data',},
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