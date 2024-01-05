<template>
  <div>
    <div v-for="(rlist, idx) in RecommendList" :key="idx">
      <div class="rlist-card-area">
        <div class="rlist-content-area">
          <div class="all-info">
            <div class="rlist-img-area">
              <a :href="rlist.link"
                ><img class="rec-detail-img" :src="rlist.img" alt=""
              /></a>
            </div>
            <div class="content">
              <div class="stname-address">
                <!-- 가게 명 -->
                <h5 class="stName">{{ rlist.storeName }}</h5>
                <!-- 가게 주소 -->
                <p class="stAddress">{{ rlist.stAddress }}</p>
              </div>
              <!-- 해시태그 -->
              <p class="rlist-rec-hash-area">
                <span
                  class="rlist-rec-hash cursor-p"
                  v-for="(hash, hidx) in rlist.hashtag"
                  :key="hidx"
                  >#{{ hash }}</span
                >
              </p>
            </div>
          </div>
          <div class="rlist-heart">
            <img class="cursor-p" src="../img/Feed/heart.png" id="heart" />
          </div>
        </div>

        <div class="upload-btn-area">
          <span>피드 올리기</span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  props: {
    RecommendList: Object,
  },
};
</script>
<style scoped>
@import "../css/MyPlaceDiary.css";
</style>
