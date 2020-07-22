/*
 * Copyright (c) 2020 Dzikoysk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.utilities.annotations;

import java.util.Arrays;
import java.util.List;

final class AnnotationsScannerConstants {

    @SuppressWarnings("SpellCheckingInspection")
    static final String[] PANDA_PACKAGES = {
            "META-INF",
            "org.panda_lang.utilities",                                                         // Panda
            "java", "com.sun", "sun", "jdk", "javax", "oracle", "com.oracle", "netscape",       // Java

            "javassist", "org.fusesource", "org.apiguardian", "org.ow2",                        // Internal
            "org.apache", "com.google", "org.slf4j", "commons-lang.commons-lang",               // Popular

            "org.junit", "junit", "org.opentest4j",                                             // Tests
            "org.jetbrains", "org.intellij", "com.intellij", "lib.idea_rt",                     // IDE
    };

    static final List<String> primitiveNames = Arrays.asList("boolean", "char", "byte", "short", "int", "long", "float", "double", "void");

    static final List<String> primitiveDescriptors = Arrays.asList("Z", "C", "B", "S", "I", "J", "F", "D", "V");

    static final List<Class> primitiveTypes = Arrays.asList(boolean.class, char.class, byte.class, short.class, int.class, long.class, float.class, double.class, void.class);

}
