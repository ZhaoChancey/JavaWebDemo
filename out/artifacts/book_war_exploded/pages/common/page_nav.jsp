<%--
  Created by IntelliJ IDEA.
  User: Chancey
  Date: 2020/3/19
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页条的开始--%>
<div id="page_nav">
    <%--			大于首页才显示--%>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}">上一页</a>
    </c:if>

    <%-- 页码输出的开始 --%>
    <c:choose>
        <%--情况1：如果总页码小于等于5 的情况，页码的范围是：1-总页码--%>
        <c:when test="${requestScope.page.pageTotal <= 5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pageTotal}"/>
        </c:when>

        <%--情况2：总页码大于5 的情况。--%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%--小情况1：当前页码为前面3 个：1，2，3 的情况，页码范围是：1-5.--%>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <%--小情况2：当前页码为最后3 个，8，9，10，页码范围是：总页码减4 - 总页码--%>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal - 3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal - 4}"/>
                    <c:set var="end" value="${requestScope.page.pageTotal}"/>
                </c:when>

                <c:otherwise>
                    <%--小情况3：4，5，6，7，页码范围是：当前页码减2 - 当前页码加2--%>
                    <c:set var="begin" value="${requestScope.page.pageNo - 2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo + 2}"/>

                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <%--foreach只执行一次 所以可以单独抽取出来--%>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${requestScope.page.pageNo == i}">
            【${i}】
        </c:if>

        <c:if test="${requestScope.page.pageNo != i}">
            <a href="${requestScope.page.url}&pageNo=${i}"> ${i}</a>
        </c:if>

    </c:forEach>

    <%-- 页码输出的结束 --%>

    <%--			如果已经是最后一页，则不显示下一页，末页--%>
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录

    <!-- 分三种情况显示跳转框中的页码值 -->
    <c:if test="${1 <= param.pageNo && param.pageNo <= requestScope.page.pageTotal}">
        到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    </c:if>

    <c:if test="${param.pageNo < 1}">
        到第<input value="1" name="pn" id="pn_input"/>页
    </c:if>

    <c:if test="${param.pageNo > requestScope.page.pageTotal}">
        到第<input value="${requestScope.page.pageTotal}" name="pn" id="pn_input"/>页
    </c:if>
    <input id="pageSearchBtn" type="button" value="确定">

    <script type="text/javascript">
        $(function () {
            // 跳到指定的页码
            $("#pageSearchBtn").click(function () {

                var pageNo = $("#pn_input").val();
                <%--var pageTotal = ${requestScope.page.pageTotal};--%>
                // if (1 <= pageNo && pageNo <= pageTotal){
                //js语言中提供了一个location地址栏对象
                //它有一个属性叫href,可以获取浏览器地址栏中的地址
                //href属性可读、可写
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
                // }

            });
        });
    </script>
</div>
<%--分页条的结束--%>