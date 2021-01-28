<template>
  <div id="app">
    <button @click="test">测试</button>
    <div>{{see}}</div>
  </div>
</template>

<script>
import qs from 'qs'
export default {
  name: 'App',
  components: {
  },
  data(){
    return{
      see:null,
    }
  },
  methods:{
    test(){
      this.$axios({
        method:"post",
        url:'/`hello`',
        headers:{
          'Content-Type': 'application/x-www-form-urlencoded'
        },
        data: qs.stringify({"id":"1"}),
      }).then(response =>{
        this.see=response;
      })
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
