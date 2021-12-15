<template>
  <div class="left">
    <el-menu
        :uniqueOpened="true"
        :router="true"
        class="el-menu-vertical-demo"
        background-color="rgb(51, 65, 87)"
        text-color="#fff"
        :collapse="leftNav.leftScroll"
        active-text-color="#ffd04b">
      <el-menu-item index="index">
        <i class="el-icon-s-home"></i>
        <template #title>LLF-ENGLISH</template>
      </el-menu-item>

      <el-submenu v-for="left in leftNavMenu" :index="left.key" :key="left.key">
        <template #title>
          <i :class="left.title.icon"></i>
          <span>{{ left.title.val }}</span>
        </template>
        <el-menu-item v-for="item in left.items" :index="item.index" :key="item.index">
          <i :class="item.icon"></i>
          <template #title>{{ item.val }}</template>
        </el-menu-item>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
import leftNavMenu from "@/config/leftNavMenu";

export default {
  name: "sell-left",
  props: ["leftNav"],
  data() {
    return {
      leftNavMenu: []
    }
  },
  created() {
    this.leftNavMenu = leftNavMenu
  }
}
</script>

<style scoped lang="scss">
.left {
  height: 100%;

  .el-menu {
    height: 100%;
    border-right: 0;
  }
}
</style>
