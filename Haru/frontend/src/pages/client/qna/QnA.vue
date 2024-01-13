<template>
  <div class="container1">
    <div class="qna-container">
      <div class="faq-container">
        <h2 class="faq-title">QnA 페이지</h2>
      </div>
      <div class="nav-bar">
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
            <th class="QnA-tr">번호</th>
            <th class="QnA-tr">카테고리</th>
            <th>제목</th>
            <th>작성자</th>
            <th class="QnA-tr">작성일</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="item in paginatedQnA"
            :key="item.no"
            :class="{
              noticeTR:
                item.category === '공지사항' ||
                item.category === '자주 묻는 질문',
            }"
          >
            <!-- category 가 공지사항인게 먼저 정렬된 데이터 받아야됨 -->
            <td class="QnA-tr">{{ item.no }}</td>
            <td class="QnA-tr">{{ item.category }}</td>
            <td>
              <a href="#">{{ item.title }}</a
              ><span
                class="qna-badge"
                :class="{
                  notAnswered: item.progress === '미답변',
                  answered: item.progress === '완료',
                }"
                >{{ item.progress }}</span
              >
            </td>
            <td class="QnA-tr">{{ item.writer }}</td>
            <td class="QnA-tr">{{ item.date }}</td>
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
              <img src="@/img/Feed/search_btn.png" alt="" />
            </button>
          </div>
        </form>
        <div>
          <button
            type="button"
            class="insert-btn QnA-Write big-ctlbtn"
            @click="onWrite"
          >
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
      pageSize: 10, // Number of items per page
      // ... more FAQs

      AllQna: [
        // Populate this array with your Q&A items
        {
          no: 4,
          category: "공지사항",
          title: "배송 문의 드립니다",
          writer: "관리자",
          date: "2020-11-12",
        },
        {
          no: 3,
          category: "공지사항",
          title: "부적절한 블라블라 내용 삭제 요청",
          writer: "관리자",
          date: "2017-11-22",
        },
        {
          no: 2,
          category: "자주 묻는 질문",
          title: "배송 문의 드립니다",
          writer: "관리자",
          date: "2020-11-12",
        },
        {
          no: 1,
          category: "자주 묻는 질문",
          title: "부적절한 블라블라 내용 삭제 요청",
          writer: "관리자",
          date: "2017-11-22",
        },
        {
          no: 16,
          category: "이용문의",
          title: "배송 문의 드립니다",
          writer: "고구마",
          progress: "미답변",
          date: "2020-11-12",
        },
        {
          no: 15,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          writer: "고구마",
          progress: "미답변",
          date: "2017-11-22",
        },
        {
          no: 14,
          category: "이용문의",
          title: "배송 문의 드립니다",
          writer: "고구마",
          progress: "미답변",
          date: "2020-11-12",
        },
        {
          no: 13,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          writer: "고구마",
          progress: "미답변",
          date: "2017-11-22",
        },
        {
          no: 12,
          category: "이용문의",
          title: "배송 문의 드립니다",
          writer: "고구마",
          progress: "완료",
          date: "2020-11-12",
        },
        {
          no: 11,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          writer: "고구마",
          progress: "완료",
          date: "2017-11-22",
        },
        {
          no: 10,
          category: "이용문의",
          title: "배송 문의 드립니다",
          writer: "고구마",
          progress: "완료",
          date: "2020-11-12",
        },
        {
          no: 9,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          writer: "고구마",
          progress: "완료",
          date: "2017-11-22",
        },
        {
          no: 8,
          category: "이용문의",
          title: "배송 문의 드립니다",
          writer: "고구마",
          progress: "완료",
          date: "2020-11-12",
        },
        {
          no: 7,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          writer: "고구마",
          progress: "완료",
          date: "2017-11-22",
        },
        {
          no: 6,
          category: "이용문의",
          title: "배송 문의 드립니다",
          writer: "고구마",
          progress: "완료",
          date: "2020-11-12",
        },
        {
          no: 5,
          category: "이용문의",
          title: "부적절한 블라블라 내용 삭제 요청",
          writer: "고구마",
          progress: "완료",
          date: "2017-11-22",
        },
        // ... more items
      ],
    };
  },
  computed: {
    paginatedQnA() {
      const start = (this.currentPage - 1) * this.pageSize;
      const end = start + this.pageSize;
      return this.AllQna.slice(start, end);
    },
    pageCount() {
      return Math.ceil(this.AllQna.length / this.pageSize);
    },
  },
  created() {
    this.$emit("bgImage", "type3");
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
.noticeTR {
  background-color: #efefef;
  font-weight: 600;
}

.faq-title {
  text-align: center;
  padding: 75px 0px 30px;
}

.pagination {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px; /* 버튼 사이의 간격 */
  margin-top: 40px;
  margin-bottom: 30px;
}

.pagination-button {
  padding: 7px;
  border: none;
  background-color: #fff; /* 하얀 배경 */
  cursor: pointer;
  transition: background-color 0.2s ease-in-out;
  font-size: 16px;
}

.pagination-button.active {
  color: black;
  font-weight: bold;
}

.pagination-button.disabled {
  cursor: default;
  opacity: 0.5; /* 비활성화된 버튼은 더 흐릿하게 */
}

.QnA-Write {
  transition: transform 0.3s;
}
.QnA-Write:hover {
  transform: scale(1.05); /* 호버 시 버튼 확대 */
}
.qna-container {
  padding-left: 100px;
  padding-right: 100px;
  margin: 100px;
  background-color: rgb(255, 255, 255);
  border: none;
  border-radius: 27px;
  width: 100%;
  max-width: 1463px;
  min-width: 900px;
  height: 100%;
  margin: 0 auto;
}

.qna-table {
  background-color: rgb(255, 255, 255);
  width: 100%;
  border-collapse: collapse;
  text-align: left;
  line-height: 1.5;
  padding: 5%;
}

#search-form {
  width: 530px;
  margin-bottom: 0;
}

