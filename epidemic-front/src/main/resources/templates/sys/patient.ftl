<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>患者管理</title>
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
                <li class="layui-nav-item layui-this">
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
                    <a href="/sys/patient/manage.html">患者管理</a>
                    <a><cite>患者列表</cite></a>
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
                                   placeholder="请输入患者姓名" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-input-inline">
                            <input type="text" name="source"
                                   placeholder="请输入感染源" autocomplete="off" class="layui-input">
                        </div>
                        <div class="layui-input-inline">
                            <select name="sex">
                                <option value="">按性别查看</option>
                                <option value="1">男</option>
                                <option value="0">女</option>
                            </select>
                        </div>
                        <div class="layui-input-inline">
                            <select name="crowd">
                                <option value="">按人群查看</option>
                                <option value="0">儿童</option>
                                <option value="1">少年</option>
                                <option value="2">青年</option>
                                <option value="3">中年</option>
                                <option value="4">老年</option>
                            </select>
                        </div>
                        <div class="layui-input-inline">
                            <select name="status">
                                <option value="">按状态查看</option>
                                <option value="0">密切接触者</option>
                                <option value="1">受感染者</option>
                                <option value="2">危重症病人</option>
                                <option value="3">死亡者</option>
                                <option value="4">治愈者</option>
                                <option value="5">正常</option>
                            </select>
                        </div>
                        <div class="layui-input-inline">
                            <select name="regionId">
                                <option value="">按地区查看</option>
                                <#list regionList as item>
                                    <option value="${item.id?c}">${item.name}</option>
                                </#list>
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
                    <a class="layui-btn layui-btn-xs" lay-event="nuclein">核酸记录</a>
                    <a class="layui-btn layui-btn-xs" lay-event="morbidity">发病记录</a>
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
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" required lay-verify="required" placeholder="请输入姓名"
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
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-block">
                <input type="text" name="age" required lay-verify="required|number" placeholder="请输入年龄"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身高</label>
            <div class="layui-input-block">
                <input type="text" name="height" required lay-verify="required" placeholder="请输入身高"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">体重</label>
            <div class="layui-input-block">
                <input type="text" name="weight" required lay-verify="required" placeholder="请输入体重"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身份证</label>
            <div class="layui-input-block">
                <input type="text" name="identityCard" required lay-verify="required|identity"
                       placeholder="请输入身份证" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input type="text" name="cellphone" required lay-verify="required|phone"
                       placeholder="请输入联系电话" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">感染源</label>
            <div class="layui-input-block">
                <textarea name="source" lay-verify="required" lay-reqtext="必填项不能为空"
                          placeholder="请输入感染源" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">人群</label>
            <div class="layui-input-block">
                <select name="crowd" lay-verify="required">
                    <option value="">按选择人群</option>
                    <option value="0">儿童</option>
                    <option value="1">少年</option>
                    <option value="2">青年</option>
                    <option value="3">中年</option>
                    <option value="4">老年</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <select name="status" lay-verify="required">
                    <option value="">按选择状态</option>
                    <option value="0">密切接触者</option>
                    <option value="1">受感染者</option>
                    <option value="2">危重症病人</option>
                    <option value="3">死亡者</option>
                    <option value="4">治愈者</option>
                    <option value="5">正常</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地区</label>
            <div class="layui-input-block">
                <select name="regionId" lay-verify="required">
                    <option value="">按选择地区</option>
                    <#list regionList as item>
                        <option value="${item.id}">${item.name}</option>
                    </#list>
                </select>
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
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" required lay-verify="required" placeholder="请输入姓名"
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
            <label class="layui-form-label">年龄</label>
            <div class="layui-input-block">
                <input type="text" name="age" required lay-verify="required|number" placeholder="请输入年龄"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身高</label>
            <div class="layui-input-block">
                <input type="text" name="height" required lay-verify="required" placeholder="请输入身高"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">体重</label>
            <div class="layui-input-block">
                <input type="text" name="weight" required lay-verify="required" placeholder="请输入体重"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">身份证</label>
            <div class="layui-input-block">
                <input type="text" name="identityCard" required lay-verify="required|identity"
                       placeholder="请输入身份证" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input type="text" name="cellphone" required lay-verify="required|phone"
                       placeholder="请输入联系电话" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">感染源</label>
            <div class="layui-input-block">
                <textarea name="source" lay-verify="required" lay-reqtext="必填项不能为空"
                          placeholder="请输入感染源" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">人群</label>
            <div class="layui-input-block">
                <select name="crowd" lay-verify="required">
                    <option value="">按选择人群</option>
                    <option value="0">儿童</option>
                    <option value="1">少年</option>
                    <option value="2">青年</option>
                    <option value="3">中年</option>
                    <option value="4">老年</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <select name="status" lay-verify="required">
                    <option value="">按选择状态</option>
                    <option value="0">密切接触者</option>
                    <option value="1">受感染者</option>
                    <option value="2">危重症病人</option>
                    <option value="3">死亡者</option>
                    <option value="4">治愈者</option>
                    <option value="5">正常</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">地区</label>
            <div class="layui-input-block">
                <select name="regionId" lay-verify="required">
                    <option value="">按选择地区</option>
                    <#list regionList as item>
                        <option value="${item.id}">${item.name}</option>
                    </#list>
                </select>
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
    layui.use(['form', 'table', 'upload'], function () {
        var table = layui.table,
            form = layui.form,
            upload = layui.upload;

        form.render('radio');

        table.render({
            elem: '#dataTable'
            , url: '/sys/patient/data'
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , title: '患者数据表'
            , cols: [[
                {field: 'id', title: 'ID', width: 110, fixed: 'left', sort: true}
                , {
                    field: 'region', title: '地区', width: 130, templet: function (data) {
                        if (data.regionName != null) {
                            return data.regionName;
                        } else {
                            return "暂无";
                        }
                    }
                }
                , {field: 'name', title: '姓名', width: 130}
                , {
                    field: 'crowd', title: '人群', width: 100, templet: function (data) {
                        if (data.crowd == 0) return "儿童";
                        if (data.crowd == 1) return "少年";
                        if (data.crowd == 2) return "青年";
                        if (data.crowd == 3) return "中年";
                        if (data.crowd == 4) return "老年";
                    }
                }
                , {
                    field: 'status', title: '状态', width: 130, templet: function (data) {
                        if (data.status == 0) return "密切接触者";
                        if (data.status == 1) return "受感染者";
                        if (data.status == 2) return "危重症病人";
                        if (data.status == 3) return "死亡者";
                        if (data.status == 4) return "治愈者";
                        if (data.status == 5) return "正常";
                    }
                }
                , {
                    field: 'sex', title: '性别', width: 70, templet: function (data) {
                        if (data.sex == 1) {
                            return "男";
                        } else {
                            return "女";
                        }
                    }
                }
                , {field: 'age', title: '年龄', width: 70}
                , {field: 'height', title: '身高', width: 100}
                , {field: 'weight', title: '体重', width: 100}
                , {field: 'identityCard', title: '身份证', width: 190}
                , {field: 'cellphone', title: '联系电话', width: 170}
                , {field: 'source', title: '感染源', width: 200}
                , {field: 'updateDate', title: '最后修改日期', width: 160, templet: function (data) {
                        return new Date(parseInt(data.updateDate)).toLocaleString().replace(/:\d{1,2}$/,' ');
                    }}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 280}
            ]]
            , page: true
        });

        //头工具栏事件
        table.on('toolbar(dataTable)', function (obj) {
            switch (obj.event) {
                case 'add':
                    layer.open({
                        type: 1,
                        title: '添加患者',
                        content: $('#add'),
                        area: ['550px', '550px'],
                        success: function (layero, index) {
                            form.val('add', {
                                "name": "",
                                "cellphone": "",
                                "age": "",
                                "height": "",
                                "weight": "",
                                "identityCard": "",
                                "source": "",
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
                    Ax.rest("/sys/patient/delete", data.id, function (data) {
                        obj.del();
                        layer.close(index);
                    })
                });
            } else if (obj.event == 'edit') {
                layer.open({
                    type: 1,
                    title: '编辑患者',
                    content: $('#edit'),
                    area: ['550px', '550px'],
                    success: function (layero, index) {
                        // if (data.sex == false) data.sex = 'false';
                        // if (data.sex == true) data.sex = 'true';
                        form.val('edit', data);
                    },
                    cancel: function (index, layero) {
                        layer.close(index);
                        layer.msg("编辑成功");
                    }
                });
            } else if (obj.event == 'nuclein') {
                location.href = "/sys/nuclein/manage.html?patientId=" + data.id;
            } else if (obj.event == 'morbidity') {
                location.href = "/sys/morbidity/manage.html?patientId=" + data.id;
            }

        });

        // 添加
        form.on('submit(add)', function (data) {
            Ax.rest("/sys/patient/add", data.field, function (data) {
                form.val('add', {
                    "name": "",
                    "cellphone": "",
                    "age": "",
                    "height": "",
                    "weight": "",
                    "identityCard": "",
                    "source": "",
                });
                layer.msg('添加成功');
                table.reload('dataTable');
            })
        });

        // 编辑
        form.on('submit(edit)', function (data) {
            Ax.rest("/sys/patient/edit", data.field, function (data) {
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