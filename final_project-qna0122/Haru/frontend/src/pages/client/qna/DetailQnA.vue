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
              :value="myQnA.category === 'usage' ? '이용문의' : '공지사항'"
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
              :value="myQnA.title"
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
            v-model="myQnA.contents"
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
            v-model="myQnA.answer"
            readonly
          ></textarea>
        </div>

        <div class="qna-btn-group">
          <button class="big-ctlbtn cancle-btn" type="button" @click="cancel">
            목록으로
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
export default {
  name: "DetailQnA",
  data() {
    return {
      qnaDetail: {
        qnum: null,
        category: "",
        title: "",
        content: "",
        answer: null,
      },
    };
  },
  methods: {
    fetchQnADetails() {
      // 서버로부터 Q&A 상세 데이터를 가져오는 로직
      // 예시: this.qnaDetail = fetchFromServer();
    },
    cancel() {
      this.$router.go(-1); // 뒤로가기
    },
    qnaUpdate() {
      this.$router.push("/UpdateQnA");
    },
  },
  created() {
    this.fetchQnADetails(); // 컴포넌트 생성 시 데이터 로드
    this.$emit("bgImage", "type3");
  },
};
</script>
<style scoped>
@import url("@/css/client/qna/qnaForm.css");
.qna-btn-group > .update-btn {
  margin-right: 20px;
}
</style>
