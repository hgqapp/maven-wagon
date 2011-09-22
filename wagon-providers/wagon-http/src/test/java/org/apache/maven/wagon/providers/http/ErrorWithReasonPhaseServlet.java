package org.apache.maven.wagon.providers.http;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: jdumay
 * Date: 24/01/2008
 * Time: 17:25:27
 */
public class ErrorWithReasonPhaseServlet
    extends HttpServlet
{
    public static final String REASON = "it sucks!";

    private Logger logger = Logger.getLogger( ErrorWithReasonPhaseServlet.class );

    public void service( HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException
    {
        if ( request.getRequestURL().toString().contains( "401" ) )
        {
            response.setStatus( 401 );
        }
        else if ( request.getRequestURL().toString().contains( "403" ) )
        {
            response.setStatus( 403 );
        }
        else if ( request.getRequestURL().toString().contains( "407" ) )
        {
            response.setStatus( 407 );
        }
        else if ( request.getRequestURL().toString().contains( "500" ) )
        {
            response.setStatus( 500 );
        }
        response.addHeader( "Reason-Phrase", REASON );
    }
}