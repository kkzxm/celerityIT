<template>
  <el-affix position="bottom" :offset="15">
    <el-pagination
        background
        layout="prev, pager, next"
        hide-on-single-page
        :page-size="page.size"
        :current-page="page.currentPage"
        @current-change="pageChange"
        :total="page.total">
    </el-pagination>
  </el-affix>

</template>

<script>

import {pageUtil} from "@/utils";

export default {
  name: "show-pagination",
  props: ["page"],
  methods: {
    pageChange(val) {
      pageUtil.setPageInData(this, {thisPage: val})
    }
  }
}
</script>

<style scoped lang="scss">
.el-pagination{
  text-align: right;
}
</style>
