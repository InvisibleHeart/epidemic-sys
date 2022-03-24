<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link rel="stylesheet" href="/layui/css/layui.css">
</head>
<body>
<nav class="layui-layout layui-layout-admin">
    <div class="layui-bg-green">
        <div class="layui-container">
            <div class="layui-row" style="padding: 10px 0px">
                新用户注册
            </div>
        </div>
    </div>
    <div class="layui-container">
        <div class="layui-row" style="margin: 100px 0px">
            <div class="layui-col-md12" style="padding: 0px 250px">
                <div class="layui-tab layui-tab-card">
                    <ul class="layui-tab-title">
                        <li class="layui-this">新用户注册</li>
                    </ul>
                    <div class="layui-tab-content" style="min-height: 300px;">
                        <div class="layui-tab-item layui-show">
                            <div class="layui-form" style="padding: 0px 50px; margin-top: 30px; padding-left: 30px">
                                <div class="layui-form-item" style="display: none">
                                    <div class="layui-input-block">
                                        <input type="text" name="role" value="0" required
                                               lay-verify="required" autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">用户名</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="username" required lay-verify="required"
                                               placeholder="请输入用户名" autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">密码</label>
                                    <div class="layui-input-block">
                                        <input type="password" name="password" required lay-verify="required"
                                               placeholder="请输入密码" autocomplete="off" class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">昵称</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="name" required lay-verify="required"
                                               placeholder="请输入您的昵称" autocomplete="off" class="layui-input">
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
                                    <label class="layui-form-label">邮箱</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="email" required lay-verify="required|email"
                                               placeholder="请输入邮箱" autocomplete="off" class="layui-input">
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
                                        <button class="layui-btn" lay-submit lay-filter="register">注册</button>
                                        <a class="layui-btn layui-btn-primary" href="/login.html">前往登录</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/js/axquery.js"></script>
<script type="text/javascript" src="/layui/layui.all.js"></script>

<script>
    layui.use(['element', 'form', 'layer'], function () {
        var element = layui.element,
            form = layui.form,
            layer = layui.layer;

        form.on('submit(register)', function (formData) {
            Ax.rest("/register", formData.field, function (data) {
                layer.msg('注册成功，赶紧前往登录吧');
            })
        });
    });
</script>
</html>