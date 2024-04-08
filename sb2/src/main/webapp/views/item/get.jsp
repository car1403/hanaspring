<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    #item_table img{
        width:100px !important;
        height:100px !important;
    }
</style>
<script>
    let html3 = {
        init: function () {
        }
    };
    $(function () {
        html3.init();
    });
</script>
<div class="container">
    <h1>Item Get</h1>
    <table class="table table-striped" id="item_table">
        <thead>
        <tr>
            <th>Image</th>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Reg Date</th>
            <th>Update Date</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="i" items="${items}">
                 <tr>
                     <td><img  src="<c:url value="/imgs"/>/${i.imgName}"></td>
                     <td><a href="<c:url value="/item/detail"/>?id=${i.itemId}">${i.itemId}</a></td>
                     <td>${i.itemName}</td>
                     <td>
                         <fmt:formatNumber type="number" pattern="###,###원" value="${i.itemPrice}" />
                     </td>
                     <td>${i.regDate}</td>
                     <td>${i.updateDate}</td>
                 </tr>
            </c:forEach>
        </tbody>
    </table>
</div>









