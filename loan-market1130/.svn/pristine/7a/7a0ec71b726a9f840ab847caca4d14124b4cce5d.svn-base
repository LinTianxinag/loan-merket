
package com.fuhui.common.eunm;


public enum RequestGateWayStatus implements EnumMessage {
	success(0, "查询成功"), failure(1, "系统错误"), sendSuccess(0, "下发成功"), // 下发成功
	/************* 信息比对类 *****************/
	matchSuccess(0, "对比一致"), // 不对一致
	matchIncorrect(400011, "比对不一致"), // 存在该身份证号码，但是姓名不同
	matchNotfind(400012, "无此记录"), // 无此记录
	/*************** 信息错误类 **********************/
	dataDelayed(400000, "请求成功"), // 数据延时回调
	appidError(400001, "帐户appid错误，连续10次错误封端口"), // 帐户appid错误
	serviceNotfind(400002, "没有开通，功能受限"), // 没有开通，功能受限
	accountBalanceInsufficient(400003, "帐户余额不足"), // 帐户余额不足
	findDataMismatching(400004, "查询数据不匹配"), // 查询数据不匹配
	templateNotCheckPass(400005, "模板审核未通过"), // 模板审核未通过
	accountIsLogout(400006, "用户账号已注销"), // 用户账号已注销
	requestIpNotWhiteList(400007, "请求ip未在白名单"), // 请求ip未在白名单
	requestParameterError(400008, "请求参数错误"), // 请求参数错误
	surpassMaximumRow(400009, "超过限定时间最大条数"), // 超过限定时间最大条数
	systemCloseFindPort(400010, "系统关闭查询接口"), // 系统关闭查询接口
	servciceTimeOut(400013, "服务商超时"), // 服务商超时
	noDataWithCost(400014, "查无数据, 计费"), // 查无数据, 计费
	signatureError(400015, "签名错误"), // 签名错误
	noDataButCost(400016, "查无数据,不计费"), // 查无数据，不计费
	notFind(400020, "未查得"), // 未查得
	findInstructError(400030, "查询指令错误"), Reject(300002, "请求驳回"); // 查询指令错误

	private final Integer _code;
	private final String _message;

	RequestGateWayStatus(Integer code, String message) {
		_code = code;
		_message = message;
	}

	@Override
	public Integer getValue()
	{
		return _code;
	}

	@Override
	public String getMessage()
	{
		return _message;
	}

	public String getJsonMessage() {
		return "{\"result_code\":" + _code + ",\"result\":{\"message\":\"" + _message + "\"}}";
	}

	public static String getMessage(Integer code) {
		for (RequestGateWayStatus status : RequestGateWayStatus.values()) {
			if (status.getValue().equals(code)) {
				return status.getMessage();
			}
		}
		return code + "";
	}

}
