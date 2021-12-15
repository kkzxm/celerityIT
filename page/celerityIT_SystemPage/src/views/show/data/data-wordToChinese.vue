<template>
  <div>
    <MenuAtTopOfTable :setDialog="setDialog" title="添加中英互译关系"></MenuAtTopOfTable>
    <show-table :page="page" :setDialog="setDialog" title="修改中英互译关系"></show-table>
    <show-pagination :page="page"></show-pagination>
    <el-dialog
        v-model="dia.visible"
        :title="dia.title"
        size="50%"
        center>
      <oper_wordToChinese :setDialog="setDialog"
                          v-if="dia.visible"
                          :row="dia.row"
                          :page="page"
                          :dia="dia"
                          :title="dia.title"></oper_wordToChinese>
    </el-dialog>

  </div>
</template>

<script>
import showTable from "@/views/showTable";
import MenuAtTopOfTable from "@/views/MenuAtTopOfTable";
import ShowPagination from "@/views/ShowPagination";
import {pageUtil} from "@/utils";
import oper_wordToChinese from "@/views/show/operation/oper-wordToChinese";

export default {
  name: "data-wordToChinese",
  components: {showTable, MenuAtTopOfTable, ShowPagination, oper_wordToChinese},
  data() {
    return {
      page: {
        dataList: [],
        total: 0,
        columnStruct: [
          {prop: "word.wordSelf", label: "单词拼写"},
          {prop: "chinese.chineseInfo", label: "中文词组信息"},
          {prop: "wordToChineseComment", label: "单词与中文关系备注"}
        ]
      },
      dia: {
        visible: false,
        title: "",
        row: {}
      },
    }
  },
  methods: {
    setDialog(dialog) {
      this.dia = dialog;
    }
  },
  created() {
    pageUtil.setPageInData(this)
  }
}
</script>
<style scoped lang="scss">
.oper-patrol {
  padding: 30px
}
</style>
