
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let get = {
        init: function () {
        }
    };
    $(function () {
        get.init();
    });
</script>
<div class="container">
    <h1>get</h1>
    <h2>${cust.id}</h2>
    <h2>${cust.pwd}</h2>
    <h2>${cust.name}</h2>
</div>





