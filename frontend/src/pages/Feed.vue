<template>
  <div class="container1">
    <FeedDetail v-if="modal_Check" @close-modal="closeModal" />
    <div class="feed-card-area" id="card-area">
      <form action="" id="search-form">
        <div class="search-area">
          <input
            class="hashtag-search-input"
            type="text"
            placeholder="# 해시태그로 피드를 검색하세요"
          />
          <button class="hashtag-search-btn">
            <img src="image/search_btn.png" alt="" />
          </button>
        </div>
      </form>

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
            <!-- 본인 게시글인 경우 수정 dim 처리 -->
            <div class="update-area" v-if="i.uid === 'abc'">
              <img class="cursor-p" src="../img/Feed/update.png" alt="" />
              <p class="cursor-p">수정하기</p>
            </div>

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
              <span
                v-if="i.content.length > 100"
                class="more cursor-p"
                id="more"
                @click="openModal"
                >... 더보기</span
              >
            </p>
          </div>

          <!-- 좋아요, 댓글 버튼 -->
          <div class="card-btn">
            <div>
              <div class="heart">
                <img class="cursor-p" src="../img/Feed/heart.png" id="heart" />
                <span>{{ i.likes }}</span>
              </div>
              <div class="comment">
                <img
                  class="cursor-p"
                  src="../img/Feed/comment.png"
                  id="comment"
                  @click="openModal"
                />
                <span @click="openModal" class="cursor-p">{{
                  i.comments
                }}</span>
              </div>
            </div>

            <p class="rDate">{{ i.rDate }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import FeedDetail from "../components/FeedDetail.vue";

export default {
  name: "feedMain",
  data() {
    return {
      cardList: [
        {
          profileImage: require("../img/Feed/no_profile.png"),
          uid: "abc",
          profileLink: "#",
          nickname: "닉네임",
          mainCategory: "액티비티",
          images: [
            require("../img/Feed/feed1.png"),
            require("../img/Feed/feed3.jpg"),
            require("../img/Feed/feed2.jpg"),
          ],
          content:
            "오늘 정말 좋았던거 같은데... 뭐 별거 없었다... 하지만 야경은 진짜 멋있었다",
          likes: 22,
          rDate: "2023-12-26",
          comments: 5,
        },
        {
          profileImage: require("../img/Feed/no_profile.png"),
          uid: "abcd",
          profileLink: "#",
          nickname: "닉네임",
          mainCategory: "액티비티",
          images: [require("../img/Feed/feed3.jpg")],
          content:
            "오늘 정말 좋았던거 같은데... 뭐 별거 없었다... 하지만 야경은 진짜 멋있었다 오늘 정말 좋았던거 같은데... 뭐 별거 없었다... 하지만 야경은 진짜 멋있었다 꼭 또가고 싶어졌다",
          likes: 22,
          rDate: "2023-12-26",
          comments: 5,
        },
        {
          profileImage: require("../img/Feed/no_profile.png"),
          uid: "abcd",
          profileLink: "#",
          nickname: "닉네임",
          mainCategory: "액티비티",
          images: [
            require("../img/Feed/feed3.jpg"),
            require("../img/Feed/feed2.jpg"),
          ],
          content:
            "오늘 정말 좋았던거 같은데... 뭐 별거 없었다... 하지만 야경은 진짜 멋있었다",
          likes: 22,
          rDate: "2023-12-26",
          comments: 5,
        },
        {
          profileImage: require("../img/Feed/no_profile.png"),
          uid: "abc",
          profileLink: "#",
          nickname: "닉네임",
          mainCategory: "액티비티",
          images: [
            require("../img/Feed/feed1.png"),
            require("../img/Feed/feed3.jpg"),
            require("../img/Feed/feed2.jpg"),
          ],
          content:
            "오늘 정말 좋았던거 같은데... 뭐 별거 없었다... 하지만 야경은 진짜 멋있었다",
          likes: 22,
          rDate: "2023-12-26",
          comments: 5,
        },
        {
          profileImage: require("../img/Feed/no_profile.png"),
          uid: "abc",
          profileLink: "#",
          nickname: "닉네임",
          mainCategory: "액티비티",
          images: [
            require("../img/Feed/feed1.png"),
            require("../img/Feed/feed3.jpg"),
            require("../img/Feed/feed2.jpg"),
          ],
          content:
            "오늘 정말 좋았던거 같은데... 뭐 별거 없었다... 하지만 야경은 진짜 멋있었다",
          likes: 22,
          rDate: "2023-12-26",
          comments: 5,
        },
      ],
      modal_Check: false,
    };
  },
  methods: {
    openModal() {
      this.modal_Check = !this.modal_Check;
    },
    closeModal() {
      this.modal_Check = false;
    },
  },
  components: {
    FeedDetail,
  },
};
</script>
<style scoped>
@import "../css/feed.css";
</style>
