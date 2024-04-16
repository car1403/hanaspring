
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<link rel="stylesheet" href="<c:url value="/css/community/community.css"/>">

<script>
    let board = {
        init: function () {
        }
    };
    $(function () {
        board.init();
    });
</script>
<!-- 공지사항 -->
<div class="communitySection2 container text-center">
    <div>
        <div>공지사항</div>
        <div>The design and maintenance are excellent.</div>
    </div>
    <div class="Notice">
        <table>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성일</th>
            </tr>
            <tr onclick="window.location.href='community01_1.html?no=5'">
                <td>5</td>
                <td>새로운 공지사항을 알려드립니다.</td>
                <td>2019-06-19</td>
            </tr>
            <tr onclick="window.location.href='community01_1.html?no=4'">
                <td>4</td>
                <td>새로운 공지사항을 알려드립니다.</td>
                <td>2019-06-19</td>
            </tr>
            <tr onclick="window.location.href='community01_1.html?no=3'">
                <td>3</td>
                <td>새로운 공지사항을 알려드립니다.</td>
                <td>2019-06-19</td>
            </tr>
            <tr onclick="window.location.href='community01_1.html?no=2'">
                <td>2</td>
                <td>새로운 공지사항을 알려드립니다.</td>
                <td>2019-06-19</td>
            </tr>
            <tr onclick="window.location.href='community01_1.html?no=1'">
                <td>1</td>
                <td>새로운 공지사항을 알려드립니다.</td>
                <td>2019-06-19</td>
            </tr>
        </table>
    </div>
</div>


<!-- search bar -->
<div class="search container">
    <table>
        <tr>
            <td>
                <select name="내용" id="">
                    <option value="">제목</option>
                    <option value="">내용</option>
                    <option value="">작성자</option>
                </select>
            </td>
            <td>
                <input type="text">
            </td>
            <td>
                <input type="image" src="../img/community/search.gif">
            </td>
        </tr>
    </table>
</div>
