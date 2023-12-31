<template>
  <div class="container">
    <div id="card">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="1037"
        height="584"
        viewBox="0 0 1037 584"
        fill="none"
      >
        <path
          d="M0 10C0 4.47715 4.47715 0 10 0H1027C1032.52 0 1037 4.47715 1037 10V574C1037 579.523 1032.52 584 1027 584H10C4.47715 584 0 579.523 0 574V10Z"
          fill="#EDEDED"
        />
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="447"
          height="584"
          viewBox="0 0 447 584"
          fill="none"
        >
          <path
            d="M0 10C0 4.47715 4.47715 0 10 0H437C442.523 0 447 4.47715 447 10V574C447 579.523 442.523 584 437 584H9.99999C4.47715 584 0 579.523 0 574V10Z"
            fill="#A2C6DD"
          />
        </svg>
      </svg>
      <div id="gif_icon"></div>
      <span id="comment1">지금의 나를 남겨주세요!</span>
      <span id="comment2"
        >Tip: 얼굴은 정면이 보여야 인식 확률이 올라갑니다!</span
      >
      <div id="img_upload">
        <div id="img_icon"></div>
        <div v-if="file_name == ''" class="comment_drag">
          끌어서 사진 올려놓기
        </div>
        <div v-else class="comment_drag">{{ file_name }}</div>
        <label for="file">
          <div v-if="file_name == ''" class="img_upload_btn">얼굴 등록하기</div>
          <div v-else class="img_upload_btn">다시 등록하기</div>
        </label>
        <button type="button" id="modal_btn" @click="modal_click">
          modal on
        </button>
        <input
          type="file"
          @change="getFileName"
          id="file"
          accept="image/*"
          hidden
        />
      </div>
    </div>
    <div id="progress_bar">
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="45"
        height="45"
        viewBox="0 0 45 45"
        fill="none"
      >
        <circle cx="22.5" cy="22.5" r="22.5" fill="#A2C6DD" />
      </svg>
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="18"
        height="18"
        viewBox="0 0 18 18"
        fill="none"
      >
        <circle cx="9" cy="9" r="9" fill="#5090AB" />
      </svg>
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="18"
        height="18"
        viewBox="0 0 18 18"
        fill="none"
      >
        <circle cx="9" cy="9" r="9" fill="#5090AB" />
      </svg>
      <svg
        xmlns="http://www.w3.org/2000/svg"
        width="18"
        height="18"
        viewBox="0 0 18 18"
        fill="none"
      >
        <circle cx="9" cy="9" r="9" fill="#5090AB" />
      </svg>
      <div id="circle">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="13"
          height="13"
          viewBox="0 0 13 13"
          fill="none"
        >
          <circle cx="6.5" cy="6.5" r="6.5" fill="#5090AB" />
        </svg>
      </div>
      <span class="progress_text_now" style="top: 23px; left: -42px"
        >사진 올리기</span
      >
      <span class="progress_text" style="top: 23px; left: 365px"
        >내 기분 쓰기</span
      >
      <span class="progress_text" style="top: 23px; left: 755px"
        >내 스트레스 분석</span
      >
      <span class="progress_text" style="top: 23px; left: 1150px">완료!</span>
    </div>
    <button id="next_btn">다음 단계</button>
  </div>
  <!-- --------------------- modal ----------------------- -->
  <div class="modal-wrap" v-show="modal_Check" @click="modal_click">
    <div class="modal-container" @click.stop="">
      <div class="modal-btn">
        <button id="modal_close" @click="modal_click"></button>
      </div>
      <div id="face_icon"></div>
      <span id="modal_comment">얼굴을 찾지 못했어요...</span>
      <div class="modal_box" style="top: 79; left: 99">
        <div class="warn"></div>
        <div id="warn_filter"></div>
        <span class="modal_text" style="top: 138; left: 32"
          >스티커나 필터를 사용한 경우</span
        >
      </div>
      <div class="modal_box" style="top: 79; left: 285">
        <div class="warn"></div>
        <div id="warn_side"></div>
        <span class="modal_text" style="top: 138; left: 50"
          >옆 모습만 나온 경우</span
        >
      </div>
      <div class="modal_box" style="top: 266; left: 99; background: #5a5a5a">
        <div class="warn"></div>
        <div id="warn_dark"></div>
        <span class="modal_text" style="top: 138; left: 41; color: white"
          >사진이 어둡게 나온 경우</span
        >
      </div>
      <div class="modal_box" style="top: 266; left: 285">
        <div class="warn"></div>
        <div id="warn_small"></div>
        <span class="modal_text" style="top: 138; left: 49"
          >얼굴이 작게 나온 경우</span
        >
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "Faceregistration",
  data() {
    return {
      file_name: "",
      model_Check: false,
    };
  },
  methods: {
    getFileName(event) {
      this.file_name = event.target.files[0].name;
    },
    modal_click() {
      this.modal_Check = !this.model_Check;
    },
  },
};
</script>
<style scoped>
body {
  position: relative;
  background: url("../img/FaceRegistration/image63.png") no-repeat;
  background-size: cover;
  width: 1920px;
  height: 1080px;
  margin-left: auto;
  margin-right: auto;
}

