<%--
  Created by IntelliJ IDEA.
  User: Lyon
  Date: 2017/4/28
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pic upload</title>
    <link rel="stylesheet" href="resources/js/fileupload/css/jquery.fileupload.css">
    <link rel="stylesheet" href="resources/js/fileupload/css/jquery.fileupload-ui.css">


    <script src="resources/js/jquery-1.12.4.min.js"></script>
    <script src="resources/js/fileupload/jquery.ui.widget.js"></script>
    <script src="resources/js/fileupload/jquery.iframe-transport.js"></script>
    <script src="resources/js/fileupload/jquery.fileupload.js"></script>
</head>
<body>
<span>委托书：</span>
<span class="btn btn-success fileinput-button">
    <i class="glyphicon glyphicon-plus"></i>
    <span>上传</span>
    <input class="fileUpload" type="file" name="files[]" data-url="pic/upload" data-form-data='{"typeName": "营业执照"}'multiple>
</span>

<br>
<span>委托书：</span><input class="fileUpload" type="file" name="files[]" data-url="pic/upload" data-form-data='{"typeName": "营业执照"}'multiple>
<script>

    $(function () {
        $(".fileUpload").each(function(){
            $(this).fileupload({
                dataType: 'json',
                done: function (e, data) {
                    console.log(e);
                    console.log(data);
                    var resp = data.result;
                    if(resp.success){
                        $.each(resp.data, function (index, fileName) {
                            $('<p/>').text(fileName).appendTo(document.body);
                        });
                    }else{
                        alert(resp.message)
                    }

                }
            });
        });
    });
</script>
</body>
</html>
