
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #container{
        width: 600px;
        height: 500px;
        border: 2px solid red;
    }
</style>
<script>
    let chart2 = {
        init: function () {
            $('#get').click(()=>{
                this.get();
            });
        },
        get:function(){
            $.ajax({
                url:'',
                success:(data)=>{
                    this.chart(data);
                }
            });
        },
        chart:function(data){
            alert('ok');
        }
    };
    $(function () {
        chart2.init();
    });
</script>
<div class="container">
    <h2>Chart2 Page</h2>
    <button id="get" type="button" class="btn btn-primary">GET</button>
    <div id="container"></div>
</div>
