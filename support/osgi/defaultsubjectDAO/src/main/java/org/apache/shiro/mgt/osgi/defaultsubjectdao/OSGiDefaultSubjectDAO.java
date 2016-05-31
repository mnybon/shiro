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

package org.apache.shiro.mgt.osgi.defaultsubjectdao;

import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.apache.shiro.mgt.SubjectDAO;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 *
 * @author mnn
 */
@Component(name = "OSGiDefaultSubjectDAO", service = SubjectDAO.class)
public class OSGiDefaultSubjectDAO extends DefaultSubjectDAO{

    public OSGiDefaultSubjectDAO() {
	super();
	setSessionStorageEvaluator(null);
    }
    
     @Reference(updated = "updatedSessionStorageEvaluator", unbind = "unbindSessionStorageEvaluator", policy = ReferencePolicy.DYNAMIC, cardinality = ReferenceCardinality.MANDATORY)
    public void bindSessionStorageEvaluator(SessionStorageEvaluator eb){
	setSessionStorageEvaluator(eb);
    }
    
    public void updatedSessionStorageEvaluator(SessionStorageEvaluator eb){
	setSessionStorageEvaluator(eb);
    }
	
    public void unbindSessionStorageEvaluator(SessionStorageEvaluator eb){
	setSessionStorageEvaluator(null);
    }
    
    
}
