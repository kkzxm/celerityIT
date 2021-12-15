<template>
  <div class="oper-word">
    <el-form ref="operPatrol" :model="form" label-width="auto">
      <el-form-item
          prop="tagGroupName"
          label="单词标签组名称">
        <el-input v-model="form.tagGroupName"></el-input>
      </el-form-item>

      <el-form-item
          prop="tagGroupComment"
          label="单词标签组备注">
        <el-input v-model="form.tagGroupComment"></el-input>
      </el-form-item>

      <el-form-item
          prop="tagGroupParent"
          label="父级标签组">
        <el-cascader
            v-model="form.tagGroupParentId"
            :options="page.dataList"
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
import { ElMessage } from 'element-plus'

export default {
  name: 'oper-tagGroup',
  props: ['setDialog', 'title', 'page', 'dia'],
  data () {
    return {
      form: {
        tagGroupId: diaLogUtil.getVal(this, 'tagGroupId'),
        tagGroupName: diaLogUtil.getVal(this, 'tagGroupName'),
        tagGroupComment: diaLogUtil.getVal(this, 'tagGroupComment'),
        tagGroupParentId: diaLogUtil.getVal(this, 'tagGroupParent', 'tagGroupId')
      },
      optionProps: {
        checkStrictly: true,
        children: 'childTagGroupSet',
        label: 'tagGroupName',
        value: 'tagGroupId'
      }
    }
  },
  methods: {
    onSubmit () {
      let params = new URLSearchParams()
      let parentId = this.form.tagGroupParentId

      params.append('tagGroupId', this.form.tagGroupId)
      params.append('tagGroupName', this.form.tagGroupName)
      params.append('tagGroupComment', this.form.tagGroupComment)

      if (parentId) {
        for (let parentIdKey in parentId) {
          if (parentId[parentIdKey] === this.form.tagGroupId) {
            ElMessage.error({
              showClose: true,
              message: '标签组循环依赖',
              type: 'error'
            })
            return
          }
        }
        params.append('tagGroupParentId', parentId.pop())
      }
      submitUtil.onSubmit(this, params, this.form.tagGroupId)
    },
    exit () {
      diaLogUtil.diaExit(this)
    }
  },
  created () {
    this.tagGroupList = tagGroupUtil.getTagGroupList()
  }
}
</script>

<style scoped>

</style>
