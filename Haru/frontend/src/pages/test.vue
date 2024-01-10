<template>
  <div>
    <form action="">
      <input type="file" name="img" id="img" @change="selectFile" />
      <button type="button" name="send" id="send" @click="sendImg">전송</button>
    </form>
    <h1>{{ result }}</h1>
  </div>
</template>
<script>
import axios from "axios";

export default {
  name: "test",
  data() {
    return {
      result: "",
      formData: new FormData(),
    };
  },
  methods: {
    selectFile(event) {
      this.formData.append("img", event.target.files[0]);
    },
    sendImg() {
      this.result = "이미지 처리중";
      axios
        .post("http://192.168.0.215:8000/calculate/getStress1", this.formData, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then((res) => {
          this.result = "일기 처리중";
          console.log(res);
          this.formData.append("face_score", res.data);
          return axios.post(
            "http://192.168.0.215:8000/calculate/getStress2",
            this.formData,
            {
              headers: {
                "Content-Type": "multipart/form-data",
              },
            }
          );
        })
        .then((res) => {
          console.log(res);
          this.result = res.data;
        });
    },
  },
};
</script>
