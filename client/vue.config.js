// help link for error "You are using the runtime-only build of 
// Vue where the template option is not available. Either pre-compile 
// the templates into render functions, or use the compiler-included 
// build."https://cli.vuejs.org/config/

// vue.config.js
module.exports = {
  outputDir: 'target/dist',
  assetsDir: 'static',
  runtimeCompiler: true,
  publicPath: '/',
  devServer: {
    port: 80,
  },
}
