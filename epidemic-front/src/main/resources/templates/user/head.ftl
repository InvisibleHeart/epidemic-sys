<div class="layui-nav layui-bg-black">
    <div class="layui-container">
        <div class="layui-row">
            <div class="layui-col-md12">
                <div class="layui-header layui-bg-black" style="margin: auto; color: #ffffff">
                    <div class="layui-logo">
                        <h4 style="text-align: left">
                            <a href="/index.html" style="color: #ffffff;">疫情防控系统</a>
                        </h4>
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
            </div>
        </div>
    </div>
</div>

<script>
    layui.use(['form'], function () {
        var form = layui.form;
        form.render('select');
    });

    function search() {
        location.href = "/index/search.html?search=" + $('.search').val();
    }
</script>
