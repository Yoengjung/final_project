const { defineConfig } = require("@vue/cli-service");
module.exports = {
  publicPath: '/Haru/',
  outputDir:'../src/main/resources/static',
  devServer: {
    port:3000,
    proxy: {
    proxy: 'http://3.35.230.229/'
//      "/api": {
//        target: "http://localhost:80",
//        changeOrigin: true,
//        pathRewrite: {
//          "^/api": "",
//        },
//      },
    },
  },
};
