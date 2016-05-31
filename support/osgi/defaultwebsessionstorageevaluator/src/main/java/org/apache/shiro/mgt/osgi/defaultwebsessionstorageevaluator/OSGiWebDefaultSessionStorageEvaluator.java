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

package org.apache.shiro.mgt.osgi.defaultwebsessionstorageevaluator;

import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.web.mgt.DefaultWebSessionStorageEvaluator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.metatype.annotations.Designate;

/**
 *
 * @author mnn
 */
@Component(name = "DefaultWebSessionStorageEvaluator", configurationPid = "org.apache.shiro.mgt.osgi.defaultwebsessionstorageevaluator", configurationPolicy = ConfigurationPolicy.OPTIONAL, service = SessionStorageEvaluator.class)
@Designate(ocd = DefaultWebSessionStorageEvaluatorOCD.class)
public class OSGiWebDefaultSessionStorageEvaluator extends DefaultWebSessionStorageEvaluator{

    public OSGiWebDefaultSessionStorageEvaluator() {
	super();
    }
    
    @Reference(updated = "updatedSessionManager", unbind = "unbindSessionManager", policy = ReferencePolicy.DYNAMIC, cardinality = ReferenceCardinality.MANDATORY)
    public void bindSessionManager(SessionManager sm){
	setSessionManager(sm);
    }
    
    public void updatedSessionManager(SessionManager sm){
	setSessionManager(sm);
    }
	
    public void unbindSessionManager(SessionManager sm){
	setSessionManager(null);
    }
    
    
    
}
