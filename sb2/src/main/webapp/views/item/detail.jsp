
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">
    <h2>Item Detail</h2>
    <h3><img  src="<c:url value="/imgs"/>/${item.imgName}"></h3>
    <h3>${item.itemName}</h3>
    <h3>
        <fmt:formatNumber type="number" pattern="###,###원" value="${item.itemPrice}" />
    </h3>
    <h3>${item.regDate}</h3>
    <h3>${item.updateDate}</h3>
</div>







