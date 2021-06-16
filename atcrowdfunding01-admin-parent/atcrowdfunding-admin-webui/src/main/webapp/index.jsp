<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<base  href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/" />

<script src="js/jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        $("#btn1").click(function(){
            console.log("1")
                $.ajax({
                    // url:"test/test1.do",
                    // dataType:"json",
                    // data:{"name":"xiaoxiao"},
                    "url":"test/test1.do",
                    "data":"aa",
                    "type":"post",
                    "dataType":"json",
                    success:function(response){
                        // success是接收到服务器端响应后执行
                        console.log(response);
                    }}
                )
        })
        var student = {
            sId:"1",
            sName:"张三",
            address:{
              province:"湖南",
              city:"怀化"
            },
            subjectList:[
                {
                    subjectName:"javaSEE",
                    sScore:100
                },{
                    subjectName:"html",
                    sScore:80
                }
            ],
            map:{
                k1:"v1",
                k2:"v2",
                k3:"v3"
            }
        }
        var studentJson = JSON.stringify(student)
        $("#btn2").click(
            function () {
                $.ajax({
                     url:"test/test2.do",
                    data:studentJson,
                    "type":"post",
                    contentType:"application/json;charset=UTF-8",
                    "dataType":"json",
                    success:function(response){
                        // success是接收到服务器端响应后执行
                        console.log(response);
                    }
                })
            }
        )

    });
</script>
<body>
        <a href="test/test.do">测试</a>        <br>

        <button id="btn1">
            test
        </button>   <br>

        <button id="btn2">
            组合对象
        </button>
        <a href="test/test3.do">去成功页面</a>
</body>
</html>