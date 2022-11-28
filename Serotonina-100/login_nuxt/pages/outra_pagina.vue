<template>
  <div>
    <b-container>
      <h1>Outra página</h1>
      <NuxtLink to="/">Ir para a Home</NuxtLink>
    </b-container>
  </div>
</template>

<script>
export default {
  name: 'OutraPagina',
  // Define que essa página só será acessível se o login tiver sido realizado
  middleware: ["auth"]
}
</script>
