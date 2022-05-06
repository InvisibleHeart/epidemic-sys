<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" sizes="any" mask="" href="/images/earth.svg">
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
<#--                    <div class="layui-col-md12" style="align-content: center">-->
<#--                        <span class="layui-badge-dot layui-bg-cyan"></span>-->

<#--                    </div>-->
                    <div class="layui-col-md2">
                        <div class="layui-col-md12">
                            &nbsp;&nbsp;&nbsp;&nbsp;<span class="layui-badge-rim">疫情传播模型</span>
                        </div>
                        <div class="layui-col-md12 layui-col-space5">
                            <div class="layui-field-box">
                                <form class="layui-form layui-form-pane"> <!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
                                    <div class="layui-form-item" pane>
                                        <label class="layui-form-label">易感人数（正常人）</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input">
                                        </div>
                                    </div>
                                    <div class="layui-form-item" pane>
                                        <label class="layui-form-label">无症状感染者</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input">
                                        </div>
                                    </div>
                                    <div class="layui-form-item" pane>
                                        <label class="layui-form-label">新冠感染者</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input">
                                        </div>
                                    </div>

                                    <div class="layui-form-item" pane>
                                        <label class="layui-form-label">待预测天数</label>
                                        <div class="layui-input-block">
                                            <input type="text" name="" placeholder="请输入" autocomplete="off" class="layui-input">
                                        </div>
                                    </div>

                                    <#--                                <div class="layui-form-item">-->
                                    <#--                                    <div class="layui-input-block">-->
                                    <#--                                        <button class="layui-btn layui-btn-sm layui-btn-radius" lay-submit lay-filter="*">立即提交</button>-->
                                    <#--                                        <button type="reset" class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">重置</button>-->
                                    <#--                                    </div>-->
                                    <#--                                </div>-->
                                    <div class="layui-col-md12">
                                        <button class="layui-btn layui-btn-sm layui-btn-radius" lay-submit lay-filter="forecast">立即提交</button>
                                        <button type="reset" class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">重置</button>
                                    </div>
                                    <#--                                <div class="layui-form-item">-->
                                    <#--                                    <div class="layui-input-block">-->
                                    <#--                                        <button type="reset" class="layui-btn layui-btn-sm layui-btn-radius layui-btn-primary">重置</button>-->
                                    <#--                                    </div>-->
                                    <#--                                </div>-->
                                    <!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="layui-col-md10">
                        <div class="layui-field-box">
                            <div id="main-1" style="width: 100%;height:600px"></div>
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
            // console.log(data);
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
                            { dimension: 'day', gte: 2 },
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
                        return params.value[1] + ': ' + params.value[2];
                    }
                },
                labelLayout: {
                    moveOverlap: 'shiftY'
                },
                emphasis: {
                    focus: 'series'
                },
                encode: {
                    x: 'day',
                    y: 'number',
                    label: ['Category', 'Number'],
                    itemName: 'Day',
                    tooltip: ['Number']
                }
            });
        });
        // console.log(seriesList);
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
            legend: {
                data: categorys
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

        /*窗口自适应，关键代码*/
        setTimeout(function (){
            window.onresize = function () {
                myEcharts1.resize();
            }
        },200);

    }

</script>

<script>

    layui.use('form', function(){
        let form = layui.form;

        // 提交
        form.on('submit(forecast)', function (data) {
            layer.msg('请求成功');
            if (data != null) {
                $.ajax({
                    url: "http://localhost:9090/utils/get",
                    type: "POST",
                    dataType: "JSON",
                    data: JSON.stringify(data),
                    async: true,
                    success: function (data) {
                        console.log(data);
                        myEcharts1.clear();
                        run(data.data);
                    }

                });
            }

        });

        //各种基于事件的操作，下面会有进一步介绍
    });
</script>


</html>