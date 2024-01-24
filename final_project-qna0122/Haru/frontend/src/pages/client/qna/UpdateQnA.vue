<template>
  <div class="container1">
    <div class="qna-write-container" @submit.prevent="submitQnA">
      <form class="qna-write-form" autocomplete="off">
        <h2>Q&A 수정</h2>
        <div class="info-input-container"> 
          <div class="qna-label-area">
            <label for="qna-title">카테고리 선택</label>
          </div>

          <!-- 카테고리 선택 -->
          <select class="input-select" v-model="selectCategory">
            <option value="usage">이용문의</option>
            <!-- [공지사항은 관리자만 입력할 수 있도록] => v-if="mid.slide(5) === 'admin'" -->
            <option value="notice">공지사항</option>
          </select>
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
              placeholder="Q&A 제목을 입력해주세요."
              :value="myQnA.title"
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
            placeholder="Q&A 내용을 작성하세요."
            v-model="myQnA.contents"
          ></textarea>
        </div>

        <div class="qna-btn-group">
          <button class="big-ctlbtn cancle-btn" type="button" @click="cancel">
            취소
          </button>
          <button class="big-ctlbtn update-btn" type="submit">수정완료</button>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
import axios from 'axios';

export default {
  name: "WriteQnA",
  data() {
    return {
      myQnA: {
        id: null, 
        category: "usage",
        title: "어떻게 스트레스 분석이 이렇게 잘맞는건가요?!?!",
        contents: "너무 잘맞아요!",
      },
    };
  },
  methods: {
    cancel() {
      this.$router.go(-1); // 뒤로가기
    },
    submitQnA(){
        // 유효성 검사
        if (!this.myQnA.title || !this.myQnA.contents) {
           alert("제목과 내용을 모두 입력해주세요.");
           return;
        }
      // 수정 요청 전송
      axios.put('/api/qnaUpdate/' + this.myQnA.id, this.myQnA)
      .then(() =>{
      //성공 피드백
        alert("게시글이 수정되었습니다.");
        this.$router.push('/qna'); // 예: Q&A 목록 페이지로 이동
        this.updateQnA();
      })
      .catch(error =>{
      // 에러 처리
        alert("게시글 수정에 실패했습니다.");
        console.error(error);
      });
    },
    updateQnA() {
    axios
      .post('/api/updateQnA', {
        qnum: this.qnaDetail.qnum,
        title: this.qnaDetail.title,
        content: this.qnaDetail.content,
        // 기타 필요한 데이터...
      })
      .then((response) => {
        // 성공적으로 업데이트 되었을 때의 처리
        console.log(response.data);
        // 사용자를 QnA 목록 페이지로 리다이렉트하거나 성공 메시지를 표시할 수 있습니다.
      })
      .catch((error) => {
        // 오류 처리
        console.error("Error updating QnA:", error);
      });
  },
  created() {
    this.$emit("bgImage", "type3");
    this.selectCategory = this.myQnA.category;
  },
},
}
</script>
<style scoped>
@import url("@/css/client/qna/qnaForm.css");
</style>
