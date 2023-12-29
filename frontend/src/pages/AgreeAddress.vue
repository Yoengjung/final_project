<template>
  <div class="agreeAddress-container">
    <div class="agree-box">
      <h2>이용약관 및 개인정보처리방침</h2>
      <input
        type="checkbox"
        id="allCheck"
        v-model="allChecked"
        @change="checkAll"
      />
      <label id="allCheck-label">전체선택</label>
      <div class="agree-box-1">
        <div class="agree-checkbox">
          <input type="checkbox" id="agree1" v-model="checkboxs[0]" />
          <label for="agree1">이용약관 동의</label>
          <label style="color: red">[필수]</label>
        </div>
        <div class="agree-content">
          <text>
            1. 서비스 내용 <br /><br />1.1 하루의 여울은 얼굴 사진 촬영 및 저장,
            일기 작성, 기분 척도 사용으로 사용자의 스트레스 수치를 평가하고,
            해당 수치에 따라 사용자에게 위치 추천 서비스를 제공합니다. <br />1.2
            사용자가 촬영한 얼굴 사진 및 일기는 개인 공간에 안전하게 보관되며,
            스트레스 수치 평가 및 추천 서비스 제공을 위한 용도로만 활용됩니다.
            <br /><br />2. 사용자 권리 및 책임 <br /><br />2.1 사용자는 얼굴
            사진 및 개인 정보의 수집, 저장, 활용에 대한 동의를 제공해야 하며,
            이에 대한 정보 활용 범위 및 목적을 충분히 이해해야 합니다. <br />2.2
            사용자는 언제든지 얼굴 사진 및 일기의 삭제, 변경, 열람 등을 요청할
            수 있으며, 관련된 권리와 책임을 갖습니다. <br /><br />3. 보안 및
            개인정보 보호 <br /><br />3.1 하루의 여울은 사용자 정보를 안전하게
            보호하기 위해 최선의 노력을 다하며, 개인정보 보호 관련 법률 및
            규정을 엄격히 준수합니다. <br />3.2 사용자의 얼굴 사진 및 개인
            정보는 외부로 유출되지 않으며, 제3자에게 판매, 양도, 공유되지
            않습니다. <br /><br />4. 서비스 이용 시 주의사항 <br /><br />4.1
            하루의 여울은 사용자의 스트레스 수치를 측정하여 적절한 장소를
            추천해주지만, 의료적 상담이나 진단을 대체할 수 없음을 알려드립니다.
            <br />4.2 스트레스 수치가 일정 기간 동안 높게 나타날 경우, 병원을
            방문하여 전문적인 의료 상담을 받는 것을 권장합니다.
          </text>
        </div>
        <div class="agree-checkbox">
          <input type="checkbox" id="agree1" v-model="checkboxs[1]" />
          <label for="agree1">개인정보 수집 및 이용 </label>
          <label style="color: red">[필수]</label>
        </div>
        <div class="agree-content">
          <text>
            1. 수집하는 개인정보 항목 및 수집 목적 <br /><br />1.1. 수집하는
            개인정보 항목 이름, 이메일 주소, 연락처, 프로필 사진 등 회원가입 시
            제공된 정보 기기 정보, 쿠키, IP 주소, 이용 기록, 서비스 이용 시간 등
            서비스 이용과 관련된 정보 <br />1.2. 개인정보 수집 목적 회원 관리 및
            서비스 제공 이용자 식별 및 본인 확인 서비스 이용에 따른 맞춤형
            콘텐츠 제공 서비스 개선 및 안전한 서비스 제공을 위한 기록 보존
            <br />2. 개인정보의 이용 <br /><br />2.1. 개인정보의 이용 회원 관리,
            서비스 제공 및 개선 이벤트 및 마케팅 활동 고객 상담 및 문의 응답<br />
            3. 개인정보의 제공 및 공유<br /><br />
            3.1. 개인정보의 제공 및 공유 서비스 제공을 위한 업체와의 협력
            (이용자 동의를 받은 경우) 법적 요구에 따른 경우 또는 법률에 규정된
            절차에 따라 정보 제공<br />
            4. 개인정보 보유 및 기간 <br /><br />4.1. 개인정보 보유 및 기간
            서비스 제공을 위한 필요 기간 동안에 한해 개인정보를 보유 및 이용
            회원 탈퇴 시 또는 정보 수집 및 이용 목적 달성 시 지체 없이 파기
            <br />5. 개인정보의 안전성과 보호조치 <br /><br />5.1. 개인정보의
            안전성과 보호조치 개인정보의 암호화 해킹, 유출, 변조 등으로부터
            개인정보를 보호하기 위한 기술적, 관리적 대책<br />
            6. 사용자의 권리<br /><br />
            6.1. 사용자의 권리 개인정보 열람, 정정, 삭제 요청 가능 개인정보 수집
            및 이용에 대한 동의 철회 가능<br />
            7. 기타 <br /><br />7.1. 기타 본 약관은 수시로 변경될 수 있으며,
            변경 시 사전 공지 예정
          </text>
        </div>
        <div class="agree-checkbox">
          <input type="checkbox" id="agree1" v-model="checkboxs[2]" />
          <label for="agree1">개인정보 제 3자 제공 동의</label>
          <label style="color: red">[필수]</label>
        </div>
        <div class="agree-content">
          <text>
            [개인 정보 제 3자 제공 동의 약관] 정의 및 목적 본 개인 정보 제 3자
            제공 동의 약관(이하 '약관')은 하루의 여울(이하 '서비스')을 이용하는
            개인 정보 주체(이하 '이용자')가 제공하는 개인 정보를 외부 제 3자에게
            제공하는 경우 이에 대한 동의 절차 및 내용에 대해 규정합니다. 개인
            정보의 제공 대상 이용자의 개인 정보 중 서비스 제공을 위해 필요한
            일부 정보는 다음과 같은 대상에게 제공될 수 있습니다: 협력 업체:
            서비스 제공, 기술 지원 등의 목적을 위해 서비스 운영에 협력하는 업체
            법적 의무: 관련 법령 및 규정에 따라 법적인 요구가 있는 경우 관련
            기관에 정보를 제공할 수 있습니다. 제공하는 개인 정보의 항목 서비스를
            이용하는 동안 회사는 다음과 같은 개인 정보를 수집 및 이용할 수
            있습니다: 개인 식별 정보: 이름, 연락처, 이메일 주소 등 서비스 이용
            기록: 로그 데이터, 쿠키, 기기 정보 등 개인 정보 제공의 목적 회사는
            제공된 개인 정보를 다음과 같은 목적으로 이용할 수 있습니다: 서비스
            제공 및 운영 이벤트, 프로모션, 마케팅 등의 목적으로 활용 개인 정보
            제공의 기간 제공된 개인 정보는 목적 달성 시까지 제공되며, 목적 달성
            이후에는 즉시 파기됩니다. 이용자의 동의 철회 이용자는 언제든지
            동의를 철회할 수 있으며, 이 경우 추가적인 정보 제공을 거부할 권리가
            있습니다. 기타 사항 본 약관에 명시되지 않은 사항은 관련 법령 및
            서비스 이용 약관 등을 따릅니다.</text
          >
        </div>
        <div class="btn_group">
          <button id="back-btn" @click="back">뒤로가기</button>
          <button id="signup-btn" @click="signup">회원가입</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "AgreeAddress",
  data() {
    return {
      allChecked: false,
      checkboxs: [false, false, false],
    };
  },
  methods: {
    back() {
      this.$router.push("/login");
    },
    signup() {
      if (this.checkboxs[0] && this.checkboxs[1] && this.checkboxs[2]) {
        this.$router.push("/signup");
      } else {
        alert("필수 약관에 동의해주세요.");
      }
    },
    checkAll() {
      this.checkboxs = this.checkboxs.map(() => this.allChecked);
    },
  },
};
</script>
<style>
body {
  background-image: url("../assets/login_bg.png");
  background-repeat: no-repeat;
  background-size: cover;
  background-attachment: fixed;
}
.custom-header .dropbtn {
  color: black;
}

