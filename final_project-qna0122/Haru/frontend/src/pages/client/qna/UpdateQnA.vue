<template>
  <div class="container1">
    <div class="qna-write-container" @submit.prevent="submitQnA">
      <form class="qna-write-form" autocomplete="off">
        <h2>Q&A 수정</h2>
        <input type="hidden" v-model="myQnA.id" />
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
              v-model="myQnA.title"
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
        id: '', 
        category: 'usage',
        title: '',
        contents: '',
      },
      selectCategory: 'usage', // 초기값을 설정해줍니다.
    };
  },
  watch: {
    selectCategory(newVal) {
      this.myQnA.category = newVal; // selectCategory가 변경될 때마다 myQnA.category를 업데이트합니다.
    }
  },
  created() {
    this.initializeMyQnA();
  },
  methods: {
    fetchData(){
      const qnum = this.$route.query.qnum;
      if(!qnum) {
        console.error("게시글 ID가 제공되지 않았습니다.");
        return;
      }
      axios.get('http://192.168.0.224/Haru/qna/${qnum}')
        .then(response => {
          this.myQnA = response.data;
        })
        .catch(error =>{
          console.error("게시글을 불러오는중 오류 발생!!!:", error);
        });
    },
    initializeMyQnA(){
      const qnum = this.$route.query.qnum;
      if (qnum) {
        this.myQnA.id = qnum;
      } else {
        console.error("게시글 수정을 위한 ID가 없습니다.");
      }
    },
    submitQnA(){
        // 유효성 검사
        if (!this.myQnA.title || !this.myQnA.contents) {
           alert("제목과 내용을 모두 입력해주세요.");
           return;
        }
      // 수정 요청 전송
      axios.patch(`http://192.168.0.224/Haru/qna/qnaUpdate/${this.myQnA.id}`,{
        title: this.myQnA.title,
        contents: this.myQnA.contents,
        category: this.myQnA.category
      })
      .then(response =>{
        console.log(response.data);
      //성공 피드백
        alert("게시글이 수정되었습니다.");
        this.$router.push('/qna'); // 예: Q&A 목록 페이지로 이동
      })
      .catch(error =>{
      // 에러 처리
        alert("게시글 수정에 실패했습니다:" + error.message);
        console.error(error);
      });
    },
    cancel() {
      this.$router.go(-1); // 뒤로가기
    },
},
}
</script>
<style scoped>
@import url("@/css/client/qna/qnaForm.css");
</style>
