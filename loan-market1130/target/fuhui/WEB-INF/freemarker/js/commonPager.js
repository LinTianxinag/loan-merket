/**
 * Created by Administrator on 2017/12/15.
 */
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
            PageAPI.AddAjaxData({pageno:PageAPI.GetCurrentPage});  //每次请求都获取一次请求参数   使用API统一使用PageAPI对象调用
        },
        ajaxSubmitBack: function(data){callback(data)},

    });
}