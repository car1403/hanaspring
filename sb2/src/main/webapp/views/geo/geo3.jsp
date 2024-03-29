<style>
    #geo3 > #map{
        width:500px;
        height: 400px;
        border:2px solid red;
    }
</style>
<script>



    let geo3 = {
        map:null,
        init:function(){
            var mapContainer = document.getElementById('map'), // 지도를 표시할 div
                mapOption = {
                    center: new kakao.maps.LatLng(37.5447611,127.0564625), // 지도의 중심좌표
                    level: 3 // 지도의 확대 레벨
                };
            geo3.map = new kakao.maps.Map(mapContainer, mapOption);
            geo3.display();
        },
        getshop:function(){
            //$.ajax();
            // lat, lng, title, img, target
            var datas = [];
        },
        display:function(){

        }
    };
    $(function(){
        geo3.init();
    });
</script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container" id="geo3">
    <h2>GEO3 Page</h2>
    <div id="map"></div>
</div>
