<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="<%=basePath%>/js/jquery-1.11.3.min.js"></script>
    <script src="<%=basePath%>/js/echarts.min.js"></script>



</head>
<body>
<div id="main" style="width: 1200px; height: 600px;"></div>
<div id="map" style="width: 1200px; height: 400px;"></div>
<div id="sharpdataset" style="width: 1200px; height: 600px;"></div>

<%--柱状图--%>
<script type="text/javascript">

    $(document).ready(
        function () {
            var app = {};

            var chartDom = document.getElementById('main');
            var myChart = echarts.init(chartDom);

            const posList = [
                'left',
                'right',
                'top',
                'bottom',
                'inside',
                'insideTop',
                'insideLeft',
                'insideRight',
                'insideBottom',
                'insideTopLeft',
                'insideTopRight',
                'insideBottomLeft',
                'insideBottomRight'
            ];
            app.configParameters = {
                rotate: {
                    min: -90,
                    max: 90
                },
                align: {
                    options: {
                        left: 'left',
                        center: 'center',
                        right: 'right'
                    }
                },
                verticalAlign: {
                    options: {
                        top: 'top',
                        middle: 'middle',
                        bottom: 'bottom'
                    }
                },
                position: {
                    options: posList.reduce(function (map, pos) {
                        map[pos] = pos;
                        return map;
                    }, {})
                },
                distance: {
                    min: 0,
                    max: 100
                }
            };
            app.config = {
                rotate: 90,
                align: 'left',
                verticalAlign: 'middle',
                position: 'insideBottom',
                distance: 15,
                onChange: function () {
                    const labelOption = {
                        rotate: app.config.rotate,
                        align: app.config.align,
                        verticalAlign: app.config.verticalAlign,
                        position: app.config.position,
                        distance: app.config.distance
                    };
                    myChart.setOption({
                        series: [
                            {
                                label: labelOption
                            },
                            {
                                label: labelOption
                            },
                            {
                                label: labelOption
                            },
                            {
                                label: labelOption
                            }
                        ]
                    });
                }
            };
            const labelOption = {
                show: true,
                position: app.config.position,
                distance: app.config.distance,
                align: app.config.align,
                verticalAlign: app.config.verticalAlign,
                rotate: app.config.rotate,
                formatter: '{c}  {name|{a}}',
                fontSize: 16,
                rich: {
                    name: {}
                }
            };


            var option = {
                title:{
                    text:'流量信息',
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'shadow'
                    }
                },
                legend: {
                    data: ['pVNum', 'uVNum', 'iPNum', 'newUvNum','visitNum']
                },
                toolbox: {
                    show: true,
                    orient: 'vertical',
                    left: 'right',
                    top: 'center',
                    feature: {
                        mark: { show: true },
                        dataView: { show: true, readOnly: false },
                        magicType: { show: true, type: ['line', 'bar', 'stack'] },
                        restore: { show: true },
                        saveAsImage: { show: true }
                    }
                },
                xAxis: [
                    {
                        type: 'category',
                        axisTick: { show: false },
                        data:  []
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: 'pVNum',
                        type: 'bar',
                        barGap: 0,
                        label: labelOption,
                        emphasis: {
                            focus: 'series'
                        },
                        data: []
                    },
                    {
                        name: 'uVNum',
                        type: 'bar',
                        label: labelOption,
                        emphasis: {
                            focus: 'series'
                        },
                        data: []
                    },
                    {
                        name: 'iPNum',
                        type: 'bar',
                        label: labelOption,
                        emphasis: {
                            focus: 'series'
                        },
                        data: []
                    },
                    {
                        name: 'newUvNum',
                        type: 'bar',
                        label: labelOption,
                        emphasis: {
                            focus: 'series'
                        },
                        data: []
                    },
                    {
                        name: 'visitNum',
                        type: 'bar',
                        label: labelOption,
                        emphasis: {
                            focus: 'series'
                        },
                        data: []
                    }

                ]
            };

            // option &&
            myChart.showLoading();

            $.ajax({
                type: "post",
                url: "<%=basePath%>/flowInformationController",
                dataType: "json",
                success: function (data) {

                    option.xAxis[0].data = data.dateStr;
                    option.series[0].data = data.pVNum;
                    option.series[1].data = data.uVNum;
                    option.series[2].data = data.iPNum;
                    option.series[3].data = data.newUvNum;
                    option.series[4].data = data.visitNum;

                    myChart.setOption(option);


                    myChart.hideLoading();
                }
            });

        }
    );



</script>

<%--曲线图--%>
<script type="text/javascript">
    $(document).ready(
        function() {
            var myChart = echarts.init(document.getElementById('map'));
            // 显示标题，图例和空的坐标轴
            myChart.setOption({
                title: {
                    text: '流量信息概况'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data:[]
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                legend : {
                    data : [ '浏览次数','独立访客','ip', '新独立访客','访问次数' ]
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: []
                },
                yAxis: {
                    type: 'value'
                },
                series: [
                    {
                        name: '浏览次数',
                        type: 'line',
                        stack: '总量',
                        data: []
                    },
                    {
                        name: '独立访客',
                        type: 'line',
                        stack: '总量',
                        data: []
                    },
                    {
                        name: 'ip',
                        type: 'line',
                        stack: '总量',
                        data: []
                    },
                    {
                        name: '新独立访客',
                        type: 'line',
                        stack: '总量',
                        data:[]
                    },
                    {
                        name: '访问次数',
                        type: 'line',
                        stack: '总量',
                        data: []
                    }
                ]
            });
            myChart.showLoading();
            $.ajax({
                type:"post",
                url:"<%=basePath%>/flowInformationController",
                dataType:"json",
                success:function(data) {
                    myChart.setOption({
                        xAxis : {
                            data : data.dateStr
                        },
                        series : [ {
                            // 根据名字对应到相应的系列
                            name : '浏览次数',
                            data : data.pVNum
                        },{
                            name : '独立访客',
                            data : data.uVNum
                        },{
                            name : 'ip',
                            data : data.iPNum
                        },{
                            name : '新独立访客',
                            data : data.newUvNum
                        },{
                            name : '访问次数',
                            data : data.visitNum
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