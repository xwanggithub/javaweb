<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
   <style type="text/css">
   	body .context {
   		border: 1px solid #ccc;
   		width: 400px;
   		height: 580px;
   		margin: 10px auto;
   	}
   
   </style>
</head>
<body>
      
          <div class="box_border" style=height:600px >  
          <div></div><div></div>          
			<div class="context">
				<article>
				<h2 align="center">${announce.atitle}</h2>
				<br>
				<p align="center">${announce.amessage}</p>
	
			</article>
			</div>
     
          </div>
</body>
</html>