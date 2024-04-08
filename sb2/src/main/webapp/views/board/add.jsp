
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let board_add = {
        url:'',
        init:function(url){
            this.url = url;
            $('#board_add > button').click(()=>{
                let title = $('#title').val();
                let content = $('#content').val();
                if(title == '' || title == null){
                    alert('title을 입력 하세요');
                    $('#title').focus();
                    return;
                }
                if(content == '' || content == null){
                    alert('content를 입력 하세요');
                    $('#content').focus();
                    return;
                }

                this.send();
            });
        },
        send:function(){
            $('#board_add').attr({
                'method':'post',
                'action':this.url
            });
            $('#board_add').submit();
        }
    };
    $(function(){
        board_add.init('<c:url value="/board/addimpl"/>');
    });

</script>
<div class="container">
    <h2>Board Register Page</h2>
    <form id="board_add">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" class="form-control" id="title" placeholder="Enter title"
                   name="boardTitle">

        </div>
        <div class="form-group">
            <label for="content">Content:</label>
            <textarea class="form-control"
                      rows="10" id="content"
                      name="boardContent" placeholder="Enter content"></textarea>
        </div>
        <input type="hidden" name="custId" value="${sessionScope.id}">
        <button type="button" class="btn btn-primary">REGISTER</button>
    </form>
</div>
