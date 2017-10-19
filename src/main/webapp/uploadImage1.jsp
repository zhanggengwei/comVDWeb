<%--
  Created by IntelliJ IDEA.
  User: vd
  Date: 2017/7/31
  Time: 下午1:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=3, minimum-scale=1, user-scalable=no">
    <title>图片上传的测试</title>
    <script style="text/javascript" src="http://www.jq22.com/jquery/jquery-2.1.1.js"></script>
    <script>
    function uploadImage(fd) {
        $.ajax({
            url: '/webApp/user/uploadImages',
            type: 'POST',
            data: fd,
            beforeSend: function(request) {
                request.setRequestHeader("token", "861670386");
            },
            dataType:"json",
            processData: false,
            contentType: false
        }).done(function (data) {
            alert(1);
            var json = JSON.stringify(data);
            alert(json.message);
            console.log(json);

        });
//            $.ajax({
//                url:"webApp/uploadImageAction",
//                type:"POST",
//                async:false,
//                beforeSend: function(request) {
//                    request.setRequestHeader("token", "a889bd74a0cb1ced3651ed81baa63b84");

//                },
//                data:fd,
//                dataType:"json",
//                success:function (data) {
//                   console.log(data);
//                },
//                error:function (error) {
//                   console.log(error);
//                   alert(error);
//                }
//            });
    }
    function submitImage() {
        alert("submit");
        var $file = document.getElementById("fileID").files[0];
        var fd = new FormData();
        fd.append("image",$file);
        uploadImage(fd);
    }
    </script>
</head>
<body>
<form  method="post" enctype="multipart/form-data">
    <input type="file"  name="image" id="fileID">
    <br>
    <input type="test" name="phone">
    <br>
    <input type="button" value="submit" onclick="submitImage()">
</form>
</body>
</html>
