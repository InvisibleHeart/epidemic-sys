<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" sizes="any" mask="" href="/images/earth.svg">
    <title>EMS-主页-疫情防控,人人有责!</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
<#--    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>-->
    <script type="text/javascript" src="/js/jquery-3.6.0.js"></script>
    <script type="text/javascript" src="/js/axquery.js"></script>
    <script type="text/javascript" src="/layui/layui.all.js"></script>
<#--    <script type="text/javascript" src="/js/echarts.js"></script>-->
    <script type="text/javascript" src="/js/echarts/echarts.min.js"></script>
    <script type="text/javascript" src="/js/echarts/vintage.js"></script>
    <script type="text/javascript" src="/js/china.js"></script>
    <script type="text/javascript" src="/js/effects/mouse.js"></script>
    <script src="https://eqcn.ajz.miesnfu.com/wp-content/plugins/wp-3d-pony/live2dw/lib/L2Dwidget.min.js"></script>
    <script>
        /*https://unpkg.com/live2d-widget-model-shizuku@1.0.5/assets/shizuku.model.json*/
        L2Dwidget.init({ "model": { jsonPath:
                    "https://unpkg.com/live2d-widget-model-shizuku@1.0.5/assets/shizuku.model.json",
                "scale": 1 }, "display": { "position": "left", "width": 110, "height": 150,
                "hOffset": 0, "vOffset": -20 }, "mobile": { "show": true, "scale": 0.5 },
            "react": { "opacityDefault": 0.8, "opacityOnHover": 0.1 } });
    </script>

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
                            <div class="layui-tab layui-tab-card">
                                <ul class="layui-tab-title">
                                    <li class="layui-this" onclick="repaint(true)">新增人数</li>
                                    <li onclick="repaint(false)">累计新增</li>
                                </ul>
                                <div class="layui-tab-content" style="height: 600px;">
                                    <div class="layui-tab-item layui-show">
                                        <div id="main-0" style="width: 100%;height:600px"></div>
                                    </div>
<#--                                    <div class="layui-tab-item">-->
<#--                                        <div id="main-0-2" style="width: 100%;height:600px"></div>-->
<#--                                    </div>-->
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="layui-col-md4">
                        <div class="layui-col-md12">
                            <div class="layui-field-box">
                                <i class="layui-icon">&#xe672;</i>
                                <strong class="layui-bg-gray" id="boardTitle">阿里健康提供数据,统计截至 </strong>
                            </div>
                            <div class="layui-field-box">
                                <div class="layui-card" style="background-color: #D4FFC9;">
                                    <div class="layui-card-header" id="incrCured">累计治愈</div>
                                    <div class="layui-card-body" id="totalCured"
                                         style="color: #2AD000; font-size: 2.4vw"></div>
                                </div>
                                <div class="layui-card" style="background-color: #fff8f8;">
                                    <div class="layui-card-header" >现有确诊</div>
                                    <div class="layui-card-body" id="currentConfirm"
                                         style="color: #e61c1d; font-size: 2.4vw"></div>
                                </div>
                                <div class="layui-card" style="background-color: #fff4f4;">
                                    <div class="layui-card-header" id="incrConfirm">累计确诊</div>
                                    <div class="layui-card-body" id="totalConfirmed"
                                         style="color: #be2121; font-size: 2.4vw"></div>
                                </div>
                                <div class="layui-card" style="background-color: #fef7ff;">
                                    <div class="layui-card-header" id="incrHidden">无症状感染者</div>
                                    <div class="layui-card-body" id="hidden"
                                         style="color: #ae3ac6; font-size: 2.4vw"></div>
                                </div>
                                <div class="layui-card" style="background-color: #f1f5ff;">
                                    <div class="layui-card-header" id="incrAbroadInputConfirmed">境外输入</div>
                                    <div class="layui-card-body" id="abroadInputConfirmed"
                                         style="color: #4e8be6; font-size: 2.4vw"></div>
                                </div>
                                <div class="layui-card" style="background-color: #c2c2c2;">
                                    <div class="layui-card-header" id="incrDeath">累计死亡</div>
                                    <div class="layui-card-body" id="totalDeath"
                                         style="color: #4e5a65; font-size: 2.4vw"></div>
                                </div>
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
<script type="text/javascript">
    $.shuicheMouse({
        type:11,
        color: false
    })
</script>
<script>
    // 回到顶部
    layui.use(['util', 'laydate', 'layer'], function(){
        var util = layui.util
            ,laydate = layui.laydate
            ,$ = layui.$
            ,layer = layui.layer;
        //固定块
        util.fixbar({
            bar1: false
            ,bar2: false
            ,css: {right: 50, bottom: 100}
            ,bgcolor: '#c2c2c2'

        });
    });

