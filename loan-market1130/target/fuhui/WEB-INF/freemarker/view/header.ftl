<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>贷款超市－数据中心</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">

    <link rel="stylesheet" type="text/css" href="../css/reset.min.css">
    <link rel="stylesheet" type="text/css" href="../css/ucenter.css">
    <link rel="stylesheet" type="text/css" href="../css/respond.css">
    <link rel="stylesheet" media="all" type="text/css" href="../css/jquery-ui-1.10.4.custom.min.css" />
    <link rel="stylesheet" media="all" type="text/css" href="../css/jquery-ui-timepicker-addon.css" />
    <link rel="stylesheet" href="../css/layer.css" id="layui_layer_skinlayercss" style="">
    <link href="../css/toastr.min.css" rel="stylesheet" type="text/css" />
    <#--<link rel="stylesheet" media="all" type="text/css" href="../css/plat.css" />-->
    <link type="text/css" rel="stylesheet" href="../css/jedate.css">

    <script type="text/javascript" src="../js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="../js/commonPager.js"></script>


</head>
<body>

<header class="clearfix">
    <h3 href="#" class="centerLogo" target="_blank" style="position:relative;"><img style="position:relative; left:-5px;"  alt="贷款超市管理平台"></h3>

    <ul class="headerUl clearfix">
        <li class="headerLi1">
            <div class="headerInfo"><span id="user">${mobile}</span><i class="headerIcon1 centerIcon"></i></div>
            <a class="centerLogout" href="javascript:logout();">退出登录</a>
        </li>
        <li>
            <a class="headerContact" href="#" target="_blank">+ +</a>
        </li>
    </ul>

    <script type="text/javascript">
        <#--var user = ${adminmobile}-->
        <#--if(user != null){-->
            <#--$("#user").html(parseInt(user));-->
        <#--}else{-->
            <#--$("#user").html("--");-->
        <#--}-->


    </script>

</header>