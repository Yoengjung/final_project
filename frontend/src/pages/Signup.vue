<template>
  <div class="signup-container">
    <form method="POST" autocomplete="off" @submit.prevent="onSubmit">
      <h2>회원가입</h2>
      <div class="label-box">
        <label for="userId">아이디</label>
        <span>*</span>
      </div>
      <div class="input-group-box">
        <input type="text" @keydown.enter.prevent="handleEnter" id="userId" />
        <button id="id-check" @click="idCheck">Button</button>
      </div>
      <p style="display: none" id="idCheck-msg"></p>
      <div class="label-box">
        <label for="pwd">비밀번호</label><span>*</span>
      </div>
      <div class="input-group-box-1">
        <input type="password" name="pwd" id="pwd" />
      </div>

      <p style="display: none" id="pwd-msg"></p>

      <div class="label-box">
        <label for="pwd_check">비밀번호 확인</label><span>*</span>
      </div>
      <div class="input-group-box-1">
        <input type="password" name="pwd_chk" id="pwd_chk" />
      </div>
      <p style="display: none" id="pwd-chk-msg"></p>

      <div class="label-box">
        <label for="nickname">닉네임</label>
        <span>*</span>
      </div>
      <div class="input-group-box-1">
        <input type="text" name="nickname" id="nickname" />
      </div>
      <p style="display: none" id="nicknameCheck-msg"></p>
      <div class="label-box">
        <label for="name">이름</label>
        <span>*</span>
      </div>
      <div class="input-group-box-1">
        <input type="text" name="name" id="name" />
      </div>
      <p style="display: none" id="nameCheck-msg"></p>
      <div class="label-box">
        <label for="email">이메일</label>
        <span>*</span>
      </div>

      <div class="input-group-box">
        <input type="text" @keydown.enter.prevent="handleEnter" id="email" />
        <button id="email-ckeck">Button</button>
      </div>
      <p style="display: none" id="emailCheck-msg"></p>

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
      <button id="submit-btn" @click="submit">회원가입</button>
    </form>
  </div>
</template>
<script>
import axios from "axios";

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
    };
  },
  mounted() {},
  methods: {
    idCheck() {
      var idRegex = /^[a-zA-Z0-9_]+$/;
      const userid = document.getElementById("userId").value;
      if (userid === "") {
        document.getElementById("idCheck-msg").innerText =
          "아이디는 필수 입력 사항입니다.";
        document.getElementById("idCheck-msg").style.display = "block";
        document.getElementById("userId").focus();
        return false;
      } else if (!idRegex.test(userid)) {
        document.getElementById("idCheck-msg").innerText =
          "아이디는 영문 대소문자와 숫자, _만 사용 가능합니다.";
        document.getElementById("idCheck-msg").style.display = "block";
        document.getElementById("userId").focus();
        return false;
      }
      axios
        .get("http://localhost:8090/api/user/idCheck", {
          params: {
            userId: userid,
          },
        })
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
            return true;
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

<style scoped>
body {
  background-image: url("../assets/login_bg.png");
  background-repeat: no-repeat;
  background-size: cover;
}
.signup-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  position: absolute;
  top: -1px;
  z-index: -1;
}

form {
  display: flex;
  position: relative;
  flex-direction: column;
  width: 600px;
  padding: 70px;
  top: 100px;
  border-radius: 21px;
  background-color: rgba(255, 255, 255, 0.3);
}

form h2 {
  text-align: center;
  color: #efab90;
}
form .label-box {
  display: flex;
  flex-direction: row;
}

form .label-box label {
  color: #efab90;
}

form .input-group-box {
  display: flex;
  flex-direction: row;
  background-color: white;
  height: 40px;
  border-radius: 49px;
  justify-content: space-between;
  align-items: center;
}

form .input-group-box-1 {
  display: flex;
  flex-direction: row;
  background-color: white;
  height: 40px;
  border-radius: 49px;
  justify-content: space-between;
  align-items: center;
}

form .input-group-box-1 input {
  width: 95%;
  background-color: white;
  border: none;
  border-radius: 49px;
  padding-left: 20px;
  margin-left: 10px;
}

form .input-group-box button {
  position: relative;
  width: 100px;
  height: 80%;
  border-radius: 49px;
  right: 3px;
  background-color: white;
  border: 1px solid #cfcfcf;
}

form input {
  width: 70%;
  background-color: white;
  border: none;
  border-radius: 49px;
  padding-left: 20px;
  margin-left: 10px;
}

form button {
  position: relative;
  border-radius: 49px;
}

label {
  display: flex;
  flex-direction: row;
  margin-top: 10px;
  margin-bottom: 10px;
}

span {
  color: red;
}

.profile-box {
  width: 250px;
  height: 250px;
  border: 3px dotted #e99571;
  border-radius: 49px;
}

.profile-box #preview-img {
  position: relative;
  left: 50%;
  transform: translateX(-50%);
  top: 30px;
}

.profile-box p {
  position: relative;
  text-align: center;
  top: 30px;
  font-size: 20px;
  color: #747474;
  margin: 0px;
}

.btn-upload {
  position: relative;
  width: 150px;
  height: 30px;
  background: #fff;
  border: 1px solid rgb(77, 77, 77);
  border-radius: 10px;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  left: 50%;
  transform: translateX(-50%);
  top: 30px;
}

#profile {
  display: none;
}

#submit-btn {
  width: 100px;
  background-color: #83aeee;
  color: white;
  border: none;
  height: 40px;
  left: 50%;
  transform: translateX(-50%);
  margin-top: 30px;
}
</style>
