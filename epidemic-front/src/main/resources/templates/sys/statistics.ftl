<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>统计图表</title>
    <link rel="stylesheet" href="/layui/css/layui.css">

    <style>
        .content {
            padding: 15px;
        }

        i {
            margin-right: 10px;
        }

        cite {
            color: #009688;
        }
    </style>
</head>
<body>
<nav class="layui-layout layui-layout-admin">
    <#include "common_head.ftl">

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <#include "common_left.ftl">

            <ul class="layui-nav layui-nav-tree">
                <li class="layui-nav-item">
                    <a href="/sys/index.html">
                        <i class="layui-icon layui-icon-home"></i>首页
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a href="/sys/user/manage.html">
                        <i class="layui-icon layui-icon-username"></i>用户管理
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a href="/sys/region/manage.html">
                        <i class="layui-icon layui-icon-template"></i>地区管理
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a href="/sys/patient/manage.html">
                        <i class="layui-icon layui-icon-flag"></i>患者管理
                    </a>
                </li>
                <li class="layui-nav-item layui-this">
                    <a href="/sys/statistics/manage.html">
                        <i class="layui-icon layui-icon-chart"></i>数据统计
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a href="/sys/forecast/manage.html">
                        <i class="layui-icon layui-icon-engine"></i>疾病预测
                    </a>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="content">
            <div class="layui-col-md12">
                <span class="layui-breadcrumb">
                    <a href="/sys/index.html">首页</a>
                    <a><cite>统计图表</cite></a>
                </span>
            </div>

            <div class="layui-col-md12">
                <hr>
            </div>

            <div class="layui-col-md12">
                <div class="layui-col-md12">
                    <fieldset class="layui-elem-field" style="margin-top: 20px; padding: 10px 0px;">
                        <span class="layui-badge-dot layui-bg-cyan"></span>
                        <strong>按人群统计</strong>
                        <div class="layui-col-md6">
                            <div class="layui-field-box">
                                <div id="main-1" style="width: 100%;height:400px;"></div>
                            </div>
                        </div>
                        <div class="layui-col-md6">
                            <div class="layui-field-box">
                                <div id="main-2" style="width: 100%;height:400px;"></div>
                            </div>
                        </div>
                    </fieldset>
                </div>

                <div class="layui-col-md12">
                    <fieldset class="layui-elem-field" style="margin-top: 20px; padding: 10px 0px;">
                        <span class="layui-badge-dot layui-bg-cyan"></span>
                        <strong>按地区统计</strong>
                        <div class="layui-col-md6">
                            <div class="layui-field-box">
                                <div id="main-3" style="width: 100%;height:400px;"></div>
                            </div>
                        </div>
                        <div class="layui-col-md6">
                            <div class="layui-field-box">
                                <div id="main-4" style="width: 100%;height:400px;"></div>
                            </div>
                        </div>
                    </fieldset>
                </div>

                <div class="layui-col-md12">
                    <fieldset class="layui-elem-field" style="margin-top: 20px; padding: 10px 0px;">
                        <span class="layui-badge-dot layui-bg-cyan"></span>
                        <strong>按感染程度统计</strong>
                        <div class="layui-col-md6">
                            <div class="layui-field-box">
                                <div id="main-5" style="width: 100%;height:400px;"></div>
                            </div>
                        </div>
                        <div class="layui-col-md6">
                            <div class="layui-field-box">
                                <div id="main-6" style="width: 100%;height:400px;"></div>
                            </div>
                        </div>
                    </fieldset>
                </div>

                <div class="layui-col-md12">
                    <fieldset class="layui-elem-field" style="margin-top: 20px; padding: 10px 0px;">
                        <div class="layui-col-md12">
                            <div class="layui-field-box">
                                <div id="main" style="width: 100%;height:400px;"></div>
                            </div>
                        </div>
                    </fieldset>
                </div>
            </div>
        </div>
    </div>

    <#include "common_bottom.ftl">
</nav>

</body>

<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/js/axquery.js"></script>
<script type="text/javascript" src="/js/template-web.js"></script>
<script type="text/javascript" src="/layui/layui.all.js"></script>
<script type="text/javascript" src="/js/echarts.js"></script>

