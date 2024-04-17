<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h2>Ocr</h2>
    <form id="item_add_form" action="<c:url value="/ocrimpl"/>"
          method="post"
          enctype="multipart/form-data">
        <div class="form-group">
            <label for="image">Image:</label>
            <input type="file"  class="form-control" id="image" placeholder="Enter name" name="image">
        </div>
        <button id="btn_add" type="submit" class="btn btn-primary">Send</button>
    </form>
    <img width="200px" src="<c:url value="/imgs/${imgname}"/> ">
    <h3>${result.bizname}</h3>
    <h3>${result.bizowner}</h3>
    <h3>${result.bizdate}</h3>
    <h3>${result.bizadd}</h3>
</div>
