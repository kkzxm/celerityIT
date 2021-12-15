<template>
  <div class="oper-chinese">
    <el-form ref="operPatrol" :model="form" label-width="auto">
      <el-form-item
          prop="wordSelf"
          label="中文组词信息">
        <el-input v-model="form.chineseInfo"></el-input>
      </el-form-item>

      <el-form-item
          prop="wordComment"
          label="英语单词备注">
        <el-input v-model="form.chineseComment"></el-input>
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
  name: "oper-chinese",
  props: ["setDialog", "title", "page", "dia"],
  data() {
    return {
      form: {
        chineseId: diaLogUtil.getVal(this, 'chineseId'),
        chineseInfo: diaLogUtil.getVal(this, 'chineseInfo'),
        chineseComment: diaLogUtil.getVal(this, 'chineseComment'),
      },
    };
  },
  created() {

  },
  methods: {
    onSubmit() {
      submitUtil.onSubmit(this, this.form, this.form.chineseId);
    },
    exit() {
      diaLogUtil.diaExit(this)
    }
  },
};
</script>

<style scoped lang="scss">

</style>
