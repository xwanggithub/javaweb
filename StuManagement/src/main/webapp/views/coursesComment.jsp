<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程评价</title>
<meta charset="UTF-8">
   <link rel="stylesheet" href="../css/common.css">
   <link rel="stylesheet" href="../css/main.css">
   <script type="text/javascript" src="../js/jquery.min.js"></script>
   <script type="text/javascript" src="../js/colResizable-1.3.min.js"></script>
   <script type="text/javascript" src="../js/common.js"></script>
   
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
 
    <div id="search_bar" class="mt10">
       <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">学生成绩信息</b></div>
			
            
          </div>
        </div>
    </div>
     <div id="table" class="mt10">
        <div class="box span10 oh">
              <table  width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>                
				 <th>课程号</th>
                 <th>课程名</th>
                 <th>任课老师</th>
                 <th>课程类别</th>
                 <th>学时</th> 
				 <th>学分</th>
				 <th>操作</th>								                   
                </tr>
                <c:choose> 
				<c:when test="${!empty mycourse}">
				<c:forEach items="${mycourse}" var="mc"  >
                <tr class="tr">
                   <td class="td_center">${mc.cno }</td>
                   <td class="td_center">${mc.cname}</td>
                   <td class="td_center">${mc.tname }</td>                  	
                   <td class="td_center">${mc.ctype==1?"必修":mc.ctype==2?"选修":"校选修"}</td>
                   <td class="td_center">${mc.preiod}</td>	
                   <td class="td_center">${mc.credit}</td>  
                   <td class="td_center"><a href="/StuManagement/Stu.action?dm=delCourse">${mc.ctype==1?null:"退选"}</a></td>		   
                 </tr>
                 </c:forEach>
                 </c:when>
                 <c:otherwise>
					无选课
				 </c:otherwise>
                 </c:choose>
                                        
              </table>
</div>
</div>
</div>
</body>
</html>