package com.veiw.webchart.controller;

import com.veiw.webchart.po.Echarts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author pengyou@xiaomi.com
 * @date 2020/4/22
 */
@Controller
public class EcharsAction {

    @RequestMapping("/demo")
    public String myDemo(Model model) {
        String skirt = "裙子";
        Echarts echarts = new Echarts();
        echarts.setNum(3.20f);
        int nums = 20;
        model.addAttribute("skirt", echarts);
        model.addAttribute("nums", nums);
        return "demo";
    }


}
