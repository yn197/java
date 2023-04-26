# swagger常用注解

## **1.@Api**

@Api 注解用于标注一个Controller（Class）。在默认情况下，Swagger-Core只会扫描解析具有@Api注解的类，而会自动忽略其他类别资源（JAX-RS endpoints，Servlets等等）的注解。

| 属性           | 描述                                             |
| -------------- | ------------------------------------------------ |
| value          | url的路径值                                      |
| tags           | 如果设置这个值、value的值会被覆盖                |
| description    | 对api资源的描述                                  |
| basePath       | 基本路径可以不配置                               |
| position       | 如果配置多个Api 想改变显示的顺序位置             |
| produces       | For example, "application/json, application/xml" |
| consumes       | For example, "application/json, application/xml" |
| protocols      | Possible values: http, https, ws, wss.           |
| authorizations | 高级特性认证时配置                               |
| hidden         | 配置为true 将在文档中隐藏                        |

示例：

```java
@Controller
@Slf4j
@RequestMapping("/user")
@Api(tags = "人员信息 API", description = "提供人员信息相关的 Rest API")
public class UserController extends BaseController {
 
}
```



## **2.@ApiOperation**

@ApiOperation 注解在用于对一个操作或HTTP方法进行描述。具有相同路径的不同操作会被归组为同一个操作对象。不同的HTTP请求方法及路径组合构成一个唯一操作。 

主要属性:

| 属性              | 描述                                                         |
| ----------------- | ------------------------------------------------------------ |
| value             | url的路径值                                                  |
| tags              | 如果设置这个值、value的值会被覆盖                            |
| description       | 对api资源的描述                                              |
| basePath          | 基本路径可以不配置                                           |
| position          | 如果配置多个Api 想改变显示的顺序位置                         |
| produces          | For example, "application/json, application/xml"             |
| consumes          | For example, "application/json, application/xml"             |
| protocols         | Possible values: http, https, ws, wss.                       |
| authorizations    | 高级特性认证时配置                                           |
| hidden            | 配置为true 将在文档中隐藏                                    |
| response          | 返回的对象                                                   |
| responseContainer | 这些对象是有效的 "List", "Set" or "Map".，其他无效           |
| httpMethod        | "GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS" and "PATCH" |
| code              | http的状态码 默认 200                                        |
| extensions        | 扩展属性                                                     |
|                   |                                                              |
|                   |                                                              |

## 3.@ApiParam

@ApiParam作用于请求方法上，定义api参数的注解。

主要属性:

| 属性            | 描述         |
| --------------- | ------------ |
| name            | 属性名称     |
| value           | 属性值       |
| defaultValue    | 默认属性值   |
| allowableValues | 可以不配置   |
| required        | 是否属性必填 |
| access          | 不过多描述   |
| allowMultiple   | 默认为false  |
| hidden          | 隐藏该属性   |
| example         | 举例子       |
|                 |              |

示例：

```java
public ResponseEntity<User> getUserById(
      @ApiParam(value = "ID of user that needs to be fetched", allowableValues = "range[1,10]", required = true)
      @PathVariable("UserId") Long userId)
```

## 4.@ApiImplicitParams、@ApiImplicitParam

@ApiImplicitParams、@ApiImplicitParam 都可以定义参数.

(1).@ApiImplicitParams：用在请求的方法上，包含一组参数说明

(2).@ApiImplicitParam：对单个参数的说明

主要属性：

| 属性         |                             描述                             |
| ------------ | :----------------------------------------------------------: |
| name         |                            参数名                            |
| value        |                       参数的说明、描述                       |
| required     |                       参数是否必须必填                       |
| paramType    | 参数放在哪个地方,<br />query --> 请求参数的获取：@RequestParam<br /> header --> 请求参数的获取：@RequestHeader <br /> path（用于restful接口）--> 请求参数的获取：@PathVariable <br /> body（请求体）--> @RequestBody User user <br /> form（普通表单提交） |
| dataType     |        参数类型，默认String，其它值dataType="Integer"        |
| defaultValue |                         参数的默认值                         |

**代码示例:**

**提示:**根据**dataTtype属性**的描述我们的"手机号","密码"都是"String"类型所以我们将其省略

```java
/**
 * <pre>
 *  登录API接口
 * </pre>
 *
 * @since 2022-06-10
 */
@ApiImplicitParams({
        //参数效验
		@ApiImplicitParam(name="phonenum",value="手机号",required=true,paramType="form"),
		@ApiImplicitParam(name="password",value="密码",required=true,paramType="form"),
		@ApiImplicitParam(name="age",value="年龄",required=true,paramType="form",dataType="Integer")
	})
	@PostMapping("/login")
	public ApiResult login(@RequestParam String mobile, @RequestParam String password,
	@RequestParam Integer age){
		//...
	    return JsonResult.ok(map);
	}
```

## **5.@ApiResponses、@ApiResponse**

@ApiResponses、@ApiResponse进行方法返回对象的说明。

主要属性：

| 属性     | 描述                       |
| -------- | -------------------------- |
| code     | 数字，例如400              |
| message  | 信息，例如"请求参数没填好" |
| response | 抛出异常的类               |

代码示例:

```java
@ApiResponses({
		@ApiResponse(code = 200, message = "请求成功"),
		@ApiResponse(code = 400, message = "请求参数没填好"),
		@ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
	}) 
	@ResponseBody
	@RequestMapping("/user")
	public ApiResult getUser(@RequestParam String userId) {
		...
	}
```

## 6.@ApiModel、@ApiModelProperty

@ApiModel用于描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）。

@ApiModelProperty用来描述一个Model的属性

使用场景

@ApiModel 用在模型类上,对模型类作注解

@ApiModelProperty 用在属性上,对属性作注解

```
/**
 * <pre>
 *     人员信息类
 * </pre>
 *
 */
@Data
@ApiModel(description= "返回人员信息")
public class UserQueryVo extends BaseEntity{
 
    @ApiModelProperty(value = "主键", required = true)
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;
    
    @ApiModelProperty(value = "手机号", required = true)
    private String phonenum;
 
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    
    @ApiModelProperty(value = "年龄", required = true)
    private Integer age;
}
```



额外补充

```
@ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改 
value–字段说明 
name–重写属性名字 
dataType–重写属性类型 
required–是否必填 
example–举例说明 
hidden–隐藏
```



## 7.**@PathVariable**

@PathVariable用于获取get请求url路径上的参数，即参数绑定的作用，通俗的说是url中"?"前面绑定的参数。

代码示例：

````
 /**
     * 人员信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("tour:vehicle:info:info")
    @ApiOperation(value = "获取user对象详情", notes = "查看人员信息")
    public ApiResult<UserQueryVo> getTourVehicleInfo(@PathVariable("id") Long id) throws Exception {
        UserQueryVo userQueryVo= userService.getTourVehicleInfoById(id);
        return ApiResult.ok(userQueryVo);
    }
````

文章出处：

https://blog.csdn.net/m0_61682705/article/details/125239542