<#include "./header.ftl">

<!-- main start -->
<#--<script type="text/javascript" src="../js/jquery.paging.js"></script>-->

<div id="ucenterWrapper" class="ucenterWidth1 clearfix">
    <#include "./menu.ftl">
    <!-- main content start -->
    <section id="ucenterSection">
        <table class="nantable" border="0" cellspacing="0" cellpadding="0">
            <tbody>
            <tr class="nanTableTh">
                <th width="8%">登录名称</th>
                <th width="10%">真实姓名</th>
                <th width="10%">手机号</th>
                <th width="10%">职位</th>
                <th width="10%">最后登录IP</th>
                <th width="12%">最后登录时间</th>
                <th width="10%">登陆次数</th>
                <th width="10%">账号状态</th>
                <th width="30%">操作</th>
            </tr>
            </tbody>
        </table>
        <table class="ucenterTableSub" border="0" cellspacing="0" cellpadding="0">
            <tbody id="sysUserList">
            <#list list as sysUser>
            <tr class="userlist" >
                <td width="8%">${sysUser.login_name}</td>
                <td width="10%">${sysUser.real_name}</td>
                <td width="10%">${sysUser.mobile}</td>
                <td width="10%">${sysUser.job}</td>
                <td width="10%">${sysUser.last_ip}</td>

                <td width="12%">${(sysUser.last_login_time)}</td>

                <td width="10%">${sysUser.login_times}</td>
                <td width="10%">
                    <#if sysUser.user_status == 1>
                    启用
                    <#else>
                    禁用
                    </#if>
                </td>
                <td width="30%" class="setDataTd">
                    <!--短信发送时,显示模板-->
                    <a class="setDataTda3"  style="cursor: pointer" onclick="changestatus(${sysUser.user_id},${sysUser.user_status})"  title="管理短信模板">
                        <i class="centerIcon">&nbsp;</i>
                        禁用/启用
                    </a>
                </td>
            </tr>
            </#list>
            </tbody>
        </table>
        <div style="margin:50px auto;width:1000px;">
        <#--<p style="font-size:18px;font-family:'微软雅黑';">样式参考,自定义小清新皮肤,无首页尾页,带跳转框,精简模式一：</p><br />-->
            <div id="page_admin" class="page_div3" style="margin-left: 20%"></div>
            <input id="pageInfo" type="hidden" pn="1" size="${size!10}">
        </div>

    </section>
    <!-- main content end -->

</div>
<style type="text/css">.layui-layer-tips .layui-layer-content{color: #666}</style>
<script type="text/javascript">

    function changestatus(id,status){
        $.ajax({
            url:'/editSysUser',
            type:'post',
            dataType:'json',
            data:{user_id:id,userStatus:status},
            success:function(data){
                if(data.status==200){
                    toastr.success(data.msg);
                    setTimeout(function(){
                        window.location.reload();
                    },1000)
                }else{
                    toastr.error(data.msg);
                }
            }
        })

    }

    function pageEvent(data) {
        $('#pageInfo').attr('size',${size!10});
        dealData(data);
    }
    page2('#page_admin', ${total!1}, "/FindSysUserList", "", pageEvent, false);

    function dealData(data) {
        var listhtml=$('#sysUserList');
        listhtml.html("");
        var innerhtml = '';
        $.each(data.list,function (i, o) {
            if(o.user_status==1)
                o.user_status="启用";
                else
                o.user_status="禁用";
                o.last_login_time=format('yyyy-MM-dd hh:mm:ss',o.last_login_time);
            innerhtml +='<tr class="userlist"><td width="8%">'+o.login_name+'</td>'+
                    '<td width="10%">'+o.real_name+'</td>'+
                    '<td width="10%">'+o.mobile+'</td>'+
                    '<td width="10%">'+o.job+'</td>'+
                    '<td width="10%">'+o.last_ip+'</td>'+
                    '<td width="12%">'+o.last_login_time+'</td>'+
                    '<td width="10%">'+o.login_times+'</td>'+
                    '<td width="10%">'+o.user_status+'</td>'+
                    '<td width="30%" class="setDataTd">'+
//                    '<a class="setDataTda1" target="_blank" href="#">'+
//                    '<i class="centerIcon">&nbsp;</i>编辑'+
//            '</a>'+
            '<a class="setDataTda3" href="#" title="管理短信模板">'+
             '<i class="centerIcon">&nbsp;</i>禁用/启用'+
            '</a>'+
            '</td></tr>';
        })
        listhtml.html(innerhtml);
    }
    function format(fm, de) { /*时间格式   格式(yyyy-MM-dd hh:mm:ss) 【时间】*/
        de = isNaN(de) ? false : de;
        Date.prototype.Format = function(fmt) {
            var fmt = fmt || '';
            var m = {
                "yyyy": this.getFullYear(), //年
                "MM": this.getMonth() + 1, //月份
                "dd": this.getDate(), //日
                "hh": this.getHours(), //小时
                "mm": this.getMinutes(), //分
                "ss": this.getSeconds(), //秒
                "qq": Math.floor((this.getMonth() + 3) / 3), //季度
                "SSSS": this.getMilliseconds() //毫秒
            };
            for(ev in m) {
                fmt = fmt.replace(ev, (m[ev] >= 10 ? m[ev] : "0" + m[ev]));
            }
            return fmt;
        };
        if(de) {
            return new Date(de).Format(fm)
        } else {
            return new Date().Format(fm)
        }
    }

</script>
<#include "./bottom.ftl">
</body>
