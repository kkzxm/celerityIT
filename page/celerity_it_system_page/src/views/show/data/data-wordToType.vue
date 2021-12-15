<template>
  <div>
    <MenuAtTopOfTable :setDialog="setDialog" title="添加单词与类型关系"></MenuAtTopOfTable>
    <show-table :page="page" :setDialog="setDialog" title="修改单词与类型关系"></show-table>
    <show-pagination :page="page"></show-pagination>
    <el-dialog
        v-model="dia.visible"
        :title="dia.title"
        size="50%"
        center>
      <oper_wordToType :setDialog="setDialog"
                       v-if="dia.visible"
                       :row="dia.row"
                       :page="page"
                       :dia="dia"
                       :title="dia.title"></oper_wordToType>
    </el-dialog>

  </div>
</template>

<script>
import showTable from "@/views/showTable";
import MenuAtTopOfTable from "@/views/MenuAtTopOfTable";
import ShowPagination from "@/views/ShowPagination";
import {pageUtil} from "@/utils";
import oper_wordToType from "@/views/show/operation/oper-wordToType";

export default {
  name: "data-wordToType",
  components: {showTable, MenuAtTopOfTable, ShowPagination, oper_wordToType},
  data() {
    return {
      page: {
        dataList: [],
        total: 0,
        columnStruct: [
          {prop: "word.wordSelf", label: "单词拼写"},
          {prop: "wordType.wordTypeName", label: "单词类型名称"},
          {prop: "wordAndTypeComment", label: "单词与类型关系备注"}
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
