<template>
<div>
       <BarHeader/>

  <main>
    <h1>TO DO LIST</h1>
    <p>O que você precisa fazer hoje? </p>

    <div class="create-new">  
      <input type="text" v-model="newTask" placeholder="Adicionar tarefa" @keypress.enter="addTask" />
      <button @click="addTask">ADD</button>
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

