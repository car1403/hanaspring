<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2024-04-01
  Time: 오후 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<script>
    let chart4 = {
        init: function () {
            $('#btn_get').click(()=>{
                let gender = $('input[name="gender"]:checked').val();
                this.get(gender);
            });
        },
        get:function(gender){
            $.ajax({
                url:'<c:url value="/chart4"/>',
                data:{'gender':gender},
                success:(data)=>{
                    this.chart(data);
                }
            });
        },
        chart:function(data){
            Highcharts.chart('container', {
                chart: {
                    type: 'pie',
                    options3d: {
                        enabled: true,
                        alpha: 45,
                        beta: 0
                    }
                },
                title: {
                    text: data.title,
                    align: 'left'
                },
                subtitle: {
                    text: 'Source: ' +
                        '<a href="https://www.counterpointresearch.com/global-smartphone-share/"' +
                        'target="_blank">Counterpoint Research</a>',
                    align: 'left'
                },
                accessibility: {
                    point: {
                        valueSuffix: '%'
                    }
                },
                tooltip: {
                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        depth: 35,
                        dataLabels: {
                            enabled: true,
                            format: '{point.name}'
                        }
                    }
                },
                series: [{
                    type: 'pie',
                    name: 'Share',
                    data: data.data
                }]
            });

        }
    };
    $(function () {
        chart4.init();
    });
</script>
<div class="container" id="chart4">
    <h1>chart4</h1>
    <div>
        <div class="form-check">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="gender" value="f">Female
            </label>
        </div>
        <div class="form-check">
            <label class="form-check-label">
                <input type="radio" class="form-check-input" name="gender" value="m">Male
            </label>
        </div>
        <button id="btn_get" type="button" class="btn btn-primary">GET</button>
    </div>
    <div id="container"></div>
</div>