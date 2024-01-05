<template>
  <div class="container-1">
    <div class="reg-card">
      <div class="pro-bar">
        <!-- 진행바 시작-->
        <ul>
          <li>
            <i class="icons awesome fa-solid fa-user active"></i>
            <div class="step first">
              <p>1</p>
              <i class="awesome fa-solid fa-check"></i>
            </div>
            <p class="label">사진올리기</p>
          </li>
          <li>
            <i class="icons awesome fa-solid fa-coins"></i>
            <div class="step second">
              <p>2</p>
              <i class="awesome fa-solid fa-check"></i>
            </div>
            <p class="label">내 기분 쓰기</p>
          </li>
          <li>
            <i class="icons awesome fa-solid fa-house"></i>
            <div class="step third">
              <p>3</p>
              <i class="awesome fa-solid fa-check"></i>
            </div>
            <p class="label">내 스트레스 분석</p>
          </li>
          <li>
            <i class="icons awesome fa-regular fa-star-half-stroke"></i>
            <div class="step fourth">
              <p>4</p>
              s
              <i class="awesome fa-solid fa-check"></i>
            </div>
            <p class="label">완료!</p>
          </li>
        </ul>
        <!-- 진행바 끝-->
      </div>
      <div class="fake-div">
        <div class="reg-box-card">
          <div class="reg-info">
            <div class="reg-info-box">
              <img
                src="../img/FaceRegistration/image3-unscreen.gif"
                width="200"
              />
              <div class="reg-title">
                <h3>지금의 나를 남겨주세요!</h3>
              </div>
              <div class="reg-desc">
                <p>Tip: 얼굴은 정면이 보여야</p>
                <p>인식 확률이 올라갑니다!</p>
              </div>
            </div>
          </div>
          <div class="input-area">
            <div class="upload-area">
              <div class="upload-area-container">
                <div class="upload-area-box1">
                  <img src="../img/FaceRegistration/camera.png" />
                </div>
                <div class="upload-area-box2">
                  <span>끌어서 사진 올려 놓기!</span>
                </div>
                <div class="upload-area-box3">
                  <button id="upload-btn">얼굴 등록하기</button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- 다음단계 버튼 필요시 활성화 -->
      <div class="next-button">
        <!-- <button id="analyze" type="submit">다음단계</button> -->
        <a id="analyze" href="/DiaryRegistration">다음단계</a>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "Faceregistration",
  data() {
    return {
      file_name: "",
      model_Check: false,
    };
  },
  methods: {
    getFileName(event) {
      this.file_name = event.target.files[0].name;
    },
    modal_click() {
      this.modal_Check = !this.model_Check;
    },
  },
};
</script>
<style scoped>
@import "../css/faceRegistration.css";
</style>
