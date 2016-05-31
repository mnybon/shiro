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

package org.apache.shiro.mgt.osgi.defaultsessionstorageevaluator;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.SessionStorageEvaluator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.metatype.annotations.Designate;

/**
 *
 * @author mnn
 */
@Component(name = "OSGiDefaultSessionStorageEvaluator", configurationPid = "org.apache.shiro.mgt.osgi.defaultsessionstorageevaluator", configurationPolicy = ConfigurationPolicy.OPTIONAL, service = SessionStorageEvaluator.class)
@Designate(ocd = DefaultSessionStorageExaluatorOCD.class)
public class OSGiDefaultSessionStorageExaluator extends DefaultSessionStorageEvaluator{

    public OSGiDefaultSessionStorageExaluator() {
	super();
    }
    
    
    
}
