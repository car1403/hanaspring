
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    let item_detail = {
        init:function(){

            $('#item_update_form > #btn_update').click(()=>{

                let c = confirm('수정하시겠습니까?');
                if(c == true){
                   this.send();
                }
            });
        },
        send:function(){
            $('#item_update_form').attr({
                'method':'post',
                'enctype':'multipart/form-data',
                'action':'<c:url value="/item/update"/>'
            });
            $('#item_update_form').submit();
        }
    };
    $(function(){
        item_detail.init();
    });
</script>



<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Tables</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <form id="item_update_form">
                    <div class="form-group">
                        <label for="id">ID:</label>
                        <input type="text"  readonly="readonly" value="${item.itemId}" class="form-control" id="id" placeholder="Enter id" name="itemId">

                    </div>
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text"  value="${item.itemName}"  class="form-control" id="name" placeholder="Enter password" name="itemName">

                    </div>
                    <div class="form-group">
                        <label for="price">Price:</label>
                        <input type="number" value="${item.itemPrice}"  class="form-control" id="price" placeholder="Enter name" name="itemPrice">

                    </div>
                    <div class="form-group">
                        <h6>
                            <fmt:parseDate value="${ item.regDate }"
                                           pattern="yyyy-MM-dd" var="parsedDateTime" type="both" />
                            <fmt:formatDate pattern="yyyy년 MM월 dd일" value="${ parsedDateTime }" />
                        </h6>
                        <h6>
                            <fmt:parseDate value="${ item.updateDate }"
                                           pattern="yyyy-MM-dd" var="parsedDateTime" type="both" />
                            <fmt:formatDate pattern="yyyy년 MM월 dd일" value="${ parsedDateTime }" />
                        </h6>
                    </div>
                    <div class="form-group">
                       <img src="<c:url value="/imgs"/>/${item.imgName}">
                       <input type="hidden" name="imgName" value="${item.imgName}"/>
                    </div>
                    <div class="form-group">
                        <label for="newimage">New Image:</label>
                        <input type="file"  class="form-control" id="newimage" placeholder="Enter name" name="image">


                    </div>
                    <button id="btn_update" type="button" class="btn btn-primary">Update</button>
                    <button id="btn_delete" type="button" class="btn btn-primary">Delete</button>

                </form>
            </div>
        </div>
    </div>

</div>


