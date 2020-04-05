<template>
  <div class="dashboard">
    <h1>{{ msg }}</h1>
    <b-button variant="primary" v-on:click="reverse">버튼</b-button>
    <router-link class="text-primary" to="/account/login">로그인</router-link>
  </div>
</template>

<script>

export default {
  name: 'Dashboard',
  data() {
    return {
      msg: 'Dashboard',
    };
  },
  methods: {
    reverse() {
      this.msg = this.msg.split('').reverse().join('');
    },
  },
};
</script>
