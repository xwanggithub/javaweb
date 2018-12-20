<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>更改学生信息</title>
    <link rel="stylesheet" href="/StuManagement/css/css/common.css">
    <link rel="stylesheet" href="/StuManagement/css/css/punishment.css">
</head>
<body>
    <div class="container">
        <div class="content">
            <div class="header clearfix">
                <div class="top fl">当前位置>学生信息修改</div>
                
            </div>
            <div class="main">
                <!--基础信息-->
                <div class="BasicInformation">
                    <div class="title">
                        学生信息修改
                    </div>
                </div>
				<form action="/StuManagement/Adm.action?dm=updateStu" method="post">
                <div class="content clearfix">
				
                    <div class="left fl">
                        <div>
                            <label for="">学号：</label>
                            <input id="province" type="text" value="${stu.sno}" class="oInp" disabled>
                        </div>
                        <div>
                            <label for="">年级：</label>
                            <input  id="unit_pro" type="text" value="${stu.enrollyear}" class="oInp"  name="enrollyear">
                        </div>
                        <div>
                            <label for="">性别：</label>
                            <select id="entrance" class="oInp"  name="gender" style="border:0; outline: none;width: 150px; height: 30px; border: 1px solid #ccc; background: #fff" value="${stu.gender}" >
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>

                        </div>
                        <div>
                            <label for="">生日：</label>
                            <input id="remarks" type="text" value="${stu.birthday}" name="birthday" class="oInp"  >
                        </div>
                    </div>
                    <div class="right fr">
                        <div>
                            <label for="">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
                            <input id="city" type="text" value="${stu.sname }" name="sname" class="oInp"  >
                        </div>
                        <div>
                            <label for="">院&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;系：</label>
                            <input id="expect_salary" type="text" value="${stu.dno}" name="dno" class="oInp"  >
                        </div>
                        <div>
                        <label for="">入校时间：</label>
                        <input id="work_pro" type="text" value="${stu.enrollyear}" class="oInp"  >
                    </div>
					
                     <div>
                        <label for="">专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</label>
                        <input id="work_pro" type="text"  value="${stu.specially}" class="oInp" name="specially" >
                   	 </div>
                   	 <input type="hidden" value="${stu.sno }" name="sno">
					</div>
					<div class="BasicInformation">
                    <div class="title">  
						<input type="submit"  value="修&nbsp;&nbsp;改" style="height: 35px;">                    
                    </div>
					</div>
				</div>	
					
				</form>
            </div>
        </div>
    </div>
    <script src="js/jquery.min.js"></script>

</body>
</html>