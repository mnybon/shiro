/*
 * Copyright 2016 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shiro.mgt.osgi.subjectfactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SubjectFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.util.OSGiAdapter;
import org.apache.shiro.web.subject.WebSubjectContext;
import org.apache.shiro.web.subject.support.WebDelegatingSubject;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 *
 * @author mnn
 */
@Component(name = "OSGiDefaultWebSubjectFactory", service = SubjectFactory.class, immediate = true)
public class OSGiWebSubjectFactory extends OSGiSubjectFactory implements SubjectFactory{

    public OSGiWebSubjectFactory(BundleContext context) {
	this.bundleContext = context;
    }

    public OSGiWebSubjectFactory() {
    }
    
    @Activate
    @Override
    public void activate(BundleContext bundleContext){
	this.bundleContext = bundleContext;
    }

    @Override
    public Subject createSubject(SubjectContext context) {
        if (!(context instanceof WebSubjectContext)) {
            return super.createSubject(context);
        }
        WebSubjectContext wsc = (WebSubjectContext) context;
        SecurityManager securityManager = wsc.resolveSecurityManager();
        Session session = wsc.resolveSession();
        boolean sessionEnabled = wsc.isSessionCreationEnabled();
        PrincipalCollection principals = wsc.resolvePrincipals();
        boolean authenticated = wsc.resolveAuthenticated();
        String host = wsc.resolveHost();
        ServletRequest request = wsc.resolveServletRequest();
        ServletResponse response = wsc.resolveServletResponse();

	OSGiAdapter<SecurityManager> adapter = new OSGiAdapter<SecurityManager>(bundleContext, SecurityManager.class);
	return new WebDelegatingSubject(request, response, principals, authenticated, host, session, sessionEnabled, adapter, securityManager);
    }
    
    
    
}
