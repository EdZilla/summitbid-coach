

<%@ page import="com.summitbid.coach.nutrition.NutritionInfo" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'nutritionInfo.label', default: 'NutritionInfo')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${nutritionInfoInstance}">
            <div class="errors">
                <g:renderErrors bean="${nutritionInfoInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${nutritionInfoInstance?.id}" />
                <g:hiddenField name="version" value="${nutritionInfoInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="nutritionInfo.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: nutritionInfoInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${nutritionInfoInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="calories"><g:message code="nutritionInfo.calories.label" default="Calories" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: nutritionInfoInstance, field: 'calories', 'errors')}">
                                    <g:textField name="calories" value="${fieldValue(bean: nutritionInfoInstance, field: 'calories')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="gramsFat"><g:message code="nutritionInfo.gramsFat.label" default="Grams Fat" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: nutritionInfoInstance, field: 'gramsFat', 'errors')}">
                                    <g:textField name="gramsFat" value="${fieldValue(bean: nutritionInfoInstance, field: 'gramsFat')}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
