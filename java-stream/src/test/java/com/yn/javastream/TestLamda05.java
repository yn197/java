package com.yn.javastream;

import com.yn.javacommon.utils.SnowflakeIdWorker;
import com.yn.javastream.domian.SysUser;
import com.yn.javastream.domian.UserInfo;
import com.yn.javastream.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yangni
 * @version 1.0
 *
 * @date 2022/8/21 11:12
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestLamda05 {
    @Resource
    private SysUserMapper sysUserMapper;
    @Test
    public void arryToMapStream() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18, "武汉"));
        userInfoList.add(new UserInfo(2L, "程序员田螺", 27, "北京"));
        userInfoList.add(new UserInfo(2L, "捡瓶子的小男孩", 26, "长沙"));

        /**
         *  list 转 map
         *  使用Collectors.toMap的时候，如果有可以重复会报错，所以需要加(k1, k2) -> k1
         *  (k1, k2) -> k1 表示，如果有重复的key,则保留第一个，舍弃第二个
         */
        Map<Long, UserInfo> userInfoMap = userInfoList.stream().collect(Collectors.toMap(UserInfo::getUserId, userInfo -> userInfo, (k1, k2) -> k1));
        userInfoMap.values().forEach(a -> System.out.println(a.getUserName()));
    }

    @Test
    public void groupingBy() {
        List<UserInfo> originUserInfoList = new ArrayList<>();
        originUserInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18, "深圳"));

        originUserInfoList.add(new UserInfo(3L, "捡瓶子的小男孩", 26, "湛江"));
        originUserInfoList.add(new UserInfo(2L, "程序员田螺", 27, "深圳"));
        Map<String, List<UserInfo>> result = new HashMap<>();
        for (UserInfo userInfo : originUserInfoList) {
            String city = userInfo.getCity();
            List<UserInfo> userInfos = result.get(city);
            if (userInfos == null) {
                userInfos = new ArrayList<>();
                result.put(city, userInfos);
            }
            userInfos.add(userInfo);
        }
    }

    @Test
    public void groupingByStream() {
        List<UserInfo> originUserInfoList = new ArrayList<>();
        originUserInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18, "深圳"));

        originUserInfoList.add(new UserInfo(3L, "捡瓶子的小男孩", 26, "湛江"));
        originUserInfoList.add(new UserInfo(2L, "程序员田螺", 27, "深圳"));
        //根据城市分组
        Map<String, List<UserInfo>> result = originUserInfoList.stream().collect(Collectors.groupingBy(UserInfo::getCity));
        //分组求和年龄
        Map<String, Integer> prodMap = originUserInfoList.stream().collect(Collectors.groupingBy(UserInfo::getCity, Collectors.summingInt(UserInfo::getAge)));

    }

    @Test
    public void distinctByStream() {
        List<String> list = Arrays.asList("A", "B", "F", "A", "C");
        List<String> temp = list.stream().distinct().collect(Collectors.toList());
        temp.forEach(System.out::println);

    }

    @Test
    public void sortedByStream() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18, "乌鲁木齐"));
        userInfoList.add(new UserInfo(3L, "捡瓶子的小男孩", 26, "辽宁"));
        userInfoList.add(new UserInfo(2L, "程序员田螺", 27, "宁波"));

/**
 *  sorted + Comparator.comparing 排序列表，
 */
        userInfoList = userInfoList.stream().sorted(Comparator.comparing(UserInfo::getAge))
                .collect(Collectors.toList());
        userInfoList.forEach(a -> System.out.println(a.toString()));

        System.out.println("开始降序排序");

