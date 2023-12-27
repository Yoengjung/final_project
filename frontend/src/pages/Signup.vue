<template>
  <div class="signup-container">
    <form method="POST" autocomplete="off" @submit.prevent="onSubmit">
      <div class="label-box">
        <label for="userId">아이디</label>
        <span>*</span>
      </div>
      <input
        type="text"
        name="userId"
        id="userId"
        @keydown.enter.prevent="handleEnter"
      />
      <p style="display: none" id="idCheck-msg"></p>
      <button id="id-check" @click="idCheck">아이디 중복 확인</button>
      <div class="label-box">
        <label for="pwd">비밀번호</label><span>*</span>
      </div>
      <input type="password" name="pwd" id="pwd" />
      <p style="display: none" id="pwd-msg"></p>

      <div class="label-box">
        <label for="pwd_check">비밀번호 확인</label><span>*</span>
      </div>
      <input type="password" name="pwd_chk" id="pwd_chk" />
      <p style="display: none" id="pwd-chk-msg"></p>

      <div class="label-box">
        <label for="nickname">닉네임</label>
        <span>*</span>
      </div>
      <input type="text" name="nickname" id="nickname" />

      <div class="label-box">
        <label for="email">이메일</label>
        <span>*</span>
      </div>
      <input type="text" name="email" id="email" />
      <p style="display: none" id="emailCheck-msg"></p>
      <button id="email-ckeck">이메일 체크</button>

      <div class="label-box">
        <label for="name">이름</label>
      </div>
      <input type="text" name="name" id="name" />

      <div class="label-box">
        <label for="birth">생년월일</label>
      </div>
      <div class="birth-info">
        <select class="box" id="birth-year">
          <option selected>출생 연도</option>
        </select>
        <select class="box" id="birth-month">
          <option selected>월</option>
        </select>
        <select class="box" id="birth-day">
          <option selected>일</option>
        </select>
      </div>

      <div class="label-box">
        <label for="address">주소</label>
      </div>
      <input type="text" name="address" id="address" />

      <div class="label-box">
        <label for="phone">전화번호</label>
      </div>
      <input type="text" name="phone" id="phone" />

      <div class="label-box">
        <label for="profile">프로필</label>
      </div>
      <input
        type="file"
        name="profile"
        id="profile"
        hidden
        @change="previewImage($event)"
      />
      <img :src="profile" />
      <button @click="submit">회원가입</button>
    </form>
  </div>
</template>
<script>
import axios from "axios";

