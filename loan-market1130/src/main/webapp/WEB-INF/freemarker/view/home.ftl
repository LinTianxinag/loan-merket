<#include "./header.ftl">
<!-- main start -->
<div id="ucenterWrapper" class="ucenterWidth1 clearfix">
<#include "./menu.ftl">
    <style>
        td{
            align-content: center;
        }
    </style>
    <!-- main content start -->
    <section id="ucenterSection">
        <ul class="purchaseTabUl clearfix newWorkTab">
            <li class="tables active" index="1">
                <a href="#">全部数据</a>
            </li>
            <li class="tables " index="2">
                <a href="#">已上架</a>
            </li>
            <li class="tables " index="3">
                <a href="#">已下架</a>
            </li>
        </ul>
        <div>
            <div id="seek1512371123288" class="search" style="clear:both">
                关键字：<input type="text" id="keyword" placeholder="ID、平台名搜索" tar="name" class="w300 gray-small" venter="button[name=seek]">
                <label>上架时间：</label>
                <input type="" id="startTime" placeholder="起始时间" value="" name="startTime" readonly="readonly" class="laydate-icon inputText">
                <span>&nbsp;至&nbsp;</span>
                <input type="" id="endTime" placeholder="截止时间" value="" name="endTime" readonly="readonly" class="laydate-icon inputText">
                </select>
                <button class="addSomeBtn addBtnFora" name="find" class="find" onclick="findSubmit()">查询</button>
                <button class="addSomeBtn addBtnFora" name="addpla" class="addpla" onclick="window.location.href='/addplat'">添加新平台</button>
            </div>
        </div>
        <div>
            <div id="seek1512371123288" class="search" style="clear:both">
                今日上架平台:<a id="tdcount" style="color: red">${tdcount}</a>个
            </div>
        </div>
        <div id="allDate" style="display: block">
            <table class="nantable" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr class="nanTableTh">
                    <th width="6%">ID</th>
                    <th width="10%">平台名称</th>
                    <th width="10%">利率</th>
                    <th width="10%">浏览人数</th>
                    <th width="10%">首页展示</th>
                    <th width="10%">位置</th>
                    <th width="10%">当前状态</th>
                    <th width="15%">上架时间</th>
                    <th width="20%">操作</th>
                </tr>
                </tbody>
            </table>
            <table class="ucenterTableSub" border="0" cellspacing="0" cellpadding="0">
                <tbody class="plalist">
                </tbody>
            </table>
        </div>
        <div id="upDate" style="display: none">
            <table class="nantable" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr class="nanTableTh">
                    <th width="5%">ID</th>
                    <th width="10%">平台名称</th>
                    <th width="10%">利率</th>
                    <th width="10%">浏览人数</th>
                    <th width="10%">首页展示</th>
                    <th width="10%">位置</th>
                    <th width="15%">上架时间</th>
                    <th width="20%">操作</th>
                </tr>
                </tbody>
            </table>
            <table class="ucenterTableSub" border="0" cellspacing="0" cellpadding="0">
                <tbody class="plalist">
                </tbody>
            </table>
        </div>
        <div id="downDate" style="display: none">
            <table class="nantable" border="0" cellspacing="0" cellpadding="0">
                <tbody>
                <tr class="nanTableTh">
                    <th width="5%">ID</th>
                    <th width="10%">平台名称</th>
                    <th width="10%">利率</th>
                    <th width="10%">浏览人数</th>
                    <th width="10%">首页展示</th>
                    <th width="10%">位置</th>
                    <th width="10%">上架时间</th>
                    <th width="10%">下架时间</th>
                    <th width="20%">操作</th>
                </tr>
                </tbody>
            </table>
            <table class="ucenterTableSub" border="0" cellspacing="0" cellpadding="0">
                <tbody class="plalist">
                </tbody>
            </table>
        </div>


    </section>
    <div style="margin:50px auto;width:1000px;">
    <#--<p style="font-size:18px;font-family:'微软雅黑';">样式参考,自定义小清新皮肤,无首页尾页,带跳转框,精简模式一：</p><br />-->
        <div id="page_div3" class="page_div3" style="margin-left: 20%"></div>
        <input id="pageInfo" type="hidden" pn="1" size="${size!10}" isQueryToday="0" isQueryYesterday="0">
    </div>

    <!-- main content end -->
