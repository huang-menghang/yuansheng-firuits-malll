<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp"/>
<title>个人中心</title>
</head>
<body>
<!--header-->
<header>
 <a onclick="backHome()" class="iconfont backIcon">&#60;</a>
 <h1>个人中心</h1>
 <a href="<%=basePath %>userCenter/userSet.jspa" class="iconfont setIcon">&#42;</a>
</header>
<div style="height:1rem;"></div>
<div class="userInfor">
 <a class="userIcon"><img src="<%=basePath%>static/images/avatar/DefaultAvatar.jpg"/></a>
 <h2>${sessionScope.customer.customerPetName}</h2>
</div>
<ul class="userList">
 <li><a href="<%=basePath %>userCenter/myOrderList.jspa" class="orderListIcon">我的订单</a></li>
 <li><a href="<%=basePath %>userCenter/paginationEntityFavourite.jspa" class="collectionIcon">常购清单</a></li>
 <li><a href="<%=basePath %>userCenter/myProfile.jspa" class="profileIcon">个人资料</a></li>
</ul>
<!--fixedNav:footer-->
<div style="height:1.2rem;"></div>
<%@include file="/webpage/common/footer.jsp"%>
<script>
  document.oncontextmenu=new Function("event.returnValue=false;");
  document.onselectstart=new Function("event.returnValue=false;"); 
</script>

</body>
</html>