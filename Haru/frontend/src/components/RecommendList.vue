<template>
  <!-- 추천 리스트 - 내장소(추천리스트), 피드생성/수정(추천리스트 모달창) -->
  <div>
    <div
      v-for="(rlist, idx) in RecommendList"
      :key="idx"
      class="rlist-day-area"
    >
      <p>{{ rlist.rdate }}</p>
      <div v-for="(item, i) in rlist.recList" :key="i">
        <div class="rlist-card-area">
          <div class="rlist-content-area">
            <div class="all-info">
              <div class="rlist-img-area">
                <a :href="item.link"
                  ><img class="rec-detail-img" :src="item.img" alt=""
                /></a>
              </div>
              <div class="content">
                <div class="stname-address">
                  <!-- 가게 명 -->
                  <h5 class="stName">{{ item.storeName }}</h5>
                  <!-- 가게 주소 -->
                  <p class="stAddress">{{ item.stAddress }}</p>
                </div>
                <!-- 해시태그 -->
                <p class="rlist-rec-hash-area">
                  <span
                    class="rlist-rec-hash cursor-p"
                    v-for="(hash, hidx) in item.hashtag"
                    :key="hidx"
                    >#{{ hash }}</span
                  >
                </p>
              </div>
            </div>

            <!-- 하트 버튼 -->
            <div
              class="rlist-heart"
              :class="{ recBtnDisplayNone: isBtnHeartNone === true }"
            >
              <img class="cursor-p" src="@/img/Feed/heart.png" id="heart" />
            </div>

            <!-- 체크박스 -> 추천리스트 선택 -->
            <div
              class="rlist-checkbox"
              :class="{ recBtnDisplayNone: isBtnHeartNone === false }"
            >
              <input
                type="checkbox"
                class="recCheckbox"
                :id="'recCheckbox' + idx + '-' + i"
              />
              <label :for="'recCheckbox' + idx + '-' + i"></label>
            </div>
          </div>

          <div
            class="upload-btn-area"
            :class="{ recBtnDisplayNone: isBtnHeartNone === true }"
          >
            <span>피드 올리기</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {};
  },
  props: {
    RecommendList: Object, // 추천 리스트 목록
    isBtnHeartNone: Boolean, //
  },
};
</script>
<style scoped>
@import "@/css/myPlace/recommendList.css";
</style>
