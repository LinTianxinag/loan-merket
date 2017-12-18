var filePath = null;
/**
 * jquery-fileupload 自定义插件
 * 		上传图片==>允许上传单张，并且是2MB以内的图片，支持格式以h5 input标准
 * 		上传图片路径==>input data-url为准
 * @param uploadId	当前点击的input file
 * @param barId		进度条id
 */
function upload(uploadId,barId) {
	var uploadErrors = [];//储存错误信息data.files[0].name
	$(uploadId).fileupload({
		dataType: 'json',
		url:'/pic/uploadit',
		/* 添加上传文件之后做一些验证 */
		add: function (e, data) {
			/* 限制上传文件数量 */
			if(data.originalFiles.length != null && data.originalFiles.length > 1) {
				uploadErrors.push('请选择一张图片上传');
				/* 限制上传文件大小 */
			} else if(data.originalFiles[0].size > (2*1024*1024)) {
				uploadErrors.push('请上传2M以内的jpg、png、jpeg格式照片');
			}
			if(uploadErrors.length > 0) {
				toastr.error(uploadErrors.join("\n"));
				return false;
			} else {
				/* 获取图片本地路径并显示*/
				getImgPath(this);
				$(this).prev().prev().html("重新上传");
				$(this).parents(".up-con").find(".progress").show();
				$(this).parents(".up-con").find(".wj-name").removeClass("up-cg");
				/* 显示上传图片名称 */
				splitImgType(this,data.files[0].name);
				data.submit();
			}
		},
		/* 上传结束后回调 */
		done: function (e, data) {
			console.log(data.result.image);
			$(this).next().val(data.result.image);
			// $(barId).css('width', 100 + '%');
			/* 上传完成隐藏进度条*/
			// $(this).parents(".up-con").find(".progress").hide();
			// $(this).parents(".up-con").find(".wj-name").addClass("up-cg");
		},
		progressall: function (e, data) {
			var progress = parseInt(data.loaded / data.total * 100, 10);
			$(barId).css('width', progress + '%');
		},
		/* 上传失败错误提示 */
		processfail: function (e, data) {
			data.files.forEach(function(file) {
				if (file.error) {
					toastr.error(file.error);
					return false;
				}
			});
		},
	});
}
//文件上传前触发事件
// $('#picture').bind('fileuploadsubmit', function (e, data) {
// 	data.formData = { UserID: $("#userID").val() };  //如果需要额外添加参数可以在这里添加
// });


$("#fileuploadSC").change(function(){
	filePath = document.getElementById("fileuploadSC").files[0];
});

/**
 * 传入的参数创建一个指向该参数对象的URL
 * 对象URL指向执行的File对象或者是Blob对象
 */
function getImgPath(e)
{
	$(e).prev().fadeIn("fast").attr('src',URL.createObjectURL(filePath));
};



/**
 *	截取图片名称
 *		示例:123456...".jpg" 以.类型结尾，隐藏.之前多于的部分为"..."
 * @param imgName
 */
function splitImgType(event,imgName)
{
	var arr = imgName.split(".");
	// $(this).parent().next().find(".wj-name").html();
	$(event).parents(".up-con").find(".pj-name .mz").text(arr[0]);
	$(event).parents(".up-con").find(".pj-name .lx").text("."+arr[1]);
    $(event).parents(".up-con").find(".pj-name .imageurl").val(arr[0]+"."+arr[1]);

	$(event).parents(".up-con").find(".gs-dx").hide();

}