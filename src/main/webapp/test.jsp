<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    /*
     * basePath：http://localhost:8080/web_log_view_project_war_exploded/
     * request.getScheme()：http
     * request.getServerName()：localhost
     * request.getServerPort()：8080
     * request.getContextPath()：web_log_view_project_war_exploded
     * */
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>最近7天日平均PV量</title>
    <script src="<%=basePath%>/js/jquery-1.11.3.min.js"></script>
    <script src="<%=basePath%>/js/echarts.min.js"></script>

</head>

<body>
<div id="main" style="width: 800px; height: 400px;"></div>
<script type="text/javascript">
    /*jquery的初始化函数*/
    $(document).ready(
        function () {
            // 3.基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));
            // 4.指定图表的配置项和数据
            // 显示标题，图例和空的坐标轴
            myChart.setOption({
                title: {
                    text: '最近7天日平均PV量',
                    //subtext: '动态数据'
                },
                tooltip: {},
                legend: {
                    data: ['日平均PV量']
                },
                xAxis: {
                    data: []
                },
                yAxis: {},
                series: [{
                    name: '日平均PV量',
                    type: 'bar',
                    data: []
                }]
            });
            // 5.使用刚指定的配置项和数据显示图表。
            //loading 动画
            myChart.showLoading();

            //4.1 ajax异步请求动态获取图表数据
            $.ajax({
                type: "post",
                url: "<%=basePath%>/AvgPvNum",
                dataType: "json",
                success: function (data) {
                    //表格数据填充
                    myChart.setOption({
                        xAxis: {
                            data: data.dates
                        },
                        series: [{
                            // 根据名字对应到相应的系列
                            name: 'PV量',
                            data: data.data
                        }]
                    });
                    //数据加载完成后再调用 hideLoading 方法隐藏加载动画
                    myChart.hideLoading();
                }
            });
        });
</script>
</body>
</html>