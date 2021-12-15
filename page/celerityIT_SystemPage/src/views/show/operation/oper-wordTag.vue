<template>
  <div class="oper-word">
    <el-form ref="operPatrol" :model="form" label-width="auto">
      <el-form-item
          prop="wordTagName"
          label="单词标签名称">
        <el-input v-model="form.wordTagName"></el-input>
      </el-form-item>

      <el-form-item
          prop="wordTagComment"
          label="单词标签备注">
        <el-input v-model="form.tagComment"></el-input>
      </el-form-item>

      <el-form-item
          prop="tagGroupParent"
          label="所属标签组">
        <el-cascader
            v-model="form.tagGroupId"
            :options="tagGroupList"
            :props="optionProps"
            clearable></el-cascader>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">{{ title }}</el-button>
        <el-button @click="exit">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

import { diaLogUtil, submitUtil, tagGroupUtil } from '@/utils'
import { API, checkRes } from '@/api'

export default {
  name: 'oper-wordTag',
  props: ['setDialog', 'title', 'page', 'dia'],
  data () {
    return {
      form: {
        wordTagId: diaLogUtil.getVal(this, 'wordTagId'),
        wordTagName: diaLogUtil.getVal(this, 'wordTagName'),
        tagComment: diaLogUtil.getVal(this, 'tagComment'),
        tagGroupId: diaLogUtil.getVal(this, 'tagGroup', 'tagGroupId')
      },
      optionProps: {
        checkStrictly: true,
        children: 'childTagGroupSet',
        label: 'tagGroupName',
        value: 'tagGroupId'
      },
      tagGroupList: []
    }
  },
  created () {
    let tagGroupList = tagGroupUtil.getTagGroupList()
    if (tagGroupList) {
      this.tagGroupList = tagGroupList
    } else {
      API.wordTagGroup.getPage().then(res => {
        checkRes(res, {
          message: '数据请求成功',
          fun () {
            this.tagGroupList = res.data.records
          }
        }, {
          message: '数据请求失败',
          fun () {

          }
        })
      })
    }
  },
  methods: {
    onSubmit () {
      let form = this.form
      let wordTagId = form.wordTagId
      let params = new URLSearchParams()
      let tagGroupId = form.tagGroupId

      if (wordTagId) {
        params.append('wordTagId', wordTagId)
      }
      if (tagGroupId) {
        params.append('tagGroupId', tagGroupId?.pop())
      }
      params.append('wordTagName', form.wordTagName)
      params.append('tagComment', form.tagComment)
      submitUtil.onSubmit(this, params, wordTagId)
    },
    exit () {
      diaLogUtil.diaExit(this)
    }
  },
}
</script>

<style scoped>

</style>
