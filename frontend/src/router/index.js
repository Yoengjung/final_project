import { createRouter, createWebHistory } from "vue-router";
import Home from "../pages/Home.vue";
import Login from "../pages/Login.vue";
import agreeAddress from "../pages/AgreeAddress.vue";
import Signup from "../pages/Signup.vue";
import UploadedImage from "../pages/UploadedImage.vue";
const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/agreeAddress",
    name: "agreeAddress",
    component: agreeAddress,
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
  },
  {
    path: "/UploadedImage",
    name: "UploadedImage",
    component: UploadedImage,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
