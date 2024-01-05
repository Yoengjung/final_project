<template>
  <div>
    <div v-for="(rlist, idx) in RecommendList" :key="idx">
      <div class=""></div>
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
