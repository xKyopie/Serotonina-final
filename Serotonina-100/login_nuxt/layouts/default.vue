<template>
    <div>
        <b-navbar toggleable="lg" type="dark" variant="info">
            <b-container>
                <div class="text-left">Logado como: {{userData.username}} (id - {{userData.id}}) </div>
            <b-button size="sm" class="ml-auto" v-on:click="logout">logout</b-button>
            </b-container>            
        </b-navbar>
        <Nuxt/>
    </div>
</template>

<script>
    export default{
        computed:{
            userData(){
                // Usar este código quando quiser recuperar dados de um usuário
                return this.$auth.user;
            }
        },
        methods:{
            logout(){
                this.$auth.setUserToken("", null);
                this.$axios.setHeader('Authorization', "");
                location.reload();
            }
        }
    }
</script>