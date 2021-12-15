<template>
  <div class="updatePwd">
    <el-form label-width="0px" class="login_form">
      <el-form-item>
        <el-input
            placeholder="请输入旧密码"
            prefix-icon="el-icon-lock"
            v-model="pwd.oldPwd"
            show-password
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-input
            placeholder="请输入密码"
            prefix-icon="el-icon-lock"
            v-model="pwd.newPwd"
            show-password
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-input
            placeholder="确认密码"
            prefix-icon="el-icon-lock"
            v-model="pwd.affirm"
            show-password
        ></el-input>
      </el-form-item>
      <el-form-item class="submit-buttons">
        <el-button type="primary" @click="updatePwd">修改密码</el-button>
        <el-button type="primary" @click="exit">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {ElMessage} from "element-plus";
import API from "@/api/api_user";
import {checkRes} from "@/api/checkRes";
import {diaLogUtil} from "@/utils";

export default {
  name: "updatePwd",
  props: ["setDialog"],
  data() {
    return {
      pwd: {
        oldPwd: "",
        newPwd: "",
        affirm: ""
      }
    }
  },
  created() {
  },
  methods: {
    updatePwd() {
      if (this.pwd.newPwd === this.pwd.affirm && this.pwd.newPwd !== this.pwd.oldPwd) {
        let params = new URLSearchParams();
        params.append("oldPwd", this.pwd.oldPwd);
        params.append("newPwd", this.pwd.newPwd);
        API.users.updatePwd(params).then(res => {
          checkRes(res, {
            message: '密码修改成功', fun: () => {
              this.exit();
              this.$router.push({name: "login"});
            }
          }, {
            message: res.message, fun: () => {
              diaLogUtil.diaExit(this, false);
              console.log(res)
            }
          })
        })
      } else {
        this.showError();
      }
    },
    showError() {
      ElMessage({
        showClose: true,
        message: '输入有误 > > >请重新输入< < <',
        type: 'error'
      });
    },
    exit() {
      diaLogUtil.diaExit(this, false);
    }
  }
}
</script>

<style scoped lang="scss">
.updatePwd {
  margin: 0 auto;
}
</style>
