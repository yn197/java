package com.yn.easyexcell.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.EasyExcelFactory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yn.easyexcell.domain.User;
import com.yn.easyexcell.listener.ExcelListener;
import com.yn.easyexcell.mapper.UserMapper;
import com.yn.easyexcell.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("easyexcell")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("myImport")
    public JsonData myImport(MultipartFile file) {
        try {
            //获取文件名
            String filename = file.getOriginalFilename();
            //获取文件流
            InputStream inputStream = file.getInputStream();
            //实例化实现了AnalysisEventListener接口的类
            ExcelListener listener = new ExcelListener();

            EasyExcelFactory.read(inputStream, User.class, listener).headRowNumber(1).build().readAll();
            //获取数据
            List<Object> list = listener.getDatas();
            if (list.size() > 1) {
                for (int i = 0; i < list.size(); i++) {
                    User user = (User) list.get(i);
                    System.out.println(user.toString());
                    //使用mybatis-plus添加到数据库
                    userMapper.insert(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return JsonData.buildSuccess();
    }

    @RequestMapping("myExport")
    public void myExport(HttpServletResponse response, HttpServletRequest request) {

        try {
            String filenames = "111111";
            String userAgent = request.getHeader("User-Agent");
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                filenames = URLEncoder.encode(filenames, "UTF-8");
            } else {
                filenames = new String(filenames.getBytes("UTF-8"), "ISO-8859-1");
            }
            response.setContentType("application/json.ms-exce");
            response.setCharacterEncoding("utf-8");
            response.addHeader("Content-Disposition", "filename=" + filenames + ".xlsx");

            // Step1：创建一个 QueryWrapper 对象
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();

            // Step2： 构造查询条件
            queryWrapper
                    .select("*");

            // Step3：执行查询
            List<User> userList = userMapper.selectList(queryWrapper);

            EasyExcel.write(response.getOutputStream(), User.class).sheet("sheet").doWrite(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
