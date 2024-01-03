import { createRouter, createWebHistory } from "vue-router";
import Home from "../pages/Home.vue";
import Login from "../pages/Login.vue";
import Signup from "../pages/Signup.vue";
import UploadedImage from "../pages/UploadedImage.vue";
import FaceRegistration from "../pages/FaceRegistration.vue";
import Feed from "../pages/Feed.vue";
import DiaryRegistration from "../pages/DiaryRegistration.vue";
import InsertFeed from "../pages/InsertFeed.vue";
import WriteDiary from "../pages/WriteDiary.vue";
import UpdateFeed from "../pages/UpdateFeed.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/Login",
    name: "Login",
    component: Login,
  },
  {
    path: "/Signup",
    name: "Signup",
    component: Signup,
  },
  {
    path: "/UploadedImage",
    name: "UploadedImage",
    component: UploadedImage,
  },
  {
    path: "/FaceRegistration",
    name: "FaceRegistration",
    component: FaceRegistration,
  },
  {
    path: "/Feed",
    name: "Feed",
    component: Feed,
  },
  {
    path: "/DiaryRegistration",
    name: "DiaryRegistration",
    component: DiaryRegistration,
  },
  {
    path: "/InsertFeed",
    name: "InsertFeed",
    component: InsertFeed,
  },
  {
    path: "/WriteDiary",
    name: "WriteDiary",
    component: WriteDiary,
  },
  {
    path: "/UpdateFeed",
    name: "UpdateFeed",
    component: UpdateFeed,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
