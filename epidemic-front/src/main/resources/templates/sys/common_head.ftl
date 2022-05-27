<div class="layui-header" style="min-width: 1200px; background-color:#F56C6C;">
    <div class="layui-logo layui-hide-xs layui-bg-orange">
        <h3>
            <strong>疫情防控后台管理</strong>
        </h3>
    </div>
    <!-- 头部区域（可配合layui 已有的水平导航） -->
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item layui-hide layui-show-md-inline-block">
            <div class="layui-col-md3">
                <@shiro.principal/>
            </div>
            <div class="layui-col-md1">
                <a href="javascript:;">
                    <img src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg" class="layui-nav-img">
                </a>
            </div>
            <dl class="layui-nav-child">
                <dd><a href="/sys/user/personal.html">个人资料</a></dd>
                <dd><a href="/login.out">退出</a></dd>
            </dl>
        </li>
    </ul>

</div>

<script>


</script>