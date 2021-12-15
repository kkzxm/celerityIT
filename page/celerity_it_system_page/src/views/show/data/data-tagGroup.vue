<template>
  <div>
    <MenuAtTopOfTable :setDialog="setDialog" title="添加单词标签组"></MenuAtTopOfTable>

    <el-table
        :data="page.dataList"
        row-key="tagGroupId"
        border
        lazy
        :default-expand-all="false"
        height="75vh"
        :tree-props="{children: 'childTagGroupSet',hasChildren:false}">
      <!--   多选框   -->
      <el-table-column type="selection"></el-table-column>
      <!--   数据显示   -->
      <el-table-column v-for="(column,index) in page.columnStruct"
                       :key="index"
                       :prop="column.prop"
                       :label="column.label">
      </el-table-column>

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

    <el-dialog
        v-model="dia.visible"
        :title="dia.title"
        width="400"
        center>
      <oper_tagGroup :setDialog="setDialog"
                     v-if="dia.visible"
                     :row="dia.row"
                     :page="page"
                     :dia="dia"
                     :title="dia.title"></oper_tagGroup>
    </el-dialog>
  </div>
</template>

<script>
import MenuAtTopOfTable from '@/views/MenuAtTopOfTable'
import oper_tagGroup from '@/views/show/operation/oper-tagGroup'
import { diaLogUtil, pageUtil, tagGroupUtil } from '@/utils'
import API from '@/api/api_user'
import { checkRes } from '@/api'

export default {
  name: 'Users-Data',
  components: {
    MenuAtTopOfTable,
    oper_tagGroup
  },
  data () {
    return {
      page: {
        dataList: [],
        total: 0,
        columnStruct: [
          {
            prop: 'tagGroupName',
            label: '单词标签组名称'
          },
          {
            prop: 'tagGroupComment',
            label: '单词标签组备注'
          }
        ],
      },
      dia: {
        visible: false,
        title: '',
        row: {}
      },
    }
  },
  methods: {
    setDialog (dialog) {
      this.dia = dialog
    },
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
        title: '修改单词标签组',
        row: row
      })
    }
  },
  created () {
    let tagGroupList = tagGroupUtil.getTagGroupList()
    if (!tagGroupList) {
      pageUtil.setPageInData(this)
    } else {
      this.page.dataList = tagGroupList
    }
  },
  updated () {
    tagGroupUtil.setTagGroupList(this.page.dataList)
  }
}
</script>

<style scoped lang="scss">
.el-table {
  width: 100%;
  background-color: $body-background;
}
</style>
