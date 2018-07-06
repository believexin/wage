<template>
  <div id="echarts-wage">
    <div id="main"></div>
  </div>
</template>

<script>
export default {
  name: 'echarts-wage',
  data () {
    return {
      charts:'',
      opinion:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎'],
      opinionData:[
        {value:335, name:'直接访问'},
        {value:310, name:'邮件营销'},
        {value:234, name:'联盟广告'},
        {value:135, name:'视频广告'},
        {value:1548, name:'搜索引擎'}
      ]
    }
  },
  methods:{
    drawPie:function(id){
      this.charts = this.$echarts.init(document.getElementById(id));
        this.charts.setOption({
           tooltip: {
             trigger: 'item',
             formatter: '{a}<br/>{b}:{c} ({d}%)'
           },
           title: {
                text: '工资等级分布',
                left: 'left'
            },
           legend: {
             orient: 'vertical',
             x: 'right',
             data:this.opinion
           },
           series: [
             {
               name:'职务',
               type:'pie',
               radius:['50%','70%'],
               avoidLabelOverlap: false,
               label: {
                 normal: {
                   show: false,
                   position: 'center'
                 },
                 emphasis: {
                   show: true,
                   textStyle: {
                     fontSize: '30',
                     fontWeight: 'blod'
                   }
                 }
               },
               labelLine: {
                 normal: {
                   show: false
                 }
               },
               data:this.opinionData
             }
           ]
         });
    }
  },
  mounted(){
      this.$nextTick(function() {
          this.$axios.get(this.HOST +"/getSalaryLevel")
          .then(res => {
            this.opinion = res.data.opinions;
            this.opinionData = res.data.opinionData;
            this.drawPie('main');
          })
          .catch(error => {
            console.log(error);
          })
      })
  }
}
</script>

<style scoped>
#main{
  width: 500px;
  height: 350px;
}
</style>
