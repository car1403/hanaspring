
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
    let chart1 = {
        init: function () {
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
                series: [{
                    name: 'Tokyo',
                    marker: {
                        symbol: 'square'
                    },
                    data: [1,2,3,4,5,6,7,8,5,3,2,1]

                }, {
                    name: 'Bergen',
                    marker: {
                        symbol: 'diamond'
                    },
                    data: [1.6, 3.3, 5.9, 10.5, 13.5, 14.5, 14.4, 11.5, 8.7, 4.7, 2.6]
                }, {
                    name: 'Korea',
                    marker: {
                        symbol: 'diamond'
                    },
                    data: [-1.6, 2.3, 10.9, 13.5, 18.5, 30.5, 35.4, 16.5, 14.7, 10.7, 2.6]
                }]
            });
        }
    };
    $(function () {
        chart1.init();
    });
</script>
<div class="container">
    <h2>Chart1 Page</h2>
    <div id="container"></div>
</div>
