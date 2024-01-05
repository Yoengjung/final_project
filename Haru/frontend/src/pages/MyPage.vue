<template>
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
};
</script>
<style scoped>
@import url("../css/mypage.css");
</style>
