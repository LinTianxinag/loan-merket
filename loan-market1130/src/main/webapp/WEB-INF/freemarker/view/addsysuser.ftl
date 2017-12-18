<#include "./header.ftl">
<body>
<!-- main start -->
<div id="ucenterWrapper" class="ucenterWidth1 clearfix">
<#include "./menu.ftl">
    <!-- main content start -->
    <body>
    <form id="formid" method="post"  action = "/addSysUserDate">
        <div id="jiekubox">
            <div class="jiekutop" style="margin-left: 30%;">
                <h2>平台用户</h2>
                <div class="jiekutop_cont" style="margin-top: 10%">
                    <div class="jiekutopCont1" style="height: 50px" >
                        <div class="jiekutopCont1_left" style="font-size: 20px" >登录名字</div>
                        <div class="jiekutopCont1_right">
                            <input type="text"  placeholder="" name="loginName" id="login_name" style="height: 100%;width: 70%"/>
                            <span class="login_name_err" style="font-size: 20px;color: red"></span>
                        </div>
                    </div>
                    <div class="jiekutopCont1" style="height: 50px">
                        <div class="jiekutopCont1_left" style="font-size: 20px" >真实名字</div>
                        <div class="jiekutopCont1_right">
                            <input type="text"  placeholder="" name="realName" id="real_name" style="height: 100%;width: 70%"/>
                            <span class="real_name_err" style="font-size: 20px;color: red"></span>
                        </div>
                    </div>
                    <div class="jiekutopCont1" style="height: 50px">
                        <div class="jiekutopCont1_left" style="font-size: 20px" >密码</div>
                        <div class="jiekutopCont1_right">
                            <input type="text"  placeholder="" name="userPwd" id="pwd" style="height: 100%;width: 70%"/>
                            <span class="pwd_err" style="font-size: 20px;color: red"></span>
                        </div>
                    </div style="height: 50px">
                    <div class="jiekutopCont1" style="height: 50px">
                        <div class="jiekutopCont1_left" style="font-size: 20px" >手机号</div>
                        <div class="jiekutopCont1_right">
                            <input type="text"  placeholder="" name="mobile" id="mobile" style="height: 100%;width: 70%"/>
                            <span class="mobile_err" style="font-size: 20px;color: red"></span>
                        </div>
                    </div>
                    <div class="jiekutopCont1" style="height: 50px">
                        <div class="jiekutopCont1_left" style="font-size: 20px">岗位</div>
                        <div class="jiekutopCont1_right">
                            <input type="text"  placeholder="" name="job" id="job" style="height: 100%;width: 70%"/>
                            <span class="job_err" style="font-size: 20px;color: red"></span>
                        </div>
                    </div>
                    <#--<div class="jiekutopCont1" style="width: 120px;height: 200px">-->
                        <#--<div class="jiekutopCont1_left" style="font-size: 20px">管理员</div>-->
                        <#--<div class="jiekutopCont1_right" >-->
                            <#--<input type="text"  placeholder="" name="job" id="job" style="height: 100%;width: 70%"/>-->

                            <#--<select name="roleId" id="fundtimetype">-->
                                <#--<option value="1" >是</option>-->
                                <#--<option value="0" selected >否</option>-->
                            <#--</select>-->
                        <#--</div>-->
                    <#--</div>-->
                    <div class="jiekutopCont1" style="height: 50px">
                        <div class="jiekutopCont1_left" style="font-size: 20px">管理员</div>
                        <div class="jiekutopCont1_right">
                            <label for="thr1">
                                <input type="radio" name="roleId" id="roleIds" value="0" checked />
                                否
                            </label>
                            <label for="thr2">
                                <input type="radio" name="roleId" value="1" id="thr2"/>
                                是
                            </label>
                        </div>
                    </div>

                </div>
            </div>

            <div class="jiekudown6" style="margin-left: 30%">
                <input type="button"  class="jiekubtn" id="addSysUser" value="提交"/>
            </div>
        </div>
    </form>
    </body>
    <!-- main content end -->
</div>



<script type="text/javascript">
    $(function(){
        $('#platname').on('blur',function () {
            var platname=$('#platname').val();
            if(platname==""){
                $('.reserr').text("不能为空");
            }else{
                $('.reserr').text("");
                $.ajax({
                    url:'/plat/namecheck',
                    type:'get',
                    dataType:'json',
                    data:{platname:platname},
                    success:function(data){
                        if(data.status==100){
                            $('.reserr').text("都说了不要重复");
                        }else{
                            $('.reserr').text("");
                        }
                    }
                })
            }
        })
        $('#login_name').on('blur',function () {
            var login_name=$('#login_name').val();
            if(login_name==""){
                $('.login_name_err').text("不能为空");
            }else{
                $('.login_name_err').text("");
            }
        })
        $('#real_name').on('blur',function () {
            var real_name=$('#real_name').val();
            if(real_name==""){
                $('.real_name_err').text("不能为空");
            }else{
                $('.real_name_err').text("");
            }
        })
        $('#pwd').on('blur',function () {
            var pwd=$('#pwd').val();
            if(pwd==""){
                $('.pwd_err').text("不能为空");
            }else{
                $('.pwd_err').text("");
            }
        })
        $('#mobile').on('blur',function () {
            var mobile=$('#mobile').val();
            if(mobile==""){
                $('.mobile_err').text("不能为空");
            }else{
                $('.mobile_err').text("");
            }
        })
        $('#job').on('blur',function () {
            var job=$('#job').val();
            if(job==""){
                $('.job_err').text("不能为空");
            }else{
                $('.job_err').text("");
            }
        })
    })
    $(document).ready(function () {
    <#if status==0>
        alert("添加失败");
    </#if>
    });

    $('#addSysUser').click(function () {
        var login_name=$('#login_name').val();
        var real_name=$('#real_name').val();
        var pwd=$('#pwd').val();
        var mobile=$('#mobile').val();
        var job=$('#job').val();
        if(job==""||real_name==""||pwd==""||mobile==""||login_name==""){
            alert("数据不能为空");
            return;
        }
        if(!(/^\d*$/).test(pwd)){
            alert("密码只能为数字");
            return;
        }
        if(!(/^1[3|4|5|7|8][0-9]\d{8}$/).test(mobile)){
            alert("手机格式错误");
            return;
        }
        $('#formid').submit();

    });

</script>

<style type="text/css">.layui-layer-tips .layui-layer-content{color: #666}</style>
<#include "./bottom.ftl">
</body>
