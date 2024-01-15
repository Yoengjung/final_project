<template>
  <div class="container my-3">
    <h2 class="border-bottom py-2">{{ question.subject }}</h2>
    <div class="card my-3">
      <div class="card-body">
        <div class="card-text" style="white-space: pre-line;">{{ question.content }}</div>
        <div class="d-flex justify-content-end">
          <div class="badge bg-light text-dark p-2 text-start">
            {{ formatDate(question.createDate) }}
          </div>
        </div>
      </div>
    </div>
    <h5 class="border-bottom my-3 py-2">{{ question.answerList.length }}개의 답변이 있습니다.</h5>
    <div class="card my-3" v-for="answer in question.answerList" :key="answer.id">
      <div class="card-body">
        <div class="card-text" style="white-space: pre-line;">{{ answer.content }}</div>
        <div class="d-flex justify-content-end">
          <div class="badge bg-light text-dark p-2 text-start">
            {{ formatDate(answer.createDate) }}
          </div>
        </div>
      </div>
    </div>
    <form @submit.prevent="submitAnswer">
      <textarea name="content" id="content" rows="10" class="form-control"></textarea>
      <input type="submit" value="답변등록" class="btn btn-primary my-2">
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      question: {
        // 질문 관련 데이터
      }
    };
  },
  methods: {
    submitAnswer() {
      // 답변 제출 로직
    },
    formatDate(date) {
      // 날짜 포맷 변경 로직
    }
  }
};
</script>

<style>
/* 여기에 CSS 스타일 */
</style>
