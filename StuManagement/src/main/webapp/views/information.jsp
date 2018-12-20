<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
 <head>
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
   <title>学籍信息</title>
 </head>
 <body>
  <div class="container">
 
    <div id="search_bar" class="mt10">
       <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">学籍信息</b></div>
			
            
          </div>
        </div>
    </div>
    
     <div id="table" class="mt10">
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>                
				 <th></th>
                 <th></th>
				 <th>学生个人信息</th>
				 <th></th>
				 <th></th>                   
                </tr>
                
                <tr class="tr">
                   <td class="td_right">学号：</td>
                   <td>${stu.sno}</td>
                   <td class="td_right">姓名：</td>
                   <td>${stu.sname}</td>  
				<td width="11%" rowspan="5" id='photoImg' class="td_center">
				<img class="center" width="80px" height="110px" src="${stu.picture}" alt="${stu.sname}" title="${stu.sname}"/>
				</td>
				   
                 </tr>
                 <tr class="tr"> 
				   <td class="td_right">性别：</td>
                   <td>${stu.gender}</td>
                   <td class="td_right">年级：</td>
                   <td>${enrollyear}</td>                                   
                 </tr>
                 <tr class="tr">
                    <td class="td_right">院系：</td>
                   <td>${stu.dno}</td>
                   <td class="td_right">专业：</td>
                   <td>${stu.specially}</td>          
                 </tr>
                 <tr class="tr">
                    <td class="td_right">入校时间：</td>
                   <td>${stu.enrollyear}</td>
                   <td class="td_right">生日：</td>
                   <td>${stu.birthday}</td>               
                 </tr>                        
              </table>
      
     
      </div>
	</div>
   </div> 
 </body>
 </html>