.search-area {
  background-color: rgb(255, 255, 255);
  width: fit-content;
  margin: 0 auto;
  position: relative;
}

.QnA-search-input {
  width: 500px;
  border-radius: 10px;
  border: 1px solid #dbdbdb;
  padding: 15px 30px;
  padding-right: 50px;
}

.qna-table thead th {
  padding: 10px;
  background-color: #fbbda4;
  text-align: center;
}

.qna-table tbody td {
  padding: 10px;
  border-bottom: 1px solid #e0e0e0;
}

.qna-table tbody td a {
  color: #333;
}

.qna-table tbody tr:hover {
  background-color: #f9f9f9; /* Hover state background */
}

.nav-bar {
  display: flex; /* 요소들을 수평 정렬 */
  justify-content: center; /* 중앙 정렬 */
  padding: 10px 0; /* 위아래 패딩 */
  list-style: none; /* 리스트 스타일 제거 */
  background-color: #ffffff; /* 배경색 */
  margin: 10px 0 50px;
}

.nav-bar:active {
  color: black;
}
.nav-item {
  padding: 10px 15px; /* 패딩 */
  margin: 0 10px; /* 좌우 마진 */
  text-decoration: none; /* 밑줄 제거 */
  color: #333; /* 텍스트 색상 */
  font-size: 19px; /* 폰트 사이즈 */
  border-radius: 4px; /* 둥근 모서리 */
  transition: background-color 0.3s; /* 배경색 변경 효과 */
}

.nav-item:hover {
  background-color: #e2e2e2; /* 호버 시 배경색 */
}

.active {
  font-weight: bold; /* 활성화된 링크의 폰트 두께 */
  color: #2eb4c9; /* 활성화된 링크의 색상 */
  border-bottom: 3px solid #2eb4c9; /* 활성화된 링크의 밑줄 */
}

.QnA-tr {
  text-align: center;
}

.QnA-search-btn {
  width: fit-content;
  height: fit-content;
  border: none;
  background: none;
  position: absolute;
  right: 10px;
  top: 11px;
}

.QnA-search-btn > img {
  width: 34px;
  z-index: 10;
}

.search-container {
  display: flex;
  width: fit-content;
  align-items: center;
  margin: 0 auto;
  padding-bottom: 40px;
}
.qna-badge {
  display: inline-block;
  width: fit-content;
  padding: 3px 12px;
  border-radius: 20px;
  margin-left: 15px;
  font-weight: 600;
  font-size: 14px;
}
.notAnswered {
  background-color: #fdd;
  color: red;
}
.answered {
  background-color: #def;
  color: #1d8eff;
}
</style>
