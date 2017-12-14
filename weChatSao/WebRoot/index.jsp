<%@page contentType="text/html" pageEncoding="utf-8"%>  
<!DOCTYPE html>  
<html>  
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
        <title>二维码技术</title>  
        <style type="text/css">  
            *{padding:0px; margin:0px;}  
            /*qrcode start*/  
            .qrcode{width:600px;  
                    height:600px;  
                    margin:150px 0 0 150px;  
                    text-align: center;  
            }  
            body{background: url("image/fengjiang.jpg") no-repeat;   
                 background-size: cover;}  
            h1{font-size:28px;text-shadow:0 0 15px #ff0; font-family:"楷体";}  
            .qrcode .q_text{  
                width:280px;  
                height:280px;  
                padding: 0px;  
                font-size: 20px;  
                font-family:"楷体";  
                margin: 50px 350px 270px 10px;  
                background:  beige;  
                text-align: left;  
            }  
            .qrcode .q_btn{width: 90%;height:25px ;  
                           border: 0px;outline: none;  
                           background: violet;  
                           cursor: pointer;  
            }  
            .qrcode .q_btn:hover{background: gray;color:  springgreen;  
                                 transition: all .5s ease;border-radius: 10px}  
            /*qrcode end*/     
            .imgBox{ 
                     position: absolute;
                     width:260px;  
                     height:260px;  
                     margin:-580px -280px 270px 680px;  
                     text-align: right;
                     }  
            </style>  
        </head>  
        <body>  
           <form action="${pageContext.request.contextPath }/ActionServlet" method="post">  
                <div class="qrcode">  
                <h1>Java 开发二维码扫一扫名片技术</h1>  
                 <table align="center" border="1px" class="q_btn">
                 <tr><td>姓名:<input type="text" name="name"></td></tr>
                 <tr><td>电话:<input type="text" name="tel"></td></tr>
                 <tr><td>邮箱:<input type="email" name="email"></td></tr>
                 <tr><td>工作室:<input type="text" name="org"></td></tr>
                 <tr><td>部门:<input type="text" name="role"></td></tr>
                 <tr><td>职位:<input type="text" name="title"></td></tr>
                 <tr><td>地址:<input type="text" name="address"></td></tr>
                 <tr><td><input type="submit" value="生成二维码" class="q_btn"/></td></tr>
                 </table>
            </div>  
        </form>  
        <div class="imgBox"> 
         
            <img src="${pageContext.servletContext.contextPath }/image/${path}" alt="二维码图片"/>  
        </div>  
    </body>  
</html>  