<template>
  <div id="app">
    <div class="container1">
      <form>
        <div class="bg">
          <div>
            <h1 class="page-upload-title">피드 수정하기</h1>
          </div>

          <!-- 사진 올리기 Area -->
          <div class="part-area">
            <p class="part-title">사진</p>
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
            <p class="part-title">피드</p>
            <textarea
              id="contents"
              cols="68"
              rows="7"
              placeholder="피드 내용을 작성하세요."
              v-model="myFeed.contents"
            ></textarea>
          </div>

          <div class="part-area">
            <p class="part-title">기존 해시태그</p>
            <div class="hashtag-area">
              <span
                @click="toggleActive(oidx, 0)"
                v-for="(originHash, oidx) in myFeed.originHashtag"
                :key="oidx"
                :class="getTagClasses(oidx, 0)"
              >
                #{{ originHash }}
              </span>
            </div>
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
                @click="toggleActive(hidx, 1)"
                v-for="(hash, hidx) in hashtag"
                :key="hidx"
                :class="getTagClasses(hidx, 1)"
              >
                #{{ hash }}
              </span>
            </div>
          </div>

          <!-- 추천 장소 선택 -->
          <div class="part-area">
            <p class="part-title">추천 장소</p>
          </div>

          <div class="btn-area">
            <button id="uploadFeed">피드 수정하기</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
export default {
  name: "UpdateFeed",
  data() {
    return {
      myFeed: {
        uid: "abc",
        originHashtag: ["고기", "돼지고기", "목살"],
        upimage: ["feed1.png", "feed2.jpg", "feed2.jpg"],
        contents:
          "고기 무한리필집 가고싶어서 집 근처에 뭐있나 봤는데 없길래 사진이나 찍자해서 스트레스 분석을 했거든요. 근데 고기집을 추천해주더라구요. 가서 먹었는데 진짜 걍 맛있어서 우왕굿",
      },
      hashtag: [
        "삼겹살",
        "소고기",
        "무한리필",
        "생고기",
        "소고기",
        "무한리필",
        "생고기",
      ],
      activeTags: [[], []],
    };
  },
  created() {
    for (var i = 0; i < this.myFeed.originHashtag.length; i++) {
      this.activeTags[0][i] = i;
    }
  },
  methods: {
    toggleActive(index, num) {
      const indexOfTag = this.activeTags[num].indexOf(index);

      if (indexOfTag === -1) {
        this.activeTags[num].push(index);
      } else {
        this.activeTags[num].splice(indexOfTag, 1);
      }
    },

    getTagClasses(index, num) {
      return {
        hashtag: true,
        "cursor-p": true,
        "hash-active": this.activeTags[num].includes(index),
      };
    },
  },
};
</script>
<style scoped>
@import url("../css/updateFeed.css");
</style>
