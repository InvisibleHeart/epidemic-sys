<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" sizes="any" mask="" href="/images/earth.svg">
    <title>登录页面</title>
    <link rel="stylesheet" href="/layui/css/layui.css">

    <style>
        body {
            margin: 0px;
            padding: 0px;
            /*background-color: #eeeeee;*/
            background-color: #FFFAFA;
        }

        .index {
            min-width: 1200px;
        }

        .index .top {
            min-width: 1200px;
        }

        .index .top .index-top {
            width: 1200px;
            margin: auto;
            height: 80px;
            text-align: left;
            line-height: 80px;
        }

        .index .content {
            min-width: 1200px;
        }

        .index .content .index-cont {
            width: 1200px;
            margin: auto;
            position: relative;
            background-color: #fff;
            margin-bottom: 20px;
        }

        .index-cont .index-cont-left {
            width: 700px;
            height: 400px;
            position: absolute;
            margin-bottom: 20px;
            text-align: right;
            margin-top: 15px;
        }

        .index-cont .index-cont-right {
            width: 420px;
            margin-left: 20px;
            box-shadow: 1px 1px 3px 1px #c7c1c1;
            background-color: #fff;
            height: 380px;
            position: absolute;
            right: 10px;
            padding: 0px 20px;
            margin-bottom: 20px;
            padding-top: 40px;
        }

        .index-cont-right .item {
            padding: 10px;
        }

        .item .login {
            font-size: 20px;
            width: 230px;
        }

        .item .register {
            width: 150px;
            text-align: right;
            cursor: pointer;
        }

        .item .register button:hover {
            cursor: pointer;
        }

        .index-cont-right .inline-block {
            display: inline-block;
        }
    </style>
</head>
<body>
<div class="index">
    <div class="" style="background-color: #FFC0CB">
        <div class="layui-container">
            <div class="layui-row" style="padding: 20px 0px; font-size: 15px; color: white;">
                <i class="layui-icon layui-icon-username"></i> <strong>用户登陆</strong>
            </div>
        </div>
    </div>

    <div class="content layui-form" style="margin-top: 50px">
        <div class="index-cont">
            <div class="index-cont-left">
<#--                <img src="/images/login.jpg" style="width: 90%; height: 80%;"/>-->
                <div class="layui-carousel" id="test1">
                    <div carousel-item>
                        <div><img src="/images/scenery3.jpg" style="width: 100%;height: auto"></div>
                        <div><img src="/images/scenery4.jpg" style="width: 100%;height: auto"></div>
                        <div><img src="/images/scenery5.jpg" style="width: 100%;height: auto"></div>
                        <div><img src="/images/scenery5.jpg" style="width: 100%;height: auto"></div>
                        <div><img src="/images/scenery5.jpg" style="width: 100%;height: auto"></div>
                    </div>
                </div>

            </div>
            <div class="index-cont-right">
                <div class="layui-col-md12">
                    <div class="item" style="margin-bottom: 40px;">
                        <div class="inline-block login">登录</div>
                        <div class="inline-block register">
                            <a href="/index.html">浏览首页</a>
                            <a href="/register.html">前往注册</a>
                        </div>
                    </div>
                    <div class="layui-form-item" style="padding-right: 50px">
                        <label class="layui-form-label">用户名</label>
                        <div class="layui-input-block">
                            <input type="text" name="userName" required lay-verify="required"
                                   placeholder="请输入用户名" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item" style="padding-right: 50px">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-block">
                            <input type="password" name="passWord" required lay-verify="required"
                                   placeholder="请输入密码" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item verify" style="position: relative;">
                        <label class="layui-form-label">验证码</label>
                        <input class="layui-input-block yzm" type="text" required lay-verify="required"
                               placeholder="请输入验证码" autocomplete="off" style="margin-left: 0px; padding: 0px 10px">
                        <p id="picyzm" style="position: absolute; right: 5px; top: 0px; height: 50px"></p>
                    </div>
                    <div class="layui-form-item">
                        <div class="inline-block" style="margin-left: 110px">
                            <button type="submit" class="layui-btn" lay-submit lay-filter="loginDo">登录</button>
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
<script type="text/javascript" src="/js/verify.js"></script>
<script type="text/javascript" src="/js/effects/Ribbons.js"></script>
<#--<script type="text/javascript" src="/js/effects/Bubble.js"></script>-->

<script>
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#test1',
            width: '100%', //设置容器宽度
            height: '390px',
            arrow: 'always' //始终显示箭头
            // anim: 'updown' //切换动画方式
        });
    });
</script>

<script>
    //初始化验证码
    var verifyCode = new GVerify({
        id: "picyzm",
        type: "blend"
    });

    layui.use(['element', 'form', 'layer'], function () {
        var element = layui.element,
            form = layui.form,
            layer = layui.layer;

        form.on('submit(loginDo)', function (formData) {
            if (!verifyCode.validate($('.yzm').val())) {
                layer.msg('验证码错误');
                return;
            }
            var user = formData.field;
            Ax.rest("/login", user, function (data) {
                location.href = "/sys/index.html";
            })
        });
    });
</script>
</html>