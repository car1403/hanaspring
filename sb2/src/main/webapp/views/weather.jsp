
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    let weather = {
        init: function () {
            $.ajax({
                url:'<c:url value="/wh2"/>',
                success:(result)=>{
                    this.display(result);
                }
            });
        },
        display: function(result){
            $('#w1').html(result.weather[0].main+' : '+result.weather[0].description);
            $('#w2').html('온도:'+result.main.temp);
            $('#w3').html('체감온도:'+result.main.feels_like);
            $('#w4').html('최저온도:'+result.main.temp_min);
            $('#w5').html('최고온도:'+result.main.temp_max);
        }
    };
    $(function () {
        weather.init();
    });
</script>
<div class="container">
    <h2>Weather Page</h2>
    <h5 id="w1"></h5>
    <h5 id="w2"></h5>
    <h5 id="w3"></h5>
    <h5 id="w4"></h5>
    <h5 id="w5"></h5>
    <h5 id="w6"></h5>

</div>
