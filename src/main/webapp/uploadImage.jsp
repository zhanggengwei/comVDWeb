<html>
<head>
    <title>Title</title>
    <script src="http://www.jq22.com/jquery/jquery-2.1.1.js"></script>
</head>
<body>
<input type="file" name="headImage" id="uploadForm"></input>
<input type="submit" name="" id="submit">submit</input>
<script type="text/javascript">
    var btn = document.getElementById("submit");
    btn.addEventListener("click", function(event){
        uploadImage()
        event.preventDefault()

    }, false);
    function uploadImage() {
        var formData = new FormData($( "#uploadForm" )[0]);
        $.ajax({
            url: '/webApp/user/uploadAvatarImage' ,  /*这是处理文件上传的servlet*/
            type: 'POST',
            data: formData,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            header:{"token":"861670386"},
            success: function (returndata) {
                alert(returndata);
            },
            error: function (returndata) {
                alert(returndata);
            }
        });

    }
</script>
</body>
</html>