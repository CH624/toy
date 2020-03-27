<template>
  <div class="dashboard">
    <h1>{{ msg }}</h1>
    <b-button variant="primary" v-on:click="reverse">버튼</b-button>
    <router-link class="text-primary" to="/login">로그인2</router-link>
    <b-button variant="primary" v-on:click="test">토큰 테스트</b-button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Dashboard',
  data() {
    return {
      msg: 'Dashboard',
    };
  },
  methods: {
    test() {
      axios.get('/api/member/info').then(result => console.log(result.data));
    },
    reverse() {
      this.msg = this.msg.split('').reverse().join('');
    },
  },
};
</script>

<style scoped>

</style>
