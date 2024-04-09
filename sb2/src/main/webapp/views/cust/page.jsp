
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!-- pagination start -->
<div class="col text-center">
    <ul class="pagination">
        <c:choose>
            <c:when test="${cpage.getPrePage() != 0}">
                <li>
                    <a href="/cust/allpage?pageNo=${cpage.getPrePage()}">Previous</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="disabled">
                    <a href="#">Previous</a>
                </li>
            </c:otherwise>
        </c:choose>

        <c:forEach begin="${cpage.getNavigateFirstPage() }" end="${cpage.getNavigateLastPage() }" var="page">
            <c:choose>
                <c:when test="${cpage.getPageNum() == page}">
                    <li class="active">
                        <a  href="/cust/allpage?pageNo=${page}">${page }</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="/cust/allpage?pageNo=${page}">${page }</a>
                    </li>
                </c:otherwise>
            </c:choose>

        </c:forEach>
        <c:choose>
            <c:when test="${cpage.getNextPage() != 0}">
                <li>
                    <a href="/cust/allpage?pageNo=${cpage.getNextPage()}">Next</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="disabled">
                    <a href="#">Next</a>
                </li>
            </c:otherwise>
        </c:choose>

    </ul>
</div>
<!-- pagination end -->