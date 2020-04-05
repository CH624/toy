<template>
  <div class="card">
    <b-card-header>
    aa
    </b-card-header>
    <b-card-body>
bb
    </b-card-body>
    <b-card-footer>
cc
    </b-card-footer>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Board-content',
  mounted() {
    const contentId = Number.parseInt(this.$route.params.id, 10);
    if (Number.isSafeInteger(contentId) && contentId > 0) {
      console.log(contentId);
    } else {
      this.$router.push('/board');
    }
  },
};
</script>
