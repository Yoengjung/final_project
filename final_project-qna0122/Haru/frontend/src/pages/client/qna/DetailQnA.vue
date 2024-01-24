<template>
  <div class="container1" v-if="qnaDetail">
    <div class="qna-write-container">
      <form class="qna-write-form" autocomplete="off">
        <h2>Q&A 상세보기</h2>
        <!-- 카테고리 -->
        <div class="info-input-container">
          <div class="qna-label-area">
            <label for="qna-category">카테고리</label>
          </div>
          <div class="input-area">
            <input
              class="input-text"
              type="text"
              id="qna-category"
              :value="qnaDetail.category === 'usage' ? '이용문의' : '공지사항'"
              readonly
            />
          </div>
        </div>

        <!-- 제목 -->
        <div class="info-input-container">
          <div class="qna-label-area">
            <label for="qna-title">제목</label>
          </div>
          <div class="input-area">
            <input
              class="input-text"
              type="text"
              name="qna-title"
              id="qna-title"
              :value="qnaDetail.title"
              readonly
            />
          </div>
        </div>

        <!-- 내용 -->
        <div class="info-input-container">
          <div class="qna-label-area">
            <label for="qna-content">내용</label>
          </div>
          <textarea
            class="input-text"
            id="qna-content"
            cols="88"
            rows="10"
            :value="qnaDetail.content"
            readonly
          ></textarea>
        </div>

        <!-- 답변 내용 -->
        <div class="info-input-container" v-if="qnaDetail.answer">
          <div class="qna-label-area">
            <label for="qna-answer">답변</label>
          </div>
          <textarea
            class="input-text"
            id="qna-answer"
            cols="88"
            rows="10"
            :value="qnaDetail.answer"
            readonly
          ></textarea>
        </div>

        <div class="qna-btn-group">
          <button class="big-ctlbtn cancle-btn" type="button" @click="cancel">
            목록으로
          </button>
          <button
            class="big-ctlbtn update-btn"
            type="button"
            @click="qnaUpdate"
            v-if="!qnaDetail.answer"
          >
            수정
          </button>
          <button class="big-ctlbtn delete-btn" type="button" v-if="!qnaDetail.answer">삭제</button>
        </div>
      </form>
    </div>
  </div>
  <div v-else>
    <p>Loading...</p>
  </div>
</template>
<script>
import axios from 'axios';

export default {
  name: "WriteQnA",
  data() {
    return {
      myQnA: {
        category: "",
        title: "",
        content: "",
        answer: "",
      },
    };
  },
  methods: {
    cancel() {
      this.$router.go(-1); // 뒤로가기
    },
    qnaUpdate() {
      this.$router.push("/UpdateQnA");
    },
    fetchQnADetails() {
      const qnum = this.$route.query.qnum;
      const status = this.$route.query.status;

    axios.get(`http://192.168.0.224/Haru/qna/questionDetails`, {
      params: { qnum, status }
    })
    .then(response => {
      const data = response.data;
      this.myQnA = {
        category: data.category,
        title: data.title,
        contents: data.qcontent,
        answer: data.answercontent,
      };
    })
      .catch(error => {
        console.error("Error fetching QnA details:", error);
      });
    }
  },         
    created() {
      this.$emit("bgImage", "type3");
      this.fetchQnADetails(); // 컴포넌트 생성 시 데이터 로드
    },
  };
</script>
<style scoped>
@import url("@/css/client/qna/qnaForm.css");
.qna-btn-group > .update-btn {
  margin-right: 20px;
}
</style>
