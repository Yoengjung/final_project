<template>
  <div class="container">
    <div class="feed-card-area" id="card-area">
      <!-- 피드 start -->
      <div class="feed-card" v-for="(i, idx) in cardList" :key="idx">
        <div class="feed-card-header">
          <!-- 프로필 사진, 닉네임 -->
          <div class="profile-area">
            <div class="profile-img">
              <a href="#"><img :src="i.profileImage" /></a>
            </div>
            <a href="#"
              ><span class="nickname">{{ i.nickname }}</span></a
            >
          </div>

          <!-- 큰 카테고리 -->
          <div class="main-category">{{ i.mainCategory }}</div>
        </div>

        <div class="feed-card-body">
          <!-- 이미지 Area -->
          <div class="card-body-image">
            <div
              :id="'carousel' + idx"
              class="carousel slide"
              data-bs-interval="false"
            >
              <!-- 인디케이터 -->
              <div class="carousel-indicators" v-if="i.images.length > 1">
                <button
                  v-for="(indi, indiIdx) in i.images"
                  :key="indiIdx"
                  type="button"
                  :data-bs-target="'#carousel' + idx"
                  :data-bs-slide-to="indiIdx"
                  :class="{ active: indiIdx === 0 }"
                ></button>
              </div>

              <!-- 이미지 -->
              <div class="carousel-inner">
                <div
                  v-for="(image, imgIdx) in i.images"
                  :key="imgIdx"
                  class="carousel-item"
                  :class="{ active: imgIdx === 0 }"
                >
                  <img :src="image" class="d-block w-100" />
                </div>
              </div>

              <!-- 이전, 다음 버튼 -->
              <button
                class="carousel-control-prev"
                type="button"
                :data-bs-target="'#carousel' + idx"
                data-bs-slide="prev"
                v-if="i.images.length > 1"
              >
                <span
                  class="carousel-control-prev-icon"
                  aria-hidden="true"
                ></span>
                <span class="visually-hidden">Previous</span>
              </button>
              <button
                class="carousel-control-next"
                type="button"
                :data-bs-target="'#carousel' + idx"
                data-bs-slide="next"
                v-if="i.images.length > 1"
              >
                <span
                  class="carousel-control-next-icon"
                  aria-hidden="true"
                ></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>
          </div>

          <!-- 본문 contents -->
          <!-- 이미지 여러개면 margin-top 조금 올리기 -->
          <div class="card-content">
            <p>
              {{ i.content.slice(0, 90) }}
              <span v-if="i.content.length > 100" class="more" id="more"
                >... 더보기</span
              >
            </p>
          </div>

          <!-- 좋아요, 댓글 버튼 -->
          <div class="card-btn">
            <div class="heart">
              <img src="../img/Feed/heart.png" id="heart" />
              <span>{{ i.likes }}</span>
            </div>
            <div class="comment">
              <img src="../img/Feed/comment.png" id="comment" />
              <span>{{ i.comments }}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- --------------------- modal ----------------------- -->
  <div class="modal-wrap" v-show="modal_Check" @click="modal_click">
    <div class="modal-container" @click.stop="">
      <div class="modal-btn">
        <button id="modal_close" @click="modal_click"></button>
      </div>
      <div id="face_icon"></div>
      <span id="modal_comment">얼굴을 찾지 못했어요...</span>
      <div class="modal_box" style="top: 79; left: 99">
        <div class="warn"></div>
        <div id="warn_filter"></div>
        <span class="modal_text" style="top: 138; left: 32"
          >스티커나 필터를 사용한 경우</span
        >
      </div>
      <div class="modal_box" style="top: 79; left: 285">
        <div class="warn"></div>
        <div id="warn_side"></div>
        <span class="modal_text" style="top: 138; left: 50"
          >옆 모습만 나온 경우</span
        >
      </div>
      <div class="modal_box" style="top: 266; left: 99; background: #5a5a5a">
        <div class="warn"></div>
        <div id="warn_dark"></div>
        <span class="modal_text" style="top: 138; left: 41; color: white"
          >사진이 어둡게 나온 경우</span
        >
      </div>
      <div class="modal_box" style="top: 266; left: 285">
        <div class="warn"></div>
        <div id="warn_small"></div>
        <span class="modal_text" style="top: 138; left: 49"
          >얼굴이 작게 나온 경우</span
        >
      </div>
    </div>
  </div>
  <!-- --------------------- modal ----------------------- -->
</template>
<script>
export default {
  name: "feed",
  data() {
    return {
      cardList: [
        {
          profileImage: require("../img/Feed/no_profile.png"),
          profileLink: "#",
          nickname: "닉네임",
          nicknameLink: "#",
          mainCategory: "액티비티",
          images: [
            require("../img/Feed/feed2.jpg"),
            require("../img/Feed/feed3.jpg"),
            require("../img/Feed/feed3.jpg"),
          ],
          content:
            "오늘 정말 좋았던거 같은데... 뭐 별거 없었다... 하지만 야경은 진짜 멋있었다",
          likes: 22,
          comments: 5,
        },
        {
          profileImage: require("../img/Feed/no_profile.png"),
          profileLink: "#",
          nickname: "닉네임",
          nicknameLink: "#",
          mainCategory: "액티비티",
          images: [require("../img/Feed/feed2.jpg")],
          content:
            "오늘 정말 좋았던거 같은데... 뭐 별거 없었다... 하지만 야경은 진짜 멋있었다 오늘 정말 좋았던거 같은데... 뭐 별거 없었다... 하지만 야경은 진짜 멋있었다 꼭 또가고 싶어졌다",
          likes: 22,
          comments: 5,
        },
        {
          profileImage: require("../img/Feed/no_profile.png"),
          profileLink: "#",
          nickname: "닉네임",
          nicknameLink: "#",
          mainCategory: "액티비티",
          images: [
            require("../img/Feed/feed2.jpg"),
            require("../img/Feed/feed3.jpg"),
          ],
          content:
            "오늘 정말 좋았던거 같은데... 뭐 별거 없었다... 하지만 야경은 진짜 멋있었다",
          likes: 22,
          comments: 5,
        },
        {
          profileImage: require("../img/Feed/no_profile.png"),
          profileLink: "#",
          nickname: "닉네임",
          nicknameLink: "#",
          mainCategory: "액티비티",
          images: [
            require("../img/Feed/feed2.jpg"),
            require("../img/Feed/feed3.jpg"),
            require("../img/Feed/feed3.jpg"),
          ],
          content:
            "오늘 정말 좋았던거 같은데... 뭐 별거 없었다... 하지만 야경은 진짜 멋있었다",
          likes: 22,
          comments: 5,
        },
        {
          profileImage: require("../img/Feed/no_profile.png"),
          profileLink: "#",
          nickname: "닉네임",
          nicknameLink: "#",
          mainCategory: "액티비티",
          images: [
            require("../img/Feed/feed2.jpg"),
            require("../img/Feed/feed3.jpg"),
            require("../img/Feed/feed3.jpg"),
          ],
          content:
            "오늘 정말 좋았던거 같은데... 뭐 별거 없었다... 하지만 야경은 진짜 멋있었다",
          likes: 22,
          comments: 5,
        },
      ],
      modal_Check: false,
    };
  },
  methods: {
    modal_click() {
      this.modal_Check = !this.modal_Check;
    },
  },
};
</script>
<style scoped>
@import "../css/feed.css";
</style>
