<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/js/axquery.js"></script>
    <script type="text/javascript" src="/layui/layui.all.js"></script>
<#--    <script type="text/javascript" src="/js/echarts.js"></script>-->
    <script type="text/javascript" src="/js/echarts/echarts.min.js"></script>
    <script type="text/javascript" src="/js/echarts/vintage.js"></script>
    <script type="text/javascript" src="/js/china.js"></script>

    <style>
        .item {
            padding: 10px;
            border: 1px solid #eeeeee;
            box-shadow: 1px 1px 5px 3px #eeeeee;
        }

        h2 {
            padding-left: 10px;
            padding-bottom: 5px;
        }

        .top-li {
            padding-right: 10px;
        }

        .top-li li {
            padding: 5px 10px;
            border: 1px solid #e2e2e2;
        }

        .top-li li a:hover {
            color: #009E94;
        }
    </style>
</head>
<body>
<nav class="layui-layout layui-layout-admin">
    <#include "head.ftl"/>

    <div class="layui-container" style="margin-top: 20px">
        <div class="layui-row">
            <div class="layui-col-md12">
                <fieldset class="layui-elem-field" style="margin-top: 20px; padding: 10px 0px;">
                    <div class="layui-col-md12" style="align-content: center">
                        <span class="layui-badge-dot layui-bg-cyan"></span>
                        <strong>全国疫情实时情况</strong>
                    </div>
                    <div class="layui-col-md8">
                        <div class="layui-field-box">
                            <div id="main-0" style="width: 100%;height:600px"></div>
                        </div>
                    </div>
                    <div class="layui-col-md4">
                        <div class="layui-field-box">
                            <div class="layui-card" style="background-color: #fffaf7;">
                                <div class="layui-card-header">本土现有确诊</div>
                                <div class="layui-card-body" id="localConfirmH5"
                                     style="color: #e57631; font-size: 2.4vw"></div>
                            </div>
                            <div class="layui-card" style="background-color: #fff8f8;">
                                <div class="layui-card-header">现有确诊</div>
                                <div class="layui-card-body" id="nowConfirm"
                                     style="color: #e61c1d; font-size: 2.4vw"></div>
                            </div>
                            <div class="layui-card" style="background-color: #fff4f4;">
                                <div class="layui-card-header">累计确诊</div>
                                <div class="layui-card-body" id="confirm"
                                     style="color: #be2121; font-size: 2.4vw"></div>
                            </div>
                            <div class="layui-card" style="background-color: #fef7ff;">
                                <div class="layui-card-header">无症状感染者</div>
                                <div class="layui-card-body" id="noInfect"
                                     style="color: #ae3ac6; font-size: 2.4vw"></div>
                            </div>
                            <div class="layui-card" style="background-color: #f1f5ff;">
                                <div class="layui-card-header">境外输入</div>
                                <div class="layui-card-body" id="importedCase"
                                     style="color: #4e8be6; font-size: 2.4vw"></div>
                            </div>
                            <div class="layui-card" style="background-color: #c2c2c2;">
                                <div class="layui-card-header">累计死亡</div>
                                <div class="layui-card-body" id="dead"
                                     style="color: #4e5a65; font-size: 2.4vw"></div>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </div>

            <div class="layui-col-md12">
                <div class="layui-form">
                    <table class="layui-table">
                        <thead>
                        <tr>
                            <th>地区</th>
                            <th>密切接触者</th>
                            <th>受感染者</th>
                            <th>危重症病人</th>
                            <th>死亡者</th>
                            <th>治愈者</th>
                            <th>正常</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list regionTabelList as item>
                            <tr>
                                <td>${item.name!'暂无'}</td>
                                <td>${item.patient1!'0'}</td>
                                <td>${item.patient2!'0'}</td>
                                <td>${item.patient3!'0'}</td>
                                <td>${item.patient4!'0'}</td>
                                <td>${item.patient5!'0'}</td>
                                <td>${item.patient6!'0'}</td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
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
    <#include 'bottom.ftl'>
</nav>

</body>

<script>
    //  全国疫情实时情况
    let myEcharts0 = echarts.init(document.getElementById('main-0'));
    let localConfirmH5 = $("#localConfirmH5");
    let nowConfirm = $("#nowConfirm");
    let confirm = $("#confirm");
    let noInfect = $("#noInfect");
    let importedCase = $("#importedCase");
    let dead = $("#dead");

    /* 中国地图 */
    let optionMap = {
        title: {
            text: '全国新冠肺炎实时确诊数量',
            // subtext: '最后更新于' + lastUpdateTime,
            // sublink: 'http://www.census.gov/popest/data/datasets.html',
            left: 'right'
        },
        tooltip: {
            trigger: 'item',
            showDelay: 0,
            transitionDuration: 0.2
        },
        visualMap: {
            left: 'right',
            min: 0,
            max: 500,
            inRange: {
                color: [
                    '#313695',
                    '#4575b4',
                    '#74add1',
                    '#abd9e9',
                    '#e0f3f8',
                    '#ffffbf',
                    '#fee090',
                    '#fdae61',
                    '#f46d43',
                    '#d73027',
                    '#a50026'
                ]
            },
            text: ['High', 'Low'],
            calculable: true
        },
        toolbox: {
            show: true,
            //orient: 'vertical',
            left: 'left',
            top: 'top',
            feature: {
                dataView: { readOnly: false },
                restore: {},
                saveAsImage: {}
            }
        },
        series: [
            {
                name: '数据',
                type: 'map',
                roam: true,
                map: 'china',
                emphasis: {
                    label: {
                        show: true
                    }
                },
                data: []
            }
        ]
    };

    $.ajax({
        type:"get",
        url:"https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5",
        dataType:"jsonp",
        async: false,
        success:function(data) {
            let lastUpdateTime = JSON.parse(data["data"])["lastUpdateTime"];
            /* 卡片展示数据 */
            let dataTitle = JSON.parse(data.data).chinaTotal;

            /* 地图数据 */
            let dataBefore = JSON.parse(data.data).areaTree[0];
            let dataAfter = dataBefore.children.map(province => ({//接受到的数据进行数据格式转换...
                name: province.name,
                value: province.total.nowConfirm,
            }));

            optionMap.title.subtext = '最后更新于' + lastUpdateTime;
            optionMap.series[0].data = dataAfter;

            // 使用刚指定的配置项和数据显示图表。
            myEcharts0.setOption(optionMap);
            // 卡片数据回显
            localConfirmH5.append(dataTitle.localConfirmH5);
            nowConfirm.append(dataTitle.nowConfirm);
            confirm.append(dataTitle.confirm);
            noInfect.append(dataTitle.noInfect);
            importedCase.append(dataTitle.importedCase);
            dead.append(dataTitle.dead);

        }
    });



</script>

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
                data: ['密切接触者', '受感染者', '危重症病人', '死亡者', '治愈者']
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
                }
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myEcharts.setOption(option);
    });
</script>
</html>
