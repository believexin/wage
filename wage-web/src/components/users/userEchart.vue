<template>
	<div id="echarts-wage-persion">
    <div id="wagePersion"></div>
  </div>
</template>
<script>
export default{
	name:'persionEchart',
	data(){
		return {
			charts:'',
			data1:['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
			data2:[10, 52, 200, 334, 390, 330, 220]
		}
	},
	props:{
	    data:{

	    }
	},
    methods:{
    drawPie:function(id){
		this.charts = this.$echarts.init(document.getElementById(id));
		this.charts.setOption({
		    color: ['#3398DB'],
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : this.data1,
		            axisTick: {
		                alignWithLabel: true
		            }
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'工资情况',
		            type:'bar',
		            barWidth: '60%',
		            data: this.data2
		        }
		    ]
		})
    },
    exchangeCharts:function(userid){
    	this.$axios.get(this.HOST +"/getAvgWageForUser?userid=" + userid)
          .then(res => {
            this.data1 = res.data.opinion;
            this.data2 = res.data.opinionData;
            this.drawPie('wagePersion');
          })
          .catch(error => {
            console.log(error);
          })
    }
  }
}
</script>
<style scoped>
#wagePersion{
  width: 400px;
  height: 300px;
}
</style>