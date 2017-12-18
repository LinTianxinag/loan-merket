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
                    <#--<a class="setDataTda1" target="_blank" href="#">-->
                        <#--<i class="centerIcon">&nbsp;</i>-->
                        <#--编辑-->
                    <#--</a>-->
                    <!--短信发送时,显示模板-->
                    <a class="setDataTda3" href="/editSysUser?id=${sysUser.user_id}&userStatus=${sysUser.user_status}" title="管理短信模板">
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
<script type="text/javascript">
    $(document).ready(function(){
        //ucenter 统一使用的提交方式:ajaxsubmit,所以当用户登录失效的时候无法跳转到指定页面,
        //添加下面对button 按钮的监视,如果为失效继续下面动作,如果点击按钮的时候登录失效了,就跳转到指定页面,如登录页面
        $('.ajax-check-login,button,input:button').click(function(event){
            var login = true;
            $.getJSON('/login/loginStatus',function(obj){
                if(obj.code=='-1')
                {
                    if(self == top){
                        window.location.href = obj.acturl;
                    }else{
                        parent.window.location.reload();
                    }

                    login = false;
                }
            })

            if(!login)
            {
                event.stopImmediatePropagation();
            }
        })

    })
    // 退出登录
    function logout(){
        $.getJSON('/login/logout',function(obj){
            window.location.href='/';
        })
    }

    $("input[name=q]").focus(function(){
        document.onkeydown = function(e){
            var ev = document.all ? window.event : e;
            if(ev.keyCode==13) {
                $("#searchBtn").click();
            }
        }
    })

    // header里的搜索框
    $("#searchBtn").click(function(){
        var q = $("input[name=q]").val();
        q=q.replace(/\//g,'');

        if(q.length==''){
            $("input[name=q]").focus();
            return false;
        }

        var searchUrl = '/docs/s/q/%40q%40';
        searchUrl=searchUrl.replace(/%40q%40/,encodeURIComponent(q));
        window.location.href=searchUrl;
    })

    $(document).ready(function(){

        $("input[name=q]").focus(function(){
            document.onkeydown = function(e){
                var ev = document.all ? window.event : e;
                if(ev.keyCode==13) {
                    $("#searchBtn").click();
                }
            }
        })
    })

    function isMobile(mobile){
        var mreg =/^1[3|5|8|4|7]{1}[0-9]{1}[0-9]{8}$/;
        if(!mreg.test(mobile)){
            return false;
        }
        return true;
    }

    $('a[href="http://crm2.qq.com/page/portalpage/wpa.php?uin=800076065&f=1&ty=1&aty=0&a=&from=6"]').bind('click',function(){
        nslog(1121);
    });
</script>

<style type="text/css">.layui-layer-tips .layui-layer-content{color: #666}</style>
<script type="text/javascript">
    $(function(){
        //已申请数据检索
        $('.subKWBtn').click(function(){
            $('#dataSearchE').hide()
            var kw = $.trim($('#titleKW').val());
            kw= kw.replace(/\//g,'').replace(/^\.+/g,'');
            var rule = /^[\u4E00-\u9FA5\uF900-\uFA2Da-z0-9\.]+$/i

            if(kw.length <=0){
                location.href = '/myData/index';
            }else{
                if(kw.length > 0 && !rule.test(kw)){
                    $('#dataSearchE').show().children('em').html('仅限中文/字母/数字/"."检索');
                    return false;
                }
                location.href = '/myData/index/titleKW/'+kw;
            }
        })
        // 预警按钮
        $('.setDataTda4').click(function(){
            if($(this).attr('data') == '') return false;
            layer.open({
                type: 2,
                title: [$(this).attr('title'),'font-size:16px;color:#606060'],
                btn:false,
                shadeClose: true,
                border: [2,0.5,'#ccc'],
                scrollbar:false,
                shade: 0.5,
                area: ['542px', '348px'],
                content: $(this).attr('data')
            });
        })

        //wargin tips
        $('.setDataTda5').mousemove(function(){
            $(this).find('.orderTips2').fadeIn();
        }).mouseout(function(){
            $(this).find('.orderTips2').stop(true).hide();
        });
        //分页跳转
        $('.goPageInput').keydown(function(e){
            if(e.keyCode == 13)
            {
                goPage('.goPageInput')
            }
        })
        $('#okSearch').click(function(){
            goPage('.goPageInput');
        })

        /* 这里是计划更新剩余次数*/
        var jsurplus = '61c2758c935bbe7022f13eed77b1eb86,b39185997baf6f29763c864eaa63717e,77cead9c81b85471867371d033ad1b09,f1d19fb536ca84454d9583bc07d669ac';
//        if(jsurplus!='')
//        {
//            setTimeout(function () {
//                if (jsurplus) {
//                    $.post('/myData/getjsurplus', {jsurplus: jsurplus}, function (e) {
//                        if (e != 'Forbidden') {
//                            var obj = json_parse(e);
//                            var data = obj.result;
//                            for (i in data) {
//                                if (data[i]['surplus'] == '-99') {
//                                    data[i]['surplus'] = '不限次数至&nbsp;' + data[i]['surexpired'];
//                                    $("#giftimg_" + data[i]['appkey']).remove();
//                                }
//                                $("#surplus_" + data[i]['appkey']).html(data[i]['surplus']);
//                            }
//                        }
//                    })
//                }
//            }, 500);
//        }

        //table vertify
        $('.certifyDiv').mouseenter(function () {
            $('.dataCertifyTips').show();
        }).mouseleave(function () {
            $('.dataCertifyTips').hide();
        });

    });
    function goPage(selected)
    {
        var num = $(selected).val();
        var max = $(selected).attr('max');
        if(isNaN(num))
        {
            alert('请输入数字!');
            $(selected).val(1);//如果输入的不是数字,则默认为1
            return false;
        }

        if((num-max)>0)
        {
            num = max;
        }
        if(num<1)
        {
            num = 1;
        }
        location.href = $(selected).attr('action')+num;
    }
</script>
<script type="text/javascript">
    function page2(pageDiv,totalPage,url,data,callback,first){
        $(pageDiv).paging({
            //参数
            totalPage: totalPage,
            showPage: 6,
            pn: 2,
            height: 30,    //高
            width: 8,      //宽

            total:totalPage?totalPage:1,
            animation: false,
            centerBgColor: "#fff",
            centerFontColor: "#000",
            centerBorder: "1px solid #ddd",
            transition: "all .2s",
            centerHoverBgColor: "#4296f5",
            centerHoverBorder: "",
            centerFontHoverColor: "#fff",
            otherFontHoverColor: "#fff",
            otherBorder: "1px solid #ddd",
            otherHoverBorder: "",
            otherBgColor: "#fff",
            otherHoverBgColor: "#4296f5",
            currentFontColor: "#fff",
            currentBgColor: "#499af5",
            currentBorder: "",
            fontSize: 13,
            currentFontSize: 13,
            cormer: 2,
            gapWidth: 3,
            showJump: true,
            jumpBgColor: "#fff",
            jumpFontHoverColor: "#fff",
            jumpHoverBgColor: "#4296f5",
            jumpBorder: "1px solid #ddd",
            jumpHoverBorder: "",
            simpleType: 1,

            //ajax
            submitStyle: "ajax",
            ajaxSubmitType: "post",
            url: url,
            ajaxData: data,
            idParameter: "pn",
            ajaxDataType: "json",
            firstAjaxSubmit: first,
            beforeAjaxSubmit: function () {       //发送请求前的操作,预处理函数，可在此根据要求动态更新请求参数
                PageAPI.AddAjaxData({pageno:PageAPI.GetCurrentPage, size: $("#pageInfo").attr('size') });  //每次请求都获取一次请求参数   使用API统一使用PageAPI对象调用

            },
            ajaxSubmitBack: function(data){callback(data)}
        });
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
