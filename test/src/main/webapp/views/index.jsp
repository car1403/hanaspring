<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>프론트엔드 종합실습</title>

    <!-- Main CSS : Header, Main, Footer -->
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>" />

    <!-- Bootstrap CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
      integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
      crossorigin="anonymous"
    />
    <!-- Bootstarp JS -->
    <script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
      crossorigin="anonymous"
    ></script>

    <script>
      $(function(){

      });
    </script>
  </head>
  <body>
    <!-- 헤더 -->
    <!-- 탑메뉴 -->
    <div class="toTopScroll">
      <img src="./img/icon-top.png" onClick="javascript:window.scrollTo(0,0)">
    </div>
    <div class="top d-none d-md-block">
      <div class="topMenu d-none d-md-block container">
        <span class="home"><a href="index.html">HOME</a></span>
        <span><a href="./member/login.html">LOGIN</a></span>
        <span><a href="./member/join.html">JOIN</a></span>
        <span><a href="./company/company03.html">CONTACT US</a></span>
      </div>
    </div>
    <!-- 네비바 -->
    <nav class="navbar navbar-expand-md navbar-light bg-white sticky-top">
      <div class="container">
        <a class="navbar-brand" href="./index.html"><img src="./img/logo.png" alt="로고"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#collapsibleNavbar">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
          <!-- ml-auto : margin-left  -->
          <ul class="navbar-nav ml-auto">
            <!-- d-block : display: block  display: none -->
            <li class="nav-item d-sm-block d-md-none ljoin">
              <a href="./member/login.html"> <img src="./img/icon-member.png">&nbsp;&nbsp;Login</a>&nbsp;
              <a href="./member/join.html"> <img src="./img/icon-join.png">&nbsp;&nbsp;Join</a>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link" href="#">회사소개</a>
              <div class="dropdown-content">
                <a href="./company/company01.html">회사개요</a>
                <a href="#">CEO인사말</a>
                <a href="./company/company03.html">오시는길</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link" href="#">사업분야</a>
              <div class="dropdown-content">
                <a href="./business/business01.html">사업분야01</a>
                <a href="#">사업분야02</a>
                <a href="#">사업분야03</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link" href="#">제품안내</a>
              <div class="dropdown-content">
                <a href="./product/product01.html">제품안내01</a>
                <a href="#">제품안내02</a>
                <a href="#">제품안내03</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link" href="#">커뮤니티</a>
              <div class="dropdown-content">
                <a href="./community/community01.html">공지사항</a>
                <a href="#">홍보자료</a>
                <a href="#">채용안내</a>
              </div>
            </li>
            <li class="nav-item dropdown">
              <a class="nav-link" href="#">고객지원</a>
              <div class="dropdown-content">
                <a href="./customer/customer01.html">1:1문의</a>
                <a href="./customer/customer02.html">묻고답하기</a>
                <a href="./customer/customer03.html">FAQ</a>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- 메인 -->
    <!-- 캐러셀 -->
    <div id="demo" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#demo" data-slide-to="0" class="active"></li>
        <li data-target="#demo" data-slide-to="1"></li>
        <li data-target="#demo" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner">
        <div class="carousel-item active section1">
          <img src="./img/visual01.jpg" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block caption-text">
            <div>
              <h3>Creative web Design</h3>
            </div>
            <div>
              <p>정직과 신뢰, 디자인을 최우선으로 생각하며 고객과 함께 하겠습니다.</p>
            </div>
            <div>
              <button type="button" class="carouselBtn">
                <a href="#">Learn More</a></button>
            </div>
          </div>
        </div>
        <div class="carousel-item section1">
          <img src="./img/visual02.jpg" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block caption-text">
            <div>
              <h3>Versatile web Design</h3>
            </div>
            <div>
              <p>다양한 기업환경에 적용이 가능한 디자인으로 보다 큰 만족과 감동을 드리도록
                최선을 다합니다.</p>
            </div>
            <div>
              <button type="button" class="carouselBtn"><a href="#">Learn More</a></button>
            </div>
          </div>
        </div>
        <div class="carousel-item section1">
          <img src="./img/visual03.jpg" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block caption-text">
            <div>
              <h3>Responsive web Design</h3>
            </div>
            <div>
              <p>PC 및 모바일에서 접속하는 디바이스 환경에 최적으로 대응하는
                반응형디자인으로 고객만족을 최우선으로 합니다</p>
            </div>
            <div>
              <button type="button" class="carouselBtn"><a href="#">Learn More</a></button>
            </div>
          </div>
        </div>
      </div>
      <button class="carousel-control-prev" type="button" data-target="#demo"
              data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-target="#demo" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </button>
    </div>

    <!-- 섹션2 -->
    <div class="groupSection">
      <div>
        <h2>THE SPECIAL DESIGN GROUP</h2>
      </div>
      <div>
        <p>우리회사는 다양한 환경에 적응하며 경쟁하기 위해 디자인 역량과 기술력에 집중하고
          고객과의 친밀한 소통과 협력을 통해 최고의 품질을 제공하고 있습니다.</p>
      </div>
      <div>
        <button type="button" class="btn2">Learn More</button>
      </div>
    </div>

    <!-- 섹션3 -->
    <div class="proMain">
      <div class="container">
        <div class="row">
          <div class="proSection1 col-12">
            <h3>PRODUCT</h3>
            <span>우리회사는 정직과 신뢰, 디자인으로 고객과 함께 합니다.</span>
          </div>
        </div>
        <div class="row">
          <div class="proSection2">
            <div class="contents1 con1 ">
              <a href="#">
                <img src="./img/m-op01.jpg">
                <div class="overlay">
                  <div class="con2">
                    <p>DFSA 101</p>
                    <button>VIEW</button>
                  </div>
                </div>
              </a>
            </div>
            <div class="proSection3 ">
              <div class="contents2 con1">
                <a href="#">
                  <img src="./img/m-op02.jpg">
                  <div class="overlay">
                    <div class="con2">
                      <p>DFSA 102</p>
                      <button>VIEW</button>
                    </div>
                  </div>
                </a>
              </div>
              <div class="contents3 con1">
                <a href="#">
                  <img src="./img/m-op03.jpg">
                  <div class="overlay">
                    <div class="con2">
                      <p>DFSA 103</p>
                      <button>VIEW</button>
                    </div>
                  </div>
                </a>
              </div>
              <div class="contents4 con1">
                <a href="#">
                  <img src="./img/m-op04.jpg">
                  <div class="overlay">
                    <div class="con2">
                      <p>DFSA 104</p>
                      <button>VIEW</button>
                    </div>
                  </div>
                </a>
              </div>
              <div class="contents5 con1">
                <a href="#">
                  <img src="./img/m-op05.jpg">
                  <div class="overlay">
                    <div class="con2">
                      <p>DFSA 105</p>
                      <button>VIEW</button>
                    </div>
                  </div>
                </a>
              </div>
            </div>
          </div>
        </div>

      </div>
    </div>

    <!-- 섹션4 -->
    <div class="businessMain">
      <div class="businessSection1">
        <h2>BUSINESS</h2>
        <p>우리회사는 정직과 신뢰, 디자인으로 고객과 함께 합니다.</p>
      </div>
      <div class="businessSection2">
        <div class="businessCard">
          <a href="#">
            <img class="businessImg" src="./img/m-mb01.jpg">
            <div>
              <h4>사업분야01</h4>
              <p>고객의 필요와 사업환경에 따라 맞춤형 디자인으로 보다 큰 감동을 드립니다.</p>
            </div>
          </a>
        </div>
        <div class="businessCard">
          <a href="#">
            <img class="businessImg" src="./img/m-mb02.jpg">
            <div>
              <h4>사업분야02</h4>
              <p>고객의 필요와 사업환경에 따라 맞춤형 디자인으로 보다 큰 감동을 드립니다.</p>
            </div>
          </a>
        </div>
        <div class="businessCard">
          <a href="#">
            <img class="businessImg" src="./img/m-mb03.jpg">
            <div>
              <h4>사업분야03</h4>
              <p>고객의 필요와 사업환경에 따라 맞춤형 디자인으로 보다 큰 감동을 드립니다.</p>
            </div>
          </a>
        </div>
        <div class="businessCard">
          <a href="#">
            <img class="businessImg" src="./img/m-mb04.jpg">
            <div>
              <h4>사업분야04</h4>
              <p>고객의 필요와 사업환경에 따라 맞춤형 디자인으로 보다 큰 감동을 드립니다.</p>
            </div>
          </a>
        </div>
      </div>
    </div>

    <!-- 섹션5 -->
    <div class="mainBanner">
      <div class="mainBannerImg">
        <img src="./img/visual04.jpg" style="width: 100%; height: 100%;">
      </div>
      <div class="mainBannerText">
        <h2>정직과 신뢰, 디자인</h2>
        <p>우리회사는 오랫동안 쌓은 전문지식과 노하우를 바탕으로 고객과 함께하겠습니다.</p>
        <button type="button" class="btn1">Learn More</button>
      </div>
    </div>

    <!-- 섹션6 -->
    <div class="csMain">
      <div class="csSection1">
        <h3>CS CENTER</h3>
        <span>우리회사는 정직과 신뢰, 디자인으로 고객과 함께 합니다.</span><br><br>
      </div>
      <div class="csSection2">
        <div>
          <h5>공지사항<a href="#">더보기</a></h5>
        </div>
        <div>
          <ul>
            <li><a href="">새로운 공지사항을 알려드립니다.</a><label>2019-06-19</label></li>
            <li><a href="">새로운 공지사항을 알려드립니다.</a><label>2019-06-19</label></li>
            <li><a href="">새로운 공지사항을 알려드립니다.</a><label>2019-06-19</label></li>
          </ul>
        </div>
      </div>
      <div class="csSection3">
        <div class="csCard1">
          <a href="#">
            <div>
              <img src="./img/m-os01.png">
            </div>
            <div>
              <span>묻고답하기</span>
            </div>
            <div>
              <span>문의사항을 남기시면 친절히 답변드립니다.</span>
            </div>
          </a>
        </div>
        <div class="csCard2">
          <a href="#">
            <div>
              <img src="./img/m-os02.png">
            </div>
            <div>
              <span>채용안내</span>
            </div>
            <div>
              <span>당사와 함께 할 수 있는 인재를 모집합니다.</span>
            </div>
          </a>
        </div>
        <div class="csCard3">
          <a href="#">
            <div>
              <img src="./img/m-os03.png">
            </div>
            <div>
              <span>오시는길</span>
            </div>
            <div>
              <span>당사의 약고 및 연락처를 보실 수 있습니다.</span>
            </div>
          </a>
        </div>
      </div>
    </div>

    <!-- 푸터 -->
    <!-- footer -->
    <div class="footer">
      <div class="container text-center">
        <div>
          <a href="#">회사소개&nbsp;&nbsp;<span>|</span></a>
          <a href="#">개인정보보호정책&nbsp;&nbsp;<span>|</span></a>
          <a href="#">이메일무단수집거부&nbsp;&nbsp;<span>|</span></a>
          <a href="#">묻고답하기&nbsp;&nbsp;<span>|</span></a>
          <a href="#">오시는길&nbsp;&nbsp;<span>|</span></a>
        </div>
        <div>
      <span>회사 : 코딩강사 &nbsp; 주소 : 서울특별시 중구 명동 세종대로 110  &nbsp; 대표 : 홍길동 <br>
        고객지원 : 010-2222-3333, FAX : 070-888-5555, EMAIL : support@gmail.com, 사업자등록번호 : 100-02-00033, 통신판매업 : 제1111-경기-00000호<br>COPYRIGHT(C) 2021 CODINGGANSA. ALL RIGHT RESERVED.</span>
        </div>
        <div>
          <img src="./img/mf-icon01.png" alt="">
          <img src="./img/mf-icon02.png" alt="">
          <img src="./img/mf-icon03.png" alt="">
          <img src="./img/mf-icon04.png" alt="">
        </div>
      </div>
    </div>

    <script>
      $(document).ready(function () {
        setTimeout(function () {
          $(".carousel").carousel({
            interval: 2000, //기본 5초
            keyboard: true, //키보드이벤트 설정
            pause: "hover", //마우스를 가져대면 자동 순환이 멈춘다.
            wrap: true, //순환설정
            touch: true, //왼쪽 오른쪽 드래그 설정
          });
        }, 1000);
      });
    </script>
  </body>
</html>
