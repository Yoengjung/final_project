<template>
  <!-- 내 장소 - 일기 리스트 -->
  <div class="">
    <DiaryUpdate
      @close-modal="closeModal"
      v-if="modal_Check"
      :selectedDiary="selectedDiary"
      :rDate="diaryList.rdate"
    />
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
            {{ diary.diaryName }}
          </p></a
        >
      </div>

      <!-- 버튼 (수정, 삭제) -->
      <div class="myplace-diary-btn-area">
        <button
          @click="openDiaryUpdate(diary), openModal()"
          class="diary-update-btn"
        ></button>
        <button class="diary-delete-btn"></button>
      </div>
    </div>
  </div>
</template>

<script>
import DiaryUpdate from "@/components/MyDiaryUpdate.vue";

export default {
  data() {
    return {
      selectedDiary: null,
      modal_Check: false,
    };
  },
  props: {
    diaryList: Object,
  },
  components: { DiaryUpdate },
  methods: {
    openModal() {
      this.modal_Check = true;
    },

    closeModal() {
      this.modal_Check = false;
    },

    openDiaryUpdate(diary) {
      this.selectedDiary = diary;
    },
  },
};
</script>
