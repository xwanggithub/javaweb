<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<title>课程评价</title>
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
<div id="table" class="mt10">
        <div class="box span10 oh">

<form action="/StuManagement/Stu.action?dm=courseComment" method="post">
		<div>
		<a>课程名称：${cname}</a>
		</div>
		<div>
		<input type="hidden" value="${cno}"  id="cno" name="cno"><br>
		<textarea style="width:80%;height:200px" id="comment" name="comment"></textarea>	
		</div>		
		<div id="btn_area">
			<input type="submit" name="submit" id="sub_btn" value="提&nbsp;&nbsp;交">&nbsp;&nbsp;
		</div>
</form>
</div>
</div>
</body>
</html>