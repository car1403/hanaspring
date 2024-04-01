
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    .chart_layout{
        width:300px;
        height:300px;
        border:2px solid red;
    }
</style>
<script>
    let chart3 = {
        init:function(){}
    };
    $(function () {
        chart3.init();
    });
</script>
<div class="container">
    <h2>Chart3 Page</h2>
    <div class="row well" >
        <div id="c1" class="col-sm4 well chart_layout"></div>
        <div id="c2" class="col-sm4 well chart_layout"></div>
        <div id="c3" class="col-sm4 well chart_layout"></div>
    </div>
</div>
