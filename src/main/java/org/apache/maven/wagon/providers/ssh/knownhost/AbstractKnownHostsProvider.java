package org.apache.maven.wagon.providers.ssh.knownhost;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
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

import com.jcraft.jsch.JSch;

import java.util.Properties;
import java.io.IOException;

/**
 * Common base for known hosts providers.
 *
 * @author <a href="mailto:brett@apache.org">Brett Porter</a>
 * @version $Id$
 */
public abstract class AbstractKnownHostsProvider
    implements KnownHostsProvider
{
    private String hostKeyChecking;

    public void addConfiguration( Properties config )
    {
        config.setProperty( HOST_KEY_CHECKING, hostKeyChecking );
    }

    public void setHostKeyChecking( String hostKeyChecking )
    {
        this.hostKeyChecking = hostKeyChecking;
    }

    public void storeKnownHosts( JSch sch )
    {
    }
}