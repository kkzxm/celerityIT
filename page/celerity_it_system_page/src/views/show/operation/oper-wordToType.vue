<template>
  <div class="oper-patrol">
    <el-form ref="oper-patrol" :model="form" label-width="auto">
      <el-form-item
          prop="wordSelf"
          label="英语单词拼写">
        <el-input v-model="form.wordSelf"></el-input>
      </el-form-item>

      <el-form-item
          prop="wordTypeName"
          label="单词类型名称">
        <el-input v-model="form.wordTypeName"></el-input>
      </el-form-item>

      <el-form-item
          prop="wordAndTypeComment"
          label="单词与类型关系备注">
        <el-input v-model="form.wordAndTypeComment"></el-input>
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
  name: "oper-wordToType",
  props: ["setDialog", "title", "page", "dia"],
  data() {
    return {
      form: {
        wordId: diaLogUtil.getVal(this, 'word', 'wordId'),
        wordSelf: diaLogUtil.getVal(this, 'word', 'wordSelf'),
        wordTypeId: diaLogUtil.getVal(this, 'wordType', 'wordTypeId'),
        wordTypeName: diaLogUtil.getVal(this, 'wordType', 'wordTypeName'),
        wordAndTypeComment: diaLogUtil.getVal(this, 'wordAndTypeComment'),
      }
    };
  },
  methods: {
    onSubmit() {
      let params = new URLSearchParams();
      params.append('wordId', this.form.wordId ? this.form.wordId : '');
      params.append('wordSelf', this.form.wordSelf);
      params.append('wordTypeId', this.form.wordTypeId ? this.form.wordTypeId : '');
      params.append('wordTypeName', this.form.wordTypeName);
      params.append('wordAndTypeComment', this.form.wordAndTypeComment);
      submitUtil.onSubmit(this, params, this.form.wordId, this.form.wordTypeId);
    },
    exit() {
      diaLogUtil.diaExit(this);
    }
  }
};
</script>

<style scoped>

</style>
