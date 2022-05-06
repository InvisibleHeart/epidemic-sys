<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" sizes="any" mask="" href="/images/earth.svg">
    <title>个人资料</title>
    <link rel="stylesheet" href="/layui/css/layui.css">

    <style>
        .content {
            padding: 15px;
        }

        .box-s {
            background-color: #ffffff;
            box-shadow: 1px 1px 5px 3px #e2e2e2;
            padding: 10px 15px;
            margin: 20px 0px;
            color: #009688;
        }

        i {
            margin-right: 10px;
        }

        fieldset{
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
                        <a><cite>个人资料</cite></a>
                    </span>
            </div>

            <div class="layui-col-md12">
                <hr>
            </div>

            <div class="layui-col-md12" style="padding: 0px 200px">

                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                    <legend>个人资料</legend>
                </fieldset>

                <div class="layui-form layui-form-pane" lay-filter="edit">
                    <div class="layui-form-item" style="display: none">
                        <label class="layui-form-label">id</label>
                        <div class="layui-input-block">
                            <input type="text" name="id" value="${user.id?c}" required lay-verify="required"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-block">
                            <input type="text" name="username" style="cursor: not-allowed"
                                   value="${user.username}"
                                   disabled autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-block">
                            <input type="text" name="password" value="${user.password}"
                                   required lay-verify="required" placeholder="请输入密码" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">昵称</label>
                        <div class="layui-input-block">
                            <input type="text" name="name" value="${user.name!''}"
                                   required lay-verify="required" placeholder="请输入昵称"
                                   autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <#if user.sex>
                                <input type="radio" name="sex" value="true" title="男" checked>
                                <input type="radio" name="sex" value="false" title="女">
                            <#else>
                                <input type="radio" name="sex" value="true" title="男">
                                <input type="radio" name="sex" value="false" title="女" checked>
                            </#if>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">邮箱</label>
                        <div class="layui-input-block">
                            <input type="text" name="email" value="${user.email!''}"
                                   required lay-verify="required|email" placeholder="请输入邮箱"
                                   autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">手机号</label>
                        <div class="layui-input-block">
                            <input type="text" name="cellphone" value="${user.cellphone!''}"
                                   required lay-verify="required|phone" placeholder="请输入手机号"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block" style="text-align: right">
                            <button class="layui-btn layui-btn-sm" lay-submit lay-filter="edit">保存编辑</button>
                        </div>
                    </div>
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

<script>
    layui.use(['form', 'table'], function () {
        var table = layui.table,
            form = layui.form;

        form.render('radio');

        // 保存编辑
        form.on('submit(edit)', function (data) {
            var admin = data.field;
            Ax.rest("/sys/user/edit/personal", admin, function (data) {
                layer.msg('编辑成功');
            })
        });

    });
</script>
</html>