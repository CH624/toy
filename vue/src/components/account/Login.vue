<template>
  <div class="card-body login-card-body">
    <p class="login-box-msg">Sign in to start your session</p>
    <form id="loginForm">
      <div v-show="loginFail">
        <div class="alert alert-danger">
          Check your id or password.
        </div>
      </div>
      <div class="input-group mb-3">
        <input type="text" class="form-control"
               placeholder="Login id" id="loginId" name="loginId">
        <div class="input-group-append">
          <div class="input-group-text">
            <font-awesome-icon icon="envelope"/>
          </div>
        </div>
      </div>
      <div class="input-group mb-3">
        <input type="password" class="form-control"
               placeholder="Password" id="password" name="password" v-on:keyup.enter="login">
        <div class="input-group-append">
          <div class="input-group-text">
            <font-awesome-icon icon="lock"/>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-8">
          <div class="icheck-primary">
            <input type="checkbox" id="remember" name="remember_me">
            <label for="remember">
              Remember Me
            </label>
          </div>
        </div>
        <div class="col-4">
          <b-button variant="primary btn-block" v-on:click="login">Sign In</b-button>
        </div>
      </div>
    </form>

    <p class="mb-1">
      <router-link to="/account/forgot">I forgot my password</router-link>
    </p>
    <p class="mb-0">
      <router-link to="/account/register">Register a new membership</router-link>
    </p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Login',
  data() {
    return {
      loginFail: false,
    };
  },
  methods: {
    login() {
      axios.post('/login', {
        loginId: document.getElementById('loginId').value,
        password: document.getElementById('password').value,
      }).then((result) => {
        if (result.data.operationStatus === 'SUCCESS') {
          sessionStorage.setItem('token', result.data.content);
          this.$router.push('/');
        } else {
          this.loginFail = true;
        }
      });
    },
  },
};
</script>
