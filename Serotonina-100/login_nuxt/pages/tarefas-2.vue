<template>
  <!-- <link href="../assets/css/main.css" rel="stylesheet"> -->
  <div>
      <BarHeader/>
     
     <div>
       <h2 class="titulo-app">Tarefas</h2>
       <article class="button">
         <img src= "../assets/Plus.png"/>
         <p> Criar tarefa</p>
       </article>
      
     </div>
    
     
      <!-- Criando Tarefas -->
      <div :key="tarefa.id" v-for="tarefa in tarefas" class="tarefas-lista">
        <ItemListaTarefas
          class="lista"
          :idTarefa="tarefa.id"
          :tarefa="tarefa.tarefa"
        >
        </ItemListaTarefas>
   
      <div id="teste"></div>

      </div>

  </div>
</template>

<script>

import BarHeader from '../components/BarHeader.vue';

export default {
  components: { BarHeader },
  data() {
    return {
      titulo: 'Conteúdos',
      pessoas: [],
    }
  },
  methods: {
    digaOla() {
      alert('Bem vindo(a) Serotonina!')
    },
  },
  
}
</script>

