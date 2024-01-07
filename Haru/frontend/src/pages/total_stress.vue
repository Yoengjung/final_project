<template>
  <div class="result-container">
    <!-- 진행바 시작-->
    <ul class="pross-bar-ul">
      <li class="pross-bar-li">
        <i class="icons awesome fa-solid fa-user active"></i>
        <div class="step first">
          <p>1</p>
          <i class="awesome fa-solid fa-check"></i>
        </div>
        <p class="label">사진올리기</p>
      </li>
      <li class="pross-bar-li">
        <i class="icons awesome fa-solid fa-coins"></i>
        <div class="step second">
          <p>2</p>
          <i class="awesome fa-solid fa-check"></i>
        </div>
        <p class="label">내 기분 쓰기</p>
      </li>
      <li class="pross-bar-li">
        <i class="icons awesome fa-solid fa-house"></i>
        <div class="step third">
          <p>3</p>
          <i class="awesome fa-solid fa-check"></i>
        </div>
        <p class="label">내 스트레스 분석</p>
      </li>
      <li class="pross-bar-li">
        <i class="icons awesome fa-regular fa-star-half-stroke"></i>
        <div class="step fourth">
          <p>4</p>
          <i class="awesome fa-solid fa-check"></i>
        </div>
        <p class="label">완료!</p>
      </li>
    </ul>
    <!-- 진행바 끝-->

    <!-- 결과 시작-->
    <div class="result-card-container">
      <div class="result-card-box">
        <div class="stress-area">
          <div class="result-comment">
            이범석님의 스트레스 수치는 <span class="badge rounded-pill bg-danger custom-bedge">정상</span> 입니다.
          </div>
          <!-- 스트레스 수치 바 시작 -->
          <div class="rating-bar">
            <div class="slider">
              <div class="slider-bar">
                <ul class="rate-ul">
                  <li class="rate-li"></li>
                  <li class="rate-li">
                    <span class="pourcentage">10%</span>
                  </li>
                  <li class="rate-li">
                    <span class="pourcentage">20%</span>
                  </li>
                  <li class="rate-li">
                    <span class="pourcentage">30%</span>
                    <span class="fourchette stress-nomal">정상</span>
                  </li>
                  <li class="rate-li">
                    <span class="pourcentage">40%</span>
                  </li>
                  <li class="rate-li">
                    <span class="pourcentage">50%</span>
                  </li>
                  <li class="rate-li">
                    <span class="pourcentage">60%</span>
                    <span class="fourchette stress-warning">주의</span>
                  </li>
                  <li class="rate-li">
                    <span class="pourcentage">70%</span>
                  </li>
                  <li class="rate-li">
                    <span class="pourcentage">80%</span>
                    <span class="fourchette stress-danger">심각</span>
                  </li>
                  <li class="rate-li">
                    <span class="pourcentage">90%</span>
                  </li>
                </ul>
                <div class="slider-scroll">
                  <div>
                    스트레스 수치
                    <span id="stress-rate">0 %</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- 스트레스 수치 바 끝 -->
        <!-- 장소추천 영역 시작 -->
        <div class="recomend-area">
          <div class="recomend-area-box">
            <div class="recomend-comment">
              <span>이범석님의 스트레스 수치로 ‘하루의 여울’이 추천한 장소에요.</span>
            </div>
            <div class="recomend-button">
              <img id="scroll-left-button" class="recomend-btn-el" src="../img/Total_stress/img/left.png">
              <img id="scroll-right-button" class="recomend-btn-el" src="../img/Total_stress/img/right.png">
            </div>
          </div>
          <!-- 장소보여주기 -->
          <div class="recomend-place">
            <div class="place-card">
              <div class="'food-img">
                <img class="heart-img"  src="../img/Total_stress/img/image 47.png">
                <img src="../img/Total_stress/food/buger.jpg" alt="버거킹" class="place-card">
              </div>
              <div class="food-desc">
                <div class="food-desc-box">
                  <div class="food-title">
                    <h4>버거킹 신논현역점</h4>
                  </div>
                  <div class="hash-tag">
                    <span class="badge rounded-pill bg-success hash-tag-bedge">#푸드</span>
                    <span class="badge rounded-pill bg-success hash-tag-bedge">#맛집</span>
                    <span class="badge rounded-pill bg-success hash-tag-bedge">#불고기</span>
                  </div>
                  <div class="food-detail">
                    <span class="food-address">주소: 부산광역시 강서구 녹산산단382로14번가길 10~29번지(송정동)</span>
                  </div>
                </div>
              </div>
            </div>
            <div class="place-card">
              <img src="../img/Total_stress/food/duck.jpg" alt="버거킹" class="place-card">
            </div>
            <div class="place-card">
              <img src="../img/Total_stress/food/mega.jpg" alt="버거킹" class="place-card">
            </div>
            <div class="place-card">
              <img src="../img/Total_stress/food/starbucks.jpg" alt="버거킹" class="place-card">
            </div>
            <div class="place-card">
              <img src="../img/Total_stress/food/wf.jpg" alt="버거킹" class="place-card">
            </div>
          </div>
          <!-- 장소보여주기 끝 -->
        </div>
        <div class="step-btn">
          <div>
            <button class="step-btn" id="prev-button"><span>이전 추천 리스트</span></button>
          </div>
          <div>
            <button class="step-btn" id="next-button"><span>나의 스트레스 보고서</span></button>
          </div>
          <div>
            <button class="step-btn" id="main-button"><span>메인으로 이동</span></button>
          </div>
        </div>
        <!-- 장소추천 영역 끝 -->
      </div>
    </div>
    <!-- 결과 끝-->
  </div>
</template>

<!--<script type="application/javascript" src="../JS_script/total_stress.js"></script>-->

<script>
export default {
  name : 'total_stress',
  data () {
    return {

    }
  }
}
</script>

<style scoped>
@import url('../css/total_stress.css');
</style>