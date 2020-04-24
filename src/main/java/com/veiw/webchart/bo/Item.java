package com.veiw.webchart.bo;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author pengyou@xiaomi.com
 * @date 2020/4/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {

    private String time;

    @SerializedName("hex_packet")
    private String hexPacket;

    private Long length;

    //....
}
