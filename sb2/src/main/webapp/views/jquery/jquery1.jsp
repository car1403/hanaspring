
<style>
    .form_bg{
        background: yellow !important;
    }
</style>
<script>

    let jquery1 = {
        init:function(){
            $('h2').hover(function(){
                $(this).text('in');
            },function(){
                $(this).text('out');
            });

            $('#id').focus(function(){
               $(this).addClass('form_bg');
            });
            $('#id').blur(function(){
                $(this).removeClass('form_bg');
            });
            $('#id').keyup(function(){
                let id = $(this).val();
                $('#pwd').val(id);
            });
            $('#login_form > button').click(function(){
                $('.fakeimg').empty();
            });
        }
    };


  $(function(){
      jquery1.init();
  });
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h2>jQuery1 Page</h2>
    <div class="fakeimg">Fake Image</div>
    <form id="login_form">
        <div class="form-group">
            <label for="id">ID:</label>
            <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">

        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="text" class="form-control" id="pwd" placeholder="Enter password" name="pwd">

        </div>

        <button type="button" class="btn btn-primary">LOGIN</button>
    </form>
</div>
