<template>
  <div>
    <MenuAtTopOfTable :setDialog="setDialog" title="添加中文组词"></MenuAtTopOfTable>
    <showTable :page="page" :setDialog="setDialog" title="修改中文组词"></showTable>
    <show-pagination :page="page"></show-pagination>
    <el-dialog
        v-model="dia.visible"
        :title="dia.title"
        width="400"
        center>
      <oper_chinese :setDialog="setDialog"
                v-if="dia.visible"
                :row="dia.row"
                :page="page"
                :dia="dia"
                :title="dia.title"></oper_chinese>
    </el-dialog>
  </div>
</template>

<script>
import MenuAtTopOfTable from "@/views/MenuAtTopOfTable";
import ShowPagination from "@/views/ShowPagination";
import {pageUtil} from "@/utils";
import oper_chinese from "@/views/show/operation/oper-chinese";
import showTable from "@/views/showTable";

export default {
  name: "data-chinese",
  components: {showTable, MenuAtTopOfTable, ShowPagination, oper_chinese},
  data() {
    return {
      page: {
        dataList: [],
        total: 0,
        columnStruct: [
          {prop: "chineseInfo", label: "中文词组信息"},
          {prop: "chineseComment", label: "中文词组备注"},
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

<style scoped>

</style>
