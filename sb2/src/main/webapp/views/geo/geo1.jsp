<style>
    #geo1 > #map{
        width:500px;
        height: 400px;
        border:2px solid red;
    }
</style>
<script>
    let geo1 = {
        map:null,
        init:function(){
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
            mapOption = {
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };
            this.map = new kakao.maps.Map(mapContainer, mapOption);
        }
    };
    $(function(){
        geo1.init();
    });
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container" id="geo1">
    <h2>GEO1 Page</h2>
    <div id="map"></div>
</div>
