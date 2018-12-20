<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
   <script type="text/javascript">
   function changeSpeciallys() {

	   var slecctS = document.querySelectorAll(".select");

	   var speciallys = new Array();

	   speciallys["0"] = ["--请选择所在专业--"];

	   speciallys["信息工程学院"] = ["计算机科学与技术", "软件工程", "电子信息", "通信工程"];

	   

	   var value = slecctS[0].value;

	   //option 集合可返回包含 <select> 元素中所有 <option> 的一个数组。

	   //注意： 数组中的每个元素对应一个 <option> 标签 - 由 0 起始。 

	   slecctS[1].options.length = 0;

	   var option;

	   for(i = 0; i < speciallys[value].length; i++) {

	   //new Option("文本","值",true,true)

	   //后面两个true分别表示默认被选中和有效!

	    

	   option = new Option(speciallys[value][i], speciallys[value][i]);

	   slecctS[1].options.add(option);

	   slecctS[1].options.selected=speciallys[value][0];

	   }

	   if(slecctS[0].value == "0"){

	   slecctS[1].disabled = true;

	   }

	   else{

	   slecctS[1].disabled = false;

	   } 

	   }
   
   </script>
   <script type="text/javascript">
   var xmlHttpRequest;
	
	try{
		xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
	}catch(e){
		try{
			xmlHttpRequest = new XMLHttpRequest();
		}catch(e){
			xmlHttpRequest = XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}

	/*
	*/
	function delet(obj){
		var sno = obj.id
		var checkUrl = "${pageContext.request.contextPath}/Adm.action?dm=deleteStu&sno=" + sno;
		var tr=obj.parentNode.parentNode;
     var trs=tr.parentNode;
    
		xmlHttpRequest.onreadystatechange=function(){
			if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
				 if(xmlHttpRequest.responseText == "true"){
					tr.remove();
					alert("学生信息删除成功！");
				 }else{
					alert("学生信息删除失败！");
				 }
			}
		} 		
		xmlHttpRequest.open("get", checkUrl, true);
		xmlHttpRequest.send();
	}
	
	function resetpsw(obj){
		var sno = obj.id
		var checkUrl = "${pageContext.request.contextPath}/Adm.action?dm=resetPsd&sno=" + sno;

    
		xmlHttpRequest.onreadystatechange=function(){
			if(xmlHttpRequest.readyState==4 && xmlHttpRequest.status==200){
				 if(xmlHttpRequest.responseText == "true"){
				
					alert("学生密码重置成功！");
				 }else{
					alert("学生密码重置失败！");
				 }
			}
		} 		
		xmlHttpRequest.open("get", checkUrl, true);
		xmlHttpRequest.send();
	}

   </script>
   <title>Document</title>
 </head>
 <body>
  <div class="container">

    <div id="search_bar" class="mt10">
       <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">搜索</b></div>
            <div class="box_center pt10 pb10">
            <form action="/StuManagement/Adm.action?dm=querryStu" method="post">
              <table class="form_table" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td>学号：</td>
                  <td><input type="text" name="sno" class="input-text lh25" size="10"></td>
                  <td>姓名：</td>
                  <td><input type="text" name="sname" class="input-text lh25" size="10"></td>

				<td>              
				               院系：
				
				<select name="country" onChange="changeSpeciallys()" class="select"> 
				
				<option value="0">--请选择院系--</option>
				
				<option value="信息工程学院">信息工程学院</option>
				
				<option value="外语学院">外语学院</option>
				
				<option value="文学院">文学院</option>
				
				<option value="马克思主义学院">马克思主义学院</option>
				
				<option value="数学与统计学院">数学与统计学院</option>
				
				<option value="物理学院">物理学院</option>
				
				</select>
				</td>
				<td>专业：
				<select name="specially" class="select">				
				<option>--请选择专业--</option>				
				</select>
				   </td>               
                  
               <td style="text-align:right;">  <input type="submit" value="搜索" class="ext_btn ext_btn_submit" ></td>          
                </tr>
				               
              </table>                           
              </form>                          
            </div>
          <div class="box_bottom pb5 pt5 pr10" style="border-top:1px solid #dadada;">
              <div class="search_bar_btn" style="text-align:right;">
                <a href="/StuManagement/admviews/addStu.jsp"> <input type="button" value="添加学生" class="ext_btn ext_btn_submit"></a>
              </div>
            </div>
          
          
          
          </div>
        </div>
    </div>
    
     <div id="table" class="mt10">
        <div class="box span10 oh">
              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="list_table">
                <tr>
                   <th width="200">学号</th>
                   <th width="200">姓名</th>
                   <th width="200">院系</th>
                   <th width="200">专业</th>
                   <th width="200">年级</th>
                   <th >操作</th>
                   <th>密码操作</th>
                </tr>
                <c:choose>
				<c:when test="${!empty sList}">
				<c:forEach items="${sList}" var="stu"  >
                <tr class="tr">
                   <td class="td_center">${stu.sno}</td>
                   <td class="td_center">${stu.sname}</td>
                   <td class="td_center">${stu.dno}</td>
                   <td class="td_center">${stu.specially}</td>
                   <td class="td_center">${stu.enrollyear}</td>
                <td>
                <a href="/StuManagement/Adm.action?dm=changeStu&sno=${stu.sno}">修改</a>
                <a id="${stu.sno}" href="javascript:;" onclick='{if(confirm("确定要删除该学生信息吗?")) {delet(this); }else {}}' style="float:right;">删除</a>
                </td>
                <td>
               &nbsp;&nbsp;&nbsp;&nbsp; 
               <a id="${stu.sno}" href="javascript:;" onclick='{if(confirm("确定要重置该学生密码吗?")) {resetpsw(this); }else {}}' style="float:center;">重置密码</a>
               
                </td>
                 </tr>
                 
                  </c:forEach>
                 </c:when>
                 <c:otherwise>
				暂无学生信息
				 </c:otherwise>
                 </c:choose>             
              </table>
              
              
              <div class="page mt10">
                <div class="pagination">
                  <ul>
                      <li class="first-child"><a href="#">首页</a></li>
                      <li class="disabled"><span>上一页</span></li>
                      <li class="active"><span>1</span></li>
                      <li><a href="#">2</a></li>
                      <li><a href="#">下一页</a></li>
                      <li class="last-child"><a href="#">末页</a></li>
                  </ul>
                </div>

              </div>
        </div>
     </div>
     
     
      

   </div> 
 </body>
 </html>
  