package com.it.luo.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

    /**
     * 传统方式 自己做请求的解析
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传执行...");

        // 用fileuploads组件完成上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads");

        //判断文件路径是否存在
        File file = new File(path);
        if( !file.exists() ){
            //创建文件夹
            file.mkdirs();
        }
        //解析request对象，获取上传的文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        //解析request
        List<FileItem> fileItems = upload.parseRequest(request);
        //遍历文件项
        for( FileItem item : fileItems){
            //判断，当前item对象是否为上传文件项
            if( item.isFormField() ){
                //是普通的form表单
            }else{
                //是上传文件项
                //获取上传文件的名称
                String filename = item.getName();
                //为了防止文件重名覆盖，给文件设置一个唯一名称
                String uuid = UUID.randomUUID().toString().replace("-","");
                filename = uuid + "_" + filename;
                //完成文件上传
                System.out.println(path);
                item.write(new File(path , filename));
                //删除临时文件
                // 当上传文件小于10kb时，会在内存中生成缓存的文件，程序会自己处理掉。
                // 当上传文件大于10kb时，就会生成临时文件，需要自己删除 。
                item.delete();
            }
        }

        return "uploadSuccess";
    }


    @RequestMapping("/upload2")
    public String fileupload2(HttpServletRequest request , MultipartFile upload) throws IOException {
        System.out.println("springmvc 文件上传执行了...");
        //文件上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        //判断文件路径是否存在
        File file = new File(path);
        if( !file.exists() ){
            //创建文件夹
            file.mkdirs();
        }

        //说明上传文件项
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String  uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_" + filename;
         //完成文件上传
        upload.transferTo(new File(path , filename));

        return "uploadSuccess";
    }

    @RequestMapping("/upload3")
    public String upload3( MultipartFile upload ) throws IOException {
        System.out.println("跨服务器上传文件...");

        // 要上传到的目标服务器的位置
        String path  = "http://localhost:9090/uploads/";

        //获取上传文件项
        String filename = upload.getOriginalFilename();
        // 把文件名称改为唯一，防止文件被覆盖
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_" + filename;

        //创建客户端对象
        Client client = Client.create();
        //与图片服务器进行连接
        WebResource resource = client.resource(path + filename);
        //上传文件
        resource.put(upload.getBytes());

        return "uploadSuccess";
    }



}