</script>
<script>
    //  全国疫情实时情况
    let myEcharts0 = echarts.init(document.getElementById('main-0'));
    let totalCured = $("#totalCured");
    let currentConfirm = $("#currentConfirm");
    let totalConfirmed = $("#totalConfirmed");
    let hidden = $("#hidden");
    let abroadInputConfirmed = $("#abroadInputConfirmed");
    let totalDeath = $("#totalDeath");

    /* 地图组件 */
    let optionMap = {
        title: {
            // text: '全国新冠肺炎实时确诊人数',
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
            max: 1000,
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
        type: "GET",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8; Content-Encoding: gzip",
        // crossDomain: true,
        // url: "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5",
        url: "https://cdn.mdeer.com/data/yqstaticdata.js",
        dataType: "jsonp",
        // scriptCharset: "UTF-8",
        jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
        jsonpCallback:"callbackstaticdata",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据
        data: "callback=?",
        // xhrFields: {
        //     withCredentials: true
        // },
        async: false,
        success:function(data) {
            let lastUpdateTime = data.country.time;
            /* 卡片展示数据 */
            let dataTitle = data.country;
            /* 地图数据 */
            let dataBefore = data.provinceArray;
            let dataAfter = dataBefore.map(province => ({//接受到的数据进行数据格式转换...
                name: province.childStatistic,
                value: province.currentConfirm,
            }));

            // 卡片数据回显
            $("#boardTitle").append(dataTitle.time);
            totalCured.append(dataTitle.totalCured);
            $("#incrCured").append("&nbsp<span class=\"layui-badge-dot layui-bg-green\"></span>&nbsp"
                + "<span class=\"layui-badge layui-bg-green\" >"
                + "较昨日增加 "
                + dataTitle.lastIncData.incrCured + "</span>");

            currentConfirm.append(dataTitle.currentConfirm);
            totalConfirmed.append(dataTitle.totalConfirmed);
            $("#incrConfirm").append("&nbsp<span class=\"layui-badge-dot\"></span>&nbsp"
                + "<span class=\"layui-badge\" >"
                + "较昨日增加 "
                + dataTitle.lastIncData.incrConfirm + "</span>");

            hidden.append(dataTitle.hidden);
            $("#incrHidden").append("&nbsp<span class=\"layui-badge-dot layui-bg-cyan\"></span>&nbsp"
                + "<span class=\"layui-badge layui-bg-cyan\" >"
                + "较昨日增加 "
                + dataTitle.lastIncData.incrHidden + "</span>");

            abroadInputConfirmed.append(dataTitle.abroadInputConfirmed);
            $("#incrAbroadInputConfirmed").append("&nbsp<span class=\"layui-badge-dot layui-bg-blue\"></span>&nbsp"
                + "<span class=\"layui-badge layui-bg-blue\" >"
                + "较昨日增加 "
                + dataTitle.lastIncData.incrAbroadInputConfirmed + "</span>");

            totalDeath.append(dataTitle.totalDeath);
            $("#incrDeath").append("&nbsp<span class=\"layui-badge-dot layui-bg-gray\"></span>&nbsp"
                + "<span class=\"layui-badge layui-bg-gray\" >"
                + "较昨日增加 "
                + dataTitle.lastIncData.incrDeath + "</span>");

            // 使用刚指定的配置项和数据显示图表。
            optionMap.title.text = "全国新冠肺炎实时确诊人数";
            optionMap.title.subtext = '最后更新于' + lastUpdateTime;
            optionMap.series[0].data = dataAfter;
            myEcharts0.setOption(optionMap);

        }
    });

    function repaint(flag) {
        $.ajax({
            type: "GET",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8; Content-Encoding: gzip",
            // crossDomain: true,
            // url: "https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5",
            url: "https://cdn.mdeer.com/data/yqstaticdata.js",
            dataType: "jsonp",
            // scriptCharset: "UTF-8",
            jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
            jsonpCallback:"callbackstaticdata",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据
            data: "callback=?",
            // xhrFields: {
            //     withCredentials: true
            // },
            async: true,
            success:function(data) {
                myEcharts0.clear();
                let lastUpdateTime = data.country.time;
                /* 地图数据 */
                let dataBefore = data.provinceArray;
                let dataAfter;
                if (flag) {
                    dataAfter = dataBefore.map(province => ({//接受到的数据进行数据格式转换...
                        name: province.childStatistic,
                        value: province.currentConfirm,
                    }));
                    optionMap.title.text = "全国新冠肺炎实时确诊人数";
                } else {
                    dataAfter = dataBefore.map(province => ({//接受到的数据进行数据格式转换...
                        name: province.childStatistic,
                        value: province.totalConfirmed,
                    }));
                    optionMap.title.text = "全国新冠肺炎累计确诊人数";
                }
                // 使用刚指定的配置项和数据显示图表。
                optionMap.title.subtext = '最后更新于' + lastUpdateTime;
                optionMap.series[0].data = dataAfter;
                myEcharts0.setOption(optionMap);
            }
        });

    }

</script>
<script>
    // 按人群统计
    var myEcharts1 = echarts.init(document.getElementById('main-1'));
    var myEcharts2 = echarts.init(document.getElementById('main-2'));
    Ax.rest("/pub/statistics/crowd/data", null, function (data) {
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
    Ax.rest("/pub/statistics/region/data", null, function (data) {
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
    Ax.rest("/pub/statistics/status/data", null, function (data) {
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
    Ax.rest("/pub/statistics/status/data2", null, function (respData) {
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
<script>
    /*窗口自适应，关键代码*/
    setTimeout(function (){
        window.onresize = function () {
            myEcharts.resize();
            myEcharts0.resize();
            myEcharts1.resize();
            myEcharts2.resize();
            myEcharts3.resize();
            myEcharts4.resize();
            myEcharts5.resize();
            myEcharts6.resize();
        }
    },200);
</script>
</html>
