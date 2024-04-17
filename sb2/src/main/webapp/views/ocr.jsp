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
</div>
