<template>
  <div class="container1">
    <!-- 컨텐츠 -->
    <div class="mypage-box">
      <!-- title -->
      <div class="main-title">
        <h2>마이페이지</h2>
      </div>
      <div class="mypage-two-box">
        <div class="mypage-left-box">
          <ul>
            <li>
              <img src="@/assets/bgImage/type3.png" class="profileImg" />
            </li>
            <li>
              <div class="nickname-box">
                <span id="nickname-tag">잘생긴 훈남</span>
              </div>
              <div class="username-box">
                <span>별명을 가진</span><span id="username-tag">고영중 님</span>
              </div>
            </li>
            <li class="user-activity-info">
              <div class="commentCnt-box">
                <ul>
                  <div>누적 댓글 개수</div>
                  <div class="div-tag">
                    <span><img src="@/img/mypage/image 95.png" /></span>
                    <span>123</span>
                  </div>
                </ul>
              </div>

              <div class="commentCnt-box">
                <ul>
                  <div>누적 좋아요 개수</div>
                  <div class="div-tag">
                    <span><img src="@/img/mypage/image 94.png" /></span>
                    <span>12</span>
                  </div>
                </ul>
              </div>
            </li>
            <div class="update-mydata-box">
              <a
                class="big-ctlbtn update-btn"
                href="/userConfirmation"
                id="updateMyDataBtn"
                >내 정보 수정</a
              >
            </div>
          </ul>
        </div>
        <div class="mypage-right-box">
          <div class="alarm-area">
            <h3>알림</h3>
            <div class="alarm-container">
              <ul>
                <li>
                  <div>
                    <img
                      class="alarm-img"
                      src="@/assets/icon/alarm/alarm_heart_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time"
                      ><img
                        src="@/assets/icon/time_icon.png"
                        alt=""
                      />10분전</span
                    >
                  </div>
                </li>
                <li>
                  <div>
                    <img
                      class="alarm-img"
                      src="@/assets/icon/login/kakao_login_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time"
                      ><img
                        src="@/assets/icon/time_icon.png"
                        alt=""
                      />40분전</span
                    >
                  </div>
                </li>
                <li>
                  <div>
                    <img
                      class="alarm-img"
                      src="@/assets/icon/alarm/alarm_basic_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time">23.12.27 1:03</span>
                  </div>
                </li>
                <li>
                  <div>
                    <img
                      class="alarm-img"
                      src="@/assets/icon/alarm/alarm_heart_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time">23.12.26 1:03</span>
                  </div>
                </li>
                <li>
                  <div>
                    <img
                      class="alarm-img"
                      src="@/assets/icon/alarm/alarm_comment_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time">23.12.25 1:03</span>
                  </div>
                </li>
                <li>
                  <div>
                    <img
                      class="alarm-img"
                      src="@/assets/icon/alarm/alarm_comment_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time">23.12.24 1:03</span>
                  </div>
                </li>
                <li>
                  <div>
                    <img
                      class="alarm-img"
                      src="@/assets/icon/alarm/alarm_basic_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time">23.12.23 1:03</span>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";

export default {
  name: "MyPage",
  data() {
    return {
      isLoggedIn: false,
      AccessToken: "",
    };
  },
  created() {
    // 페이지가 로드될 때 초기 이미지 설정
    this.bgImage();
    this.getToken();
    this.getData();
  },
  methods: {
    // 해당 화면 Background 이미지 설정
    bgImage() {
      var newImage = "type1";
      this.$emit("bgImage", newImage);
    },
    getToken() {
      this.AccessToken = localStorage.getItem("jwtToken");
      console.log(this.AccessToken);
      if (this.AccessToken != null) {
        this.isLoggedIn = true;
      } else {
        this.isLoggedIn = false;
        this.$router.push("/login");
      }
    },
    getData() {
      axios
        .post(
          `http://${process.env.VUE_APP_BACK_END_URL}/api/auth/myPageData`,
          this.AccessToken,
          {
            headers: {
              Authorization: `Bearer ${this.AccessToken}`, // Bearer 스킴을 사용하여 토큰을 전송
              "Content-Type": "application/json", // 요청 데이터의 타입을 명시
            },
          }
        )
        .then((res) => {
          console.log(res.data);
        });
    },
  },
};
</script>
<style scoped>
@import url("@/css/client/member/mypage.css");
</style>
