<script>
    let ajax1 = {
        init:function(){
            var url = '<c:url value="/getservertime"/>';

            setInterval(function(){

                $.ajax({
                    url:'/getservertime',
                    success:function(data){
                        ajax1.display(data);
                    },
                    error:function(){}
                });
            },1000);


        },
        display:function(data){
            $('#result').text(data);
        }
    };

    $(function(){
        ajax1.init();
    });
</script>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h2>AJAX1 Page</h2>
    <h3>Server Time</h3>
    <h3 id="result"></h3>
</div>
