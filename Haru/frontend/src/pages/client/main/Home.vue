<template>
  <div class="home-container">
    <video muted autoplay loop class="home">
      <source src="@/assets/bgImage/main_bg.mp4" type="video/mp4" />
    </video>
    <div class="main-section" id="main-section">
    </div>

    <!-- 컨텐츠 -->
    <div class="pages" ref="pages">
      <div class="page">
        <div class="main-page">
          <div class="title-box">
            <span id="main-title">지친 현대인의 삶을 위한, 하루의 여울</span>
            <span id="sub-title">하루의 여울이 당신을 위해 이곳으로 안내합니다.</span>
          </div>
          <div class="wrapper-badge">
            <div class="site-info-badge">
              <div class="info-section">
                <img src="@/img/main/account.png" class="info-img">
                <span>회원수</span>
                <span>{{total_member}}명</span>
              </div>
              <!-- 공백div -->
              <div class="white-space-div"></div>
              <div class="info-section">
                <img src="@/img/main/stress.png" class="info-img">
                <span>오늘 평균 스트레스 수치</span>
                <span>{{today_stress_avg}}%</span>
              </div>
              <div class="white-space-div"></div>
              <div class="info-section">
                <img src="@/img/main/feed.png" class="info-img">
                <span>누적 피드수</span>
                <span>{{total_feed}}개</span>
              </div>
              <div class="white-space-div"></div>
              <div class="info-section">
                <img src="@/img/main/like.png" class="info-img">
                <span>누적 좋아요</span>
                <span>{{total_like}}개</span>
              </div>
            </div>
          </div>
          </div>
      </div>
      <div class="second page">
        <h2 class="title">원페이지 스크롤링입니다</h2>
      </div>
      <div class="third page">
        <h2 class="title">공부열심히 합시다</h2>
      </div>
      <div class="first page">
        <h2 class="title">공부열심히 합시다</h2>
      </div>
    </div>
    <!-- 페이징 -->
    <ul class="pagination">
      <li v-for="(btn, index) in btns" :key="index" @click="btnClick(index)" :class="{active : current === index}"></li>
    </ul>
  </div>
</template>

<script>
export default {
  name : 'Home',
  data() {
    return {
      // div 슬라이더들, 버튼들
      slides: [],
      // 슬라이더 버튼들
      btns: [],
      // 슬라이더 갯수
      count : 0,
      current : 0,
      touchstart : 0,
      // 애니메이션 상태
      animation_state : false,

      //메인에 보여줄 변수들
      total_member : 1249,
      today_stress_avg: 62,
      total_feed: 1202,
      total_like : 2103,
    }
  },
  created(){
    // 메인일 경우
    this.$emit("jasic", true);
  },
  methods : {
    init() {
      this.slides = this.$refs.pages.children;
      this.count = this.slides.length;

      // 버튼 생성
      for (let i =0; i < this.count; i++){
        this.slides[i].style.bottom =  -(i * 100) + '%';
        let btn = document.createElement('li');
        btn.addEventListener('click', this.btnClick);
        this.btns.push(btn);
        // 버튼 화면에 뿌려주기
        this.$refs.pages.append(btn);
      }
      // 초기 버튼 활성화
      this.btns[0].classList.add('active');
    },
    gotoNum(index){
      console.log(this.current, index); //0, 1
      console.log(this.slides[1]);
      if(index !== this.current && !this.animation_state){
        this.animation_state = true;
        setTimeout(() => (this.animation_state = false), 500);
        // 버튼 active css 주기
        this.btns[this.current].classList.remove('active');
        this.current = index;
        this.btns[this.current].classList.add('active');

        // index 페이지로 이동
        for (let i = 0; i < this.count; i++){
          this.slides[i].style.bottom = (this.current-i) * 100 + '%';
        }
      }
    },
    gotoNext(){
      if (this.current < this.count -1) {
        return this.gotoNum(this.current + 1);
      }
      else {
        return false;
      }
    },
    gotoPrev(){
      if(this.current > 0){
        return this.gotoNum(this.current - 1)
      }
      else {
        return false;
      }
    },
    btnClick(event){
      this.gotoNum(parseInt(event));
    },
    onTouchStart(event){
      this.touchstart = event.touches[0].screenY;
    },
    onTouchEnd(event){
      if(this.touchstart < event.changedTouches[0].screenY){
        this.gotoPrev();
      }
      else{
        this.gotoNext();
      }
    },
    onWheel(event){
      if(event.deltaY < 0){
        this.gotoPrev();
      }
      else{
        this.gotoNext();
      }
    }
  },
  mounted() {
    this.init();
    this.$refs.pages.ontouchstart = this.onTouchStart;
    this.$refs.pages.ontouchend = this.onTouchEnd;
    this.$refs.pages.onmousewheel = this.onWheel;
    this.$refs.pages.onwheel = this.onWheel;
  }
}
</script>

<style scoped>
@import url("@/css/client/main/home.css");
</style>
