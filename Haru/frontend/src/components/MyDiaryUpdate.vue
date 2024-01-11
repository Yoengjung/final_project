<template>
  <div>
    <div class="feed-modal-wrap" id="modal-wrap" @click="$emit('close-modal')">
      <!-- 모달창 영역 -->
      <div class="mydiary-modal-container mydiary-rec-modal" @click.stop>
        <!-- 일기 날짜 -->
        <div class="diary-date-area">
          <h2 id="diary-date-h2">{{ rDate }}</h2>
        </div>

        <!-- 일기 제목, 내용 -->
        <div class="input-diary">
          <div class="diary-title-box">
            <input
              type="text"
              name="diary-title"
              id="diary-title"
              placeholder="제목"
              maxlength="30"
              :value="selectedDiary.diaryName"
            />
          </div>
          <div class="diary-content-box">
            <textarea
              name="diary-content"
              id="diary-content"
              placeholder="어떤 일이 있었나요?"
              maxlength="1000"
              :value="selectedDiary.dContents"
            ></textarea>
          </div>
        </div>
        <!-- 일기 끝 -->

        <!-- 버튼 영역 -->
        <div class="mydiary-update-btn-area">
          <button @click="$emit('close-modal')" class="big-ctlbtn cancle-btn">
            취소하기
          </button>
          <button class="big-ctlbtn insert-btn">수정하기</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    selectedDiary: Object,
    rDate: String,
  },
  methods: {},
};
</script>
<style scoped>
@import "@/css/myPlace/myDiary.css";
</style>
