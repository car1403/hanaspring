
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    let item_add = {
        init:function(){

            $('#item_add_form > #btn_add').click(()=>{

                let c = confirm('입력하기겠습니까?');
                if(c == true){
                    this.send();
                }
            });
        },
        send:function(){
            $('#item_add_form').attr({
                'method':'post',
                'enctype':'multipart/form-data',
                'action':'<c:url value="/item/addimpl"/>'
            });
            $('#item_add_form').submit();
        }
    };
    $(function(){
        item_add.init();
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
                <form id="item_add_form">

                    <div class="form-group">
                        <label for="name">Name:</label>
                        <input type="text"  class="form-control" id="name" placeholder="Enter password" name="itemName">

                    </div>
                    <div class="form-group">
                        <label for="price">Price:</label>
                        <input type="number"  class="form-control" id="price" placeholder="Enter name" name="itemPrice">

                    </div>
                    <div class="form-group">
                        <label for="image">Image:</label>
                        <input type="file"  class="form-control" id="image" placeholder="Enter name" name="image">

                    </div>

                    <button id="btn_add" type="button" class="btn btn-primary">Add</button>

                </form>
            </div>
        </div>
    </div>

</div>


