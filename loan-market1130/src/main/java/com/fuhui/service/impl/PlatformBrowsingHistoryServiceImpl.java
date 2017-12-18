package com.fuhui.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fuhui.common.config.Constants;
import com.fuhui.common.util.RedisUtil;
import com.fuhui.mybatis.generator.dao.FhUserMapper;
import com.fuhui.mybatis.generator.dao.PlatformBrowsingHistoryMapper;
import com.fuhui.mybatis.generator.dao.Platform_RecordMapper;
import com.fuhui.mybatis.generator.model.FhUser;
import com.fuhui.mybatis.generator.model.PlatformBrowsingHistory;
import com.fuhui.mybatis.generator.model.Platform_Record;
import com.fuhui.service.PlatformBrowsingHistoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author : xufanglong
 * @Description:浏览历史的实现类
 * @Date: create in 11:40 2017/12/12
 * @Modified By:
 */
@Service
public class PlatformBrowsingHistoryServiceImpl implements PlatformBrowsingHistoryService {

    @Autowired
    private PlatformBrowsingHistoryMapper platformBrowsingHistoryMapper;

    @Autowired
    private Platform_RecordMapper platformRecordMapper;

    @Autowired
    private FhUserMapper fhUserMapper;

    /**
     *增加用户的浏览的历史,及平台的浏览次数
     * @param request
     * @param response
     * @return
     */
    @Override
    @Transactional
    public JSONObject addBrowseTimes(HttpServletRequest request, HttpServletResponse response) {
        JSONObject object=new JSONObject();

        String money=request.getParameter("money");
        String day=request.getParameter("day");
        String platid=request.getParameter("plat_id");

        try{
            String userid = RedisUtil.get(Constants.APP_SESSION + request.getSession().getId());
            Platform_Record platform_record=platformRecordMapper.getPlatFromByPlatId(Integer.parseInt(platid));

            int count=platformBrowsingHistoryMapper.getCountInUserAndPlatid(Integer.parseInt(platid),Integer.parseInt(userid));
            //单用户第一次访问，平台访问计数加一
            if(count==0){
                platform_record.setVisitorsNum(platform_record.getVisitorsNum()+1);
                platformRecordMapper.updateByPrimaryKeySelective(platform_record);
            }
            //浏览历史
            PlatformBrowsingHistory platformBrowsingHistory=new PlatformBrowsingHistory();
            platformBrowsingHistory.setPlaid(Integer.parseInt(platid));
            platformBrowsingHistory.setPlaname(platform_record.getPlatName());
            platformBrowsingHistory.setDesireDay(day);
            platformBrowsingHistory.setDesireMoney(money);
            platformBrowsingHistory.setBrowsingTime(new Date());
            platformBrowsingHistoryMapper.insert(platformBrowsingHistory);

            //用户个人浏览记录
            FhUser fhUser=fhUserMapper.selectByPrimaryKey(Integer.parseInt(userid));
            fhUser.setView_count(fhUser.getView_count()+1);
            fhUserMapper.updateByPrimaryKeySelective(fhUser);

        }catch(Exception e){
            e.printStackTrace();
            object.put("status",100);
            object.put("msg","系统异常");
        }
        object.put("status",200);
        object.put("msg","成功");
        return object;
    }

    /**
     * 获取用户的浏览的历史
     * @param request
     * @param response
     * @return
     */
    @Override
    public JSONObject getUserBrowseHis(HttpServletRequest request, HttpServletResponse response) {
        JSONObject object=new JSONObject();
        String userid = RedisUtil.get(Constants.APP_SESSION + request.getSession().getId());
        int pageno=Integer.parseInt(request.getParameter("pageno"));
        int pagesize=Integer.parseInt(request.getParameter("pagesize"));
        int count=platformBrowsingHistoryMapper.getCountInUser(Integer.parseInt(userid));

        if(count==0){
            object.put("status",100);
            object.put("msg","用户暂无浏览记录");
            object.put("count",count);
            object.put("list",null);
        }else{
            PageHelper.startPage(pageno, pagesize);
            List<PlatformBrowsingHistory> list=platformBrowsingHistoryMapper.getInfoByUserid(Integer.parseInt(userid));
            PageInfo page = new PageInfo(list);
            object.put("status",200);
            object.put("msg","获取成功");
            object.put("count",count);
            object.put("list",page.getList());
        }
        return object;
    }
}
