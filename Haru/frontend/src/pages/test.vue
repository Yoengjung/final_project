<template>
  <div>
    <form action="">
      <input type="file" name="img" id="img" @change="selectFile" />
      <input type="text" v-model="textData" placeholder="일기를  입력하세요" />
      <button type="button" name="send" id="send" @click="sendImg">전송</button>
    </form>
    <h1>{{ label }}</h1>
    <h1>{{ confidence }}</h1>
    <h1>{{ face_score }}</h1>
    <h1>{{ diary_score }}</h1>
    <h1>{{ total_score }}</h1>
    <h1>{{ date }}</h1>
  </div>
</template>
<script>
import axios from "axios";

export default {
  name: "test",
  data() {
    return {
      textData: "",
      img: "",
      total_score: "", // 스트레스 총합
      face_score: "", // 얼굴 스트레스
      diary_score: "", // 일기 스트레스
      label: "", // 얼굴 라벨
      confidence: "", // 얼굴 라벨 정확도
      date: "", // 분석일자
      formData: new FormData(),
    };
  },
  methods: {
    selectFile(event) {
      this.formData.append("img", event.target.files[0]);
    },
    sendImg() {
      this.formData.append("text", this.textData);
      this.total_score = "이미지 처리중";
      this.face_score = "";
      this.diary_score = "";
      this.label = "";
      this.confidence = "";
      this.date = "";
      axios
        .post("http://192.168.0.227:8000/calculate/getStress1", this.formData, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then((res) => {
          this.total_score = "일기 처리중";
          console.log(res);
          if (res.data === "Face not found") {
            // 얼굴 못 찾았을 경우
            this.total_score = "얼굴을 찾을 수 없습니다.";
          } else {
            this.label = "분석된 감정 : " + res.data["label"];
            this.confidence = "정확도 : " + res.data["confidence"];
            this.face_score = "얼굴 스트레스 : " + res.data["face_score"];
            this.formData.append("face_score", res.data["face_score"]);
            this.formData.append("label", res.data["label"]);
            this.formData.append("confidence", res.data["confidence"]);
            axios
              .post(
                "http://192.168.0.227:8000/calculate/getStress2", // 이미지 처리 끝 일기 처리 시작
                this.formData,
                {
                  headers: {
                    "Content-Type": "multipart/form-data",
                  },
                }
              )
              .then((res) => {
                // 일기 처리 끝
                console.log(res);
                this.diary_score = "일기 스트레스 : " + res.data["diary_score"];
                this.total_score = "스트레스 총합 : " + res.data["total_score"];
                this.date = "분석된 날짜 : " + res.data["date"];
              });
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