</div>
<script>
    $(".tables").click(function(){
        $("#allDate").css("display","none");
        $("#upDate").css("display","none");
        $("#downDate").css("display","none");
        var index = $(this).attr("index")
        $(".active").removeClass("active");
        $(this).addClass("active");
        if(index == 1){
            $("#allDate").css("display","block");
        }else if(index == 2){
            $("#upDate").css("display","block");
        }else if(index == 3){
            $("#downDate").css("display","block");
        }
        findSubmit();
    })


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

    $(document).ready(function(){
        findSubmit();
    })



    var query = {};
    function findSubmit(flag) {
        var index = $(".active").attr("index");
        var keyword = $("#keyword").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var query = {keyword: keyword, starttime: startTime, endtime: endTime};


        if (index == 2) {             //已上架
            $.extend(query, {onshelves: 1})
        } else if (index == 3) {       //已下架
            $.extend(query, {onshelves: 0})
        }

        $.ajax({
            url: '/findplatformlist',
            type: 'POST',
            data: query,
            success: function (res) {
                $('#page_div3').html('');
                page2('#page_div3', res.total, "/findplatformlist", query, pageEvent, false);
                dealDatas(res,index);

            }
        })
    }

    $("#tables").on('click',function(){
        alert("111")
    })

        function dealDatas(data,index) {
            var html = "";
            var list = data.list;
            $("#tdcount").text(data.tdcount);
            if(index == 1){
                for(var i = 0;i < list.length;i++){
                    var daytype = list[i].byday == 1 ? "日" : (list[i].byday == 2　? "月" : "");
                    var ishomepage = list[i].isHomepage == 0 ? "否" : (list[i].isHomepage == 1　? "是" : "");
                    var onshelves = list[i].onshelvesStatus == 0 ? "已下架" : (list[i].onshelvesStatus == 1　? "已上架" : "");
                    var displayposition = list[i].position != null ? list[i].position : "无优先";
                    var visitors_num = list[i].visitorsNum != null ? list[i].visitorsNum : 0;
                    var onshelvesstatus=list[i].onshelvesStatus;
                    var dataone,datatwo,datathr;
                    dataone = list[i].platId;
                    if (onshelvesstatus== '1'){
                        datatwo = "下架";
                        datathr = "xiajia(this)"
                    }else if(onshelvesstatus== '0'){
                        datatwo = "上架";
                        datathr = "shangjia(this)"
                    }else{};

                    html += '<tr><td width="6%">'+list[i].platId+'</td>'
                            + '<td width="10%">'+list[i].platName+'</td>'
                            + '<td width="10%">'+daytype+"/"+list[i].rate+'%</td>'
                            + '<td width="10%">'+visitors_num+'人</td>'
                            + '<td width="10%">'+ishomepage+'</td>'
                            + '<td width="10%">'+displayposition+'</td>'
                            + '<td width="10%">'+onshelves+'</td>'
                            + '<td width="15%">'+new Date(parseInt(list[i].updateTime)).format("yyyy-MM-dd hh:mm:ss")+'</td>'
                            + '<td width="20%" class="setDataTd">'
                            + '<a class="setDataTda1" target="_self" href="/platdetails?platid='+list[i].platId+'"><i class="centerIcon">&nbsp;</i>编辑</a>'
                            +'<a class="setDataTda3" data-id="'+dataone+'" href="javascript:void(0);" onclick="'+datathr+'"> <i class="centerIcon">&nbsp;</i>'+datatwo+'</a>'
                            + '<a class="setDataTda4 ajax-check-login" target="_self"  href="/platcheck?platid='+list[i].platId+'"><i class="centerIcon">&nbsp;</i>查看</a>'
                            + '</td></tr>';
                }

                $("#allDate .plalist").children().remove();
                $("#allDate .plalist").append(html);
            }else if(index == 2){
                for(var i = 0;i < list.length;i++){
                    var daytype = list[i].byday == 1 ? "日" : (list[i].byday == 2　? "月" : "");
                    var ishomepage = list[i].isHomepage == 0 ? "否" : (list[i].isHomepage == 1　? "是" : "");
                    var onshelves = list[i].onshelvesStatus == 0 ? "已下架" : (list[i].onshelvesStatus == 1　? "已上架" : "");
                    var displayposition = list[i].position != null ? list[i].position : "无优先";
                    var visitors_num = list[i].visitorsNum != null ? list[i].visitorsNum : 0;
                    var onshelvesstatus=list[i].onshelvesStatus;
                    var dataone,datatwo,datathr;
                    dataone = list[i].platId;
                    if (onshelvesstatus== '1'){
                        datatwo = "下架";
                        datathr = "xiajia(this)"
                    }else if(onshelvesstatus== '0'){
                        datatwo = "上架";
                        datathr = "shangjia(this)"
                    }else{};

                    html += '<tr><td width="5%">'+list[i].platId+'</td>'
                            + '<td width="10%" >'+list[i].platName+'</td>'
                            + '<td width="10%">'+daytype+"/"+list[i].rate+'%</td>'
                            + '<td width="10%">'+visitors_num+'人</td>'
                            + '<td width="10%">'+ishomepage+'</td>'
                            + '<td width="10%">'+displayposition+'</td>'
                            + '<td width="15%">'+new Date(parseInt(list[i].updateTime)).format("yyyy-MM-dd hh:mm:ss")+'</td>'
                            + '<td width="20%" class="setDataTd">'
                            + '<a class="setDataTda1" target="_self"  href="/platdetails?platid='+list[i].platId+'"><i class="centerIcon">&nbsp;</i>编辑</a>'
                            +'<a class="setDataTda3" data-id="'+dataone+'" href="javascript:void(0);" onclick="'+datathr+'"> <i class="centerIcon">&nbsp;</i>'+datatwo+'</a>'
                            + '<a class="setDataTda4 ajax-check-login" target="_self"  href="/platcheck?platid='+list[i].platId+'"><i class="centerIcon">&nbsp;</i>查看</a>'
                            + '</td></tr>';
                }

                $("#upDate .plalist").children().remove();
                $("#upDate .plalist").append(html);
            }else if(index == 3){
                for(var i = 0;i < list.length;i++){
                    var daytype = list[i].byday == 1 ? "日" : (list[i].byday == 2　? "月" : "");
                    var ishomepage = list[i].isHomepage == 0 ? "否" : (list[i].isHomepage == 1　? "是" : "");
                    var onshelves = list[i].onshelvesTime;
                    var displayposition = list[i].position != null ? list[i].position : "无优先";
                    var visitors_num = list[i].visitorsNum != null ? list[i].visitorsNum : 0;
                    var updateTime=list[i].updateTime;
                    var onshelvesstatus=list[i].onshelvesStatus;
                    var dataone,datatwo,datathr;
                    dataone = list[i].platId;
                    if (onshelvesstatus== '1'){
                        datatwo = "下架";
                        datathr = "xiajia(this)"
                    }else if(onshelvesstatus== '0'){
                        datatwo = "上架";
                        datathr = "shangjia(this)"
                    }else{};

                    html += '<tr><td width="5%">'+list[i].platId+'</td>'
                            + '<td width="10%">'+list[i].platName+'</td>'
                            + '<td width="10%">'+daytype+"/"+list[i].rate+'%</td>'
                            + '<td width="10%">'+visitors_num+'人</td>'
                            + '<td width="10%">'+ishomepage+'</td>'
                            + '<td width="10%">'+displayposition+'</td>'

                            + '<td width="10%">'+new Date(onshelves).format("yyyy-MM-dd hh:mm:ss")+'</td>'  //上下架时间？？？
                            + '<td width="10%">'+new Date(updateTime).format("yyyy-MM-dd hh:mm:ss")+'</td>'


                            + '<td width="20%" class="setDataTd">'
                            + '<a class="setDataTda1" target="_self"  href="/platdetails?platid='+list[i].platId+'"><i class="centerIcon">&nbsp;</i>编辑</a>'
                            +'<a class="setDataTda3" data-id="'+dataone+'" href="javascript:void(0);" onclick="'+datathr+'"> <i class="centerIcon">&nbsp;</i>'+datatwo+'</a>'
                            + '<a class="setDataTda4 ajax-check-login" target="_self"  href="/platcheck?platid='+list[i].platId+'"><i class="centerIcon">&nbsp;</i>查看</a>'
                            + '</td></tr>';
                }

                $("#downDate .plalist").children().remove();
                $("#downDate .plalist").append(html);
            }
        }


    function pageEvent(data) {
        $('#pageInfo').attr('size',${size!10});
        dealDatas(data);
    }

    //下架的按钮操作
    function xiajia(ev) {

        var platid=$(ev).attr('data-id');
        $.ajax({
            url:'/plat/down',
            type:'post',
            dataType:'json',
            data:{platid:platid},
            success:function(data){
                if(data.status==200){
                    toastr.success(data.msg);
                    setTimeout(function () {
                        window.location.reload();
                    },1000);
                }else{
                    toastr.err(data.msg);
                }
            }
        })
    }

    //上架的按钮操作
    function shangjia(ev) {

        var platid=$(ev).attr('data-id');
        $.ajax({
            url:'/plat/upit',
            type:'post',
            dataType:'json',
            data:{platid:platid},
            success:function(data){
                if(data.status==200){
                    toastr.success(data.msg);
                    setTimeout(function () {
                        window.location.reload();
                    },1000);
                }else{
                    toastr.err(data.msg);
                }
            }
        })
    }






</script>



<#include "./bottom.ftl">

</body>
