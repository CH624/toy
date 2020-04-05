<template>
  <div id="app">
    <div class="hold-transition sidebar-mini">
      <div class="wrapper">
        <Navbar/>
        <Sidebar/>
        <div class="content-wrapper p-3">
          <router-view/>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Sidebar from '@/components/common/Sidebar';
import Navbar from '@/components/common/Navbar';

export default {
  name: 'App',
  components: { Sidebar, Navbar },
};
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
</style>
