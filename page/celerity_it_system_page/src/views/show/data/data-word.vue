<template>
  <div>
    <MenuAtTopOfTable :setDialog="setDialog" title="添加英语单词"></MenuAtTopOfTable>

    <el-table
        :data="page.dataList"
        height="75vh">
      <el-table-column type="selection"></el-table-column>
      <el-table-column type="expand">
        <template #default="props">
          <el-form label-position="left" inline class="demo-table-expand">
            <el-form-item label="单词拼写">
              <span>{{ props.row.wordSelf }}</span>
            </el-form-item>
            <el-form-item label="单词备注">
              <span>{{ props.row.wordComment }}</span>
            </el-form-item>
            <el-form-item label="单词类型">
              <ul>
                <li v-for="type in props.row.wordTypeList" :key="type.wordTypeId">{{ type.wordTypeName }}</li>
              </ul>
            </el-form-item>
            <el-form-item label="中文翻译">
              <ul>
                <li v-for="chinese in props.row.chineseList" :key="chinese.chineseId">{{ chinese.chineseInfo }}</li>
              </ul>
            </el-form-item>
            <el-form-item label="单词标签">
              <ul>
                <li v-for="tag in props.row.wordTagList" :key="tag.wordTagId">{{ tag.wordTagName }}</li>
              </ul>
            </el-form-item>
          </el-form>
        </template>
      </el-table-column>
      <el-table-column
          label="单词拼写"
          prop="wordSelf">
      </el-table-column>
      <el-table-column
          label="单词备注"
          prop="wordComment">
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
    <show-pagination :page="page"></show-pagination>
    <el-drawer
        v-model="dia.visible"
        :title="dia.title"
        size="auto"
        center>
      <oper_word :setDialog="setDialog"
                 v-if="dia.visible"
                 :row="dia.row"
                 :page="page"
                 :dia="dia"
                 style="padding: 20px;height: 90vh;overflow-y: auto"
                 :title="dia.title"></oper_word>
    </el-drawer>
  </div>
</template>

<script>
import MenuAtTopOfTable from '@/views/MenuAtTopOfTable'
import ShowPagination from '@/views/ShowPagination'
import { diaLogUtil, pageUtil } from '@/utils'
import oper_word from '@/views/show/operation/oper-word'
import API from '@/api/api_user'
import { checkRes } from '@/api'

export default {
  name: 'data-word',
  components: {
    MenuAtTopOfTable,
    ShowPagination,
    oper_word
  },
  data () {
    return {
      page: {
        dataList: [],
        total: 0,
        columnStruct: [
          {
            prop: 'wordSelf',
            label: '英语单词拼写'
          },
          {
            prop: 'wordComment',
            label: '英语单词备注'
          },
        ]
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
        title: '修改英语单词',
        row: row
      })
    }
  },
  created () {
    pageUtil.setPageInData(this)
  }
}
</script>

<style scoped lang="scss">
.demo-table-expand {
  font-size: 0;
}

.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}

.demo-table-expand .el-form-item {
  margin: 0 70px;
  width: 30%;
}

.el-table {
  width: 100%;
  background-color: $body-background;
}
</style>
