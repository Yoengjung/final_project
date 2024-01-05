<template>
  <div class="container1">
    <RecommendList v-show="recommendModalStatus" />
    <form>
      <div class="bg">
        <div>
          <h1 class="page-upload-title">피드 작성하기</h1>
        </div>

        <!-- 사진 올리기 Area -->
        <div class="part-area">
          <p class="part-title">사진 올리기</p>
          <div class="upload-image-area">
            <div v-for="(item, idx) in 5" :key="idx">
              <label :for="'file' + (idx + 1)">
                <div class="file" :class="{ upfile: idx === 0 }">
                  <img v-if="idx === 0" src="../img/Feed/camera.png" alt="" />
                </div>
              </label>
              <input
                v-if="idx === 0"
                type="file"
                :id="'file' + (idx + 1)"
                accept="image/*"
                hidden
              />
            </div>
          </div>
        </div>

        <div class="part-area">
          <p class="part-title">피드 작성</p>
          <textarea
            id="contents"
            cols="68"
            rows="7"
            placeholder="피드 내용을 작성하세요."
          ></textarea>
        </div>

        <div class="part-area">
          <div>
            <p class="part-title">
              추천 해시태그<br />
              <span style="color: #a7a7a7"
                >사진을 업로드하면 해시태그를 추천해드려요!</span
              >
            </p>
          </div>
          <div class="hashtag-area">
            <span
              @click="toggleActive(hidx)"
              v-for="(hash, hidx) in hashtag"
              :key="hidx"
              :class="getTagClasses(hidx)"
            >
              #{{ hash }}
            </span>
          </div>
        </div>

        <!-- 추천 장소 선택 -->
        <div class="part-area">
          <button
            class="part-title recommend-modal-open-btn"
            @click="recommendModal"
          >
            추천 장소 선택
          </button>
        </div>

        <div class="btn-area">
          <button id="uploadFeed">피드 올리기</button>
        </div>
      </div>
    </form>
  </div>
</template>
<script>
import RecommendList from "../components/RecommendList.vue";

export default {
  name: "InsertFeed",
  recommendModalStatus: false,
  data() {
    return {
      uid: "abc",
      hashtag: [
        "고기",
        "돼지고기",
        "목살",
        "삼겹살",
        "소고기",
        "무한리필",
        "생고기",
      ],
      activeTags: [],
    };
  },
  methods: {
    toggleActive(index) {
      const indexOfTag = this.activeTags.indexOf(index);

      if (indexOfTag === -1) {
        this.activeTags.push(index);
      } else {
        this.activeTags.splice(indexOfTag, 1);
      }
    },

    getTagClasses(index) {
      return {
        hashtag: true,
        "cursor-p": true,
        "hash-active": this.activeTags.includes(index),
      };
    },
    openModal() {
      this.recommendModalStatus = !this.recommendModalStatus;
    },
    closeModal() {
      this.recommendModalStatus = false;
    },
  },
  components: { RecommendList },
};
</script>
<style scoped>
@import url("../css/insertFeed.css");
</style>
