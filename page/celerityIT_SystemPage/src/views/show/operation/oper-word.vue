<template>
  <div class="oper-word">
    <el-form ref="operPatrol" :model="form" label-width="auto">
      <!-- region 普通项 -->
      <el-form-item
          prop="wordSelf"
          label="英语单词拼写">
        <el-input v-model="form.wordSelf"></el-input>
      </el-form-item>

      <el-form-item
          prop="wordComment"
          label="英语单词备注">
        <el-input v-model="form.wordComment"></el-input>
      </el-form-item>
      <!-- endregion -->

      <!-- region list项 -->
      <!-- region 中文翻译 -->

      <div class="chineseList list">
        <el-divider content-position="left">中文翻译</el-divider>
        <el-form-item
            v-for="(chinese, index) in form.chineseList"
            :label="'中文翻译' + (index+1)"
            :key="chinese.key"
            :prop="'chineseInfo'"
        >
          <el-input v-model="chinese.chineseInfo" style="width: 400px"></el-input>
          <el-button @click.prevent="removeDemo(chinese,'chinese')">删除</el-button>
        </el-form-item>
        <div class="addButton">
          <el-button @click.prevent="addDemo('chinese')">添加中文翻译</el-button>
        </div>
      </div>
      <!--endregion-->

      <!-- region 单词类型 -->
      <div class="wordTypeList list">
        <el-divider content-position="left">单词类型</el-divider>
        <el-form-item
            v-for="(wordType, index) in form.wordTypeList"
            :label="'单词类型' + (index+1)"
            :key="wordType.key"
            :prop="'wordTypeName'"
        >
          <el-input v-model="wordType.wordTypeName" style="width: 400px"></el-input>
          <el-button @click.prevent="removeDemo(wordType,'wordType')">删除</el-button>
        </el-form-item>
        <div class="addButton">
          <el-button @click.prevent="addDemo('wordType')">添加单词类型</el-button>
        </div>
      </div>
      <!-- endregion -->

      <!-- region 单词标签 -->
      <div class="wordTagList list">
        <el-divider content-position="left">单词标签</el-divider>
        <el-form-item
            v-for="(wordTag, index) in form.wordTagList"
            :label="'单词标签' + (index+1)"
            :key="wordTag.key"
            :prop="'wordTagName'"
        >
          <el-input v-model="wordTag.wordTagName" style="width: 400px"></el-input>
          <el-button @click.prevent="removeDemo(wordTag,'wordTag')">删除</el-button>
        </el-form-item>
        <div class="addButton">
          <el-button @click.prevent="addDemo('wordTag')">添加单词标签</el-button>
        </div>
      </div>
      <!-- endregion -->
      <!-- endregion -->

      <!-- region 操作项 -->
      <el-form-item class="">
        <el-button type="primary" @click="onSubmit">{{ title }}</el-button>
        <el-button @click="exit">取消</el-button>
      </el-form-item>
      <!-- endregion -->
    </el-form>
  </div>
</template>

<script>

import { diaLogUtil, submitUtil } from '@/utils'

export default {
  name: 'oper-word',
  props: ['setDialog', 'title', 'page', 'dia'],
  data () {
    return {
      form: {
        wordId: diaLogUtil.getVal(this, 'wordId'),
        wordSelf: diaLogUtil.getVal(this, 'wordSelf'),
        wordComment: diaLogUtil.getVal(this, 'wordComment'),
        chineseList: [{
          chineseInfo: ''
        }],
        wordTypeList: [{
          wordTypeName: ''
        }],
        wordTagList: [{
          wordTagName: ''
        }],
      },
    }
  },
  created () {
  },
  methods: {
    onSubmit () {
      submitUtil.onSubmit(this, this.form, this.form.wordId)
    },
    exit () {
      diaLogUtil.diaExit(this)
    },
    removeDemo (item, prop) {
      let index = this.form[prop + 'List'].indexOf(item)
      if (index !== -1) {
        this.form[prop + 'List'].splice(index, 1)
      }
    },
    addDemo (prop) {
      this.form[prop + 'List'].push({
        chineseInfo: '',
        key: Date.now()
      })
    }
  },
}
</script>

<style scoped>
.oper-word {
  width: 650px;
}

.list {

}

.addButton {
  text-align: right;
}
</style>
