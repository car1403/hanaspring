
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    let board_detail = {
        init:function(){
            $('#board_detail_form > #btn_update').click(()=>{

                this.send();
            });
            $('#board_detail_form > #btn_delete').click(()=>{

                let c = confirm('삭제하기겠습니까?');
                if(c == true){
                    let id = $('input[name="boardId"]').val();
                    location.href = '<c:url value="/board/delete"/>?id='+id;
                }
            });
        },
        send:function(){
            $('#board_detail_form').attr({
                'method':'post',
                'action':'<c:url value="/board/update"/>'
            });
            $('#board_detail_form').submit();
        }
    };
    $(function () {
        board_detail.init();
    });
</script>
<div class="container">
    <h2>Board Detail Page</h2>
    <form id="board_detail_form">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" value="${board.boardTitle}"
                   class="form-control" id="title"  name="boardTitle">

        </div>
        <div class="form-group">
            <label for="content">Content:</label>
            <textarea class="form-control"
                      rows="10" id="content"
                      name="boardContent" >${board.boardContent}</textarea>
        </div>
        <div class="form-group">
            <label for="custid">Cust ID:</label>
            <input type="text" value="${board.custId}"
                   class="form-control" id="custid"  name="custId" readonly="readonly">
        </div>
        <input type="hidden" name="boardId" value="${board.boardId}">
        <div class="form-group">
            <p>등록일:
                <fmt:parseDate value="${ board.boardRegdate }"
                               pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
                <fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${ parsedDateTime }" />
            </p>
            <p>수정일:
                <fmt:parseDate value="${ board.boardUpdate }"
                               pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
                <fmt:formatDate pattern="dd.MM.yyyy HH:mm:ss" value="${ parsedDateTime }" />
            </p>
        </div>
        <c:if test="${sessionScope.id == board.custId}">
            <button id="btn_update" type="button" class="btn btn-primary">Update</button>
            <button id="btn_delete" type="button" class="btn btn-primary">Delete</button>
        </c:if>
    </form>

    <%-- Comment List    --%>

        <c:choose>
            <c:when test="${board.commentList.size() != 0}">
<%--            <c:when test="${board.commentList != []}">--%>
<%--            <c:when test="${!empty(board.commentList)}">--%>
            <table class="table table-striped" id="comment_table">
                <thead>
                <tr>
                    <th>Content</th>
                    <th>CustId</th>
                    <th>RegDate</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="c" items="${board.commentList}">
                    <tr>
                        <td>${c.commentContent}</td>
                        <td>${c.custId}</td>
                        <td>
                            <fmt:parseDate value="${c.commentRegdate}"
                                           pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
                            <fmt:formatDate pattern="yyyy년MM월dd일 HH시mm분" value="${ parsedDateTime }" />
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </c:when>
            <c:otherwise>
                <p>없음</p>
            </c:otherwise>
        </c:choose>




</div>
