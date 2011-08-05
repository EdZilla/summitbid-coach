

<%@ page import="com.summitbid.coach.activity.Exercise" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'exercise.label', default: 'Exercise')}" />
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
            <g:hasErrors bean="${exerciseInstance}">
            <div class="errors">
                <g:renderErrors bean="${exerciseInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${exerciseInstance?.id}" />
                <g:hiddenField name="version" value="${exerciseInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="exercise.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: exerciseInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${exerciseInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="end"><g:message code="exercise.end.label" default="End" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: exerciseInstance, field: 'end', 'errors')}">
                                    <g:datePicker name="end" precision="day" value="${exerciseInstance?.end}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="properties"><g:message code="exercise.properties.label" default="Properties" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: exerciseInstance, field: 'properties', 'errors')}">
                                    <g:select name="properties" from="${com.summitbid.coach.Property.list()}" multiple="yes" optionKey="id" size="5" value="${exerciseInstance?.properties*.id}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="start"><g:message code="exercise.start.label" default="Start" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: exerciseInstance, field: 'start', 'errors')}">
                                    <g:datePicker name="start" precision="day" value="${exerciseInstance?.start}"  />
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
