"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[661],{661:function(e,t,a){a.r(t),a.d(t,{default:function(){return c}});var l=function(){var e=this,t=e._self._c;return t("div",[t("div",{staticClass:"operation"},[t("el-button",{attrs:{type:"danger",plain:""},on:{click:e.delBatch}},[e._v("批量删除")])],1),t("div",{staticClass:"table"},[t("el-table",{attrs:{data:e.tableData,stripe:""},on:{"selection-change":e.handleSelectionChange}},[t("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),t("el-table-column",{attrs:{prop:"id",label:"序号",width:"80",align:"center",sortable:""}}),t("el-table-column",{attrs:{prop:"activityId",label:"活动ID","show-overflow-tooltip":""}}),t("el-table-column",{attrs:{prop:"activityName",label:"活动名称","show-overflow-tooltip":""}}),t("el-table-column",{attrs:{prop:"userId",label:"报名人ID","show-overflow-tooltip":""}}),t("el-table-column",{attrs:{prop:"userName",label:"报名人","show-overflow-tooltip":""}}),t("el-table-column",{attrs:{prop:"time",label:"报名时间"}}),t("el-table-column",{attrs:{label:"操作",width:"180",align:"center"},scopedSlots:e._u([{key:"default",fn:function(a){return[t("el-button",{attrs:{plain:"",type:"danger",size:"mini"},on:{click:function(t){return e.del(a.row.id)}}},[e._v("删除")])]}}])})],1),t("div",{staticClass:"pagination"},[t("el-pagination",{attrs:{background:"","current-page":e.pageNum,"page-sizes":[5,10,20],"page-size":e.pageSize,layout:"total, prev, pager, next",total:e.total},on:{"current-change":e.handleCurrentChange}})],1)],1)])},s=[],i={name:"ActivitySign",data(){return{tableData:[],pageNum:1,pageSize:10,total:0,user:JSON.parse(localStorage.getItem("xm-user")||"{}"),rules:{},ids:[]}},created(){this.load(1)},methods:{del(e){this.$confirm("您确定删除吗？","确认删除",{type:"warning"}).then((t=>{this.$request.delete("/activitySign/delete/"+e).then((e=>{"200"===e.code?(this.$message.success("操作成功"),this.load(1)):this.$message.error(e.msg)}))})).catch((()=>{}))},handleSelectionChange(e){this.ids=e.map((e=>e.id))},delBatch(){this.ids.length?this.$confirm("您确定批量删除这些数据吗？","确认删除",{type:"warning"}).then((e=>{this.$request.delete("/activitySign/delete/batch",{data:this.ids}).then((e=>{"200"===e.code?(this.$message.success("操作成功"),this.load(1)):this.$message.error(e.msg)}))})).catch((()=>{})):this.$message.warning("请选择数据")},load(e){e&&(this.pageNum=e),this.$request.get("/activitySign/selectPage",{params:{pageNum:this.pageNum,pageSize:this.pageSize}}).then((e=>{this.tableData=e.data?.list,this.total=e.data?.total}))},handleCurrentChange(e){this.load(e)}}},n=i,o=a(3736),r=(0,o.Z)(n,l,s,!1,null,"319e734e",null),c=r.exports}}]);
//# sourceMappingURL=661.a2de3b34.js.map