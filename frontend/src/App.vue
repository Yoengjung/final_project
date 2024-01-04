<template>
  <Header class="custom-header" />
  <RouterView />
  <!-- <Footer /> -->
</template>

<script>
import Header from "./components/Header.vue";
// import Footer from "./components/Footer.vue";

export default {
  name: "App",
  components: {
    Header,
    // Footer,
  },
};
</script>

<style>
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
</style>
