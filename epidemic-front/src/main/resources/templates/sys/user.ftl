<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
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
                <li class="layui-nav-item layui-this">
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
                    <a href="/sys/user/manage.html">用户管理</a>
                    <a><cite>用户列表</cite></a>
                </span>
            </div>

            <div class="layui-col-md12">
                <hr>
            </div>

            <div class="layui-col-md12">
                <div class="layui-form" lay-filter="name">
                    <div class="layui-form-item">
                        <div class="layui-input-inline">
                            <input type="text" name="name"
                                   placeholder="请输入用户昵称" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-input-inline">
                            <select name="sex">
                                <option value="">按性别查看</option>
                                <option value="1">男</option>
                                <option value="0">女</option>
                            </select>
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
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-block">
                <input type="text" name="username" required lay-verify="required" placeholder="请输入用户名"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="text" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-block">
                <input type="text" name="name" required lay-verify="required" placeholder="请输入昵称"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="1" title="男" checked>
                <input type="radio" name="sex" value="0" title="女">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-block">
                <input type="text" name="cellphone" required lay-verify="required" placeholder="请输入手机号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input type="text" name="email" required lay-verify="required" placeholder="请输入邮箱" autocomplete="off"
                       class="layui-input">
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
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-block">
                <input type="text" name="name" required lay-verify="required" placeholder="请输入昵称"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="1" title="男">
                <input type="radio" name="sex" value="0" title="女">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-block">
                <input type="text" name="cellphone" required lay-verify="required" placeholder="请输入手机号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input type="text" name="email" required lay-verify="required" placeholder="请输入邮箱" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block" style="text-align: right">
                <button class="layui-btn layui-btn-sm" lay-submit lay-filter="edit">保存修改</button>
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
            , url: '/sys/user/data'
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , title: '用户数据表'
            , cols: [[
                {field: 'id', title: 'ID', width: 110, fixed: 'left', sort: true}
                , {field: 'username', title: '用户名'}
                , {
                    field: 'role', title: '身份', width: 130, templet: function (data) {
                        return "系统管理员";
                    }
                }
                , {field: 'name', title: '昵称'}
                , {
                    field: 'sex', title: '性别', width: 70, templet: function (data) {
                        if (data.sex == 1) {
                            return "男";
                        } else {
                            return "女";
                        }
                    }
                }
                , {field: 'email', title: '邮箱'}
                , {field: 'cellphone', title: '手机号'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 130}
            ]]
            , page: true
        });

        //头工具栏事件
        table.on('toolbar(dataTable)', function (obj) {
            switch (obj.event) {
                case 'add':
                    layer.open({
                        type: 1,
                        title: '添加用户',
                        content: $('#add'),
                        area: ['550px', '530px'],
                        success: function (layero, index) {
                            form.val('add', {
                                "username": "",
                                "password": "",
                                "email": "",
                                "name": "",
                                "cellphone": "",
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
                    Ax.rest("/sys/user/delete", data.id, function (data) {
                        obj.del();
                        layer.close(index);
                        layer.msg("删除成功");
                    })
                });
            } else if (obj.event == 'edit') {
                layer.open({
                    type: 1,
                    title: '编辑用户',
                    content: $('#edit'),
                    area: ['550px', '500px'],
                    success: function (layero, index) {
                        // if (data.sex == false) data.sex = 'false';
                        // if (data.sex == true) data.sex = 'true';
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
            var user = data.field;
            Ax.rest("/sys/user/add", data.field, function (data) {
                form.val('add', {
                    "username": "",
                    "password": "",
                    "email": "",
                    "cellphone": "",
                    "name": "",
                });
                layer.msg('添加成功');
                table.reload('dataTable');
            })
        });

        // 编辑
        form.on('submit(edit)', function (data) {
            var user = data.field;
            Ax.rest("/sys/user/edit", user, function (data) {
                layer.msg('用户信息已修改');
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