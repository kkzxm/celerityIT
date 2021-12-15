<template>
  <div>
    <MenuAtTopOfTable :setDialog="setDialog" title="添加单词与标签关系"></MenuAtTopOfTable>
    <showTable :page="page" :setDialog="setDialog" title="修改单词与标签关系"></showTable>
    <show-pagination :page="page"></show-pagination>
    <el-dialog
        v-model="dia.visible"
        :title="dia.title"
        width="400"
        center>
      <oper_wordToTag :setDialog="setDialog"
                  v-if="dia.visible"
                  :row="dia.row"
                  :page="page"
                  :dia="dia"
                  :title="dia.title"></oper_wordToTag>
    </el-dialog>
  </div>
</template>

<script>
import showTable from "@/views/showTable";
import MenuAtTopOfTable from "@/views/MenuAtTopOfTable";
import ShowPagination from "@/views/ShowPagination";
import oper_wordToTag from "@/views/show/operation/oper-wordToTag";
import {pageUtil} from "@/utils";

export default {
  name: "data-wordToTag",
  components: {showTable, MenuAtTopOfTable, ShowPagination, oper_wordToTag},
  data() {
    return {
      page: {
        dataList: [],
        total: 0,
        columnStruct: [
          {prop: "word.wordSelf", label: "英语单词拼写"},
          {prop: "wordTag.wordTagName", label: "单词标签名称"},
          {prop: "wordAndTagComment", label: "单词与标签关系备注"}
        ],
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

<style scoped>

</style>
