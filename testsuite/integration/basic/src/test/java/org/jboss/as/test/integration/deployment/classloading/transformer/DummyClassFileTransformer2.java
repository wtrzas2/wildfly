/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat Inc., and individual contributors as indicated
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

package org.jboss.as.test.integration.deployment.classloading.transformer;

import org.jboss.modules.ClassTransformer;
import java.nio.ByteBuffer;
import java.security.ProtectionDomain;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author Marius Bogoevici
 */
public class DummyClassFileTransformer2 implements ClassTransformer {

    public static boolean wasActive = false;

    public static Set<String> transformedClassNames = new ConcurrentSkipListSet<String> ();

    @Override
    public ByteBuffer transform(ClassLoader loader, String className, ProtectionDomain protectionDomain, ByteBuffer classfileBuffer) throws IllegalArgumentException {
        transformedClassNames.add(className);
        wasActive = true;
        return classfileBuffer;
    }
}
