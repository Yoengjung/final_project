<template>
  <video muted autoplay loop class="home">
    <source src="../assets/main_bg.mp4" type="video/mp4" />
  </video>
  <div class="screen-1">
    <h1>지친 현대인의 삶을 위한, 하루의 여울</h1>
    <h4>하루의 여울이 당신을 위해 안락한 곳으로 안내합니다.</h4>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
};
</script>

<style scoped>
video {
  padding: 0px;
  margin: 0px;
  max-width: 100%;
  object-fit: cover;
  z-index: -2;
}
.home {
  display: block;
  position: absolute;
  width: 100vw;
  height: 100vh;
  top: -5px;
  z-index: -1;
}

.screen-1 {
  width: 80%;
  height: 500px;
  top: 150px;
  position: relative;
  left: 50%;
  transform: translateX(-50%);
  color: white;
  z-index: 1;
}

.home .screen-1 h1 {
  margin-bottom: 20px;
}
</style>
