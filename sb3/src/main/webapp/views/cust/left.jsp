
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
  let cust_left = {
    init: function () {
      $('#cust_add').click(()=>{
        var login_id = '${sessionScope.id}';
        if(login_id == '' || login_id == null){
          alert('ID를 입력 하세요');
          return;
        }
      });
    }
  };
  $(function () {
    cust_left.init();
  });
</script>
<ul class="nav nav-pills flex-column">
  <p>Cust</p>
  <li class="nav-item">
    <a id="cust_add" class="nav-link" href="<c:url value="/cust/add"/>">add</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/cust/get"/>">get</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="<c:url value="/cust/allpage"/>">allpage</a>
  </li>

</ul>
