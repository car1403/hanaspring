<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-03-27
  Time: 오전 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    // JSON (JavaScript Object Notation)
    let datas = [
        {"id":"id01","name":"james1"},
        {"id":"id02","name":"james2"},
        {"id":"id03","name":"james3"},
        {"id":"id04","name":"james4"},
        {"id":"id05","name":"james5"}
    ];
    let html2 = {

        init:function (){
            $('#btn').click(function(){
                html2.display(datas);
            });
        },
        display:function(datas){
            $(datas).each(function(index, data){
                alert(index + ' ' +data);
            });
        }
    };

    $(function(){
        html2.init();
    });
</script>
<div class="container">
    <h2>HTML2 Page</h2>
    <button id="btn" type="button" class="btn btn-success">Success</button>

    <div class="row">
        <div class="container col-sm-4" >

        </div>
        <div class="container col-sm-8">

        </div>
    </div>
</div>
