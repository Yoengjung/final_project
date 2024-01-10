<template>
<<<<<<< HEAD
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
            <li><img src="../assets/main_image.png" class="profileImg" /></li>
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
                    <span><img src="../img/mypage/image 95.png" /></span>
                    <span>123</span>
                  </div>
                </ul>
              </div>

              <div class="commentCnt-box">
                <ul>
                  <div>누적 좋아요 개수</div>
                  <div class="div-tag">
                    <span><img src="../img/mypage/image 94.png" /></span>
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
                      src="../assets/alarm_heart_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time"
                      ><img src="@/assets/time_icon.png" alt="" />10분전</span
                    >
                  </div>
                </li>
                <li>
                  <div>
                    <img
                      class="alarm-img"
                      src="../assets/kakao_login_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time"
                      ><img src="@/assets/time_icon.png" alt="" />40분전</span
                    >
                  </div>
                </li>
                <li>
                  <div>
                    <img
                      class="alarm-img"
                      src="../assets/alarm_basic_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time">23.12.27 1:03</span>
                  </div>
                </li>
                <li>
                  <div>
                    <img
                      class="alarm-img"
                      src="../assets/alarm_heart_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time">23.12.26 1:03</span>
                  </div>
                </li>
                <li>
                  <div>
                    <img
                      class="alarm-img"
                      src="../assets/alarm_comment_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time">23.12.25 1:03</span>
                  </div>
                </li>
                <li>
                  <div>
                    <img
                      class="alarm-img"
                      src="../assets/alarm_comment_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time">23.12.24 1:03</span>
                  </div>
                </li>
                <li>
                  <div>
                    <img
                      class="alarm-img"
                      src="../assets/alarm_basic_icon.png"
                    />
                    <span id="comment-content">댓글 내용</span>
                    <span class="alarm-time">23.12.23 1:03</span>
                  </div>
                </li>
              </ul>
            </div>
=======
  <div class="mypage-container">
    <h2>마이페이지</h2>
    <div class="mypage-box">
      <div class="mypage-left-box">
        <ul>
          <li><img src="../assets/main_image.png" class="profileImg" /></li>
          <li>
            <div class="nickname-box">
              <span id="nickname-tag">잘생긴 훈남</span>
            </div>
            <div class="username-box">
              <span>별명을 가진</span><span id="username-tag">고영중 님</span>
            </div>
          </li>
          <li>
            <ul class="user-activity-info">
              <li>
                <div class="commentCnt-box">
                  <ul>
                    <div>누적 댓글 갯수</div>
                    <div class="div-tag">
                      <span><img src="../img/mypage/image 95.png" /></span>
                      <span>123</span>
                    </div>
                  </ul>
                </div>
              </li>
              <li>
                <div class="commentCnt-box">
                  ]p
                  <ul>
                    <div>누적 좋아요 갯수</div>
                    <div class="div-tag">
                      <span><img src="../img/mypage/image 94.png" /></span>
                      <span>12</span>
                    </div>
                  </ul>
                </div>
              </li>
            </ul>
          </li>
          <div class="update-mydata-box">
            <a href="/updateMyPage" id="updateMyDataBtn">내 정보 수정</a>
          </div>
        </ul>
      </div>
      <div class="mypage-right-box">
        <div>
          <h3>알림</h3>
          <div class="alarm-container">
            <ul>
              <li>
                <div>
                  <img class="alarm-img" src="../assets/kakao_login_icon.png" />
                  <span id="comment-content">댓글 내용</span>
                </div>
              </li>
              <li>
                <div>
                  <img class="alarm-img" src="../assets/kakao_login_icon.png" />
                  <span id="comment-content">댓글 내용</span>
                </div>
              </li>
              <li>
                <div>
                  <img class="alarm-img" src="../assets/kakao_login_icon.png" />
                  <span id="comment-content">댓글 내용</span>
                </div>
              </li>
              <li>
                <div>
                  <img class="alarm-img" src="../assets/kakao_login_icon.png" />
                  <span id="comment-content">댓글 내용</span>
                </div>
              </li>
              <li>
                <div>
                  <img class="alarm-img" src="../assets/kakao_login_icon.png" />
                  <span id="comment-content">댓글 내용</span>
                </div>
              </li>
              <li>
                <div>
                  <img class="alarm-img" src="../assets/kakao_login_icon.png" />
                  <span id="comment-content">댓글 내용</span>
                </div>
              </li>
              <li>
                <div>
                  <img class="alarm-img" src="../assets/kakao_login_icon.png" />
                  <span id="comment-content">댓글 내용</span>
                </div>
              </li>
            </ul>
>>>>>>> BeomSeokLee
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "MyPage",
  data() {
    return {};
  },
  created() {
    // 페이지가 로드될 때 초기 이미지 설정
    this.bgImage();
  },
  methods: {
    // 해당 화면 Background 이미지 설정
    bgImage() {
      var newImage = "type1";
      this.$emit("bgImage", newImage);
    },
  },
};
</script>
<style scoped>
@import url("../css/mypage.css");
</style>
