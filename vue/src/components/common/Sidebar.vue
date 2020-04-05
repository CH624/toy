<template>
  <aside class="main-sidebar sidebar-light-purple elevation-4">
    <!-- Brand Logo -->
    <router-link to="/" class="brand-link">
      <img src="/static/logo.png" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">SurfBoard</span>
    </router-link>

    <!-- Sidebar -->
    <div class="sidebar">

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column nav-child-indent" data-widget="treeview"
            role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item">
            <router-link to="/dashboard" class="nav-link" active-class="active">
              <font-awesome-icon icon="tachometer-alt" class="nav-icon"/>
              <p>Dashboard</p>
            </router-link>
          </li>
          <li class="nav-item">
            <router-link to="/board" class="nav-link" active-class="active">
              <font-awesome-icon icon="clipboard-list" class="nav-icon"/>
              <p>Board</p>
            </router-link>
          </li>
        </ul>
      </nav>
    </div>
  </aside>
</template>

<script>
export default {
  name: 'Sidebar',
};
</script>
