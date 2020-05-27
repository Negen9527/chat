[toc]

### 零、技术选型

- 基础框架 SpringBoot  

- 通信协议 WebSocket  

- 数据存储 MySQL  

### 一、项目功能

- 用户模块：用户注册、用户登录
- 好友模块：添加好友、删除好友、好友申请及处理
- 消息模块：获取消息记录



功能模块图



### 二、功能展示

##### 	1、注册页面

![注册页面.png](https://upload-images.jianshu.io/upload_images/16432686-4eac9dbd12504bc4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



##### 	2、登录页面

![登录页面.png](https://upload-images.jianshu.io/upload_images/16432686-0e9cf25407618f70.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



##### 	3、聊天主页

![聊天主页.png](https://upload-images.jianshu.io/upload_images/16432686-b3a07097eaa6401f.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)



##### 4、聊天演示



![聊天演示](https://upload-images.jianshu.io/upload_images/16432686-8a17d682e8cf591f.gif?imageMogr2/auto-orient/strip)



### 三、项目部署

1、下载项目

​	git clone https://github.com/Negen9527/chat.git

2、导入idea

3、创建数据库 db_chat， 运行项目

4、浏览器访问 http://127.0.0.1:8578/login.html





-----------------------------------------------------------------------------------------------------------------------------------------

更多学习资源获取加QQ群（备注资源）
279035164

项目远程调试、部署（备注调试）
扣扣：1096041251（不常在）
微信：hugeng8936

==================================华丽的分割线==================================

常用开发环境及工具下载及安装教程

1、Jdk8
	https://www.jianshu.com/p/1d834fcf5c44

2、Mysql
	https://www.jianshu.com/p/25b04118f929

3、sqlyog
	https://pan.baidu.com/s/1-d0GbIzjQShea87I1mLrqA

4、eclipse（复制链接到迅雷下载超快）
	64位：  
	  http://mirror.kakao.com/eclipse/technology/epp/downloads/release/oxygen/3a/eclipse-jee-oxygen-3a-win32-x86_64.zip
	32位：
      http://mirror.kakao.com/eclipse/technology/epp/downloads/release/oxygen/3a/eclipse-jee-oxygen-3a-win32.zip

5、idea（有钱 Ultimate、 没钱 Community，个人建议 Community）
	https://www.jetbrains.com/idea/download/#section=windows

6、Maven
	https://www.jianshu.com/p/8cee329465d4





### 四、项目涉及接口协议

##### 	1、用户注册

###### 		请求地址

​			http://127.0.0.1:8578/user/register

###### 		请求方式

​			POST

###### 		请求示例

```json
{
    "userName": "斯内克",
    "password": "123456",
    "sex": "1"
}
```
###### 		响应示例

```json
{
    "code": 3002,
    "message": "用户名已存在",
    "data": null
}
```



##### 	2、用户登录

###### 		请求地址

​			http://127.0.0.1:8578/user/register

###### 		请求方式

​			POST

###### 		请求示例

```json
{
    "userName": "斯内克",
    "password": "123456",
    "sex": "1"
}
```

###### 		响应示例

```json

```





##### 	3、获取好友列表

###### 		请求地址

​			http://127.0.0.1:8578/friend/list/{userId}

###### 		请求方式

​			GET

###### 		请求示例

```json
http://127.0.0.1:8578/friend/list/2
```

###### 		响应示例

```json
{
    "code": 20000,
    "message": "数据获取成功",
    "data": [
        {
            "nickName": "张大炮",
            "sex": 1,
            "isOnline": null,
            "id": 1,
            "avatar": null,
            "userName": "张大炮"
        }
    ]
}
```



##### 	4、获取非好友列表

###### 		请求地址

​			http://127.0.0.1:8578/friend/list/un/{userId}

###### 		请求方式

​			GET

###### 		请求示例

```json
http://127.0.0.1:8578/friend/list/un/2
```

###### 		响应示例

```json
{
    "code": 20000,
    "message": "数据获取成功",
    "data": [
        {
            "sex": 0,
            "isOnline": null,
            "id": 3,
            "avatar": null,
            "userName": "test"
        },
        {
            "sex": 0,
            "isOnline": false,
            "id": 4,
            "avatar": null,
            "userName": "test1"
        },
        {
            "sex": 1,
            "isOnline": false,
            "id": 5,
            "avatar": null,
            "userName": "root"
        }
    ]
}
```



##### 	5、获取新朋友（好友请求）列表

###### 		请求地址

​			http://127.0.0.1:8578/friend/add/list/{userId}

###### 		请求方式

​			GET

###### 		请求示例

```json
http://127.0.0.1:8578/friend/add/list/2
```

###### 		响应示例

```json
{
    "code": 20000,
    "message": "数据获取成功",
    "data": []
}
```



##### 	6、发起好友请求

###### 		请求地址

​			http://127.0.0.1:8578/friend/add

###### 		请求方式

​			POST

###### 		请求示例

```json
{
	"sendUserId": 1 ,
	"receiveUserId": 2,
	"message": "你好啊"
}
```

###### 		响应示例

```json
{
    "code": 200,
    "message": "发送成功",
    "data": null
}
```



##### 	7、处理好友请求

###### 		请求地址

​			http://127.0.0.1:8578/friend/add/list/handle

###### 		请求方式

​			POST

###### 		请求示例

```json
127.0.0.1:7858/friend/add/list/handle?addFriendId=1&isReceive=1
```

###### 		响应示例

```json
{
    "code": 20000,
    "message": "添加成功",
    "data": null
}
```



##### 	8、获取好友聊天信息

###### 		请求地址

​			http://127.0.0.1:8578/message/list?sid={sUserId}&rid={rUserId}

###### 		请求方式

​			POST

###### 		请求示例

```json
127.0.0.1:8578/message/list?sid=1&rid=2
```

###### 		响应示例

```json
{
    "code": 20000,
    "message": "数据获取成功",
    "data": [
        {
            "id": 28,
            "sendUserId": 2,
            "receiveUserId": 1,
            "content": "嘿嘿嘿",
            "sendTime": "2020-05-19 11:19:14"
        },
        {
            "id": 27,
            "sendUserId": 1,
            "receiveUserId": 2,
            "content": "没有啊",
            "sendTime": "2020-05-19 11:19:09"
        },
        {
            "id": 26,
            "sendUserId": 2,
            "receiveUserId": 1,
            "content": "这周日你有空吗",
            "sendTime": "2020-05-19 11:18:49"
        },
        {
            "id": 25,
            "sendUserId": 2,
            "receiveUserId": 1,
            "content": "哈哈哈",
            "sendTime": "2020-05-19 09:55:53"
        },
        {
            "id": 24,
            "sendUserId": 1,
            "receiveUserId": 2,
            "content": "may day  may day",
            "sendTime": "2020-05-19 09:55:48"
        },
        {
            "id": 23,
            "sendUserId": 2,
            "receiveUserId": 1,
            "content": "嗯呐呐，我是斯内克",
            "sendTime": "2020-05-19 08:51:17"
        },
        {
            "id": 22,
            "sendUserId": 1,
            "receiveUserId": 2,
            "content": "你好啊，我是张大炮",
            "sendTime": "2020-05-19 08:51:07"
        }
    ]
}
```













