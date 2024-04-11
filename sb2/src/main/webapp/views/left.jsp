
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
  let left = {
    init: function () {
      $('#btn_board_add').click(()=>{
          if('${sessionScope.id}' == '' || '${sessionScope.id}' == null){
            $('#btn_board_add').removeAttr('href');
            alert('로그인 하셔야 합니다.');
          }
      });
    }
  };
  $(function () {
    left.init();
  });
</script>
<ul class="nav nav-pills flex-column">
  <li class="nav-item">
    <a id="btn_board_add" class="nav-link" href="<c:url value="/board/add"/>">Board Add</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/board/get"/>">Board Get</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/board/allpage"/>">Board All Get</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/weather"/>">Weather</a>
  </li>
</ul>
