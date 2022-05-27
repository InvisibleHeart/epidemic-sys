<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" sizes="any" mask="" href="/images/earth.svg">
    <title>首页</title>
    <link rel="stylesheet" href="/layui/css/layui.css">

    <style>
        .content {
            padding: 15px;
        }

        i {
            margin-right: 10px;
        }

        .site-doc-icon li .layui-anim {
            width: 150px;
            height: 150px;
            line-height: 150px;
            margin: 0 auto 10px;
            text-align: center;
            background-color: #009688;
            cursor: pointer;
            color: #fff;
            border-radius: 50%;
        }

        .site-doc-icon li {
            display: inline-block;
            margin: 10px;
        }

        .site-doc-icon li .layui-anim {
            display: inline-block;
        }

        #blogTitle {
            background: url("/images/scenery6.jpg") center center / cover no-repeat #222;
            overflow: hidden;
            width: 100%;
            height: 40vh;
            max-height: 40vh;
            box-shadow: 0 1px 2px rgba(150,150,150,.7);
            text-align: center;
            display: table;
        }
    </style>
</head>
<body class="layui-layout-body">
<nav class="layui-layout layui-layout-admin">
    <#include "common_head.ftl">

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <#include "common_left.ftl">

            <ul class="layui-nav layui-nav-tree">
                <li class="layui-nav-item layui-this">
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
                    <a href="/pub/statistics/manage.html">
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
                <div class="layui-col-md12">
                    <blockquote class="layui-elem-quote" style="color:#009688; margin-bottom: 50px">
                        <i class="layui-icon">&#xe674;</i>欢迎登录疫情防控后台管理系统
                    </blockquote>
                </div>

                <div>
<#--                    <img src="/images/admin-index.jpg" style="width: 100%; height: 300px">-->
                    <!-- star特效的容器   -->
                    <div id="blogTitle"></div>
                </div>

            </div>
            <div class="layui-col-md12">
                <!-- 实现的容器   -->
                <div id="jsi-flying-fish-container" class="container">
                    <canvas width="100%" height="50px"></canvas>
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
<script type="text/javascript" src="/js/effects/fish.js"></script>
<script type="text/javascript" src="/js/effects/three.min.js"></script>
<script type="text/javascript" src="/js/effects/star.js"></script>

</html>

<script>

</script>