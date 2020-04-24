package com.veiw.webchart.controller;

import com.veiw.webchart.bo.Item;
import com.veiw.webchart.utils.PyDateUtil;
import com.veiw.webchart.utils.PyJsonUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pengyou@xiaomi.com
 * @date 2020/4/22
 */
@Controller
public class EcharsAction {


    private final String dataUrl = "https://cloud.alientek.com/api/orgs/2086/devicepacket/59417250541070249333";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/demo")
    public String myDemo(Model model) {
        //完整地址https://cloud.alientek.com/api/orgs/2086/devicepacket/59417250541070249333
        // ?page=1&limit=50&start=2020-04-24 02:12:35&end=2020-04-24 03:12:35
        long currentTimeMillis = System.currentTimeMillis();

        //headers
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("token", "1e8d3629aaf740c48d0d85fdfcf6f8bf");
        HttpEntity requestEntity = new HttpEntity(null, requestHeaders);
        ResponseEntity<String> entity = restTemplate.exchange(dataUrl, HttpMethod.GET, requestEntity, String.class);
        //获取返回信息
        String body = entity.getBody();
        body = "{\n" +
                "    \"code\": 200,\n" +
                "    \"data\": {\n" +
                "        \"current_page\": 1,\n" +
                "        \"items\": [\n" +
                "            {\n" +
                "                \"hex_packet\": \"45 41 66 34 23 89 80 100\",\n" +
                "                \"length\": 14,\n" +
                "                \"time\": \"2018-08-11T17:03:39.300928+08:00\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"hex_packet\": \"78 41 55 88 90 43 34 23\",\n" +
                "                \"length\": 14,\n" +
                "                \"time\": \"2018-08-11T17:02:39.401668+08:00\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"hex_packet\": \"100 64 73 33 56 99 77 44\",\n" +
                "                \"length\": 22,\n" +
                "                \"time\": \"2018-08-11T17:02:24.560741+08:00\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"page_limit\": 30,\n" +
                "        \"total_item\": 10,\n" +
                "        \"total_page\": 1\n" +
                "    },\n" +
                "    \"message\": \"ccccc\"\n" +
                "}";

        List<Item> itemList = PyJsonUtils.bodyToList(body);
        //定义坐标
        List<String> xData = new ArrayList<String>();
        List<List<Integer>> yData = new ArrayList<List<Integer>>();
        for (int i = 0; i < 8; i++) {
            yData.add(new ArrayList<Integer>());
        }
        for (Item item : itemList) {
            try {
                xData.add(PyDateUtil.dateStr2formatStr(item.getTime()));
                String[] yStr = item.getHexPacket().split(" ");
                for (int j = 0; j < yStr.length; j++) {
                    yData.get(j).add(Integer.parseInt(yStr[j]));
                }
            } catch (Exception e) {
                System.err.println("error===============" + e.getMessage());
            }
        }
        model.addAttribute("xData", xData);
        model.addAttribute("yData", yData);
        return "demo";
    }

}
