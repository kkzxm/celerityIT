
<template>
  <div class="oper-patrol">
    <el-form ref="oper-patrol" :model="form" label-width="auto">
      <el-form-item
          prop="wordSelf"
          label="英语单词拼写">
        <el-input v-model="form.wordSelf"></el-input>
      </el-form-item>

      <el-form-item
          prop="wordTagName"
          label="单词标签名称">
        <el-input v-model="form.wordTagName"></el-input>
      </el-form-item>

      <el-form-item
          prop="wordAndTagComment"
          label="单词与标签关系备注">
        <el-input v-model="form.wordAndTagComment"></el-input>
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
  name: "oper-wordToTag",
  props: ["setDialog", "title", "page", "dia"],
  data() {
    return {
      form: {
        wordId: diaLogUtil.getVal(this, 'word', 'wordId'),
        wordSelf: diaLogUtil.getVal(this, 'word', 'wordSelf'),
        wordTagId: diaLogUtil.getVal(this, 'wordTag', 'wordTagId'),
        wordTagName: diaLogUtil.getVal(this, 'wordTag', 'wordTagName'),
        wordAndTagComment: diaLogUtil.getVal(this, 'wordAndTagComment'),
      }
    };
  },
  methods: {
    onSubmit() {
      let params = new URLSearchParams();
      params.append('wordId', this.form.wordId ? this.form.wordId : '');
      params.append('wordSelf', this.form.wordSelf);
      params.append('wordTagId', this.form.wordTagId ? this.form.wordTagId : '');
      params.append('wordTagName', this.form.wordTagName);
      params.append('wordAndTagComment', this.form.wordAndTagComment);
      submitUtil.onSubmit(this, params, this.form.wordId, this.form.wordTagId);
    },
    exit() {
      diaLogUtil.diaExit(this);
    }
  }
};
</script>

<style></style>
