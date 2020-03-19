<template>
  <div class="container py-5">
    <div class="row">
      <div class="col-md-2 text-center">
        <p><i class="fa fa-exclamation-triangle fa-5x"></i><br/>Status Code: 404</p>
      </div>
      <div class="col-md-10">
        <h3>OPPSSS!!!! Sorry...</h3>
        <p>
          Sorry, The page you are looking for might have been removed
          <br/>had its name changed or is temporarily unavailable.
        </p>
        <router-link class="btn btn-danger" :to="$router.go(-1)">Go Back</router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PageNotFound',
};
</script>

<style scoped>
  #footer{
    text-align: center;
    position: fixed;
    margin-left: 530px;
    bottom: 0;
  }
</style>
