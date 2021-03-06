/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.catalog.maven;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.camel.catalog.CatalogHelper.loadText;

public class ConnectorArtifactHelper {

    private static final Logger LOG = LoggerFactory.getLogger(ComponentArtifactHelper.class);

    private ConnectorArtifactHelper() {
    }

    public static String[] loadConnectorJSonSchema(ClassLoader classLoader) {
        String[] answer = new String[2];

        String path = "camel-connector.json";
        try {
            InputStream is = classLoader.getResourceAsStream(path);
            if (is != null) {
                answer[0] = loadText(is);
            }
        } catch (Throwable e) {
            LOG.warn("Error loading " + path + " file", e);
        }

        path = "camel-connector-schema.json";
        try {
            InputStream is = classLoader.getResourceAsStream(path);
            if (is != null) {
                answer[1] = loadText(is);
            }
        } catch (Throwable e) {
            LOG.warn("Error loading " + path + " file", e);
        }

        return answer;
    }

}
