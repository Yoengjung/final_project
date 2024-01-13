<template>
  <div class="container1">
    <div class="qna-write-container">
      <form class="qna-write-form" autocomplete="off">
        <h2>Q&A 등록</h2>
        <div class="info-input-container">
          <div class="label-area">
            <label for="qna-title">카테고리 선택</label>
          </div>

          <!-- 날짜 선택 -->
          <select class="input-select" v-model="selectCategory">
            <option value="usage">이용문의</option>
            <!-- [공지사항은 관리자만 입력할 수 있도록] => v-if="mid.slide(5) === 'admin'" -->
            <option value="notice">공지사항</option>
          </select>
        </div>

        <!-- 제목 -->
        <div class="info-input-container">
          <div class="label-area">
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
          <div class="label-area">
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

        <div class="btn-group">
          <button class="big-ctlbtn insert-btn" type="submit">등록</button>
          <button class="big-ctlbtn cancle-btn" type="button" @click="cancel">
            취소
          </button>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
export default {
  name: "WriteQnAForm",
  data() {
    return {
      selectCategory: "usage", // 이용문의
    };
  },
  methods: {
    cancel() {
      this.$router.push("/QnA");
    },
  },
  created() {
    this.$emit("bgImage", "type3");
  },
};
</script>
<style scoped>
.btn-group {
  align-items: center;
  justify-content: center;
  margin-bottom: 50px;
}
.btn-group > .insert-btn {
  margin-right: 20px;
}
.qna-write-container {
  padding-left: 100px;
  padding-right: 100px;
  background-color: rgb(255 255 255 / 90%);
  border: none;
  border-radius: 27px;
  width: 100%;
  max-width: 1463px;
  min-width: 900px;
  height: 100%;
  margin: 0 auto;
}

.qna-write-form {
  display: flex;
  flex-direction: column;
}

label {
  font-size: 20px;
  left: 15px;
}

.qna-write-form h2 {
  margin-bottom: 30px;
  text-align: center;
  padding: 75px 0px 30px;
}

#qna-title {
  height: 50px;
  padding: 0 20px 0 20px;
  margin-bottom: 20px;
  border-radius: 20px;
}

#qna-content {
  padding: 20px;
  margin-bottom: 20px;
  border-radius: 20px;
  resize: none;
}
</style>
