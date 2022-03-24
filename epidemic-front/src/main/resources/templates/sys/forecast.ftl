<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>疾病预测</title>
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
                <li class="layui-nav-item">
                    <a href="/sys/statistics/manage.html">
                        <i class="layui-icon layui-icon-chart"></i>数据统计
                    </a>
                </li>
                <li class="layui-nav-item layui-this">
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
                    <a><cite>疾病预测</cite></a>
                </span>
            </div>


            <div class="layui-col-md12">
                <hr>
            </div>

            <div class="layui-col-md12">
                <fieldset class="layui-elem-field" style="margin-top: 20px; padding: 10px 0px;">
                    <div class="layui-col-md12" style="align-content: center">
                        <span class="layui-badge-dot layui-bg-cyan"></span>
                        <strong>模拟疫情传播</strong>
                    </div>
                    <div class="layui-col-md8">
                        <div class="layui-field-box">
                            <div id="main-1" style="width: 100%;height:600px"></div>
                        </div>
                    </div>
                    <div class="layui-col-md4">
                        <div class="layui-field-box">

                        </div>
                    </div>
                </fieldset>
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
<script type="text/javascript" src="/js/echarts/echarts.min.js"></script>
<script type="text/javascript" src="/js/echarts/vintage.js"></script>

<script>

    var myEcharts1 = echarts.init(document.getElementById('main-1'));

    $.ajax({
        url: "http://localhost:9090/setting/statistics/forecast",
        type: "GET",
        dataType: "JSON",
        async: false,
        success: function (data) {
            run(data.data);
        }

    });


    function run(_rawData) {

        const categorys = [
            'Susceptible',
            'Exposed',
            'Infectious',
            'Recovered'
        ];
        const datasetWithFilters = [];
        const seriesList = [];
        echarts.util.each(categorys, function (category) {
            var datasetId = 'dataset_' + category;
            datasetWithFilters.push({
                id: datasetId,
                fromDatasetId: 'dataset_raw',
                transform: {
                    type: 'filter',
                    config: {
                        and: [
                            { dimension: 'day', gte: 1 },
                            { dimension: 'name', '=': category }
                        ]
                    }
                }
            });
            seriesList.push({
                type: 'line',
                datasetId: datasetId,
                showSymbol: false,
                name: category,
                endLabel: {
                    show: true,
                    formatter: function (params) {
                        return params.value[3] + ': ' + params.value[0];
                    }
                },
                labelLayout: {
                    moveOverlap: 'shiftY'
                },
                emphasis: {
                    focus: 'series'
                },
                encode: {
                    x: 'Year',
                    y: 'Income',
                    label: ['Category', 'Number'],
                    itemName: 'Day',
                    tooltip: ['Number']
                }
            });
        });
        let option = {
            animationDuration: 10000,
            dataset: [
                {
                    id: 'dataset_raw',
                    source: _rawData
                },
                ...datasetWithFilters
            ],
            title: {
                text: '新冠疫情预测模型'
            },
            tooltip: {
                order: 'valueDesc',
                trigger: 'axis'
            },
            xAxis: {
                type: 'category',
                nameLocation: 'middle'
            },
            yAxis: {
                name: 'number'
            },
            grid: {
                right: 140
            },
            series: seriesList
        };
        myEcharts1.setOption(option);
    }

</script>

</html>