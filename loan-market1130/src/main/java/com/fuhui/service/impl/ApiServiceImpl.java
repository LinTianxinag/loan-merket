package com.fuhui.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fuhui.mybatis.generator.dao.PlatformMapper;
import com.fuhui.mybatis.generator.dao.Platform_RecordMapper;
import com.fuhui.mybatis.generator.model.Platform;
import com.fuhui.mybatis.generator.model.Platform_Record;
import com.fuhui.service.ApiService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @author : xufanglong
 * @Description:
 * @Date: create in 14:51 2017/12/11
 * @Modified By:
 */
@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private Platform_RecordMapper platformRecordMapper;
    @Autowired
    private PlatformMapper platformMapper;

    @Override
    public JSONObject getHomeDisplays(HttpServletRequest request, HttpServletResponse response) {
        JSONObject object=new JSONObject();
        object.put("status",200);
        object.put("msg","请求成功");
        //计数
        int count=platformRecordMapper.getCountInHomedisPlay();
        if(count > 0){
            //给结果集
            List<Platform_Record> list=platformRecordMapper.getHomedisplays();
            object.put("count",count);
            object.put("list",list);
        }else{
            //给结果集
            object.put("count",0);
            object.put("list",null);
        }
        return object;
    }

    /**
     * 获取现金贷的列表的信息,并作分页查询展示
     * @param request
     * @param response
     * @return
     */
    @Override
    public JSONObject getLoanList(HttpServletRequest request, HttpServletResponse response) {
        JSONObject obj=new JSONObject();
        int pageno=Integer.parseInt(request.getParameter("pageno")) ;
        int pagesize=Integer.parseInt(request.getParameter("pagesize"));
        obj.put("status",200);
        obj.put("msg","请求成功");
        //统计符合条件的所有的现金贷平台
        int count=platformRecordMapper.getCountOfLoanList();
        if(count>0){
            PageHelper.startPage(pageno, pagesize);
            List<HashMap> list = platformRecordMapper.getOnshevlesLoan();
            PageInfo page = new PageInfo(list);
            obj.put("count",count);
            obj.put("list",page.getList());
        }else{
            obj.put("count",0);
            obj.put("list",null);
        }
        return obj;
    }

    /**
     * 获取现金贷的详情的信息
     * @param request
     * @param response
     * @return
     */
    @Override
    public JSONObject getLoanDetail(HttpServletRequest request, HttpServletResponse response) {
        JSONObject object=new JSONObject();
        String platId=request.getParameter("plat_id");
        Platform platform=platformMapper.selectByPrimaryKey(Integer.parseInt(platId));
        if(null == platform || "".equals(platform)){
            object.put("status",100);
            object.put("msg","暂无详情");
        }else{
            object.put("status",200);
            object.put("msg","成功");
            object.put("platform",platform);
        }
        return object;
    }
}
