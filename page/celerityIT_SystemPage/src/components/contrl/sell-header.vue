<template>
  <div class="heater">
    <el-menu class="el-menu-demo"
             mode="horizontal"
             background-color="#334157"
             text-color="#fff"
             active-text-color="#fff">
      <el-menu-item class="control-left">
        <el-button @click="tagger(!leftNav.leftScroll)">
          <i :class="'el-icon-s-' + (leftNav.leftScroll?'un':'')+ 'fold'"
             style="font-size: 30px;color: white"></i>
        </el-button>
      </el-menu-item>
      <el-submenu index="2" class="submenu">
        <template #title>超级管理员</template>
        <el-menu-item index="2-1">设置</el-menu-item>
        <el-menu-item @click="content()" index="2-2">个人中心</el-menu-item>
        <el-menu-item @click="exit()" index="2-3">退出</el-menu-item>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>


import {setToken} from "@/api";

export default {
  name: "sell-heater",
  props: ["leftNav", "update"],
  data() {
    return {
      user: {}
    }
  },
  // 创建完毕状态(里面是操作)
  created() {
    this.user = JSON.parse(localStorage.getItem('userdata'))
  },
  methods: {
    // 退出登录
    exit() {
      this.$confirm("退出登录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
          .then(() => {
            setToken("")
            this.$router.push({name: "login"});
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消"
            });
          });
    },
    tagger(flag) {
      this.$emit("update", flag);
    },
    content() {

    }
  },

}
</script>

<style scoped lang="scss">
.control-left {
  border: 0 !important;

  .el-button {
    background-color: #0000;
    border: 0;
    padding: 0
  }
}

.el-menu-vertical-demo:not(.el-menu--collapse) {
  border: none;
}

.submenu {
  float: right;
}

.showImg {
  width: 26px;
  height: 26px;
  position: absolute;
  top: 17px;
  left: 17px;
  border: none;
}
</style>
