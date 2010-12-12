/*
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.seam.security.examples.id_provider;

import javax.enterprise.event.Observes;
import javax.servlet.ServletContext;

import org.jboss.seam.security.external.saml.api.SamlIdentityProviderConfigurationApi;
import org.jboss.seam.servlet.event.Initialized;

public class SamlIdpCustomizer
{
   public void servletInitialized(@Observes @Initialized final ServletContext context, SamlIdentityProviderConfigurationApi idp)
   {
      idp.setEntityId("http://www.saml-idp.com");
      idp.setHostName("www.saml-idp.com");
      idp.setProtocol("http");
      idp.setPort(8080);
      idp.setSigningKey("classpath:/test_keystore.jks", "store456", "servercert", "pass456");
      idp.setWantSingleLogoutMessagesSigned(false);
   }
}
