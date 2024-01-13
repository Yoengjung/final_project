<template>
  <div class="qna-Write-background">
    <div class="qna-write-container">
      <form class="qna-write-form" autocomplete="off">
        <h2>QnA</h2>
        <label for="qna-title">제목</label>
        <input type="text" placeholder="제목을 입력하세요" id="qna-title" />
        <label for="qna-content">내용</label>
        <textarea
          name="qna-content"
          id="qna-content"
          cols="30"
          rows="10"
          placeholder="내용을 입력하세요"
        ></textarea>
        <div class="btn-group">
          <button type="submit">등록</button>
          <button type="button" @click="cancel">취소</button>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
export default {
  name: "WriteQnAForm",
  data() {},
  methods: {
    cancel() {
      this.$router.push("/QnA");
    },
  },
};
</script>
<style scoped>
.qna-Write-background {
  background-image: url("@/assets/bgImage/type3.png");
  background-repeat: no-repeat;
  background-size: cover;
  padding: 100px;
}
.qna-write-container {
  padding-left: 100px;
  padding-right: 100px;
  margin: 100px;
  background-color: rgb(255, 255, 255);
  border: none;
  border-radius: 27px;
  width: 100%;
  max-width: 1463px; /* Adjust the width as needed */
  min-width: 900px;
  height: 100%;
  margin: 0 auto; /* Center the table */
  border: 0.5px solid #ccc; /* 테두리 추가 */
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
  text-align: center;
  margin-bottom: 30px;
  margin-top: 30px;
}

#qna-title {
  height: 50px;
  font-size: 20px;
  padding: 0 20px 0 20px;
  margin-bottom: 20px;
  border-radius: 20px;
}

#qna-content {
  font-size: 20px;
  padding: 20px;
  margin-bottom: 20px;
  border-radius: 20px;
  resize: none;
}
</style>
