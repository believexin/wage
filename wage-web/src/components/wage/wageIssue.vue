<template>
  <div>
    <div style="margin-top: 15px;">
      <el-input placeholder="请输入员工姓名" v-model="userName" class="input-with-select">
        <el-select v-model="corps" slot="prepend" placeholder="请选择单位">
          <el-option label="全部" value="0"></el-option>
          <el-option v-for="item in selectCorps" :label="item.corpName" :value="item.corpId"></el-option>
        </el-select>
        <el-button slot="append" icon="el-icon-search" @click="search"></el-button>
      </el-input>
      <el-button type="primary" @click="sendWage" :disabled="isSendRight">工资发放</el-button>
    </div>
    <el-table ref="multipleTable" :data="tableData" tooltip-effect="dark" style="width: 100%" @selection-change="handleSelectionChange" 
      v-loading="loading2"
      element-loading-text="拼命加载中"
      element-loading-spinner="el-icon-loading"
      element-loading-background="rgba(1, 10, 10, 0.8)">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column  prop="id" label="编号" width="150"> </el-table-column>
      <el-table-column  prop="username" label="姓名" width="100"> </el-table-column>
      <el-table-column  prop="sex" label="性别" width="50"> </el-table-column>
      <el-table-column  prop="corpname" label="单位" width="150"> </el-table-column>
      <!-- <el-table-column  prop="deptname" label="部门" width="150"> </el-table-column> -->
      <!-- <el-table-column  prop="job" label="职位" width="120"> </el-table-column> -->
      <el-table-column  prop="salary" label="工资&amp;奖金" width="120"> </el-table-column>
      <!-- <el-table-column prop="note" label="备注"  show-overflow-tooltip></el-table-column> -->
      <el-table-column prop="note" label="是否发放工资"  show-overflow-tooltip>
        <template slot-scope="scope"><el-switch disabled v-model="scope.row.value" active-color="#13ce66" ></el-switch></template>
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="100">
        <template slot-scope="scope">
          <el-button @click.native.prevent="edit(scope.row)" type="text" size="small">查看详情</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="totals">
      </el-pagination>
    </div>
    <el-dialog title="编辑信息" :visible.sync="dialogFormVisible">
      <el-form :model="dialogs">
        <el-form-item label="编号" :label-width="formLabelWidth" disabled>
          <el-input v-model="dialogs.id" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="姓名" :label-width="formLabelWidth" disabled>
          <el-input v-model="dialogs.username" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="职位" :label-width="formLabelWidth" disabled>
          <el-input v-model="dialogs.job" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="工资" :label-width="formLabelWidth" disabled>
          <el-input v-model="dialogs.salary" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="备注" :label-width="formLabelWidth" disabled>
          <el-input v-model="dialogs.note" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="部门" :label-width="formLabelWidth" disabled>
          <el-select v-model="dialogs.deptname" placeholder="请选择活动区域">
            <el-option v-for="item in selectDepts" :label="item.deptName" :value="item.deptId"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="单位" :label-width="formLabelWidth">
          <el-select v-model="dialogs.corpname" placeholder="请选择活动区域">
            <el-option v-for="item in selectCorps" :label="item.corpName" :value="item.corpId"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import UserMsg from '../users/userMsg'
  export default {
    data() {
      return {
        tableData: [{
          id: '123654',
          corpid: 330000,
          corpname: '洁润有限公司',
          deptid: '3300000001',
          deptname: '人力资源',
          name: '王小虎',
          sex: '男',
          position:'会计',
          salary: '5000',
          // note:'',
          // value:false

        }],
        selectCorps:[{
          corpName:'洁润有限公司',
          corpId:'1254'
        },
        {
          corpName:'洁润有限分公司',
          corpId:'6666'
        }],
        selectDepts:[{
          deptName:'人力资源部',
          deptId:'3300000001'
        }],
        multipleSelection: [],
        currentPage: 1,
        corps:'',
        userName:'',
        loading2:false,
        formLabelWidth:'50px',
        dialogFormVisible:false,
        pageSize:5,
        totals:0,
        dialogs:{

        },
        isSendRight:true
      }
    },
    components:{
      UserMsg
    },

    methods: {
      handleSelectionChange(val) {
        console.log(val);
        this.multipleSelection = val;
      },
      handleSizeChange(val) {
        this.pageSize = val;
        this.getUserList();
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        this.currentPage = val;
        this.getUserList();
        console.log(`当前页: ${val}`);
      },
      handleClick(row) {
        console.log(row);
        this.$alert('<UserMsg><UserMsg/>', '详情', {
        dangerouslyUseHTMLString: true
        })
      },
      edit(row) {
        this.dialogs = row;
        this.dialogFormVisible = true
      },
      openDetails() {
        
      },
      search(){
        this.loading2 = true;
        setTimeout(() => {
          this.loading2 = false;
        },1000);
      },
      getUserList(){
         this.$axios.get(this.HOST +"/getUserSalaryInfo?pageStart="+ this.currentPage +"&pageCount=" + this.pageSize)
        .then(res => {
          this.tableData = res.data;
        })
        .catch(error => {
          console.log(error);
        })
      },
      sendWage(){
        this.$prompt('请输入支出银行卡号', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          inputPattern: /^\d*$/,
          inputErrorMessage: '卡号格式不正确'
        }).then(({ value }) => {
          this.$message({
            type: 'success',
            message: '你的银行卡号是: ' + value + ',系统将5分钟后发放工资'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '取消输入'
          });       
        });
      }
    },
    mounted(){
      this.$nextTick(function(){
       this.$axios.get(this.HOST +"/getUserSalaryInfoSize")
        .then(res => {
          this.totals = res.data;
          this.getUserList();
        })
        .catch(error => {
          console.log(error);
        });
        var loginid = sessionStorage.getItem("loginid");
        // 权限
        this.$axios.get(this.HOST + "/getUserRightsByloginid?loginid="+ loginid)
        .then(res => {
          var rights = res.data;
          for(var i = 0;i < rights.length;i ++){
            if(rights[i] == 'wage.send'){
              this.isSendRight = false;
            }
          }
        })
        .catch(error => {
          console.log(error);
        })
      })
    }
  }
</script>
<style scoped>
.el-input{
  width: 500px;
}
.el-select >>> .el-input {
    width: 200px;
}
.input-with-select >>> .el-input-group__prepend{
/*  background-color: #011219;
  border-color: #606266;*/
}
.input-with-select >>> input{
/*  background-color: #011219;
  border-color: #606266;*/
}
.block >>> *{
  /*background-color: #011219;*/
}
.el-pagination >>> button.disabled{
 /*background-color: #011219; */
}
.el-table >>> tr,td,th>div,th,input,thead,li,ul{
/*  background-color: #011219!important;
  border-color: #606266!important;*/
}
.el-table-column >>> tr,td,th>div,th,input,thead{
  /*background-color: #011219!important;*/
}
.el-table >>> th, .el-table >>> tr{
/*  background-color: #011219!important;
  border-color: #606266;*/
}
* >>> * {
  /*border-color: #606266!important;*/
}
.el-table::before{
  /*background-color: #606266!important;*/
}
.input-with-select >>> .el-input-group__append button.el-button{
  /*background-color: #011219!important;*/
}
.el-dialog{
/*  background-color: #022433!important;
  border-color: #606266!important;*/
}
.el-dialog >>> input{
/*  background-color: #022433!important;
  border-color: #606266!important;*/
}
</style>