.custom-header .login-ul-box ul li a {
  color: black;
}

.agreeAddress-container {
  display: flex;
  width: 100%;
  height: 120vh;
  position: absolute;
  background-repeat: no-repeat;
  background-size: cover;
  top: -1px;
  z-index: -1;
}

.agree-box {
  position: relative;
  top: 10%;
  width: 700px;
  height: 600px;
  left: 50%;
  transform: translateX(-50%);
}

#allCheck-label {
  margin-top: 20px;
  margin-left: 10px;
}

.agree-checkbox label {
  margin-top: 20px;
  margin-left: 10px;
}

.agree-content {
  background-color: white;
  height: 300px;
  overflow-y: scroll;
  padding: 10px;
}

.btn_group {
  position: relative;
  margin-top: 30px;
  width: 400px;
  text-align: center;
  left: 50%;
  transform: translateX(-50%);
}

.btn_group button {
  margin: 0px;
  padding: 0pxl;
  width: 150px;
  height: 40px;
  margin-left: 10px;
  border-radius: 10px;
  border: none;
  background-color: #f5f5f5;
  color: black;
}

#back-btn {
  background-color: #cfcfcf;
  color: #757575;
  margin-bottom: 100px;
}

#signup-btn {
  color: white;
  background-color: #d97979;
  margin-bottom: 100px;
}
</style>
