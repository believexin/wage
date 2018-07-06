<template>
	<div class="organ">
		<el-input placeholder="输入关键字进行过滤" v-model="filterText"></el-input>

		<el-tree background-color="#545b64" text-color="#fff" active-text-color="#ffd04b" class="filter-tree" :default-expanded-keys="defaultKey"  node-key="id" :data="data2" :props="defaultProps"  :filter-node-method="filterNode" ref="tree2" @node-click="nodeClick">
		</el-tree>
	</div>
</template>

<script>
export default {
	name:'organ',
	data() {
	  return {
	  	defaultKey:['-1'],
	    filterText: '',
	    data2: [],
	    defaultProps: {
	      children: 'children',
	      label: 'label'
	    }
	  }
	},
	watch: {
	  filterText(val) {
	    this.$refs.tree2.filter(val);
	  }
	},

	methods: {
	  filterNode(value, data) {
	    if (!value) return true;
	    return data.label.indexOf(value) !== -1;
	  },
	  nodeClick(data1,data2,data3){
	  	if(data2.data.organType === 'Users'){
			this.$emit("parentEvent",data2.data.content);
	  	}
	  }
	},
	mounted(){
		this.$nextTick(function(){
			this.$axios.get(this.HOST +"/getOrganTree")
			.then(res => {
				this.data2 = res.data;
			})
			.catch(error => {
				console.log(error);
			})
		})
	}
};
</script>
<style scoped>
.el-input{
	width: 250px;
}
.el-tree{
	overflow-y: auto;
	/*background: #011219;*/
	/*height: 800px;*/
}
.organ>.el-input{
	/*background: #011219;*/
}
.organ{
	/*background: #011219;*/
}
.organ .el-input__inner,input{
	/*background-color: #011219!important;*/
}
.el-input >>> .el-input__inner{
/*  background-color: #011219!important;
  border-color: #606266;*/
}
</style>