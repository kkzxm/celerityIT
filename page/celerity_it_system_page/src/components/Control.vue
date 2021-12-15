<template>
  <div class="hello">
    <el-container style="height: 100%">
      <el-aside width="auto">
        <sell-left :leftNav="leftNav"></sell-left>
      </el-aside>
      <el-container>
        <el-header>
          <sell-header :leftNav="leftNav" @update="update"></sell-header>
        </el-header>
        <el-main>
            <router-view></router-view>
        </el-main>
        <el-footer height="6%">
          <sell-footer></sell-footer>
        </el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import sellHeader from "@/components/contrl/sell-header";
import sellFooter from "@/components/contrl/sell-footer";
import SellLeft from "@/components/contrl/sell-left";

export default {
  name: "Control",
  components: {SellLeft, sellHeader, sellFooter},
  data() {
    return {
      leftNav: {
        leftScroll: false
      },
    }
  },
  methods: {
    /**
     * 更变左边导航栏收宿
     */
    update(flag) {
      this.leftNav.leftScroll = flag;
    },
  },
}
</script>

<style scoped lang="scss">
.hello {
  height: 100vh;

  .el-container {
    .el-header {
      padding: 0;
      border-left: 3px solid #100f0f;
    }

    .el-aside {
      height: 100%;
    }

    .el-main {
      overflow: hidden;
      padding: 10px 10px 0;
    }

    .el-footer {
    }
  }
}
</style>
