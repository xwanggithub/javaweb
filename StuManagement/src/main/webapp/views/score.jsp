<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>成绩信息</title>
<meta charset="UTF-8">
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
 
    <div id="search_bar" class="mt10">
       <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">学生成绩信息</b></div>
			
            
          </div>
        </div>
    </div>
     <div id="table" class="mt10">
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>                
				 <th>课程号</th>
                 <th>课程名</th>
                 <th>课程类别</th>
				 <th>学分</th>
				 <th>绩点</th>
				 <th>成绩</th>                   
                </tr>
                <c:choose>
				<c:when test="${!empty sgds}">
				<c:forEach items="${sgds}" var="s"  >
                <tr class="tr">
                   <td class="td_center">${s.courseNo }</td>
                   <td class="td_center">${s.cname}</td>
                   <td class="td_center">${s.ctype==1?"必修":s.ctype==2?"选修":"校选修"}</td>
                   <td class="td_center">${s.credit }</td>                  	
                   <td class="td_center">${s.ctype==1?s.gpa:null}</td>	
                   <td class="td_center">${s.score}</td>  		   
                 </tr>
                 </c:forEach>
                 </c:when>
                 <c:otherwise>
					无成绩
				 </c:otherwise>
                 </c:choose>
                                        
              </table>
</div>
</div>
</div>
</body>
</html>