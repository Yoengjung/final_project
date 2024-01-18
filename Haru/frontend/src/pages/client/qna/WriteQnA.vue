<template>
  <div class="container1">
    <div class="qna-write-container">
      <form class="qna-write-form" autocomplete="off">
        <h2>Q&A 등록</h2>
        <div class="info-input-container">
          <div class="qna-label-area">
            <label for="qna-title">카테고리 선택</label>
          </div>

          <!-- 카테고리 선택 -->
          <select class="input-select" v-model="selectCategory" id="input-select">
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
          ></textarea>
        </div>
          <input type="hidden" v-model="qnaData.userNickname" />

        <div class="qna-btn-group">
          <button class="big-ctlbtn cancle-btn" type="button" @click="cancel">
            취소
          </button>
          <button class="big-ctlbtn insert-btn" type="button" @click="submitQnA">등록</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { jwtDecode } from "jwt-decode";


export default {
  name: "WriteQnA",
  data() {
    return {
      selectCategory: "usage", // 기본값 - 이용문의
      qnaData: {
        qnaCategory: "usage",
        qnaTitle: "",
        qnaContent: "",
         userNickname: "",
      },
    };
  },
  methods: {
    cancel() {
      this.$router.go(-1); // 뒤로가기
    },
    submitQnA() {
      this.qnaData.qnaTitle = document.getElementById("qna-title").value;
      this.qnaData.qnaCategory = document.getElementById("input-select").value;
      this.qnaData.qnaContent = document.getElementById("qna-content").value;

  
       const token = localStorage.getItem("jwtToken");

        if (token) {
        const decodedToken = jwtDecode(token);
        const userNickname = decodedToken.nickname;
        this.qnaData.userNickname = userNickname;
      }
      console.log(this.qnaData);

      // 서버로 데이터 전송
      axios.get(`http://${process.env.VUE_APP_BACK_END_URL}/QuestionAdd`, {
  params: this.qnaData
})
        .then((res) => {
          this.qnaData = res.data;
          console.log(this.qnaData);

          // 등록이 완료되면 뒤로 가기
           this.$router.go(-1);
        })
        .catch((error) => {
          console.error('Q&A 등록 중 오류 발생:', error);
        });
    },
  },
  created() {
    this.$emit("bgImage", "type3");
  },
};
</script>

<style scoped>
@import url("@/css/client/qna/qnaForm.css");
</style>
