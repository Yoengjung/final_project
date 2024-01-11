import { createRouter, createWebHistory } from "vue-router";
import Home from "@/pages/Home.vue"; // 메인 홈

// 회원 member--------------------------------------
import Login from "@/pages/member/Login.vue";
import Signup from "@/pages/member/Signup.vue"; // 회원가입
import MyPage from "@/pages/member/MyPage.vue"; // 마이페이지
import UserConfirmation from "@/pages/member/UserConfirmation.vue"; // 내 정보 수정 화면 전 비밀번호 입력 화면
import UpdateMyInfo from "@/pages/member/UpdateMyInfo.vue"; // 내 정보 수정
import SelectHobby from "@/pages/member/SelectHobby.vue"; // 취미 및 관심사 선택

// 스트레스 분석하기 stress--------------------------------------
import Emotional_analysis from "@/pages/stress/Emotional_analysis.vue"; // 스트레스 분석 화면
import Total_stress from "@/pages/stress/Total_stress.vue"; // 결과 화면

// 피드 feed--------------------------------------
import Feed from "@/pages/feed/Feed.vue";
import InsertFeed from "@/pages/feed/InsertFeed.vue"; // 피드 생성
import UpdateFeed from "@/pages/feed/UpdateFeed.vue"; // 피드 수정
import MyFeed from "@/pages/feed/MyFeed.vue"; // 내 피드 목록

// 내 장소 myPlace--------------------------------------
import MyPlaceDiary from "@/pages/myPlace/MyPlaceDiary.vue"; // 추천 리스트 (추천 항목 + 일기)
import MyFavoritePlace from "@/pages/myPlace/MyFavoritePlace.vue"; // 찜한 장소

// 기타--------------------------------------
import Test from "@/pages/test.vue"; // test 화면

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
    component: SelectHobby,
  },
  {
    path: "/Emotional_analysis",
    name: "Emotional_analysis",
    component: Emotional_analysis,
  },
  {
    path: "/Total_stress",
    name: "Total_stress",
    component: Total_stress,
  },
  {
    path: "/MyFavoritePlace",
    name: "MyFavoritePlace",
    component: MyFavoritePlace,
  },
  {
    path: "/Test",
    name: "Test",
    component: Test,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
