<template>
  <nav class="main-header navbar navbar-expand navbar-dark navbar-purple">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#">
          <font-awesome-icon icon="bars"/>
        </a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <router-link to="/" class="nav-link">Home</router-link>
      </li>
    </ul>

    <!-- SEARCH FORM -->
    <form class="form-inline ml-3">
      <div class="input-group input-group-sm">
        <input class="form-control form-control-navbar" type="search"
               placeholder="Search" aria-label="Search">
        <div class="input-group-append">
          <button class="btn btn-navbar" type="submit">
            <font-awesome-icon icon="search"/>
          </button>
        </div>
      </div>
    </form>

    <ul class="navbar-nav ml-auto">
<!--      <li class="nav-item dropdown">-->
<!--        <a class="nav-link" data-toggle="dropdown" href="#">-->
<!--          <font-awesome-icon icon="bell"/>-->
<!--          <span class="badge badge-warning navbar-badge">15</span>-->
<!--        </a>-->
<!--        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">-->
<!--          <span class="dropdown-header">15 Notifications</span>-->
<!--          <div class="dropdown-divider"></div>-->
<!--          <a href="#" class="dropdown-item">-->
<!--            <font-awesome-icon icon="envelope" class="mr-2"/>-->
<!--            4 new messages-->
<!--            <span class="float-right text-muted text-sm">3 mins</span>-->
<!--          </a>-->
<!--          <div class="dropdown-divider"></div>-->
<!--          <a href="#" class="dropdown-item">-->
<!--            <font-awesome-icon icon="users" class="mr-2"/>-->
<!--            8 friend requests-->
<!--            <span class="float-right text-muted text-sm">12 hours</span>-->
<!--          </a>-->
<!--          <div class="dropdown-divider"></div>-->
<!--          <a href="#" class="dropdown-item">-->
<!--            <font-awesome-icon icon="file" class="mr-2"/>-->
<!--            3 new reports-->
<!--            <span class="float-right text-muted text-sm">2 days</span>-->
<!--          </a>-->
<!--          <div class="dropdown-divider"></div>-->
<!--          <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>-->
<!--        </div>-->
<!--      </li>-->
    </ul>
  </nav>
</template>

<script>
export default {
  name: 'Navbar',
  methods: {
    logout() {
      sessionStorage.removeItem('token');
      this.$router.next('/account/login');
    },
  },
};
</script>
