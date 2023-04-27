package com.yn.javastream.domian;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangni
 * @version 1.0
 *
 * @date 2022/11/22 13:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {
    private Long userId;
    private String userName;
    private Integer age;
    private String city;

}
