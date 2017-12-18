<#include "./header.ftl">
<!-- main start -->
<div id="ucenterWrapper" class="ucenterWidth1 clearfix">
<#include "./menu.ftl">
    <body>
    <form id="formid" method="post"  name="formid" action = "/plat/add">
        <div id="jiekubox">
            <div class="jiekutop">
                <h2>借款参数</h2>
                <div class="jiekutop_cont">
                    <div class="jiekutopCont1">
                        <div class="jiekutopCont1_left" >平台名称</div>
                        <div class="jiekutopCont1_right">
                            <input type="text"  placeholder="平台名称不可重复" name="platname" id="platname" value="${platform.name}"/>
                            <span class="reserr"></span>
                        </div>
                    </div>
                    <div class="jiekutopCont1">
                        <div class="jiekutopCont1_left">参考利率</div>
                        <div class="jiekutopCont1_right">
                            <select name="rateType" id="">
                            <#if platform.referenceDay== 1>
                                <option value="1">日参考利率</option>
                             <#elseif platform.referenceDay== 2>
                                <option value="2" >月参考利率</option>
                            </#if>
                            </select>
                            <input type="text"  name="rate" id="rate" value="${platform.referenceInterestRate}"/> %
                            <span class="rateerr" style="font-size: 14px;color: red" ></span>
                        </div>
                    </div>
                    <div class="jiekutopCont1">
                        <div class="jiekutopCont1_left">借款金额区间</div>
                        <div class="jiekutopCont1_right">
                            <input type="text"  name="loanlow" id="loanlow" value="${platform.loanMoneyLow}"/>
                            <span>--</span>
                            <input type="text"  name="loanhigh" id="loanhigh" value="${platform.loanMoneyHigh}"/>
                            <span>元</span>
                        </div>
                    </div>
                    <div class="jiekutopCont1">
                        <div class="jiekutopCont1_left">借款周期区间</div>
                        <div class="jiekutopCont1_right">
                            <input type="text" name="loantimelow" value="${platform.loanCycleLow}"/>
                            <span>--</span>
                            <input type="text" name="loantimehigh" value="${platform.loanCycleHigh}"/>
                            <span>天</span>
                        </div>
                    </div>
                    <div class="jiekutopCont1">
                        <div class="jiekutopCont1_left">最快放款时间</div>
                        <div class="jiekutopCont1_right">
                            <select name="fundtimetype" id="fundtimetype">
                            <#if platform.fastLoan== 1>
                                <option value="1">按小时</option>
                            <#elseif platform.fastLoan== 2>
                                <option value="2">按分钟</option>
                            <#elseif platform.fastLoan== 3>
                                <option value="3">按秒</option>
                            </#if>
                            </select>
                            <input type="text"  name="fundtime" value="${platform.fastLoanTime}"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="jiekumiddle">
                <h2>所需材料</h2>
                <div class="jiekumiddle_one">
                    <label for="idcard">
                    <#if platform.idcard== 1>
                        <input type="checkbox" id="idcard" name="idcard"  checked/>
                        身份证
                    <#elseif platform.idcard== 0>
                        <input type="checkbox" id="idcard" name="idcard" />
                        身份证
                    </#if>
                    </label>
                    <label for="shouquan">
                    <#if platform.carrierWarrant== 1>
                        <input type="checkbox" id="shouquan" name="shouquan" checked/>
                        运营商授权
                    <#elseif platform.carrierWarrant== 0>
                        <input type="checkbox" id="shouquan" name="shouquan" />
                        运营商授权
                    </#if>
                    </label>
                    <label for="bankcard">
                    <#if platform.bankCard== 1>
                        <input type="checkbox" id="bankcard" name="bankcard" checked/>
                        银行卡
                    <#elseif platform.bankCard== 0>
                        <input type="checkbox" id="bankcard" name="bankcard"/>
                        银行卡
                    </#if>
                    </label>
                    <label for="xinyong">
                    <#if platform.zhima== 1>
                        <input type="checkbox" id="xinyong" name="xinyong" checked/>
                        芝麻信用
                    <#elseif platform.zhima== 0>
                        <input type="checkbox" id="xinyong" name="xinyong" />
                        芝麻信用
                    </#if>
                    </label>
                    <label for="xuexin">
                    <#if platform.xuexinwang== 1>
                        <input type="checkbox" id="xuexin" name="xuexin"checked/>
                        学信网授权
                    <#elseif platform.xuexinwang== 0>
                        <input type="checkbox" id="xuexin" name="xuexin"/>
                        学信网授权
                    </#if>
                    </label>
                    <label for="taobao">
                    <#if platform.taobao== 1>
                        <input type="checkbox" id="taobao" name="taobao" checked/>
                        淘宝授权
                    <#elseif platform.taobao== 0>
                        <input type="checkbox" id="taobao" name="taobao" />
                        淘宝授权
                    </#if>
                    </label>
                    <label for="bankcard">
                    <#if platform.zhifubao== 1>
                        <input type="checkbox" id="alipay" name="alipay" checked/>
                        支付宝授权
                    <#elseif platform.zhifubao== 0>
                        <input type="checkbox" id="alipay" name="alipay"/>
                        支付宝授权
                    </#if>
                    </label>
                    <label for="qq">
                    <#if platform.qq== 1>
                        <input type="checkbox" id="qq" name="qq" checked/>
                        QQ授权
                    <#elseif platform.qq== 0>
                        <input type="checkbox" id="qq" name="qq"/>
                        QQ授权
                    </#if>
                    </label>

                </div>
                <div class="jiekumiddle_two">
                    <div class="jiekumiddle_oneleft">申请条件</div>
                    <div class="jiekumiddle_oneright">
                        <textarea name="applycondition" id="" style="width:578px;height:140px;border:1px solid #333;text-align:left;">${platform.applyconditions}</textarea>
                    </div>
                </div>
            </div>
            <div class="jiekudown">

                <h2>图片上传</h2>
                <label class="pull-left"><span class="fc-ff0000"></span></label>

                            <div class="pull-left up-con">
                                <!-- 鼠标交互预览图 -->
                                <div class="btn-wrap pull-left">
                                    <img src="../pic/${platform.imageUrl}" class="class-img" style="width: 300px; height: 200px; border: 1px solid #000;overflow: hidden;">
                                </div>
                            </div>


                <h2>前台展示</h2>
                <div class="jiekudown_wrap">
                    <div class="jiekudown1">
                        <div class="jiekud1_left">首页展示</div>
                        <div class="jiekud1_right">
                        <#if platform.homepage== 1>
                            <label for="yes">
                                <input type="radio" name="itemone" id="yes" checked/>
                                是
                            </label>
                            <label for="no">
                                <input type="radio" name="itemone" id="no" />
                                否
                            </label>
                        <#elseif platform.homepage== 0>
                            <label for="yes">
                                <input type="radio" name="itemone" id="yes" />
                                是
                            </label>
                            <label for="no">
                                <input type="radio" name="itemone" id="no" checked/>
                                否
                            </label>
                        </#if>


                        </div>
                    </div>
                    <div class="jiekudown2">
                        <div class="jiekud2_left">列表展示</div>
                        <div class="jiekud2_right">
                            <select name="chooseposition" id="jieku_select">
                            </select>
                        </div>
                    </div>
                    <div class="jiekudown3">
                        <div class="jiekud3_left">上架状态</div>
                        <div class="jiekud3_right">
                        <#if platform.onshelves== 1>
                            <label for="yestwo">
                                <input type="radio" name="itemtwo" id="yestwo" value="0"  />
                                已下架
                            </label>
                            <label for="notwo">
                                <input type="radio" name="itemtwo" value="1" id="notwo" checked/>
                                已上架
                            </label>
                        <#elseif platform.onshelves== 0>
                            <label for="yestwo">
                                <input type="radio" name="itemtwo" id="yestwo" value="0"  checked/>
                                已下架
                            </label>
                            <label for="notwo">
                                <input type="radio" name="itemtwo" value="1" id="notwo" />
                                已上架
                            </label>
                        </#if>
                        </div>
                    </div>
                    <div class="jiekudown4">
                        <div class="jiekud4_left">标签显示</div>
                        <div class="jiekud4_right">
                        <#if platform.labelshow== 1>
                            <label for="thr1">
                                <input type="radio" name="itemthr" id="thr1" value="1" checked />
                                新品
                            </label>
                            <label for="thr2">
                                <input type="radio" name="itemthr" value="2" id="thr2"/>
                                推荐
                            </label>
                            <label for="thr3">
                                <input type="radio" name="itemthr" value="3" id="thr3"/>
                                火热
                            </label>
                        <#elseif platform.labelshow==2>
                            <label for="thr1">
                                <input type="radio" name="itemthr" id="thr1" value="1"  />
                                新品
                            </label>
                            <label for="thr2">
                                <input type="radio" name="itemthr" value="2" id="thr2" checked/>
                                推荐
                            </label>
                            <label for="thr3">
                                <input type="radio" name="itemthr" value="3" id="thr3"/>
                                火热
                            </label>
                        <#elseif platform.labelshow== 3>
                            <label for="thr1">
                                <input type="radio" name="itemthr" id="thr1" value="1"  />
                                新品
                            </label>
                            <label for="thr2">
                                <input type="radio" name="itemthr" value="2" id="thr2"/>
                                推荐
                            </label>
                            <label for="thr3">
                                <input type="radio" name="itemthr" value="3" id="thr3" checked/>
                                火热
                            </label>
                        </#if>



                        </div>
                    </div>
                    <div class="jiekudown5">
                        <div class="jiekud5_left">跳转连接</div>
                        <div class="jiekud5_right">
                            <textarea name="jumpurl" id="" style="width:578px;height:48px;border:1px solid #333;text-align:left;">${platform.jumpurl}</textarea>
                        </div>
                    </div>
                    <div class="jiekudown6">
                    </div>
                </div>
            </div>
        </div>
    </form>
    </body>
    <!-- main content end -->
</div>

<script type="text/javascript">
    // 退出登录
    function logout(){
        $.getJSON('/login/logout',function(obj){
            window.location.href='/';
        })
    }

    $("#fileuploadSC").click(function () {
        upload(this,barIdCardTake);
    })

    $(document).ready(function(){
        $.post("/plat/getplatlist",function(data){
            var parent_length = $('#jieku_select').children().length;
            var resnum = Number(parent_length)+Number(data.count);
            if(resnum==0){
                resnum=1;
                var htm = "<option >请选择</option>";
                for(var i=0;i<resnum;i++){
                    htm += '<option value="'+(i+1)+'">'+(i+1)+'</option>';
                };
            }else{
                var htm = "<option >请选择</option>";
                for(var i=0;i<resnum;i++){
                    htm += '<option value="'+(i+1)+'">'+(i+1)+'</option>';
                };
            }

            console.log(htm)
            $('#jieku_select').html(htm)
        });
    });
</script>

<style type="text/css">.layui-layer-tips .layui-layer-content{color: #666}</style>
<#include "./bottom.ftl">
</body>
