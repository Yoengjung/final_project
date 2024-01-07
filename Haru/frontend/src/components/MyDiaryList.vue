<template>
  <!-- 내 장소 - 일기 리스트 -->
  <div class="">
    <!-- 날짜 -->
    <div class="myplace-diary-date">
      <p>{{ diaryList.rdate }}</p>
    </div>

    <!-- 일기 하나씩 -->
    <div
      class="myplace-diary-area"
      v-for="(diary, idx) in diaryList.dList"
      :key="idx"
    >
      <!-- 아이콘 -->
      <div class="myplace-diary-icon-bg">
        <img src="../img/myPlace/diaryicon.png" alt="" />
      </div>

      <!-- 제목 -->
      <div class="myplace-diary-title-area">
        <a href=""
          ><p>
            {{ diary.diaryName.slice(0, 40) }}
            <!-- 38 글자 넘으면 ...처리 -->
            <span v-if="diary.diaryName.length > 38">...</span>
          </p></a
        >
      </div>

      <!-- 버튼 (수정, 삭제) -->
      <div class="myplace-diary-btn-area">
        <button class="diary-update-btn"></button>
        <button class="diary-delete-btn"></button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  props: {
    diaryList: Object,
  },
};
</script>
