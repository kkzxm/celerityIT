<!--
表格上方菜单
-->
<template>
  <div>
    <el-affix :offset="50">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>{{ title.replace('添加', '') }}管理</el-breadcrumb-item>
      </el-breadcrumb>
      <!--
      鼠标悬浮在添加按钮上时
      -->
      <div class="btn-s">
        <el-button
            type="primary"
            size="small"
            icon="el-icon-circle-plus-outline"
            @click="setDialog({visible:true,title,row:{}})"
        >{{ title }}
        </el-button>
      </div>
    </el-affix>
    <br/>
    <br/>
  </div>
</template>

<script>
export default {
  name: "MenuAtTopOfTable",
  props: ["setDialog", "title"],
  methods: {},
  created() {
  }
};
</script>

<style scoped lang="scss">
.el-breadcrumb {
  font-size: 20px;
  line-height: 20px;
  float: left;
}

.btn-s {
  float: right;

  .el-button {
    -moz-border-radius-bottomleft: 0;
    -moz-border-radius-bottomright: 0;
    float: left;
  }
}
</style>
