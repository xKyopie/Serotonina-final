<template>
  <div>
    <b-container>
    <img
      id="menu"
      src="~/assets/MenuHamburguer.png"
      alt="menu hamburguer"
      v-on:click="mostrarMenu"
    />
    
    <div id="menu-h">
      <img
        id="cancel"
        src="~/assets/X.png"
        alt="cancel icon"
        v-on:click="mostrarMenu"
      />
      <h1 class="menu-texto">Menu</h1>
      <br /><br />
      <NuxtLink to="/index-2"><p class="menu-content-2">Início</p></NuxtLink>
      <NuxtLink to="/conteudosPage"><p class="menu-content">Conteúdo</p></NuxtLink>
      <NuxtLink to="/salvos-copy"><p class="menu-content">Salvos</p></NuxtLink>
      <NuxtLink to="/to-do">
      <p class="menu-content">Tarefas</p></NuxtLink>
      <p class="menu-content">Configurações</p>
      <br /><br />
      <p class="menu-content-3">Sair do app</p>
    </div>
    </b-container>
  </div>
</template>

<script>
export default {
  name: 'menuHamburguer',
  methods: {
    mostrarMenu() {
      const menuH = document.getElementById('menu-h')
      const menuH2 = document.getElementById('menu')
      

      if (menuH2.style.display === 'block') {
        menuH2.style.display = 'none'
        menuH.style.display = 'block'
       
      } else {
        menuH2.style.display = 'block'
        menuH.style.display = 'none'
       
      }
    },
  },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Cabin:wght@700&family=Courier+Prime&family=Darker+Grotesque&family=Inter:wght@300;400&family=Montserrat:wght@500&family=Poppins:wght@600&family=Roboto:ital,wght@0,400;0,500;1,400&display=swap');

#menu {
  position: absolute;
  width: 30px;
  height: 20px;
  left: 40px;
  top: 20px;
  z-index: 4;
 
}

#menu-h {
  display: none;
  z-index: 10;
  background-color: #9288c7;
  position: absolute;
  width: 300px;
  height: 800px;
  font-family: 'Courier Prime', monospace;
  color: #616162;
  padding-top: 20px;
  box-shadow: 2px 2px 2px #b6b4b4;
    
}

#cancel {
  padding-left: 200px;
}

.menu-content {
  color: #616162;
  font-weight: 400;
  font-size: 24px;
  line-height: 27px;
  padding-left: 10px;
  text-decoration: none;
}

.menu-content-2 {
  color: black;
  font-weight: 400;
  font-size: 24px;
  line-height: 27px;
  padding-left: 10px;
}

.menu-content-3 {
  color: #616162;
  font-weight: 400;
  font-size: 24px;
  line-height: 27px;
  text-align: center;
  padding-bottom: 20px;
}

.menu-texto {
  text-align: center;
}
</style>