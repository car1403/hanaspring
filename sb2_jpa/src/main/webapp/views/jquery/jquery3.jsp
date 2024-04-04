<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    let jquery3 = {
        init:function(){
            $('#btn_get').click(function(){
                var url = '<c:url value="/getdata"/>';
                    fetch(url).then(response => response.json()).then(data => {
                        alert(data);
                    });


                <%--$.ajax({--%>
                <%--    url:'<c:url value="/getdata"/>',--%>
                <%--    success:function(data){--%>
                <%--        alert(data);--%>
                <%--    }--%>
                <%--});--%>
            });
        }
    };
    $(function(){
        jquery3.init();
    });
</script>

<div class="container">
    <h2>jQuery3 Page</h2>
    <button id="btn_get" type="button" class="btn btn-primary">GET</button>

</div>
