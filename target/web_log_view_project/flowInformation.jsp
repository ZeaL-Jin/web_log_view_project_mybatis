<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>流量信息概况</title>
    <script src="<%=basePath%>/js/jquery-1.11.3.min.js"></script>
    <script src="<%=basePath%>/js/echarts.min.js"></script>
</head>

<body>

<div id="main" style="width: 800px; height: 400px;"></div>

<script type="text/javascript">

    var myChart = echarts.init(document.getElementById('main'));
    $(document).ready(
        function () {
            // 3.基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));
            // 4.指定图表的配置项和数据
            // 显示标题，图例和空的坐标轴
            myChart.setOption({
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },

                legend: {
                    data: ['浏览次数（PV）', '独立访客(UV)', 'IP', '新独立访客', '访问次数']
                },
                xAxis: [{
                    type: 'category',
                    axisTick: {
                        show: false
                    },
                    data: []
                }],
                yAxis: [{
                    type: 'value'
                }],
                series: [{
                    name: '浏览次数（PV）',
                    type: 'bar',
                    barGap: 0,
                    emphasis: {
                        focus: 'series'
                    },
                    data: []
                },
                    {
                        name: '独立访客(UV)',
                        type: 'bar',
                        emphasis: {
                            focus: 'series'
                        },
                        data: []
                    },
                    {
                        name: 'IP',
                        type: 'bar',
                        emphasis: {
                            focus: 'series'
                        },
                        data: []
                    },
                    {
                        name: '新独立访客',
                        type: 'bar',
                        emphasis: {
                            focus: 'series'
                        },
                        data: []
                    },
                    {
                        name: '访问次数',
                        type: 'bar',
                        emphasis: {
                            focus: 'series'
                        },
                        data: []
                    }
                ]

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
                            //根据名字对应到响应的系列
                            name: '浏览次数（PV）',
                            data: data.pVNum
                        },
                            {
                                name: '独立访客(UV)',
                                data: data.data
                            },
                            {
                                name: 'IP',
                                data: data.data
                            },
                            {
                                name: '新独立访客',
                                data: data.data
                            },
                            {
                                name: '访问次数',
                                data: data.data
                            }
                        ]
                    });
                    //数据加载完成后再调用 hideLoading 方法隐藏加载动画
                    myChart.hideLoading();
                }
            });
        });
</script>

</body>

</html>