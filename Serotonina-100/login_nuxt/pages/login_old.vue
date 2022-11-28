<template>
    <div class="container">
      <form @submit.prevent="doLogin">
        <h2 class="mb-3">Login</h2>
        <div class="input">
          <label for="email">Email address</label>
          <input
            class="form-control"
            type="text"
            name="email"
            placeholder="email@adress.com"
            v-model="formLogin.username"
          />
        </div>
        <div class="input">
          <label for="password">Password</label>
          <input
            class="form-control"
            type="password"
            name="password"
            placeholder="password123"
            v-model="formLogin.password"
          />
        </div>
        <!-- <div class="alternative-option mt-4">
          You don't have an account? <span @click="moveToRegister">Register</span>
        </div> -->
        <button type="submit" class="mt-4 btn-pers" id="login_button">
          Login
        </button>
        <div
          class="alert alert-warning alert-dismissible fade show mt-5 d-none"
          role="alert"
          id="alert_1"
        >
          Lorem ipsum dolor sit amet consectetur, adipisicing elit.
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="alert"
            aria-label="Close"
          ></button>
        </div>
      </form>
    </div>
  </template>
  
  <script>
  import { btoa } from 'buffer';

 
  export default {
    // Define que essa página está acessível para todo mundo
    auth: false,
    data() {
      return {
        formLogin:{
          username: "lorin",
          password: "1234",
        }        
      };
    },

    methods:{
      async doLogin(){
        // const headerAuth = formatHeaderAuthentication();
        let headerAuth = `${Buffer.from(this.formLogin.username + ":" + this.formLogin.password, 'base64')}`

        console.log(this.formLogin.username);
        console.log(this.formLogin.password);

        // console.log(`Basic ${window.btoa(this.formLogin.username + ":" + this.formLogin.password)}`)
        // //Codifica a senha
        // // headerAuth = "Basic " + encodeURIComponent(escape(headerAuth))
        // headerAuth = `Basic ${window.btoa(this.formLogin.username + ":" + this.formLogin.password)}`
        // try{
        //   const result = await this.$axios.get("/userauth", {
        //     // headers:{
        //     //   "authorization": headerAuth 
        //     // },
        //     auth:{
        //       username: this.formLogin.username,
        //       password: this.formLogin.password
        //     },
        //   });
        try{
          let response = await this.$auth.login( 
            {  // headers:{
              // "authorization": headerAuth 
              data: this.formLogin
            },            
          )
          // data: this.formLogin })
          if (this.$auth.loggedIn) {
            console.log('Successfully Logged In')
            console.log(this.$auth.strategy.token)
            console.log(this.$auth.strategy)
            // Problema de armazenamento de token resolvido com:
            // https://dev.to/mrnaif2018/how-to-make-nuxt-auth-working-with-jwt-a-definitive-guide-9he 
            //this.$auth.setToken('local', response.data.access_token)
            this.$router.push('/outra_pagina')
        }
          // HTTP Accepted = 202
          console.log(response.status);
          if(response.status === 200)
            this.$router.push("/");
        }catch(error){
          console.log(error);
          alert("Nome ou senha incorretos!");
        }
      }
    }
  };
  </script>