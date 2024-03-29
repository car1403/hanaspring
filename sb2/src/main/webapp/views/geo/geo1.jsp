<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
        lat:37.5448181,
        lng:127.0565111,
        init:function() {
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                    center: new kakao.maps.LatLng(this.lat, this.lng), // 지도의 중심좌표
                    level: 3 // 지도의 확대 레벨
                };
            this.map = new kakao.maps.Map(mapContainer, mapOption);
            this.display();
        },
        display:function(){
            var mapTypeControl = new kakao.maps.MapTypeControl();
            this.map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
            var zoomControl = new kakao.maps.ZoomControl();
            this.map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
            var markerPosition  = new kakao.maps.LatLng(this.lat,this.lng);
            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(this.map);

            var iwContent =
                '<div style="padding:5px;">Hello World!<br><img style="width:50px;" src="<c:url value="/img/bab1.jpg"/>"></div>'; // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다

            var infowindow = new kakao.maps.InfoWindow({
                content : iwContent
            });

            kakao.maps.event.addListener(marker, 'mouseover', function() {
                infowindow.open(geo1.map, marker);
            });

            kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            });
            kakao.maps.event.addListener(marker, 'click', function() {
                location.href='http://www.nate.com';
            });
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
