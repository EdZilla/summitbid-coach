
<%@ page import="com.summitbid.coach.nutrition.NutritionInfo" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'nutritionInfo.label', default: 'NutritionInfo')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'nutritionInfo.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'nutritionInfo.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="calories" title="${message(code: 'nutritionInfo.calories.label', default: 'Calories')}" />
                        
                            <g:sortableColumn property="gramsFat" title="${message(code: 'nutritionInfo.gramsFat.label', default: 'Grams Fat')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${nutritionInfoInstanceList}" status="i" var="nutritionInfoInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${nutritionInfoInstance.id}">${fieldValue(bean: nutritionInfoInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: nutritionInfoInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: nutritionInfoInstance, field: "calories")}</td>
                        
                            <td>${fieldValue(bean: nutritionInfoInstance, field: "gramsFat")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${nutritionInfoInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