<script>
    // 按人群统计
    var myEcharts1 = echarts.init(document.getElementById('main-1'));
    var myEcharts2 = echarts.init(document.getElementById('main-2'));
    Ax.rest("/sys/statistics/crowd/data", null, function (data) {
        /*   饼图   */
        var option1 = {
            tooltip: {
                trigger: 'item'
            },
            legend: {
                top: '5%',
                left: 'center'
            },
            series: [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '45%',
                    data: data.statisticsList,
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        myEcharts1.setOption(option1);

        /*   柱图   */
        var option2 = {
            tooltip: {},
            legend: {
                data:['患者数量']
            },
            xAxis: {
                data: data.nameList
            },
            yAxis: {},
            series: [{
                name: '患者数量',
                type: 'bar',
                data: data.valueList
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myEcharts2.setOption(option2);
    });
</script>

<script>
    // 按地区统计
    var myEcharts3 = echarts.init(document.getElementById('main-3'));
    var myEcharts4 = echarts.init(document.getElementById('main-4'));
    Ax.rest("/sys/statistics/region/data", null, function (data) {
        /*   饼图   */
        var option3 = {
            tooltip: {
                trigger: 'item'
            },
            legend: {
                top: '5%',
                left: 'center'
            },
            series: [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '45%',
                    data: data.statisticsList,
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        myEcharts3.setOption(option3);

        /*   柱图   */
        var option4 = {
            tooltip: {},
            legend: {
                data:['患者数量']
            },
            xAxis: {
                data: data.nameList
            },
            yAxis: {},
            series: [{
                name: '患者数量',
                type: 'bar',
                data: data.valueList
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myEcharts4.setOption(option4);
    });
</script>

<script>
    // 按感染程度统计
    var myEcharts5 = echarts.init(document.getElementById('main-5'));
    var myEcharts6 = echarts.init(document.getElementById('main-6'));
    Ax.rest("/sys/statistics/status/data", null, function (data) {
        /*   饼图   */
        var option5 = {
            tooltip: {
                trigger: 'item'
            },
            legend: {
                top: '5%',
                left: 'center'
            },
            series: [
                {
                    name: '访问来源',
                    type: 'pie',
                    radius: '45%',
                    data: data.statisticsList,
                    emphasis: {
                        itemStyle: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        myEcharts5.setOption(option5);

        /*   柱图   */
        var option6 = {
            tooltip: {},
            legend: {
                data:['患者数量']
            },
            xAxis: {
                data: data.nameList
            },
            yAxis: {},
            series: [{
                name: '患者数量',
                type: 'bar',
                data: data.valueList
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myEcharts6.setOption(option6);
    });
</script>

<script>
    // 按感染程度对比统计
    var myEcharts = echarts.init(document.getElementById('main'));
    Ax.rest("/sys/statistics/status/data2", null, function (respData) {
        /*   饼图   */
        var option = {
            title: {
                text: '感染程度对比'
            },
            tooltip: {
                trigger: 'axis'
            },
            legend: {
                data: ['密切接触者', '受感染者', '危重症病人', '死亡者', '治愈者', '正常']
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
            xAxis: {
                type: 'category',
                boundaryGap: false,
                data: respData.dateList
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: '密切接触者',
                    type: 'line',
                    stack: 'Total',
                    data: respData.data1
                },
                {
                    name: '受感染者',
                    type: 'line',
                    stack: 'Total',
                    data: respData.data2
                },
                {
                    name: '危重症病人',
                    type: 'line',
                    stack: 'Total',
                    data: respData.data3
                },
                {
                    name: '死亡者',
                    type: 'line',
                    stack: 'Total',
                    data: respData.data4
                },
                {
                    name: '治愈者',
                    type: 'line',
                    stack: 'Total',
                    data: respData.data5
                },
                {
                    name: '正常',
                    type: 'line',
                    stack: 'Total',
                    data: respData.data6
                },
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myEcharts.setOption(option);
    });
</script>
</html>