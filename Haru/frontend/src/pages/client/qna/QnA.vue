<template>
  <div class="container1">
    <div class="qna-container">
      <div class="faq-container">
        <h2 class="faq-title">Q&A 페이지</h2>
      </div>
      <div class="nav-bar">
        <!-- exact-active-class : Vue Router에서 사용되는 속성 -->
        <!-- router-link가 현재 활성화된(exact match) 상태일 때 적용할 클래스를 지정하는 데 사용 -->
        <router-link to="/QnA" class="nav-item" exact-active-class="active"
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
            <th class="qna-tr">번호</th>
            <th class="qna-tr">카테고리</th>
            <th>제목</th>
            <th>작성자</th>
            <th class="qna-tr">작성일</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="item in paginatedQnA"
            :key="item.no"
            :class="{
              noticeTR: item.category === '공지사항',
            }"
          >
            <!-- category 가 공지사항인게 먼저 정렬된 데이터 받아야됨 -->
            <td class="qna-tr">{{ item.qnanum }}</td>
            <td class="qna-tr">{{ item.qna_category
 }}</td>
            <td>
                <router-link
            :to="{ name: 'DetailQnA', params: { qnAId: item.qnanum } }"
            class="nav-item"
            exact-active-class="active"
            @click="onTitleClick(item.qnanum)"
          >
            {{ item.qna_title }}
          </router-link
          ><span
                class="qna-badge"
                :class="{
                  notAnswered: item.progress === '미답변',
                  answered: item.progress === '완료',
                }"
                >{{ item.progress }}</span
              >
            </td>
            <td class="qna-tr">{{ item.user_id.name }}</td>
            <td class="qna-tr">{{ item.qna_cdate }}</td>
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
      <div class="qna-search-container">
        <form id="qna-search-form" @submit.prevent="onSearch">
          <div class="qna-search-area">
            <input
              class="qna-search-input"
              v-model="searchQuery"
              type="text"
              placeholder="제목으로 검색하세요"
            />
            <button type="button" class="qna-search-btn" @click="onSearch">
              <img src="@/img/Feed/search_btn.png" alt="" />
            </button>
          </div>
        </form>
        <div>
          <button
            type="button"
            class="qna-write insert-btn big-ctlbtn"
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
import axios from "axios";

export default {
  data() {
    return {
      currentPage: 1,
      pageSize: 10,
      AllQna: [],
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
    this.fetchData(); // 수정된 부분
  },
  methods: {
    setCurrentPage(page) {
      if (page >= 1 && page <= this.pageCount) {
        this.currentPage = page;
        this.$emit("update:currentPage", page);
      }
    },
    goToPreviousPage() {
      if (this.currentPage > 1) {
        this.setCurrentPage(this.currentPage - 1);
      }
    },
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
      this.$router.push({ name: "WriteQnA" });
    },
    fetchData() {
      axios.get(`http://${process.env.VUE_APP_BACK_END_URL}/testQuestionList`)
        .then((res) => {
          this.AllQna = res.data || []; // 수정된 부분
          console.log(this.AllQna);
        })
        .catch((error) => {
          console.error("Error fetching QnA data", error);
        });
    },
     onTitleClick(qnanum) {
      console.log("클릭된 제목의 qnanum:", qnanum);
    },
  },
};
</script>

<style scoped>
@import url("@/css/client/qna/qnaBoard.css");
/* TAB 활성화 표시 */
.active {
  font-weight: bold; /* 활성화된 링크의 폰트 두께 */
  color: #2eb4c9; /* 활성화된 링크의 색상 */
  border-bottom: 3px solid #2eb4c9; /* 활성화된 링크의 밑줄 */
}
</style>
