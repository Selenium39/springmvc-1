# springmvc-1

```
1.创建第一个Springmvc
    1.导入jar包
    2.在web.xml中配置DispatcherServlet,指定springmvc的配置文件
    3.在配置文件中进行配置(1.扫包 2.视图解析器)
    4.新建Controller类
2.@RequestMapping()映射:
     1.可以修饰方法可以修饰类
     2.属性
          1.value　路径
          2.method 请求方式
          3.params 参数
          4.headers　请求报头
     3.支持Ant风格url
          1.?匹配文件名中的一个字符
          2.*匹配文件文中的任意字符
          ３．匹配多层路径
     4.带有占位符的url
     　　　１．url中使用{id}
           2.参数中使用@PathVariable(value="id") int id    
3.REST风格架构
     1.get:获得资源
     2.post:上传资源
     3.put:跟新资源
     4.delete:删除资源
  注意:web前端并没有put和delete请求,怎么做?
      答:1.设置_method隐藏表单域　<input type="hidden" name="_method" value="DELETE"></input>
         2.在web.xml中设置HiddenHttpMethod过滤器,它会查找有无_method属性，如果有进行转换
4.获取请求上下文
      1.使用@RequestParam(当前端的name属性(请求参数)和形参同名时，不使用@RequestParam也可以访问的到)
      2.通过pojo获取:必须和pojo的属性名相同,可以使用级联属性绑定
      3.使用@RequestHeader来获取消息报头
      4.通过@CookieValue获取Cookie值
      5.通过Servlet原生API(HttpServletRequest,HttpServletResponse....)
5.处理模型数据(将数据输出)
      1.ModelAndView:放置的值是放到Request范围当中的
      2.Map以及Model,ModelMap
      3.@SessionAttributes:放置的值放在HttpSession范围当中,注意这个注解是注解在类上面的
      4.@ModelAttribute:
      　　１.作用在方法上:在当前控制器被调用的所有方法之前被调用
          注意:修饰无返回值方法则要手动将数据放到请求范围,修饰有返回值,自动将返回值放到请求范围
          2.作用在方法形参上:查找对象并合并对象
      　比如模拟用户修改的过程:
      　　如果直接修改，并不是所有的值都修改了，则值会为空，这样就想要到数据库
      　　查询数据(1)，然后在前端数据绑定之前进行对象合并(2)
         讲查询的数据放在请求范围指定ｋｅｙ，则可以讲查询到的数据绑定形参
        合并对象具体方法:
                       1.定义一个方法查出原来的对象,并在这个方法上加上@ModelAttribut注解,不需要@RequestMapping,将原来的对象放到模型域中(key为对象小写名)
                       2.将对象作为业务方法中的形参(如果key不为对象小写名,则要在形参上加上@ModelAttribute)
  ***若@ModelAttribute注解的方法无返回值,则需要map等手动放到模型域,如果有返回值,则返回的对象自动放到模型域,通过@ModelAttribute("key")设置key值                     
  
  
  
 6.直接给视图配置映射信息
 　<mvc: view-controller></mvc>
 　注意:如果给某个视图配置了映射信息，其它控制器的映射无效
 　　　此时可以使用<mvc:annotation-driven></mvc:annotation-driven>解决
 7.自定义视图
    1.视图类型:实现View接口
    2.视图加载到spring容器之中
    ３.自定义视图解析器并指定优先级
    注意:
    报错@EnableAsync annotation metadata was not injected
    https://blog.csdn.net/pansanday/article/details/50365399  
  8.使用jsr303(hibernate-validate)校验
     1.导入hibernate-validate jar包
     2.在bean上加上注解如@NotEmpty
     3.在业务方法的形参bean上加上注解@Valid,后面加上BindResult对象
     4.在前端页面使用<form:errors>显示出来
  9.springmvc与json
     1.导入jar包jackson-databind,jackson-core,jackson-annotations
     2.在前端页面和发送ajax请求
         $(function() {
		$("#ajax").click(function() {
			$.ajax({
				url : 'http://localhost:8080/springmvc/testAjax',
				type : 'post',
				contentType:'application/json;charset=utf-8',
				data :'[{"name":"wantao","age":10},{"name":"wantao1","age":200}]',
				success : function(result) {
                     $.each(result,function(index,value){
                    	 alert(value.name+""+value.age);
                     });
				}

			});
			return false;
		});
	});
    3.在方法的形参上加上@RequestBody注解
    4.在方法上加上ResponseBody注解
   
```
参考视频:https://ke.qq.com/course/249350
