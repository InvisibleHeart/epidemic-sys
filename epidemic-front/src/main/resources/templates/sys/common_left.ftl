<div style="padding: 20px">
    <#if user ??>
        <img src="/images/headImg.jpg" class="layui-nav-img">${user.name}
        <br/>
        <span class="layui-badge-dot layui-bg-green"
              style="margin-left: 40px; margin-right: 5px"></span>管理员
        <br/>
        <span class="layui-badge-dot layui-bg-green" style="margin-left: 40px; margin-right: 5px"></span>在线
    </#if>
</div>
