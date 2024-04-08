<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <h1>Board Get</h1>
    <table class="table table-striped" id="board_table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Content</th>
            <th>CustId</th>
            <th>RegDate</th>
            <th>UpdateDate</th>
            <th>Click</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="b" items="${boards}">
                <tr>
                    <td><a href="<c:url value="/board/detail"/>?id=${b.boardId}">${b.boardId}</a></td>
                     <td>${b.boardTitle}</td>
                     <td>${b.boardContent}</td>
                     <td>${b.custId}</td>
                     <td>${b.boardRegdate}</td>
                     <td>${b.boardUpdate}</td>
                     <td>${b.boardCnt}</td>
                 </tr>
            </c:forEach>
        </tbody>
    </table>
</div>









