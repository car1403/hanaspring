
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #container{
        width: 600px;
        height: 500px;
        border: 2px solid red;
    }
</style>
<script>
    let chart2 = {
        init: function () {
            $('#get').click(()=>{
                this.get();
            });
            setInterval(()=>{this.get();},3000);
        },
        get:function(){
            $.ajax({
                url:'<c:url value="/chart2" />',
                success:(data)=>{
                    this.chart(data);
                }
            });
        },
        chart:function(data){
            Highcharts.chart('container', {
                chart: {
                    type: 'spline'
                },
                title: {
                    text: 'Monthly Average Temperature'
                },
                subtitle: {
                    text: 'Source: ' +
                        '<a href="https://en.wikipedia.org/wiki/List_of_cities_by_average_temperature" ' +
                        'target="_blank">Wikipedia.com</a>'
                },
                xAxis: {
                    categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                        'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
                    accessibility: {
                        description: 'Months of the year'
                    }
                },
                yAxis: {
                    title: {
                        text: 'Temperature'
                    },
                    labels: {
                        format: '{value}°'
                    }
                },
                tooltip: {
                    crosshairs: true,
                    shared: true
                },
                plotOptions: {
                    spline: {
                        marker: {
                            radius: 4,
                            lineColor: '#666666',
                            lineWidth: 1
                        }
                    }
                },
                series: data
            });
        }
    };
    $(function () {
        chart2.init();
    });
</script>
<div class="container">
    <h2>Chart2 Page</h2>
    <button id="get" type="button" class="btn btn-primary">GET</button>
    <div id="container"></div>
</div>
