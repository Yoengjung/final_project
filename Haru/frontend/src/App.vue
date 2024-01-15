<template>
  <div
    :class="{
      'bg-type1': bgType === 'type1',
      'bg-type2': bgType === 'type2',
      'bg-type3': bgType === 'type3',
      'bg-type4': bgType === 'type4',
      'bg-type5': bgType === 'type5',
    }"
  >
    <Header class="custom-header" />
    <RouterView @bgImage="updateBgImage" @is-main="mainPage" />
    <Footer v-if="!isMain" />
  </div>
</template>

<script>
import Header from "@/components/client/layout/Header.vue";
import Footer from "@/components/client/layout/Footer.vue";

export default {
  name: "App",
  data() {
    return {
      bgType: "",
      isMain: false,
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
    mainPage(is) {
      this.isMain = is;
    },
  },
};
</script>

<style>
<<<<<<< HEAD
html {
  margin: 0px;
  padding: 0px;
}
@font-face {
  font-family: "SUITE-SemiBold";
  src: url("./assets/font/SUITE-SemiBold.ttf") format("woff");
}
@font-face {
  font-family: "SUITE-Bold";
  src: url("./assets/font/SUITE-Bold.ttf") format("woff");
}
@font-face {
  font-family: "SUITE-Heavy";
  src: url("./assets/font/SUITE-Heavy.ttf") format("woff");
}
@font-face {
  font-family: "SUITE-Light";
  src: url("./assets/font/SUITE-Light.ttf") format("woff");
}
@font-face {
  font-family: "SUITE-Medium";
  src: url("./assets/font/SUITE-Medium.ttf") format("woff");
}
@font-face {
  font-family: "SUITE-Regular";
  src: url("./assets/font/SUITE-Regular.ttf") format("woff");
}
@font-face {
  font-family: "SUITE-ExtraBold";
  src: url("./assets/font/SUITE-ExtraBold.ttf") format("woff");
}
@font-face {
  font-family: "humanbeomseog";
  src: url("./assets/font/휴먼범석체.ttf") format("woff");
}

* {
  font-family: "SUITE";
  color: #333333;
  font-size: 16px;
  position: relative;
}

.container {
  margin: 0 auto;
}

.container1 {
  padding: 80px 228px 228px;
  margin: 0 auto;
}

a {
  text-decoration: none;
}

.cursor-p {
  cursor: pointer;
}
=======
/* 공통 css 적용 */
@import url("@/css/client/common/common.css");
/* 공통 font */
@import url("@/css/client/common/font.css");
/* 화면 별 background-image 설정 */
@import url("@/css/client/common/bgImage.css");
>>>>>>> 3452ddf317ab63b434bd437bc2e5367c419eef0b
</style>
