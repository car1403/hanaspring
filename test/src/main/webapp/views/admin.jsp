
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!-- 메인 -->
<div id="adminSection">
  <div class="adminDiv">
    <h3>공지사항 관리</h3>
  </div>
  <div class="adminDiv">
    검색 옵션
    <select name="search_select" id="search_select">
      <option value="all" selected>전체</option>
      <option value="title">제목</option>
      <option value="content">내용</option>
      <option value="id">작성자아이디</option>
    </select>
    <input
            type="text"
            name="search_keyword"
            id="search_keyword"
            value=""
    />
    <input type="image" src="../img/community/search.gif" />
  </div>
  <div class="adminDiv">
    정렬
    <select class="size" name="order_select" id="order_select">
      <option value="id_asc" selected>아이디 오름차순</option>
      <option value="id_desc">아이디 내림차순</option>
      <option value="reg_date_asc">등록일 오름차순</option>
      <option value="reg_date_desc">등록일 내림차순</option>
    </select>
  </div>
  <div class="adminDiv2" id="tableTitle">
    <div>목록 10건</div>
    <div>
      한페이지 행수
      <select class="size" name="page_select" id="page_select">
        <option value="page10" selected>10개씩 보기</option>
        <option value="page10">20개씩 보기</option>
        <option value="page10">50개씩 보기</option>
      </select>
    </div>
  </div>
  <div class="">
    <table class="adminTable">
      <thead>
      <tr>
        <th>글번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>작성일</th>
      </tr>
      </thead>
      <tbody>
      <tr
              onclick="location.href='/admin_notice_view?notice_idx=5';"
              style="cursor: pointer"
      >
        <td>1</td>
        <td>타이틀1</td>
        <td>admin</td>
        <td>2024-04-09</td>
      </tr>
      <tr
              onclick="location.href='/admin_notice_view?notice_idx=4';"
              style="cursor: pointer"
      >
        <td>2</td>
        <td>타이틀1</td>
        <td>admin</td>
        <td>2024-04-08</td>
      </tr>
      <tr
              onclick="location.href='/admin_notice_view?notice_idx=3';"
              style="cursor: pointer"
      >
        <td>3</td>
        <td>타이틀1</td>
        <td>admin</td>
        <td>2024-04-07</td>
      </tr>
      <tr
              onclick="location.href='/admin_notice_view?notice_idx=2';"
              style="cursor: pointer"
      >
        <td>4</td>
        <td>타이틀1</td>
        <td>admin</td>
        <td>2024-04-07</td>
      </tr>
      <tr
              onclick="location.href='/admin_notice_view?notice_idx=1';"
              style="cursor: pointer"
      >
        <td>5</td>
        <td>타이틀1</td>
        <td>admin</td>
        <td>2024-04-05</td>
      </tr>
      </tbody>
    </table>
  </div>

  <div class="pageNav adminDiv2">
    <div></div>
    <div>
      <a href="/admin_notice?page=1">처음</a>
      <a href="/admin_notice?page=1">이전</a>
      <a href="/admin_notice?page=1">1</a>
      <a href="/admin_notice?page=2">2</a>
      <a href="/admin_notice?page=3">3</a>
      <a href="/admin_notice?page=2">다음</a>
      <a href="/admin_notice?page=3">마지막</a>
    </div>
    <div><a href="/admin_notice_write">공지글 쓰기</a></div>
  </div>
</div>
</div>
