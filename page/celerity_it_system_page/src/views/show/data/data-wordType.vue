<template>
  <div>
    <MenuAtTopOfTable :setDialog="setDialog" title="添加单词类型"></MenuAtTopOfTable>
    <showTable :page="page" :setDialog="setDialog" title="修改单词类型"></showTable>
    <show-pagination :page="page"></show-pagination>
    <el-dialog
        v-model="dia.visible"
        :title="dia.title"
        width="400"
        center>
      <oper_wordType :setDialog="setDialog"
                  v-if="dia.visible"
                  :row="dia.row"
                  :page="page"
                  :dia="dia"
                  :title="dia.title"></oper_wordType>
    </el-dialog>
  </div>
</template>

<script>
import showTable from "@/views/showTable";
import MenuAtTopOfTable from "@/views/MenuAtTopOfTable";
import ShowPagination from "@/views/ShowPagination";
import oper_wordType from "@/views/show/operation/oper-wordType";
import {pageUtil} from "@/utils";

export default {
  name: "data-wordType",
  components: {showTable, MenuAtTopOfTable, ShowPagination, oper_wordType},
  data() {
    return {
      page: {
        dataList: [],
        total: 0,
        columnStruct: [
          {prop: "wordTypeName", label: "单词类型名称"},
          {prop: "wordTypeComment", label: "单词类型备注"}
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
