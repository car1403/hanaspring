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
        lat:0.0,
        lng:0.0,
        init:function() {
            if (navigator.geolocation) {

                // GeoLocation을 이용해서 접속 위치를 얻어옵니다
                navigator.geolocation.getCurrentPosition(function(position) {
                    geo1.lat = position.coords.latitude;
                    geo1.lng = position.coords.longitude; // 경도

                    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                        mapOption = {
                            center: new kakao.maps.LatLng(geo1.lat, geo1.lng), // 지도의 중심좌표
                            level: 3 // 지도의 확대 레벨
                        };
                    geo1.map = new kakao.maps.Map(mapContainer, mapOption);
                    geo1.display();
                });


            } else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
                alert('error');
            }




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
