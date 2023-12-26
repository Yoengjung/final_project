<template>
  <div class="home">
    <div class="screen-1">
      <h1>지친 현대인의 삶을 위한, 하루의 여울</h1>
      <h4>하루의 여울이 당신을 위해 안락한 곳으로 안내합니다.</h4>
    </div>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
};
</script>

<style>
.header-router {
  display: block;
  position: absolute;
  width: 100vw;
  height: 100vh;
  top: -5px;
  background-repeat: no-repeat;
  background-size: cover;
  background-image: url("../assets/main_image.png");
}

.screen-1 {
  width: 80%;
  height: 500px;
  top: 250px;
  position: relative;
  left: 50%;
  transform: translateX(-50%);
  color: white;
}

.home .screen-1 h1 {
  margin-bottom: 20px;
}
</style>
