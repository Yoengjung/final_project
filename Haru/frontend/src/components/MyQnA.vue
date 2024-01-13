<template>
  <div class="amu">
    <div class="qna-container">
      <div class="faq-container">
        <h2
          class="faq-title"
          style="text-align: center; padding: 75px 0 50px 0"
        >
          나의 QnA 페이지
        </h2>
      </div>
      <div class="nav-bar" style="padding: 30px">
        <router-link to="/qna" class="nav-item" exact-active-class="active"
          >Q&A</router-link
        >
        <router-link to="/myQnA" class="nav-item" exact-active-class="active"
          >나의 질문 사항</router-link
        >
        <!-- ... 기타 링크 ... -->
      </div>
      <table class="qna-table">
        <thead>
          <tr>
            <th class="QnA-tr">No</th>
            <th class="QnA-tr">카테고리</th>
            <th>제목</th>
            <th class="QnA-tr">날짜</th>
            <th class="QnA-tr">진행 상황</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in paginatedQnA" :key="item.no">
            <td class="QnA-tr">{{ item.no }}</td>
            <td class="QnA-tr">{{ item.category }}</td>
            <td>
              <a href="#">{{ item.title }}</a>
            </td>
            <td class="QnA-tr">{{ item.date }}</td>
            <td class="QnA-tr">{{ item.Progress }}</td>
          </tr>
        </tbody>
      </table>

      <div class="pagination">
        <button
          class="pagination-button"
          :class="{ disabled: currentPage === 1 }"
          @click="setCurrentPage(currentPage - 1)"
          v-if="currentPage > 1"
        >
          &lt;
        </button>

        <button
          v-for="page in pageCount"
          :key="page"
          :class="{ 'pagination-button': true, active: currentPage === page }"
          @click="setCurrentPage(page)"
        >
          {{ page }}
        </button>

        <button
          class="pagination-button"
          :class="{ disabled: currentPage === pageCount }"
          @click="setCurrentPage(currentPage + 1)"
          v-if="currentPage < pageCount"
        >
          &gt;
        </button>
      </div>
      <div class="search-container">
        <form id="search-form" @submit.prevent="onSearch">
          <div class="search-area">
            <input
              class="QnA-search-input"
              v-model="searchQuery"
              type="text"
              placeholder="Search"
            />
            <button type="button" class="QnA-search-btn" @click="onSearch">
              <img src="../img/Feed/search_btn.png" alt="" />
            </button>
          </div>
        </form>
        <div>
          <button type="button" class="QnA-Write" @click="onWrite">
            글쓰기
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      currentPage: 1,
      pageSize: 10,

      MyQna: [
        {
          no: 1,
          category: "공지사항",
          title: "배송 문의 드립니다",
          date: "2020-11-12",
          Progress: "완료",
        },
        {
          no: 2,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          date: "2017-11-22",
          Progress: "완료",
        },
        {
          no: 3,
          category: "공지사항",
          title: "배송 문의 드립니다",
          date: "2020-11-12",
          Progress: "완료",
        },
        {
          no: 4,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          date: "2017-11-22",
          Progress: "완료",
        },
        {
          no: 5,
          category: "공지사항",
          title: "배송 문의 드립니다",
          date: "2020-11-12",
          Progress: "완료",
        },
        {
          no: 6,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          date: "2017-11-22",
          Progress: "완료",
        },
        {
          no: 7,
          category: "공지사항",
          title: "배송 문의 드립니다",
          date: "2020-11-12",
          Progress: "완료",
        },
        {
          no: 8,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          date: "2017-11-22",
          Progress: "완료",
        },
        {
          no: 9,
          category: "공지사항",
          title: "배송 문의 드립니다",
          date: "2020-11-12",
          Progress: "완료",
        },
        {
          no: 7,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          date: "2017-11-22",
          Progress: "완료",
        },
        {
          no: 6,
          category: "공지사항",
          title: "배송 문의 드립니다",
          date: "2020-11-12",
          Progress: "완료",
        },
        {
          no: 5,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          date: "2017-11-22",
          Progress: "완료",
        },
        {
          no: 4,
          category: "공지사항",
          title: "배송 문의 드립니다",
          date: "2020-11-12",
          Progress: "완료",
        },
        {
          no: 3,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          date: "2017-11-22",
          Progress: "완료",
        },
        {
          no: 2,
          category: "공지사항",
          title: "배송 문의 드립니다",
          date: "2020-11-12",
          Progress: "완료",
        },
        {
          no: 1,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          date: "2017-11-22",
          Progress: "완료",
        },
      ],
    };
  },
  computed: {
    paginatedQnA() {
      const start = (this.currentPage - 1) * this.pageSize;
      const end = start + this.pageSize;
      return this.MyQna.slice(start, end);
    },
    pageCount() {
      return Math.ceil(this.MyQna.length / this.pageSize);
    },
  },
  methods: {
    toggle(index) {
      this.faqs[index].open = !this.faqs[index].open;
    },
    setCurrentPage(page) {
      // 페이지 번호가 유효한 범위 내에 있는지 확인
      if (page >= 1 && page <= this.pageCount) {
        this.currentPage = page; // 현재 페이지 상태를 업데이트

        // 부모 컴포넌트에 'update:currentPage' 이벤트를 방출하여
        // v-model이나 .sync modifier를 사용하여 바인딩된 값을 업데이트
        this.$emit("update:currentPage", page);
      }
    },
    // '이전' 버튼을 클릭했을 때의 로직
    goToPreviousPage() {
      if (this.currentPage > 1) {
        this.setCurrentPage(this.currentPage - 1);
      }
    },
    // '다음' 버튼을 클릭했을 때의 로직
    goToNextPage() {
      if (this.currentPage < this.pageCount) {
        this.setCurrentPage(this.currentPage + 1);
      }
    },
    onSearch() {
      console.log("검색 내용:", this.searchQuery);
    },
    onWrite() {
      console.log("글쓰기 페이지로 이동");
      this.$router.push({ name: "WriteQnAForm" });
    },
  },
};
</script>

<style scoped>
* {
  font-family: "SUITE";
}
.amu {
  background-image: url("@/assets/bgImage/type3.png");
}
.QnA-tr {
  text-align: center;
}
</style>
