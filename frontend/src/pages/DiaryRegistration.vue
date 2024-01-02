<template>
  <div class="container-1">
    <div class="pro-bar"><StressBar /></div>
    <div class="reg-card">
      <div class="fake-div"></div>
      <div class="reg-box-card">
        <div class="reg-info">
          <div class="reg-info-box">
            <img src="../img/diaryReg/darily--unscreen.gif" width="300" />
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
            <div class="contents-1">
              나의 기분은 지금
              <span
                class="badge rounded-pill"
                :class="moodColor"
                ref="moodColor"
                id="mood"
                >{{ moodText }}</span
              >
              이에요.
            </div>
            <div class="contents-2-1">
              <input
                type="range"
                min="1"
                max="5"
                value="3"
                step="1"
                class="slider"
                id="myRange"
                @input="updateMood"
              />
            </div>
            <div class="contents-3">
              <a class="write-darily" href="/WriteDiary">일기쓰기</a>
            </div>
          </div>
        </div>
      </div>
      <!-- 다음단계 버튼 필요시 활성화 -->
      <div class="next-button" style="display: none">
        <a href="/WriteDiary">다음단계</a>
      </div>
    </div>
  </div>
</template>

<script>
import StressBar from "@/components/StressBar.vue";
export default {
  name: "DiaryRegistration",
  data() {
    return {
      mood: 3,
    };
  },
  components: {
    StressBar,
  },
  computed: {
    moodColor() {
      return {
        "bg-danger": this.mood === 1,
        "bg-warning": this.mood === 2,
        "bg-info": this.mood === 3,
        "bg-primary": this.mood === 4,
        "bg-success": this.mood === 5,
      };
    },
    moodText() {
      const moods = ["안좋음", "조금 안좋음", "보통", "좋음", "매우 좋음"];
      return moods[this.mood - 1] || "보통";
    },
  },
  methods: {
    updateMood(event) {
      this.mood = parseInt(event.target.value);
      this.changeMood(this.mood.toString());
    },
    changeMood(mood) {
      const moodTexts = ["안좋음", "조금 안좋음", "보통", "좋음", "매우 좋음"];
      const moodIndex = parseInt(mood) - 1;

      this.$nextTick(() => {
        const moodColorElement = this.$refs.moodColor;
        const moodTextElement = this.$refs.moodText;

        if (moodColorElement && moodTextElement) {
          moodTextElement.innerText = moodTexts[moodIndex];
        }
      });
    },
  },
};
</script>
<style scoped>
@import url("../css/DiaryRegistration.css");
</style>
