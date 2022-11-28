<template>
<div>
       <BarHeader/>

  <main>
    <h1>LOGIN</h1>
  
    <div class="create-new">  
      <input type="text" v-model="newTask" placeholder="Nome de Usuário" @keypress.enter="addTask" />
      <button @click="addTask">ADD</button>
    </div>

    <div class="create-new">  
      <input type="PASSWORD"  v-model="newTask" placeholder="Senha" @keypress.enter="addTask"/>
      <button @click="addTask">ADD</button>
    </div>

  <div>
    <NuxtLink to="/politica-privacidade">
    <button @click="addTask" class="botao-termos">Concordo com os termos de uso</button>
    </NuxtLink>
  </div>

  <div>
    <input type="checkbox">
  </div>
    <div class="tasks">
      <Task v-for="(task, i) in $store.state.tasks"
      :key="i"
      :task="task" />
    </div>
    

   
  </main>
</div>
  
</template>

<script>
export default {
  data (){
    return {
      newTask: ''
    }
  },
  methods: {
    addTask (){
      if (this.newTask) {
        this.$store.commit('ADD_TASK', this.newTask);
        this.newTask = '';
      }
    }
  }
}
</script>