/**
 * 如果想降序排序，则可以使用加reversed()
 */
        userInfoList = userInfoList.stream().sorted(Comparator.comparing(UserInfo::getAge).reversed())
                .collect(Collectors.toList());
        userInfoList.forEach(a -> System.out.println(a.toString()));


    }


    @Test
    public void findFirstByStream() {
        List<String> list = Arrays.asList("A", "B", "F", "A", "C");
        list.stream().findFirst().ifPresent(System.out::println);
    }


    @Test
    public void anyMatchOnlyByStream() {
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        boolean match = stream.anyMatch(s -> s.contains("C"));
        System.out.println(match);
    }

    @Test
    public void anyMatchAllByStream() {
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        boolean match = stream.allMatch(s -> s.contains("C"));
        System.out.println(match);
    }


    @Test
    public void mapToUpperCaseByStream() {
        List<String> list = Arrays.asList("jay", "tianluo");
//转化为大写
        List<String> upperCaselist = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        upperCaselist.forEach(System.out::println);
    }


    @Test
    public void reduceByStream() {
        int sum = Stream.of(1, 2, 3, 4).reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    @Test
    public void peekByStream() {
        List<String> result = Stream.of("程序员田螺", "捡田螺的小男孩", "捡瓶子的小男孩")
                .filter(a -> a.contains("田螺"))
                .peek(a -> System.out.println("公众号:" + a)).collect(Collectors.toList());
        System.out.println(result);
        //运行结果
        //公众号:程序员田螺
        //公众号:捡田螺的小男孩
        //[程序员田螺, 捡田螺的小男孩]
    }


    @Test
    public void maxAndMinByStream() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18, "广州"));
        userInfoList.add(new UserInfo(3L, "捡瓶子的小男孩", 26, "上海"));
        userInfoList.add(new UserInfo(2L, "程序员田螺", 27, "深圳"));

        Optional<UserInfo> maxAgeUserInfoOpt = userInfoList.stream().max(Comparator.comparing(UserInfo::getAge));
        maxAgeUserInfoOpt.ifPresent(userInfo -> System.out.println("max age user:" + userInfo));

        Optional<UserInfo> minAgeUserInfoOpt = userInfoList.stream().min(Comparator.comparing(UserInfo::getAge));
        minAgeUserInfoOpt.ifPresent(userInfo -> System.out.println("min age user:" + userInfo));

//运行结果
        //max age user:UserInfo{userId=2, userName='程序员田螺', age=27}
        //min age user:UserInfo{userId=1, userName='捡田螺的小男孩', age=18}
    }

    @Test
    public void countByStream() {
        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(new UserInfo(1L, "捡田螺的小男孩", 18, "广州"));
        userInfoList.add(new UserInfo(3L, "捡瓶子的小男孩", 26, "上海"));
        userInfoList.add(new UserInfo(2L, "程序员田螺", 27, "深圳"));

        long count = userInfoList.stream().filter(user -> user.getAge() > 18).count();
        System.out.println("大于18岁的用户:" + count);
        //输出
        //大于18岁的用户:2
    }

    private void saveDb(Supplier<Integer> supplier) {
        if (supplier.get() > 0) {
            System.out.println("插入数据库成功");
        } else {
            System.out.println("插入数据库失败");
        }
    }

    @Test
    public void add() throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(Long.parseLong(SnowflakeIdWorker.getNextId()));
        sysUser.setDeptId(Long.parseLong(SnowflakeIdWorker.getNextId()));
        sysUser.setUserName("测试数据");
        sysUser.setNickName("若依测试数据");
        saveDb(() -> sysUserMapper.insert(sysUser));
    }

    @Test
    public void test() throws Exception {
        String[] firstArr = {"苹果", "香蕉", "西瓜"};
        String[] secondArr = {"苹果", "香蕉", "西瓜", "葡萄"};
        List<String> firstList = Arrays.asList(firstArr);
        List<String> secondList = Arrays.asList(secondArr);


        List<String> collect = secondList.stream()
                .filter(item -> !firstList.contains(item)).collect(Collectors.toList());

        System.out.println(collect);
    }
    public static void main(String[] args) {

        LocalDate startTime = LocalDate.now().minusDays(6);
        LocalDate endTime = LocalDate.now().minusDays(-1);
        System.out.println("开始时间："+startTime+"结束时间："+endTime);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        //现在日期
        String now = format.format(new Date());
        System.out.println("现在日期  ："+now);

        //过去七天
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, - 7);//减几就是几天之前
        Date d = calendar.getTime();
        String day = format.format(d);
        System.out.println("过去七天  ："+day);

        //过去一月
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1); //减几就是几个月之前
        Date m = calendar.getTime();
        String mon = format.format(m);
        System.out.println("过去一个月："+mon);

        //过去一年
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -1);//减几就是几年之前
        Date y = calendar.getTime();
        String year = format.format(y);
        System.out.println("过去一年  ："+year);
    }
}
