<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>editHero</title>
</head>
<body>
<div style="margin:50px auto; width:300px">
    <form action="updateHero" method="post">
        name:&nbsp;&nbsp;<input name="name" value="${hero.name}"> <br>
        hp:&nbsp;&nbsp;<input name="hp" value="${hero.hp}"><br>
        damage:&nbsp;&nbsp;<input name="damage" value="${hero.damage}">
        <br>

        <input type="hidden" name = "id" value="${hero.id}">
        <input type="submit" value="提交">
    </form>

</div>
</body>
</html>