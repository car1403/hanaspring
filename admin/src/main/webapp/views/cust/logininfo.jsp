
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let cust_get = {
        init:function(){},
        update:function(id){
            let c = confirm('수정하시겠습니까?');
            if(c == true){
                location.href = '<c:url value="/cust/detail"/>?id='+id;
            }
        },
        delete:function(id){
            let c = confirm('삭제하시겠습니까?');
            if(c == true){
                location.href = '<c:url value="/cust/delete"/>?id='+id;
            }
        }
    };
    $(function(){
        cust_get.init();
    });
</script>
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Login Info</h1>
    <p class="mb-4">Login 사용자: ${cnt}</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>ID</th>

                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>ID</th>

                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="c" items="${logincusts}">
                        <tr>
                            <td>${c.loginId}</td>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>


