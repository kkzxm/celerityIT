
<template>
  <div class="oper-patrol">
    <el-form ref="oper-patrol" :model="form" label-width="auto">
      <el-form-item
          prop="wordSelf"
          label="英语单词拼写">
        <el-input v-model="form.wordSelf"></el-input>
      </el-form-item>

      <el-form-item
          prop="chineseInfo"
          label="中文组词信息">
        <el-input v-model="form.chineseInfo"></el-input>
      </el-form-item>

      <el-form-item
          prop="wordToChineseComment"
          label="中英互译关系备注">
        <el-input v-model="form.wordToChineseComment"></el-input>
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
  name: "oper-wordToChinese",
  props: ["setDialog", "title", "page", "dia"],
  data() {
    return {
      form: {
        wordId: diaLogUtil.getVal(this, 'word', 'wordId'),
        wordSelf: diaLogUtil.getVal(this, 'word', 'wordSelf'),
        chineseId: diaLogUtil.getVal(this, 'chinese', 'chineseId'),
        chineseInfo: diaLogUtil.getVal(this, 'chinese', 'chineseInfo'),
        wordToChineseComment: diaLogUtil.getVal(this, 'wordToChineseComment'),
      }
    };
  },
  methods: {
    onSubmit() {
      let params = new URLSearchParams();
      params.append('wordId', this.form.wordId ? this.form.wordId : '');
      params.append('wordSelf', this.form.wordSelf);
      params.append('chineseId', this.form.chineseId ? this.form.chineseId : '');
      params.append('chineseInfo', this.form.chineseInfo);
      params.append('wordToChineseComment', this.form.wordToChineseComment);
      submitUtil.onSubmit(this, params, this.form.wordId, this.form.chineseId);
    },
    exit() {
      diaLogUtil.diaExit(this);
    }
  }
};
</script>

<style></style>
