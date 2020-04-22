package com.veiw.webchart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pengyou@xiaomi.com
 * @date 2020/4/22
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, @RequestParam(value = "name", required = false, defaultValue = "springboot-thymeleaf") String name) {
        request.setAttribute("name", name);
        return "hello";
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        List<Integer> data = new ArrayList<Integer>();
        data.add(820);
        data.add(932);
        data.add(901);
        data.add(934);
        data.add(1290);
        data.add(1330);
        data.add(1320);
        request.setAttribute("data", data);
        return "index";
    }

}
