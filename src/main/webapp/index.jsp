<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
<a href="hello">hello</a><br/>
<form method="post" action="deleteTest/1">
<input type="hidden" name="_method" value="DELETE"></input>
<button type="submit">提交</button>
</form>
<form method="post" action="testRequestParam">
<input type="text" name="id"></input><br/>
<input type="text" name="username"></input>
<button type="submit">提交</button>
</form>
<form method="post" action="testPojo">
<input type="text" name="name"></input>
<input type="text" name="age"></input>
<button type="submit">提交</button>
</form>
<form method="post" action="testModelAttribute">
<input type="text" name="name" value="万晓飞"></input>
<button type="submit">提交</button>
</form>
</body>
</html>
