<style>
    #geo2 > #map{
        width:500px;
        height: 400px;
        border:2px solid red;
    }
</style>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="geo2">
    <h2>GEO2 Page</h2>
    <button id="btn_s" type="button" class="btn btn-primary">Seoul</button>
    <button id="btn_b" type="button" class="btn btn-primary">Busan</button>
    <button id="btn_j" type="button" class="btn btn-primary">Jeju</button>

    <div id="map"></div>
</div>
