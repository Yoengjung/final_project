<template>
  <Header />
  <RouterView />
  <Footer />
</template>

<script>
import Header from "./components/Header.vue";
import Footer from "./components/Footer.vue";

export default {
  name: "App",
  components: {
    Header,
    Footer,
  },
};
</script>

<style>
html {
  margin: 0px;
  padding: 0px;
}
@font-face {
  font-family: "custom-font";
  src: url("./assets/font/SUITE-SemiBold.ttf") format("woff");
}

body {
  font-family: "custom-font", sans-serif;
}
</style>
