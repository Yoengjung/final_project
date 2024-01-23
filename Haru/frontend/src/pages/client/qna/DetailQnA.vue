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
            <input v-model="qnatitle"
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
          <textarea  v-model="qnacontent"
            class="input-text"
            id="qna-content"
            cols="88"
            rows="10"
            placeholder="Q&A 내용을 작성하세요."
          ></textarea>
        </div>

        <div class="qna-btn-group">
          <button class="big-ctlbtn cancle-btn" type="button" @click="cancel">
            취소
          </button>
          <button class="big-ctlbtn insert-btn" type="button" @click="qnaSave">등록</button>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "WriteQnA",
  data() {
    return {
      selectCategory: "usage", // default - 이용문의
    };
  },
  methods: {
    cancel() {
      // this.$router.push("/QnA");
      this.$router.go(-1); // 뒤로가기
    },
    // qnasave
    qnaSave(){
        //alert("selectCategory:"+this.selectCategory);
        //alert("qnatitle:"+this.qnatitle);
        let formQuery = {
                "qcategroy":this.selectCategory,
                "qtitle":this.qnatitle,
                "qwriter":"테스형",
                "qcontent":this.qnacontent
        };

        axios.post(`http://${process.env.VUE_APP_BACK_END_URL}/qna/qnaAdd`,formQuery)
        .then((res) => {
            console.log(res.data);
            alert("글 등록 테스트");
        })
        .catch((err) => {
             if (err.message.indexOf('Network Error') > -1) {
                          alert('네트워크가 원활하지 않습니다.\n잠시 후 다시 시도해주세요.')
               }
        })
    }
  },
  created() {
    this.$emit("bgImage", "type3");
  },
};
</script>
<style scoped>
@import url("@/css/client/qna/qnaForm.css");
</style>