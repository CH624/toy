<template>
  <div class="card-body register-card-body">
    <p class="login-box-msg">Register a new membership</p>

    <form role="form" id="registerForm">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Name"
               id="name" name="name">
        <div class="input-group-append">
          <div class="input-group-text">
            <font-awesome-icon icon="user"/>
          </div>
        </div>
      </div>
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Login id"
               id="loginId" name="loginId">
        <div class="input-group-append">
          <div class="input-group-text">
            <font-awesome-icon icon="envelope"/>
          </div>
        </div>
      </div>
      <div class="input-group mb-3">
        <input type="password" class="form-control" placeholder="Password"
               id="password" name="password">
        <div class="input-group-append">
          <div class="input-group-text">
            <font-awesome-icon icon="lock"/>
          </div>
        </div>
      </div>
      <div class="input-group mb-3">
        <input type="password" class="form-control" id="retypePassword" name="retypePassword"
               placeholder="Retype password">
        <div class="input-group-append">
          <div class="input-group-text">
            <font-awesome-icon icon="lock"/>
          </div>
        </div>
      </div>
      <div class="input-group mb-2">
        <b-button variant="primary btn-block" v-on:click="register">Register</b-button>
      </div>
    </form>
    <router-link class="text-center" to="/account/login">I already have a membership</router-link>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Register',
  methods: {
    register() {
      axios.post('/register', {
        name: document.getElementById('name').value,
        loginId: document.getElementById('loginId').value,
        password: document.getElementById('password').value,
      }).then((result) => {
        if (result.data.operationStatus === 'SUCCESS') {
          this.$toastr.s('회원가입 완료')
            .onClosed = () => this.$router.push('/login');
        }
      });
    },
  },
};
</script>
