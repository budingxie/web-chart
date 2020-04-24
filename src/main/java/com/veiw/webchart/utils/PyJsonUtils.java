package com.veiw.webchart.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.veiw.webchart.bo.Item;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author pengyou@xiaomi.com
 * @date 2020/4/24
 */
public class PyJsonUtils {

    /**
     * 转化list集合
     *
     * @param body body
     * @return 集合
     */
    public static List<Item> bodyToList(String body) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<JsonObject>>() {
        }.getType();
        JsonObject bodyObj = gson.fromJson(body, JsonObject.class);
        JsonArray items = bodyObj.getAsJsonObject("data").getAsJsonArray("items");
        List<JsonObject> jsonObjects = gson.fromJson(items, type);
        List<Item> itemList = new ArrayList<>();
        for (JsonObject jsonObject : jsonObjects) {
            itemList.add(gson.fromJson(jsonObject, Item.class));
        }
        return itemList;
    }

}