export default {
  name: "SignUp",
  data() {
    return {
      userid: "",
      pwd: "",
      nickname: "",
      email: "",
      name: "",
      birth_year: "",
      birth_month: "",
      birth_day: "",
      address: "",
      phone: "",
      profile: "",
    };
  },
  mounted() {
    const year = document.getElementById("birth-year");
    const month = document.getElementById("birth-month");
    const day = document.getElementById("birth-day");

    for (let i = 2021; i >= 1900; i--) {
      const option = document.createElement("option");
      option.value = i;
      option.innerText = i;
      year.appendChild(option);
    }

    for (let i = 1; i <= 12; i++) {
      const option = document.createElement("option");
      option.value = i;
      option.innerText = i;
      month.appendChild(option);
    }

    for (let i = 1; i <= 31; i++) {
      const option = document.createElement("option");
      option.value = i;
      option.innerText = i;
      day.appendChild(option);
    }
  },
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
        .get("http://localhost:8082/api/user/idCheck", {
          params: {
            userid: userid,
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
      const birth_year = document.getElementById("birth-year").value;
      const birth_month = document.getElementById("birth-month").value;
      const birth_day = document.getElementById("birth-day").value;
      const address = document.getElementById("address").value;
      const phone = document.getElementById("phone").value;

      var idRegex = /^[a-zA-Z0-9_]+$/;
      var pwdRegex = /^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*[a-zA-Z]).{8,}$/;
      var nicknameRegex = /^[a-zA-Z0-9ㄱ-ㅎ가-힣]+$/;
      var emailRegex = /^[\w-.]+@([\w-]+\.)+[\w-]{2,5}$/;

      if (userId === "") {
        document.getElementById("userId").focus();
        document.getElementById("idCheck-msg").innerText =
          "아이디는 필수 입력 사항입니다.";
        document.getElementById("idCheck-msg").style.display = "block";
      }
      if (pwd === "") {
        document.getElementById("pwd").focus();
        document.getElementById("pwd-msg").innerHTML =
          "비밀번호는 영문 대문자와 숫자, 특수문자를 포함한 8자리 이상이어야 합니다.";
        document.getElementById("pwd-msg").style.display = "block";
      }
      if (pwd_chk === pwd) {
        document.getElementById("pwd-chk-msg").focus();
        document.getElementById("pwd-chk-msg").innerHTML =
          "비밀번호가 일치하지 않습니다.";
        document.getElementById("pwd-chk-msg").style.display = "block";
      }
      if (email === "") {
        document.getElementById("email").focus();
        document.getElementById("emailCheck-msg").innerHTML =
          "이메일은 필수 입력 사항입니다.";
      }

      if (idRegex.test(userId) === false) {
        document.getElementById("userId").focus();
        document.getElementById("idCheck-msg").innerText =
          "아이디는 영문 대소문자와 숫자, _만 사용 가능합니다.";
        document.getElementById("idCheck-msg").style.display = "block";
        return false;
      }
      if (pwd === "") {
        document.getElementById("pwdCheck-msg").innerHTML =
          "비밀번호는 영문 대문자와 숫자, 특수문자를 포함한 8자리 이상이어야 합니다.";
        document.getElementById("pwdCheck-msg").style.display = "block";
        return false;
      } else if (pwdRegex.test(pwd) == false) {
        document.getElementById("pwdCheck-msg").innerHTML =
          "비밀번호는 영문 대문자와 숫자, 특수문자를 포함한 8자리 이상이어야 합니다.";
        document.getElementById("pwdCheck-msg").style.display = "block";
        document.getElementById("pwd").focus();
        return false;
      } else if (pwd !== pwd_chk) {
        alert("비밀번호가 일치하지 않습니다.");
        document.getElementById("pwd_chk").focus();
        return false;
      } else if (pwd_chk === "") {
        alert("비밀번호 확인을 입력해주세요.");
        document.getElementById("pwd_chk").focus();
        return false;
      } else if (nickname === "") {
        alert("닉네임을 입력해주세요.");
        document.getElementById("nickname").focus();
        return false;
      } else if (nicknameRegex.test(nickname) === false) {
        alert("닉네임은 한글, 영문 대소문자, 숫자만 사용 가능합니다.");
        document.getElementById("nickname").focus();
        return false;
      } else if (email === "") {
        alert("이메일을 입력해주세요.");
        document.getElementById("email").focus();
        return false;
      } else if (emailRegex.test(email) === false) {
        alert("이메일 형식이 올바르지 않습니다.");
        document.getElementById("email").focus();
        return false;
      } else if (name === "") {
        alert("이름을 입력해주세요.");
        document.getElementById("name").focus();
        return false;
      } else if (
        birth_year === "출생 연도" ||
        birth_month === "월" ||
        birth_day === "일"
      ) {
        alert("생년월일을 입력해주세요.");
        return false;
      } else if (address === "") {
        alert("주소를 입력해주세요.");
        document.getElementById("address").focus();
        return false;
      } else if (phone === "") {
        alert("전화번호를 입력해주세요.");
        document.getElementById("phone").focus();
        return false;
      } else {
        const birth = `${birth_year}-${birth_month}-${birth_day}`;
        axios
          .post("http://localhost:8090/api/user/signup", {
            userId: userId,
            pwd: pwd,
            nickname: nickname,
            email: email,
            name: name,
            birth: birth,
            address: address,
            phone: phone,
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
.signup-container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100vh;
  position: absolute;
  background-image: url("");
  background-repeat: no-repeat;
  background-size: cover;
}

form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
label {
  display: flex;
  flex-direction: row;
  margin-top: 10px;
  margin-bottom: 10px;
}
form .label-box {
  display: flex;
  flex-direction: row;
}
span {
  color: red;
}
</style>
