<#include "./header.ftl">

<!-- main start -->
<div id="ucenterWrapper" class="ucenterWidth1 clearfix">
    <#include "./menu.ftl">

    <!-- main content start -->
    <section id="ucenterSection">
        <h1 class="purchaseTabUl clearfix newWorkTab">
            用户列表
        </h1>
        <div>
            <div id="seek1512371123288" class="search" style="clear:both">

                关键字：<input type="text" id="keyword" placeholder="ID、手机号、姓名、身份证" tar="name" class="w300 gray-small" venter="button[name=seek]" style="width:170px ">
                <label>注册时间：</label>
                <input type="text" id="startTime" placeholder="起始时间" value="" name="startTime" readonly="readonly" class="laydate-icon inputText">
                <span>&nbsp;至&nbsp;</span>
                <input type="text" id="endTime" placeholder="截止时间" value="" name="endTime" readonly="readonly" class="laydate-icon inputText">
                <button class="addSomeBtn addBtnFora" name="seek" class="find" id="find" onclick="findSubmit()" style="background-color: #00a7f2;color: #FFFFFF">查询</button>
                <button class="addSomeBtn addBtnFora" name="seek" class="find" onclick="findSubmit(1)">查询今天</button>
                <button class="addSomeBtn addBtnFora" name="seek" class="find" onclick="findSubmit(2)">查询昨天</button>
            </div>
        </div>
        <div>
            <div id="seek1512371123288" class="search" style="clear:both">
                注册人数:<a id="count" style="color: red">${count}</a>人
            </div>
        </div>
        <table class="nantable" border="0" cellspacing="0" cellpadding="0">
            <tbody>
            <tr class="nanTableTh">
                <th width="5%">ID</th>
                <th width="10%">手机号</th>
                <th width="10%">姓名</th>
                <th width="10%">身份证号</th>
                <th width="10%">独立浏览次数</th>
                <th width="10%">注册时间</th>
                <th width="10%">操作</th>
            </tr>
            </tbody>
        </table>
        <table class="ucenterTableSub" border="0" cellspacing="0" cellpadding="0">
            <tbody id="userlist">
            <#list list as user>
            <tr class="userlist" >
                <td width="5%">${user.id}</td>
                <td width="10%">${user.mobile}</td>
                <td width="10%">${user.name}</td>
                <td width="10%">${user.idcard}</td>
                <td width="10%">${user.view_count}</td>
                <td width="10%">${user.create_time?string("yyyy-MM-dd hh:mm:ss")}</td>
                <td width="10%" class="finds" style="cursor: pointer" onclick="window.location.href='/userdetails?uid=${user.id}'">查看</td>
            </tr>
            </#list>
            </tbody>
        </table>


    </section>
    <!-- main content end -->

</div>
<div style="margin:50px auto;width:1000px;">
    <#--<p style="font-size:18px;font-family:'微软雅黑';">样式参考,自定义小清新皮肤,无首页尾页,带跳转框,精简模式一：</p><br />-->
    <div id="page_div3" class="page_div3" style="margin-left: 20%"></div>
    <input id="pageInfo" type="hidden" pn="1" size="${size!10}" isQueryToday="0" isQueryYesterday="0">
</div>

<script>
    $(function () {
        $("#startTime").jeDate({
            format: "YYYY-MM-DD hh:mm"
        })
        $("#endTime").jeDate({
            format: "YYYY-MM-DD hh:mm"
        })
    })
</script>
<script type="text/javascript">
    $(document).ready(function () {
        findSubmit();
    })
    var query = {};
//    每一次查询会重新初始化pager，然后保留好查询条件，pager根据这些来进行查询。
    function findSubmit(flag) {
        var keyword = $("#keyword").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var query = {keyword: keyword, starttime: startTime, endtime: endTime};
        if (flag == 1) {
            $.extend(query, {isQueryToday: 1})
        } else if (flag == 2) {
            $.extend(query, {isQueryYesterday: 1})
        }
//        进行请求获取数据

        $.ajax({
            url:'/finduserlist',
            type:'POST',
            data:query,
            success:function(res){
                $('#page_div3').html('');
                page2('#page_div3', res.total, "/finduserlist", query, pageEvent, false);
                dealData(res);
            }
        })

    }

    function pageEvent(data) {
        $('#pageInfo').attr('size',${size!10});
        dealData(data);
    }
    <#--page2('#page_div3', ${total!1} , "/finduserlist", {size:$("#pageInfo").attr('size')}, pageEvent, false);-->

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
    function dealData(data) {
        var listhtml = $('#userlist');
        listhtml.html("");
        var innerhtml = '';
        $("#count").text(data.count);
        $.each(data.list, function (i, o) {
            innerhtml += '<tr class="userlist"><td width="5%">' + o.id + '</td>' +
                    '<td width="10%">' + o.mobile + '</td>' +
                    '<td width="10%">' + o.name + '</td>' +
                    '<td width="10%">' + o.idcard + '</td>' +
                    '<td width="10%">' + o.view_count + '</td>' +
                    '<td width="10%">' + format('yyyy-MM-dd hh:mm:ss',o.create_time) + '</td>' +
                    '<td width="10%" class="finds" onclick="window.location.href=\'/userdetails?uid=' + o.id + '\'">查看</td></tr>';
        })
        listhtml.html(innerhtml);
    }



</script>
<script>

</script>
<#include "./bottom.ftl">
</body>
