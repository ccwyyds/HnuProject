<template xmlns:margin-bottom="http://www.w3.org/1999/xhtml">
  <div class="main-content">
    <div style="display: flex; align-items: flex-start; grid-gap: 10px">

      <div style="width: 150px" class="card">
        <div class="category-item" :class="{ 'category-item-active': item.name === current }"
             v-for="item in categoryList" :key="item.id" @click="selectCategory(item.name)">{{ item.name }}</div>
      </div>

      <div style="flex: 1">

<!--        引入博客列表-->
        <blog-list :categoryName="current" ref="blogListRef"/>

        <Footer/>

      </div>

      <div style="width: 260px">
        <div class="card" style="margin-bottom: 10px">
          <div style="font-size: 20px; font-weight: bold; margin-bottom: 10px">欢迎您！😘</div>
          <a href="/front/person"> <div style="color: #666">写下博客记录美好的一天</div></a>
        </div>


      <div class="card" style="margin-bottom: 10px">
        <div style="display: flex; align-items:center;padding-bottom: 10px;border-bottom: 1px solid #ddd" >
          <div style="font-size: 20px;flex: 1">博客榜单</div>
          <div style="font-size: 12px;color: #666;cursor: pointer" @click="refreshTop"><i class="el-icon-refresh"></i>换一换</div>
        </div>



        <div >

            <div v-for="item in showlist" :key="item.id" style="margin: 15px 0" class="line1">
              <a :href="'/front/blogDetail?blogId=' + item.id" target="_blank">
                <span style="width: 18px; display: inline-block; text-align: right; margin-right: 10px">
                  <span style="color: orangered" v-if="item.index === 1">{{ item.index }}</span>
                  <span style="color: goldenrod" v-else-if="item.index === 2">{{ item.index }}</span>
                  <span style="color: dodgerblue" v-else-if="item.index === 3">{{ item.index }}</span>
                  <span style="color: #666" v-else>{{ item.index }}</span>
                </span>
              <span style="color: #666;">{{ item.title }}</span>
              </a>
            </div>

        </div>
    </div>

        <div style="margin-bottom: 10px">
          <div v-for="item in topActivityList" :key="item.id" style="margin-bottom: 10px">
            <a :href="'/front/activityDetail?activityId=' + item.id" target="_blank"><img :src="item.cover" alt="" style="width: 100%; border-radius: 5px"></a>
          </div>
        </div>

        <div style="line-height: 30px; color: #666; padding: 0 10px">
          <div>就读院校： 淮阴师范学院</div>
          <div>举报邮箱： 2668595802@qq.com</div>
          <div> 联系电话： 18899900088</div>
          <div> 京ICP备66668888号-2  ©2024</div>
        </div>

  </div>
    </div>
  </div>

</template>

<script>

import Footer from "@/components/Footer.vue";
import BlogList from "@/components/BlogList.vue";

export default {
  components: {
    Footer,
    BlogList
  },

  data() {
    return {
      current: '全部博客',  //当前选中的分类名称
      categoryList: [],
      toplist: [],
      showlist: [],
      lastIndex: 0,
      topActivityList: []
    }
  },
  mounted() {
    this.load()

    this.refreshTop()
    this.loadTopActivity()

  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {
    loadTopActivity(){
      this.$request.get('/activity/selectTop').then(res => {
        this.topActivityList = res.data || []
      })
    },
    refreshTop(){
      this.$request.get('/blog/selectTop').then(res => {
        this.toplist = res.data || []
        let i = 1;
        this.toplist.forEach(item => item.index = i++)


        // 榜单数为10，若想修改直接修改即可。
        if(this.lastIndex === 10){
          this.lastIndex = 0;
        }
        this.showlist = this.toplist.slice(this.lastIndex,this.lastIndex+5)
        this.lastIndex += 5;
      })
    },
    selectCategory(categoryName) {
      this.current = categoryName

    },
    load() {
      // 请求分类的数据
      this.$request.get('/category/selectAll').then(res => {
        this.categoryList = res.data || []
        this.categoryList.unshift({ name: '全部博客' })
      })
    },


  }
}
</script>

<style>
.category-item {
  text-align: center;
  padding: 10px 0;
  font-size: 16px;
  cursor: pointer;
}
.category-item-active {
  background-color: #1890ff;
  color: #fff;
  border-radius: 5px;
}
.line1 {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}


</style>
