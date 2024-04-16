
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
    let summary = {
        init:function(){
            $('#summary_form button').click(()=>{
                this.send();
            });
        },
        send:function(){
            let content = $('#content').val();
            $.ajax({
                url:'<c:url value="/summaryimpl"/>',
                data:{'content':content},
                success:(result)=>{

                    $('#result').val(result.summary);
                }
            });
        }
    };
    $(function(){
        summary.init();
    });
</script>
<div class="container">
    <h2>Summary</h2>
    <form id="summary_form">
        <div class="form-group">
            <label for="content">Content:</label>
            <textarea class="form-control"
                      rows="10" id="content"
                      name="boardContent" placeholder="Enter content"></textarea>
        </div>
        <button type="button" class="btn btn-primary">REGISTER</button>
    </form>
    <textarea class="form-control"
              rows="10" id="result"
              name="boardContent" placeholder="Enter content"></textarea>
</div>
