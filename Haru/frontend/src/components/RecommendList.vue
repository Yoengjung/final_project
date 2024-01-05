<template>
  <div>
    <div v-for="(rlist, idx) in RecommendList" :key="idx">
      <p>{{ rlist.rdate }}</p>
      {{ rlist.recList }}
      <!-- <div v-for="(item, i) in " key="idx">
        {{ item }}
      </div> -->
    </div>
  </div>
</template>
<script>
export default {
  props: {
    RecommendList: Object,
  },
};
</script>
<style scoped>
@import "../css/MyPlaceDiary.css";
</style>
