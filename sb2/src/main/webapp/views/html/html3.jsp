<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"  %>
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
    <h1>html3</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>PWD</th>
            <th>NAME</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${custs}">
                 <tr>
                    <td>${c.id}</td>
                    <td>${c.pwd}</td>
                    <td>${c.name}</td>
                 </tr>
            </c:forEach>
        </tbody>
    </table>
</div>









