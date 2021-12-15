<template>
  <div class="oper-word">
    <el-form ref="operPatrol" :model="form" label-width="auto">
      <el-form-item
          prop="wordTypeName"
          label="英语单词类型名称">
        <el-input v-model="form.wordTypeName"></el-input>
      </el-form-item>

      <el-form-item
          prop="wordTypeComment"
          label="英语类型备注">
        <el-input v-model="form.wordTypeComment"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">{{ title }}</el-button>
        <el-button @click="exit">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

import {diaLogUtil, submitUtil} from "@/utils";

export default {
  name: "oper-wordType",
  props: ["setDialog", "title", "page", "dia"],
  data() {
    return {
      form: {
        wordTypeId: diaLogUtil.getVal(this, 'wordTypeId'),
        wordTypeName: diaLogUtil.getVal(this, 'wordTypeName'),
        wordTypeComment: diaLogUtil.getVal(this, 'wordTypeComment'),
      },
      depList: [{depId: "", depName: ""}],
      usersRulerList: [{rulerId: "", rulerName: ""}]
    };
  },
  created() {
  },
  methods: {
    onSubmit() {
      submitUtil.onSubmit(this, this.form, this.form.wordTypeId);
    },
    exit() {
      diaLogUtil.diaExit(this)
    }
  },
};
</script>

<style scoped>

</style>
