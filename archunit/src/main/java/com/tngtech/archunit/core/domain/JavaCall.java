/*
 * Copyright 2014-2025 TNG Technology Consulting GmbH
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
package com.tngtech.archunit.core.domain;

import com.tngtech.archunit.PublicAPI;
import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.AccessTarget.CodeUnitCallTarget;
import com.tngtech.archunit.core.domain.JavaAccess.Predicates.TargetPredicate;
import com.tngtech.archunit.core.importer.DomainBuilders.JavaAccessBuilder;

import static com.tngtech.archunit.PublicAPI.Usage.ACCESS;

@PublicAPI(usage = ACCESS)
public abstract class JavaCall<T extends CodeUnitCallTarget> extends JavaCodeUnitAccess<T> {
    JavaCall(JavaAccessBuilder<T, ?> builder) {
        super(builder);
    }

    /**
     * Predefined {@link DescribedPredicate predicates} targeting {@link JavaCall}.
     * Further predicates to be used with {@link JavaCall} can be found at {@link JavaCodeUnitAccess.Predicates}.
     */
    @PublicAPI(usage = ACCESS)
    public static final class Predicates {
        private Predicates() {
        }

        @PublicAPI(usage = ACCESS)
        public static DescribedPredicate<JavaCall<?>> target(DescribedPredicate<? super CodeUnitCallTarget> predicate) {
            return new TargetPredicate<>(predicate);
        }
    }
}
