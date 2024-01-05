<template>
  <div class="faceReg-container">
    <div class="container-2">
      <div class="reg-card">
        <div class="pro-bar">
          <StressBar />
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
          <button id="analyze" type="submit">다음단계</button>
        </div>
      </div>
      <warnFaceModal :modal_Check="isModalVisible" @hide-modal="hideModal" />
    </div>
  </div>
</template>
<script>
import StressBar from "@/components/StressBar.vue";
import WarnFaceModal from "../components/WarnFaceModal";

export default {
  name: "Faceregistration",
  components: {
    StressBar,
    WarnFaceModal,
  },
  data() {
    return {
      file_name: "",
      isModalVisible: true,
    };
  },
  methods: {
    hideModal() {
      this.isModalVisible = false; // 모달을 숨김
    },
  },
};
</script>
<style scoped>
@import "../css/faceRegistration.css";
</style>
