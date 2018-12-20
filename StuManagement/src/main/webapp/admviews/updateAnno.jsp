<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加公告</title>
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
   <script type="text/javascript">

   
   
   </script>
   <style type="text/css">
   		.container #search_bar .box .box_border #table .submit {
   			margin-right: 240px;
   			float: right;
   		}
   		.container #search_bar .box .box_border #table .one {
   			width: 800px;
   			height: 20px;
   			border: 1px solid #ccc;
   		}
   		.container #search_bar .box .box_border #table span {
   			display: inline-block;
   			height: 20px;
   			line-height: 20px;
   			text-align: center;
   			margin-top: 10px;
   		}
   		.container #search_bar .box .box_border #table .arti {
   			margin-right:800px;
   			display: inline-block;
   			text-align: center;
   		}
   		.container #search_bar .box .box_border #table .two {
   			margin-left: 40px;
   			width: 800px;
   			height: 400px;
   			border: 1px solid #ccc;
   			resize:none;
   		}
   </style>
</head>
<body>
<div class="container">
	<div id="search_bar" class="mt10">
       <div class="box">
          <div class="box_border">
            
			<div id="table" class="mt10">
        	<div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>               				 
				 <th>发布公告&nbsp;&&&nbsp;通知</th>				                   
                </tr>
            </table>
            <form action="/StuManagement/An.action?dm=updateAnno" align="center" method="post">
            <span>标题：</span><input type="text" name="atitle"  class="one" value="${announce.atitle}">
            <br>
     		 <span class="arti">内容：</span>
     		 <br>
     		 <textarea rows="" cols="" class="two" name="amessage" >${announce.amessage}</textarea>
       		<br>
       		<input type="hidden" value="${announce.ano}" name="ano" id="ano">
        		<input type="submit" value="发布"  class="submit">
            
            </form>
         </div>
          </div> 
          

          </div>
        </div>
    </div>
</div>
</body>
</html>