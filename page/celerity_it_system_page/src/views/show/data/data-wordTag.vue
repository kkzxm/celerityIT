<template>
  <div>
    <MenuAtTopOfTable :setDialog="setDialog" title="添加单词标签"></MenuAtTopOfTable>
    <showTable :page="page" :setDialog="setDialog" title="修改单词标签"></showTable>
    <show-pagination :page="page"></show-pagination>
    <el-dialog
        v-model="dia.visible"
        :title="dia.title"
        width="400"
        center>
      <oper_wordTag :setDialog="setDialog"
                  v-if="dia.visible"
                  :row="dia.row"
                  :page="page"
                  :dia="dia"
                  :title="dia.title"></oper_wordTag>
    </el-dialog>
  </div>
</template>

<script>
import showTable from "@/views/showTable";
import MenuAtTopOfTable from "@/views/MenuAtTopOfTable";
import ShowPagination from "@/views/ShowPagination";
import oper_wordTag from "@/views/show/operation/oper-wordTag";
import {pageUtil} from "@/utils";

export default {
  name: "data-wordTag",
  components: {showTable, MenuAtTopOfTable, ShowPagination, oper_wordTag},
  data() {
    return {
      page: {
        dataList: [],
        total: 0,
        columnStruct: [
          {prop: "wordTagName", label: "英语标签名称"},
          {prop: "tagComment", label: "单词标签备注"},
          {prop: "tagGroup.tagGroupName", label: "所属标签组名称"}
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
