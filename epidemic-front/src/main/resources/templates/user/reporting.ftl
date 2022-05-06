<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" sizes="any" mask="" href="/images/earth.svg">
    <title>EMS-健康报备-疫情防控,人人有责!</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">

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

    <div class="layui-header layui-bg-black" style="margin: auto; color: #ffffff">
        <div class="layui-logo layui-hide-xs layui-bg-black">
            <a href="/index.html" style="color: #ffffff;">疫情防控系统</a>
        </div>
        <ul class="layui-nav" style="text-align: right;">
            <li class="layui-nav-item">
                <a href="/login.html">后台登录</a>
            </li>
            <li class="layui-nav-item">
                <a href="/reporting.html">疫情报备</a>
            </li>
        </ul>
    </div>

    <div class="layui-container">
        <div class="layui-row" >
            <div class="layui-col-md12" >
                <div class="layui-tab layui-tab-card">
                    <ul class="layui-tab-title">
                        <li class="layui-this">健康报备</li>
                    </ul>
                    <div class="layui-tab-content" style="min-height: 300px;">
                        <div class="layui-tab-item layui-show">
                            <div class="layui-form" >
                                <div class="layui-form-item">
                                    <label class="layui-form-label">姓名</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="userName" required lay-verify="required"
                                               placeholder="请输入姓名" autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">身份证</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="identityCard" required lay-verify="required"
                                               placeholder="请输入身份证" autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">性别</label>
                                    <div class="layui-input-block">
                                        <input type="radio" name="sex" value="true" title="男" checked>
                                        <input type="radio" name="sex" value="false" title="女">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">行程码状态</label>
                                    <div class="layui-input-block">
                                        <input type="radio" name="travelCode" value="true" title="不带*" checked>
                                        <input type="radio" name="travelCode" value="false" title="带*">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">健康码状态</label>
                                    <div class="layui-input-block">
                                        <input type="radio" name="healthCode" value="1" title="绿码" checked>
                                        <input type="radio" name="healthCode" value="2" title="黄码">
                                        <input type="radio" name="healthCode" value="3" title="红码">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label ">身体状况</label>
                                    <div class="layui-input-block">
                                        <input type="radio" name="physicalCondition" value="健康" title="健康" checked>
                                        <input type="radio" name="physicalCondition" value="有发烧、咳嗽等症状" title="有发烧、咳嗽等症状">
                                        <input type="radio" name="physicalCondition" value="其他症状" title="其他症状">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label ">所在城市</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="city" required lay-verify="required"
                                               placeholder="请输入所在城市" autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">所居住地址</label>
                                    <div class="layui-input-block">
                                        <textarea name="address" placeholder="请输入内容" class="layui-textarea"></textarea>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">所在街道（镇/乡）的风险等级</label>
                                    <div class="layui-input-block">
                                        <select name="riskLevel" lay-verify="required">
                                            <option value=""></option>
                                            <option value="0">低风险</option>
                                            <option value="1">中风险</option>
                                            <option value="2">高风险</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">是否已接种加强针</label>
                                    <div class="layui-input-block">
                                        <select name="vaccines" lay-verify="required">
                                            <option value=""></option>
                                            <option value="0">未接种</option>
                                            <option value="1">已接种第一针</option>
                                            <option value="2">已接种第二针</option>
                                            <option value="3">已接种加强针</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">最近一次核酸检测时间</label>
                                    <div class="layui-input-block">
                                        <input type="text" class="layui-input" id="nucleicTime" name="nucleicTime"
                                               placeholder="请选择时间" autocomplete="off" >
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">核酸检测结果</label>
                                    <div class="layui-input-block">
                                        <select name="nucleicResults" lay-verify="required">
                                            <option value=""></option>
                                            <option value="0">阴性</option>
                                            <option value="1">阳性</option>
                                            <option value="2">未出结果</option>
                                            <option value="3">未做</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">手机号</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="cellphone" required lay-verify="required|phone"
                                               placeholder="请输入手机号" autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <div class="layui-input-block">
                                        <button class="layui-btn" lay-submit lay-filter="register">提交</button>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <#include 'bottom.ftl'>
</nav>

</body>

<script type="text/javascript" src="/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="/layui/layui.all.js"></script>

<script>
    layui.use(['element', 'form', 'layer', 'laydate'], function () {
        var element = layui.element,
            form = layui.form,
            layer = layui.layer,
            laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#nucleicTime' //指定元素
        });

        form.on('submit(register)', function (formData) {
            $.ajax({
                type: "POST",
                contentType: "application/json; charset=utf-8",
                url: "http://localhost:9090/setting/patient/reporting",
                data: JSON.stringify(formData.field),
                dataType: "JSON",
                async: true,
                success:function(data) {
                    console.log(data)
                    alert(data.message);
                    window.location.href='http://localhost:9000/index.html';
                }
            });
        });
    });
</script>

</html>
