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
              <img src="../img/writeDiary/darily--unscreen.gif" width="300" />
              <div class="reg-title">
                <h3>지금의 나를 기록해 주세요!</h3>
              </div>
              <div class="reg-desc">
                <p>Tip: 자신의 기분을 자세하게</p>
                <p>기록 할수록 정확도가 올라가요!</p>
              </div>
            </div>
          </div>
          <div class="input-area">
            <div class="input-area-box">
              <div class="darily-date">
                <h2 id="darily-date-h1"></h2>
              </div>
              <div class="diary-title-box">
                <input
                  type="text"
                  name="diary-title"
                  id="diary-title"
                  placeholder="제목"
                  maxlength="30"
                />
              </div>
              <div class="diary-content">
                <textarea
                  name="diary-content"
                  id="diary-content"
                  placeholder="어떤 일이 있었나요?"
                  maxlength="1000"
                ></textarea>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- 다음단계 버튼 필요시 활성화 -->
      <div class="next-button">
        <button id="preStep" onclick="">이전으로</button>
        <button id="analyze" type="submit">분석하기</button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "WriteDiary",
  data() {
    return {};
  },
};
</script>
<style scoped>
@import url("../css/writeDiary.css");
</style>
