<template>
  <!-- 내 장소 - [추천 리스트/ 일기] 화면 -->
  <div class="container1">
    <div class="myplace-content-area">
      <!-- 달력 -->
      <div class="myplace-calendar-area">
        <div class="myplace-calendar-container">
          <div class="myplace-calendar">
            <header>
              <button class="cal-btn-prev" @click="changeMonth(-1)"></button>
              <span>{{ calendarHeader }}</span>
              <button class="cal-btn-next" @click="changeMonth(1)"></button>
            </header>

            <table class="myplace-calendar-table">
              <thead>
                <tr>
                  <th v-for="index in week" :key="index">
                    {{ index }}
                  </th>
                </tr>
              </thead>

              <tbody>
                <tr v-for="(index, i) in days" :key="i">
                  <td
                    v-for="childIndex in index"
                    :key="childIndex"
                    :class="{ 'cal-set-today': isToday(childIndex) }"
                  >
                    {{ childIndex }}
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <!-- end calendar -->
        </div>
        <!-- end container -->
      </div>
      <div class="rightarea">
        <!-- 탭 버튼 Area -->
        <div class="myplace-tab-btn-area">
          <div
            class="tab-btn-left cursor-p"
            :class="{ 'tab-btn-active': isTabRecList === true }"
            @click="changeTab('recommend')"
          >
            추천 리스트
          </div>
          <div
            class="tab-btn-right cursor-p"
            :class="{ 'tab-btn-active': isTabRecList === false }"
            @click="changeTab('diary')"
          >
            일기
          </div>
        </div>

        <!-- 컴포넌트로 토글되는 영역 (추천리스트, 일기 리스트)myNum -->
        <div class="tab-content-area">
          <RecommendList
            :RecommendList="RecommendList"
            :isBtnHeartNone="isBtnHeartNone"
            class="rlist-container"
            v-if="isTabRecList === true"
            ref="recList"
          />
          <MyDiaryList
            :diaryList="diaryList"
            class="rlist-container"
            v-if="isTabRecList === false"
          />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import RecommendList from "@/components/client/myPlace/RecommendList.vue";
import MyDiaryList from "@/components/client/myPlace/MyDiaryList.vue";

