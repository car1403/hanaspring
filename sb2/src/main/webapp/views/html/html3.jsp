<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<script>
    $(function(){
        const defaultData = 'https://demo-live-data.highcharts.com/time-data.csv';
        const urlInput = document.getElementById('fetchURL');
        const pollingCheckbox = document.getElementById('enablePolling');
        const pollingInput = document.getElementById('pollingTime');

        function createChart() {
            Highcharts.chart('container', {
                chart: {
                    type: 'areaspline'
                },
                title: {
                    text: 'Live Data'
                },
                accessibility: {
                    announceNewData: {
                        enabled: true,
                        minAnnounceInterval: 15000,
                        announcementFormatter: function (
                            allSeries,
                            newSeries,
                            newPoint) {
                            if (newPoint) {
                                return 'New point added. Value: ' + newPoint.y;
                            }
                            return false;
                        }
                    }
                },
                plotOptions: {
                    areaspline: {
                        color: '#32CD32',
                        fillColor: {
                            linearGradient: { x1: 0, x2: 0, y1: 0, y2: 1 },
                            stops: [
                                [0, '#32CD32'],
                                [1, '#32CD3200']
                            ]
                        },
                        threshold: null,
                        marker: {
                            lineWidth: 1,
                            lineColor: null,
                            fillColor: 'white'
                        }
                    }
                },
                data: {
                    csvURL: urlInput.value,
                    enablePolling: pollingCheckbox.checked === true,
                    dataRefreshRate: parseInt(pollingInput.value, 10)
                }
            });

            if (pollingInput.value < 1 || !pollingInput.value) {
                pollingInput.value = 1;
            }
        }

        urlInput.value = defaultData;
// We recreate instead of using chart update to make sure the loaded CSV
// and such is completely gone.
        pollingCheckbox.onchange = urlInput.onchange =
            pollingInput.onchange = createChart;

// Create the chart
        createChart();


    });
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <h2>HTML3 Page</h2>
    <figure class="highcharts-figure">
        <div id="container"></div>
        <p class="highcharts-description">
            Datasets formatted in CSV or JSON can be fetched remotely using the
            <code>data</code> module. This chart shows how a chart can also be
            configured to poll against the remote source.
        </p>
    </figure>

    <div class="ld-form">
        <div class="ld-row">
            <label class="ld-label">
                Enable Polling
            </label>
            <input type="checkbox" checked="checked" id="enablePolling"/>
        </div>
        <div class="ld-row">
            <label class="ld-label">
                Polling Time (Seconds)
            </label>
            <input class="ld-time-input" type="number" value="2" id="pollingTime"/>
        </div>
        <div class="ld-row">
            <label class="ld-label">
                CSV URL
            </label>
            <input class="ld-url-input" type="text" id="fetchURL"/>
        </div>
    </div>
</div>
