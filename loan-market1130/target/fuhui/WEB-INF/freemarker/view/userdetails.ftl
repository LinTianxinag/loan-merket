<#include "./header.ftl">

<!-- main start -->
<div id="ucenterWrapper" class="ucenterWidth1 clearfix">
    <#include "./menu.ftl">

    <!-- main content start -->
    <section id="ucenterSection">
        <h3><a onClick="javascript :history.back(-1);" style="cursor: pointer"><<<</a></h3>
        <li>&nbsp;&nbsp;&nbsp;&nbsp;</li>
        <h1 class="purchaseTabUl clearfix newWorkTab">
            浏览详情：${user.mobile}
            <#--<li class="active">-->
                <#--<a href="#">全部数据</a>-->
            <#--</li>-->
            <#--<li class="">-->
                <#--<a href="#">已导流</a>-->
            <#--</li>-->
            <#--<li class="">-->
                <#--<a href="#">未导流</a>-->
            <#--</li>-->
        </h1>
        <div>
            <div id="seek1512371123288" class="search" style="clear:both">

                关键字：<input type="text" id="keyword" placeholder="ID、平台名搜索" tar="name" class="w300 gray-small" venter="button[name=seek]" style="width:170px ">
                <label>浏览时间：</label>
                <input type="" id="startTime" placeholder="起始时间" value="" name="startTime" readonly="readonly" class="laydate-icon inputText">
                <span>&nbsp;至&nbsp;</span>
                <input type="" id="endTime" placeholder="截止时间" value="" name="endTime" readonly="readonly" class="laydate-icon inputText">
                <#--申请结果：-->
                <#--<select id="isreal" name="isreal" tar="isreal">-->
                <#--<option value="">请选择</option>-->
                <#--<option value="1">已上架</option>-->
                <#--<option value="0">已下架</option>-->
                <#--</select>-->
                <button class="addSomeBtn addBtnFora" name="seek" class="find" id="find" onclick="findSubmit()" style="background-color: #00a7f2;color: #FFFFFF">查询</button>
                <button class="addSomeBtn addBtnFora" name="seek" class="find" onclick="findSubmit(1)">查询今天</button>
                <button class="addSomeBtn addBtnFora" name="seek" class="find" onclick="findSubmit(2)">查询昨天</button>
            </div>
        </div>
        <div>
            <div id="seek1512371123288" class="search" style="clear:both">
                总浏览次数:<a style="color: red" id="count">${total}</a>次
            </div>
        </div>
        <table class="nantable" border="0" cellspacing="0" cellpadding="0">
            <tbody>
            <tr class="nanTableTh">
                <th width="5%">平台ID编号</th>
                <th width="10%">平台名称</th>
                <th width="10%">期望借款金额</th>
                <th width="10%">期望借款天数</th>
                <th width="10%">浏览时间</th>
            </tr>
            </tbody>
        </table>
        <table class="ucenterTableSub" border="0" cellspacing="0" cellpadding="0">
            <tbody id="userlist">
            <#list list as details>
            <tr class="userlist">
                <td width="5%">${details.plaid}</td>
                <td width="10%">${details.planame}</td>
                <td width="10%">${details}</td>
                <td width="10%">${details.planame}</td>
                <td width="10%">${details.browsing_time}</td>
            </tr>
            </#list>
            </tbody>
        </table>


    </section>
    <!-- main content end -->
</div>
<input id="uid" type="hidden" value="0"/>

<script>

    var uid = ${user.id}
    function findSubmit(flag){

        var keyword = $("#keyword").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var query = {keyword:keyword,starttime:startTime,endtime:endTime};
        if(flag == 1){
            $.extend(query,{isQueryToday:1})
        }else if(flag == 2){
            $.extend(query,{isQueryYesterday:1})
        }
        if(uid != null){
            $("#uid").val(uid);
        }
        $.extend(query,{uid:$("#uid").val()})
        $.ajax({
            url:'/finduserdetails',
            type:'POST',
            data:query,
            success:function(res){
                $("#userlist").children().remove();
                $("#count").text(res.total);
                var html = "";
                var list = res.list;
                var page = res.page;
                for(var i = 0;i < list.length;i++){
                    html += '<tr class="userlist">'
                            +'<td width="5%">'+list[i].plaid+'</td>'
                            +'<td width="10%">'+list[i].planame+'</td>'
                            +'<td width="10%">'+new Date(parseInt(list[i].browsing_time)).format("yyyy-MM-dd hh:mm:ss")+'</td></tr>';
                }
                $("#userlist").append(html);
            }
        })

    }