#card {
  position: relative;
  width: 1037px;
  height: 584px;
  top: 264px;
  left: 442px;
  border-radius: 49px;
  box-shadow: 3px 10px 15px rgba(0, 0, 0, 0.1);
}

#gif_icon {
  width: 184px;
  height: 173px;
  top: 103px;
  left: 128px;
  position: absolute;
  border-radius: 49px;
  background: url("../img/FaceRegistration/ezgif\ 2.svg"),
    lightgray -86.194px -27px / 194.114% 115.607% no-repeat;
}

#comment1 {
  width: 293px;
  height: 60px;
  top: 311px;
  left: 83px;
  position: absolute;
  color: #fff;
  font-family: SUIT-Regular, sans-serif;
  font-size: 30px;
  font-style: normal;
  font-weight: 700;
  line-height: 60px;
  /* 200% */
  letter-spacing: -0.6px;
}

#comment2 {
  width: 270px;
  height: 100px;
  top: 393px;
  left: 93px;
  position: absolute;
  color: #fff;
  text-align: center;
  font-family: SUIT-Regular, sans-serif;
  font-size: 25px;
  font-style: normal;
  font-weight: 400;
  line-height: 50px;
  /* 200% */
  letter-spacing: -0.5px;
}

#img_upload {
  width: 510px;
  height: 498px;
  top: 43px;
  left: 485px;
  position: absolute;
  flex-shrink: 0;
  border-radius: 10px;
  border: 2px dashed #828282;
}

#img_icon {
  width: 157px;
  height: 157px;
  top: 111px;
  left: 177px;
  position: absolute;
  flex-shrink: 0;
  background: url(../img/FaceRegistration/image-62.png),
    lightgray 50% / cover no-repeat;
}

.comment_drag {
  width: 223px;
  height: 120px;
  top: 264px;
  left: 149px;
  position: absolute;
  color: #929292;
  font-family: SUIT-Regular;
  font-size: 25px;
  font-style: normal;
  font-weight: 100;
  line-height: 120px;
  text-align: center;
  letter-spacing: -0.5px;
}

.img_upload_btn {
  width: 197px;
  height: 51px;
  top: 384px;
  left: 162px;
  position: absolute;
  border-radius: 20px;
  background: #81c4ee;
  border: none;
  color: #fff;
  text-align: center;
  font-family: SUIT-Regular;
  font-size: 25px;
  font-style: normal;
  font-weight: 100;
  line-height: 50px;
  letter-spacing: -0.5px;
  cursor: pointer;
}

