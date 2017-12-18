
<script type="text/javascript" src="../js/jquery-ui-1.10.4.custom.min.js"></script>
<script type="text/javascript" src="../js/jquery-ui-timepicker-addon.js"></script>
<script type="text/javascript" src="../js/jquery-ui-timepicker-zh-CN.js"></script>
<script type="text/javascript" src="../js/jquery.jedate.js"></script>
<script type="text/javascript" src="../js/fileupload-img.js"></script>
<script type="text/javascript" src="../js/jquery.fileupload.js"></script>
<script src="../js/jquery.form.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="../js/toastr.min.js"></script>
<script src="../js/layer.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/json.parse.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/nslog.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="../js/Date.js"></script>
<script src="../js/ucenterPublic.js" type="text/javascript" charset="utf-8"></script>


<script type="text/javascript">
    // 退出登录
    function logout(){
        $.post("/logout",function(dta){
            if(dta){
                var result = JSON.parse(dta);
                if(result.status == 200){
                    window.location.href = "/index";
                }
            }
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
    function isMobile(mobile){
        var mreg =/^1[3|5|8|4|7]{1}[0-9]{1}[0-9]{8}$/;
        if(!mreg.test(mobile)){
            return false;
        }
        return true;
    }

</script>