export default {
  data() {
    return {
      // 달력 외 관련
      activeTab: "recommend", // 기본값으로 추천 리스트를 활성화
      // rDate: "2024-01-05",
      isBtnHeartNone: false, // 하트버튼이 안보여야되는지
      isTabRecList: true, // 추천 리스트 탭 활성화
      RecommendList: [
        // 추천 받았던 리스트 (날짜별)
        {
          rdate: "2024-01-15",
          recList: [
            {
              storeName: "신논현역 딸부자네 불백",
              stAddress: "서울시 강남구 꼬마빌딩 1층",
              img: require("@/img/Feed/bul.png"),
              link: "#",
              hashtag: ["푸드", "맛집", "고기", "돼지고기", "갈매기살"],
              heartOnOff: "on",
            },
            {
              storeName: "신논현역 버거킹",
              stAddress: "서울시 강남구 꼬마빌딩 2층",
              img: require("@/img/Feed/bul.png"),
              link: "#",
              hashtag: ["패스트푸드", "맛집", "와퍼"],
              heartOnOff: "off",
            },
            {
              storeName: "신논현역 버거킹",
              stAddress: "서울시 강남구 꼬마빌딩 2층",
              img: require("@/img/Feed/bul.png"),
              link: "#",
              hashtag: ["패스트푸드", "맛집", "와퍼"],
              heartOnOff: "off",
            },
          ],
        },
        {
          rdate: "2024-01-10",
          recList: [
            {
              storeName: "신논현역 와플대학",
              stAddress: "서울시 강남구 꼬마빌딩 3층",
              img: require("@/img/Feed/bul.png"),
              link: "#",
              hashtag: [
                "카페",
                "맛집",
                "와플",
                "애플시나몬",
                "레몬에이드",
                "레몬에이드",
                "레몬에이드",
              ],
              heartOnOff: "on",
            },
            {
              storeName: "신논현역 딸부자네 불백",
              stAddress: "서울시 강남구 꼬마빌딩 1층",
              img: require("@/img/Feed/bul.png"),
              link: "#",
              hashtag: [
                "푸드",
                "맛집",
                "고기",
                "돼지고기",
                "갈매기살",
                "갈매기살",
              ],
              heartOnOff: "on",
            },
          ],
        },
        {
          rdate: "2024-01-07",
          recList: [
            {
              storeName: "신논현역 버거킹",
              stAddress: "서울시 강남구 꼬마빌딩 2층",
              img: require("@/img/Feed/bul.png"),
              hashtag: ["패스트푸드", "맛집", "와퍼"],
              heartOnOff: "off",
            },
          ],
        },
      ],
      // 일기 리스트
      diaryList: {
        rdate: "2024년 01월 10일(수)",
        dList: [
          {
            diaryNum: 0,
            diaryName: "오늘 와룡산 갔다오고 나서(1)",
            dContents:
              "오늘은 크리스마스, 하얀 눈이 내리는 마법 같은 날이었다. 아침에 눈을 뜨자 창밖으로 내리쏟는 눈을 보며 설렘을 감추지 못했다. 따뜻한 코코아 한 잔을 손에 쥐고, 창가에 앉아 눈 내리는 거리를 바라봤다.오늘은 크리스마스, 하얀 눈이 내리는 마법 같은 날이었다. 아침에 눈을 뜨자 창밖으로 내리쏟는 눈을 보며 설렘을 감추지 못했다.",
          },
          {
            diaryNum: 1,
            diaryName: "오늘 와룡산 갔다오고 나서(2)",
            dContents:
              "따뜻한 코코아 한 잔을 손에 쥐고, 창가에 앉아 눈 내리는 거리를 바라봤다. 점심 식사, 우리가 나눈 웃음과 이야기들이 마음을 더욱 풍성하게 만들어주었다. 선물 교환은 언제나 즐거움의 정점을 찍는다. 서로의 마음을 담은 선물을 주고받으며, 그 속에 담긴 사랑과 감사의 마음을 느낄 수 있었다. 저녁이 되어, 가족들과 함께 크리스마스 영화를 보며 하루를 마무리했다.모든 순간이 따뜻하고, 평화롭고, 기쁨 가득했다. 오늘 하루가 주는 작은 기적들에 감사하며, 내일을 기대한다.",
          },
          {
            diaryNum: 2,
            diaryName: "강남에 맛집 탐방 후기",
            dContents: "강남에 맛집 닭도리탕타앝수육",
          },
        ],
      },
      // 달력 관련 데이터
      today: new Date(),
      week: ["일", "월", "화", "수", "목", "금", "토"],
      calendarHeader: "",
      days: [],
    };
  },
  mounted() {
    this.calendarImplementation();
  },
  created() {
    // 페이지가 로드될 때 초기 이미지 설정
    this.bgImage();
  },
  methods: {
    calendarImplementation: function () {
      this.days = [];
      const year = this.today.getFullYear();
      const month = this.today.getMonth();
      // 시작 요일 찾기
      const startDayOfTheMonth = new Date(year, month, 1).getDay();
      // 마지막 날
      const endDayOfTheMonth = new Date(year, month + 1, 0).getDate();
      // 시작날부터 마지막 날까지 채우기
      const basicDays = Array.from(
        { length: endDayOfTheMonth },
        (v, i) => i + 1
      );
      // 시작 요일까지의 빈 날짜 채우기
      // 수요일이면 startDayofTheMonth 값이 3 [null, null, null]
      const emptyDays = Array(startDayOfTheMonth).fill(null);
      // 두 배열 합치기
      const combinedDays = [...emptyDays, ...basicDays];
      // 7일씩 나누고 넣기
      for (let i = 0; i < endDayOfTheMonth + startDayOfTheMonth; i += 7) {
        this.days.push(combinedDays.slice(i, i + 7));
      }
      this.calendarHeader = `${year}년 ${month + 1} 월`;
      this.addLastWeekEmptyDays();
    },
    addLastWeekEmptyDays: function () {
      // 마지막 주에 뒤에 남는 일 채우기
      const daysLastIndex = this.days.length - 1;
      // fill -> 배열의 길이만큼 밖에 추가 안돼서 못씀
      if (this.days[daysLastIndex] !== 7) this.days[daysLastIndex].length = 7;
    },
    changeMonth: function (val) {
      this.today = new Date(
        this.today.setMonth(this.today.getMonth() + val, 1)
      );
      this.calendarImplementation();
    },

    // 해당 화면 Background 이미지 설정
    bgImage() {
      var newImage = "type5";
      this.$emit("bgImage", newImage);
    },

    // 탭 전환하기
    changeTab(tab) {
      this.activeTab = tab;
      if (tab === "recommend") {
        this.isTabRecList = true;
      } else {
        this.isTabRecList = false;
      }
    },
    isToday(day) {
      // moment 생성 -> 날짜 라이브러리
      const moment = require("moment");
      // 오늘 날짜
      const todayy = moment();
      // 오늘 날짜에 해당하면 클래스 표시 위해 format
      var indexDay = moment(
        new Date(todayy.year(), todayy.month(), day)
      ).format("YYYY-MM-DD");

      return indexDay === todayy.format("YYYY-MM-DD");
    },
  },
  components: {
    RecommendList,
    MyDiaryList,
  },
};
</script>

<style scoped>
@import "@/css/client/myPlace/myPlaceDiary.css";
@import "@/css/client/myPlace/calendar.css";

/* 오늘 날짜에 표시 */
.cal-set-today {
  background: #398ab1;
  color: #f9f9f9;
}

#calendarSection {
  text-align: center;
  text-align: -webkit-center;
  text-align: -moz-center;
}
table {
  border-spacing: 2px;
  border-collapse: separate;
}
td {
  width: 65px;
  height: 65px;
  text-align: center;
  vertical-align: baseline;
  border: 2px solid transparent;
  border-radius: 50%;
  line-height: 58px;
  cursor: pointer;
}

tr td:first-child,
tr th:first-child {
  color: red;
}
tr td:last-child,
tr th:last-child {
  color: blue;
}
</style>
