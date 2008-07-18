<?xml version="1.0"?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:t="http://myfaces.apache.org/tomahawk"
    xmlns:wf="http://xmlns.idega.com/com.idega.webface"
	xmlns:ws="http://xmlns.idega.com/com.idega.workspace" version="1.2">
	<jsp:directive.page contentType="text/html" />
	<f:view>
		<ws:page id="workspacepage1" javascripturls="
				/idegaweb/bundles/com.idega.block.web2.0.bundle/resources/javascript/jquery/1.2.3/jquery-compressed.js,
				/idegaweb/bundles/com.idega.block.web2.0.bundle/resources/javascript/jquery-ui/1.5b/ui.tabs.js,
				/idegaweb/bundles/com.idega.workspace.bundle/resources/javascript/workspace.js">
			<h:form id="workspaceform1">
				<wf:wfblock id="welcomeBlock" title="#{localizedStrings['com.idega.workspace']['welcome_to_eplatform']}">
					<t:htmlTag value="h1"><h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_to_eplatform']}"/></t:htmlTag>
					<t:div styleClass="welcomeBox">
						<t:htmlTag value="ul" styleClass="welcomeList">
							<t:htmlTag value="li" styleClass="selected">
								<h:outputLink value="#text1">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.welcome']}" />
								</h:outputLink>
							</t:htmlTag>
							<t:htmlTag value="li">
								<h:outputLink value="#text2">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.getting_started']}" />
								</h:outputLink>
							</t:htmlTag>
							<t:htmlTag value="li">
								<h:outputLink value="#text3">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.add_users_and_groups']}" />
								</h:outputLink>
							</t:htmlTag>
							<t:htmlTag value="li">
								<h:outputLink value="#text4">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.adding_pages']}" />
								</h:outputLink>
							</t:htmlTag>
							<t:htmlTag value="li">
								<h:outputLink value="#text5">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.creating_articles']}" />
								</h:outputLink>
							</t:htmlTag>
							<t:htmlTag value="li">
								<h:outputLink value="#text6">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.your_file_manager']}" />
								</h:outputLink>
							</t:htmlTag>
							<t:htmlTag value="li">
								<h:outputLink value="#text7">
									<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_list.properties']}" />
								</h:outputLink>
							</t:htmlTag>
						</t:htmlTag>
						
						<t:div styleClass="welcomeTexts">
							<t:div id="text1" forceId="true" styleClass="welcomeText">
								<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_texts.welcome']}" />
							</t:div>
							<t:div id="text2" forceId="true" styleClass="welcomeText">
								<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_texts.getting_started']}" />
							</t:div>
							<t:div id="text3" forceId="true" styleClass="welcomeText">
								<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_texts.add_users_and_groups']}" />
							</t:div>
							<t:div id="text4" forceId="true" styleClass="welcomeText">
								<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_texts.adding_pages']}" />
							</t:div>
							<t:div id="text5" forceId="true" styleClass="welcomeText">
								<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_texts.creating_articles']}" />
							</t:div>
							<t:div id="text6" forceId="true" styleClass="welcomeText">
								<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_texts.your_file_manager']}" />
							</t:div>
							<t:div id="text7" forceId="true" styleClass="welcomeText">
								<h:outputText value="#{localizedStrings['com.idega.workspace']['welcome_texts.properties']}" />
							</t:div>
						</t:div>
					</t:div>
				</wf:wfblock>
			</h:form>
		</ws:page>
	</f:view>
</jsp:root>