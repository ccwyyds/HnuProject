"use strict";(self["webpackChunkvue"]=self["webpackChunkvue"]||[]).push([[459],{9459:function(t,e,l){l.r(e),l.d(e,{default:function(){return p}});var a=function(){var t=this,e=t._self._c;return e("div",[e("div",{staticClass:"search"},[e("el-input",{staticStyle:{width:"200px","margin-right":"10px"},attrs:{placeholder:"请输入标题查询"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.load(1)}},model:{value:t.title,callback:function(e){t.title=e},expression:"title"}}),e("el-input",{staticStyle:{width:"200px","margin-right":"10px"},attrs:{placeholder:"请输入分类查询"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.load(1)}},model:{value:t.categoryName,callback:function(e){t.categoryName=e},expression:"categoryName"}}),e("el-input",{staticStyle:{width:"200px"},attrs:{placeholder:"请输入用户名称查询"},nativeOn:{keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.load(1)}},model:{value:t.userName,callback:function(e){t.userName=e},expression:"userName"}}),e("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"info",plain:""},on:{click:function(e){return t.load(1)}}},[t._v("查询")]),e("el-button",{staticStyle:{"margin-left":"10px"},attrs:{type:"warning",plain:""},on:{click:t.reset}},[t._v("重置")])],1),e("div",{staticClass:"operation"},[e("el-button",{attrs:{type:"primary",plain:""},on:{click:t.handleAdd}},[t._v("新增")]),e("el-button",{attrs:{type:"danger",plain:""},on:{click:t.delBatch}},[t._v("批量删除")])],1),e("div",{staticClass:"table"},[e("el-table",{attrs:{data:t.tableData,strip:""},on:{"selection-change":t.handleSelectionChange}},[e("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),e("el-table-column",{attrs:{prop:"id",label:"序号",width:"70",align:"center",sortable:""}}),e("el-table-column",{attrs:{prop:"title",label:"标题","show-overflow-tooltip":""}}),e("el-table-column",{attrs:{prop:"descr",label:"简介","show-overflow-tooltip":""}}),e("el-table-column",{attrs:{prop:"cover",label:"封面"},scopedSlots:t._u([{key:"default",fn:function(l){return[e("div",{staticStyle:{display:"flex","align-items":"center"}},[l.row.cover?e("el-image",{staticStyle:{width:"50px",height:"50px","border-radius":"5px"},attrs:{src:l.row.cover,"preview-src-list":[l.row.cover]}}):t._e()],1)]}}])}),e("el-table-column",{attrs:{prop:"categoryName",label:"分类"}}),e("el-table-column",{attrs:{prop:"tags",label:"标签"},scopedSlots:t._u([{key:"default",fn:function(l){return t._l(JSON.parse(l.row.tags||"[]"),(function(l){return e("el-tag",{key:l,staticStyle:{"margin-right":"5px"}},[t._v(t._s(l))])}))}}])}),e("el-table-column",{attrs:{prop:"userName",label:"发布人"}}),e("el-table-column",{attrs:{prop:"date",label:"发布日期"}}),e("el-table-column",{attrs:{prop:"readCount",label:"浏览量"}}),e("el-table-column",{attrs:{label:"查看内容"},scopedSlots:t._u([{key:"default",fn:function(l){return[e("el-button",{on:{click:function(e){return t.preview(l.row.content)}}},[t._v("查看内容")])]}}])}),e("el-table-column",{attrs:{label:"操作",align:"center",width:"180"},scopedSlots:t._u([{key:"default",fn:function(l){return[e("el-button",{attrs:{size:"mini",type:"primary",plain:""},on:{click:function(e){return t.handleEdit(l.row)}}},[t._v("编辑")]),e("el-button",{attrs:{size:"mini",type:"danger",plain:""},on:{click:function(e){return t.del(l.row.id)}}},[t._v("删除")])]}}])})],1),e("div",{staticClass:"pagination"},[e("el-pagination",{attrs:{background:"","current-page":t.pageNum,"page-sizes":[5,10,20],"page-size":t.pageSize,layout:"total, prev, pager, next",total:t.total},on:{"current-change":t.handleCurrentChange}})],1)],1),e("el-dialog",{attrs:{title:"信息",visible:t.fromVisible,width:"60%","close-on-click-modal":!1,"destroy-on-close":""},on:{"update:visible":function(e){t.fromVisible=e}}},[e("el-form",{ref:"formRef",staticStyle:{"padding-right":"50px"},attrs:{model:t.form,"label-width":"100px",rules:t.rules}},[e("el-form-item",{attrs:{label:"标题",prop:"title"}},[e("el-input",{attrs:{placeholder:"标题"},model:{value:t.form.title,callback:function(e){t.$set(t.form,"title",e)},expression:"form.title"}})],1),e("el-form-item",{attrs:{label:"简介",prop:"descr"}},[e("el-input",{attrs:{type:"textarea",placeholder:"简介"},model:{value:t.form.descr,callback:function(e){t.$set(t.form,"descr",e)},expression:"form.descr"}})],1),e("el-form-item",{attrs:{label:"封面",prop:"cover"}},[e("el-upload",{attrs:{action:t.$baseUrl+"/files/upload",headers:{token:t.user.token},"list-type":"picture","on-success":t.handleCoverSuccess}},[e("el-button",{attrs:{type:"primary"}},[t._v("上传封面")])],1)],1),e("el-form-item",{attrs:{label:"分类",prop:"categoryId"}},[e("el-select",{staticStyle:{width:"100%"},model:{value:t.form.categoryId,callback:function(e){t.$set(t.form,"categoryId",e)},expression:"form.categoryId"}},t._l(t.categoryList,(function(t){return e("el-option",{key:t.id,attrs:{value:t.id,label:t.name}})})),1)],1),e("el-form-item",{attrs:{label:"标签",prop:"tags"}},[e("el-select",{staticStyle:{width:"100%"},attrs:{multiple:"",filterable:"","allow-create":"","default-first-option":""},model:{value:t.tagsArr,callback:function(e){t.tagsArr=e},expression:"tagsArr"}},[e("el-option",{attrs:{value:"后端"}}),e("el-option",{attrs:{value:"Java"}}),e("el-option",{attrs:{value:"面试"}}),e("el-option",{attrs:{value:"Vue"}}),e("el-option",{attrs:{value:"前端"}}),e("el-option",{attrs:{value:"大数据"}}),e("el-option",{attrs:{value:"算法"}}),e("el-option",{attrs:{value:"程序员"}}),e("el-option",{attrs:{value:"小白"}})],1)],1),e("el-form-item",{attrs:{label:"内容",prop:"content"}},[e("div",{attrs:{id:"editor"}})])],1),e("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(e){t.fromVisible=!1}}},[t._v("取 消")]),e("el-button",{attrs:{type:"primary"},on:{click:t.save}},[t._v("确 定")])],1)],1),e("el-dialog",{attrs:{title:"文章内容",visible:t.fromVisible1,width:"50%","close-on-click-modal":!1,"destroy-on-close":""},on:{"update:visible":function(e){t.fromVisible1=e}}},[e("div",{domProps:{innerHTML:t._s(t.content)}}),e("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("el-button",{on:{click:function(e){t.fromVisible1=!1}}},[t._v("关 闭")])],1)])],1)},i=[],r=l(7438),o=l.n(r),s=l(5792),n={name:"Blog",data(){return{tableData:[],pageNum:1,pageSize:10,total:0,title:null,categoryName:null,userName:null,fromVisible:!1,form:{},user:JSON.parse(localStorage.getItem("xm-user")||"{}"),rules:{},ids:[],categoryList:[],tagsArr:[],editor:null,content:"",fromVisible1:!1}},created(){this.load(1)},methods:{preview(t){this.content=t,this.fromVisible1=!0},handleAdd(){this.form={},this.tagsArr=[],this.setRichText(),this.fromVisible=!0},handleEdit(t){this.form=JSON.parse(JSON.stringify(t)),this.tagsArr=JSON.parse(this.form.tags||"[]"),this.fromVisible=!0,this.setRichText(),setTimeout((()=>{this.editor.txt.html(this.form.content)}),0)},save(){this.$refs.formRef.validate((t=>{t&&(this.form.tags=JSON.stringify(this.tagsArr),this.form.content=this.editor.txt.html(),this.$request({url:this.form.id?"/blog/update":"/blog/add",method:this.form.id?"PUT":"POST",data:this.form}).then((t=>{"200"===t.code?(this.$message.success("保存成功"),this.load(1),this.fromVisible=!1):this.$message.error(t.msg)})))}))},del(t){this.$confirm("您确定删除吗？","确认删除",{type:"warning"}).then((e=>{this.$request.delete("/blog/delete/"+t).then((t=>{"200"===t.code?(this.$message.success("操作成功"),this.load(1)):this.$message.error(t.msg)}))})).catch((()=>{}))},handleSelectionChange(t){this.ids=t.map((t=>t.id))},delBatch(){this.ids.length?this.$confirm("您确定批量删除这些数据吗？","确认删除",{type:"warning"}).then((t=>{this.$request.delete("/blog/delete/batch",{data:this.ids}).then((t=>{"200"===t.code?(this.$message.success("操作成功"),this.load(1)):this.$message.error(t.msg)}))})).catch((()=>{})):this.$message.warning("请选择数据")},load(t){t&&(this.pageNum=t),this.$request.get("/blog/selectPage",{params:{pageNum:this.pageNum,pageSize:this.pageSize,title:this.title,categoryName:this.categoryName,userName:this.userName}}).then((t=>{this.tableData=t.data?.list,this.total=t.data?.total})),this.$request.get("/category/selectAll").then((t=>{this.categoryList=t.data||[]}))},reset(){this.title=null,this.categoryName=null,this.userName=null,this.load(1)},handleCurrentChange(t){this.load(t)},handleCoverSuccess(t){this.form.cover=t.data},setRichText(){this.$nextTick((()=>{this.editor=new(o())("#editor"),this.editor.highlight=s.Z,this.editor.config.uploadImgServer=this.$baseUrl+"/files/editor/upload",this.editor.config.uploadFileName="file",this.editor.config.uploadImgHeaders={token:this.user.token},this.editor.config.uploadImgParams={type:"img"},this.editor.create()}))}}},c=n,u=l(3736),d=(0,u.Z)(c,a,i,!1,null,"0fae2cea",null),p=d.exports}}]);
//# sourceMappingURL=459.da56d27e.js.map