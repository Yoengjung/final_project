<template>
  <div class="container1">
    <!-- 장소보여주기 -->
    <div class="recommend-place">
      <div class="place-card">
        <div class="'food-img">
          <img class="heart-img" src="../img/Total_stress/img/image 47.png" />
          <img src="" alt="" class="place-card" />
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
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      myFaboritePlace: [{}],
    };
  },
  created() {
    this.bgImage();
  },
  methods: {
    bgImage() {
      var newImage = "type5";
      this.$emit("bgImage", newImage);
    },
  },
};
</script>
