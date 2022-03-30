<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<link rel="stylesheet" href="/shoppingmall/css/style.css?after"/>
<script src="/shoppingmall/js/jquery-1.11.0.min.js"></script>
<script src="/shoppingmall/12_login.js"></script>

<c:if test="${empty sessionScope.id}">
  <div id="lStatus">
     <ul>
        <li><label for="cid"></label>
            <input id="cid" name="cid" type="email" size="20" class="tag"
              maxlength="50" placeholder="example@kings.com">
            <label for="cpasswd"></label>
            <input id="cpasswd" name="cpasswd" type="password" class="tag"
              size="20" placeholder="6~16자 숫자/문자 입력" maxlength="16">
            <button id="uLogin" class="tag">Login</button>
            <button id="uRes" class="tag">Sign-up</button>
     </ul>
  </div>
</c:if>
<c:if test="${!empty sessionScope.id}">
  <div id="lStatus">
     <ul>
        <li>${sessionScope.id}님이 로그인 하셨습니다.
           <div id="info">
             <table>
               <tr>
               
               	<td><button id="uLogout" class="tag2">로그아웃</button></td>
                 
                 <td><form id="cartForm" method="post" action="/shoppingmall/cartList.do">
                   <input type="hidden" name="buyer" value="${sessionScope.id}">
                   <input type="submit" name="cart" class="tag2" value="장바구니"></form></td>
                   
                 </tr>
             </table>
        </div>     
            
     </ul>
  </div>
</c:if> 