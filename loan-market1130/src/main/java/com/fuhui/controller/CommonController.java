package com.fuhui.controller;

import com.alibaba.fastjson.JSONObject;
import com.fuhui.annoation.ApiCheck;

import com.fuhui.common.config.Resources;
import com.fuhui.common.util.RedisUtil;
import com.fuhui.common.util.WebUtil;
import com.fuhui.mybatis.dto.SendSmsDto;
import com.fuhui.service.SmsService;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RequestWrapper;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : xufanglong
 * @Description:api接口和后台管理通用的写在此处
 * @Date: create in 16:27 2017/11/30
 * @Modified By:
 */
@RestController
public class CommonController {
    private Producer captchaProducer = null;

    @Autowired
    public void setCaptchaProducer(Producer captchaProducer) {
        this.captchaProducer = captchaProducer;
    }

    @Autowired
    private SmsService smsService;


    /**
     * 发送短信的功能
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/sendSms")
    public String SendSms(HttpServletRequest request, HttpServletResponse response){
        return  smsService.SmsCheck(request,response);
    }


    /**
     * 验证码缓存2分钟
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/captcha")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = captchaProducer.createText();
        // store the text in the session
        RedisUtil.set(request.getSession().getId() + com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY,120,capText);
        System.out.println("key===>"+request.getSession().getId()+ com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY+",value====>"+capText);
        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        // write the data out

        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }


    /**
     * 后台管理的图片的上传
     * @param request
     * @param response
     * uploadaddress:图片的存储
     * @return
     */
    @PostMapping("/pic/uploadit")
    public void uploadImage(@RequestParam("file") MultipartFile file,HttpServletRequest request){
        String filename = file.getOriginalFilename();
        String uploadaddress= Resources.CONFIG.getString("image_storage");
        try{
            System.out.println(filename);
            //写入本地磁盘
            InputStream is = file.getInputStream();
            byte[] bs = new byte[1024];
            int len;
            OutputStream os = new FileOutputStream(new File(uploadaddress + filename));
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            os.close();
            is.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
