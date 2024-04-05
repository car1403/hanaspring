<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-03-28
  Time: 오전 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
        For more information about DataTables, please visit the <a target="_blank"
                                                                   href="https://datatables.net">official DataTables documentation</a>.</p>

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
                        <th>Image</th>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Reg Date</th>
                        <th>Update Date</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Image</th>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Reg Date</th>
                        <th>Update Date</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="item" items="${itemlist}">
                        <tr>
                            <td><img src="<c:url value="/imgs"/>/${item.imgName}"></td>
                            <td>${item.itemId}</td>
                            <td>${item.itemName}</td>
                            <td>${item.itemPrice}</td>
                            <td>${item.regDate}</td>
                            <td>${item.updateDate}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>

