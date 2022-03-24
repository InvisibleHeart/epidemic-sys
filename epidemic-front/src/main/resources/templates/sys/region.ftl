<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>地区管理</title>
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
                <li class="layui-nav-item layui-this">
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
                    <a href="/sys/region/manage.html">地区管理</a>
                    <a><cite>地区列表</cite></a>
                </span>
            </div>

            <div class="layui-col-md12">
                <hr>
            </div>

            <div class="layui-col-md12">
                <div class="layui-form" lay-filter="search">
                    <div class="layui-form-item">
                        <div class="layui-input-inline">
                            <input type="text" name="name"
                                   placeholder="请输入名称" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-input-inline">
                            <button class="layui-btn layui-btn" lay-submit lay-filter="search">
                                <i class="layui-icon">&#xe615;</i>搜索
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="layui-col-md12">
                <table class="layui-hide" id="dataTable" lay-filter="dataTable"></table>

                <script type="text/html" id="toolbarDemo">
                    <div class="layui-btn-container">
                        <a class="layui-btn layui-btn-sm layui-btn-primary" lay-event="add">
                            添加
                        </a>
                    </div>
                </script>

                <script type="text/html" id="barDemo">
                    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit">编辑</a>
                    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                </script>
            </div>
        </div>
    </div>

    <#include "common_bottom.ftl">
</nav>

<div id="add" style="display: none; padding: 30px">
    <div class="layui-form layui-form-pane" lay-filter="add">
        <div class="layui-form-item">
            <label class="layui-form-label">地区</label>
            <div class="layui-input-block">
                <input type="text" name="name" required lay-verify="required" placeholder="请输入地区名称"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block" style="text-align: right">
                <button class="layui-btn layui-btn-sm" lay-submit lay-filter="add">确定</button>
            </div>
        </div>
    </div>
</div>
<div id="edit" style="display: none; padding: 30px">
    <div class="layui-form layui-form-pane" lay-filter="edit">
        <div class="layui-form-item" style="display: none">
            <label class="layui-form-label">ID</label>
            <div class="layui-input-block">
                <input type="text" name="id" required lay-verify="required"
                       autocomplete="off" class="layui-input id">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地区</label>
            <div class="layui-input-block">
                <input type="text" name="name" required lay-verify="required" placeholder="请输入地区名称"
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

        table.render({
            elem: '#dataTable'
            , url: '/sys/region/data'
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , title: '地区数据表'
            , cols: [[
                {field: 'id', title: 'ID', width: 110, fixed: 'left', sort: true}
                , {field: 'name', title: '地区'}
                , {field: 'regionCount', title: '患者数量', width: 200}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 130}
            ]]
            , page: true
        });

        //头工具栏事件
        table.on('toolbar(dataTable)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'add':
                    layer.open({
                        type: 1,
                        title: '添加地区',
                        content: $('#add'),
                        area: ['450px', '230px'],
                        success: function (layero, index) {
                            form.val('add', {
                                "name": "",
                            })
                        },
                        cancel: function (index, layero) {
                            layer.close(index);
                        }
                    });
                    break;
            }
            ;
        });

        //监听行工具事件
        table.on('tool(dataTable)', function (obj) {
            var data = obj.data;
            if (obj.event == 'del') {
                layer.confirm('真的删除行么？', function (index) {
                    Ax.rest("/sys/region/delete", data.id, function (data) {
                        obj.del();
                        layer.close(index);
                        layer.msg("删除成功");
                    })
                });
            } else if (obj.event == 'edit') {
                layer.open({
                    type: 1,
                    title: '编辑地区',
                    content: $('#edit'),
                    area: ['450px', '230px'],
                    success: function (layero, index) {
                        form.val('edit', data)
                    },
                    cancel: function (index, layero) {
                        layer.close(index);
                    }
                });
            }
        });

        // 添加
        form.on('submit(add)', function (data) {
            Ax.rest("/sys/region/add", data.field, function (data) {
                form.val('add', {
                    "name": "",
                });
                layer.msg('添加成功');
                table.reload('dataTable');
            })
        });

        // 编辑
        form.on('submit(edit)', function (data) {
            Ax.rest("/sys/region/edit", data.field, function (data) {
                layer.msg('编辑成功');
                table.reload('dataTable');
            })
        });

        // 搜索
        form.on('submit(search)', function (data) {
            table.reload('dataTable', {
                where: data.field
            }); //只重载数据
        });

    });
</script>
</html>