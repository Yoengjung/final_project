<template>
  <div class="container1">
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
              :value="myQnA.qna_category === 'usage' ? '이용문의' : '공지사항'"
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
              :value="myQnA.qna_title"
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
            v-model="myQnA.qna_content"
            readonly
          ></textarea>
        </div>

        <!-- 답변 내용 -->
        <div class="info-input-container">
          <div class="qna-label-area">
            <label for="qna-content" id="answered">답변</label>
          </div>
          <textarea
            class="input-text"
            id="qna-content"
            cols="88"
            rows="10"
            v-model="adminanswer.qna_answer"
            readonly
          ></textarea>
        </div>

        <div class="qna-btn-group">
          <button class="big-ctlbtn cancle-btn" type="button" @click="cancel">
            목록으로
          </button>
          <button
            v-if="isAdminUser()"
            class="big-ctlbtn answer-btn"
            type="button"
            @click="answerQnA"
          >
            답변 달기
          </button>
          <!-- 답변이 된 경우 '수정', '삭제'는 불가 -->
          <button
            class="big-ctlbtn update-btn"
            type="button"
            @click="qnaUpdate"
          >
            수정
          </button>
          <button class="big-ctlbtn delete-btn" type="button">삭제</button>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
import axios from "axios";

export default {
  name: "DetailQnA",
  data() {
    return {
      myQnA: {
        qna_category: "",
        qna_title: "",
        qna_content: "",
      },
      adminanswer: {
        qna_answer: "", // 답변 내용 추가
      },
    };
  },
  methods: {
    async fetchData() {
      try {
        const qnAId = this.$route.params.qnAId;
        console.log(qnAId);
        const response = await axios.get(`http://${process.env.VUE_APP_BACK_END_URL}/testQuestionList/${qnAId}`);
        console.log(response.data);

        // 데이터 구조가 일치하는지 확인
        if (response.data && response.data.qna_category) {
          this.myQnA = {
            qna_category: response.data.qna_category,
            qna_title: response.data.qna_title,
            qna_content: response.data.qna_content,
          };
          console.log("Fetched QnA data:", this.myQnA);

          // 답변 내용 가져오기
          this.fetchAnswerContent(qnAId);
        } else {
          console.error("Invalid QnA data structure");
        }
      } catch (error) {
        console.error("Error fetching QnA data", error);
      }
    },
    cancel() {
      this.$router.go(-1);
    },
    qnaUpdate() {
      if (this.myQnA.id) {
        this.$router.push({ name: "UpdateQnA", params: { id: this.myQnA.id } });
      } else {
        console.error("Invalid QnA ID");
      }
    },
    isAdminUser() {
      // qna_category가 'admin'인 경우에만 답변 달기 버튼을 표시
      return this.myQnA.qna_category === 'admin'; 
    },
    answerQnA() {
      // 답변 달기 로직 추가
    },
    async fetchAnswerContent(qnAId) {
  try {
    const response = await axios.get(`http://${process.env.VUE_APP_BACK_END_URL}/testQuestionList/${qnAId}`);
    // response.data에 서버에서 받아온 답변 내용이 들어있음
    this.adminanswer.qna_answer = response.data.content; // content 속성 가져오기
    console.log(response.data.content);
  } catch (error) {
    console.error("Error fetching answer content", error);
  }
}
  },
  created() {
    this.$emit("bgImage", "type3");
    this.fetchData();
  },
};
</script>

<style scoped>
@import url("@/css/client/qna/qnaForm.css");
.qna-btn-group > .update-btn {
  margin-right: 20px;
}
</style>
