package com.min.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Iterator;

/**
 * @program: SSM
 * @description:
 * @author: mcy
 * @create: 2018-06-24 13:57
 **/
@Controller
public class TTController {
    @RequestMapping("/test.do")
    @ResponseBody
    public Object test(){
        return "123";
    }

    /**
     * 文件上传
     * @param
     * @param
     * @return
     */
    @RequestMapping(value="/upload.do",method= RequestMethod.POST)
    @ResponseBody
    public Object upload(HttpServletRequest request,  @RequestParam("file1") MultipartFile file)throws Exception{
        if(!file.isEmpty()) {

            //上传文件路径
            //String path = request.getServletContext().getRealPath("E:/");
            String path = "E:/";
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            System.out.println(filepath);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return "success";
        } else {
            return "error";
        }

    }



    /**
     * 多文件上传
     * @param
     * @param
     * @return
     */

    @Autowired
    CommonsMultipartResolver multipartResolver;
    @RequestMapping(value="/moreUpload.do",method= RequestMethod.POST)
    @ResponseBody
    public Object moreUpload(HttpServletRequest request,HttpServletResponse response)throws Exception{
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                //记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if(file != null){
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if(myFileName.trim() !=""){
                        System.out.println(myFileName);
                        //重命名上传后的文件名
                        String fileName = "demoUpload" + file.getOriginalFilename();
                        //定义上传路径
                        String path = "E:/" + fileName;
//                        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload") + fileName;
                        File localFile = new File(path);
                        try {
                            file.transferTo(localFile);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            }
            return "success";
        }else {
            return "error";
        }

    }


    /**
     * 下载资源
     * @param fileName
     * @param response
     * @throws Exception
     */
    @RequestMapping("/getSource")
    public void getSourceMessages(String fileName,HttpServletResponse response) throws Exception {
        File file = new File("E://",fileName);
        response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(file.getName(),"UTF-8"));
        response.addHeader("Content-Length", file.length()+"");
        response.setContentType("application/force-download");//application/x-msdownload
        InputStream fis = new BufferedInputStream(new FileInputStream(file));
        OutputStream out = new BufferedOutputStream(response.getOutputStream());
        byte[] buff = new byte[1024];
        int read;
        while((read = fis.read(buff))!=-1){
            out.write(buff, 0, read);
        }
        out.flush();
        fis.close();
        out.close();
    }

}
