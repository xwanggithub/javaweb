<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用学生管理系统</title>
<link rel="stylesheet" href="/StuManagement/css/common.css">
   <link rel="stylesheet" href="/StuManagement/css/main.css">
   <script type="text/javascript" src="/StuManagement/js/jquery.min.js"></script>
   <script type="text/javascript" src="/StuManagement/js/colResizable-1.3.min.js"></script>
   <script type="text/javascript" src="/StuManagement/js/common.js"></script>
   
   <script type="text/javascript">
      $(function(){  
        $(".list_table").colResizable({
          liveDrag:true,
          gripInnerHtml:"<div class='grip'></div>", 
          draggingClass:"dragging", 
          minWidth:30
        }); 
        
      }); 
   </script>
</head>
<body>
<div class="container">
<br>
	<h1 align="center">欢迎使用学生管理系统</h1>
	<div><br></div>
	<div id="search_bar" class="mt10">
       <div class="box">
          <div class="box_border">
            
			<div id="table" class="mt10">
        	<div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr> 
                <th width="100">时间</th>               				 
				 <th>公告&nbsp;&&&nbsp;通知</th>				                   
                </tr>
                 
                <c:choose> 
				<c:when test="${!empty alist}">
				<c:forEach items="${alist}" var="a"  >
                <tr class="tr">
                <td class="td_center">${a.adate}</td>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/StuManagement/An.action?dm=announcement&ano=${a.ano}">${a.atitle}</a></td>              
                </tr>
                </c:forEach>
                </c:when>
                <c:otherwise>
					无通知
				 </c:otherwise>
                </c:choose>
               </table>
         </div>
          </div>  
          </div>
        </div>
    </div>
</div>
</body>
</html>