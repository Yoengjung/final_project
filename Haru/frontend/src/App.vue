<template>
  <Header class="custom-header" />
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
  padding: 80px 228px;
  margin: 0 auto;
}

a {
  text-decoration: none;
}

.cursor-p {
  cursor: pointer;
}

/*small button 크기 (추가, 수정, 삭제)*/
.sm_ctlbtn {
  /*div - a*/
  min-width: 60px;
  height: fit-content;
  text-align: center;
  line-height: 40px;
  border-radius: 10px;
  padding: 0 7px;
}

/*small button 색상 (추가, 수정, 삭제)*/
.insert_smbtn {
  border: 1px solid #008dff;
}
.insert_smbtn > a {
  color: #008dff;
}
.update_smbtn {
  border: 1px solid #00ad07;
}
.update_smbtn > a {
  color: #00ad07;
}
.delete_smbtn {
  border: 1px solid #ff1414;
}
.delete_smbtn > a {
  color: #ff1414 !important;
}

/*big button 크기 (추가, 수정, 삭제)*/
.big_ctlbtn {
  /*button*/
  width: 180px;
  height: 50px;
  font-size: 1rem;
  border: 0;
  border-radius: 25px;
}

/*big button 색상 (추가, 수정, 삭제)*/
.insert_bigbtn {
  background-color: #f7a27e;
  color: #fff;
  border: 0;
  border-radius: 25px;
}
.insert_bigbtn:hover {
  background-color: #eb7543;
  color: #fff;
}
.update_bigbtn {
  background-color: #ffa559;
  color: #fff;
  border: 0;
  border-radius: 25px;
}
.update_bigbtn:hover {
  background-color: #df8b43;
  color: #fff;
}
.delete_bigbtn {
  background-color: #ff2e00;
  color: #fff;
  border: 0;
  border-radius: 25px;
}
.delete_bigbtn:hover {
  background-color: #c32300;
  color: #fff;
}
.select_bigbtn {
  background-color: #ffffff;
  border: 1px solid #0143ff;
  color: #0143ff;
  border-radius: 25px;
}
.select_bigbtn:hover {
  background-color: #f0f4ff;
  border: 1px solid #0143ff;
  color: #0143ff;
}
.reset_bigbtn {
  background-color: #ffe6c7;
  color: #000000;
  border: 0;
  border-radius: 25px;
}
.reset_bigbtn:hover {
  background-color: #ffd49f;
  color: #000000;
}
.normal_bigbtn {
  background-color: #ffffff;
  border: 1px solid #252525;
  color: #252525;
  border-radius: 25px;
}
.normal_bigbtn:hover {
  background-color: rgb(235, 235, 235);
  border: 1px solid #252525;
  color: #252525;
}
.else_bigbtn {
  background-color: #6d6d6d;
  color: #fff;
  border: 0;
  border-radius: 25px;
}
.else_bigbtn:hover {
  background-color: #454545;
  color: #fff;
}
.cancle_bigbtn {
  background-color: #e9e9e9;
  color: #000000;
  border: 0;
  border-radius: 25px;
}
.cancle_bigbtn:hover {
  background-color: #c5c5c5;
  color: #000000;
}
</style>
