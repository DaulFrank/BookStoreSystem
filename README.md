# BookStoreSystem
基于 jsp + servlet + mysql 三层架构实现的网上书店系统
@[TOC]

## 一、前言
该系统是简单的模仿 当当网 书店系统,==分为前端和后台两个部分==,目前并没有实现前后端的分离,本系统采用==三层架构==的设计思想完成前后端的交互，进而实现相对应的功能。采用的主要技术栈是: jsp + servlet + Mysql,其中包括 jsp 的三大组件,c3p0 连接池，等技术，运用的开发环境时 Idea9 + Mysql8.0。

## 二、相关技术:
[1、三层架构设计思想](https://blog.csdn.net/qq_43619271/article/details/106538194)
[2、ApacheDBUtils 详解用法](https://blog.csdn.net/qq_43619271/article/details/106491522)
[3、c3p0连接池](https://blog.csdn.net/qq_43619271/article/details/106488884)


## 三、功能分析:

### 1、前台:

==a、	用户模块：==

	•	注册 
	•	登录 	
	•	退出

==b、分类模块：==

> •	查看所有分类

==c、图书模块：==

> •	查询所有图书 
> •	按分类查询图书
>  •	查询图书详细（按id查）

==d、	购物车模块：==

> •	添加购物车条目； 
> •	清空所有条目；
>  •	删除指定条目；
>   •	我的购物车（按用户查询购物车）

==e、	订单模块：==

> •	生成订单；
>  •	我的订单（按用户查询订单） 
>  •	按id查询订单
>  •	确认收货 
>  •	付款功能（只是跳转到银行页面）
>  •	付款回调功能（由银行来调用我们这个方法，表示用户已经付款成功）

### 2、后台：

==a、管理员：==

> •	登录

==b、分类管理：==

> •	添加分类 
> •	查看所有分类
>  •	删除分类
>   •	按id查询
>    •	修改分类

==c、图书管理（我的）==

> •	查看所有图书
> •	按id查询 
> •	删除图书 
> •	修改图书 
> •	添加图书（上传图片）

## 四、效果展示:

### 1、登录与注册:
==登录:==
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607102850818.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607102906975.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
==注册==
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607102924582.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607102939359.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)

### 2、前台：
==首页:==
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607104046498.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607104101781.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
==分类查询==
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020060710412574.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
==我的购物车==
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607104140624.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607104154671.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
==我的订单==
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607104215530.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607104231160.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
==退出==
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020060710424390.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)

### 3、后台:

> 嘻嘻，本着后台能用就行的原则,相对于前台来说，后台就比较简陋了。

==管理员登录:==
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607104950451.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)

==后台首页:==
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607105013502.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
==分类管理:==
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607105108304.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607105122645.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607105134669.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
==图书管理:==
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607105207238.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607105304869.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200607105320117.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzNjE5Mjcx,size_16,color_FFFFFF,t_70#pic_center)

## 五、后记:
到此,小潘同学的网上书店系统就介绍完了,==需要源码==的小伙伴可以到     [Github](https://github.com/DaulFrank/BookStoreSystem) 上自行提取,如果在部署项目时遇到问题可以随时联系我。
在此非常==感谢 崔希凡 老师==的视频讲解,才使我完成了人生中的第一个 JavaWeb 项目,但是其中的一些技术还没有真正的搞懂,包括一些帮助类的实现都还没有运用成熟,后期会在深入的做一遍。
如果项目对您有帮助，别忘了点个赞点个关注哦。
感谢感谢！

