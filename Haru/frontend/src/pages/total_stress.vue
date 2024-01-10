<template>
  <div class="container1">
    <!--  진행바 영역 시작-->
    <div class="pro-bar">
      <div class="pro-bar-box">
        <div class="row">
          <div class="col">
            <ul id="progress-bar" class="progressbar">
              <li class="active">
                <span class="span-thin">얼굴 등록하기</span>
              </li>
              <li class="active">
                <span class="span-thin">척도 등록하기</span>
              </li>
              <li class="active"><span class="span-thin">일기쓰기</span></li>
              <li class="active"><span class="span-bold">완료!</span></li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <!--  진행바 영역 끝-->
    <div class="container1">
      <div class="result-card-container">
        <div class="result-card-box">
          <div class="stress-area">
            <div class="result-comment">
              이범석님의 스트레스 수치는
              <span class="badge rounded-pill bg-danger custom-bedge"
                >정상</span
              >
              입니다.
            </div>
            <!-- 스트레스 수치 바 시작 -->
            <div class="rating-bar-container">
              <div class="percentage-box">
                <ul class="rating-percent">
                  <li class="rating-number"></li>
                  <li class="rating-number">
                    <span class="percentage">10%</span>
                  </li>
                  <li class="rating-number">
                    <span class="percentage">20%</span>
                  </li>
                  <li class="rating-number">
                    <span class="percentage">30%</span>
                    <span class="fourchette stress-nomal">정상</span>
                  </li>
                  <li class="rating-number">
                    <span class="percentage">40%</span>
                  </li>
                  <li class="rating-number">
                    <span class="percentage">50%</span>
                  </li>
                  <li class="rating-number">
                    <span class="percentage">60%</span>
                    <span class="fourchette stress-warning">주의</span>
                  </li>
                  <li class="rating-number">
                    <span class="percentage">70%</span>
                  </li>
                  <li class="rating-number">
                    <span class="percentage">80%</span>
                    <span class="fourchette stress-danger">심각</span>
                  </li>
                  <li class="rating-number">
                    <span class="percentage">90%</span>
                  </li>
                  <li class="rating-number"></li>
                </ul>
              </div>
              <div class="rating-bar">
                <div class="rating-bar-gauge" :style="{ width: gaugeWidth }">
                  <span
                    class="percentage-number"
                    v-if="20 <= parseInt(gaugeWidth)"
                    >스트레스 수치 {{ stressRate }}%</span
                  >
                </div>
              </div>
            </div>
          </div>
          <!-- 스트레스 수치 바 끝 -->
          <!-- 장소추천 영역 시작 -->
          <div class="recomend-area">
            <div class="recomend-area-box">
              <div class="recomend-comment">
                <span
                  >이범석님의 스트레스 수치로 ‘하루의 여울’이 추천한
                  장소에요.</span
                >
              </div>
              <div class="recomend-button">
                <img
                  id="scroll-left-button"
                  class="recomend-btn-el"
                  src="../img/Total_stress/img/left.png"
                  @click="scrollLeft"
                />
                <img
                  id="scroll-right-button"
                  class="recomend-btn-el"
                  src="../img/Total_stress/img/right.png"
                  @click="scrollRight"
                />
              </div>
            </div>
            <!-- 장소보여주기 -->
            <div class="recomend-place">
              <div class="place-card">
                <div class="'food-img">
                  <img
                    class="heart-img"
                    src="../img/Total_stress/img/image 47.png"
                  />
                  <img
                    src="../img/Total_stress/food/buger.jpg"
                    alt="버거킹"
                    class="place-card"
                  />
                </div>
                <div class="food-desc">
                  <div class="food-desc-box">
                    <div class="food-title">
                      <h4>버거킹 신논현역점</h4>
                    </div>
                    <div class="hash-tag">
                      <span class="review-score">★ 4.58</span>
                    </div>
                    <div class="food-detail">
                      <span class="food-address"
                        >주소: 부산광역시 강서구 녹산산단382로14번가길
                        10~29번지(송정동)</span
                      >
                    </div>
                  </div>
                </div>
              </div>
              <div class="place-card">
                <div class="'food-img">
                  <img
                    class="heart-img"
                    src="../img/Total_stress/img/image 47.png"
                  />
                  <img
                    src="../img/Total_stress/food/duck.jpg"
                    alt="버거킹"
                    class="place-card"
                  />
                </div>
                <div class="food-desc">
                  <div class="food-desc-box">
                    <div class="food-title">
                      <h4>버거킹 신논현역점</h4>
                    </div>
                    <div class="hash-tag">
                      <span class="review-score">★ 별점없음</span>
                    </div>
                    <div class="food-detail">
                      <span class="food-address"
                        >주소: 부산광역시 강서구 녹산산단382로14번가길
                        10~29번지(송정동)</span
                      >
                    </div>
                  </div>
                </div>
              </div>
              <div class="place-card">
                <img
                  src="../img/Total_stress/food/mega.jpg"
                  alt="버거킹"
                  class="place-card"
                />
              </div>
              <div class="place-card">
                <img
                  src="../img/Total_stress/food/starbucks.jpg"
                  alt="버거킹"
                  class="place-card"
                />
              </div>
              <div class="place-card">
                <img
                  src="../img/Total_stress/food/wf.jpg"
                  alt="버거킹"
                  class="place-card"
                />
              </div>
            </div>
            <!-- 장소보여주기 끝 -->
          </div>
          <div class="step-btn">
            <div>
              <button class="step-btn" id="prev-button">
                <span>이전 추천 리스트</span>
              </button>
            </div>
            <div>
              <button class="step-btn" id="next-button">
                <span>나의 스트레스 보고서</span>
              </button>
            </div>
            <div>
              <button class="step-btn" id="main-button">
                <span>메인으로 이동</span>
              </button>
            </div>
          </div>
          <!-- 장소추천 영역 끝 -->
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "total_stress",
  data() {
    return {
      gaugeWidth: "0%", // 초기 게이지
      ratNumber: [10, 20, 30, 40, 50, 60, 70, 80, 90],
      stressRate: 0,
    };
  },
  created() {
    // background-image 설정
    this.bgImage();
  },
  methods: {
    // background-image 설정
    bgImage() {
      var newImage = "type2";
      this.$emit("bgImage", newImage);
    },
    scrollLeft() {
      var slider = document.querySelector(".recomend-place");
      slider.scrollTo({
        left: 0,
        behavior: "smooth",
      });
    },
    scrollRight() {
      const slider = document.querySelector(".recomend-place");
      slider.scrollTo({
        left: slider.scrollWidth,
        behavior: "smooth",
      });
    },
  },
  mounted() {
    let currentWidth = 0;
    const targetWidth = 78; // 목표 값 추후 변경
    this.stressRate = targetWidth;

    const animationDuration = 3000;
    const interval = 30;

    const step = (targetWidth - currentWidth) / (animationDuration / interval);

    const animate = () => {
      if (currentWidth < targetWidth) {
        currentWidth += step;
        this.gaugeWidth = currentWidth + "%";
        this.stressRate = Math.round(currentWidth);
        requestAnimationFrame(animate);
      } else {
        this.gaugeWidth = targetWidth + "%"; // 애니메이션이 완료되면 정확한 값으로 설정
        this.stressRate = targetWidth;
      }
    };
    animate();
  },
};
</script>

<style scoped>
@import url("../css/total_stress.css");
</style>
