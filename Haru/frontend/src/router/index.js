import { createRouter, createWebHistory } from "vue-router";
import Home from "../pages/Home.vue";
import Login from "../pages/Login.vue";
import Signup from "../pages/Signup.vue";
import UploadedImage from "../pages/UploadedImage.vue";
import Feed from "../pages/Feed.vue";
import InsertFeed from "../pages/InsertFeed.vue";
import UpdateFeed from "../pages/UpdateFeed.vue";
import MyFeed from "../pages/MyFeed.vue";
import MyPlaceDiary from "../pages/MyPlaceDiary.vue";
import MyPage from "../pages/MyPage.vue";
import UpdateMyPage from "../pages/UpdateMyPage.vue";
import UpdateMyInfo from "../pages/UpdateMyInfo.vue";
import UserConfirmation from "../pages/UserConfirmation.vue";
import SelectHobby from "../pages/SelectHobby.vue";

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
    path: "/Feed",
    name: "Feed",
    component: Feed,
  },
  {
    path: "/InsertFeed",
    name: "InsertFeed",
    component: InsertFeed,
  },
  {
    path: "/UpdateFeed",
    name: "UpdateFeed",
    component: UpdateFeed,
  },
  {
    path: "/MyFeed",
    name: "MyFeed",
    component: MyFeed,
  },
  {
    path: "/MyPlaceDiary",
    name: "MyPlaceDiary",
    component: MyPlaceDiary,
  },
  {
    path: "/MyPage",
    name: "MyPage",
    component: MyPage,
  },
  {
    path: "/UpdateMyPage",
    name: "UpdateMyPage",
    component: UpdateMyPage,
  },
  {
    path: "/UpdateMyInfo",
    name: "UpdateMyInfo",
    component: UpdateMyInfo,
  },
  {
    path: "/UserConfirmation",
    name: "UserConfirmation",
    component: UserConfirmation,
  },
  {
    path: "/SelectHobby",
    name: "SelectHobby",
    component: SelectHobby
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