#progress_bar {
  width: 1220px;
  height: 0px;
  top: -450px;
  left: 350px;
  position: relative;
  background: #bcbcbc;
  border: 1px solid #bcbcbc;
  display: flex;
  align-content: center;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: center;
}
#circle {
  width: 13px;
  height: 13px;
  top: -7px;
  left: 16px;
  position: absolute;
}
#progress_text_bar {
  width: 1275px;
  height: 0px;
  top: 200px;
  left: 320px;
  position: absolute;
  display: flex;
  align-content: center;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: center;
  box-sizing: content-box;
}
.progress_text_now {
  width: 125px;
  height: 60px;
  position: absolute;
  color: #00518c;
  text-align: center;
  font-family: SUIT-Regular;
  font-size: 20px;
  font-style: normal;
  font-weight: 600;
  line-height: 60px;
  letter-spacing: -0.4px;
}
.progress_text {
  width: 130px;
  height: 60px;
  position: absolute;
  color: #6892b0;
  text-align: center;
  font-family: SUIT-Regular;
  font-size: 20px;
  font-style: normal;
  font-weight: 400;
  line-height: 60px;
  letter-spacing: -0.4px;
}

#next_btn {
  width: 294px;
  height: 60px;
  top: 940px;
  left: 813px;
  position: absolute;
  border-radius: 20px;
  background: #81c4ee;
  box-shadow: 0px 3px 10px 0px rgba(0, 0, 0, 0.25);
  border: none;
  color: #fff;
  align-items: center;
  text-align: center;
  font-family: SUIT-Regular;
  font-size: 25px;
  font-style: normal;
  font-weight: 100;
  line-height: 50px; /* 200% */
  letter-spacing: -0.5px;
  cursor: pointer;
}

/* dimmed */
.modal-wrap {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.4);
}
/* modal or popup */
.modal-container {
  position: relative;
  width: 561px;
  height: 479px;
  border-radius: 20px;
  background: #dadada;
  top: 341px;
  left: 696px;
  border-radius: 10px;
  padding: 20px;
  box-sizing: border-box;
}

#modal_btn {
  width: 150px;
  height: 51px;
  top: 384px;
  left: 400px;
  position: absolute;
  border-radius: 20px;
  background: #81c4ee;
  border: none;
  color: #fff;
  text-align: center;
  font-family: SUIT-Regular;
  font-size: 25px;
  font-style: normal;
  font-weight: 100;
  line-height: 50px;
  letter-spacing: -0.5px;
  cursor: pointer;
}

#face_icon {
  width: 64px;
  height: 54px;
  top: 18px;
  left: 124px;
  position: absolute;
  background: url("../img/FaceRegistration/image-73.png");
  flex-shrink: 0;
}

#modal_close {
  width: 39px;
  height: 36px;
  top: 15px;
  left: 507px;
  position: absolute;
  background: url("../img/FaceRegistration/image-74.png");
  flex-shrink: 0;
  border: none;
}

#modal_comment {
  width: 246px;
  height: 38px;
  top: 29px;
  left: 190px;
  position: absolute;
  color: #000;
  font-family: SUIT-Regular;
  font-size: 25px;
  font-style: normal;
  font-weight: 500;
  line-height: 30px;
  letter-spacing: -0.5px;
}

.modal_box {
  width: 175px;
  height: 175px;
  position: absolute;
  border-radius: 10px;
  background: #fff;
  flex-shrink: 0;
}

.warn {
  width: 37px;
  height: 37px;
  top: 11px;
  left: 10px;
  position: absolute;
  background: url("../img/FaceRegistration/image-79.png");
}

#warn_filter {
  width: 68px;
  height: 86px;
  top: 36px;
  left: 53px;
  position: absolute;
  background: url("../img/FaceRegistration/image-75.png") no-repeat;
}

#warn_side {
  width: 68px;
  height: 86px;
  top: 50px;
  left: 53px;
  position: absolute;
  background: url("../img/FaceRegistration/image-76.png") no-repeat;
}

#warn_dark {
  width: 68px;
  height: 86px;
  top: 54px;
  left: 53px;
  position: absolute;
  background: url("../img/FaceRegistration/image-77.png") no-repeat;
}

#warn_small {
  width: 68px;
  height: 86px;
  top: 70px;
  left: 53px;
  position: absolute;
  background: url("../img/FaceRegistration/image-78.png") no-repeat;
}

.modal_text {
  position: absolute;
  color: #000;
  font-family: SUIT-Regular;
  font-size: 10px;
  font-style: normal;
  font-weight: 500;
  line-height: 30px;
  letter-spacing: -0.2px;
}
</style>
