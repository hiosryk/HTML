<%@page import="com.kitri.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Product p = (Product)request.getAttribute("product");
   String no = p.getProd_no();
%>
<style>
@media screen and (max-width: 300px)
div.product_view_detail {
    
}
div.product_view_detail h4 {
    font-size: 24px;
    font-weight: bold;
    color: #222;
    border-bottom: 2px solid #333;
    padding-bottom: 18px;
    margin-bottom: 20px;
}
div.product_view_detail p.t1 {
    font-size: 16px;
    color: #444;
    margin-bottom: 20px;
    line-height: 1.6;
    min-height: 40px;
    vertical-align: baseline;
    background: transparent;
}
div.product_view{
    width: 100%;
}
div.product_view_pic {
    width: 50%;
    float: left;
    position: relative;
}
img {
    vertical-align: top;
    width: 80%;
    max-width: 100%;
}
div.product_view_detail {
    width: 40%;
    /* width: 610px; */
    float: left;
    position: relative;
}
div.product_info_content {
    width: 100%;
    transparent;
    background: url('http://image.istarbucks.co.kr/common/img/menu/detail_bg.jpg') center 0 repeat-y;
    margin: 20px 0;
}
div.product_info_content ul {
    margin: 0;
    padding: 0;
    width: 50%;
    /* width: 100%; */
    float: left;
    list-style: none;
}
div.product_info_content ul>li {
    width: 100%;
    margin: 0;
    padding: 0;
    border: 0;
    vertical-align: baseline;
    background: transparent;
}
div.product_info_content ul>li>button{
    width: 100%;
}
div.product_info_content dl dt {
    float: left;
    width: 85%;
}

div.product_info_content dl dd {
    float: right;
    width: 15%;
    text-align: right;
}
div.product_info_content dl:after {
    content: "";
    display: block;
    clear: both;
}
</style>
<div class="product_view">
<div class="product_view_pic">
  <img src="images/<%=no%>.jpg">
</div>
<div class="product_view_detail">
<h4><%=p.getProd_name() %></h4>
<p class="t1"><%-- <%=p.getProd_detail()==null?"":p.getProd_detail() %> --%>
신선하게 브루드(Brewed)되어 원두의 다양함이 살아있는 커피
</p>
<div class="product_info_content">
<ul>
<li class="no">
 <dl><dt>상품번호</dt>
     <dd><%=no %></dd>
</dl>
</li>
<li class="name">
 <dl><dt>가격</dt>
     <dd><%=p.getProd_price() %></dd>
</dl>
</li>
<li class="quantity">
 <dl><dt>수량</dt>
     <dd><input type="number" name="quantity"></dd>
</dl>
</li>
<li class="submit">
<dl><dt><button>장바구니넣기</button></dt>
</dl>
</li>




</ul>
</div>
</div>
</div>
<%-- <script src="js/jquery.elevatezoom.js"></script>
<div class="zoomContainer" 
     style="transform: translateZ(0px); 
            position: absolute; 
            left: 20.4375px; 
            top: 219px; 
            height: 419px; 
            width: 401px;">
   <div class="zoomLens" 
        style="background-position: 0px 0px; 
               float: right; 
               overflow: hidden; 
               z-index: 999; 
               transform: translateZ(0px); 
               opacity: 0.4; 
               zoom: 1; 
               width: 271.789px; 
               height: 208.609px; 
               background-color: white; 
               cursor: default; 
               border: 1px solid rgb(0, 0, 0); 
               background-repeat: no-repeat; 
               position: absolute; 
               left: 0px; 
               top: 208px; 
               display: none;">&nbsp;</div>
     <div class="zoomWindowContainer" 
          style="width: 610px;">
          <div style="overflow: hidden; 
                      background-position: 0px -521px; 
                      text-align: center; 
                      background-color: rgb(255, 255, 255); 
                      width: 610px; 
                      height: 468px; 
                      float: left; 
                      background-size: 900px 940px; 
                      z-index: 100; 
                      border: 4px solid rgb(136, 136, 136); 
                      background-repeat: no-repeat; 
                      position: absolute; 
                      background-image: 
                      /*url('//image.istarbucks.co.kr/upload/store/skuimg/2015/07/[2]_20150724164439044.jpg'*/
                      url('images/001.jpg'); 
                      top: -2px; 
                      left: 439px; 
                      display: none;" 
                      class="zoomWindow">&nbsp;</div>
    </div>
</div> --%>