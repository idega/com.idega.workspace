<?xml version="1.0"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:t="http://myfaces.apache.org/tomahawk"
    xmlns:wf="http://xmlns.idega.com/com.idega.webface"
	xmlns:ws="http://xmlns.idega.com/com.idega.workspace" version="1.2">
	<jsp:directive.page contentType="text/html" />
	<f:view>
		<ws:page id="workspacepage1">
			<h:form id="workspaceform1">
				<wf:wfblock id="welcomeBlock" title="#{localizedStrings['com.idega.workspace']['welcome_to_eplatform']}">
					<t:htmlTag value="h1"><h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_to_eplatform']}"/></t:htmlTag>
					<t:div styleClass="welcomeBox">
						<t:htmlTag value="ul" styleClass="welcomeList">
							<t:htmlTag value="li" styleClass="selected">
								<h:outputLink value="#">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.welcome']}" />
								</h:outputLink>
							</t:htmlTag>
							<t:htmlTag value="li">
								<h:outputLink value="#">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.getting_started']}" />
								</h:outputLink>
							</t:htmlTag>
							<t:htmlTag value="li">
								<h:outputLink value="#">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.add_users_and_groups']}" />
								</h:outputLink>
							</t:htmlTag>
							<t:htmlTag value="li">
								<h:outputLink value="#">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.adding_pages']}" />
								</h:outputLink>
							</t:htmlTag>
							<t:htmlTag value="li">
								<h:outputLink value="#">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.creating_articles']}" />
								</h:outputLink>
							</t:htmlTag>
							<t:htmlTag value="li">
								<h:outputLink value="#">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.your_file_manager']}" />
								</h:outputLink>
							</t:htmlTag>
							<t:htmlTag value="li">
								<h:outputLink value="#">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.properties']}" />
								</h:outputLink>
							</t:htmlTag>
						</t:htmlTag>
						
						<t:div styleClass="welcomeText">
							<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_texts.welcome']}" />
						</t:div>
					</t:div>
				</wf:wfblock>
			</h:form>
		</ws:page>
	</f:view>
</jsp:root>