</script>
<script>
    $(function () {
        $("#startTime").jeDate({
            format: "YYYY-MM-DD hh:mm"
        })
        $("#endTime").jeDate({
            format: "YYYY-MM-DD hh:mm"
        })
    })
    //    var start = {
    //        format: 'YYYY-MM-DD hh:mm:ss',
    //        minDate: '2017-12-4 23:59:59', //设定最小日期为当前日期
    //        isinitVal:true,
    //        maxDate: $.nowDate({DD:0}), //最大日期
    //        okfun: function(obj){
    //            end.minDate = obj.val; //开始日选好后，重置结束日的最小日期
    //            endDates();
    //        }
    //    };
    //    var end = {
    //        format: 'YYYY年MM月DD日 hh:mm:ss',
    //        minDate: $.nowDate({DD:0}), //设定最小日期为当前日期
    //        maxDate: '2099-06-16 23:59:59', //最大日期
    //        okfun: function(obj){
    //            start.maxDate = obj.val; //将结束日的初始值设定为开始日的最大日期
    //        }
    //    };
    //    //这里是日期联动的关键
    //    function endDates() {
    //        //将结束日期的事件改成 false 即可
    //        end.trigger = false;
    //        $("#endTime").jeDate(end);
    //    }
    //    $('#startTime').jeDate(start);
    //    $('#endTime').jeDate(end);

</script>
<script>
    <#--function page2(pageDiv,totalPage,url,data,callback,first){-->
        <#--$(pageDiv).paging({-->
            <#--//参数-->
            <#--totalPage: totalPage,-->
            <#--showPage: 6,-->
            <#--pn: 2,-->
            <#--height: 30,    //高-->
            <#--width: 8,      //宽-->

            <#--total:totalPage?totalPage:1,-->
            <#--animation: false,-->
            <#--centerBgColor: "#fff",-->
            <#--centerFontColor: "#000",-->
            <#--centerBorder: "1px solid #ddd",-->
            <#--transition: "all .2s",-->
            <#--centerHoverBgColor: "#4296f5",-->
            <#--centerHoverBorder: "",-->
            <#--centerFontHoverColor: "#fff",-->
            <#--otherFontHoverColor: "#fff",-->
            <#--otherBorder: "1px solid #ddd",-->
            <#--otherHoverBorder: "",-->
            <#--otherBgColor: "#fff",-->
            <#--otherHoverBgColor: "#4296f5",-->
            <#--currentFontColor: "#fff",-->
            <#--currentBgColor: "#499af5",-->
            <#--currentBorder: "",-->
            <#--fontSize: 13,-->
            <#--currentFontSize: 13,-->
            <#--cormer: 2,-->
            <#--gapWidth: 3,-->
            <#--showJump: true,-->
            <#--jumpBgColor: "#fff",-->
            <#--jumpFontHoverColor: "#fff",-->
            <#--jumpHoverBgColor: "#4296f5",-->
            <#--jumpBorder: "1px solid #ddd",-->
            <#--jumpHoverBorder: "",-->
            <#--simpleType: 1,-->

            <#--//ajax-->
            <#--submitStyle: "ajax",-->
            <#--ajaxSubmitType: "post",-->
            <#--url: url,-->
            <#--ajaxData: data,-->
            <#--idParameter: "pn",-->
            <#--ajaxDataType: "json",-->
            <#--firstAjaxSubmit: first,-->
            <#--beforeAjaxSubmit: function () {       //发送请求前的操作,预处理函数，可在此根据要求动态更新请求参数-->
                <#--PageAPI.AddAjaxData({pageno:PageAPI.GetCurrentPage, size:10 });  //每次请求都获取一次请求参数   使用API统一使用PageAPI对象调用-->

            <#--},-->
            <#--ajaxSubmitBack: function(data){callback(data)}-->
        <#--});-->
    <#--}-->
    <#--function pageEvent(data) {-->
        <#--&lt;#&ndash;$('#pageInfo').attr('size',${size!10});&ndash;&gt;-->
        <#--dealData(data);-->
    <#--}-->

    <#--page2('#page_admin', ${total!1}, "/FindSysUserList", "", pageEvent, false);-->

    <#--function dealData(data) {-->
    <#---->
    <#--}-->
</script>
<#include "./bottom.ftl">

</body>
</html>
