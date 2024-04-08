
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let register = {
        url:'',
        init:function(url){
            this.url = url;

            $('#register_form  #btn_check').click(()=>{
                let id = $('#id').val();
                if(id == '' || id == null){
                    alert('ID를 입력 하세요');
                    return;
                }
                $.ajax({
                    url:'<c:url value="/registercheckid"/>',
                    data:{'id':id},
                    success:(result)=>{
                        // alert(result);
                        let msg = '입력 가능 합니다.';
                        if(result == '0'){
                            msg = '사용 불가능 합니다.';
                        }
                        $('#check_msg').html(msg);
                    }
                });

            });


            $('#register_form  #btn_register').click(function(){
                let id = $('#id').val();
                let pwd = $('#pwd').val();
                let name = $('#name').val();
                if(id == '' || id == null){
                    alert('ID를 입력 하세요');
                    $('#id').focus();
                    return;
                }
                if(pwd == '' || pwd == null){
                    alert('PWD를 입력 하세요');
                    $('#pwd').focus();
                    return;
                }
                if(name == '' || name == null){
                    alert('NAME를 입력 하세요');
                    $('#name').focus();
                    return;
                }
                register.send();
            });
        },
        send:function(){
            $('#register_form').attr({
                'method':'post',
                'action':this.url
            });
            $('#register_form').submit();
        }
    };
    $(function(){
        register.init('<c:url value="/registerimpl"/>');
    });

</script>
<div class="container">
    <h2>Register Page</h2>
    <form id="register_form">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
            <button id="btn_check" type="button" class="btn btn-primary">CHECK ID</button>
            <span id="check_msg"></span>
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">

        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">

        </div>
        <button id="btn_register" type="button" class="btn btn-primary">REGISTER</button>
    </form>
</div>
