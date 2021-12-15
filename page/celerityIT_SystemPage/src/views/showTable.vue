<!--
表格显示
-->
<template>
  <div class="showTable">
    <el-table
        :data="page.dataList"
        border
        stripe
        height="100%">
      <el-table-column type="selection"></el-table-column>
      <el-table-column v-for="(column,index) in page.columnStruct"
                       :key="index"
                       :prop="column.prop"
                       :label="column.label"
                       align="center"
                       header-align="center">
      </el-table-column>

      <!--数据操作-->
      <el-table-column
          fixed="right"
          label="操作">
        <template #default="scope">
          <el-popconfirm
              confirmButtonText='好的'
              cancelButtonText='不用了'
              icon="el-icon-info"
              @confirm="del(scope.row)"
              iconColor="red"
              title="确定要删除吗??">
            <template #reference>
              <el-button type="text" size="small">删除</el-button>
            </template>
          </el-popconfirm>
          <el-button type="text" @click="upClick(scope.row)">修改</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>

import API from '@/api/api_user'
import { checkRes } from '@/api'
import { diaLogUtil, pageUtil } from '@/utils'

export default {
  name: 'showTable',
  props: ['page', 'setDialog', 'title'],
  methods: {
    del (index) {
      API[this.$route.name].del(index).then((res) => {
        checkRes(res, {
          message: '删除成功',
          fun: () => {
            pageUtil.setPageInData(this)
          }
        }, {
          message: '删除失败',
          fun: () => {
          }
        })
      })
    },
    upClick (row) {
      diaLogUtil.diaOpen(this, {
        title: this.title,
        row: row
      })
    }
  }
}
</script>

<style scoped lang="scss">
.showTable {
  height: 75vh;
}

.el-table {
  width: 100%;
  background-color: $body-background;
}
</style>
