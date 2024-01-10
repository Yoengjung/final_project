<template>
  <!-- 내 장소 - [추천 리스트/ 일기] 화면 -->
  <div class="container1">
    <!-- <div class="page-title-area">
      <h1 class="page-upload-title">내 기록</h1>
    </div> -->

    <div class="myplace-content-area">
      <!-- 달력 -->
      <div class="myplace-calendar-area">
        <div class="myplace-calendar-container">
          <div class="myplace-calendar">
            <header>
              <h2>September</h2>

              <a class="btn-prev fontawesome-angle-left" href="#"></a>
              <a class="btn-next fontawesome-angle-right" href="#"></a>
            </header>

            <table class="myplace-calendar-table">
              <thead>
                <tr>
                  <td>Mo</td>
                  <td>Tu</td>
                  <td>We</td>
                  <td>Th</td>
                  <td>Fr</td>
                  <td>Sa</td>
                  <td>Su</td>
                </tr>
              </thead>

              <tbody>
                <tr>
                  <td class="prev-month">26</td>
                  <td class="prev-month">27</td>
                  <td class="prev-month">28</td>
                  <td class="prev-month">29</td>
                  <td class="prev-month">30</td>
                  <td class="prev-month">31</td>
                  <td>1</td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>3</td>
                  <td>4</td>
                  <td>5</td>
                  <td>6</td>
                  <td>7</td>
                  <td>8</td>
                </tr>
                <tr>
                  <td>9</td>
                  <td class="calendar-event">10</td>
                  <td>11</td>
                  <td>12</td>
                  <td>13</td>
                  <td>14</td>
                  <td>15</td>
                </tr>
                <tr>
                  <td>16</td>
                  <td>17</td>
                  <td>18</td>
                  <td>19</td>
                  <td>20</td>
                  <td class="calendar-event">21</td>
                  <td>22</td>
                </tr>

                <tr>
                  <td class="calendar-current-day calendar-event">23</td>
                  <td>24</td>
                  <td>25</td>
                  <td>26</td>
                  <td>27</td>
                  <td>28</td>
                  <td>29</td>
                </tr>
                <tr>
                  <td>30</td>
                  <td class="next-month">1</td>
                  <td class="next-month">2</td>
                  <td class="next-month">3</td>
                  <td class="next-month">4</td>
                  <td class="next-month">5</td>
                  <td class="next-month">6</td>
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

        <!-- 컴포넌트로 토글되는 영역 (추천리스트, 일기 리스트) -->
        <div class="tab-content-area">
          <RecommendList
            :RecommendList="RecommendList"
            :isBtnHeartNone="isBtnHeartNone"
            class="rlist-container"
            v-if="isTabRecList === true"
          />
          <MyDiaryList
            :diaryList="diaryList"
            class="rlist-container"
            v-if="isTabRecList === false"
          />
          <!-- {{ diaryList }} -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import RecommendList from "../components/RecommendList.vue";
import MyDiaryList from "../components/MyDiaryList.vue";

export default {
  data() {
    return {
      activeTab: "recommend", // 기본값으로 추천 리스트를 활성화
      rDate: "9월 23일",
      isBtnHeartNone: false, // 하트버튼이 안보여야되는지
      isTabRecList: true, // 추천 리스트 탭 활성화
      RecommendList: [
        // 추천 받았던 리스트 (날짜별)
        {
          rdate: "9월 23일",
          recList: [
            {
              storeName: "신논현역 딸부자네 불백",
              stAddress: "서울시 강남구 꼬마빌딩 1층",
              img: require("../img/Feed/bul.png"),
              link: "#",
              hashtag: ["푸드", "맛집", "고기", "돼지고기", "갈매기살"],
              heartOnOff: "on",
            },
            {
              storeName: "신논현역 버거킹",
              stAddress: "서울시 강남구 꼬마빌딩 2층",
              img: require("../img/Feed/bul.png"),
              link: "#",
              hashtag: ["패스트푸드", "맛집", "와퍼"],
              heartOnOff: "off",
            },
            {
              storeName: "신논현역 버거킹",
              stAddress: "서울시 강남구 꼬마빌딩 2층",
              img: require("../img/Feed/bul.png"),
              link: "#",
              hashtag: ["패스트푸드", "맛집", "와퍼"],
              heartOnOff: "off",
            },
          ],
        },
        {
          rdate: "9월 22일",
          recList: [
            {
              storeName: "신논현역 와플대학",
              stAddress: "서울시 강남구 꼬마빌딩 3층",
              img: require("../img/Feed/bul.png"),
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
              img: require("../img/Feed/bul.png"),
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
          rdate: "9월 21일",
          recList: [
            {
              storeName: "신논현역 버거킹",
              stAddress: "서울시 강남구 꼬마빌딩 2층",
              img: require("../img/Feed/bul.png"),
              hashtag: ["패스트푸드", "맛집", "와퍼"],
              heartOnOff: "off",
            },
          ],
        },
      ],
      // 일기 리스트
      diaryList: {
        rdate: "2023년 03월 23일(수)",
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
    };
  },
  created() {
    // 페이지가 로드될 때 초기 이미지 설정
    this.bgImage();
  },
  methods: {
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
  },
  components: {
    RecommendList,
    MyDiaryList,
  },
};
</script>

<style scoped>
@import "../css/myPlaceDiary.css";
@import "../css/calendar.css";
</style>
