<template>
  <!-- --------------------- modal Start ------------------------->
  <div class="feed-modal-wrap" id="modal-wrap" @click="$emit('close-modal')">
    <!-- 모달창 영역 -->
    <div class="feed-modal-container feed-rec-modal" @click.stop>
      <!-- x 버튼 -->
      <div class="feed-modal-btn">
        <button id="feed-modal-close" @click="$emit('close-modal')"></button>
      </div>

      <!-------------------------- 컨텐츠 시작 -------------------------->
      <div class="feed-rec-area">
        <!-- 선택한 장소 전체 영역 -->
        <div class="feed-rec-selected-area">
          <p class="feed-rec-area-title">선택한 장소</p>
          <div class="contents">
            <div class="feed-rec-noplace">장소를 선택해주세요!</div>
          </div>
        </div>

        <!-- 이전 추천 리스트 전체 영역 -->
        <div>
          <p class="feed-rec-area-title">이전 추천 리스트</p>
          <RecList
            :RecommendList="RecommendList"
            :isBtnHeartNone="isBtnHeartNone"
            class="feed-rec-recList"
          />
        </div>

        <!-- 버튼 영역 -->
        <div class="feed-rec-btn-area">
          <button class="btn-cancle">취소하기</button>
          <button>선택하기</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import RecList from "../components/RecommendList.vue";

export default {
  name: "feedRecommendList",
  data() {
    return {
      isBtnHeartNone: true,
      RecommendList: [
        {
          rdate: "9월 23일",
          recList: [
            {
              storeName: "신논현역 딸부자네 불백",
              stAddress: "서울시 강남구 꼬마빌딩 1층",
              img: require("../img/Feed/bul.png"),
              link: "#",
              hashtag: ["푸드", "맛집", "고기", "돼지고기", "갈매기살"],
              heartOnOff: "on",
            },
            {
              storeName: "신논현역 버거킹",
              stAddress: "서울시 강남구 꼬마빌딩 2층",
              img: require("../img/Feed/bul.png"),
              link: "#",
              hashtag: ["패스트푸드", "맛집", "와퍼"],
              heartOnOff: "off",
            },
            {
              storeName: "신논현역 버거킹",
              stAddress: "서울시 강남구 꼬마빌딩 2층",
              img: require("../img/Feed/bul.png"),
              link: "#",
              hashtag: ["패스트푸드", "맛집", "와퍼"],
              heartOnOff: "off",
            },
          ],
        },
        {
          rdate: "9월 22일",
          recList: [
            {
              storeName: "신논현역 와플대학",
              stAddress: "서울시 강남구 꼬마빌딩 3층",
              img: require("../img/Feed/bul.png"),
              link: "#",
              hashtag: [
                "카페",
                "맛집",
                "와플",
                "애플시나몬",
                "레몬에이드",
                "레몬에이드",
                "레몬에이드",
              ],
              heartOnOff: "on",
            },
            {
              storeName: "신논현역 딸부자네 불백",
              stAddress: "서울시 강남구 꼬마빌딩 1층",
              img: require("../img/Feed/bul.png"),
              link: "#",
              hashtag: [
                "푸드",
                "맛집",
                "고기",
                "돼지고기",
                "갈매기살",
                "갈매기살",
              ],
              heartOnOff: "on",
            },
          ],
        },
        {
          rdate: "9월 21일",
          recList: [
            {
              storeName: "신논현역 버거킹",
              stAddress: "서울시 강남구 꼬마빌딩 2층",
              img: require("../img/Feed/bul.png"),
              hashtag: ["패스트푸드", "맛집", "와퍼"],
              heartOnOff: "off",
            },
          ],
        },
      ],
    };
  },
  components: {
    RecList,
  },
};
</script>
<style scoped>
@import "../css/insertFeed.css";
@import "../css/feedRecommend.css";
</style>
