<template>
  <div class="pro-bar">
    <ul>
      <li>
        <i class="icons awesome fa-solid fa-user active"></i>
        <div class="step first">
          <p>1</p>
          <i class="awesome fa-solid fa-check"></i>
        </div>
        <p class="label">사진올리기</p>
      </li>
      <li>
        <i class="icons awesome fa-solid fa-coins"></i>
        <div class="step second">
          <p>2</p>
          <i class="awesome fa-solid fa-check"></i>
        </div>
        <p class="label">내 기분 쓰기</p>
      </li>
      <li>
        <i class="icons awesome fa-solid fa-house"></i>
        <div class="step third">
          <p>3</p>
          <i class="awesome fa-solid fa-check"></i>
        </div>
        <p class="label">내 스트레스 분석</p>
      </li>
      <li>
        <i class="icons awesome fa-regular fa-star-half-stroke"></i>
        <div class="step fourth">
          <p>4</p>
          s
          <i class="awesome fa-solid fa-check"></i>
        </div>
        <p class="label">완료!</p>
      </li>
    </ul>
    <!-- 진행바 끝 -->
  </div>
</template>
<script>
export default {
  name: "stressbar",
};
</script>
<style scope>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.main {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

ul {
  display: flex;
  justify-content: center;
  padding: 0;
}

ul li {
  list-style: none;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: 0 40px;
}

ul li .icons {
  font-size: 25px;
  color: #1b761b;
  margin: 0 60px;
}

ul li .label {
  font-family: sans-serif;
  letter-spacing: 1px;
  font-size: 14px;
  font-weight: thin;
  color: #6892b0;
}

ul li .step {
  height: 30px;
  width: 30px;
  border-radius: 50%;
  background-color: #6892b0;
  margin: 16px 0 10px;
  display: grid;
  place-items: center;
  color: ghostwhite;
  position: relative;
  cursor: pointer;
  z-index: 0;
}

.step::after {
  content: "";
  position: absolute;
  width: 170px;
  height: 2px;
  background-color: #6892b0;
  right: 30px;
}

.first::after {
  width: 0;
  height: 0;
}

ul li .step .awesome {
  display: none;
}

ul li .step p {
  font-size: 18px;
}

ul li .active {
  background-color: #5fa7db;
}

li .active::after {
  background-color: #5fa7db;
}

ul li .active p {
  display: none;
}

ul li .active .awesome {
  display: flex;
}
</style>
