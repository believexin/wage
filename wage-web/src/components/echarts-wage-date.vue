<template>
  <div id="echarts-wage-date">
    <div id="wageDate"></div>
  </div>
</template>

<script>

export default {
  name: 'echarts-wage-date',
  data () {
    return {
      charts:'',
      opinion:['一', '二', '三', '四', '五', '六', '七', '八', '九'],
      opinionData:[
        {
            name: '3的指数',
            type: 'line',
            data: [1, 3, 9, 27, 81, 247, 741, 2223, 6669]
        },
        {
            name: '2的指数',
            type: 'line',
            data: [1, 2, 4, 8, 16, 32, 64, 128, 256]
        },
        {
            name: '1/2的指数',
            type: 'line',
            data: [1/2, 1/4, 1/8, 1/16, 1/32, 1/64, 1/128, 1/256, 1/512]
        }
    ]
    }
  },
  methods:{
    drawPie:function(id){
      this.charts = this.$echarts.init(document.getElementById(id));
      this.charts.setOption(
        {
    title: {
        text: '工资分布折线图',
        left: 'left'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b} : {c}'
    },
    legend: {
        left: 'right'
        // data: ['1/2的指数','2的指数', '3的指数']
    },
    xAxis: {
        type: 'category',
        name: '时间',
        splitLine: {show: false},
        data: this.opinion
    },
    grid: {
        left: '3%',
        right: '10%',
        bottom: '3%',
        containLabel: true
    },
    yAxis: {
        type: 'log',
        name: '工资（元）'
    },
    series: this.opinionData
}
        );
        
    }
  },
  mounted(){
      this.$nextTick(function() {
          this.$axios.get(this.HOST +"/getAvgWage")
          .then(res => {
            this.opinion = res.data.opinion;
            this.opinionData = res.data.opinionData;
            this.drawPie('wageDate');
          })
          .catch(error => {
            console.log(error);
          })
      })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
#wageDate{
  width: 600px;
  height: 350px;
}
</style>
