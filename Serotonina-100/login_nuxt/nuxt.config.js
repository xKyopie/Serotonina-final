export default {
  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: "login-teste",
    htmlAttrs: {
      lang: "en",
    },
    meta: [
      { charset: "utf-8" },
      { name: "viewport", content: "width=device-width, initial-scale=1" },
      { hid: "description", name: "description", content: "" },
      { name: "format-detection", content: "telephone=no" },
    ],
    link: [{ rel: "icon", type: "image/x-icon", href: "/favicon.ico" }],
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    // https://go.nuxtjs.dev/bootstrap
    "bootstrap-vue/nuxt",
    // https://go.nuxtjs.dev/axios
    "@nuxtjs/axios",
    "@nuxtjs/auth-next",
  ],

  auth: {
    // Options to '@nuxtjs/auth-next' module
    strategies: {
      local: {
        user: {
          autoFetch: false,
        },
        endpoints: {
          login: { url: '/login', method: 'post', propertyName: "data.token"},
          // user: { url: '/user/me', method: 'get'},
          logout: false,
        },
      },
    },
  },

  router:{
    // Define que todas as página do app só serão acessoveis se o login tiver sido realizado
    middleware: ["auth"]
  },

  // Axios module configuration: https://go.nuxtjs.dev/config-axios
  axios: {
    // Workaround to avoid enforcing hard-coded localhost:3000: https://github.com/nuxt-community/axios-module/issues/308
    baseURL: "http://localhost:8080/",
  },

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {},
};
