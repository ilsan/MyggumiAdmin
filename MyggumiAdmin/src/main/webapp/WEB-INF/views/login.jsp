<%--
  Created by IntelliJ IDEA.
  User: jihoonlee
  Date: 2017. 12. 26.
  Time: 오후 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="loginUrl" value="/login"/>

<form name="loginfrm" id="loginfrm" action="${loginUrl}" method="POST">

    <!-- spring security 4.0이상의 버전부터는 CSRF방지 기능이 작동하고 있기 때문에 PATCH, POST, PUT, DELETE 요청에 CSRF 토큰을 포함해야한다 -->
    <!-- 스프링 폼태그를 사용하는 폼 ex: <form ... 은 자동으로 토큰 파라미터가 추가되므로 위 코드가 필요없다-->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='loginId' id="loginId" value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='loginPassWord' id="loginPassWord"/></td>
        </tr>


        <c:if test="${not empty param.fail}">
            <tr>
                <td colspan="2">
                    <font color="red">
                        <p>Your login attempt was not successful, try again.</p>
                        <p>Reason: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</p>
                    </font>
                    <c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION"/>
                </td>
            </tr>
        </c:if>

        <tr>
            <td colspan='2'><input name="submit" type="submit"/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="reset" type="reset"/></td>
        </tr>
    </table>
</form>
<script type="javascript">

    $(document).ready(function () {

        $("#loginbtn").click(function () {
            if ($("#loginid").val() == "") {
                alert("로그인 아이디를 입력해주세요");
                $("#loginid").focus();
            } else if ($("#loginPassWord").val() == "") {
                alert("로그인 비밀번호를 입력해주세요");
                $("#loginPassWord").focus();
            } else {
                $("#loginfrm").attr("action", ${loginUrl});
                $("#loginfrm").submit();
            }
        });
    })
</script>