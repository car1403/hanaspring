
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

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

