<template>
  <div
    :class="{
      'bg-type1': bgType === 'type1',
      'bg-type2': bgType === 'type2',
      'bg-type3': bgType === 'type3',
    }"
  >
    <Header class="custom-header" />
    <RouterView @bgImage="updateBgImage" />
    <Footer />
  </div>
</template>

<script>
import Header from "./components/Header.vue";
import Footer from "./components/Footer.vue";

export default {
  name: "App",
  data() {
    return {
      bgType: "",
    };
  },
  components: {
    Header,
    Footer,
  },
  methods: {
    updateBgImage(bg) {
      this.bgType = bg;
    },
  },
};
</script>

<style>
/* body에 배경 이미지 설정 */
.bg-type1 {
  background-image: url("./assets/signup_bg.png");
  background-size: cover;
}
.bg-type2 {
  background-image: url("./assets/image_63.png");
  background-size: cover;
}
.bg-type3 {
  background-image: url("./assets/main_image.png");
  background-size: cover;
}
html {
  margin: 0px;
  padding: 0px;
}
/* 폰트 설정 */
@font-face {
  font-family: "SUITE-SemiBold";
  src: url("@/assets/font/SUITE-SemiBold.ttf") format("woff");
}
@font-face {
  font-family: "SUITE-Bold";
  src: url("@/assets/font/SUITE-Bold.ttf") format("woff");
}
@font-face {
  font-family: "SUITE-Heavy";
  src: url("@/assets/font/SUITE-Heavy.ttf") format("woff");
}
@font-face {
  font-family: "SUITE-Light";
  src: url("@/assets/font/SUITE-Light.ttf") format("woff");
}
@font-face {
  font-family: "SUITE-Medium";
  src: url("@/assets/font/SUITE-Medium.ttf") format("woff");
}
@font-face {
  font-family: "SUITE-Regular";
  src: url("@/assets/font/SUITE-Regular.ttf") format("woff");
}
@font-face {
  font-family: "SUITE-ExtraBold";
  src: url("@/assets/font/SUITE-ExtraBold.ttf") format("woff");
}
@font-face {
  font-family: "humanbeomseog";
  src: url("@/assets/font/휴먼범석체.ttf") format("woff");
}

/* 전체 기본 텍스트 설정 */
* {
  font-family: "SUITE";
  color: #333333;
  font-size: 16px;
  position: relative;
}
/*이미지 드래그 및 복사 방지*/
img {
  -webkit-user-select: none;
  -khtml-user-select: none;
  -moz-user-select: none;
  -o-user-select: none;
  user-select: none;
  -webkit-user-drag: none;
  -khtml-user-drag: none;
  -moz-user-drag: none;
  -o-user-drag: none;
  user-drag: none;
}

.container1 {
  padding: 80px 228px 150px;
  margin: 0 auto;
  min-height: calc(100vh - 249px); /* footer 계산용 */
}

a {
  text-decoration: none;
}

ul {
  margin: 0;
  padding-left: 0;
}

ul,
li {
  list-style: none;
}

ul,
li {
  list-style: none;
}

.cursor-p {
  cursor: pointer;
}

.main-title {
  margin-bottom: 20px;
  width: fit-content;
}

.main-title-center {
  margin: 0 auto 20px;
}

.main-title > h2,
.main-title-center > h2 {
  font-size: 1.8rem;
  font-weight: 600;
  color: #f39f7e;
}

/*big button 크기 (추가, 수정, 삭제)*/
.big-ctlbtn {
  /*button*/
  width: 180px;
  height: 50px;
  font-size: 1.1rem;
  font-weight: 500;
  border: 0;
  border-radius: 25px;
  transition: background-color 0.2s;
}

/*big button 색상 (추가, 수정, 삭제)*/
.insert-btn {
  background-color: #f7a27e;
  color: #fff;
  border: 0;
  border-radius: 25px;
}
.insert-btn:hover {
  background-color: #eb7543;
  color: #fff;
}
.update-btn {
  background-color: #f0bba4;
  color: #fff;
  border: 0;
  border-radius: 25px;
}
.update-btn:hover {
  background-color: #ed956f;
  color: #fff;
}
.delete-btn {
  background-color: #e18585;
  color: #fff;
  border: 0;
  border-radius: 25px;
}
.delete-btn:hover {
  background-color: #c74c4c;
  color: #fff;
}
.select-btn {
  background-color: #7facef;
  color: #fff;
  border: 0;
  border-radius: 25px;
}
.select-btn:hover {
  background-color: #437fd7;
  color: #fff;
}
.reset-btn {
  background-color: #ffe6c7;
  color: #000000;
  border: 0;
  border-radius: 25px;
}
.reset-btn:hover {
  background-color: #ffd49f;
  color: #000000;
}
.normal-btn {
  background-color: #ffffff;
  border: 1px solid #252525;
  color: #252525;
  border-radius: 25px;
}
.normal-btn:hover {
  background-color: rgb(235, 235, 235);
  border: 1px solid #252525;
  color: #252525;
}
.else-btn {
  background-color: #6d6d6d;
  color: #fff;
  border: 0;
  border-radius: 25px;
}
.else-btn:hover {
  background-color: #454545;
  color: #fff;
}
.cancle-btn {
  background-color: #d5d5d5;
  color: #000000;
  border: 0;
  border-radius: 25px;
}
.cancle-btn:hover {
  background-color: #c5c5c5;
  color: #000000;
}
</style>
