package ysw.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/7/3 12:01
 * @Version
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * @return java.lang.String
     * @Param [req, upload]
     * @Date 9:03 2020/7/4
     * @Description: //TODO
     **/
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest req, MultipartFile upload) throws IOException {
        System.out.println("文件上传！！");
        String path = req.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()) {
            //创建文件夹
            file.mkdirs();
        }
        //获取文件名称
        String filename = upload.getOriginalFilename();
        //将文件名称设置为唯一值
        String replace = UUID.randomUUID().toString().replace("-", "");
        filename = replace + "_" + filename;
        //完成文件上传
        upload.transferTo(new File(path, filename));
        return "success";
    }

    @RequestMapping("/fileupload2")
    public String fileupload2(MultipartFile upload) throws IOException {
        System.out.println("文件上传！！");
        //定义上传文件服务路径
        String path = "http://localhost:xxxx/xxxx/";
        //获取文件名称
        String filename = upload.getOriginalFilename();
        //将文件名称设置为唯一值
        String replace = UUID.randomUUID().toString().replace("-", "");
        filename = replace + "_" + filename;
        //创建客户端对象
        Client client = Client.create();
        //和文件服务器进行连接
        WebResource resource = client.resource(path + filename);
        //上传文件
        resource.put(upload.getBytes());
        return "success";
    }
}
