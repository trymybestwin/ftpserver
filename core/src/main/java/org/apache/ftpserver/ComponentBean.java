/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */  

package org.apache.ftpserver;

import org.apache.ftpserver.ftplet.Component;
import org.apache.ftpserver.ftplet.Configuration;

public class ComponentBean extends Bean {

    private Configuration config;
    private Component component;
    private Class<Component> clazz;
    
    public ComponentBean(Configuration config, Class<Component> clazz) {
        this.clazz = clazz;
        this.config = config;
    }
    
    public Object initBean() throws Exception {
        component = clazz.newInstance();
        
        component.configure(config);
        return component;
    }
    
    public Object getBean() {
        return component;
    }

    public void destroyBean() {
        component.dispose();
        component = null;
    }
    
}
