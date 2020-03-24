<template>
  <div class="hold-transition login-page">
    <div class="login-box">
      <div class="login-logo">
        <router-link to="/"><b>SurfBoard</b></router-link>
      </div>
      <div class="card">

      </div>
    </div>
  </div>
</template>

<script>
import Register from "@/components/account/Register";
import Login from "@/components/account/Login";
import Forgot from "@/components/account/Forgot";

export default {
  name: "Account",
  components: {
    Register, Login, Forgot
  },
  mounted() {
    
  }
}
</script>

<style scoped>

</style>
