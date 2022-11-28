<template>
  <div>
    <b-container>
      <h1>Home</h1>
    </b-container>
  </div>
</template>

<script>
export default {
  name: 'IndexP',
  // Define que essa página só será acessível se o login tiver sido realizado
  middleware: ["auth"]
}
</script>
